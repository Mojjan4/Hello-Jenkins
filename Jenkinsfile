pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/Mojjan4/Hello-Jenkins.git'
            }
        }

        stage('Run Unit Tests') {
            steps {
                sh './gradlew testDebugUnitTest'
            }
        }

        stage('Build Debug APK') {
            steps {
                sh '''
                    echo "✅ Android SDK path: $ANDROID_HOME"
                    echo "sdk.dir=$ANDROID_HOME" > local.properties
                    ./gradlew clean assembleDebug
                '''
            }
        }

        stage('Archive Artifact') {
            steps {
                archiveArtifacts artifacts: 'app/build/outputs/apk/debug/*.apk', fingerprint: true
            }
        }
    }

    post {
        always {
            echo '--- Pipeline completed ---'
        }
        success {
            echo '✅ Build, test, and artifact pipeline succeeded!'
        }
        failure {
            echo '❌ Build or tests failed! Check the console output.'
        }
    }
}
