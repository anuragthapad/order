pipeline {
    agent any 
    stages {
        stage('Compile and Clean') { 
            steps {

                sh "cd order-management-service; mvn clean compile"
            }
        }
       
		stage('Junit5 Test') { 
            steps {

                sh "cd order-management-service; mvn test"
            }
        }
        
		 stage ('Analysis(Checkstyle,PMD,CPD,SpotBugs)') {
            steps {
                sh 'cd order-management-service; mvn clover:instrument checkstyle:checkstyle pmd:pmd pmd:cpd spotbugs:spotbugs'
            }
        }
        
		stage('Jacoco Coverage Report') {
        	steps{
        			jacoco(execPattern: '**/target/jacoco.exec',
				    classPattern: 'target/classes',
				    sourcePattern: 'src/main/java',
				    exclusionPattern: 'src/test*')
			}
		}
        
        stage('SonarQube'){
			steps {
				sh "cd order-management-service; mvn sonar:sonar -Dsonar.host.url=http://3.232.89.40:9000 -Dsonar.login=f5149ebc08b1d5b00b3449d7f0cf24e19bee340f"
		         
		     }
   		}
   		
        stage('Maven Build') { 
            steps {
                sh "cd order-management-service; mvn package"
            }
        }
		stage('Acceptance report') {
            steps{
        			cucumber buildStatus: 'UNSTABLE',
                		reportTitle: 'My Cucumber Report',
                		fileIncludePattern: '**/*.json',
               			trendsLimit: 10,
                		classifications: [
                    		[
                        		'key': 'Browser',
                        		'value': 'Firefox'
                    		]
                		]
                  }
			}
			
		 stage('Build Docker image'){
            steps {
              
                sh 'cd order-management-service; docker build -t  order_management_service:1.0 .'
            }
        }
        

        stage('Push Docker Image'){
        	steps{
        		script{
        			docker.withRegistry("https://304040140783.dkr.ecr.us-east-1.amazonaws.com", "ecr:us-east-1:aws.credentials") {
					  docker.image("order_management_service:1.0").push()
						}
        			}
        		}
        	}        
    }
    post {
        always {
            junit testResults: '**/target/surefire-reports/TEST-*.xml'

            recordIssues enabledForFailure: true, tools: [mavenConsole(), java(), javaDoc()]
            recordIssues enabledForFailure: true, tool: checkStyle()
            recordIssues enabledForFailure: true, tool: spotBugs()
            recordIssues enabledForFailure: true, tool: cpd(pattern: '**/target/cpd.xml')
            recordIssues enabledForFailure: true, tool: pmdParser(pattern: '**/target/pmd.xml')
            publishCoverage adapters: [jacocoAdapter('**/target/site/jacoco/jacoco.xml')]
        }
    }
}

