package application;

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
		
		sc.close();
		}

}
