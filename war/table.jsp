<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@page import="com.googlecode.objectify.Objectify"%>
<%@page import="com.googlecode.objectify.ObjectifyService"%>
<%@page import="com.googlecode.objectify.Query"%>
<%@page import="frankel.uriel.gae.UserInfo"%>

<head>
<title>סקר השכר של מחשבון הנטו</title>

</head>

<body style="padding: 0; margin: 0; border: none; min-width:800px;">
<div>
<div>
  <img src="head_background2.png" style="width: 100%; height: 300px; margin:0; padding:0; border: none; position: fixed;"/>
  <img src="neto.png" style="z-index: 10; float: right; height: 300px; position: fixed; right: 50px;"/>
<div style="z-index: 10; position: fixed; margin-right:0px; margin-left:0px; top: 100px; right: 400px; width: 400px; height:200px; color:rgb(255,255,255); font-size:30px; text-align:right;">
סקר השכר של אפליקציית מחשבון הנטו
</div>
</div>
<div style="position:absolute;  top:320px;   width: 100%; text-align: center;">
	<table style="margin-left: auto; margin-right: auto; border:1px solid green;">
		<tr style="background: green;">
			<th style="text-align: center;">וותק</td>
			<th style="text-align: center;">תחום</td>
			<th style="text-align: center;">החברה</td>
			<th style="text-align: center;">העבודה</td>
			<th style="text-align: center;">משכורת</td>
		</tr>
		<%
			Objectify ofy = ObjectifyService.begin();
			Query<UserInfo> query = ofy.query(UserInfo.class);
			boolean grey = false;
			for (UserInfo userInfo : query) {
				if(grey){
		%>
		<tr style="background: aqua;">
			<td><%=userInfo.seniority%></td>
			<td><%=userInfo.discipline%></td>
			<td><%=userInfo.company%></td>
			<td><%=userInfo.jobTitle%></td>
			<td><%=userInfo.salary%></td>
		</tr>
		<%
				}else{
					%>
					<tr style="background:white;">
						<td><%=userInfo.seniority%></td>
						<td><%=userInfo.discipline%></td>
						<td><%=userInfo.company%></td>
						<td><%=userInfo.jobTitle%></td>
						<td><%=userInfo.salary%></td>
					</tr>
					<%		
				}
				
			}
		%>
	</table>
	</div>
	</div>
	<footer style="position:absolute;  bottom:30px;   width: 100%;
    text-align: center; ">
	<img src="appengine-noborder-120x30.gif" alt="Powered by Google App Engine" style="height: 30px; width: 120px;"/>
</footer>
</body>
</html>


