package by.htp.library.dao;

import java.util.List;

import by.htp.library.model.BaseEntity;

public interface BaseDao<T extends BaseEntity> {
	
	void create(T entity);
	T read(int id);
	List<T> readAll();
	void update(T entity);
	void delete(int id);
	
	

}
