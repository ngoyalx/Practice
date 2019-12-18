pipeline {
    agent any
    stages{
        stage('Code Checkout'){
            steps{
                 echo 'code checkout'
                 checkout([$class: 'GitSCM'
                 , branches: [[name: '*/master']]
                 , doGenerateSubmoduleConfigurations: false
                 , extensions: [], submoduleCfg: []
                 , userRemoteConfigs: [[credentialsId: '573f6c34-87da-46d3-8115-d6c8a77f9bd0', url: 'https://github.com/ngoyalx/Practice.git']]])
                 echo 'checkout complete'
            }
        }
        stage('Integration Test'){
            steps{
                echo 'Integration test'
            }
        }
    }
}
