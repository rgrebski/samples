package com.grebski.grails.linkedin.dto

import groovy.transform.ToString

@ToString
class AccessTokenDto {
    String access_token
    Long expires_in
}
