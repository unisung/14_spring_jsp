package exam3;

import java.beans.PersistenceDelegate;
import java.time.LocalDate;
import java.util.Scanner;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class Test01Insert {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		EntityManagerFactory emf =
		   Persistence.createEntityManagerFactory("JpaEx01");
		EntityManager em
		          = emf.createEntityManager();
		
		try {
			 em.getTransaction().begin();
			
			System.out.println("입력하려는 이메일?:");
			String email = scanner.nextLine();
			
			System.out.println("입력하려는 이름?:");
			String name = scanner.nextLine();
				
			System.out.println("이메일확인: " + email);
			System.out.println("이름확인: " + name);	
				
			Member3 user 
			    = new Member3(email,name,LocalDate.now());
			
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
