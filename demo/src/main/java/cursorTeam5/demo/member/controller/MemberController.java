package cursorTeam5.demo.member.controller;

import cursorTeam5.demo.member.domain.Member;
import cursorTeam5.demo.member.dto.requests.MemberSaveRequest;
import cursorTeam5.demo.member.dto.response.MemberSaveResponse;
import cursorTeam5.demo.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/save")
    public ResponseEntity<MemberSaveResponse> save(@RequestBody MemberSaveRequest memberSaveRequest) {
        MemberSaveResponse member = memberService.save(memberSaveRequest);
        return ResponseEntity.ok(member);
    }
}
