<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" type="image/png" sizes="16x16" href="../plugins/images/favicon.png">
    <title>Elite Admin Template - The Ultimate Multipurpose admin template</title>
    <!-- Bootstrap Core CSS -->
    <link href="../../studyloop/default/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="../../studyloop/default/plugins/bower_components/bootstrap-extension/css/bootstrap-extension.css" rel="stylesheet">
    <!-- animation CSS -->
    <link href="../../studyloop/default/css/animate.css" rel="stylesheet">
    <!-- Menu CSS -->
    <link href="../../studyloop/default/plugins/bower_components/sidebar-nav/dist/sidebar-nav.min.css" rel="stylesheet">
    <!-- page CSS -->
    <link href="../../studyloop/default/plugins/bower_components/bootstrap-datepicker/bootstrap-datepicker.min.css" rel="stylesheet" type="text/css" />
    <link href="../../studyloop/default/plugins/bower_components/custom-select/custom-select.css" rel="stylesheet" type="text/css" />
    <link href="../../studyloop/default/plugins/bower_components/switchery/dist/switchery.min.css" rel="stylesheet" />
    <link href="../../studyloop/default/plugins/bower_components/bootstrap-select/bootstrap-select.min.css" rel="stylesheet" />
    <link href="../../studyloop/default/plugins/bower_components/bootstrap-tagsinput/dist/bootstrap-tagsinput.css" rel="stylesheet" />
    <link href="../../studyloop/default/plugins/bower_components/bootstrap-touchspin/dist/jquery.bootstrap-touchspin.min.css" rel="stylesheet" />
    <link href="../../studyloop/default/plugins/bower_components/multiselect/css/multi-select.css" rel="stylesheet" type="text/css" />
    <!-- animation CSS -->
    <link href="../../studyloop/default/css/animate.css" rel="stylesheet">
    <!-- Custom CSS -->
    <link href="../../studyloop/default/css/style.css" rel="stylesheet">
    <!-- color CSS -->
    <link href="../../studyloop/default/css/colors/blue.css" id="theme" rel="stylesheet">
    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
<![endif]-->
</head>

