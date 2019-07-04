package app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import model.Department;
import model.Employee;

public class Main {
	
	public static void startsWithA() {
		List<String> strList = new ArrayList<String>();		
		strList.add("Toy");
		strList.add("Apple");
		strList.add("Art");
		strList.add("Band");
		strList.add("Java");
		strList.add("And");
		strList.add("Tip");
		strList.add("arg");
		
		
		strList.stream()
			.filter((str) -> str.toLowerCase().startsWith("a") && str.length() == 3)
			.collect(Collectors.toList())
			.forEach(System.out::println);				
	}
	
	public static int startsWithE(String str1, String str2) {
		if(str1.toLowerCase().startsWith("e")) {
			return -1;
		}
		else {
			return 1;
		}		
	}
	
	public static String getString(List<Integer> list) {
	 return list.stream()
	  .map(i -> i % 2 == 0 ? "e" + i : "o" + i)
	  .collect(Collectors.joining(","));
	}
	
	private static List<Employee> createSmallCompany() {

		Department technologyDept = new Department();
		technologyDept.setId(1);
		technologyDept.setDepartmentName("Technology");
		
		Department hrDept = new Department();
		hrDept.setId(2);
		hrDept.setDepartmentName("Human Resource");
		
		Department payrollDept = new Department();
		payrollDept.setId(3);
		payrollDept.setDepartmentName("Payroll");
		
		List<Employee> employees = new ArrayList<Employee>();
		
		employees.add(new Employee(1, "Tom", 200000, null, hrDept));
		employees.add(new Employee(2, "Joe", 95000, 1, hrDept));
		
		employees.add(new Employee(3, "Julie", 180000, null, technologyDept));
		employees.add(new Employee(4, "Adam", 140000, 3, technologyDept));
		employees.add(new Employee(5, "James", 135000, 3, technologyDept));
		
		employees.add(new Employee(6, "Jake", 125000, null, payrollDept));
		
		return employees;
	}

	public static void main(String[] args) {

		//Assignment
		System.out.println("Assignment Solutions");
		
		//Make an array containing a few Strings
		String[] array = {"Ferhat", "Mike", "Eli", "Allen", "Ellis", "Chad", "Mohamadou"};
		//length (i.e., shortest to longest)
		System.out.println("Shortest to Longest");
		Arrays.sort(array, (s1, s2) -> s1.length() - s2.length());
		Arrays.asList(array).forEach(System.out::println);
				
		//reverse length (i.e., longest to shortest)
		System.out.println("Longest to Shortest");
		Arrays.sort(array, (s1, s2) -> s2.length() - s1.length());
		System.out.println("---------------------");
		Arrays.asList(array).forEach(System.out::println);
		
		//alphabetically by the first character only
		System.out.println();
		System.out.println("Alphabetically by the first character only");
		Arrays.sort(array, (s1, s2) -> s1.charAt(0) - s2.charAt(0));
		Arrays.asList(array).forEach(System.out::println);
		
		//Strings that contain “e” first, everything else second. For now, put the code directly in the lambda.
		System.out.println("=================Starts with 'e' first======================================");
		
		Arrays.stream(array)
			.sorted((str1, str2) -> {
				if(str1.toLowerCase().startsWith("e")) {
					return -1;
				}
				else {
					return 1;
				}
		}).forEach(System.out::println);
		
		System.out.println("=================Starts with 'e' first with helper======================================");
		Arrays.sort(array, (str1, str2) -> startsWithE(str1, str2));
		Arrays.stream(array).forEach(System.out::println);
		
		//Using Java 8 features write a method that returns a comma separated string
		//based on a given list of integers.
		System.out.println();
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		System.out.println("COMMA SEPERATED VALUES");
		System.out.println(getString(list));
		
		//Strings that contain “e” first, everything else second. 
		//For now, put the code directly in the lambda.
		System.out.println();
		System.out.println("'E' FIRST");
		List<String> practice = Arrays.asList("Ferhat", "Mike", "Eli", "Allen", "Ellis", "Chad", "Mohamadou");
		practice.stream()
		.filter((s1) -> s1.charAt(0) == 'E')
		//put the filter back at the front 
		.forEach(System.out :: println);

		System.out.println();
		
		startsWithA();
		
		//Employee with the max salary
		List<Employee> employees = createSmallCompany();
		Employee empWithMaxSalary =
				employees
				.stream()
				.reduce(new Employee(), (e1,e2) -> e1.getSalary() > e2.getSalary() ? e1 : e2);
		System.out.println("---------------------");
		System.out.println(empWithMaxSalary.getName());
		
		//List Employees whose manager is Julie
		List<Employee> empWithSameManager =
				employees
				.stream()
				.filter(e -> e.getManagerId() != null && e.getManagerId() == 3)
				.collect(Collectors.toList());
		
		String result =
				empWithSameManager
				.stream()
				.map(e -> e.getName())
				.collect(Collectors.joining(" and ", " same manager: ", " report to Julie "));
		System.out.println(result);
		
		//Who has neither manager
		
		System.out.println("Employees with no managers");
		employees
		.stream()
		.filter(e -> e.getManagerId() == null)
		.collect(Collectors.toList())
		.forEach(e -> System.out.println(e.getName()));
		
		}

	}
