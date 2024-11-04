package exam1;

import java.time.LocalDate;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Member1 {
	@Id
	@GeneratedValue//자동발번되는 속성
	private Long id;
	private String username;
	private LocalDate createDate;
	
	protected Member1() {}

	public Member1(String username, 
			            LocalDate createDate) {
		this.username = username;
		this.createDate = createDate;
	}
}
