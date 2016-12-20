
def call(body) {
    def config = [:]
    body.resolveStrategy = Closure.DELEGATE_FIRST
    body.delegate = config
    stage('checkout') {
	    node {
	    	def mvnHome = tool config.tool
		    withEnv([
	            "PATH=${mvnHome}/bin:${env.PATH}"
	        ])
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
