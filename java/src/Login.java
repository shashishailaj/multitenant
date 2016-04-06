// Import required java libraries
import java.io.*;
import java.net.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.Properties;

// Extend HttpServlet class
public class Login extends HttpServlet {

  protected static Properties properties = new Properties();

  public void init() throws ServletException
  {
    try {
      if (properties.size() < 1) {
        InputStream stream = this.getClass().getResourceAsStream("multitenant.properties");
        properties.load(stream);
        String authority = (String) properties.get("login.authority");
        System.out.println("authority: " + authority);
      }
    }
    catch (Exception ex) {
      ex.printStackTrace();
      throw new ServletException(ex); 
    }  
  }

  public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
  {
    // variables
    // String authority = "https://login.windows.net/common";
    // String clientId = "36bda7c5-cc23-4618-9e09-e710b2357818";
    // String redirect = "http://pelasne-java.southcentralus.cloudapp.azure.com:8080/multitenant/token";
    // String state = "random";
    // String resource = "https://graph.windows.net/";
    
    String authority = (String) properties.get("login.authority");
    String clientId  = (String) properties.get("login.clientId");
    String redirect  = (String) properties.get("login.redirect");
    String state     = (String) properties.get("login.state");
    String resource  = (String) properties.get("login.resource");

    // write auth cookie
    response.addCookie(new Cookie("authstate", state));

    // consent
    String add = (request.getParameter("consent") == "y") ? "&prompt=admin_consent" : "";

    // redirect
    String url = authority + "/oauth2/authorize?response_type=code&client_id=" + URLEncoder.encode(clientId, "UTF-8")
      + "&redirect_uri=" + URLEncoder.encode(redirect, "UTF-8") + "&state=" + URLEncoder.encode(state, "UTF-8")
      + "&resource=" + URLEncoder.encode(resource, "UTF-8") + add;
    response.sendRedirect(url);

  }

  public void destroy()
  {
      // do nothing.
  }

}
