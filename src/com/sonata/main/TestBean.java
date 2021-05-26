package com.sonata.main;

import java.util.Scanner;

import com.sonata.DAOImpl.DoctorDAOImpl;
import com.sonata.Model.Doctors;

public class TestBean {
	static DoctorDAOImpl dao;
	static Scanner scan;
	public static void main(String[] args) {
		dao=new DoctorDAOImpl();
		TestBean t=new TestBean();
		scan=new Scanner(System.in);
		System.out.println(("Enter 1:To insert,2:To update,3:To delete"));
		int choice=scan.nextInt();
		switch(choice) {
		case 1:t.insertion();
		       break;
		case 2:t.updation();
		       break;
		case 3:t.deletion();
		       break;
		default:System.out.println("Invalid input");
		}
		

	}
	
	public void insertion() {
		Doctors d=new Doctors();
		scan.nextLine();
		System.out.println("Enter Your name");
		d.setName(scan.nextLine());
		System.out.println("Enter Your specialization ");
		d.setSpecialization(scan.nextLine());
		System.out.println("Enter Your Location");
		d.setLocation(scan.nextLine());
		System.out.println("Enter Your contact ");
		d.setContact(scan.nextLine());
		
		System.out.println("Row inserted "+dao.insert(d));
	}

	public void updation() {
		System.out.println("Enter your ID");
		int id=scan.nextInt();
		Doctors d=(Doctors) dao.access(id);
		System.out.println("Enter To update 1:Name,2:Specialization,3:Location,4:Contact");
		int choice=scan.nextInt();
		switch(choice) {
		case 1:System.out.println("Enter Your Name to update");
		       scan.nextLine();
		       d.setName(scan.nextLine());
		       dao.update(d, id);
		       break;
		case 2:System.out.println("Enter Your Specialization to update");
		       scan.nextLine();
	           d.setSpecialization(scan.nextLine());
	           dao.update(d, id);
	           break;
		case 3:System.out.println("Enter Your location to update");
		       scan.nextLine();
	           d.setLocation(scan.nextLine());
	           dao.update(d, id);
	           break;
		case 4:System.out.println("Enter Your Contact to update");
		       scan.nextLine();
	           d.setContact(scan.nextLine());
	           dao.update(d, id);
	           break;
	    default :System.out.println("Invalid Option");
		}
	}
	
	public void deletion() {
		System.out.println("Enter Your id to delete");
		dao.delete(scan.nextInt());
	}
}
