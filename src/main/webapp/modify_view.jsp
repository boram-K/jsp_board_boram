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
<title>Insert title here</title>
<style type="text/css">
.wrap{
	height: 85vh;
}
</style>
<script type="text/javascript">
function check(){
	 if(document.getElementById("title").value==""){
		alert("제목을 입력해주세요");
		return;
	}
	 modifyForm.submit();
}
</script>
</head>
<body>

<jsp:include page="header.jsp"/>
<div class="wrap">
<div class="container mt-5">
	<table class="table table-bordered " style="width: 70%">
		<form name="modifyForm" action="modify.do" method="post">
			<input type="hidden" name="bid" value="${modifyID}"> <!-- 리퀘스트영역에 저장된 것을 가져옴 -->
			<tr>
				<td>번호</td>
				<td> ${modifyID} </td>
			</tr>
			<tr>
				<td>이름 </td>
				<td> <input type="text" name="bname" size = "20"></td>
			</tr>
			<tr>
				<td> 제목 </td>
				<td> <input type="text" id="title" name="btitle" size = "50"></td>
			</tr>
			<tr>
				<td> 내용 </td>
				<td> <textarea rows="10" cols="100" name="bcontent" ></textarea></td>
			</tr>
			<tr >
				<td colspan="2"> <input type="button" value="답변" onclick="check();"></td>
			</tr>
		</form>
	</table>
	</div>
	</div>
	<jsp:include page="footer.jsp"/>
</body>
</html>