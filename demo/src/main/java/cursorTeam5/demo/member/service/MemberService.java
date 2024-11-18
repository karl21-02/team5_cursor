package cursorTeam5.demo.member.service;

import cursorTeam5.demo.member.domain.Member;
import cursorTeam5.demo.member.domain.repository.MemberRepository;
import cursorTeam5.demo.member.dto.requests.MemberSaveRequest;
import cursorTeam5.demo.member.dto.response.MemberSaveResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberSaveResponse save(MemberSaveRequest memberSaveRequest) {

        Member member = Member.builder()
                        .name(memberSaveRequest.getName())
                                .build();

        Member saved_member = memberRepository.save(member);
        return new MemberSaveResponse(saved_member.getName());
    }

}
