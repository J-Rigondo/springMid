package kr.ac.inhatc.mvc.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.ac.inhatc.mvc.dto.BoardDto;
import kr.ac.inhatc.mvc.dto.SearchDto;
import kr.ac.inhatc.mvc.service.BoardService;


@Controller
public class BoardController {	
	@Autowired
	BoardService boardService;
	
	int hit = 0;
	
	//게시글 불러오기
	@RequestMapping(value = "selectSubjectList", method = RequestMethod.GET)
	public String selectSubjectList(Model model, @RequestParam(required=false, defaultValue="1") int page,
			@RequestParam(required=false, defaultValue="1") int range,
			@RequestParam(required=false, defaultValue="2") int searchType,
			@RequestParam(required=false) String searchKeyword
			) throws Exception {
		
		hit++;
		
		SearchDto searchDto = new SearchDto();		
		searchDto.setSearchType(searchType);
		searchDto.setSearchKeyword(searchKeyword);
		
		int listCnt = boardService.getSubjectListCnt(searchDto);
		
		searchDto.pageInfo(page, range, listCnt);
		
		List<BoardDto> subjectList = boardService.selectSubjectList(searchDto);
		System.out.println(subjectList);
		model.addAttribute("subjectList", subjectList);
		model.addAttribute("hit",hit);
		model.addAttribute("pagination", searchDto);
		
		return "board";	
	}
	
	//게시글 읽기
	@RequestMapping(value = "boardDetail.do", method = RequestMethod.GET)
	public String selectSubjectOne(Model model, @RequestParam(required=false) String no) throws Exception {
		HashMap<?, ?> map = boardService.selectSubjectOne(no);
		model.addAttribute("detailBoard", map);
		return "boardDetail";
	}
	
	//게시글 쓰기
	@RequestMapping(value = "regSubject", method = RequestMethod.GET)
	public String regSubjectPage(Model model) {
		return "boardDetail";
	}
	
	@RequestMapping(value = "regSubject.do", method = RequestMethod.POST)
	public String regSubject(Model model, BoardDto boardDto) throws Exception {
		boardService.regSubject(boardDto);
		return "redirect:selectSubjectList";
	}
	
	//게시글 수정
	@RequestMapping(value = "modifyBoardDetail.do", method = RequestMethod.POST)
	public String modifyBoardDetail(Model model, BoardDto boardDto) throws Exception {
		boardService.modifyBoardDetail(boardDto);
		return "redirect:selectSubjectList";
	}
	
	//게시글 삭제
	@RequestMapping(value = "deleteBoardDetail.do", method = RequestMethod.POST)
	public String deleteBoardDetail(Model model, @RequestParam(required=false) String no) throws Exception {
		boardService.deleteBoardDetail(no);
		return "redirect:selectSubjectList";
	}
}
