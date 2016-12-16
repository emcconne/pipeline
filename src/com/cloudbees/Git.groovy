package com.cloudbees;

@Grab("org.codehaus.groovy.modules.http-builder:http-builder:0.7.1")
import groovyx.net.http.HTTPBuilder
import static groovyx.net.http.ContentType.*
import static groovyx.net.http.Method.*
import groovy.json.JsonSlurper

@NonCPS
def getGitHubRepos(user, pass) {
    def http = new HTTPBuilder('http://api.github.com')

    try {
        http.request( 'https://api.github.com', GET, JSON ) { req ->
            uri.path = '/user/repos'
            headers.'Authorization' = "Basic " + "${user}:${pass}".bytes.encodeBase64().toString()
            headers.'User-Agent' = 'Groovy'
            response.success = { resp, json_resp ->
                return json_resp.name
            }
        }
    } catch (exc) {
        println exc.toString()
    }
}