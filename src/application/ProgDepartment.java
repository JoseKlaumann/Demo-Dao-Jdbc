package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class ProgDepartment {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		DepartmentDao depDao = DaoFactory.createDepartmentDao();
		
	    System.out.println("=== TEST 1: department findById ====");
	    Department dep = depDao.findById(3);
	    System.out.println(dep);
	    
	    System.out.println("\n=== TEST 2: department findAll ====");
	    List<Department> list = depDao.findAll();
	    for (Department obj : list) {
	    	System.out.println(obj);
	    }
		
		sc.close();
		}

}
