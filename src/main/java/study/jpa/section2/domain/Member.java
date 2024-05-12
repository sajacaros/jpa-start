package study.jpa.section2.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Setter;
import lombok.ToString;

@Entity
@Setter
@ToString
public class Member {
    @Id
    Long id;

    String name;
}
