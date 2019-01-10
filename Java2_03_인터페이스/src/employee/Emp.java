package employee;

/*  -eno:int
 *  -ename:String
 *  -phone:String
 * 
 *  +Emp()
 *  +Emp(eno:int, ename:String, phone:String)
 *  +getter
 *  +setSalary(salary:long):void     --abstract
 *  +setBonus(bonus:long):void       --abstract
 */
abstract public class Emp {
	private int eno;
	private String ename;
	private String phone;
	
	public Emp() {
		//super(); 있어도 되고 없어도된다. 포함되는 클래스가 extends Object생략되어 있기때문에 작성되는 문구. 
	}
	public Emp(int eno, String ename, String phone) {
		//super(); 있어도 되고 없어도된다. 포함되는 클래스가 extends Object생략되어 있기때문에 작성되는 문구.
		this.eno = eno;
		this.ename = ename;
		this.phone = phone;
	}
	
	public int getEno() {
		return eno;
	}
	public String getEname() {
		return ename;
	}
	public String getPhone() {
		return phone;
	}
	abstract public void setSalary(long salary);
	abstract public void setBonus(long bonus);
}










