package study.jpa.section3_2.domain;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "orders")
@NoArgsConstructor
public class Order {
    @Id
    @GeneratedValue
    Long id;

    LocalDateTime orderDateTime;
    @ManyToOne
    @JoinColumn(name="MEMBER_ID")
    Member member;
    @ManyToMany
    @JoinTable(
            name = "ORDER_ITEM",
            joinColumns = @JoinColumn(name = "ORDER_ID"),
            inverseJoinColumns = @JoinColumn(name = "ITEM_ID")
    )
    Set<Item> itemList = new HashSet<>();

    public Order(Member member) {
        this.member = member;
        this.orderDateTime = LocalDateTime.now();
    }

    public void addItem(Item item) {
        this.itemList.add(item);
    }
}
