# cardreader
# usefull urls
https://www.java4s.com/spring-boot-tutorials/spring-boot-restful-web-service-with-post-request-in-xml-example/
https://spring.io/guides/tutorials/rest/
https://www.baeldung.com/spring-handler-mappings
https://www.baeldung.com/spring-new-requestmapping-shortcuts

#Text

POST should be used to create new resources when:
- the new resource is subordinate to an existing resource - the resource identity/URL is not known at creation time

PUT should be used to update existing resources with well-known URL. It can be used to create a resource at well-known URL as well; however, it does help to think about this scenario in a different way - if the resource URL is known before the PUT request is made, this could be treated the same as the resource at this location already existing but being empty.

# test data for postman
<xml version="1.0" encoding="UTF-8"?>
<cardCheck>
  <data>
  2009-01-01
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
</cardCheck>