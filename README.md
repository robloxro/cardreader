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
# Text

POST should be used to create new resources when:
- the new resource is subordinate to an existing resource - the resource identity/URL is not known at creation time

PUT should be used to update existing resources with well-known URL. It can be used to create a resource at well-known URL as well; however, it does help to think about this scenario in a different way - if the resource URL is known before the PUT request is made, this could be treated the same as the resource at this location already existing but being empty.

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

# TODO

- add versioning
- put message on the queue
- add swagger doc?
- possibly add logic to refuse in without out and out without in but in this case we need a persistence layer to the db
