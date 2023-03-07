pipeline {
    agent {
        label "slave01"
    }
    
    stages {
        stage("Pull image 1") {
            steps {
                script {
                        def image = docker.image("openjdk:11")
                        image.pull()
                    }
                }
            }
        stage("Pull image 2") {
            steps {
                script {
                    try {
                        def image = docker.image("openjdk:fuck")
                        image.pull()
                    }
                    catch (Exception e) {
                        println "exception ${e}"
                        currentBuild.result = 'UNSTABLE'
                    }
                }
            }
        }
    }
}
