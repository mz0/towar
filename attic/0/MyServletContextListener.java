package com.example;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import javax.servlet.annotation.WebListener;
//https://stackoverflow.com/questions/58034013/background-process-in-vaadin-8-application
//do i need @WebListener to start working?
@WebListener
public class MyServletContextListener implements ServletContextListener{

  @Override
  public void contextInitialized(ServletContextEvent event) {
    System.out.println ( "MyServletContextListener has started." );
    ServletContext context=event.getServletContext();
    String url=context.getInitParameter("URL");
    String database=context.getInitParameter("Database name");
    String username=context.getInitParameter("Username");
    String password=context.getInitParameter("password");
    MyDatabase mydb=new MyDatabase(url+database,username,password);
    context.setAttribute("Database", mydb);
    
    this.executorService = Executors.newSingleThreadExecutor() ;
      Runnable runnable = new Runnable () {
        @Override
        public void run ( ) {
          System.out.println ( "INFO - Acme web app doing some work on background thread. " + Instant.now () );
        }
      };
      Future future = this.executorService.submit ( runnable );
  }
  
  @Override
  public void contextDestroyed(ServletContextEvent event) {
    System.out.println("web app is exiting. " + Instant.now());
      if ( Objects.nonNull(executorService) ) {
        this.executorService.shutdown ();
      }
  }
}
// stackoverflow.com/questions/4691132/how-to-run-a-background-task-in-a-servlet-based-web-application
//
//Executors.newScheduledThreadPool to create instance of ScheduledExecutorService
// https://crunchify.com/how-to-run-java-program-automatically-on-tomcat-startup/
/*
<?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns="http://java.sun.com/xml/ns/javaee" xmlns:web="http://java.sun.com/xml/ns/javaee/web-app_2_5.xsd" xsi:schemaLocation="http://java.sun.com/xml/ns/javaee http://java.sun.com/xml/ns/javaee/web-app_3_0.xsd" version="3.0">
  <display-name>CrunchifyTutorials</display-name>
  <welcome-file-list>
    <welcome-file>index.html</welcome-file>
    <welcome-file>index.htm</welcome-file>
    <welcome-file>index.jsp</welcome-file>
    <welcome-file>default.html</welcome-file>
    <welcome-file>default.htm</welcome-file>
    <welcome-file>default.jsp</welcome-file>
  </welcome-file-list>
  <servlet>
    <servlet-name>CrunchifyTutorials</servlet-name>
    <servlet-class>crunchify.com.tutorials.CrunchifyServletExample</servlet-class>
    <load-on-startup>1</load-on-startup>
</servlet>
</web-app>package crunchify.com.tutorials;
*/ 
import javax.servlet.*;
import javax.servlet.http.HttpServlet;
 
@SuppressWarnings("serial")
public class CrunchifyServletExample extends HttpServlet {
  public void init(ServletConfig config) throws ServletException  {
    System.out.println("----------");
    System.out.println("---------- CrunchifyServletExample Initialized successfully ----------");
    System.out.println("----------");
    super.init(config);
    try {
      Class.forName("oracle.jdbc.driver.OracleDriver").newInstance(  );
    }
    catch (ClassNotFoundException e) {
      throw new UnavailableException("TransactionConnection.init(  ) ClassNotFoundException: " + e.getMessage());
    }
    catch (IllegalAccessException e) {
      throw new UnavailableException("TransactionConnection.init(  ) IllegalAccessException: " + e.getMessage());
    }
    catch (InstantiationException e) {
      throw new UnavailableException("TransactionConnection.init(  ) InstantiationException: " + e.getMessage());
    }
  }
  public void doGet(
    HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    response.setContentType("text/html");
    PrintWriter out = response.getWriter(  );
    out.println("<html>");
    out.println("<head>");
    out.println("<title>A Per Transaction Connection</title>");
    out.println("</head>");
    out.println("<body>");

    Connection connection = null;
    try {
      // Establish a connection
      connection = DriverManager.getConnection(
       "jdbc:oracle:thin:@dssw2k01:1521:orcl", "scott", "tiger");
    }
    catch (SQLException e) {
      throw new UnavailableException(
       "TransactionConnection.init(  ) SQLException: " + 
       e.getMessage(  ));
    }

    Statement  statement = null;
    ResultSet  resultSet = null;
    String     userName  = null;  
    try { 
      // Test the connection
      statement = connection.createStatement(  );
      resultSet = statement.executeQuery(
       "select initcap(user) from sys.dual");
      if (resultSet.next(  ))
        userName = resultSet.getString(1);
    }
    catch (SQLException e) {
      out.println(
       "TransactionConnection.doGet(  ) SQLException: " + 
       e.getMessage(  ) + "<p>");
    }
    finally {
      if (resultSet != null) 
        try { resultSet.close(  ); } catch (SQLException ignore) { }
      if (statement != null) 
        try { statement.close(  ); } catch (SQLException ignore) { }
    }

    if (connection != null) {
      // Close the connection
      try { connection.close(  ); } catch (SQLException ignore) { }
    }

    out.println("Hello " + userName + "!<p>");
    out.println("You're using a per transaction connection!<p>");
    out.println("</body>");
    out.println("</html>");
  }

  public void doPost(
   HttpServletRequest request, HttpServletResponse response)
   throws IOException, ServletException {
    doGet(request, response);
  }
  destroy( )
}
// Java Programming with Oracle JDBC
//https://www.oreilly.com/library/view/java-programming-with/059600088X/ch04s02.html

// https://medium.com/@tattwei46/how-to-work-with-servlet-jsp-and-jdbc-fcc568a6a57b
// https://www.geeksforgeeks.org/life-cycle-of-a-servlet/
