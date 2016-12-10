<%@ page import="com.grebski.grails.linkedin.IndexController" %>
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
    <h2>
        <a href="${linkedInUrl}">
            <img src="https://content.linkedin.com/content/dam/developer/global/en_US/site/img/signin-button.png" style="width: 100%"/>
        </a>
    </h2>
</div>

</body>
</html>
