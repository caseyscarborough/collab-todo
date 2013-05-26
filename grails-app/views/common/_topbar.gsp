<div id="menu">
	<nobr>
		<a href="/collab-todo">Home</a>
		<g:if test="${session.user}">
			<g:link controller="user" action="logout">Logout</g:link>
			<g:link controller="user" action="show" id="${session.user?.id}">${session.user?.firstName}&nbsp;${session.user?.lastName}</g:link>
		</g:if>
		<g:else>
			<g:link controller="user" action="login">Login</g:link>
		</g:else>
	</nobr>
</div>