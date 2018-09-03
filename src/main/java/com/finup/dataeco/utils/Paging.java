package com.finup.dataeco.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A usual, Simple Java Object for the Paging
 * 
 * @author Shu Zong Rui
 * @date 2012-03-10
 */
public class Paging {
	private final static int DEFAULT_PAGE_SIZE = 10;
	private final static int DEFAULT_PAGE_INDEX = 1;

	/**
	 * the total page number
	 */
	private int totalPage;

	/**
	 * the total item number
	 */
	private int total;

	/**
	 * the number of showed record for each page
	 */
	private int size = DEFAULT_PAGE_SIZE;

	/**
	 * the index for current page which is being accessed
	 */
	private int index = DEFAULT_PAGE_INDEX;

	/**
	 * the offset which the data is started to selected from
	 */
	private int offset;

	/**
	 * the index for previous page, the default value is 1
	 */
	private int prevPage = 1;

	/**
	 * the index for next page, the default value is 1
	 */
	private int nextPage = 1;

	private boolean hasNextPage = false;

	private boolean hasPrevPage = false;

	/**
	 * the data for query
	 */
	private List data;

	/**
	 * params a map which contains the query parameters
	 */
	private Map<String, Object> params = new HashMap<String, Object>();

	/**
	 * for data
	 */
	public static Paging getDataPaging(Paging paging, Integer total, List data) {
		if (paging == null)
			paging = new Paging();

		paging.setTotal(total != null ? total : 0);
		paging.setData(data);

		return paging;
	}

	public int getOffset() {
		return (index - 1) * size;
	}

	// getter and setter
	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage > 0 ? totalPage : 0;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total > 0 ? total : 0;
		this.setTotalPage((int) Math.ceil((double) total / size));
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = (size > 0) ? size : DEFAULT_PAGE_SIZE;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index > 0 ? index : DEFAULT_PAGE_INDEX;
	}

	public int getPrevPage() {
		return prevPage;
	}

	public void setPrevPage(int prevPage) {
		this.prevPage = prevPage < 1 ? 1 : prevPage;
	}

	public int getNextPage() {
		return nextPage;
	}

	public void setNextPage(int nextPage) {
		this.nextPage = nextPage > this.totalPage ? this.totalPage : nextPage;
	}

	public boolean isHasNextPage() {
		return index < totalPage ? true : false;
	}

	public void setHasNextPage(boolean hasNextPage) {
		this.hasNextPage = hasNextPage;
	}

	public boolean isHasPrevPage() {
		return index > 1 ? true : false;
	}

	public void setHasPrevPage(boolean hasPrevPage) {
		this.hasPrevPage = hasPrevPage;
	}

	public List getData() {
		if (data == null) {
			data = new ArrayList();
		}
		return data;
	}

	public void setData(List data) {
		this.data = data;
	}

	public Map<String, Object> getParams() {
		return params;
	}

	public void setParams(Map<String, Object> params) {
		this.params = params;
	}

	@Override
	public String toString() {
		return "Paging [totalPage=" + totalPage + ", total=" + total + ", size=" + size + ", index=" + index
				+ ", offset=" + offset + ", prevPage=" + prevPage + ", nextPage=" + nextPage + ", hasNextPage="
				+ hasNextPage + ", hasPrevPage=" + hasPrevPage + ", data=" + data + ", params=" + params + "]";
	}

}
