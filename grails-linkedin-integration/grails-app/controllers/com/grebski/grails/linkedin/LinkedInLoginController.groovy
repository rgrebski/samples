package com.grebski.grails.linkedin

class LinkedInLoginController {

    def linkedInLoginService

    def index() {
        def linkedInAuthCode = params.code

        if(linkedInAuthCode != null){
            def token = linkedInLoginService.getTokenFromLinkedIn(linkedInAuthCode)
        }else {
            return [error: 'Missing code query param']
        }

    }

}