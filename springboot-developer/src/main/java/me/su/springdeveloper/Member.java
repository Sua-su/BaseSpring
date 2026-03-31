package me.su.springdeveloper;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

//    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
//    @Column(name = "email", nullable = false)
//    private String email;

    public Member(String name) {
        this.name = name;
    }

}
