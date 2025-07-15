pipeline {
    agent any
    
    tools {
		maven 'apache-maven-3.9.10'
	}

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/Jasmin-Patel/AutomationProject.git' // Replace with your repository URL
            }
        }
        stage('Build') {
            steps {
                bat 'mvn clean install' // Or your preferred build command
            }
        }
        stage('Test') {
            steps {
                bat 'mvn test' // Or your preferred test command
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying...'
            }
        }
    }
}
