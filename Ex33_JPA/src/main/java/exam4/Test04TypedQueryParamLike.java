package exam4;

import java.util.List;
import java.util.function.Consumer;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class Test04TypedQueryParamLike {
	public static void main(String[] args) {
		EntityManagerFactory emf =
			    Persistence.createEntityManagerFactory("JpaEx01");
				EntityManager em
				       = emf.createEntityManager();
				
 try {
	String email = "test.com";
    String paramValue = "%"+email+"%"; //%test.com%
    String name = "양";
    String nameValue = "%"+name+"%"; //%양%
    
    System.out.println("paramValue:" + paramValue);
    System.out.println("nameValue:" + nameValue);
    
   
    //createQuery(쿼리문, 클래스정보)
    TypedQuery<Member4> query=
  em.createQuery("select m from Member4 m "
  		        +" where m.email like :email "
  		        +" and m.name like :name "
  		        +" order by m.name",
		  Member4.class)
    .setParameter("email", paramValue)
    .setParameter("name", nameValue);
    	    
     List<Member4> result = query.getResultList();
    
     if(result.isEmpty()) {
    	 System.out.println("사용자가 없습니다.");
     }else {
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
