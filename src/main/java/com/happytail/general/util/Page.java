package com.happytail.general.util;

import java.util.List;

public class Page<T> {
	
	//一頁幾個
	private Integer pageSize;
	
	//現在的頁數
	private Integer currentPage;
	
	private Integer totalPages;
	
	private Integer totalNum;
	
	private List<T> records;
	
	public Page(List<T> records, Integer pageNum, Integer pageSize, long totalCount) {
		this.records = records;
		this.pageSize = pageSize;
		this.currentPage = pageNum;
		this.totalPages = (int) Math.ceil(totalCount/pageSize);
		this.totalNum = (int)totalCount;
	}
	
	public Page() {
		
	}
	
	public void setPageInfo(PageInfo pageinfo) {
		this.pageSize = pageinfo.getPageSize();
		this.currentPage = pageinfo.getPageNum();
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public Integer getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(Integer totalPages) {
		this.totalPages = totalPages;
	}

	public Integer getTotalNum() {
		return totalNum;
	}

	public void setTotalNum(Integer totalNum) {
		this.totalNum = totalNum;
	}

	public List<T> getRecords() {
		return records;
	}

	public void setRecords(List<T> records) {
		this.records = records;
	}
	
	public boolean getIsFirstPage() {
		return this.currentPage == 1;
	}
	
	public boolean getIsLastPage() {
		return this.currentPage == this.totalPages;
	}
	
	public boolean getIsHastNext() {
		return this.currentPage < this.totalPages;
	}
}