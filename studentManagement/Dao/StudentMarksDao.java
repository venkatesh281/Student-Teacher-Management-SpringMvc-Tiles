package com.studentManagement.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.studentManagement.StudentMarks;
@Repository
@Transactional
public class StudentMarksDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
    
	

	public int saveStudentMarks(StudentMarks s) {
		
		
		
		String sql = "insert into studentmarks(RollNum,Name,Tamil,English,Maths,science,SocialScience,Total,Grade) values('" + s.getRollnum() + "','"
				+ s.getName() + "','" + s.getTamil() + "','" + s.getEnglish() + "','" + s.getMaths() + "','" + s.getScience()
				+ "','" +s.getSocialScience()+"','" +s.getTotal()+"','" +s.getGrade()+ "')";
		return jdbcTemplate.update(sql);
	}
    

	public int updateStudentMarks(StudentMarks s) {
		
		
		String sql = "update studentmarks set Name='" + s.getName() + "', Tamil='" + s.getTamil() + "',English='"
				+ s.getEnglish() + "',Maths='" + s.getMaths() + "',science='" + s.getScience() + "', SocialScience='"
				+ s.getSocialScience() + "', Total='" + s.getTotal() + "', Grade='" + s.getGrade() +"' where RollNum=" + s.getRollnum() + "";
		return jdbcTemplate.update(sql);
	}
    

	public int deleteStudentMarks(int rollNum) {
		String sql = "delete from studentmarks where RollNum=" + rollNum + "";
		return jdbcTemplate.update(sql);
	}

	public StudentMarks getStudentMarksByRollNum(int rollNum) {
		String sql = "select * from studentmarks where RollNum=?";
		return jdbcTemplate.queryForObject(sql, new Object[] { rollNum },
				new BeanPropertyRowMapper<StudentMarks>(StudentMarks.class));
	}
	
	

	public List<StudentMarks> getStudentMarks() {
		return jdbcTemplate.query("select * from studentmarks", new RowMapper<StudentMarks>() {
			public StudentMarks mapRow(ResultSet rs, int row) throws SQLException {
				StudentMarks studentmarks = new StudentMarks();
				studentmarks.setRollnum(rs.getInt(1));
				studentmarks.setName(rs.getString(2));
				studentmarks.setTamil(rs.getInt(3));
				studentmarks.setEnglish(rs.getInt(4));
				studentmarks.setMaths(rs.getInt(5));
				studentmarks.setScience(rs.getInt(6));
				studentmarks.setSocialScience(rs.getInt(7));
			    studentmarks.setTotal(rs.getInt(8));
			    studentmarks.setGrade(rs.getString(9));
			  
				return studentmarks;
			}

		});

	}
	
}
