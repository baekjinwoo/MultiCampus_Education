package ArrayObject;

//오브젝트배열-2(객체배열)
public class UserMain3 {

	public static void main(String[] args) {
		User[] ob=new User[]{
								new User("Kim","010-123-4564"),
								new User("lee","010-456-4579"),
								new User("park","010-000-8754")
							};
		
		for(User m:ob){ //forEach문장
			System.out.println(m.getName()+"\t"+m.getPhone());
		}
		
		
	}
}
