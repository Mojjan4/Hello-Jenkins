pipeline {
    agent any

    environment {
        ANDROID_HOME = '/var/lib/jenkins/Android/Sdk'
        PATH = "$PATH:$ANDROID_HOME/cmdline-tools/latest/bin:$ANDROID_HOME/platform-tools"
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/Mojjan4/Hello-Jenkins.git'
            }
        }

        stage('Build Debug APK') {
            steps {
                sh '''
                    echo " Android SDK path: $ANDROID_HOME"
                    # Write local.properties for Gradle so it knows where the SDK is
                    echo "sdk.dir=$ANDROID_HOME" > local.properties
                    ./gradlew clean assembleDebug
                '''
            }
        }

        stage('Run Unit Tests') {
            steps {
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
