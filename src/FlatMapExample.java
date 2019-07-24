import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Dept{
	int deptId;
	List<Emp> emps;
	Dept(int deptId, List<Emp> emps){
		this.deptId=deptId;
		this.emps=emps;
	}
}
class Emp{
	int salary;
	String name;
	Emp(int salary, String name){
		this.salary=salary;
		this.name=name;
	}
}
public class FlatMapExample {

	public static void getAllEmps(List<Dept> depts) {
		String emps="";
		for(Dept d:depts) {
			for(Emp e:d.emps) {
				emps=emps+e.name+", ";
			}
		}
		System.out.println(emps);
	}
	
	public static void getAllEmpsRefactor(List<Dept> depts) {
		String names = depts.stream().flatMap(d->d.emps.stream()).map(e->e.name).collect(Collectors.joining(", "));
		System.out.println(names);
	}
	
	public static void totalSalary(List<Dept> depts) {
		int total=0;
		for(Dept d:depts) {
			for(Emp e:d.emps) {
				total+=e.salary;
			}
		}
		System.out.println(total);
	}
	
	public static void totalSalaryRefactor(List<Dept> depts) {
		long  total = depts.stream().flatMap(d->d.emps.stream()).map(e->e.salary).reduce(0,Integer::sum);
		System.out.println(total);
	}
	
	public static void countNoOfEmpPerDept(List<Dept> depts) {
		Map<Integer,Integer> deptMap=new HashMap();
		for(Dept d:depts) {
			deptMap.put(d.deptId,d.emps.size());
		}
		System.out.println(deptMap);
	}
	public static void countNoOfEmpPerDeptRefactor(List<Dept> depts) {
		Map<Integer,Integer> deptMap=depts.stream().collect(Collectors.toMap(d->d.deptId, d->d.emps.size()));
		System.out.println(deptMap);
	}
	public static void main(String[] args) {
		List<Emp> e1=Arrays.asList(new Emp(1000,"A"),new Emp(5000,"B"));
		List<Emp> e2=Arrays.asList(new Emp(8000,"C"),new Emp(4500,"D"),new Emp(4800,"E"));
		List<Dept> depts=Arrays.asList(new Dept(1,e1), new Dept(2,e2),new Dept(3,e2));
		//getAllEmps(depts);
		//getAllEmpsRefactor(depts);
		//totalSalary(depts);
		//totalSalaryRefactor(depts);
		countNoOfEmpPerDeptRefactor(depts);
	}
}
