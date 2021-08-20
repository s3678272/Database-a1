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

@WebServlet("/registerServlet")
public class registerServlet extends HttpServlet{
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        boolean fullNameIsString;
        
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String fullname = request.getParameter("fullname");
        String screenname = request.getParameter("screenname");
        String dateofbrith = request.getParameter("dateofbrith");
        String gender = request.getParameter("gender");
        String status = request.getParameter("status");
        String location = request.getParameter("location");

        fullNameIsString = fullname.matches("^[A-Za-z]+$");

        request.getSession().setAttribute("email", email);

        User user = new User(email, password, fullname, screenname, dateofbrith, gender, status, location);

        try{
            if(email.equals("")||password.equals("")||fullname.equals("")||screenname.equals("")||dateofbrith.equals("")||gender.equals("")||status.equals("")||location.equals("")){
                request.setAttribute("erroremptyAll", "Fields can not be empty!");
                request.getRequestDispatcher("page5.html").forward(request, response);
            }else if(fullNameIsString == false){
                request.setAttribute("errorFNstring", "the FullName can only be string");
                request.getRequestDispatcher("page5.html").forward(request, response);
            }else{
                boolean result = loginDao.register(user);
                if(result == true){
                    System.out.println("register Success!!!!!！"); //print to consol
                    request.getRequestDispatcher("page2.html").forward(request, response);
                }else{
                    System.out.println("register failed");
                    request.setAttribute("errorMsgR", "Register failed, this email has been registed, please try another email!");
                    request.getRequestDispatcher("page5.html").forward(request, response);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    
}
