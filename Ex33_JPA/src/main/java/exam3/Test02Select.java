package exam3;

import java.time.LocalDate;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Test02Select {
	public static void main(String[] args) {
		EntityManagerFactory emf =
		   Persistence.createEntityManagerFactory("JpaEx01");
		EntityManager em
		          = emf.createEntityManager();
		try {
			Member3 user 
			    = em.find(Member3.class, "test@test.com");
			System.out.println("["+ user +"]");
			
			if(user !=null) {
				System.out.println("이름: " + user.getName());
				System.out.printf("생성: %tY-%<tm-%<td\n",
						           user.getCreateDate());
			}else { //user == null
				System.out.println("존재하지 않습니다.");
			}
		}catch(Exception e) {
			 e.printStackTrace();
		}finally {
			em.close();
		}
		emf.close();
	}
}
