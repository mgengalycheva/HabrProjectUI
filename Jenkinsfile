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
                git credentialsId: '3c34ed55-4061-46f9-83d9-9e22653d6144', url: 'https://github.com/mgengalycheva/habrProjectUI'
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
            emailext body: '$PROJECT_NAME - Build # $BUILD_NUMBER - $BUILD_STATUS', recipientProviders: [[$class: 'DevelopersRecipientProvider'], [$class: 'RequesterRecipientProvider']], subject: 'Test'
        }
    }
}