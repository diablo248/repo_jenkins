pipeline {
    agent any
    parameters {
        string defaultValue: 'bbb', name: 'env2'
    }
    stages {
        stage("First") {
            steps {
                echo "${params.env2}"
            }
            
        }
    }
}
