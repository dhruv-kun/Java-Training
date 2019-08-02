import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


abstract @interface Sample {
	String value();
}

public class ListSample {
	public static void main(String[] args) {
		List<Integer> iList = Arrays.asList(3, 41, 512, 13);
		List<String> sList = Arrays.asList("Beth", "John", "Lee");
	
		print(iList);
		print(sList);
		List<Integer> idList = new ArrayList<>();
		List<String> sdList = new ArrayList<>();
		
		copy(idList, iList);
		copy(sdList, sList);
		
		
		
	}
	@Sample(value="Data")
	private static <T> void copy(List<T> dList, List<T> list) {
		for (T o: list)
			dList.add(o);
		
	}
	// ? unknown type allows only accessors
	private static void print(List<?> list) {
		list.forEach(System.out::println);
	}
	
	
}
