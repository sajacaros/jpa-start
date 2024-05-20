package study.jpa.section3_2.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class Item {
    @Id
    @GeneratedValue
    Long id;
    String name;
    Integer price;

    public Item(String name, Integer price) {
        this.name = name;
        this.price = price;
    }
}
