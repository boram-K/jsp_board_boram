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
<title>게시판</title>
<style type="text/css">
.wrap{
	height: 80vh;
}
h3{
	font-family: 'Dongle';
}

</style>

</head>
<body>

<jsp:include page="header.jsp"/>
<div class="wrap">
<div class="container text-center">
<h1>자유 게시판</h1>
<h3>욕설,비방 금지입니다. 문제시 게시물이 삭제될 수 있습니다.</h3>
<div class="d-flex flex-row-reverse">
<button type="button" onclick="location.href='write_view.do';" class="btn mb-2" style="font-family: 'Sunflower'; background-color: #ff9967;">글쓰기</button>
</div>
<table class="table table-sm table-bordered table-hover">
 <thead style="background-color: #343148; color: #D7C49E;">
<tr>
<th>번호</th>
<th>이름</th>
<th>제목</th>
<th>날짜</th>
<th>조회수</th>
</tr>
</thead>
<c:forEach var="bto" items="${plist}">
<tr>
<td>${bto.bid}</td>
<td>${bto.bname}</td>
<td>
<c:forEach begin="1" end="${bto.bindent}">re></c:forEach>
<a href="content_view.do?bid=${bto.bid}">${bto.btitle}</a>
</td>
<td>${bto.bdate}</td>
<td>${bto.bhit}</td>
</tr>
</c:forEach>

</table>
<div class="conatainer text-center">
<ul class="pagination justify-content-center">
<c:forEach var="i" begin="${page[0]}" end="${page[1]}">
<li class="page-item"><a class="page-link" href="/jsp_board_boram/pList.do?pageNum=${i}">${i}</a></li>
</c:forEach> 
</ul>
</div>
</div>
</div>
<jsp:include page="footer.jsp"/>
</body>
</html>