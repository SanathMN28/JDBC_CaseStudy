package com.sonata.DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.sonata.DAO.DoctorDAO;
import com.sonata.Model.Doctors;

public class DoctorDAOImpl implements DoctorDAO{
    int a=0;
    DBConnection db=new DBConnection();
    Connection con=db.getConnection();
    Doctors doc=null;
	@Override
	public int insert(Object obj) {
		doc=(Doctors)obj;
		try {
			PreparedStatement ps=con.prepareStatement("INSERT INTO doctor(doc_name,doc_specialization,doc_location,doc_contact) VALUES(?,?,?,?)");
			ps.setString(1, doc.getName());
			ps.setString(2, doc.getSpecialization());
			ps.setString(3, doc.getLocation());
			ps.setString(4, doc.getContact());
			
			a=ps.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return a;
	}

	

	@Override
	public int update(Object obj, int id) {
		doc=(Doctors)obj;
		try {
			
			PreparedStatement ps=con.prepareStatement("UPDATE doctor SET doc_name=?,doc_specialization=?,doc_location=?,doc_contact=? WHERE doc_id="+id);
			ps.setString(1, doc.getName());
			ps.setString(2, doc.getSpecialization());
			ps.setString(3, doc.getLocation());
			ps.setString(4, doc.getContact());
			
			a=ps.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return a;
	}



	@Override
	public int delete(int id) {
		try {
			PreparedStatement ps=con.prepareStatement("DELETE FROM doctor WHERE doc_id="+id);
			a=ps.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return a;
	}
	
	public Object access(int id) {
		Doctors d=new Doctors();
		try {
			PreparedStatement ps=con.prepareStatement("SELECT * FROM doctor WHERE doc_id="+id);
			ResultSet rs=ps.executeQuery();
			rs.next();
				d.setName(rs.getString(2));
				d.setSpecialization(rs.getString(3));
				d.setLocation(rs.getString(4));
				d.setContact(rs.getString(5));
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return d;
	}

}
