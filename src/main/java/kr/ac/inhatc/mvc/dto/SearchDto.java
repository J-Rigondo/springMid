package kr.ac.inhatc.mvc.dto;

public class SearchDto extends PaginationDto {
	private int searchType;
	private String searchKeyword;
	
	public int getSearchType() {
		return searchType;
	}
	public void setSearchType(int searchType) {
		this.searchType = searchType;
	}
	public String getSearchKeyword() {
		return searchKeyword;
	}
	public void setSearchKeyword(String searchKeyword) {
		this.searchKeyword = searchKeyword;
	}
	
}
