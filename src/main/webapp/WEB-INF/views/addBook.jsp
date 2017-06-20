<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>책 추가 페이지</title>
<style>
body {
	background-color: #fff;
}

form fieldset {
	margin-bottom: 25px;
}

form legend {
	fotn-size: 15px;
	font-weight: bold;
}

form ul li {
	list-style: none;
	margin: 5px 0;
	font-size: 15px;
}
</style>
</head>
<body>
	<h2>책 추가 페이지</h2>
	<form action="/Hansung_Libary/register/book/" method="GET">
		<fieldset>
			<legend> 책 정보(책 번호/이름/구분 필수) </legend>
			<ul>
				<li>책 번호 : <input type="text" name="book_code" id="book_code"
					size="22" /></li>
				<li>책 구분 : <input type="radio" name="book_type" value="IT">IT
					<input type="radio" name="book_type" value="과학">과학 <input
					type="radio" name="book_type" value="역사">역사
				</li>
				<li>책 이름 : <input type="text" name="title" id="title" size="22" /></li>
				<li>책 작가 : <input type="text" name="author" id="author"
					size="22" /></li>
				<li>출판년도 : <input type="text" name="publish" id="publish"
					size="20" /></li>
			</ul>
		</fieldset>

		<input type="submit" value="등록"> <input type="reset"
			value="초기화"> <input type="button" value="초기화면"
			onclick="location.href='./'">
	</form>
</body>
</html>