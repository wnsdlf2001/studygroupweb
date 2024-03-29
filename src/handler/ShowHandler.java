package handler;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import databean.ApplyDataBean;
import databean.AttendeeDataBean;
import databean.BoardDataBean;
import databean.CertificateDataBean;
import databean.CommentDataBean;
import databean.ExpDataBean;
import databean.LanguageDataBean;
import databean.LocationDataBean;
import databean.SchoolDataBean;
import databean.StudyDataBean;
import databean.StudyTimeDataBean;
import databean.UserDataBean;
import dbbean.BoardDBBean;
import dbbean.ShowDBBean;
import dbbean.UserDao;

@Controller
public class ShowHandler {
	@Resource
	private ShowDBBean showDao;
	@Resource
	private BoardDBBean boardDao;
	@Resource
	private UserDao userDao;
	
	
	SimpleDateFormat inputFormat = new SimpleDateFormat( "MM/dd/yyyy" );
	
	@RequestMapping("/view")
	public ModelAndView viewPro(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		HttpSession session = req.getSession( true );
		
		//int study_id = 1; // for temporary selected study data
		int study_id = Integer.parseInt( req.getParameter("sid") );	// studyId parameter
		
		//int tuser_id = 5; // for temporary signed-user data
		UserDataBean userDto = (UserDataBean) req.getSession().getAttribute("userDto"); //세션에서 가져온 유저 정보
		if(userDto != null) {
			userDto = userDao.getUserById(userDto.getId());
		}
		
		int cntAttendee = showDao.getCntAttendee( study_id );	// count attendee with regprocess_id=5
		
		StudyDataBean studyDto = showDao.getStudyInfo( study_id );
		StudyTimeDataBean studytimeDto = showDao.getStudyTime( study_id );
		LocationDataBean locationDto = showDao.getLocation( study_id );
		ApplyDataBean masterData = showDao.loadPrevData( studyDto.getUser_id() );	// study master-user data
		//UserDataBean userDto = showDao.getMyData( userDto.getId() );
		if(userDto != null) {
			ApplyDataBean applyDto = showDao.loadPrevData( userDto.getId() );
			req.setAttribute( "applyDto", applyDto );
		}
		studyDto.setCur_personnel( cntAttendee );

		if ( cntAttendee != 0 ) { 
			List<Integer> idList = showDao.getIdListAttendee( study_id );	// study members
			Map<Integer, ApplyDataBean> dataMap = new HashMap<Integer, ApplyDataBean>();
			for (Integer user_id : idList) {
				ApplyDataBean applyData = showDao.loadPrevData( user_id );
				dataMap.put( user_id,  applyData );
			}			
			req.setAttribute( "dataMap", dataMap );
		}

		req.setAttribute( "cntAttendee", cntAttendee );
		req.setAttribute( "masterData", masterData );
		req.setAttribute( "cntAttendee", cntAttendee );
		session.setAttribute( "studyDto", studyDto );	// studyDto -> on session
		req.setAttribute( "studytimeDto", studytimeDto );
		req.setAttribute( "locationDto", locationDto );
		
		session.setAttribute( "userDto", userDto );		// userDto -> on session
		session.setMaxInactiveInterval( -1 );


		//게시판
		study_id = 1; //스터디 아이디
		int wuser_id = 1; //글쓰는 사람 유저 아이디
		List<BoardDataBean> boardDtoList = boardDao.loadBoardlist(study_id);
		req.setAttribute("boardDtoList", boardDtoList);
		req.setAttribute("study_id", study_id);
		req.setAttribute("wuser_id", wuser_id);
		
		return new ModelAndView("views/show/view");
	}
	
	
	@RequestMapping("/apply")
	public ModelAndView applyPro(HttpServletRequest req, HttpServletResponse resp) throws Exception {
			req.setCharacterEncoding( "utf-8" );
		
			AttendeeDataBean attendeeDto = new AttendeeDataBean();
			SchoolDataBean schoolDto = new SchoolDataBean();
			ExpDataBean expDto = new ExpDataBean();
			LanguageDataBean langDto = new LanguageDataBean();
			CertificateDataBean certDto = new CertificateDataBean();
			UserDataBean userDto = (UserDataBean) req.getSession().getAttribute( "userDto" );
			StudyDataBean studyDto = (StudyDataBean) req.getSession().getAttribute( "studyDto" );
			System.out.println(userDto.getId());

			
			attendeeDto.setPurpose( req.getParameter( "purpose" ) );
			attendeeDto.setGoal( req.getParameter( "goal" ) );
			attendeeDto.setIntro( req.getParameter( "attendee_intro" ) );
			attendeeDto.setRequest( req.getParameter( "attendee_request" ) );
			attendeeDto.setRegdate( new Timestamp( System.currentTimeMillis() ) );
			attendeeDto.setUser_id( userDto.getId() );
			attendeeDto.setStudy_id( studyDto.getId() );
			attendeeDto.setRegprocess_id( 1 );

			showDao.deleteSchool( userDto.getId() );
			schoolDto.setName( req.getParameter( "school" ) );
			schoolDto.setMajor( req.getParameter( "major" ) );
			schoolDto.setStatus( req.getParameter( "radio-school" ) );
			schoolDto.setUser_id( userDto.getId() );
			showDao.insertSchool( schoolDto );
			

			showDao.deleteCareer( userDto.getId() );
			for ( int i = 1; i < 21; i++ ) {
				if ( req.getParameter( "career" + Integer.toString( i ) ) != null && 
						! req.getParameter( "career" + Integer.toString( i ) ).equals( "" ) ) {
					expDto.setExperience( req.getParameter( "career" + Integer.toString( i ) ) );
					expDto.setStart_date( inputFormat.parse( req.getParameter( "workstart" + Integer.toString( i ) ) ) );
					expDto.setEnd_date( inputFormat.parse( req.getParameter( "workend" + Integer.toString( i ) ) ) );
					expDto.setUser_id( userDto.getId() );
					showDao.insertCareer( expDto );
				}
			}

			showDao.deleteLanguage( userDto.getId() );
			for ( int i = 1; i < 21; i++ ) {
				if ( req.getParameter( "lang" + Integer.toString( i ) ) != null &&
						! req.getParameter( "lang" + Integer.toString( i ) ).equals( "" ) ) { 
					langDto.setLanguage( req.getParameter( "lang" + Integer.toString( i ) ) );
					langDto.setName( req.getParameter( "exam" + Integer.toString( i ) ) );
					langDto.setScore( req.getParameter( "score" + Integer.toString( i ) ) );
					langDto.setObtain_date( inputFormat.parse( req.getParameter( "langodate" + Integer.toString( i ) ) ) );
					langDto.setUser_id( userDto.getId() );
					showDao.insertLanguage( langDto );
				}
			}

			showDao.deleteCertificate( userDto.getId() );
			for ( int i = 1; i < 21; i++ ) {
				if ( req.getParameter( "cert" + Integer.toString( i ) ) != null &&
						! req.getParameter( "cert" + Integer.toString( i ) ).equals( "" ) ) { 
					certDto.setName( req.getParameter( "cert" + Integer.toString( i ) ) );
					certDto.setScore( req.getParameter( "grade" + Integer.toString( i ) ) );
					certDto.setObtain_date( inputFormat.parse( req.getParameter( "certodate" + Integer.toString( i ) ) ) );
					certDto.setUser_id( userDto.getId() );
					showDao.insertCertificate( certDto );
				}
			}

			int resultAttendee = showDao.insertAttendee( attendeeDto );
			
			req.setAttribute( "resultAttendee", resultAttendee );

		
		return new ModelAndView("views/show/apply");
	}

