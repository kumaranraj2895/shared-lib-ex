def call(body = null) {
    pipeline {
        agent any
        stages {
            stage('Build') {
                steps {
                    script {
                        body != null ? body() : PostBuildStep()
                    }
                }
            }
        }
    }
}

def PostBuildStep() {
    echo 'Running default post-build step';
}
