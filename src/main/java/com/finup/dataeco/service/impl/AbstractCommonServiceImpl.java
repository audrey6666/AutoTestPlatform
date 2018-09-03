package com.finup.dataeco.service.impl;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.reflect.FieldUtils;

import com.finup.dataeco.mapper.CommonMapper;
import com.finup.dataeco.service.CommonService;
import com.finup.dataeco.utils.Paging;

/**
 * A abstract impl for CommonService the subclass must be impl the relative
 * abstract method
 *
 * @author shuzongrui
 *
 * @param <T>
 */
public abstract class AbstractCommonServiceImpl<T> implements CommonService<T> {
	// private static final Logger LOGGER =
	// LoggerFactory.getLogger(AbstractCommonService.class);

	private final static int DEFAULT_PAGE_SIZE = 20;

	protected abstract CommonMapper<T> getCommonMapper();

	@Override
	public Long insert(T t) throws Exception {
		getCommonMapper().insert(t);
		Field field = FieldUtils.getField(t.getClass(), "id", true);
		Object id = field.get(t);
		return id instanceof Long ? (Long) id : null;
	}

	@Override
	public void batchInsert(List list) {
		if (list != null && !list.isEmpty()) {
			getCommonMapper().batchInsert(list);
		}
	}

	@Override
	public int update(Object params) throws Exception {
		return getCommonMapper().update(params);
	}

	@Override
	public int delete(Object id) throws Exception {
		return getCommonMapper().delete(id);
	}

	@Override
	public Object insertOrUpdate(T t) throws Exception {
		if (isExists(t))
			this.update(t);
		else
			this.insert(t);
		return t;
	}

	@Override
	public void batchDelete(Object params) throws Exception {
		getCommonMapper().batchDelete(params);
	}

	@Override
	public int count(Object params) {
		return getCommonMapper().count(params);
	}

	@Override
	public List list(Object params, int offset, int size) {
		return getCommonMapper().list(params, offset > 0 ? offset : 0, size > 0 ? size : DEFAULT_PAGE_SIZE);
	}

	@Override
	public Paging list(Paging paging) {
		if (paging == null)
			paging = new Paging();
		Map<String, Object> params = paging.getParams();
		int totalRecord = this.count(params);
		List result = this.list(params, paging.getOffset(), paging.getSize());
		return Paging.getDataPaging(paging, totalRecord, result);
	}

	@Override
	public List select(Object params) {
		return getCommonMapper().select(params);
	}

	@Override
	public T get(Long id) {
		return (T) getCommonMapper().get(id);
	}

	@Override
	public Object find(Object params) {
		return getCommonMapper().find(params);
	}

	@Override
	public boolean isExists(Object params) {
		return getCommonMapper().isExists(params) > 0 ? true : false;
	}

	@Override
	public boolean isExistsForUpdate(Object params) {
		return getCommonMapper().isExistsForUpdate(params) > 0 ? true : false;
	}

}