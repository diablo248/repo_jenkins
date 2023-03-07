def gitCheckout(Map params) {
    checkout scmGit(branches: [[name: params.branch]], extensions: [], userRemoteConfigs: [[credentialsId: params.credentials, url: params.url]])
}

def setGitUserInfo((Map params) {
  sh "git config --global user.name ${params.user}"
  sh "git config --global user.email ${params.mail}"
}
                   
def gitCommit(Map params) {
  sh "git add ${params.path}"
  sh "git commit -m ${params.msg}"
}
