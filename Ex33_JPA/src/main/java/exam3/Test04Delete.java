package exam3;

import java.util.Scanner;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Test04Delete {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		EntityManagerFactory emf =
		   Persistence.createEntityManagerFactory("JpaEx01");
		EntityManager em
		          = emf.createEntityManager();
		
		try {
			 em.getTransaction().begin();
			
			System.out.println("삭제하려는 이메일?:");
			String email = scanner.nextLine();
			
			System.out.println("이메일확인: " + email);
			
			Member3 user 
			    = em.find(Member3.class, email);
			
			//"test@test.com"정보가 없으면
			if(user == null) {
				System.out.println("존재 하지 않습니다.");
				em.getTransaction().rollback();
				return;
			}
			//"test@test.com" 정보가 있으면 삭제처리
			em.remove(user); //영속영에서 객체 제거
			
			em.getTransaction().commit();//DB반영
			
			System.out.println("탈퇴 처리 했습니다.");
			
		}catch(Exception e) {
			 e.printStackTrace();
			 em.getTransaction().rollback();
		}finally {
			em.close();
		}
		emf.close();
	}
}
