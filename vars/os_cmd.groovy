package org.cloudbees;

def call(command) {
    def output
    sh "set -o pipefail"
    sh "$command 2>&1 | tee output.jenkins"
    output = readFile 'output.jenkins'
    sh "rm output.jenkins"
    return output.toString()
}