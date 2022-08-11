def call() {
    def dockerfileContent = readFile('Dockerfile')
    assert dockerfileContent.contains('LABEL maintainer=') : "No maintainer was found."
    assert dockerfileContent.contains('"common-mailbox@our-domain.com"') : "The maintainer must be common-mailbox@our-domain.com"
    // OK, the check is somehow basic
}
