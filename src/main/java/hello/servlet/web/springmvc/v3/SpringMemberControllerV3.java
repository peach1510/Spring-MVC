package hello.servlet.web.springmvc.v3;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/springmvc/v3/members")
public class SpringMemberControllerV3 {

    private MemberRepository memberRepository = MemberRepository.getInstance();

//    @RequestMapping(value = "/new-form", method = RequestMethod.GET)
    @GetMapping("/new-form")
    public String newForm() {
        // 인터페이스, 문자열 반환 전부 다 됨 => 뷰 이름으로 알고 프로세스 진행
        return "new-form";
    }

//    @RequestMapping(method = RequestMethod.GET)
//    애노테이션을 위한 애노테이션!
    @GetMapping
    public String members(Model model) {
        List<Member> members = memberRepository.findAll();

        model.addAttribute("members", members);
        return "members";
    }

    // HTTP 형태를 지정할 수 있다.
//    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @PostMapping("/save")
    // 서블릿 리퀘스트, 리스폰스, 파라미터, 다 받을 수 있다.
    // RequestParam과 request.getParameter은 거의 같은 코드이다.
    public String save(@RequestParam("username") String username,
                                @RequestParam("age") int age,
                                Model model) {

        Member member = new Member(username, age);
        memberRepository.save(member);

        // 모델에 담기
        model.addAttribute("member", member);
        return "save-result";
    }
}
