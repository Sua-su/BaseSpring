package me.su.springdeveloper;


import me.su.springdeveloper.repository.MemberRepository;
import me.su.springdeveloper.dao.Member;
import org.junit.jupiter.api.DisplayName;
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

    @Test
    @Sql("/insert-members.sql")

    void getAllMembers() {
        //given
        //when
        List<Member> members = memberRepository.findAll();
        //then (검증)
        assertThat(members.size()).isEqualTo(3);
    }

    @DisplayName("record insert Test")
    @Test
    void saveMember(){
        //given
        Member m = new Member("scs");
        //when
        memberRepository.save(m);
        assertThat(memberRepository.findById(1L).get().getName()).isEqualTo("scs");



    }


    @Test
    @Sql("/insert-members.sql")

    void getMemberById() {

        Member member = memberRepository.findById(2L).get();

        assertThat(member.getName()).isEqualTo("B");
    }


    @Test
    @Sql("/insert-members.sql")
    void getMemberByName(){
        Member member = memberRepository.findByName("C").get();
        assertThat(member.getName()).isEqualTo("C");
    }


    @DisplayName("two record insert")
    @Test
    void saveMembers() {

        //given
        List<Member> members = List.of(new Member("hong"), new Member("Park"));

        //when
        memberRepository.saveAll(members);

        //then
        assertThat(memberRepository.findAll().size()).isEqualTo(2);
    }
}
