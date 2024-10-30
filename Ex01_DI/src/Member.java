import java.io.Serializable;

public class Member implements Serializable {

private static final long serialVersionUID = 1L;
	
private String name;
 private String nickname;
 
public Member(String name, 
		String nickname) {
	this.name = name;
	this.nickname = nickname;
}

public Member() {}

public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getNickname() {
	return nickname;
}
public void setNickname(String nickname) {
	this.nickname = nickname;
}
@Override
public String toString() {
	return "Member [name=" + name 
			+ ", nickname=" 
			+ nickname + "]";
}

}
