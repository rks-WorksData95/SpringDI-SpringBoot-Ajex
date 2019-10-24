package com.SpringCrudPostman.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="student")
public class Student
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long studentId;
	
	@Column(name="studentName")
	private String studentName;
	
	@Column(name="studentDesignation")
	private String studentDesignation;

	public Student() 
	{
		super();
	}
	
	public Student(Long studentId, String studentName, String studentDesignation) 
	{
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.studentDesignation = studentDesignation;
	}

	public Student(String studentName, String studentDesignation) 
	{
		super();
		this.studentName = studentName;
		this.studentDesignation = studentDesignation;
	}

	public Long getStudentId()
	{
		return studentId;
	}

	public void setStudentId(Long studentId) 
	{
		this.studentId = studentId;
	}

	public String getStudentName() 
	{
		return studentName;
	}

	public void setStudentName(String studentName) 
	{
		this.studentName = studentName;
	}

	public String getStudentDesignation() 
	{
		return studentDesignation;
	}

	public void setStudentDesignation(String studentDesignation) 
	{
		this.studentDesignation = studentDesignation;
	}

	@Override
	public String toString()
	{
		return "Student [studentId=" + studentId + ", studentName=" + studentName + ", studentDesignation=" + studentDesignation
				+ "]";
	}
	
}
