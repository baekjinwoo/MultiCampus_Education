package employee;

public class EmpMain {
	public static void main(String[] args) {
		Developer dev=new Developer(101, "Scott", "5678");
		dev.setSalary(2500000);
		dev.setBonus(350000);
		System.out.println(dev.toString());
		
		Engineer eng=new Engineer(201,"Steve","1234");
		eng.setSalary(1500000);
		eng.setBonus(75000);
		System.out.println(eng.toString());
	}
}
/* 사원번호:101
 * 사원이름:Scott
 * 내선번호:5678
 * 기본급여:2500000
 * 보너스+수당:450000
 * 지급금액 : 2950000원
 * 
 * 사원번호:201
 * 사원이름:Steve
 * 내선번호:1234
 * 기본급여:1500000
 * 보너스+수당:225000
 * 지급금액 : 1725000원
 */

