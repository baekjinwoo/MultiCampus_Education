package test1;


public class LambdaEx1 {
	public static void main(String[] args) {
	Print ob = new Print(){

		
	@Override
	public void view(){
		System.out.println("Hello Lambda");
			}
		};
		ob.view();
		
		
	}
}
