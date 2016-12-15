// src/com/cloudbees/Zot.groovy
package com.cloudbees;

def checkOutFrom(repo) {
  git url: "git@github.com:emcconne/${repo}"
}