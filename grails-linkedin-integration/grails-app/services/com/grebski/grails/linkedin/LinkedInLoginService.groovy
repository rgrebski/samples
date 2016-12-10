package com.grebski.grails.linkedin

import grails.plugins.rest.client.RestBuilder
import grails.plugins.rest.client.RestResponse
import groovy.json.JsonOutput
import org.grails.web.json.JSONElement
import org.springframework.util.LinkedMultiValueMap
import org.springframework.util.MultiValueMap

import static javax.servlet.http.HttpServletResponse.SC_OK

class LinkedInLoginService {

    def linkedInConfig

    private static final String REDIRECT_URI = 'http://localhost:8080/linkedInLogin'
    private static final String GET_ACCESS_TOKEN_URL = "https://www.linkedin.com/oauth/v2/accessToken"

    def getTokenFromLinkedIn(String authCode) {
        RestResponse resp = postGetAccessToken(authCode)
        verifyRespStatusOK(resp)

        def json = resp.json
        prettyLogJsonIfDebugEnabled(json)

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
        MultiValueMap<String, String> form = new LinkedMultiValueMap<String, String>()
        form.add("grant_type", "authorization_code")
        form.add("code", authCode)
        form.add("redirect_uri", REDIRECT_URI)
        form.add('client_id', linkedInConfig.clientId)
        form.add('client_secret', linkedInConfig.clientSecret)

        def resp = rest.post(GET_ACCESS_TOKEN_URL) {
            auth(linkedInConfig.clientId, linkedInConfig.clientSecret)
            accept("application/json")
            contentType("application/x-www-form-urlencoded")
            body(form)
        }
        resp
    }
}
