pipeline {
    agent any

    // tools {
    //     // Install the Maven version configured as "M3" and add it to the path.
    //     maven "M3"
    // }

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

                // Run Maven on a Unix agent.
                // sh "printenv"
                sh "mvn clean test"

                // To run Maven on a Windows agent, use
                // bat "mvn -Dmaven.test.failure.ignore=true clean package"
            }

            post {
                // If Maven was able to run the tests, even if some of the test
                // failed, record the test results and archive the jar file.
                // success {
                //     junit '**/target/surefire-reports/TEST-*.xml'
                //     archiveArtifacts 'target/*.jar'
                // }
                always{
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
}
