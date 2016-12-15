package com.cloudbees;

@Grab(group='org.kohsuke', module='github-api', version='1.80')
import org.kohsuke.github.GitHub
import org.kohsuke.github.GHRepository
import com.cloudbees.groovy.cps.NonCPS

class GitHubApi {
	def githubapi

	GitHubApi(user, oauth) {
		GitHub github = GitHub.connect(user, oauth);
		this.githubapi = github
	}

	def new_repo(name, description) {
		GHRepository repo = this.githubapi.createRepository(name, description,
  		"http://www.kohsuke.org/",true/*public*/);
	}
}

