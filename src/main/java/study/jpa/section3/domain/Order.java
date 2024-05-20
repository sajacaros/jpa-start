package study.jpa.section3.domain;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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
    @OneToMany(mappedBy = "order")
    List<OrderItem> orderItemList = new ArrayList<>();

    public Order(Member member) {
        this.member = member;
        this.orderDateTime = LocalDateTime.now();
    }

    public void addOrderItem(OrderItem orderItem) {
        this.orderItemList.add(orderItem);
    }
}
