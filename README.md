# Tomcat Dummy
Derived from the ZetCode's [Tomcat Derby tutorial](http://zetcode.com/java/tomcatderby/) (2018.03.20)

## What works
`./gradlew war` produces a WAR file which can be manually deployed to Tomcat.
Do not forget to put MySQL Connector/J into `$CATALINA_HOME/lib/` beforehand.

There's a "Show all" page (<war-name>/controller?action=listcars) and a trivial JSTL demo page.
