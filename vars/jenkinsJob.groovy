def call(){
    node {
        stage('Checkout') {
            checkout scm
        }

        // Execute different stages depending on the job
        if(env.JOB_NAME.contains("deploy")){
            dockerBuildAndPublish()
        } else if(env.JOB_NAME.contains("test")) {
            buildAndTest()
        }
    }
}

def dockerBuildAndPublish(){
    stage("dockerBuild") {
        sh 'docker build -t berluseden/demojenkins:1.0.0-${BUILD_ID} .'
        sh 'docker push berluseden/demojenkins:1.0.0-${BUILD_ID}'
    }
}
