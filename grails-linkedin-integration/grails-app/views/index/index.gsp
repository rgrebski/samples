<%@ page import="com.grebski.grails.linkedin.config.LinkedInConfig; com.grebski.grails.linkedin.IndexController" %>
<!doctype html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Linked In Login Sample</title>

    <asset:link rel="icon" href="favicon.ico" type="image/x-ico"/>
</head>

<body>
%{--<content tag="nav">--}%
%{--</content>--}%

<div class="container">

    <div class="col-md-offset-5 col-md-2">
        <form class="form-signin">
            <h2 class="form-signin-heading">Please sign in</h2>
            <label for="inputEmail" class="sr-only">Email address</label>
            <input type="email" id="inputEmail" class="form-control" placeholder="Email address" required autofocus>
            <label for="inputPassword" class="sr-only">Password</label>
            <input type="password" id="inputPassword" class="form-control" placeholder="Password" required>

            <div class="checkbox">
                <label>
                    <input type="checkbox" value="remember-me"> Remember me
                </label>
            </div>
            <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>

        </form>
    </div>

</div> <!-- /container -->
<div class="col-md-offset-5 col-md-2">

    <form action="https://www.linkedin.com/uas/oauth2/authorization" method="post">
        <input type="hidden" name="response_type" value="code"/>
        <input type="hidden" name="redirect_uri" value="http://localhost:8080/linkedInLogin"/>
        <input type="hidden" name="client_id" value="${clientId}"/>
        <input type="hidden" name="state" value="assumeImRandom2:)"/>


        <input type="submit" value="Login with LinkedIn" class="lnk"/>
    </form>
</div>

</body>
</html>
