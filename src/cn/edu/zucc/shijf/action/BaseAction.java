package cn.edu.zucc.shijf.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.*;
import org.apache.struts2.util.ServletContextAware;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Map;

/**
 * Created by wetsaid on 2016/6/10.
 */
public class BaseAction extends ActionSupport implements ServletRequestAware,
        ServletResponseAware, ServletContextAware, SessionAware,
        ApplicationAware, CookiesAware {

    public HttpServletRequest request;
    public ServletContext servletContext;
    public HttpServletResponse response;
    public Map<String, Object> session;
    public Map<String, Object> application;
    public Map<String, String> cookies;

    @Override
    public void setServletRequest(HttpServletRequest request) {
        this.request = request;
    }

    @Override
    public void setServletResponse(HttpServletResponse response) {
        this.response = response;
    }

    @Override
    public void setServletContext(ServletContext servletContext) {
        this.servletContext = servletContext;
    }

    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }

    @Override
    public void setApplication(Map<String, Object> application) {
        this.application = application;
    }

    @Override
    public void setCookiesMap(Map<String, String> cookies) {
        this.cookies = cookies;
    }

    /**
     * 转向
     *
     * @param path
     */
    public void forward(String path) {
        try {
            this.request.getRequestDispatcher(path).forward(this.request,
                    this.response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 先弹框，再重定向
     *
     * @param msg
     * @param path
     */
    public void alertRedirect(String msg, String path) {
        try {
            this.response.setContentType("text/html;charset=utf8");
            PrintWriter out = this.response.getWriter();
            out.print("<script>");
            out.print("alert('" + msg + "');");
            out.print("window.location='" + path + "';");
            out.print("</script>");
            out.flush();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 弹框并返回原网页
     * @param msg
     */
    public void alertBack(String msg) {
        try {
            this.response.setContentType("text/html;charset=utf8");
            PrintWriter out = this.response.getWriter();
            out.print("<script>");
            out.print("alert('" + msg + "');");
            out.print("window.history.back(-1);");
            out.print("</script>");
            out.flush();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 转换get方式提交的中文编码（UTF-8）
     *
     * @param str
     * @return
     */
    public String convertGetCode(String str) {
        if (str != null) {
            try {
                byte[] bs = str.getBytes("ISO8859-1");
                str = new String(bs, "UTF-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return str;
    }

    public void logout() {
        session.clear();
        forward("login.jsp");
    }
}
