package homework01;
/*[����8] ���� ���α׷��� �ϼ��Ͻÿ�
		(1)Ŭ������ : Salary
		  -name:String
		  -salary:int
		  +Salary(name:String, int salary:int) 
		  +toString():String  ==>�̸��� ������ ����

		(2)Ŭ������ : Test8 ==> Salary�� ��ӹ���
		  -department:String
		  +Test8(name:String, salary:int,department:String)
		  +toString():String   ==>�μ��� ����

		(3)main()�Լ�����
		   public static void main(String[] args){
		         Test8 ob=new Test8("��ȣ��",85000000,"���ߺ�");
		         System.out.println(ob.toString()); 
		   }

		[���ȭ��]
		�̸� : ��ȣ��
		���� : 85000000
		�μ� : ���ߺ�*/

class Salary {
	private String name;
	private int salary;

	public Salary(String name, int salary) {
		this.name = name;
		this.salary = salary;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public void viewInfomation1() {
		System.out.println("�̸�: " + getName() + "\n����: " + getSalary());
	}
}

public class munjae08 extends Salary {
	private String department;

	public munjae08(String name, int salary, String department) {
		super(name, salary);
		this.department = department;
	}

	public void viewInfomation2() {
		// �λ����
		super.viewInfomation1();
		System.out.println("�μ�: " + department);
		
		//System.out.println("�̸�: " + getName() + "\n����: " + getSalary()+"�μ�: " + department); �̰ŵ� ����

		
	}

	public static void main(String[] args) {
		munjae08 ob = new munjae08("��ȣ��", 85000000, "���ߺ�");
		//ob.viewInfomation1();
		ob.viewInfomation2();

	}
}
