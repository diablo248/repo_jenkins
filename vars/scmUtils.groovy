def gitCheckout(Map params) {
    checkout([
        $class: 'GitSCM',
        branches: [[name:  params.branch ]],
        userRemoteConfigs: [[ url: params.url, credentialsId: params.credentials ]],
        extensions: [[$class: 'LocalBranch']]
    ])
}

def setGitUserInfo(Map params) {
  sh "git config --global user.name ${params.user}"
  sh "git config --global user.email ${params.mail}"
}
                   
def gitCommit(Map params) {
  sh "git add ${params.path}"
  sh "git commit -m '${params.msg}'"
}

def gitPush(Map params) {
    withCredentials([usernamePassword(credentialsId: params.credentials, usernameVariable: 'user', passwordVariable: 'passwd')])
      {
          sh "git push --set-upstream https://${passwd}@github.com/${params.gitHubPath}.git ${params.branch}"
      }
}
