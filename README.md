# Useful urls
https://www.java4s.com/spring-boot-tutorials/spring-boot-restful-web-service-with-post-request-in-xml-example/
https://spring.io/guides/tutorials/rest/
https://www.baeldung.com/spring-handler-mappings
https://www.baeldung.com/spring-new-requestmapping-shortcuts
https://restfulapi.net/resource-naming/
https://activemq.apache.org/getting-started#WindowsBinaryInstallation
https://activemq.apache.org/hello-world
Naming example http://dummy.restapiexample.com/
examples on get post put delete https://spring.io/guides/tutorials/rest/
versioning https://www.springboottutorial.com/spring-boot-versioning-for-rest-services
https://springframework.guru/spring-framework-annotations/
https://www.devglan.com/spring-boot/spring-boot-jms-activemq-example
https://dzone.com/articles/kafka-producer-and-consumer-example

# Text

POST should be used to create new resources when:
- the new resource is subordinate to an existing resource - the resource identity/URL is not known at creation time

PUT should be used to update existing resources with well-known URL. It can be used to create a resource at well-known URL as well; however, it does help to think about this scenario in a different way - if the resource URL is known before the PUT request is made, this could be treated the same as the resource at this location already existing but being empty.

# start kafka


C:\Users\ruxij\kits\kafka_2.12-2.4.0\bin\windows>zookeeper-server-start.bat .\..\..\config\zookeeper.properties
kafka-server-start.bat .\..\..\config\server.properties
bin/kafka-topics.sh --create --bootstrap-server localhost:9092 --replication-factor 1 --partitions 1 --topic cardTopic
bin/kafka-topics.sh --list --bootstrap-server localhost:9092

#issues to solve if using kafka on windows

Change:
#listeners=PLAINTEXT://:9092`
in server.properties to:
listeners=PLAINTEXT://localhost:9092


#start activemq

C:\Users\ruxij\kits\apache-activemq-5.15.11-bin\apache-activemq-5.15.11\bin\win64
activemq.bat start
console
http://localhost:8161/admin/ 
with 
admin/admin
netstat -an|find "61616"


# test data for postman
<CardCheck>
                       	<id>
                       		1
                       	</id>
                         <data>
                         2009
                         </data>
                         <cardId>
                         12
                         </cardId>
                         <username>
                         Ruxij
                         </username>
                         <action>
                         IN
                         </action>
</CardCheck>

get:localhost:8080/cardCheck/v1.0
get:localhost:8080/cardCheck/
post:localhost:8080/cardCheck/v1.0
post:localhost:8080/cardCheck/

# Completed

- add versioning - done

#TODO

- put message on the queue
- add swagger doc?
