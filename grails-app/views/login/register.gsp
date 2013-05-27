<%@ page import="collab.todo.User" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'user.label', default: 'User')}" />
		<title>Register</title>
	</head>
	<body>
		<div id="create-user" class="content scaffold-create" role="main">
			<h1>Register for an account</h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<g:hasErrors bean="${userInstance}">
			<ul class="errors" role="alert">
				<g:eachError bean="${userInstance}" var="error">
				<li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
				</g:eachError>
			</ul>
			</g:hasErrors>
			<g:form action="handleRegistration" method="post">
				<fieldset class="form" >
					<table>
						<tbody>
							<tr class="prop">
								<td valign="top" class='nameClear'>
								<label for="username">Username:</label>
								</td>
								<td valign="top" class='valueClear ${hasErrors(bean:user, field:'userName', 'errors')}'>
									<input type="text" name="userName" />
								</td>
							</tr>
							<tr class="prop">
								<td valign="top" class='nameClear'>
								<label for="password">Password:</label>
								</td>
								<td valign="top" class='valueClear ${hasErrors(bean:user, field:'password', 'errors')}'>
									<input type="password" name="password" />
								</td>
							</tr>
							<tr class="prop">
								<td valign="top" class='nameClear'>
								<label for="confirm">Confirm Password:</label>
								</td>
								<td valign="top" class='valueClear ${hasErrors(bean:user, field:'password', 'errors')}'>
									<input type="password" name="confirm" />
								</td>
							</tr>
							<tr class="prop">
								<td valign="top" class='nameClear'>
								<label for="firstName">First Name:</label>
								</td>
								<td valign="top" class='valueClear ${hasErrors(bean:user, field:'firstName', 'errors')}'>
									<input type="text" name="firstName" />
								</td>
							</tr><tr class="prop">
								<td valign="top" class='nameClear'>
								<label for="lastName">Last Name:</label>
								</td>
								<td valign="top" class='valueClear ${hasErrors(bean:user, field:'lastName', 'errors')}'>
									<input type="text" name="lastName" />
								</td>
							</tr>
							<tr class="prop">
								<td valign="top" class='nameClear'>
								<label for="email">Email:</label>
								</td>
								<td valign="top" class='valueClear ${hasErrors(bean:user, field:'email', 'errors')}'>
									<input type="text" name="email" />
								</td>
							</tr>
							<tr class="prop">
								<td valign="top" class='nameClear'>
								<label for="code">Enter Code:</label>
								</td>
								<td valign="top" class='valueClear'>
									<input type="text" name="captcha"><br><br>
									<img src="${createLink(controller:'simpleCaptcha', action: 'captcha')}" />
								</td>
							</tr>
						</tbody>
					</table>
				</fieldset>
				<fieldset class="buttons">
					<g:submitButton name="create" class="save" value="${message(code: 'default.button.register.label', default: 'Register')}" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
