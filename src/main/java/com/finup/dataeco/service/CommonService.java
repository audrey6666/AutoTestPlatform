package com.finup.dataeco.service;

import java.util.Collection;
import java.util.List;

import com.finup.dataeco.utils.Paging;

/**
 * Common Service
 * 
 * @author shuzongrui
 *
 * @param <T>
 */
public interface CommonService<T> {

	/**
	 * 
	 * @param entity
	 * @return Long the id
	 * @throws Exception
	 */
	Long insert(T entity) throws Exception;

	/**
	 * <p>
	 * batch insert
	 * 
	 * @throws Exception
	 */
	void batchInsert(final List list) throws Exception;

	/**
	 * 
	 * @param params
	 *            Maybe a entity object. more usual, it's a Map or
	 *            parameterization Object
	 * @return
	 * @throws Exception
	 */
	int update(Object params) throws Exception;

	/**
	 * if exist do update otherwise, do insert
	 * 
	 * @throws Exception
	 */
	Object insertOrUpdate(T t) throws Exception;

	/**
	 * 
	 * @param id
	 *            usual, it's a Long Object
	 * @return
	 * @throws Exception
	 */
	int delete(Object id) throws Exception;

	/**
	 * 
	 * @param params
	 *            maybe an Array with the ids or a List ...
	 * @throws Exception
	 * 
	 */
	void batchDelete(final Object params) throws Exception;

	/**
	 * count the total number by the query params
	 * 
	 * @param params
	 *            Maybe a entity object. more usual, it's a Map or
	 *            parameterization Object
	 * @return
	 */
	int count(Object params);

	/**
	 * paging query
	 * 
	 * @param params
	 *            Maybe a entity object. more usual, it's a Map or
	 *            parameterization Object
	 * @param offset
	 *            = (pageIndex - 1) * pageSize
	 * @param size
	 *            the page size
	 * @return Collection usual, the element maybe a VO Object not the T
	 */
	Collection list(Object params, int offset, int size);

	/**
	 * <p>
	 * the default impl by count(Object params) + list(Object params, int
	 * offset, int size)
	 *
	 * @param paging
	 *            query paging which usually contain some propertities such as
	 *            params, pageIndex, pageSize ...
	 * @return for result Paging which usually contain some propertities such as
	 *         result(data), totalPage ...
	 */
	Paging list(Paging paging);

	/**
	 * normally query
	 * 
	 * @param params
	 * @return
	 */
	List select(Object params);

	/**
	 * 
	 * @param id
	 * @return T the entity
	 */
	T get(Long id);

	/**
	 * 
	 * @param params
	 *            usual, it's a Map or parameterization Object
	 * @return Object usual it's a VO or BO Object Or a List
	 */
	Object find(Object params);

	/**
	 * 
	 * @param params
	 *            usual, it's the Long id
	 * @return if exists, return true, otherwise return false
	 */
	boolean isExists(Object params);

	/**
	 * 
	 * @param params
	 *            usual, it's the Long id
	 * @return if exists for update, return true, otherwise return false
	 */
	boolean isExistsForUpdate(Object params);
}