pipeline {
    agent {
        label "slave01"
    }
    options {
      buildDiscarder logRotator(artifactDaysToKeepStr: '', artifactNumToKeepStr: '', daysToKeepStr: '3', numToKeepStr: '7')
      timeout(5)
      timestamps()
    }
    environment {
      ENV1 = "aaaa"
      ENV2 = "bbb"
    }

    stages {
        stage("Check envs") {
            steps {
              println "EN1 = ${ENV1} ENV2=${ENV2}"
            }

        }

        stage("Timeout") {
            options {
                timeout(time: 30, unit: 'SECONDS')
            }
            steps {
                  sleep(1)
            }
        }
    }
    post {
        // Clean after build
        always {
            cleanWs()
        }
    }
}