<body>
    <!-- Preloader -->
    <div class="preloader">
        <div class="cssload-speeding-wheel"></div>
    </div>
            <div class="container-fluid">
                <div class="row bg-title">
                    <div class="col-lg-3 col-md-4 col-sm-4 col-xs-12">
                        <h4 class="page-title">회원가입을 위한 추가 설문을 완료해 주세요.</h4> </div>
                    <!-- /.col-lg-12 -->
                </div>
                <!-- .row -->
                <div class="row">
                    <div class="col-sm-12">
                        <div class="white-box">
                            <h3 class="box-title m-b-0">관심사</h3>
                            <p class="text-muted m-b-30">관심 있는 분야를 선택해 주세요(중복 선택 가능)</p>                          
                            <h5 class="m-t-20">클릭하여 선택</h5>
                            <select class="select2 m-b-10 select2-multiple" multiple="multiple" data-placeholder="Choose">
                                <optgroup label="취업">
                                    <option value="BG">대기업</option>
                                    <option value="MS">중소기업</option>
                                    <option value="PC">공기업</option>
                                    <option value="PU">공무원</option>
                                    <option value="FR">외국계기업</option>
                                </optgroup>
                                <optgroup label="자격증">
                                    <option value="IT">IT</option>
                                    <option value="CK">요리</option>
                                    <option value="SO">사회</option>
                                </optgroup>
                                <optgroup label="전공">
                                    <option value="AZ">공학</option>
                                    <option value="CO">인문</option>
                                    <option value="ID">자연과학</option>
                                    <option value="MT">사회</option>
                                    <option value="NE">상경</option>
                                    <option value="NM">예체능</option>
                                </optgroup>
                                <optgroup label="어학">
                                    <option value="EN">영어</option>
                                    <option value="JP">일본어</option>
                                    <option value="CH">중국어</option>
                                    <option value="DE">독일어</option>
  									<option value="ET">기타언어</option>
                                </optgroup>
                                <optgroup label="기타">
                                    <option value="CO">회화</option>
                                    <option value="EX">운동</option>
                                </optgroup>
                            </select>
                        </div>
                    </div>
                </div>
                <!-- /.row -->
                <!-- /.row -->
                <!-- .row -->
                <!-- /.row -->
                <div class="row">
                    <div class="col-lg-12">
                        <div class="white-box">
                            <div class="row">
                                <div class="col-lg-2 col-md-2 col-sm-4 col-xs-12">
                                    <h3 class="box-title m-b-0">유입 경로</h3>
                                    <p class="text-muted font-13 m-b-30"> 사이트를 어떻게 알게 되셨나요?</p>
                                    <div class="checkbox">
                                        <input id="checkbox0" type="checkbox">
                                        <label for="checkbox0"> 포털사이트 </label>
                                    </div>
                                    <div class="checkbox checkbox-custom">
                                        <input id="checkbox11" type="checkbox" checked>
                                        <label for="checkbox11"> 지인소개 </label>
                                    </div>
                                    <div class="checkbox checkbox-primary">
                                        <input id="checkbox2" type="checkbox" checked>
                                        <label for="checkbox2"> 취업카페 </label>
                                    </div>
                                    <div class="checkbox checkbox-success">
                                        <input id="checkbox3" type="checkbox">
                                        <label for="checkbox3"> 취업포털 </label>
                                    </div>
                                    <div class="checkbox checkbox-info">
                                        <input id="checkbox4" type="checkbox">
                                        <label for="checkbox4"> 커뮤니티 사이트 </label>
                                    </div>
                                    <div class="checkbox checkbox-warning">
                                        <input id="checkbox5" type="checkbox" checked>
                                        <label for="checkbox5"> 기타 </label>
                                    </div>
                                </div>
                                <div class="col-lg-2 col-md-2 col-sm-4 col-xs-12">
                                    <h3 class="box-title m-b-0">Checkbox Circle</h3>
                                    <p class="text-muted font-13 m-b-30"> Add simple <code>checkbox-circle</code> class </p>
                                    <div class="checkbox checkbox-circle">
                                        <input id="checkbox7" type="checkbox">
                                        <label for="checkbox7"> Simply Rounded </label>
                                    </div>
                                    <div class="checkbox checkbox-info checkbox-circle">
                                        <input id="checkbox8" type="checkbox" checked>
                                        <label for="checkbox8"> Info </label>
                                    </div>
                                    <div class="checkbox checkbox-primary checkbox-circle">
                                        <input id="checkbox-9" type="checkbox">
                                        <label for="checkbox-9"> Primary </label>
                                    </div>
                                    <div class="checkbox checkbox-success checkbox-circle">
                                        <input id="checkbox-10" type="checkbox" checked>
                                        <label for="checkbox-10"> Success </label>
                                    </div>
                                    <div class="checkbox checkbox-warning checkbox-circle">
                                        <input id="checkbox-11" type="checkbox">
                                        <label for="checkbox-11"> Warning </label>
                                    </div>
                                    <div class="checkbox checkbox-danger checkbox-circle">
                                        <input id="checkbox-12" type="checkbox" checked>
                                        <label for="checkbox-12"> Danger </label>
                                    </div>
                                    <div class="checkbox checkbox-purple checkbox-circle">
                                        <input id="checkbox-13" type="checkbox" checked>
                                        <label for="checkbox-13"> Purple </label>
                                    </div>
                                    <div class="checkbox checkbox-inverse checkbox-circle">
                                        <input id="checkbox-15" type="checkbox" checked>
                                        <label for="checkbox-15"> Inverse </label>
                                    </div>
                                </div>
                                <div class="col-lg-2 col-md-2 col-xs-12">
                                    <h3 class="box-title m-b-0">Checkbox Disable</h3>
                                    <p class="text-muted font-13 m-b-30"> Disable state </p>
                                    <div class="checkbox">
                                        <input id="checkbox9" type="checkbox" disabled>
                                        <label for="checkbox9"> Can't check this </label>
                                    </div>
                                    <div class="checkbox checkbox-warning checkbox-circle">
                                        <input id="checkbox110" type="checkbox" disabled checked>
                                        <label for="checkbox110"> And this </label>
                                    </div>
                                    <div class="checkbox checkbox-info">
                                        <input id="checkbox12" type="checkbox" disabled checked>
                                        <label for="checkbox12"> Can't check this </label>
                                    </div>
                                    <div class="checkbox checkbox-purple checkbox-circle">
                                        <input id="checkbox14" type="checkbox" disabled checked>
                                        <label for="checkbox14"> And this </label>
                                    </div>
                                </div>
                                <div class="col-lg-2 col-md-2 col-sm-4 col-xs-12">
                                    <h3 class="box-title m-b-0">Radio Buttons</h3>
                                    <p class="text-muted font-13 m-b-30"> With bootstrap colors </p>
                                    <div class="radio">
                                        <input type="radio" name="radio" id="radio1" value="option1" checked>
                                        <label for="radio1"> Default </label>
                                    </div>
                                    <div class="radio radio-custom">
                                        <input type="radio" name="radio" id="radio2" value="option2">
                                        <label for="radio2"> Custom </label>
                                    </div>
                                    <div class="radio radio-primary">
                                        <input type="radio" name="radio" id="radio3" value="option3">
                                        <label for="radio3"> Primary </label>
                                    </div>
                                    <div class="radio radio-success">
                                        <input type="radio" name="radio" id="radio4" value="option4">
                                        <label for="radio4"> Success </label>
                                    </div>
                                    <div class="radio radio-info">
                                        <input type="radio" name="radio" id="radio5" value="option5">
                                        <label for="radio5"> Info </label>
                                    </div>
                                    <div class="radio radio-danger">
                                        <input type="radio" name="radio" id="radio6" value="option6">
                                        <label for="radio6"> Danger </label>
                                    </div>
                                    <div class="radio radio-warning">
                                        <input type="radio" name="radio" id="radio7" value="option7">
                                        <label for="radio7"> Warning </label>
                                    </div>
                                    <div class="radio radio-purple">
                                        <input type="radio" name="radio" id="radio8" value="option8">
                                        <label for="radio8"> Purple </label>
                                    </div>
                                </div>
                                <div class="col-lg-2 col-md-2 col-sm-4 col-xs-12">
                                    <h3 class="box-title m-b-0">Radio Clickable</h3>
                                    <p class="text-muted font-13 m-b-30"> All buttons clickable </p>
                                    <div class="radio">
                                        <input type="radio" name="radio1" id="radio11" value="option1" checked>
                                        <label for="radio11"> Default </label>
                                    </div>
                                    <div class="radio radio-custom">
                                        <input type="radio" name="radio2" id="radio12" value="option2">
                                        <label for="radio12"> Custom </label>
                                    </div>
                                    <div class="radio radio-primary">
                                        <input type="radio" name="radio3" id="radio13" value="option3">
                                        <label for="radio13"> Primary </label>
                                    </div>
                                    <div class="radio radio-success">
                                        <input type="radio" name="radio4" id="radio14" value="option4" checked>
                                        <label for="radio14"> Success </label>
                                    </div>
                                    <div class="radio radio-info">
                                        <input type="radio" name="radio5" id="radio15" value="option5" checked>
                                        <label for="radio15"> Info </label>
                                    </div>
                                    <div class="radio radio-danger">
                                        <input type="radio" name="radio6" id="radio16" value="option6">
                                        <label for="radio16"> Danger </label>
                                    </div>
                                    <div class="radio radio-warning">
                                        <input type="radio" name="radio7" id="radio17" value="option7" checked>
                                        <label for="radio17"> Warning </label>
                                    </div>
                                    <div class="radio radio-purple">
                                        <input type="radio" name="radio8" id="radio18" value="option8">
                                        <label for="radio18"> Purple </label>
                                    </div>
                                </div>
                                <div class="col-lg-2 col-md-2 col-sm-4 col-xs-12">
                                    <h3 class="box-title m-b-0">Radio Disable</h3>
                                    <p class="text-muted font-13 m-b-30"> Disable state </p>
                                    <div class="radio">
                                        <input type="radio" name="radio21" id="radio21" value="option1" disabled checked>
                                        <label for="radio21"> Default </label>
                                    </div>
                                    <div class="radio radio-custom">
                                        <input type="radio" name="radio22" disabled id="radio22" value="option2">
                                        <label for="radio22"> Custom </label>
                                    </div>
                                    <div class="radio radio-primary">
                                        <input type="radio" name="radio23" disabled id="radio23" value="option3">
                                        <label for="radio23"> Primary </label>
                                    </div>
                                    <div class="radio radio-success">
                                        <input type="radio" name="radio24" disabled id="radio24" value="option4" checked>
                                        <label for="radio24"> Success </label>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- /.row -->
            </div>
            <!-- /.container-fluid -->
  
        <!-- /#page-wrapper -->
        <footer class="footer text-center"> 2017 &copy; Elite Admin brought to you by themedesigner.in </footer>
   
    <!-- /#wrapper -->
    <!-- jQuery -->
    <script src="../../studyloop/default/plugins/bower_components/jquery/dist/jquery.min.js"></script>
    <!-- Bootstrap Core JavaScript -->
    <script src="../../studyloop/default/bootstrap/dist/js/tether.min.js"></script>
    <script src="../../studyloop/default/bootstrap/dist/js/bootstrap.min.js"></script>
    <script src="../../studyloop/default/plugins/bower_components/bootstrap-extension/js/bootstrap-extension.min.js"></script>
    <!-- Menu Plugin JavaScript -->
    <script src="../../studyloop/default/plugins/bower_components/sidebar-nav/dist/sidebar-nav.min.js"></script>
    <!--slimscroll JavaScript -->
    <script src="../../studyloop/default/js/jquery.slimscroll.js"></script>
    <!--Wave Effects -->
    <script src="../../studyloop/default/js/waves.js"></script>
    <!-- Custom Theme JavaScript -->
    <script src="../../studyloop/default/js/custom.min.js"></script>
    <script src="../../studyloop/default/plugins/bower_components/switchery/dist/switchery.min.js"></script>
    <script src="../../studyloop/default/plugins/bower_components/custom-select/custom-select.min.js" type="text/javascript"></script>
    <script src="../../studyloop/default/plugins/bower_components/bootstrap-select/bootstrap-select.min.js" type="text/javascript"></script>
    <script src="../../studyloop/default/plugins/bower_components/bootstrap-tagsinput/dist/bootstrap-tagsinput.min.js"></script>
    <script src="../../studyloop/default/plugins/bower_components/bootstrap-touchspin/dist/jquery.bootstrap-touchspin.min.js" type="text/javascript"></script>
    <script type="text/javascript" src="../../studyloop/default/plugins/bower_components/multiselect/js/jquery.multi-select.js"></script>
    <script>
    jQuery(document).ready(function() {
        // Switchery
        var elems = Array.prototype.slice.call(document.querySelectorAll('.js-switch'));
        $('.js-switch').each(function() {
            new Switchery($(this)[0], $(this).data());
        });
        // For select 2
        $(".select2").select2();
        $('.selectpicker').selectpicker();
        //Bootstrap-TouchSpin
        $(".vertical-spin").TouchSpin({
            verticalbuttons: true,
            verticalupclass: 'ti-plus',
            verticaldownclass: 'ti-minus'
        });
        var vspinTrue = $(".vertical-spin").TouchSpin({
            verticalbuttons: true
        });
        if (vspinTrue) {
            $('.vertical-spin').prev('.bootstrap-touchspin-prefix').remove();
        }
        $("input[name='tch1']").TouchSpin({
            min: 0,
            max: 100,
            step: 0.1,
            decimals: 2,
            boostat: 5,
            maxboostedstep: 10,
            postfix: '%'
        });
        $("input[name='tch2']").TouchSpin({
            min: -1000000000,
            max: 1000000000,
            stepinterval: 50,
            maxboostedstep: 10000000,
            prefix: '$'
        });
        $("input[name='tch3']").TouchSpin();
        $("input[name='tch3_22']").TouchSpin({
            initval: 40
        });
        $("input[name='tch5']").TouchSpin({
            prefix: "pre",
            postfix: "post"
        });
        // For multiselect
        $('#pre-selected-options').multiSelect();
        $('#optgroup').multiSelect({
            selectableOptgroup: true
        });
        $('#public-methods').multiSelect();
        $('#select-all').click(function() {
            $('#public-methods').multiSelect('select_all');
            return false;
        });
        $('#deselect-all').click(function() {
            $('#public-methods').multiSelect('deselect_all');
            return false;
        });
        $('#refresh').on('click', function() {
            $('#public-methods').multiSelect('refresh');
            return false;
        });
        $('#add-option').on('click', function() {
            $('#public-methods').multiSelect('addOption', {
                value: 42,
                text: 'test 42',
                index: 0
            });
            return false;
        });
    });
    </script>
    <!--Style Switcher -->
    <script src="../../studyloop/default/plugins/bower_components/styleswitcher/jQuery.style.switcher.js"></script>
    <!--Style Switcher -->
    <script src="../../studyloop/default/plugins/bower_components/styleswitcher/jQuery.style.switcher.js"></script>
</body>

</html>
