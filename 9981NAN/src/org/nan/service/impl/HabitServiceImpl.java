package org.nan.service.impl;

import java.util.List;

import org.nan.action.habitAction;
import org.nan.dao.HabitDao;
import org.nan.entities.Habit;
import org.nan.service.HabitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class HabitServiceImpl implements HabitService{
	
	@Autowired
	private HabitDao habitDao;

	@Transactional(propagation=Propagation.REQUIRED)
	@Override
	public boolean add(Habit habit) {
		return habitDao.save(habit);
	}
	
	@Transactional(propagation=Propagation.REQUIRED)
	@Override
	public boolean delete(Integer id) {
		return habitDao.delete(id);
	}
	
	@Transactional(propagation=Propagation.REQUIRED)
	@Override
	public boolean update(Habit habit) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Habit getOne(Integer id) {
		return habitDao.getOneById(id);
	}
	@Transactional(readOnly=true)
	@Override
	public List<Habit> getAll() {
		List<Habit> allHabits = habitDao.getAllHabits();
			return allHabits;
	}

	@Override
	public boolean daysUp(Integer id) {
		return habitDao.updateDaysUp(id);
	}

	@Override
	public boolean daysDown(Integer id) {
		return habitDao.updateDaysDown(id);
	}
}
