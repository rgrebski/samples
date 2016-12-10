package com.grebski.grails.linkedin

class LinkedInLoginController {

    def linkedInLoginService

    def index() {
        def linkedInAuthCode = params.code


        if(linkedInAuthCode != null){
            def token = linkedInLoginService.getTokenFromLinkedIn(linkedInAuthCode)
            def userInfo = linkedInLoginService.getUserInfo(token.access_token)
            chain(action: "showUserInfo", model: [userInfo: userInfo])
        }
    }

    def showUserInfo(){
        [userInfo: chainModel['userInfo']]
    }
}