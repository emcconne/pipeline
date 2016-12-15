// src/com/cloudbees/Zot.groovy
package com.cloudbees;

def checkOutFromGitHub(repo) {
	git url: "${repo}"
}

def maven() {
	mvn clean install
}