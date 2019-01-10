package emp;

import java.util.ArrayList;
import java.util.List;

//데이타베이스에서 자원을 가져올 용도로 사용됨(DAO : Data Access Object)
public class EmpDao {
	List<EmpVo> list=null;

	public EmpDao(){
		list=new ArrayList<>();
		list.add(new EmpVo("kim","영업부",1000000));
		list.add(new EmpVo("lee","관리부",1650000));
		list.add(new EmpVo("park","개발부",1350000));
	}
	
	
	
	
	public List <EmpVo> getEmpList(){
		return list;
	}
	
	
	
	
	public EmpVo getEmp(String name){
		for(EmpVo ob:list){
			if(ob.getEname().equals(name)){
				return ob;
			}
		}
	return null;
	}



}