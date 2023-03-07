def gitCheckout(Map params) {
 
checkout scmGit(branches: [[name: params.branch]], extensions: [], userRemoteConfigs: [[credentialsId: params.credentials, url: params.url]])
}