	@RequestMapping("/applyForm")
	public ModelAndView applyFormPro(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		UserDataBean userDto = (UserDataBean) req.getSession().getAttribute( "userDto" );
		req.getSession().setAttribute( "userDto", userDto );
		
		return new ModelAndView("views/show/applyForm");
	}
	
	@RequestMapping("/applyResult")
	public ModelAndView applyResultPro(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		int user_id = Integer.parseInt( req.getParameter( "id" ) );
		int study_id = Integer.parseInt( req.getParameter( "sid" ) );
		
		req.setAttribute( "user_id", user_id );
		req.setAttribute( "study_id", study_id );
		
		return new ModelAndView("views/show/applyResult");
	}
	
	@RequestMapping(value="/getApplication.do", produces="application/json; charset=utf8")
	@ResponseBody
	public ResponseEntity ajax_myApplication( 
		@RequestParam("user_id") Integer user_id, 
		@RequestParam("study_id") Integer study_id, HttpServletResponse resp) throws Exception {

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "application/json;charset=UTF-8");
		
		System.out.println("in ajax : got user_id " + user_id + ", got study_id " + study_id);
		
		ApplyDataBean applyDto = showDao.loadPrevData( user_id );

		Map<String, Integer> id_map = new HashMap<String, Integer>();
		id_map.put( "user_id", user_id );
		id_map.put( "study_id", study_id );
		AttendeeDataBean attendeeDto = showDao.getMineApplied( id_map );
		
