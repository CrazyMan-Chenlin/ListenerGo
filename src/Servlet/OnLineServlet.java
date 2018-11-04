package Servlet;

import model.OnLineBean;
import model.User;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@WebServlet(name = "OnLineServlet",urlPatterns = "/OnLineServlet")
public class OnLineServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext context = request.getServletContext();
        Map<String, HttpSession> online = (Map<String, HttpSession>) context.getAttribute("online");
        List<OnLineBean> onLineBeanList = new ArrayList<>();
        Set<Map.Entry<String, HttpSession>> entries = online.entrySet();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        for (Map.Entry<String, HttpSession> entry : entries
                ) {
            OnLineBean onLineBean = new OnLineBean();
            HttpSession session = entry.getValue();
            onLineBean.setSessionId(session.getId());
            onLineBean.setUser((User)session.getAttribute("user"));
            onLineBean.setIp((String) session.getAttribute("ip"));
            onLineBean.setLoginTime(sdf.format(session.getCreationTime()));
            onLineBean.setLastTime(sdf.format(session.getLastAccessedTime()));
            onLineBeanList.add(onLineBean);
        }
            context.setAttribute("onLineBeanList",onLineBeanList);
           response.sendRedirect(request.getContextPath()+"/user/OnLineUser.jsp");
    }

}