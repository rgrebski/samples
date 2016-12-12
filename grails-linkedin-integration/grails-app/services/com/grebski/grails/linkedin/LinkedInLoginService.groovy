package com.grebski.grails.linkedin

import com.fasterxml.jackson.databind.ObjectMapper
import com.grebski.grails.linkedin.dto.AccessTokenDto
import com.grebski.grails.linkedin.dto.LinkedInUserInfoDto
import grails.plugins.rest.client.RestBuilder
import grails.plugins.rest.client.RestResponse
import groovy.json.JsonOutput
import org.grails.web.json.JSONElement

import static javax.servlet.http.HttpServletResponse.SC_OK

class LinkedInLoginService {

    private static final String GET_ACCESS_TOKEN_URL = "https://www.linkedin.com/oauth/v2/accessToken"
    private static final String GET_USER_INFO_URL = "https://api.linkedin.com/v1/people/~" +
            ":(id,first-name,last-name,headline,email-address,picture-url,industry,site-standard-profile-request,interests,summary,main-address,phone-numbers,skills:(skill))" +
            "?format=json"

    def linkedInConfig
    def objectMapper = new ObjectMapper()

    AccessTokenDto getTokenFromLinkedIn(String authCode) {
        RestResponse resp = postGetAccessToken(authCode)
        verifyRespStatusOK(resp)

        def json = resp.json
        prettyLogJsonIfDebugEnabled(json)

        objectMapper.readValue(json.toString(), AccessTokenDto)
    }

    private void prettyLogJsonIfDebugEnabled(JSONElement json) {
        if (log.isDebugEnabled()) {
            def prettyJson = JsonOutput.prettyPrint(json.toString()).stripIndent()
            log.debug("Received auth code: \n$prettyJson")
        }
    }

    private void verifyRespStatusOK(RestResponse resp) {
        if (resp.status != SC_OK) {
            throw new IllegalStateException("Could not authorize using oauth: " + resp.json)
        }
    }

    private RestResponse postGetAccessToken(String authCode) {
        RestBuilder rest = new RestBuilder()
        Map<String, String> queryParams = [:]
        queryParams.put('client_id', linkedInConfig.clientId)
        queryParams.put('client_secret', linkedInConfig.clientSecret)
        queryParams.put("grant_type", "authorization_code")
        queryParams.put("redirect_uri", linkedInConfig.redirectUrl)
        queryParams.put("code", authCode)


        def queryParamsString = queryParams.collect {"$it.key=$it.value"}.join("&")
        def getAccessTokenUrl = "$GET_ACCESS_TOKEN_URL?$queryParamsString"
        def resp = rest.get(getAccessTokenUrl) {
            auth(linkedInConfig.clientId, linkedInConfig.clientSecret)
            accept("application/json")
        }
        resp
    }

    def getUserInfo(String accessToken) {
        RestBuilder rest = new RestBuilder()
        def resp     = rest.get(GET_USER_INFO_URL) {
            header('Authorization', "Bearer $accessToken")
        }

        verifyRespStatusOK(resp)
        def jsonString = resp.json.toString()
        objectMapper.readValue(jsonString, LinkedInUserInfoDto)
    }
}
