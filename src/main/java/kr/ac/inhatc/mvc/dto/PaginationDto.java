package kr.ac.inhatc.mvc.dto;

public class PaginationDto {
	private int listSize = 10; //불러올 리스트 갯수
	private int rangeSize = 10; // 범위 갯수
	private int page; //현재 페이지
	private int range; // 현재 범위
	private int startList; //limit 시작
	private int listCnt; //전체 리스트 갯수
	private int pageCnt; //전체 페이지 수
	private int startPage;
	private int endPage;
	private int headPage;
	private int tailPage;
	private boolean prev;
	private boolean next;
	
	public int getListSize() {
		return listSize;
	}
	public void setListSize(int listSize) {
		this.listSize = listSize;
	}
	public int getRangeSize() {
		return rangeSize;
	}
	public void setRangeSize(int rangeSize) {
		this.rangeSize = rangeSize;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getRange() {
		return range;
	}
	public void setRange(int range) {
		this.range = range;
	}
	public int getStartList() {
		return startList;
	}
	public void setStartList(int startList) {
		this.startList = startList;
	}
	public int getListCnt() {
		return listCnt;
	}
	public void setListCnt(int listCnt) {
		this.listCnt = listCnt;
	}
	public int getPageCnt() {
		return pageCnt;
	}
	public void setPageCnt(int pageCnt) {
		this.pageCnt = pageCnt;
	}
	public int getStartPage() {
		return startPage;
	}
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	public int getEndPage() {
		return endPage;
	}
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	public boolean isPrev() {
		return prev;
	}
	public void setPrev(boolean prev) {
		this.prev = prev;
	}
	public boolean isNext() {
		return next;
	}
	public void setNext(boolean next) {
		this.next = next;
	}
	
	public void pageInfo(int page, int range, int listCnt) {
		this.page=page;
		this.range=range;
		this.listCnt=listCnt;
		this.startList=(page-1) * listSize;
		
		//전체 페이지 수		
		this.pageCnt=(int) Math.ceil(listCnt/(double)listSize);
		
		//시작 페이지
		this.startPage=(range-1)*rangeSize+1;
		
		//끝 페이지
		this.endPage=range*rangeSize;
		
		//이전 버튼 상태
		this.prev= range == 1 ? false : true;
		
		//다음 버튼 상태
		this.next= endPage>=pageCnt ? false: true;
		
		//마지막 페이지가 전체 페이지를 초과할 경우
		if(this.endPage >= this.pageCnt) {
			this.endPage = this.pageCnt;
			this.next=false;
		}		
	}
}
