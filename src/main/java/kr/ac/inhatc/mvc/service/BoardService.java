package kr.ac.inhatc.mvc.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.inhatc.mvc.dao.BoardDao;
import kr.ac.inhatc.mvc.dto.BoardDto;
import kr.ac.inhatc.mvc.dto.SearchDto;

@Service
public class BoardService {
	@Autowired
	BoardDao boardDao;
	public List<BoardDto> selectSubjectList(SearchDto searchDto) throws Exception {		
		return boardDao.selectSubjectList(searchDto);
	}	
	
	public int getSubjectListCnt(SearchDto searchDto) {		
		return boardDao.getSubjectListCnt(searchDto);
	}
	
	public HashMap<?, ?> selectSubjectOne(String no) throws Exception {		
		return boardDao.selectSubjectOne(no);
	}

	public int regSubject(BoardDto boardDto) throws Exception {
		return boardDao.regSubject(boardDto);		
	}

	public int deleteBoardDetail(String no) throws Exception {
		return boardDao.deleteBoardDetail(no);
		
	}

	public int modifyBoardDetail(BoardDto boardDto) throws Exception {
		return boardDao.modifyBoardDetail(boardDto);		
	}

	

	
}
