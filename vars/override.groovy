def call(body = null) {
    node {
        agent any
       
		stage ('Clone') {
	        	checkout([$class: 'GitSCM', branches: [[name: '*/main']], doGenerateSubmoduleConfigurations: false, extensions: [], 				submoduleCfg: [], userRemoteConfigs: [[url: 'https://github.com/kumaranraj2895/maven-demo-jib']]])
	        }
            	stage('Build') {
                    		script {
                        		body != null ? body() : BuildStep()
                    	}
            	}
    }
}

def BuildStep() {
    sh 'maven clean install -f pom.xml'
}
