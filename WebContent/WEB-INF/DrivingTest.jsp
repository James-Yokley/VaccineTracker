<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>DrivingTest</title>
</head>
<body>
<h2>Driving Test</h2>
<p>${questions[index].description}</p>
<ol>
	<li>${questions[index].answerA}</li>
	<li>${questions[index].answerB}</li>
	<li>${questions[index].answerC}</li>
</ol>
	<p>Correct answer: ${questions[index].correctAnswer}</p>
	
	<a href="DrivingTestBrowser?questionIndex=${index + 1}">Next</a>	
	
</body>
</html>