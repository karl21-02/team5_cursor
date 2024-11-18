package cursorTeam5.demo.member.controller;

import cursorTeam5.demo.member.domain.Member;
import cursorTeam5.demo.member.dto.requests.MemberSaveRequest;
import cursorTeam5.demo.member.dto.response.MemberSaveResponse;
import cursorTeam5.demo.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/save")
    public ResponseEntity<MemberSaveResponse> save(MemberSaveRequest memberSaveRequest) {
        MemberSaveResponse member = memberService.save(memberSaveRequest);
        return ResponseEntity.ok(member);
    }
}
