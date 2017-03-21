String basePath = 'example-path'
String repo = 'jenkins-training/tech-example-java'

folder(basePath) {
    description 'Example Folder'
}

pipelineJob("$basePath/Example Pipeline") {
    definition {
        cps {
                script(readFileFromWorkspace('pipeline-maven.groovy'))
                sandbox()
        }
    }
}

multibranchPipelineJob("$basePath/Example Multi-Branch Pipeline") {
    branchSources {
        git {
            remote('https://github.com/jenkins-training/tech-example-web.git')
            credentialsId('jason')
            includes('*')
        }
    }
    orphanedItemStrategy {
        discardOldItems {
            numToKeep(20)
        }
    }
}
