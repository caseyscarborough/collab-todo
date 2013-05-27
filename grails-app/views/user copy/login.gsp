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
		<span class="nameClear">
			<label for="login">Username:</label>
		</span>
		<g:textField name="userName" value='${params.userName }' /><br><br>
		<span class="nameClear">
			<label for="password">Password:</label>
		</span>
		<g:passwordField name="password" value='' />
		<br><br>
			<g:actionSubmit value="Login" action="handleLogin" />
	</g:form>
</body>
</html>