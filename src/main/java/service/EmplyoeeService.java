package service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import Entity.Employee;

public class EmplyoeeService {

	private static List<Employee> list = new ArrayList<Employee>();
	public void intiliazeEmployee() {
		Employee emp1= new Employee();
		emp1.setId(1);
		emp1.setFirstname("jay");
		emp1.setLastname("Mahajan");
		emp1.setUsername("jay");
		emp1.setPassword("123");
		emp1.setIsadmin(true);
		emp1.setSalary(100000);
		list.add(emp1);
		Employee emp2= new Employee(2,"vikram","singh","vikram","123",false,20000);
		list.add(emp2);
		//System.out.println(list);
	}
	public List<Employee> getEmployeeList() {
		return list;
	}
	public Employee login(String userName, String password) {
		
		Employee userEmployee=list.stream().filter(e->e.getUsername().equals(userName)&&e.getPassword().equals(password)).findFirst().orElse(null);
		if(userEmployee!=null)
			return userEmployee;
		
		return null;
	}
	public void addData(Employee e) {
		
		
		list.add(e);
		
	}
	public void updateUserEmployee(Employee employee) {
		
	int id=employee.getId();
	Employee employee2 = list.stream().filter(a->a.getId()==id).findFirst().orElse(null);
	employee2.setFirstname(employee.getFirstname());
	employee2.setLastname(employee.getLastname());
	employee2.setUsername(employee.getUsername());
	employee2.setPassword(employee.getPassword());
	employee2.setSalary(employee.getSalary());
	employee2.setIsadmin(employee.isIsadmin());
	System.out.println(list);
	
	
}
	public Employee editEmployee(int id) {
		Employee employee2 = list.stream().filter(a->a.getId()==id).findFirst().orElse(null);
		return employee2;
	}
	public void delete(int id) {
		Employee employee2 = list.stream().filter(a->a.getId()==id).findFirst().orElse(null);
		list.remove(employee2) ; 
		
	}
}
