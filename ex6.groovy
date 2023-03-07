pipeline {
    agent any
    
    environment {
      creds = "github_michalk"
      url = "https://github.com/diablo248/repo_jenkins.git"
      username = "abcd"
      branch = "main"
      mail = "ala@ma_kota.pl"
      repo = "diablo248/repo_jenkins"

    }

    stages {
        stage("Checkout") {
            steps {
                script {
                    scmUtils.gitCheckout(
                        branch: env.branch,
                        url: env.url,
                        credentials: env.creds
                    )
                }  
            }
        }
        stage("Do something") {
            steps {
                sh "echo `12345` > file.txt"
            }
        }

        stage("Set/Add/Upload") {
            steps {
                script {
                    scmUtils.setGitUserInfo(
                        user: env.username,
                        mail: env.mail
                        )  

                    scmUtils.gitCommit (
                      path: "file.txt",
                      msg: "New commit"
                      )
                        
                    scmUtils.gitPush(
                        credentialsId: env.creds, 
                        gitHubPath: env.repo)
                    }
                    
                }
            }
        }
}
