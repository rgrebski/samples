<html>

<body>
<table class="table table-bordered">
    <thead></thead>
    <tbody>
    <tr>
        <td>First Name</td>
        <td>${userInfo.firstName}</td>
    </tr>
    <tr>
        <td>Last Name</td>
        <td>${userInfo.lastName}</td></tr>
    <tr>
        <td>Email</td>
        <td>${userInfo.emailAddress}</td>
    </tr>
    <tr>
        <td>Industry</td>
        <td>${userInfo.industry}</td>
    </tr>
    <tr>
        <td>Summary</td>
        <td>${userInfo.summary}</td>
    </tr>
    <tr>
        <td>Picture</td>
        <td><img src="${userInfo.pictureUrl}" /></td>
    </tr>
    </tbody>
</table>
</body>
</html>