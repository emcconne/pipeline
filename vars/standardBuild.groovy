
def call(body) {
    def config = [:]
    body.resolveStrategy = Closure.DELEGATE_FIRST
    body.delegate = config
    body()
    stage('checkout') {
		def mvnHome = tool config.tool
	    withEnv([
            "PATH=${mvnHome}/bin:${env.PATH}"
        ])
	    node {
	        checkout scm
	        stage('main') {
		        sh config.mainScript
		    }
	        stage('post') {
	        	sh config.postScript
	        }
	    }
	}
}
