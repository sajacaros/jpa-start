package study.jpa.section3_2;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import study.jpa.section3_2.domain.Item;
import study.jpa.section3_2.domain.Member;
import study.jpa.section3_2.domain.Order;


public class TestMain {
    public static void main(String[] args) {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("section3_2");
            EntityManager em = emf.createEntityManager();
            EntityTransaction tx = em.getTransaction();
            tx.begin();

            try {
                Member member = new Member("dukim");
                Item item = new Item("장난감", 10_000);
                Item item2 = new Item("장난감2", 20_000);
                Order order = new Order(member);

                em.persist(member);
                em.persist(item);
                em.persist(item2);
                em.persist(order);

                order.addItem(item);
                order.addItem(item2);

                tx.commit();
            } catch(Exception e) {
                tx.rollback();
            } finally {
                em.close();
            }

            emf.close();
        }
}
