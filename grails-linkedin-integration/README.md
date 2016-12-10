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