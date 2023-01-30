job("DSLJob05") {
  description("Job created through DSL")
  parameters {
    gitParam('Minor_Tag') {
      type('TAG')
      tagFilter("Minor*")
  	}
  }
  scm {
    git {
      remote {
        url("https://github.com/anupam-sy/MavenProject_01.git")
      }
      branch('${Minor_Tag}')
    }
  }
  triggers {
    cron('H/1 * * * *') // Run job in every two minutes
  }
  steps {
    maven { 
      goals('clean')
      goals('compile')
      mavenInstallation('apache-maven-3.5.2')
    }
  }
}