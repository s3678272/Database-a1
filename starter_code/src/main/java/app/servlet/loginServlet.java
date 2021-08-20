package app.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import app.dao.loginDao;
import app.model.User;

/**
 * Deal request from web - Post form
 *
 * @author Tingyu Gong
 */
@WebServlet("/loginServlet")

public class loginServlet extends HttpServlet{
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String fullname = request.getParameter("fullname");
        String screenname = request.getParameter("screenname");
        String dateofbrith = request.getParameter("dateofbrith");
        String gender = request.getParameter("gender");
        String status = request.getParameter("status");
        String location = request.getParameter("location");

        request.getSession().setAttribute("email", email);

        User user = new User(email, password, fullname, screenname, dateofbrith, gender, status, location);

        try{
            if(email.equals("") && !password.equals("")){
                request.setAttribute("errorEmailempty", "email can not be empty!");
                request.getRequestDispatcher("index.java").forward(request, response);
            }else if(password.equals("") && !email.equals("")){
                request.setAttribute("errorPasswordempty", "Password can not be empty!");
                request.getRequestDispatcher("index.java").forward(request, response);
            }else if (email.equals("") && password.equals("")) {
                request.setAttribute("errorEmailempty", "email can not be empty!");
                request.setAttribute("errorPasswordempty", "Password can not be empty!");
                request.getRequestDispatcher("index.java").forward(request, response);
            }else { //if the user input is good then we check if their emaiil recorded in the database or not
                int result = loginDao.login(user);

                if (result > 0) {
                    request.getRequestDispatcher("page2.java").forward(request, response);
                } else {
                    request.setAttribute("errorMsgL", "Login failed, Please enter your correct email or password!");
                    request.getRequestDispatcher("index.java").forward(request, response);
                }
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
