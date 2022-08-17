def call(){
    node {
        stage('Checkout') {
            checkout scm
        }

        // Execute different stages depending on the job
        if(env.JOB_NAME.contains("deploy")){
            packageArtifact()
        } else if(env.JOB_NAME.contains("test")) {
            buildAndTest()
        }
    }
}

def packageArtifact(){
    stage("Package artifact") {
        sh 'docker build -t berluseden/demojenkins:1.0.0-${BUILD_ID} .'
        sh 'docker push berluseden/demojenkins:1.0.0-${BUILD_ID}'
    }
}

def buildAndTest(){
    stage("Backend tests"){
        sh 'docker build -t berluseden/demojenkins:1.0.0-${BUILD_ID} .'
        sh 'docker push berluseden/demojenkins:1.0.0-${BUILD_ID}'
    }
}
