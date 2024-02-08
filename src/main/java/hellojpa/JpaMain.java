package hellojpa;

import jakarta.persistence.*;
import java.util.List;

public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();

        tx.begin();
        try {
            List<Member> findMembers = em.createQuery("select m from Member as m", Member.class)
                    .setFirstResult(5).setMaxResults(8)
                    .getResultList();

            for (Member findMember : findMembers) {
                System.out.println("findMember = " + findMember.getName());
            }

            tx.commit();
        } catch (Exception exception) {
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();

    }
}
