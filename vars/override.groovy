def call(body = null) {
    pipeline {
        agent any
        stages {
		stage ('Clone') {
	        	checkout([$class: 'GitSCM', branches: [[name: '*/main']], doGenerateSubmoduleConfigurations: false, extensions: [], 				submoduleCfg: [], userRemoteConfigs: [[url: 'https://github.com/kumaranraj2895/maven-demo-jib']]])
	        }
            	stage('Build') {
                	steps {
                    		script {
                        		body != null ? body() : BuildStep()
                    		}
                	}
            	}
        }
    }
}

def BuildStep() {
    sh 'maven clean install -f pom.xml'
}
