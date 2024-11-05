package exam3;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "JpaMember3")
public class Member3 {
	@Id
	private String email;
	private String name;
	@Column(name = "create_date")
	private LocalDate createDate;

	public Member3() {
	}

	public Member3(String email, String name, LocalDate createDate) {
		this.email = email;
		this.name = name;
		this.createDate = createDate;
	}

	public String getEmail() {
		return email;
	}

	public String getName() {
		return name;
	}

	public LocalDate getCreateDate() {
		return createDate;
	}

	// 이름변경 메소드
	public void changeName(String name) {
		this.name = name;
	}
}
