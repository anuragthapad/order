pipeline {
    agent any 
    stages {
        stage('Compile and Clean') { 
            steps {

                sh "mvn clean compile"
            }
        }
        
        stage('Junit5 Test') { 
            steps {

                sh "mvn test"
            }
        }
        
		 stage ('Analysis(Checkstyle,PMD,CPD,SpotBugs)') {
            steps {
                sh 'mvn clover:instrument checkstyle:checkstyle pmd:pmd pmd:cpd spotbugs:spotbugs'
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
		steps{
			sh "mvn sonar:sonar -Dsonar.host.url=http://localhost:4950 -Dsonar.login=2d1ec4021e5735308a130599522684e3074c7918"
		}
   	}
	
	stage('Maven Build') { 
            steps {
                sh "mvn package"
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
