<html>
<g:if test="${params.code != null}">
    Auth code: ${params.code}
</g:if>
<g:else>
    "code" request param missing
</g:else>
</html>