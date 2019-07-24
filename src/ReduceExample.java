import java.util.Arrays;
import java.util.List;

public class ReduceExample {

	public static void addAll(List<List<Integer>> nos) {
		int sum = 0;
		for (int i = 0; i < nos.size(); i++) {
			for (int j = 0; j < nos.get(i).size(); j++) {
				sum += nos.get(i).get(j);
			}
		}
		System.out.println(sum);
	}

	public static void addAllRefactor1(List<List<Integer>> nos) {
		int sum = nos.stream().flatMap(no -> no.stream()).reduce(0, Integer::sum);
		System.out.println(sum);
	}

	public static void addAll1(List<List<List<Integer>>> nos) {
		int sum = 0;
		for (int i = 0; i < nos.size(); i++) {
			for (int j = 0; j < nos.get(i).size(); j++) {
				for (int k = 0; k < nos.get(i).get(j).size(); k++) {
					sum += nos.get(i).get(j).get(k);
				}

			}
		}
		System.out.println(sum);
	}
	
	public static void addAll1Refactor1(List<List<List<Integer>>> nos) {
		int sum = nos.stream().flatMap(no->no.stream()).flatMap(no->no.stream()).reduce(0, Integer::sum);
		System.out.println(sum);
	}

	public static void main(String[] args) {

		List<List<Integer>> list = Arrays.asList(Arrays.asList(1, 2), Arrays.asList(3, 4));
		addAll(list);
		addAllRefactor1(list);
		
		List<List<List<Integer>>> list1 = Arrays.asList(Arrays.asList(Arrays.asList(1, 2),Arrays.asList(3, 4)));
		addAll1(list1);
		
		addAll1Refactor1(list1);

	}

}
