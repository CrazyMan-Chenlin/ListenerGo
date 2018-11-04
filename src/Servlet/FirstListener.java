package Servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.*;

@WebListener()
public class FirstListener implements ServletContextListener,
        HttpSessionListener, HttpSessionAttributeListener ,ServletRequestListener{
         int count=0;
    // Public constructor is required by servlet spec
    public FirstListener() {
    }
    public void requestInitialized(ServletRequestEvent sre) {
        HttpServletRequest request = (HttpServletRequest)sre.getServletRequest();
        String ip = request.getRemoteHost();
        HttpSession session = request.getSession(true);
        session.setAttribute("ip",ip);
    }
    // -------------------------------------------------------
    // ServletContextListener implementation
    // -------------------------------------------------------
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("ServletContext对象被创建");
    }

    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("ServletContext对象被销毁");
    }

    // -------------------------------------------------------
    // HttpSessionListener implementation
    // -------------------------------------------------------
    public void sessionCreated(HttpSessionEvent se) {
        HttpSession session=se.getSession();
        ServletContext servletContext = se.getSession().getServletContext();
        synchronized (se){
            count++;
            servletContext.setAttribute("count",count);
        }

    }

    public void sessionDestroyed(HttpSessionEvent se) {
        /* Session is destroyed. */
    }

    // -------------------------------------------------------
    // HttpSessionAttributeListener implementation
    // -------------------------------------------------------

    public void attributeAdded(HttpSessionBindingEvent sbe) {
      /* This method is called when an attribute 
         is added to a session.
      */
    }

    public void attributeRemoved(HttpSessionBindingEvent sbe) {
      /* This method is called when an attribute
         is removed from a session.
      */
    }

    public void attributeReplaced(HttpSessionBindingEvent sbe) {
      /* This method is invoked when an attibute
         is replaced in a session.
      */
    }
}