		System.out.println("in ajax : got attendeeDto " + attendeeDto);
		System.out.println("in ajax : got attendeeId " + attendeeDto.getId() + "\n");
		
		HashMap<String, Object> attendeeMap = new HashMap<String, Object>();
		attendeeMap.put( "attendee_id", Integer.toString( attendeeDto.getId() ) );
		if ( attendeeDto.getPurpose() != null )
			attendeeMap.put( "purpose", attendeeDto.getPurpose() );
		if ( attendeeDto.getGoal() != null )
			attendeeMap.put( "goal", attendeeDto.getGoal() );
		attendeeMap.put( "user_id", Integer.toString( attendeeDto.getUser_id() ) );
		if ( attendeeDto.getIntro() != null )
			attendeeMap.put( "intro", attendeeDto.getIntro() );
		if ( attendeeDto.getRequest() != null )
			attendeeMap.put( "request", attendeeDto.getRequest() );
		if ( applyDto.getSchool_name() != null )
			attendeeMap.put( "school_name", applyDto.getSchool_name() );
		if ( applyDto.getSchool_major() != null )
			attendeeMap.put( "school_major", applyDto.getSchool_major() );
		if ( applyDto.getSchool_status() != null )
			attendeeMap.put( "school_status", applyDto.getSchool_status() );
		attendeeMap.put( "experience", applyDto.getExperience() );
		attendeeMap.put( "exp_start", applyDto.getExp_start() );
		attendeeMap.put( "exp_end", applyDto.getExp_end() );
		attendeeMap.put( "language", applyDto.getLanguage() );
		attendeeMap.put( "lang_name", applyDto.getLang_name() );
		attendeeMap.put( "lang_score", applyDto.getLang_score() );
		attendeeMap.put( "lang_obtain", applyDto.getLang_obtain() );
		attendeeMap.put( "cert_name", applyDto.getCert_name() );
		attendeeMap.put( "cert_score", applyDto.getCert_score() );
		attendeeMap.put( "cert_obtain", applyDto.getCert_obtain() );
		
