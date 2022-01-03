<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<link rel ="stylesheet" href="CSS/custom.css">
<title>Insert title here</title>
<style type="text/css">
table{
	margin: 0 auto;
}
.wrap{
	height: 85vh;
}
</style>
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
	replyForm.submit();
}
</script>
</head>
<body>

<jsp:include page="header.jsp"/>
<div class="wrap">
	<div class="container mt-5">
	<table class="table table-bordered " style="width: 80%">
		<form name="replyForm" action="reply.do" method="post">
			<input type="hidden" name="bid" value="${reply_view.bid}"> <!-- hidden을 하게되면 사용자에게는 안보임 -->
			<input type="hidden" name="bgroup" value="${reply_view.bgroup}">
			<input type="hidden" name="bstep" value="${reply_view.bstep}">
			<input type="hidden" name="bindent" value="${reply_view.bindent}">
			<tr>
				<td> 번호 </td>
				<td> ${reply_view.bid} </td>
			</tr>
			<tr>
				<td> 이름 </td>
				<td> <input type="text" name="bname" size = "20" value="${reply_view.bname}"></td>
			</tr>
			<tr>
				<td> 제목 </td>
				<td> <input type="text" id="title" name="btitle" size = "50" value="${reply_view.btitle}"></td>
			</tr>
			<tr>
				<td> 내용 </td>
				<td> <textarea  rows="10"  cols="70" name="bcontent">${reply_view.bcontent}</textarea></td>
			</tr>
			<tr class="ptr">
				<td> 비밀번호</td>
				<td> <input type="text" name="bpw" id="pw" maxlength="4" onkeypress="inNumber();"><br/>
				수정하거나 삭제를 위해서 반드시 4자리 숫자를 입력해주세요 </td>			
			</tr>
			<tr >
				<td colspan="2"><input type="button" value="답변" onclick="check();">&nbsp;&nbsp; <a href="pList.do" >목록</a></td>
			</tr>
		</form>
	</table>
	</div>
	</div>
	<jsp:include page="footer.jsp"/>
</body>
</html>