String basePath = 'example-path'
String repo = 'jenkins-training/tech-example-java'

folder(basePath) {
    description 'Example Folder'
}

pipelineJob("$basePath/Example Pipeline") {
    cps {
            script(readFileFromWorkspace('pipeline-maven.groovy'))
            sandbox()
    }
}
