import java.io.IOException;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Test {
	
	public static void main(String[] args) throws IOException {
		List<Item> items = Arrays.asList(
                new Item("apple", 10, new BigDecimal("9.99")),
                new Item("banana", 20, new BigDecimal("19.99")),
                new Item("orang", 10, new BigDecimal("29.99")),
                new Item("watermelon", 10, new BigDecimal("29.99")),
                new Item("papaya", 20, new BigDecimal("9.99")),
                new Item("apple", 10, new BigDecimal("9.99")),
                new Item("banana", 10, new BigDecimal("19.99")),
                new Item("apple", 20, new BigDecimal("9.99"))
        );
		System.out.println(items);


        Map<String, Long> counting = items.stream().collect(
                Collectors.groupingBy(Item::getName, Collectors.counting()));

        System.out.println(counting);

        Map<String, Integer> sum = items.stream().collect(
                Collectors.groupingBy(Item::getName, Collectors.summingInt(Item::getQty)));

        Map<String,BigDecimal> totalPrice=items.stream().collect(
        						Collectors.groupingBy(Item::getName,Collectors.reducing(BigDecimal.ZERO,Item::getPrice,BigDecimal::add)));
        
        Map<String,BigDecimal> totalPrice1=items.stream().collect(
				Collectors.groupingBy(Item::getName,Collectors.mapping(Item::getPrice, Collectors.reducing(BigDecimal.ZERO,BigDecimal::add))));

        System.out.println(totalPrice);
        System.out.println(totalPrice1);
        
        
        Map<Integer,Set<String>> groupByQtyMap=items.stream().collect(
        		Collectors.groupingBy(Item::getQty,Collectors.mapping(Item::getName, Collectors.toSet())));
        System.out.println(groupByQtyMap);
	}

}
