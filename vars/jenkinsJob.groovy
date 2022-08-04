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
        sh 'docker build -t berluseden/demojenkins:latest .'
        sh 'docker push berluseden/demojenkins:latest'
    }
}

def buildAndTest(){
    stage("Backend tests"){
        sh "mvn test"
    }
}
