package com.larryco.cally.repositories;

import java.util.List;
import com.larryco.cally.models.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("memberRepository")
public interface MemberRepository extends JpaRepository<Member, Long> {
    Member findByEmail(String email);
    Member findByFirstName(String firstName);
}