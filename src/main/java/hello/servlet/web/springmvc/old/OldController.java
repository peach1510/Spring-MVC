package hello.servlet.web.springmvc.old;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 스프링 빈의 이름을 URL 패턴으로 맞춰 줌 => 호출 됨

@Component("/springmvc/old-controller")
public class OldController implements Controller {

    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // 컨트롤러는 호출이 되었는데 View를 못 찾고 있음
        System.out.println("OldController.handleRequest");
        return new ModelAndView("new-form");
    }
}
