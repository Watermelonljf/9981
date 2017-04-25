package org.nan.dao.impl;

import java.util.List;

import org.nan.dao.HabitDao;
import org.nan.entities.Habit;
import org.springframework.stereotype.Repository;



@Repository
public class HabitDaoImpl extends BaseDaoImpl<Habit> implements HabitDao{

	@Override
	public List<Habit> getAllHabits() {
		String hql = " FROM Habit";
		try {
			return getAll(hql, null);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean updateDaysUp(Integer id) {
		
		Habit habit = getOneById(id);
		habit.setDays(habit.getDays()+1);
		if(update(habit))
			return true;
		return false;
	}

	@Override
	public boolean updateDaysDown(Integer id) {
		Habit habit = getOneById(id);
		habit.setDays(habit.getDays()-1);
		if(update(habit))
			return true;
		return false;
	}
	
	
}


