package kr.ac.inhatc.mvc.dao;

import java.util.HashMap;
import java.util.List;

import kr.ac.inhatc.mvc.dto.BoardDto;
import kr.ac.inhatc.mvc.dto.SearchDto;

public interface BoardDao {
	public List<BoardDto> selectSubjectList(SearchDto searchDto) throws Exception;
	
	public int getSubjectListCnt(SearchDto searchDto);
	
	public HashMap<?, ?> selectSubjectOne(String no) throws Exception;	
	
	public int regSubject(BoardDto boardDto) throws Exception;	
	
	public int modifyBoardDetail(BoardDto boardDto) throws Exception;
	
	public int deleteBoardDetail(String no) throws Exception;

}
