package org.nan.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;


@Entity
@Table(name="t_habit")
public class Habit {
	private Integer id;   //记录id
	private String name;  
	
	private Integer days;
	private String about;
	private Date startTime;
	
	
	public Habit() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Habit(Integer id, String name, Integer days, String about,
			Date startTime) {
		super();
		this.id = id;
		this.name = name;
		this.days = days;
		this.about = about;
		this.startTime = startTime;
	}
	@Id
	@GeneratedValue
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getDays() {
		return days;
	}
	public void setDays(Integer days) {
		this.days = days;
	}
	public String getAbout() {
		return about;
	}
	public void setAbout(String about) {
		this.about = about;
	}
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="start_time")
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	@Transient
	@Override
	public String toString() {
		return "Habit [id=" + id + ", name=" + name + ", days="
				+ days + ", about=" + about + ", startTime=" + startTime + "]";
	}

	
	
	
	
}
