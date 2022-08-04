job('DockerBuildandPublishDSL') {
     scm {
        git {
        remote {
                url('https://github.com/berluseden/nodeapp_test.git')
            }
            wrappers {
                preBuildCleanup()
            } 
            branch('*/' + 'master')
        }
    }

    steps {
        dockerBuildAndPublish {
            repositoryName('berluseden/demojenkins')
            registryCredentials('dockerhub')
        }
    }
