package com.grebski.grails.linkedin

import grails.boot.GrailsApp
import grails.boot.config.GrailsAutoConfiguration
import org.springframework.context.annotation.PropertySource

/*
Credentials file should look like this:
clientId=yourLinkedInOauthClientId
clientSecret=yourLinkedInOauthSecret
 */
@PropertySource(value = "file:\${user.home}/linkedin-oauth-credentials.properties", ignoreResourceNotFound = true)
class Application extends GrailsAutoConfiguration {
    static void main(String[] args) {
        GrailsApp.run(Application, args)
    }
}