pipeline {
    agent none
    stages {
        stage('STAGE A') {
            input {
              message 'Should we proceed ?'
              submitter 'michal_kochanowski'
            }
            agent any
            steps {
                echo "Test"
            }
        }
		stage ('STAGE B') {
            parallel {
                stage('STAGE C') {
                    agent any
                    steps {
                        echo "STAGE C"
                    }
                }
                stage('STAGE D') {
                    agent any
                    steps {
                        echo "STAGE D"
                        sh 'exit 1'

                    }
                }
                stage ('STAGE E') {
                    agent any
                    steps {
                        echo "STAGE D"
                    }
                }
        }
    }
}
}
