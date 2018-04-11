package com.naver.board.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.xml.bind.ParseConversionEvent;

import org.apache.ibatis.type.IntegerTypeHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.naver.board.domain.BoardVO;
import com.naver.board.service.BoardService;

@Controller
public class BoardController {

	@Inject
	private BoardService boardService;
	static String pastyear;
	@RequestMapping(value="/board", method=RequestMethod.GET)
	public String selectAll(Model model, HttpServletRequest req) throws Exception{
		
		int page ;
		try {
			page = Integer.parseInt(req.getParameter("page"));
		
		} catch(Exception e) {
			page = 1;
		}
		page = (page-1) * 20;
		
		// boardAll
		
		List<BoardVO> boardAll = boardService.selectAll(page);
		model.addAttribute("boardAll", boardAll);
		
		// boardYear
		
		String year = req.getParameter("year"); 
		System.out.println("맨 처음 "+year);
		System.out.println(year instanceof String);
		String name = req.getParameter("name");
		
		if(year == null) {
			
		}else if(year.equals("")){
			year = pastyear;
			System.out.println("없을 때 "+year);
		}else {
			System.out.println("있을 때 "+year);
			pastyear = year;
		}
		
		List<BoardVO> boardYear = boardService.selectYear(year, name, page);
		model.addAttribute("boardYear", boardYear);
		model.addAttribute("year", year);
		
		//boardCount
		
		int boardCnt = boardService.selectCnt(year, name);
		boardCnt = (boardCnt/20) + 1;
		model.addAttribute("year",year);
		model.addAttribute("boardCnt",boardCnt);
		
		return "home";
	}

	
	
}
