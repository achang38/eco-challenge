REPOURL = https://github.com/achang38/eco-challenge.git
push: addremote
	git push origin master
pull: removeremote
	git remote add origin $(REPOURL)
	git pull origin master
addremote: commit
	git remote add origin $(REPOURL)
commit: add
	git commit
add: removeremote
	git add .
removeremote:
	git remote rm origin