		JSONArray json = new JSONArray();
		json.add( attendeeMap );
		System.out.println(json.toString() + "\n");
		return new ResponseEntity(json.toString(), responseHeaders, HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/loadPrevData.do", produces="application/json; charset=utf8")
	@ResponseBody
	public ResponseEntity ajax_myPrevData(HttpServletRequest req, HttpServletResponse resp) throws Exception {

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "application/json;charset=UTF-8");
		
		UserDataBean userDto = (UserDataBean) req.getSession().getAttribute( "userDto" );
		int user_id = userDto.getId();
		ApplyDataBean applyDto = showDao.loadPrevData( user_id );
		//ApplyDataBean applyDto = new ApplyDataBean();
		System.out.println("user_id : " + user_id);
		
		HashMap<String, Object> applyMap = new HashMap<String, Object>();
		applyMap.put( "attendee_id", Integer.toString( applyDto.getAttendee_id() ) );
		applyMap.put( "purpose", applyDto.getPurpose() );
		applyMap.put( "goal", applyDto.getGoal() );
		applyMap.put( "user_id", Integer.toString( applyDto.getUser_id() ) );
		applyMap.put( "school_name", applyDto.getSchool_name() );
		applyMap.put( "school_major", applyDto.getSchool_major() );
		applyMap.put( "school_status", applyDto.getSchool_status() );
		applyMap.put( "experience", applyDto.getExperience() );
		applyMap.put( "exp_start", applyDto.getExp_start() );
		applyMap.put( "exp_end", applyDto.getExp_end() );
		applyMap.put( "language", applyDto.getLanguage() );
		applyMap.put( "lang_name", applyDto.getLang_name() );
		applyMap.put( "lang_score", applyDto.getLang_score() );
		applyMap.put( "lang_obtain", applyDto.getLang_obtain() );
		applyMap.put( "cert_name", applyDto.getCert_name() );
		applyMap.put( "cert_score", applyDto.getCert_score() );
		applyMap.put( "cert_obtain", applyDto.getCert_obtain() );
		
		JSONArray json = new JSONArray();
		json.add( applyMap );
		System.out.println(json.toString());
		return new ResponseEntity(json.toString(), responseHeaders, HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/getMineApplied.do")
	@ResponseBody
	public String ajax_isMineApplied( 
			@RequestParam("user_id") Integer user_id, 
			@RequestParam("study_id") Integer study_id, HttpServletRequest request) throws Exception {
		int study_holder_id = showDao.getStudyIdbyUserId(study_id);
		if(user_id == study_holder_id) {
			
			return "mystudy";
		}
		else {
			Map<String, Integer> id_map = new HashMap<String, Integer>();
			id_map.put( "user_id", user_id );
			id_map.put( "study_id", study_id );
			AttendeeDataBean attendeeDto = showDao.getMineApplied( id_map );
			
			if ( attendeeDto != null ) return "exist";
			else return "joinable";
		}

	}
	
	@RequestMapping("/boardlist")
	public ModelAndView boardListProcess(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		int study_id = 1; //스터디 아이디
		int wuser_id = 1; //글쓰는 사람 유저 아이디
		List<BoardDataBean> boardDtoList = boardDao.loadBoardlist(study_id);
		req.setAttribute("boardDtoList", boardDtoList);
		req.setAttribute("study_id", study_id);
		req.setAttribute("wuser_id", wuser_id);
		return new ModelAndView("views/board/list");
	}
	
	@RequestMapping("/boardInput")
	public ModelAndView boardInputProcess(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		int study_id = 1; //스터디 아이디
		int wuser_id = 1; //글쓰는 사람 유저 아이디
		req.setAttribute("study_id", study_id);
		req.setAttribute("wuser_id", wuser_id);
		return new ModelAndView("views/board/inputForm");
	}

	@RequestMapping("/boardinputpro")
	public ModelAndView boardInputProProcess(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		req.setCharacterEncoding( "utf-8" );
		BoardDataBean boardDto = new BoardDataBean();
		boardDto.setTitle(req.getParameter("title"));
		boardDto.setPasswd(req.getParameter("passwd"));
		boardDto.setContent(req.getParameter("content"));
		boardDto.setUser_id(Integer.parseInt(req.getParameter("wuser_id")));
		boardDto.setStudy_id(Integer.parseInt(req.getParameter("study_id")));
		boardDto.setReadcount(0);
		boardDto.setRef(0);
		boardDto.setRe_level(0);
		boardDto.setRe_step(0);
		
		int form = Integer.parseInt(req.getParameter("articleform"));
		if(form == 1) {
			boardDto.setSecret("1");
			boardDto.setNotice("0");
		}
		else if(form ==2) {
			boardDto.setSecret("0");
			boardDto.setNotice("1");
		}
		else {
			boardDto.setSecret("0");
			boardDto.setNotice("0");
		}
		int res = boardDao.insertBoard(boardDto); //삽입
		System.out.println(res);
		req.setAttribute("res", res);
		return new ModelAndView("views/board/inputPro");
	}
	
	@RequestMapping("/boardcontent")
	public ModelAndView boardContentProcess(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		req.setCharacterEncoding( "utf-8" );
		int id = Integer.parseInt(req.getParameter("bid"));
		int study_id = 1;
		Map<String,Integer> map = new HashMap<String,Integer>();
		map.put("id", id);
		map.put("study_id", study_id);
		BoardDataBean boardDto = boardDao.getArticle(map);
		System.out.println(boardDto.getTitle());
		req.setAttribute("boardDto", boardDto);
		return new ModelAndView("views/board/content");
	}
	
	@RequestMapping("/articledelete")
	public ModelAndView articledeleteProcess(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		int id = Integer.parseInt(req.getParameter("id"));
		int sid = Integer.parseInt(req.getParameter("id"));
		Map<String,Integer> map = new HashMap<String,Integer>();
		map.put("id", id);
		map.put("study_id", sid);
		int res = boardDao.deleteArticle(map);
		req.setAttribute("res", res);
		return new ModelAndView("views/board/deletePro");
	}
	
	 @RequestMapping(value="/board/commentList.do", produces="application/json; charset=utf8")
	 @ResponseBody
	 public ResponseEntity ajax_commentList(HttpServletRequest req, HttpServletResponse resp) throws Exception{


	        HttpHeaders responseHeaders = new HttpHeaders();
	        responseHeaders.add("Content-Type", "application/json;charset=UTF-8");

	
	        ArrayList<HashMap> hmlist = new ArrayList<HashMap>();
	        
	        // 해당 게시물 댓글
	        int board_id = Integer.parseInt(req.getParameter("board_id"));
	        List<CommentDataBean> commentDto = boardDao.selectBoardCommentByCode(board_id);
	        
	        if(commentDto.size() > 0){
	            for(int i=0; i<commentDto.size(); i++){
	                HashMap hm = new HashMap();
	                hm.put("id", commentDto.get(i).getId());
	                hm.put("content", commentDto.get(i).getContent());
	                hm.put("writer", commentDto.get(i).getWriter());
	                hm.put("regdate", commentDto.get(i).getRegdate().toString());
	                
	                hmlist.add(hm);
	            }
	            
	        }
	        JSONArray json = new JSONArray();
	        json.addAll(hmlist);
	        System.out.println(json.toString());
	        return new ResponseEntity(json.toString(), responseHeaders, HttpStatus.CREATED);
	        
	    }
	   @RequestMapping(value="/board/addComment.do")
	   @ResponseBody
	   public String ajax_addComment(@ModelAttribute("commentDto")CommentDataBean commentDto, HttpServletRequest request) throws Exception{
	        
	        HttpSession session = request.getSession();
	     	        
	        try{
	        	commentDto.setWriter("익명");
	        	System.out.println(commentDto.getContent());
	            boardDao.addComment(commentDto);
	            
	        } catch (Exception e){
	            e.printStackTrace();
	        }
	        
	        return "success";
	    }
	   
	   @RequestMapping(value="/board/delComment.do")
	   @ResponseBody
	   public String ajax_deleteComment(
				@RequestParam("comment_id") String commentId, HttpServletRequest req) throws Exception{

//			Map<String, Integer> id_map = new HashMap<String, Integer>();
//			id_map.put( "comment_id", comment_id );
//			id_map.put( "board_id", board_id );
//			id_map.put( "study_id", study_id );
		   	int comment_id = Integer.parseInt( commentId );
			
			boardDao.delComment( comment_id );
			
	        return "success";
	    }
	   
	   
}