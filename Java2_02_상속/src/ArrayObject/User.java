package ArrayObject;

//디폴트 생성자, 인자2개받는 생성자, setter&getter
// Entity, VO(Value Object), DTO(Data Transfer Object)
//: 관련성있는 데이터를 하나로 묶은 클래스

public class User {

	private String name;
	private String phone;

	public User(String name, String phone) {
		this.name = name;
		this.phone = phone;
	}

	public User() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

}
