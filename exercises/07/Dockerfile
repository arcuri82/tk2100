# Kali is a Linux distribution with security tools
FROM kalilinux/kali-linux-docker:latest

# The version for Docker is however "minimal", with no so many tools installed.
# So we need to install them manually
RUN apt-get -y update && apt-get install -y metasploit-framework

# For the "setoolkit", it seems we can't use "apt-get", and rather need to build it manually.
# So, we follow instructions for installation from their web site, which states to
# use Git to download the source code, and install it manually by using a Python script
RUN git clone https://github.com/trustedsec/social-engineer-toolkit/ set/
RUN cd set; python setup.py install