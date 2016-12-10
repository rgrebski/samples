package com.grebski.grails.linkedin

class IndexController {

    def linkedInConfig

    def index() {
        [clientId: linkedInConfig.clientId]
    }
}
