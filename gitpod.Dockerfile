FROM gitpod/workspace-full

RUN sudo apt update && \
    sudo apt install -y openjdk-17-jdk && \
    sudo update-alternatives --install /usr/bin/java java /usr/lib/jvm/java-17-openjdk-amd64/bin/java 1 && \
    sudo update-alternatives --install /usr/bin/javac javac /usr/lib/jvm/java-17-openjdk-amd64/bin/javac 1

ENV JAVA_HOME=/usr/lib/jvm/java-17-openjdk-amd64
