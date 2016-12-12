package com.grebski.grails.linkedin.config

import org.springframework.core.env.Environment

class LinkedInConfig {

    def static final DEFAULT_REDIRECT_URL = 'http://localhost:8080/linkedInLogin'
    final String clientId
    final String clientSecret
    final String redirectUrl

    LinkedInConfig(Environment env) {
        clientId = env.getRequiredProperty('clientId')
        clientSecret = env.getRequiredProperty('clientSecret')
        redirectUrl = Optional.ofNullable(env.getProperty('redirectUrl'))
                .orElse(DEFAULT_REDIRECT_URL)
    }

    String getRedirectUrlEscaped(){
        URLEncoder.encode(redirectUrl, "UTF-8")
    }
}
