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

        /*
            //비영속
            Member member = new Member();
            member.setId(100L);
            member.setName("HelloJPA");

            //영속
            System.out.println("==== BEFORE ====");
            em.persist(member);
            System.out.println("==== AFTER ====");

            // 같은 트랜잭션 안에서 동시성 보장
            Member findMember1 = em.find(Member.class, 100L);
            Member findMember2 = em.find(Member.class, 100L);

            System.out.println("result = " + (findMember1 == findMember2));
        */

        /*

            Member member1 = new Member(150L, "A");
            Member member2 = new Member(160L, "B");

            em.persist(member1);
            em.persist(member2);
            System.out.println("==========================");

         */

            Member member = em.find(Member.class, 150L);
            member.setName("AAA");

            tx.commit(); // 커밋 시점에 데이터베이스 쿼리가 실행됨
        } catch (Exception exception) {
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();

    }
}
