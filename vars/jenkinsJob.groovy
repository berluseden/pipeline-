def call(Map pipelineParams) {
    pipeline {
        agent any
        
       stages('Checkout') {
            checkout scm
        }

       stage {
            stage('docker build') {
                steps {
                    script {
                        dockerLib.build(DockerfilePath: pipelineParams.dockerfilePath,
                                        DockerImage: pipelineParams.dockerImage,
                                        
                    }
                }
            }
            stage('docker push') {
                steps {
                    script {
                        dockerLib.push(DockerImage: pipelineParams.dockerImage)
                    }
                }
            }
        }
    }
}
