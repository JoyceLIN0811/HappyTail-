<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://cdnjs.cloudflare.com/ajax/libs/sockjs-client/1.3.0/sockjs.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/stomp.js/2.3.3/stomp.js"></script>
        
        <script type="text/javascript">
            var stompClient = null;
             
            function setConnected(connected) {
                document.getElementById('connect').disabled = connected;
                document.getElementById('disconnect').disabled = !connected;
                document.getElementById('conversationDiv').style.visibility 
                  = connected ? 'visible' : 'hidden';
                document.getElementById('response').innerHTML = '';
            }
             
            function connect() {
                var socket = new SockJS('/notice');
                stompClient = Stomp.over(socket);  
                stompClient.connect({}, function(frame) {
                    setConnected(true);
                    console.log('Connected: ' + frame);
                    stompClient.subscribe('/topic/forum/notice', function(messageOutput) {
                        showMessageOutput(JSON.parse(messageOutput.body));
                    });
                });
            }
             
            function disconnect() {
                if(stompClient != null) {
                    stompClient.disconnect();
                }
                setConnected(false);
                console.log("Disconnected");
            }
 
            function showMessageOutput(messageOutput) {
                var response = document.getElementById('response');
                var p = document.createElement('p');
                p.style.wordWrap = 'break-word';
                p.appendChild(document.createTextNode(messageOutput.from + ": " 
                  + messageOutput.text + " (" + messageOutput.time + ")"));
                response.appendChild(p);
            }
        </script>



</head>
<body onload="disconnect()">



			<div>
                <button id="connect" onclick="connect();">Connect</button>
                <button id="disconnect" disabled="disabled" onclick="disconnect();">
                    Disconnect
                </button>
            </div>
            <br />
            
            <div id="conversationDiv">
               
                <p id="response"></p>
            </div>

<div> 共 ${page.totalNum}筆</div>

<table border="1">
	<tr style="text-align:center">
		<td>預約人</td>
	 	<td>品種</td>
	 	<td>預約時間</td>
	 	<td>服務</td>
	 	<td>需求</td>
	 	<td>金額</td>
	 	<td>狀態</td>
	 	<td>評分</td>
	 	<td>評論</td>
	<c:forEach varStatus="star" var="View" items="${page.records}" begin='0' end='${page.pageSize-1}'>
	<tr style="text-align:center">
			<td>${View.username}</td>
			<td>${View.breed}</td>
			<td>${View.createDate}<br>${View.availableDateTime}:00</td>
			<td>${View.serviceItem}</td>
			<td>${View.require}</td>
			<td>${View.amount}</td>
			<td>${View.statuss}</td>
			<td>${View.score}</td>
			<td>${View.content}</td>
	</tr>
	</c:forEach>
	</tr>
</table><br>

<script>


</script>

<form method="get" action="pageBackView" style='float: left;margin-right: 10px '>
	<td><input type='hidden' name='pageNum' value='${page.currentPage-1}'>
		<input type='submit' value='上一頁'>
	</td>
</form>

<span style='float: left;margin-right: 10px;'>第  ${page.currentPage} 頁 , 共 ${page.totalPages+1}頁</span>

<form method="get" action="pageBackView" >
	<td><input type='hidden' name='pageNum' value='${page.currentPage+1}'>
		<input type='submit' value='下一頁'>
	</td>
</form>




<a href="<c:url value='pageBackView?pageNum=1' />"><input type="button" value='查詢全部'></a><br><br>

<form action="queryByPageBackView" method="get">
選擇月份: <select name='createMonth'>
			<option value='2020-01'>1月</option>
			<option value='2020-02'>2月</option>
			<option value='2020-03'>3月</option>
			<option value='2020-04'>4月</option>
			<option value='2020-05'>5月</option>
			<option value='2020-06'>6月</option>
			<option value='2020-07'>7月</option>
			<option value='2020-08'>8月</option>
			<option value='2020-09'>9月</option>
			<option value='2020-10'>10月</option>
			<option value='2020-11'>11月</option>
			<option value='2020-12'>12月</option>
	    </select>
	    <input type='hidden' name='pageNum' value='${page.currentPage}'>
	    <input type="submit" value='查詢'>

</form>




</body>
</html>