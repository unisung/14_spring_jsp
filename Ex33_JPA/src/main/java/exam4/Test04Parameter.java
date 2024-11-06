package exam4;

import java.util.List;
import java.util.Scanner;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class Test04Parameter {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		EntityManagerFactory emf =
				Persistence.createEntityManagerFactory("JpaEx01");
        EntityManager em 
           = emf.createEntityManager();
        try {
        	System.out.println("조회할 회원명?:");
        	String name = scanner.nextLine();
        	
        	//name파라미터를 조건으로 조회
        	TypedQuery<Member4> query
        	   =em.createQuery("select m from Member4 m "
        	   				 + " where m.name = :name "
        	   				 + " order by m.name",
        	   				 Member4.class)
        	   .setParameter("name", name);//파라미터 값세팅
        	//결과 리스트 얻기
        	List<Member4> result = query.getResultList();
        	//[양만춘,이순신],[]
          if(result.isEmpty())
        	  System.out.println("사용자가 없습니다.");
          else {
        	  result.forEach(user-> 
        	  System.out.printf("|%s|%s|%tY-%<tm-%<td|\n",
        			              user.getName(),
        			              user.getEmail(),
        			              user.getCreateDate())
        	  );
          }
        }catch (Exception e) {
        	e.printStackTrace();
		}finally {
			em.close();
			emf.close();
		}
	}
}