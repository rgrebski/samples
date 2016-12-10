package com.grebski.grails.linkedin

import org.apache.commons.lang.RandomStringUtils

class IndexController {

    private static String linkedInLoginUrl = "https://www.linkedin.com/oauth/v2/authorization?response_type=code" +
            "&client_id=77zhc7lm079p0z" +
            "&redirect_uri=http%3A%2F%2Flocalhost:8080%2FlinkedInLogin" +
            "&scope=r_basicprofile"


    def linkedInConfig

    def index() {
        [
                clientId        : linkedInConfig.clientId,
                state           : RandomStringUtils.randomAlphabetic(10),
                linkedInLoginUrl: linkedInLoginUrl
        ]
    }
}
