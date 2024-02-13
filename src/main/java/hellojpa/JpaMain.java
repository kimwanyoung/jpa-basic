package hellojpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            Member member = new Member();
            member.setUsername("A");

            Member member1 = new Member();
            member1.setUsername("B");

            Member member2 = new Member();
            member2.setUsername("C");

            System.out.println("====================");
            em.persist(member);
            em.persist(member1);
            em.persist(member2);

            System.out.println("member = " + member.getId());
            System.out.println("member1 = " + member1.getId());
            System.out.println("member2 = " + member2.getId());

            System.out.println("====================");

            tx.commit();
        } catch (Exception exception) {
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();

    }
}
