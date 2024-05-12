package study.jpa.section2;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import study.jpa.section2.domain.Member;

import java.util.List;

public class MemberSearchMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            List<Member> resultList = em.createQuery("select m from Member as m", Member.class)
                    .getResultList();

            for(Member member: resultList) {
                System.out.println("member : " + member);
            }
            tx.commit();

        } catch(Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }
}
