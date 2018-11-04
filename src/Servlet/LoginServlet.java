package Servlet;

import model.User;
import service.implement.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "LoginServlet",urlPatterns = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        UserServiceImpl userService=new UserServiceImpl();
        User user = userService.queryUser(username);
        if (user.getPassword().equals(password)){
            HttpSession session = request.getSession(true);
            String ip = request.getRemoteHost();
            session.setAttribute("user",user);
            session.setAttribute("ip",ip);
            response.sendRedirect(request.getContextPath()+"/index.jsp");
        }else {
            String message="*密码错误";
            request.setAttribute("message",message);
            request.getRequestDispatcher("/login.jsp").forward(request,response);
        }
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
