<!DOCTYPE HTML>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <title>Getting Started: Handling Form Submission</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
</head>
<body>
	Your hobbies: <br/>

	<%= request.getParameter("UserHobbies") %>
	<br/>
	<a href="/hobbies">Save hobbies</a>
	<a href="/search">Search user hobbies</a>
</body>

</html>
