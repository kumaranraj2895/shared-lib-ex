def call(body) {
def config = [:]
    body.resolveStrategy = Closure.DELEGATE_FIRST
    body.delegate = config
    body()

    node {
        agent any
       
		stage ('Clone') {
	        	checkout([$class: 'GitSCM', branches: [[name: '*/main']], doGenerateSubmoduleConfigurations: false, extensions: [], 				submoduleCfg: [], userRemoteConfigs: [[url: 'https://github.com/kumaranraj2895/maven-demo-jib']]])
	        }
            	stage('Build') {
                        	body() : BuildStep()
                    }
    	}
}

def BuildStep() {
    sh 'maven clean install -f pom.xml'
}
