package ArrayObject;

//오브젝트배열-1(객체배열)
public class UserMain2 {

	public static void main(String[] args) {
		User[] ob=new User[3];
		ob[0]=new User("Kim","010-123-4564");
		ob[1]=new User("lee","010-456-4579");
		ob[2]=new User("park","010-000-8754");
			
		for(int i=0;i<ob.length;i++){
			System.out.println(ob[i].getName()+"\t"+ob[i].getPhone());
		}
	}

}
