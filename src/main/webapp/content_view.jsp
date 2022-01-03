<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<link rel ="stylesheet" href="CSS/custom.css">
<title>게시글 확인</title>
<style type="text/css">
.content{
	height: 100px;
}
.td{
 width: 100px;
 background-color: #101820;
 color: #D7C49E;
}
.wrap{
	height: 70vh;
}
</style>
</head>
<body>

<jsp:include page="header.jsp"/>
<div class="wrap">
<div class="container mt-5">
	<table class="table table-bordered">
			<tr>
				<td class="td">번호</td>
				<td> ${content.bid} </td>
			</tr>
			<tr>
				<td class="td"> 조회수</td>
				<td> ${content.bhit} </td>
			</tr>
			<tr>
				<td class="td">이름 </td>
				<td>${content.bname}</td>
			</tr>
			<tr>
				<td class="td"> 제목</td>
				<td>${content.btitle}</td>
			</tr>
			<tr>
				<td colspan="2"> 내용 </td> </tr>
				<tr class="content">
				<td colspan="2" >${content.bcontent}</td>
			</tr>
			<tr >
				<td colspan="2"><a href="pList.do">목록으로</a> &nbsp;&nbsp;<a href="mpwCheckForm.do?bid=${content.bid}">수정</a>&nbsp;&nbsp; <a href="dpwCheckForm.do?bid=${content.bid}">삭제</a> &nbsp;&nbsp; <a href="reply_view.do?bid=${content.bid}">답변</a></td>
			</tr>
		</form>
	</table>
	</div>
	</div>
	<jsp:include page="footer.jsp"/>
</body>
</html>