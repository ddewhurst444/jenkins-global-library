def call(Map params = [:]) {
    String script = params.script
    Boolean returnStatus = params.get('returnStatus', false)
    Boolean returnStdout = params.get('returnStdout', false)
    String encoding = params.get('encoding', null)

    timeout(time: 2, unit: 'HOURS') {
        ansiColor('xterm') {
            timestamps {
                /* invoke the built-in sh step */
                return steps.sh(script: script,
                          returnStatus: returnStatus,
                          returnStdout: returnStdout,
                              encoding: encoding)
            }
        }
    }
}
/* Convenience overload */
def call(String script) {
    return call(script: script)
}
