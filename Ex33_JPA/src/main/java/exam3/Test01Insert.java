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
			em.persist(user);//저장메소드
			
			em.getTransaction().commit();//DB반영
			
		}catch(Exception e) {
			 e.printStackTrace();
			 em.getTransaction().rollback();
		}finally {
			em.close();
		}
		emf.close();
	}
}
