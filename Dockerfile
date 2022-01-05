FROM openjdk:8               
VOLUME /tmp                  
EXPOSE 8080                   
ADD target/Rest-Webservice-0.0.1-SNAPSHOT.jar Rest-Webservice-0.0.1-SNAPSHOT.jar.original 
ENTRYPOINT ["java","-jar","/Rest-Webservice-0.0.1-SNAPSHOT.jar"]