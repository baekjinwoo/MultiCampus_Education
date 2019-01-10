package employee;

/* Emp클래스를 상속 받은후 
 * -salary:long
 * -bonus:long
 * 
 * +Engineer()
 * +Engineer(eno:int, ename:String, phone:String)
 * +toString():String
 * 
 *  [조건]
 *  보너스+=150000을 수당으로 지급
 */
public class Engineer extends Emp{
	private long salary;
	private long bonus;
	
	public Engineer() {
		super();
	}
	public Engineer(int eno, String ename, String phone) {
		super(eno, ename, phone);
	}
	@Override
	public void setSalary(long salary) {
		this.salary=salary;
	}
	@Override
	public void setBonus(long bonus) {
		this.bonus=bonus+150000;
	}
	public String toString(){
		return "사원번호:"+super.getEno() 
				+"\n사원이름:"+super.getEname()
				+"\n내선번호:"+super.getPhone()
				+"\n기본급여:"+salary
				+"\n보너스+수당:"+bonus
				+"\n지급금액:"+(salary+bonus)+"원\n";
	}	
}
