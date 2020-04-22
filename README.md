# TomcatDerby
Source code from the ZetCode's Tomcat Derby tutorial.

In the tutorial, we create small web application with NetBeans, Tomcat, and Derby.

In addition, we use the three-layer, controller, and DAO software patterns.

For the presentation layer, we use JSP pages and JSTL tags.

The example also uses pure.css library to help design the UI of the application.

http://zetcode.com/java/tomcatderby/

## What works
`./gradlew war` produces a WAR file which can be manually deployed.

There's an empty "Show all" (<war-name>/controller?action=listcars) and a form for adding more cars.

Those newly added cars do not appear in "Show all".

Obviously this app is broken a.t.m.
