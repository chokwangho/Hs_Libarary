<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ page session="false"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Home</title>
<style>
</style>
</head>
<body style="background: #FFFFFF">
	<h1>조광호님의 페이지</h1>

	<ul type="disc">
		<li style="margin-bottom: -15;"><h2>사용자가 설정한 알림 설정값</h2></li>
		<table border=2>
			<th width="100">이름</th>
			<th width="100">분야</th>
			<th width="150">알림 종류</th>
			<th width="100">휴대폰 번호</th>
			<th width="150">이메일</th>
			<c:forEach items="${ recommandInfos }" var="recommandInfo">
				<tr align="center">
					<td><c:out value="${ recommandInfo.getName() }" /></td>
					<td><c:out value="${ recommandInfo.getBook_type_str() }" /></td>
					<td><c:out value="${ recommandInfo.getNotify_type_str() }" /></td>
					<td><c:out value="${ recommandInfo.getPhone_num() }" /></td>
					<td><c:out value="${ recommandInfo.getEmail() }" /></td>
				</tr>
			</c:forEach>
		</table>
	</ul>

	<ul type="disc">
		<li style="margin-bottom: -15;"><h2>도서관의 책정보</h2></li>
		<table border=2>
			<th width="100">책 번호</th>
			<th width="100">책 구분</th>
			<th width="150">젝 제목</th>
			<th width="100">저자</th>
			<th width="50">출판년도</th>
			<c:forEach items="${ bookInfos }" var="bookInfo">
				<tr align="center">
					<td><c:out value="${ bookInfo.getBook_code() }" /></td>
					<td><c:out value="${ bookInfo.getBook_type() }" /></td>
					<td><c:out value="${ bookInfo.getTitle() }" /></td>
					<td><c:out value="${ bookInfo.getAuthor() }" /></td>
					<td><c:out value="${ bookInfo.getPublish() }" /></td>
				</tr>
			</c:forEach>
		</table>
	</ul>

	<input type="button" value="희망도서 신청" onclick="location.href='./addBook'">
	<input type="button" value="신간도서 알림설정"
		onclick="location.href='./newArrival'">
</body>
</html>
