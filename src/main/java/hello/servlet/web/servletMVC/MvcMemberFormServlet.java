package hello.servlet.web.servletMVC;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// WEB-INF: 외부에서 직접 부르지 않고 컨트롤러를 거쳐서 내부에서 포워드 해야만 접근할 수 있게 함
@WebServlet(name = "mvcMemberFormServlet", urlPatterns = "/servlet-mvc/members/new-form")
public class MvcMemberFormServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String viewPath = "/WEB-INF/views/new-form.jsp";
        RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);

        // 서블릿에서 JSP를 호출
        // 서버 내부에서 다시 호출이 발생한다.
        // 클라이언트가 아니라 서버 안에서 servlet 호출했다 JSP 호출하고 응답 만들어서 고객한테 준다.
        // 서버 내부적으로 함수, 메서드 호출하듯이 호출이 일어난다.
        dispatcher.forward(request, response);
    }
}
