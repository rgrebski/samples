package com.grebski.grails.linkedin.config

import org.springframework.core.env.Environment

import static com.google.common.base.Preconditions.checkNotNull

class LinkedInConfig {
    final String clientId
    final String clientSecret

    LinkedInConfig(Environment env){
        clientId = env.getProperty('clientId')
        clientSecret = env.getProperty('clientSecret')

        checkNotNull(clientId, 'Missing property clientId')
        checkNotNull(clientSecret, 'Missing property clientSecret')
    }
}
