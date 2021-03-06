package com.ccea.persistence.model;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * generic DAO interface
 * 
 * @author abuayyub
 * 
 * @param <T>
 */
public interface CceaDAO<T> extends Serializable {

	public List<T> findAll();

	public T findById(Integer id);

	public T findByName(String field, String value);

	// public List<T> findByObject (Object obj);

	List<T> findByName(Map<String, String> field);

}
