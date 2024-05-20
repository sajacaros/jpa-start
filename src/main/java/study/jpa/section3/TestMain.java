package study.jpa.section3;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import study.jpa.section3.domain.Member;
import study.jpa.section3.domain.Item;
import study.jpa.section3.domain.Order;
import study.jpa.section3.domain.OrderItem;

public class TestMain {
    public static void main(String[] args) {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("section3");
            EntityManager em = emf.createEntityManager();
            EntityTransaction tx = em.getTransaction();
            tx.begin();

            try {
                Member member = new Member("dukim");
                Item item = new Item("장난감", 10_000);
                Item item2 = new Item("장난감2", 20_000);
                Order order = new Order(member);
                OrderItem orderItem = new OrderItem(order, item);
                OrderItem orderItem2 = new OrderItem(order, item2);

                em.persist(member);
                em.persist(item);
                em.persist(item2);
                em.persist(order);
                em.persist(orderItem);
                em.persist(orderItem2);

                tx.commit();
            } catch(Exception e) {
                tx.rollback();
            } finally {
                em.close();
            }

            emf.close();
        }
}
