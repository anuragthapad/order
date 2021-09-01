pipeline {
  agent any
  stages {	
	stage('Maven Compile'){
		steps{
			echo 'Project compile stage'
			bat label: 'Compilation running', script: '''mvn compile'''
	       	}
	}
	
	stage('Unit Test') {
	   steps {
			echo 'Project Testing stage'
			bat label: 'Test running', script: '''mvn test'''
	       
       		}
   	}
	
	stage ('Analysis(Checkstyle,PMD,CPD,SpotBugs)') {
            steps {
                sh 'mvn clover:instrument checkstyle:checkstyle pmd:pmd pmd:cpd spotbugs:spotbugs'
            }
        }

	stage('Jacoco Coverage Report') {
        	steps{
            		jacoco()
		}
	}
       
       stage('SonarQube'){
		steps{
				bat label: '', script: '''mvn sonar:sonar \
				-Dsonar.host.url=http://localhost:4950 \
				-Dsonar.login=2d1ec4021e5735308a130599522684e3074c7918'''
			}
   		}
	
	stage('Maven Package'){
		steps{
			echo 'Project packaging stage'
			bat label: 'Project packaging', script: '''mvn package'''
		}
	} 		
    
  }
}

