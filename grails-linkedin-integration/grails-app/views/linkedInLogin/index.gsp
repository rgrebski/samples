<html>
<g:if test="${params.code != null}">
    Logged user info: ${loggedUserInfo}
</g:if>
<g:else>
    "code" request param missing
</g:else>
</html>