pipeline {

    agent any 

    stages {
        stage("Test trigger post") {
            steps {
                sh "exit 1"
            }
            post {
              failure {
                build job: 'exercise-declarative-pipeline-triggers_downstream', parameters: [
                string(name: 'env2', value: "HAHAHA")]
              }
            }
        }
    }

}
