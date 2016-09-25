<!DOCTYPE HTML>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <title>Getting Started: Handling Form Submission</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
</head>
<body>
	Hobbies:<br/>
	<form action = "/hobbiesResult" method="POST">
		<input type="text" placeholder="username" name="username"><br/>
		<textarea rows="4" cols="50" name="UserHobbies" placeholder="Enter your hobbies here..."></textarea>
		<br/>
		<input type="submit" value="Submit" /> <input type="reset" value="Reset" /></p>
		
	</form>
	
</body>

</html>
