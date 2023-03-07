pipeline {

    agent any 

    parameters {
        choice choices: ['dev', 'prod'], description: '', name: 'env'
    }

    stages {
        stage("Deployment 1") {
            when {
                    expression { params.env == 'dev' }
                }
            
            steps {
                echo "Deployment on $params.env"
            }
        }
        stage("Deployment 2") {
            steps {
                script {
                    if ( params.env == "dev" ) {
                        echo "Deployment on $params.env"
                    }
                }
            }
        }
        

    }
}
