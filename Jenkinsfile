pipeline {
   agent any
    tools{
        maven "MavenTest"
        git "GitTest"
    }
    stages {
        stage('Build') {
            steps {
                echo "It's Build"
                git credentialsId: 'bfc5b87d-aabf-46a5-ac48-25441e07561a', url: 'https://github.com/mgengalycheva/habrProjectUI'
                echo "Stop build"
            }
        }
		stage('Clean') {
            steps {
                echo "tests execute"
                sh 'mvn clean'
            }
        }
		stage('Test') {
            steps {
                echo "tests run"
                sh 'mvn test'

            }
        }
        stage('results') {
            steps {
                echo 'tests execution'
                allure([
                    includeProperties: false,
                    jdk: '',
                    properties: [],
                    reportBuildPolicy: 'ALWAYS',
                    results: [[path: 'target/allure-results']]
                ])
            }
        }
    }
    post {
        always {
                  /* mail to: 'mari.kamar@gmail.com',
                  subject: "Status of pipeline: ${currentBuild.fullDisplayName}",
                  body: "${env.BUILD_URL} has result ${currentBuild.result}" */
            emailext body: 'A Test EMail', recipientProviders: [[$class: 'DevelopersRecipientProvider'], [$class: 'RequesterRecipientProvider']], subject: 'Test'
            //emailext body: '$PROJECT_NAME - Build # $BUILD_NUMBER - $BUILD_STATUS', recipientProviders: [[$class: 'DevelopersRecipientProvider'], [$class: 'RequesterRecipientProvider']], subject: 'Test'
        }
    }
}