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
import java.util.Set;

@WebServlet(name = "KickOutServlet",urlPatterns = "/KickOutServlet")
public class KickOutServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String sessionId = request.getParameter("sessionId");
        ServletContext context = request.getServletContext();
        Map<String, HttpSession> onLine = (Map<String, HttpSession>) context.getAttribute("online");
        HttpSession session = onLine.get(sessionId);
        if (session!=null){
            onLine.remove(sessionId);
            context.setAttribute("onLine",onLine);
            session.invalidate();
        }
        response.sendRedirect(request.getContextPath()+"/OnLineServlet");
    }
}
