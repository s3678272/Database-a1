package app;

import java.util.ArrayList;
import io.javalin.http.Context;
import io.javalin.http.Handler;

/**
 * Temporary HTML as an example page.
 * 
 * Based on the Project Workshop code examples.
 * This page currently:
 *  - Provides a link back to the index page
 *  - Displays the list of movies from the Movies Database using the JDBCConnection
 *
 * @author Timothy Wiley, 2021. email: timothy.wiley@rmit.edu.au
 * @author Santha Sumanasekara, 2021. email: santha.sumanasekara@rmit.edu.au
 * @author Halil Ali, 2021. email: halil.ali@rmit.edu.au
 */
public class Page5 implements Handler {

   // URL of this page relative to http://localhost:7000/
   public static final String URL = "/page5.html";

   @Override
   public void handle(Context context) throws Exception {
      // Create a simple HTML webpage in a String
      String html = "<html>\n";

      // Add some Header information
      html = html + "<head>" + "<title>Register</title>\n";

      // Add some CSS (external file)
      html = html + "<link href='//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css' rel='stylesheet' id='bootstrap-css'>";
      html = html + "<script src='//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js'></script>";
      html = html + "<script src='//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>";

      html = html + "<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css'>";

      html = html + "<script src='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js'></script>";
      html = html + "<link rel='stylesheet' href'//maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css'>";
      html = html + "<link rel='stylesheet' href='path/to/font-awesome/css/font-awesome.min.css'>";

      html = html + "<link rel='stylesheet' type='text/css' href='register.css' />\n";

      // Add the body
      html = html + "<body>\n";
      html = html + "<div class='container'>";

      JDBCConnection jdbc = JDBCConnection.getConnection();
      ArrayList<String> movies = jdbc.getMovies();

      html = html + "<center>"; 
      html = html + "<b id='login-name'>SIGN-UP Here </b>"; 
      html = html + "</center>>";
	
      html = html + "<div class='row'>";
		
      html = html + "<div class='col-md-6 col-md-offset-3' id='login'>";

      html = html + "<form action='registerServlet' method'post'>";
	
      html = html + "<div class='form-group'>";
      html = html + "<label class='user'> FullName:  </label>";

	
      html = html + "<input type='text' class='form-control' id='t1' name='tl' placeholder='Username'>";
      html = html + "</div>";


      html = html + "<div class='form-group'>";
      html = html + "<label class='user'> Email: </label>";

      html = html + "<input type='email' class='form-control' id='email' name='email' placeholder='EnterEmail'>";

      html = html + "</div>";
      html = html + "<div class='form-group'>";
      html = html + "<label class='user'> ScreenName: </label>";

      html = html + "<input type='text' class='form-control' id='text2' name='tl' placeholder=' Enter your mobile Number'>";

      html = html + "</div>";

      html = html + "<div class='form-group'>";
      html = html + "<label class='user'> Password: </label>";
      html = html + "<input type='text' class='form-control' id='text2' name='tl' placeholder=' Enter Password'>";
      html = html + "</div>";

      html = html + "<div class='form-group label_001' >";
      html = html + "<label class='user'> Gender: </label>";
      html = html + "<label class='adio-inline'><input type='radio' name='optradio'>Male</label>";
      html = html + "<label class='radio-inline'><input type='radio' name='optradio'>Female</label>";
      html = html + "</div>";

      html = html + "<div class='form-group' >";
      html = html + "<label class='user'> Date of birth: </label>";
      html = html + "<input type='date' class='form-control' id='text2' name='tl'>";
      html = html + "</div>";

      html = html + "<div class='form-group' >";
      html = html + "<label class='user'> Status: </label>";
      
      html = html + "<select name = 'tl'>";

      html = html + "<option value = 'married'>married </option>";

      html = html + "<option value = 'single'>single </option>";
      
      html = html + "<option value = 'divorced'>divorced </option>";
      
      html = html + "</select>";
      html = html + "</div>";

      html = html + "<div class='form-group' >";
      html = html + "<label class='user'> Location: </label>";
      html = html + "<input type='textarea' class='form-control'  name='tl'>";
      html = html + "</div>";

html = html + "<div class='form-group'>";

html = html + "<input type='submit' class='btn btn-success' value='submit' style='border-radius:0px;'>";
html = html + "<br>";
html = html + "<br>";
html = html + "<a href='/' style='color: white; font-size: 15px; float: right; margin-right: 10px;'> Back login page </a>";

html = html + "</div>";
    
    html = html + "</form>";
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
