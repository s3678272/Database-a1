package app;

import io.javalin.http.Context;
import io.javalin.http.Handler;

/**
 * Example Index HTML class using Javalin
 * <p>
 * Generate a static HTML page using Javalin by writing the raw HTML into a Java
 * String object
 *
 * @author Timothy Wiley, 2021. email: timothy.wiley@rmit.edu.au
 * @author Santha Sumanasekara, 2021. email: santha.sumanasekara@rmit.edu.au
 */
public class Index implements Handler {

   // URL of this page relative to http://localhost:7000/
   public static final String URL = "/";

   @Override
   public void handle(Context context) throws Exception {
      // Create a simple HTML webpage in a String
      String html = "<html>\n";

      // Add some Header information
      html = html + "<head>" + "<title>Homepage</title>\n";

      // Add some CSS (external file)
      html = html + "<link rel='stylesheet' href='https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css' integrity='sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO' crossorigin='anonymous'>\n";
      html = html + "<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js'></script>\n";
      html = html + "<link rel='stylesheet' href='https://use.fontawesome.com/releases/v5.6.1/css/all.css' integrity='sha384-gfdkjb5BdAXd+lj+gudLWI+BXq4IuLW5IT+brZEZsLFm++aCMlF1V92rMkPaX4PP' crossorigin='anonymous'>\n";
      html = html + "<link rel='stylesheet' type='text/css' href='login.css' />\n";
      

      // Add the body
      html = html + "<body>\n";

      html = html + "<div class='container h-100'>";
      html = html + "<div class='d-flex justify-content-center h-100'>";
      html = html + "<div class='user_card'>";
      html = html + "<div class='d-flex justify-content-center'>";

      html = html + "<h1>Facebook Lite </h1>";


      html = html + "</div>";
      html = html + "<div class='d-flex justify-content-center form_container'>";
      html = html + "<form action='loginServlet' method='post'>";

      // String errorMsgL = (String) request.getAttribute("errorMsgL");
      // String errorEmailempty = (String) request.getAttribute("errorEmailempty");
      // String errorPasswordempty = (String) request.getAttribute("errorPasswordempty");
      // if (errorMsgL == null) {
      //     errorMsgL = "";
      // }
      // if (errorEmailempty == null) {
      //     errorEmailempty = "";
      // }
      // if (errorPasswordempty == null) {
      //     errorPasswordempty = "";
      // }

      html = html + "<div class='input-group mb-3'>";
      html = html + "<div class='input-group-append'>";
      html = html + "<span class='input-group-text'><i class='fas fa-user'></i></span>";
      html = html + "</div>";
      html = html + "<input type='text' name='' class='form-control input_user' placeholder='email'>";
      html = html + "</div>";
      html = html + "<div class='input-group mb-2'>";
      html = html + "<div class='input-group-append'>";
      html = html + "<span class='input-group-text'><i class='fas fa-key'></i></span>";
      html = html + "</div>";
      html = html + "<input type='password' name='' class='form-control input_pass' placeholder='password'>";
      html = html + "</div>";
      html = html + "<div class='d-flex justify-content-center mt-3 login_container'>";
                  html = html + "<button type='button' name='button'  class='btn login_btn'>Login</button>";
				    html = html + "</div>";
               html = html + "</form>";
               html = html + "</div>";
		
            html = html + "<div class='mt-4'>";
            html = html + "<div class='d-flex justify-content-center links'>";
            html = html + "<a href='/page5.html' class='ml-2'>Sign Up</a>";
                  html = html + "</div>";


                  html = html + "</div>";
               html = html + "</div>";
            html = html + "</div>";
         html = html + "</div>";
      html = html + "</div>";

      // Finish the HTML webpage
      html = html + "</body>" + "</html>\n";

      // DO NOT MODIFY THIS
      // Makes Javalin render the webpage
      context.html(html);
   }

}
