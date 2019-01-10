package ArrayObject;

public class UserMain1 {

	public static void main(String[] args) {
		User ob1=new User("Kim","010-123-4564");
		User ob2=new User("lee","010-456-4579");
		User ob3=new User("park","010-000-8754");
			
		System.out.println(ob1.getName()+"\t"+ob1.getPhone());
		System.out.println(ob2.getName()+"\t"+ob2.getPhone());
		System.out.println(ob3.getName()+"\t"+ob3.getPhone());

		
	}

}
