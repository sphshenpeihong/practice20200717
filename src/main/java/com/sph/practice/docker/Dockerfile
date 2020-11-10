#基础镜像使用openjdk 以及 centos 试试能不能直接在容器里面手动去运行java -jar命令
# 基础镜像
FROM openjdk:8-jdk-alpine
# 容器暴露端口
EXPOSE 8080
RUN ["mkdir", "/home/shenpeihong1"]
# 复制文件 首先宿主机去主机的文件传输
COPY practice-0.0.1-SNAPSHOT.jar /app/app.jar
ENTRYPOINT java -jar /app/app.jar

# 基础镜像
#FROM openjdk:8-jdk-alpine
# 容器暴露端口
#EXPOSE 8080
# 复制文件 首先宿主机去主机的文件传输
#COPY practice-0.0.1-SNAPSHOT.jar /app/app.jar
# 容器运行后将会去执行该命令
#ENTRYPOINT java -jar /app/app.jar

#获取base image
#FROM adoptopenjdk/openjdk8:latest
#类似于执行 linux指令
#RUN mkdir /opt/app
#类似于linux copy指令  需要写自己项目的jar包全路径
#COPY docker-0.0.1-SNAPSHOT.jar /opt/app/
#对外端口
#EXPOSE 7070
#执行命令 java -jar /opt/app/demo-docker.jar
#CMD ["java", "-jar", "/opt/app/docker-0.0.1-SNAPSHOT.jar"]


