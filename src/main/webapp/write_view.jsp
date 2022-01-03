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
<title>글쓰기</title>
<script type="text/javascript">
function inNumber(){
	if(event.keyCode<48||event.keyCode>57){
		event.returnValue = false;
	}
}

function check(){
	
	if(document.getElementById("pw").value==""){
		alert("비밀번호를 입력해주세요");
		return;
	}else if(document.getElementById("title").value==""){
		alert("제목을 입력해주세요");
		return;
	}
	writeForm.submit();
}
</script>
<style type="text/css">
table{
	margin: 0 auto;
}
.wrap{
	height: 85vh;
}

</style>
</head>
<body>

<jsp:include page="header.jsp"/>
<div class="wrap">
<div class="container mt-5">
	<table class="table table-bordered " style="width: 80%">
		<form name="writeForm" action="write.do" method="post">
			<tr>
				<td>이름</td>
				<td> <input type="text" name="bname" size = "20"> </td>
			</tr>
			<tr>
				<td>제목 </td>
				<td> <input type="text" id="title" name="btitle" size = "50"> </td>
			</tr>
			<tr>
				<td> 내용</td>
				<td> <textarea name="bcontent" rows="10"  cols="80"></textarea> </td>
			</tr>
			<tr class="ptr">
				<td> 비밀번호</td>
				<td> <input type="text" name="bpw" id="pw" maxlength="4" onkeypress="inNumber();"><br/>
				수정하거나 삭제를 위해서 반드시 4자리 숫자를 입력해주세요 </td>			
			</tr>			
			<tr>
				<td colspan="2"> <input type="button" value="글쓰기" onclick="check()"> &nbsp;&nbsp; <a href="pList.do">목록으로</a></td>
			</tr>
		</form>
	</table>
	</div>
	</div>
	
	<jsp:include page="footer.jsp"/>
</body>
</html>