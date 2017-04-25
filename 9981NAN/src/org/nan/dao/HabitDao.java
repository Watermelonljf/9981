package org.nan.dao;

import java.util.List;

import org.nan.entities.Habit;

import sun.security.action.GetBooleanAction;

public interface HabitDao extends BaseDao<Habit>{
	List<Habit> getAllHabits();
	boolean updateDaysUp(Integer id);
	boolean updateDaysDown(Integer id);
}	
