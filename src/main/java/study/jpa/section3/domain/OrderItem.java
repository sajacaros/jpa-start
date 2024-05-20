package study.jpa.section3.domain;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import study.jpa.section3.type.OrderStatus;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "ORDER_ITEM")
@NoArgsConstructor
public class OrderItem {
    @Id
    @GeneratedValue
    Long id;
    LocalDateTime orderDate;
    @Enumerated(EnumType.STRING)
    OrderStatus status;
    @ManyToOne
    @JoinColumn(name = "ORDER_ID", insertable = false, updatable = false)
    Order order;
    @ManyToOne
    @JoinColumn(name = "ITEM_ID", insertable = false, updatable = false)
    Item item;

    public OrderItem(Order order, Item item) {
        this.order =order;
        this.item = item;
        this.orderDate = LocalDateTime.now();
        this.status = OrderStatus.PREPARE;
        order.addOrderItem(this);
    }
}
