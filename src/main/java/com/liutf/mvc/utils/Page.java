package com.liutf.mvc.utils;

/**
 * 翻页， 用法，让需要翻页的实体类来集成它
 * 
 * @author liutf
 * 
 */
public class Page {

	private int page;// 页数
	private int rows;// 每页显示条数
	@SuppressWarnings("unused")
	private int startIndex;// 起始行
	private String sort;// 排序条件
	private String order;// 排序规则

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.startIndex = (this.page - 1) * this.rows;
		this.rows = rows;
	}

	public int getStartIndex() {
		return (this.page - 1) * this.rows;
	}

	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

}