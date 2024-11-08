package com.study.springboot.jpa;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor(access=AccessLevel.PROTECTED)
@Builder
@Entity(name="JPAMEMBER03")
public class Member {
	@Id
	@SequenceGenerator(
			name="mySequence03",
			sequenceName = "JAPMEMBER03_SEQ",
			initialValue = 1,
			allocationSize = 1
			)
	@GeneratedValue(generator = "mySequence03")
	private Long id;
	private String name;
	private String email;
}
//스프링 부트는 3.2부터 더 이상 바이트코드를 파싱할때
//파라미터 이름을 추론하지 않는다고 한다.
//그리고 의존성 주입 또는 속성을 바인딩 할 때는 -parameters 옵션으로
//컴파일 했는지 꼭 확인하라고 한다.

//이클립스에서는 다음과 같이 설정하면 된다.
//상단 메뉴 - Window - Preferences - Java -
//Store information about method parameters (usable via reflection) 체크
