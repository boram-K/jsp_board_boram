<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<link rel ="stylesheet" href="CSS/custom.css">
<title>비밀번호 확인</title>
<style type="text/css">
	.wrap{
		height: 80vh;
	}
</style>
</head>
<body>
	<div class="wrap">
	<jsp:include page="header.jsp"/>
		<div class="container mt-5 text-center">
			<div class="d-flex justify-content-center">
			<table class="table table-bordered" style="width: 500px">
				<form action="mpwCheck.do" method="post">
				<input type="hidden" name="mid" value="${cid}">
				<tr>
					<td>password </td>
					<td><input type="text" name="num" size="10"></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="입력"></td>
				</tr>
				</form>
			</table>
			</div>
		</div>
	</div>
	<jsp:include page="footer.jsp"/>
</body>
</html>