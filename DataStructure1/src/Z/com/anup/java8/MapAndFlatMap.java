package Z.com.anup.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class MapAndFlatMap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<String> listForEmp1 = new ArrayList<>();
		listForEmp1.add("NY");listForEmp1.add("LA");listForEmp1.add("CHI");
		Employee e1 = new Employee(1, "Ram",listForEmp1);
		List<String> listForEmp2 = new ArrayList<>();
		listForEmp2.add("HOU");listForEmp2.add("MIA");listForEmp2.add("CHI");
		Employee e2 = new Employee(1, "Shyam",listForEmp2);
		List<String> listForEmp3 = new ArrayList<>();
		listForEmp3.add("NY");listForEmp3.add("SD");listForEmp3.add("WA");
		Employee e3 = new Employee(1, "Hari",listForEmp3);
		
		List<Employee> emplist = new ArrayList<>();
		emplist.add(e1);emplist.add(e2);emplist.add(e3);
		
		//Map 
		List<Integer> idList = 
				emplist.stream().map(emp->emp.getId()).collect(Collectors.toList());
		
		// to work in <list<list>> we need flatmap to get unique values
		
		Set<String> citiesWorked = 
				emplist.stream().flatMap(emp->emp.getListOfCities().stream()/// notes
						).collect(Collectors.toSet());
		
		System.out.println(citiesWorked);// 2d results to 1 D of unique 
	}

}
