package me.su.springdeveloper;


import me.su.springdeveloper.Member;
import me.su.springdeveloper.MemberRepository;
import org.hibernate.annotations.processing.SQL;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;


import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;




@DataJpaTest
public class MemberRepositoryTest {
    @Autowired
    MemberRepository memberRepository;

    @Sql("/insert-members.sql")
    @Test
    void getAllMembers() {
        //given
        //when
        List<Member> members = memberRepository.findAll();
        assertThat(members.size()).isEqualTo(3);


    }
    @Sql("/insert-members.sql")
    @Test
    void getMemberById() {

        Member member = memberRepository.findById(2L).get();

        assertThat(member.getName()).isEqualTo("B");

    }

    void getMemberbyName(){
        Member member = memberRepository.findByName("C").get();
        assertThat(member.getName()).isEqualTo("C");
    }

}
