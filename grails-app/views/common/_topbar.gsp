<div id="menu">
	<nobr>
		<g:link controller='home'>Home</g:link>
		<g:link controller="todo">Todos</g:link>
		<g:link controller="category">Categories</g:link>
		<g:if test="${session.user}">
			<g:link controller="user" action="show" id="${session.user?.id}">Account</g:link>
			<g:link controller="login" action="logout">Logout</g:link>
		</g:if>
		<g:else>
			<g:link controller="login">Login</g:link>
		</g:else>
	</nobr>
</div>