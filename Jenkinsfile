pipeline { 
    agent none 
    
    stages {
        stage('docker-compose') {
            steps {
               sh "docker-compose build"
               sh "docker-compose up -d"
            }
        }
    }
    post { 
        always { 
            echo 'post process !' 
        } 
    } 
}

