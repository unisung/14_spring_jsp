package exam3;

import java.time.LocalDate;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Test03Update {
	public static void main(String[] args) {
		EntityManagerFactory emf =
		   Persistence.createEntityManagerFactory("JpaEx01");
		EntityManager em
		          = emf.createEntityManager();
		
		try {
			 em.getTransaction().begin();
			
			Member3 user 
			    = em.find(Member3.class, "test@test.com");
			if(user==null) {
				System.out.println("존재하지 않습니다.");
				em.getTransaction().rollback();
				return;
			}
			
			//수정처리
			user.changeName("전우치");//DB가 아닌 영속컨텍스에 변경
			
			em.getTransaction().commit();//DB반영

			System.out.println("이름을 변경했습니다.");
			//수정내용 확인
			Member3 userDB = 
					em.find(Member3.class, "test@test.com");
			
			System.out.println("["+userDB+"]");
			System.out.println("이름:"+userDB.getName());
			
		}catch(Exception e) {
			 e.printStackTrace();
			 em.getTransaction().rollback();
		}finally {
			em.close();
		}
		emf.close();
	}
}
