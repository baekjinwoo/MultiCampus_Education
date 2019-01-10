package ObjectEx;
/*    + (public)    -(private)    #(protected)
+name:String              
+k:int
+e:int
+m:int

+setUser(name:String, k:int, e:int, m:int):void
+getTotal():int
+getUser():String
*/

public class User {

	public String name;
	public int k;
	public int e;
	public int m;

	public void setUser(String name, int k, int e, int m) {
		this.name = name;
		this.k = k;
		this.e = e;
		this.m = m;

	}

	public int getTotal() { // 인자를 넣으면 x
		return k + e + m;
	}

	public String getUser() { // 인자를 넣으면 x
		return "나의 이름은" + name + "이고 총점은" + getTotal() + "점입니다";

	}
}
