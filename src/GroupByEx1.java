import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class GroupByEx1 {

	public static void countFruits() {
		List<String> fruits=Arrays.asList("apple","apple","mango","grapes","apple");
		Map<String,Integer> map=new HashMap();
		for(String s:fruits) {
			map.put(s, map.getOrDefault(s, 0)+1);
		}
		System.out.println(map);
	}
	
	public static void countFruitsRefactor1() {
		List<String> fruits=Arrays.asList("apple","apple","mango","grapes","apple");
		Map<String,Integer> map=new HashMap();
		fruits.forEach(f->{
			map.put(f, map.getOrDefault(f, 0)+1);
		});
		System.out.println(map);
	}
	
	public static void countFruitsRefactor2() {
		List<String> fruits=Arrays.asList("apple","apple","mango","grapes","apple");
		Map<String,Long> map=fruits.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		System.out.println(map);
	}
	
	
	public static void main(String[] args) {
		countFruits();
		countFruitsRefactor1() ;
		countFruitsRefactor2() ;
	}

}
