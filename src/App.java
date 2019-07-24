import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class App {

	public static void main(String[] args) {
		List<String> list=Arrays.asList("java","java","c","php","c");
		Map<String,Integer> map=new HashMap();
		for(String s:list) {
			map.put(s, map.getOrDefault(s,0)+1);
		}
		System.out.println(map);
		
		Map<String,Long> map2=list.stream()
				.collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
		System.out.println(map2);
	}
}
