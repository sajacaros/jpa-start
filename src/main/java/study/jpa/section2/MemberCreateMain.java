package study.jpa.section2;

import study.jpa.section2.domain.Member;
import jakarta.persistence.*;

public class MemberCreateMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            Member member = new Member();
            member.setId(1L);
            member.setName("hello jpa");

            em.persist(member);
            tx.commit();
        } catch(Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }
}
