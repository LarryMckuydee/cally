package com.larryco.cally;

import com.larryco.cally.models.Member;
import com.larryco.cally.repositories.MemberRepository;

import static org.assertj.core.api.Assertions.assertThat;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestEntityManager;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@AutoConfigureTestEntityManager
@Transactional
public class MemberRepositoryIntegrationTest {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private MemberRepository memberRepository;

    @Test
    public void whenFindByFirstName_thenReturnMember() {
        //given
        Member member = new Member();
        member.setEmail("larry@gmail.com");
        member.setFirstName("Oleg");
        member.setLastName("Mckuydee");

        entityManager.persist(member);
        entityManager.flush();

        // fetch member
        Member found = memberRepository.findByFirstName("Oleg");

        // then
        assertThat(found.getFirstName())
          .isEqualTo(member.getFirstName());
    }
}