def call(body) {
    def config = [:]
    body.resolveStrategy = Closure.DELEGATE_FIRST
    body.delegate = config
    body()

    node {
	    try {
	        stage ('Clone') {
	        	checkout([$class: 'GitSCM', branches: [[name: '*/main']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[url: 'https://github.com/kumaranraj2895/maven-demo-jib']]])
	        }
	        stage ('install') {
	        	sh "mvn install -f pom.xml"
	        }
	    } catch (err) {
	        currentBuild.result = 'FAILED'
	        throw err
	    }
    }
}


