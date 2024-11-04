package exam1;

import java.beans.PersistenceDelegate;
import java.time.LocalDate;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class BasicUse {
	public static void main(String[] args) {
		EntityManagerFactory emf =
		   Persistence.createEntityManagerFactory("JpaEx01");
		EntityManager entityManager 
		          = emf.createEntityManager();
		EntityTransaction transaction 
		          = entityManager.getTransaction();
		
		try {
			transaction.begin();
			
			Member1 user = new Member1("홍길동2",LocalDate.now());
			entityManager.persist(user);//저장메소드
			
			transaction.commit();//DB반영
			
		}catch(Exception e) {
			 e.printStackTrace();
			 transaction.rollback();
		}finally {
			entityManager.close();
		}
		emf.close();
	}
}
