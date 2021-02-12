def call(body = null) {
    node {
        agent any
            stage ("checkout") {
      			checkout([$class: 'GitSCM', branches: [[name: '*/main']], doGenerateSubmoduleConfigurations: false, extensions: [], 				submoduleCfg: [], userRemoteConfigs: [[url: 'https://github.com/kumaranraj2895/maven-demo-jib']]])
    	}
	    stage ("install") {
        		BuildStep()
    	}
    }
}

def BuildStep() {
    stage ("install") {
        sh "mvn install -f pom.xml" 
    }
}
