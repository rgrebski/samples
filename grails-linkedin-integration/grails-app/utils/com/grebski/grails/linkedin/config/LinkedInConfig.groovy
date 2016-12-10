package com.grebski.grails.linkedin.config

import org.springframework.core.env.Environment

class LinkedInConfig {
    final String clientId
    final String clientSecret

    LinkedInConfig(Environment env){
        clientId = env.getProperty('clientId')
        clientSecret = env.getProperty('clientSecret')
    }
}
