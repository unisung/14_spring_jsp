package exam3;

import java.beans.PersistenceDelegate;
import java.time.LocalDate;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class Test01Insert {
	public static void main(String[] args) {
		EntityManagerFactory emf =
		   Persistence.createEntityManagerFactory("JpaEx01");
		EntityManager em
		          = emf.createEntityManager();
		
		try {
			 em.getTransaction().begin();
			
			Member3 user 
			    = new Member3("test@test.com","홍길동2",LocalDate.now());
			System.out.println(111);
			em.persist(user);//저장메소드
			System.out.println(222);
			
			em.getTransaction().commit();//DB반영
			System.out.println(333);
			System.out.println("가입 요청을 처리했습니다.");
			
		}catch(Exception e) {
			 e.printStackTrace();
			 em.getTransaction().rollback();
		}finally {
			em.close();
		}
		emf.close();
	}
}
