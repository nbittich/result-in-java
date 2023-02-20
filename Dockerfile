FROM openjdk:19
COPY . .
RUN javac --enable-preview --release 19 ErrorHandling.java
ENTRYPOINT [ "java", "--enable-preview","ErrorHandling" ]
