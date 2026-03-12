package me.su.springdeveloper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TestService {
    private final TestRepository testRepository;

    public List<Member> getAllMembers() {
        return testRepository.findAll();
    }

    public Member saveMember(Member member) {
        return testRepository.save(member);
    }
}
