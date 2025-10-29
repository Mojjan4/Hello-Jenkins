pipeline {
    agent any

    environment {
            ANDROID_HOME = '/home/testtestsson/Android/Sdk'
            PATH = "$PATH:$ANDROID_HOME/cmdline-tools/latest/bin:$ANDROID_HOME/platform-tools"

    stages {
        stage('Checkout') {
            steps {
                // Pull the latest code from your GitHub repo
                git branch: 'main', url: 'https://github.com/Mojjan4/Hello-Jenkins.git'
            }
        }

        stage('Build Debug APK') {
            steps {
                // Clean old builds and compile the app
                sh './gradlew clean assembleDebug'
            }
        }

        stage('Run Unit Tests') {
            steps {
                // Run your Kotlin test suite
                sh './gradlew testDebugUnitTest'
            }
        }
    }

    post {
        always {
            echo '--- Pipeline completed ---'
        }
        success {
            echo '✅ Build and tests succeeded!'
        }
        failure {
            echo '❌ Build or tests failed! Check the console output.'
        }
    }
}
