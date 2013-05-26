<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main"/>
		<title>CollabTodo</title>
	</head>
	<body>
			<h1>Welcome to Collab-Todo</h1>
			<p>This application is a to-do application written in the Grails framework. 
			It allows users to create and manage todos in categories. Users are also able 
			to create buddy lists of other users of the application and can easily assign 
			tasks to other users. It will also include reports and batch emails, along 
			with some other functionality. Below is a list of controllers that are currently 
			deployed in this application, click on each to execute its default action:</p>

			<div id="controller-list" role="navigation">
				<ul>
					<g:each var="c" in="${grailsApplication.controllerClasses.sort { it.fullName } }">
						<li class="controller"><g:link controller="${c.logicalPropertyName}">${c.fullName}</g:link></li>
					</g:each>
				</ul>
			</div>
	</body>
</html>
