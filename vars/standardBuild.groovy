
def call(Map config=[:], body) {
    body.resolveStrategy = Closure.DELEGATE_FIRST
    body.delegate = config
    println config
    body()
    def mvnHome = tool config.tool
    withEnv([
        "PATH=${mvnHome}/bin:${env.PATH}"
    ]) {
	    stage('checkout') {
	        checkout scm
	    }
	    stage('main') {
	        sh config.mainScript
	    }
	    stage('post') {
	    	sh config.postScript
	    }
	}
}
