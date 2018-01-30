# specify the base image "from" which we build on.
# for list of available images: https://hub.docker.com/
FROM docker/whalesay:latest

# apt-get is a linux command to install programs
# "-y" means "answer yes" if the install asks permission 
#      to do something
# && doesn't execute second command if first fail
# "fortunes" is just a random selector from some existing quotes
RUN apt-get -y update && apt-get install -y fortunes

# this is the actual executed command
# run "fortunes" (which gives a random quote) and pipe it 
# as input for the "cowsay" program 
CMD /usr/games/fortune -a | cowsay