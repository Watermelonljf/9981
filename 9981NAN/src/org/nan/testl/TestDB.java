package org.nan.testl;

import java.util.Date;

import javax.swing.Spring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.nan.dao.HabitDao;
import org.nan.dao.impl.HabitDaoImpl;
import org.nan.entities.Habit;
import org.nan.service.HabitService;
import org.nan.service.impl.HabitServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class TestDB extends AbstractJUnit4SpringContextTests{
	
	
	ApplicationContext ctx = null;
	{
		ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
	}
	
	
	@Test
	public void testHabitSave(){
		HabitService habitService = new HabitServiceImpl();
		Habit habit = new Habit();
		habit.setAbout("背英语");
		habit.setName("习惯1");
		habit.setStartTime(new Date());
		habit.setDays(1);
		habitService.add(habit);
		
	}
	
	@Test 
	public void testGetOne(){
		
		HabitDao habitDao = new HabitDaoImpl();
		habitDao.getAllHabits();
		
	}
	
}
