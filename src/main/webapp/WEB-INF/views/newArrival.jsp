<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>신간도서 설정 페이지</title>
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

#book_type {
	margin-left: 0px;
}

#phone_num {
	margin-top: 0px;
	margin-left: 0px;
	margin-bottom: 5px;
}

#email_add {
	margin-top: 0px;
	margin-left: 0px;
	margin-bottom: 5px;
}
</style>
</head>
<body>
	<h2>신간도서 설정 페이지</h2>
	<form action="/Hansung_Libary/register/recommand/" method="GET">
		<fieldset>
			<legend>
				사용자정보</small>
			</legend>
			<ul>
				<li>사용자 이름 : <input type="text" name="member_info" id="member_info"
					size="22" /></li>
			</ul>
		</fieldset>
		<fieldset>
			<legend>
				카테고리 설정<small>(다수선택가능)</small>
			</legend>
			<ul>
				<li><input type="checkbox" name="book_type" id="book_type"
					value="1">IT</li>
				<li><input type="checkbox" name="book_type" id="book_type"
					value="2">과학</li>
				<li><input type="checkbox" name="book_type" id="book_type"
					value="4">역사</li>
			</ul>
		</fieldset>
		<fieldset>
			<legend>
				알림 수신 설정<small>(다수선택가능)</small>
			</legend>
			<ul>
				<li><input type="checkbox" name="notify_type" id="notify_type"
					value="1"> 핸드폰 : <input type="text" name="phone_num"
					id="phone_num" size="18" /></li>
				<li><input type="checkbox" name="notify_type" id="notify_type"
					value="2"> Email : <input type="text" name="email_add"
					id="email_add" size="20" /></li>
			</ul>
		</fieldset>

		<input type="submit" value="등록"> <input type="reset"
			value="초기화"> <input type="button" value="초기화면"
			onclick="location.href='./'">
	</form>
</body>
</html>