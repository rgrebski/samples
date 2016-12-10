package com.grebski.grails.linkedin.dto

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import groovy.transform.ToString

@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
class LinkedInUserInfoDto {
    String firstName
    String lastName
    String industry
    String pictureUrl
    String summary
    String emailAddress
}
