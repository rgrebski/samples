package com.grebski.grails.linkedin

class IndexController {

    private static String redirectUrl = 'http%3A%2F%2Flocalhost:8080%2FlinkedInLogin'
    def index() {
        [linkedInUrl: generateLinkedInUrl()]
    }

    def generateLinkedInUrl() {
        "https://www.linkedin.com/oauth/v2/authorization?response_type=code" +
                "&client_id=77zhc7lm079p0z" +
                "&redirect_uri=$redirectUrl" +
                "&scope=r_basicprofile"
    }
}
