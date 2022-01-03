<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
  <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
<link rel ="stylesheet" href="CSS/custom.css">
<title>Board Main</title>
<style type="text/css">
	.wrap{
	height: 80vh;
	}
</style>
</head>
<body>
<div class="wrap">
<jsp:include page="header.jsp"/>
<div class="container mt-5">
  <div class="jumbotron">
    <h1>사이트 소개</h1>      
    <p>이 사이트는 부트스트랩과 jsp,oracle, javaScript, mysql를 사용해 만든 게시판 사이트 입니다.</p>
    <a class="btn btn-info" href="pList.do" style="color: black; font-family: Sunflower;" role="button">게시판으로 가기</a>
  </div>
  </div>
  </div>
  <jsp:include page="footer.jsp"/>
</body>
</html>