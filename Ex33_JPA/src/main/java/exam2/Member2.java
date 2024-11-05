package exam2;


import jakarta.persistence.Access;
import jakarta.persistence.AccessType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;

@Entity
public class Member2 {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Access(AccessType.FIELD)//필드로 접근
	private String username;
	@Access(AccessType.PROPERTY) //getter/setter로 접근
	private String password;

	@Transient
	private long itemstamp;
	transient private long timestamp2;
	
	protected Member2() {}
	
	public Member2(String username, String password) {
		this.username = username;
		this.password = password;
	}

 //@Access(AccessType.PROPERTY)이면 getter/setter추가해주어야함
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	

}
