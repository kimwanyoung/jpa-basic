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

            Member member = new Member();
            member.setId(1L);
            member.setUsername("A");
            member.setRoleType(RoleType.USER);

            Member member2 = new Member();
            member2.setId(2L);
            member2.setUsername("B");
            member2.setRoleType(RoleType.ADMIN);

            em.persist(member);
            em.persist(member2);

            tx.commit();
        } catch (Exception exception) {
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();

    }
}
