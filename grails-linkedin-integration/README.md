# Grails - integration with LinkedIn (OAuth2)

## Configuration
1) Application.groovy - change oauth credentials location
```java
@PropertySource("file:/home/rgrebski/linkedin-oauth-credentials.properties")
```

File should look like this:
```
clientId=xxxx
clientSecret=xxxx
```

## Docker Image
You can run sample from docker:
```
docker run -p 8080:8080 -e "clientId=yourClientId" -e "clientSecret=yourClientSecret" -e "redirectUrl=yourRedirectUrl" rgrebski/grails-linkedin-integration
```

ClientId and secret should be obtained from LinkedIn, when creating new OAuth2 application, redirectUrl should be set in LinkedIn app settings