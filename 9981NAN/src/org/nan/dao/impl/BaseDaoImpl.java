package org.nan.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.nan.dao.BaseDao;
import org.springframework.beans.factory.annotation.Autowired;
public class BaseDaoImpl<T> implements BaseDao<T>{
	@Autowired
	private SessionFactory sessionFactory;
	
	public Session getSession(){
		return sessionFactory.getCurrentSession();
	}
	/**
	 * 创建一个Class的对象来获取泛型的class
	 */
	private Class<?> clz;
	
	public Class<?> getClz() {
		if(clz==null) {
			//获取泛型的Class对象
			clz = ((Class<?>)
					(((ParameterizedType)(this.getClass().getGenericSuperclass())).getActualTypeArguments()[0]));
		}
		return clz;
	}
	
	
	@Override
	public boolean save(T t) {
		try {
			getSession().save(t);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean delete(Integer id) {
		try {
			getSession().delete(load(id));
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	

	@Override
	public boolean update(T t) {
		try {
			getSession().update(t);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public T load(Integer id) {
		return (T)getSession().load(getClz(), id);
	}
	
	@Override
	public T getOneById(Integer id) {
		return (T) getSession().get(getClz(), id);
	}

	
	@Override
	public List<T> getAll(String hql, Object[] args) {
		Session session = getSession();
		Query query = session.createQuery(hql);
		return setParamsByObjects(query, args).list();
	}


	@Override
	public Query setParamsByObjects(Query query, Object[] args) {
		if(args!=null && args.length>0){
			for(int i=0;i<args.length;i++){
				query.setParameter(i+1, args[i]);
			}
		}
		return query;
	}
	
	
	
}
