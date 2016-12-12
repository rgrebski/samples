package com.grebski.grails.linkedin

import org.apache.commons.lang.RandomStringUtils

import javax.annotation.PostConstruct

class IndexController {

    private String linkedInLoginUrl


    def linkedInConfig

    @PostConstruct
    public void init(){
        def redirectUrlEscaped = linkedInConfig.redirectUrlEscaped
        linkedInLoginUrl = "https://www.linkedin.com/oauth/v2/authorization?response_type=code" +
                "&client_id=$linkedInConfig.clientId" +
                "&redirect_uri=$redirectUrlEscaped" +
                "&scope=r_basicprofile%20r_emailaddress"
    }

    def index() {
        [
                clientId        : linkedInConfig.clientId,
                state           : RandomStringUtils.randomAlphabetic(10),
                linkedInLoginUrl: linkedInLoginUrl
        ]
    }
}
