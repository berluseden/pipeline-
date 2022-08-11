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

    stage('dockerBuild') {
                    
                    dockerBuildAndPublish()
                }
