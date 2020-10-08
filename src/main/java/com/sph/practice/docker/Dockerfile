#获取base image
FROM adoptopenjdk/openjdk8:latest
#类似于执行 linux指令
RUN mkdir /opt/app
#类似于linux copy指令  需要写自己项目的jar包全路径
COPY docker-0.0.1-SNAPSHOT.jar /opt/app/
#对外端口
EXPOSE 7070
#执行命令 java -jar /opt/app/demo-docker.jar
CMD ["java", "-jar", "/opt/app/docker-0.0.1-SNAPSHOT.jar"]