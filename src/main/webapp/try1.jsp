<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<sql:query var="rs" dataSource="jdbc/cardata">
select ID, Name, Price from CARS
</sql:query>

<html>
  <head>
    <title>DB Test</title>
  </head>
  <body>

  <h2>Results</h2>

  <c:forEach var="row" items="${rs.rows}">
    Name ${row.Name}<br/>
    Price ${row.Price}<br/>
  </c:forEach>

  </body>
</html>
<!--
https://tomcat.apache.org/taglibs/standard/
https://docs.oracle.com/javaee/7/javaserver-faces-2-2/vdldocs-facelets/c/forEach.html#navbar_top
http://tomcat.apache.org/tomcat-9.0-doc/jndi-datasource-examples-howto.html
https://tomcat.apache.org/tomcat-9.0-doc/jdbc-pool.html
-->
