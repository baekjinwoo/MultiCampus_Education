package ObjectEx;

public class ObjectEx4 {

	public static void main(String[] args) {
		Employee  em=new Employee();
		//setter로 값을 대입하고 toString()로 출력하시오 //이순신//개발부//1500000/85.75
		
		
		
		em.setName("이순신");
		em.setDept("개발부");
		em.setPay(1500000);
		em.setScore(87.75);
		System.out.println(em.toString()); //방법1

		
		em.setName("진달래");
		em.setDept("경리부서");
		em.setPay(1200000);
		em.setScore(75.34);
		System.out.println(em.toString());

		
		em.setEmpleoyy("진달래2","경리부서2",1200000,75.34);
		System.out.println(em.toString()); //방법2
		
		
		//getter로 출력하시오
	}
}
/*
 * 이름은 이순신이고 개발부에 근무하며 급여는 1500000원 입사성적은 85.75입니다
 * 
 * 사원이름 : 진달래 근무부서 : 경리부 받는급여 : 1200000원 입사점수 : 75.34점
 */
