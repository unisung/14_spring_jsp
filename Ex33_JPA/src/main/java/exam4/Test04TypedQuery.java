package exam4;

import java.util.List;
import java.util.function.Consumer;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class Test04TypedQuery {
	public static void main(String[] args) {
		EntityManagerFactory emf =
			    Persistence.createEntityManagerFactory("JpaEx01");
				EntityManager em
				       = emf.createEntityManager();
				
 try {
   //query사용
   //createQuery(쿼리문, 클래스정보)
    TypedQuery<Member4> query=
  em.createQuery("select m from Member4 m order by m.name",
		  Member4.class);
    	    
     List<Member4> result = query.getResultList();
    
     if(result.isEmpty()) {
    	 System.out.println("사용자가 없습니다.");
     }else {
//    	 for(int i=0;i<result.size();i++) {
//    		 Member4 user = result.get(i);
//		 System.out.printf("| %s | %s | %tY-%<tm-%<td | \n",
//				 user.getEmail(),user.getName(), 
//				 user.getCreateDate());
//	 }
    	 
//    	 for(Member4 user:result) {
//    		 System.out.printf("| %s | %s | %tY-%<tm-%<td | \n",
//    				 user.getEmail(),user.getName(), 
//    				 user.getCreateDate());
//    	 }
    result.forEach(user-> 
    	     System.out.printf("| %s | %s | %tY-%<tm-%<td | \n",
				    user.getEmail(),user.getName(), 
			        user.getCreateDate())
    			 );
     }
    	    
	} catch (Exception e) {
		e.printStackTrace();
	}				
		
	}
}
