package com.grebski.grails.linkedin

class UrlMappings {

    static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

        "/"(controller: "index", view: "/index", action: "index")
        "/linkedInLogin" (view: "/linkedInLogin", controller: "linkedInLogin", action: "index")
        "500"(view:'/error')
        "404"(view:'/notFound')
    }
}
