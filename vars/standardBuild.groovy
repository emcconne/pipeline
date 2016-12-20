// defined in vars/standardBuild.groovy of repo

// body parm is a closure
def call(body) { 
	def config =[:]
	body.resolveStrategy = Closure.DELEGATE_FIRST
	body.delegate = config
	body.call()
	println config.type
	body.postBuildAction.call()
}