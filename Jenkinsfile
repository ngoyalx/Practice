pipeline {
    stages{
        stage('Code Checkout'){
            steps{
                 echo 'code checkout'
            }
           

        }

        stage('Integration Test'){
            steps{
                echo 'Integration test'
            }

        }
    }
    post{
        steps{
            echo 'allure report generation'
        }
    }
}
