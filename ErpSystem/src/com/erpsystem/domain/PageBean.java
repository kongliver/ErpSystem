package com.erpsystem.domain;

import java.util.List;

/**
 * @功能 分页的Javabean类
 * @文件 PageBean.java
 * @作者 张洪刚
 * @时间 2018-09-30 22:51
 * @地点 成都
 */
public class PageBean<T> {

	/** 当前第几页 */
	private int currentPage;

	/** 页面显示条数（一页） */
	private int currentCount;

	/** 总共的条数 */
	private int totalCount;

	/** 总共的页数 */
	private int totalPage;

	/** 当前页面需要显示的数据 */
	private List<T> list;

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getCurrentCount() {
		return currentCount;
	}

	public void setCurrentCount(int currentCount) {
		this.currentCount = currentCount;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

}
