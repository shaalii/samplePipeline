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
   	
   	stage('Jacoco Coverage Report') {

        steps{

            jacoco()

		}

	}
	
	stage('SonarQube'){

		steps{

			bat label: '', script: '''mvn sonar:sonar \
			-Dsonar.host.url=http://localhost:9000 \
			-Dsonar.login=squ_1450272800ed853bfab8d665b2ce6e9742eafade'''
		}

   	} 

 

	stage('Maven Package'){

		steps{

			echo 'Project packaging stage'

			bat label: 'Project packaging', script: '''mvn package'''

		}

	}
	
 
post {
    always {        cucumber buildStatus: 'UNSTABLE',
                failedFeaturesNumber: 1,
                failedScenariosNumber: 1,
                skippedStepsNumber: 1,
                failedStepsNumber: 1,
                classifications: [
                        [key: 'Commit', value: '<a href="${GERRIT_CHANGE_URL}">${GERRIT_PATCHSET_REVISION}</a>'],
                        [key: 'Submitter', value: '${GERRIT_PATCHSET_UPLOADER_NAME}']
                ],                reportTitle: 'My report',
                fileIncludePattern: '**/*cucumber-report.json',
                sortingMethod: 'ALPHABETICAL',
                trendsLimit: 100
    }
}
 

	 



  }

}