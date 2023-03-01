<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Color testing</title>
<%
String color = request.getParameter("bgColor");
if (color == null || color == "") {
	out.println("Please enter some colour");
	color = "white";
}
%>

</head>
<body bgcolor="<%=color%>">
	<form>

		<h2>Trying background color dynamically!!</h2>
		<input type="text" placeholder="enter your color" name="bgColor">
		<input type="submit" value="Try this color">

	</form>
</body>
</html>