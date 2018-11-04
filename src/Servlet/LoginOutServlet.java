package Servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

@WebServlet(name = "LoginOutServlet",urlPatterns = "/LoginOutServlet")
public class LoginOutServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        ServletContext context = this.getServletContext();
        Map<String, HttpSession> online = (Map<String, HttpSession>) context.getAttribute("online");
        online.remove(session.getId());
        context.setAttribute("online",online);
        session.invalidate();
        response.sendRedirect(request.getContextPath()+"/index.jsp");
    }
}
