import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;

public class HelloworldServlet implements Servlet {
    public void init(ServletConfig config) throws ServletException {
        System.out.println("init");
    }

    public void service(ServletRequest request, ServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        out.println("<!doctype html>\n" +
                "<html>\n" +
                "<head>\n" +
                "<meta charset=\"UTF-8\">\n" +
                "<title>Hello World!</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<h1>Hello World!</h1>\n" +
                "<p>\"Igniter\"의 서블릿 프로세서 테스트용 서블릿.<p>\n" +
                "<p>테스트 시간 : " + new java.util.Date() + "</p>\n" +
                "<p>서블릿 명 : " + this.getClass().getName() + "</p>\n" +
                "<p>서블릿 정상작동 중!</p>\n" +
                "</body>\n" +
                "</html>\n");
    }

    public void destroy() {
        System.out.println("destroy");
    }

    public String getServletInfo() {
        return null;
    }

    public ServletConfig getServletConfig() {
        return null;
    }
}