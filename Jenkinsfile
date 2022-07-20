pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                checkout scm
                }
            }
        stage('Running Automation') {
            steps {
                // Get some code from a GitHub repository
//                 git 'https://github.com/clement8653/cucumberSelenium.git'

                // sh "printenv"
//                 sh "mvn clean test"

                // To run Maven on a Windows agent, use
                // bat "mvn -Dmaven.test.failure.ignore=true clean package"
            }
        }
        stage('Prepare report'){
            steps{
                publishHTML ([
                    allowMissing: false,
                    alwaysLinkToLastBuild: false,
                    keepAll: true,
                    reportDir: 'target/extent-report',
                    reportFiles: 'report.html',
                    reportName: 'My Report'
                    ])

            }
        }
    }
}
