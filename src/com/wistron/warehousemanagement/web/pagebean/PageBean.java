package com.wistron.warehousemanagement.web.pagebean;

public class PageBean {
	
	private int currentPage;
	
	private int totalnumber;
	
	private int totalpage;
	
	private int numberperpage=5;

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getTotalnumber() {
		return totalnumber;
	}

	public void setTotalnumber(int totalnumber) {
		this.totalnumber = totalnumber;
	}

	public int getTotalpage() {
		
		if(totalnumber%numberperpage==0)
		  {
			totalpage=totalnumber/numberperpage;
		  }
		  else
		  {
			  totalpage=totalnumber/numberperpage+1;
		  }
		
		return totalpage;
	}

	public void setTotalpage(int totalpage) {
		this.totalpage = totalpage;
	}

	public int getNumberperpage() {
		return numberperpage;
	}

	public void setNumberperpage(int numberperpage) {
		this.numberperpage = numberperpage;
	}
	
	

}
