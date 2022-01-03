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
	nav{
	background-color: #343148;
	font-weight: bolder;
	}

</style>
</head>
<body>
<nav class="navbar navbar-expand-lg  mb-5">
    <a class="navbar-brand" href="pList.do">
    <img src="img/butterfly-g90cff62ca_640.jpg" alt="Logo" style="width:40px;">
  </a>
  <button style="border-color:#D7C49E; " class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span  class="navbar-toggler-icon">=</span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link" href="main.jsp" style="color: #D7C49E">Main <span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="pList.do" style="color: #D7C49E">게시판</a>
      </li>
    </ul>
    <form action="serch.do" class="form-inline my-2 my-lg-0">
      <input name="serch" class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
      <button class="btn btn-outline-warning my-2 my-sm-0" type="submit">Search</button>
    </form>
  </div>
</nav>
</body>
</html>