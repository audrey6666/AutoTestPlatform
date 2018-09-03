package com.finup.dataeco.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface CommonMapper<T> {

	/**
	 * @param entity
	 *            the id will be return with it
	 * @return Long the id
	 */
	Long insert(T entity);

	/**
	 * @param list
	 */
	void batchInsert(final List list);

	/**
	 * @param params
	 * @return
	 */
	int update(Object params);

	/**
	 * @param entity
	 *            usual, it's a Long Object
	 * @return
	 */
	int delete(Object entity);

	/**
	 * @param params
	 *            maybe an Array with the ids or a List ...
	 */
	void batchDelete(Object params);

	/**
	 * count the total number by the query params
	 * 
	 * @param params
	 *            Maybe a entity object. more usual, it's a Map or
	 *            parameterization Object
	 * @return
	 */
	int count(@Param(value = "params") Object params);

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
	 * @return List the element maybe a VO Object not the T
	 */
	List list(@Param(value = "params") Object params, @Param(value = "offset") int offset,
			@Param(value = "size") int size);

	/**
	 * normally query
	 * 
	 * @param params
	 * @return
	 */
	List select(Object params);

	/**
	 * @param id
	 * @return T the entity
	 */
	T get(Long id);

	/**
	 * @param params
	 *            usual, it's a Map or parameterization Object
	 * @return Object usual it's a VO or BO Object
	 */
	Object find(Object params);

	/**
	 * @param params
	 *            usual, it's the String Object
	 * @return if int > 0 , indicate exists
	 */
	int isExists(Object params);

	/**
	 * @param params
	 *            usual, it's the String Object
	 * @return if int > 0 , indicate exists
	 */
	int isExistsForUpdate(Object params);

	/**
	 * 本地缓存最新数据
	 * 
	 * @param params
	 * @return
	 */
	Object last(Object params);

}