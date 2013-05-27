<html>
<head>
	<title>Login Page</title>
	<meta name="layout" content="main"/>
</head>

<body>
	<g:if test="${flash.message}">
		<div class="message">
			${flash.message}
		</div>
	</g:if>
	<p>
		Welcome to your Todo List. Login below:
	</p><br>
	<g:form action="handleLogin" method="post">
		<table>
		<tr>
			<td><label for="login">Username:</label></td>
			<td><g:textField name="userName" value='${params.userName }' /></td>
		</tr>
		<tr>
			<td><label for="password">Password:</label></td>
			<td><g:passwordField name="password" value='' /></td>
		<tr>
		</table>
		<g:actionSubmit value="Login" action="handleLogin" />
	</g:form>
</body>
</html>