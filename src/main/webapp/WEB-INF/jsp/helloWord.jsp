<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="ctx" value="<%=request.getContextPath()%>" />
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>hello world</title>
</head>
<body>
	<form method="post" id="environmentAdd">
		<table>
			<tr>
				<td>TestEnvironment:</td>
				<td><input type="text" id="TestEnvironment" /></td>
			</tr>
		</table>
		<a href="javascript:userAdd()">确定</a>
	</form>
	<script src="../resources/jquery/jquery.min.js"></script>
    <script src="../resources/bootstrap/js/bootstrap.min.js"></script>
    <script src="../resources/bootstrap/js/bootstrap-table.min.js"></script>
    <script src="../resources/bootstrap/language/bootstrap-table-zh-CN.min.js"></script>
    <script src="../resources/util/moment.min.js"></script>
	<script>
	
		function userAdd() {
			$.ajax({
				url : "${ctx}/testEnvironment/insert",
				contentType:"application/json;charset=utf-8",
				data : "{\"environmentName\":\"environmentName\",\"serverUrl\":\"serverUrl\",\"oauthAccessTokenUri\":\"oauthAccessTokenUri\",\"oauthGrantType\":\"oauthGrantType\",\"oauthClientId\":\"oauthClientId\",\"oauthSecret\":\"oauthSecret\"}",
				type : "post",
				success : function(data) {
					alert(data);
					console.log(data);
				},
				error : function(data){
					alert(data);
					console.log(data);
				}
			});
		}
	</script>
</body>
</html>