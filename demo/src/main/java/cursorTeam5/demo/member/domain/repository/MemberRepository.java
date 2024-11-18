package cursorTeam5.demo.member.domain.repository;

import cursorTeam5.demo.member.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
