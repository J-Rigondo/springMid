package kr.ac.inhatc.mvc.dao;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.ac.inhatc.mvc.dto.BoardDto;
import kr.ac.inhatc.mvc.dto.SearchDto;

@Repository
public class BoardDaoImpl implements BoardDao{
	@Autowired
	protected SqlSessionTemplate sqlSession;

	@Override
	public List<BoardDto> selectSubjectList(SearchDto searchDto) throws Exception {		
		return sqlSession.selectList("selectSubjectList",searchDto);
	}
	
	@Override
	public int getSubjectListCnt(SearchDto searchDto) {		
		return sqlSession.selectOne("getSubjectListCnt",searchDto);
	}
	
	@Override
	public HashMap selectSubjectOne(String no) throws Exception {		
		return sqlSession.selectOne("selectSubjectOne", no);
	}

	@Override
	public int regSubject(BoardDto boardDto) throws Exception {		
		return sqlSession.insert("regSubject", boardDto);
	}

	@Override
	public int modifyBoardDetail(BoardDto boardDto) throws Exception {		
		return sqlSession.update("modifyBoardDetail", boardDto);
	}

	@Override
	public int deleteBoardDetail(String no) throws Exception {		
		return sqlSession.delete("deleteBoardDetail", no);
	}
	

	
}


