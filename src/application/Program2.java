package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		System.out.println("*** Testing the Department class");

		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();

		System.out.println("*** TEST 1: Department insert ***");
		Department newDepartment = new Department(null, "RH");
		departmentDao.insert(newDepartment);
		System.out.println("Inserted! New id: " + newDepartment.getId());

		System.out.println("***TEST 2: Department Update");
		Department dep2 = departmentDao.findById(1);
		dep2.setName("Sales");
		departmentDao.update(dep2);
		System.out.println("Update completed");
		
		System.out.println("***TEST 3: Department deleteByID");
		System.out.print("Enter id for delete test: ");
		int id = sc.nextInt();
		departmentDao.deleteById(id);
		System.out.println("Delete completed");
		
		System.out.println("***TEST 4: Department findById");
		Department dep = departmentDao.findById(1);
		System.out.println(dep);
		
		System.out.println("***TEST 5: Department findAll");
		List<Department> list = departmentDao.findAll();
		for (Department d : list) {
			System.out.println(d);
		
		}
		sc.close();	
	}
}
