Study group website 

* server language : jsp, java
* os evironment : windows 10
* IDE : eclipse 2019-3
* Server : Apache Tomcat 9.0
* DB : oracle 11g xe

How to use
1. clone repository to your local computer 
2. import project on your Eclipse IDE
3. execute studyloop.sql inside WebContent folder

* edit studyloop/views/notice/webSocket.jsp 
inline 23
var ws = new WebSocket("ws://localhost:8080/studyloop/websocket/chat");
localhost -> my IP address to activate websocket function
