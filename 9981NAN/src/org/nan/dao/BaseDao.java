package org.nan.dao;

import java.util.List;

import org.apache.catalina.authenticator.SavedRequest;
import org.hibernate.Query;

/**
 * hibernate 基本操作
 * @author Watermelon_R
 *
 * @param <T>
 */
public interface BaseDao<T> {
	
	/**
	 * 保存一个对象
	 * @param t
	 */
	boolean save(T t);
	
	/**
	 * 删除对象,对象需要ID,hibernate可以删除游离对象
	 * @param t
	 */
	boolean delete(Integer id);
	
	/**
	 * 更新对象
	 * @param t
	 */
	boolean update(T t);
	
	
	public T load(Integer id);
	
	/**
	 * 查找一个对象根据Id
	 * @param id
	 * @return
	 */
	T getOneById(Integer id);
	
	/**
	 * 查找一组对象
	 * @return
	 */
	List<T> getAll(String hql, Object[] args);
	
	/**
	 * 设置hql一组问号值
	 * @param query
	 * @param args
	 * @return
	 */
	Query setParamsByObjects(Query query,Object[] args);
}
