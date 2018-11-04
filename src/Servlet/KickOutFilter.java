package Servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "KickOutFilter",urlPatterns = "/KickOutServlet")
public class KickOutFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        String ip = request.getRemoteAddr();
        if ("localhost".equals(ip)||"127.0.0.1".equals(ip)){
            chain.doFilter(req, resp);
        }else {
            response.getWriter().write("非管理员权限！");
        }
    }

    public void init(FilterConfig config) throws ServletException {
    }

}
