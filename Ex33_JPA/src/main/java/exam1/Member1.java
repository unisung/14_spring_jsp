package exam1;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity//테이블 생성(매핑) 어노테이션
@Table(name="JpaMember1")//테이블명을 지정할때
public class Member1 {//@Table어노테이션 없으면 클래스명으로 table생성
	@Id //@Entity어노테이션을 붙이면 @Id어노테이션이 반드시 있어야함.
	@GeneratedValue//자동발번되는 속성
	private Long id;
	private String username;
	@Column(name="create_date")//테이블은 - snake방식
	private LocalDate createDate;//JAVA-카멜방식네이밍
	
	protected Member1() {}

	public Member1(String username, 
			            LocalDate createDate) {
		this.username = username;
		this.createDate = createDate;
	}
}
/*
@Entity : 해당 클래스가 JPA의 엔티티임을 의미
@Id : 엔티티 클래스의 식별자 - DB 테이블의 주요 키에 매핑한다.
@Column : 매핑할 테이블의 컬럼 이름을 지정한다.
		  필드에 어노테이션이 없으면, 필드 이름과 동일한 이름의
		  테이블 컬럼에 매핑한다.
* 참고
* java.util.Date 타입을 매핑할 때는 @Timestamp 어노테이션을 사용했다.
  Java 8에 LocalDateTime 추가되고 (거의) 사용하지 않는다.
TemporalType.? 열거 타입
- DATE : java.sql.Date 에 해당
- TIME : java.sql.Time 에 해당
- TIMESTAMP : java.sql.Timestamp 에 해당

@GeneratedValue(strategy = GenerationType.IDENTITY)
- 기본키 생성을 데이터베이스에게 위임하는 방식으로 id값을 따로 할당하지 않아도
  데이터베이스가 자동으로 AUTO_INCREMENT를 하여 기본키를 생성
@GeneratedValue(strategy = GenerationType.SEQUNCE)
		  
 */
