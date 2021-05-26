package com.sonata.DAO;

public interface DoctorDAO {
	//public void display();
	public int insert(Object obj);
	public int update(Object obj,int id);
	public int delete(int id);

}
