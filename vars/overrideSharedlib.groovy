def call(body = null) {
    node {
        agent any
            stage('Build') {
                        body != null ? body() : PostBuildStep()
            }
    }
}

def PostBuildStep() {
    echo 'Running default post-build step';
}
