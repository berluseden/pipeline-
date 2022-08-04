def createDeploymentJob(jobName, repoUrl) {
    pipelineJob(jobName) {
        definition {
            cpsScm {
                scm {
                    git {
                        remote {
                            url(repoUrl)
                        }
                        branches('master')
                        extensions {
                            cleanBeforeCheckout()
                        }
                    }
                }
                scriptPath("Jenkinsfile")
            }
        }
    }
}


def buildPipelineJobs() {
    def repo = "https://github.com/berluseden/"
    def repoUrl = repo + jobName + ".git"
    def deployName = jobName + "_deploy"

    createDeploymentJob(deployName, repoUrl)
}

buildPipelineJobs()
