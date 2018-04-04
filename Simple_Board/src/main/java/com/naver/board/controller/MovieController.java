package com.naver.board.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.naver.board.domain.BoardVO;
import com.naver.board.domain.MovieVO;
import com.naver.board.service.BoardService;

@Controller
public class MovieController {

	//@Inject
	//private BoardService boardService;
	
	@RequestMapping(value="/movie", method=RequestMethod.GET)
	public String selectAll(Model model, HttpServletRequest req) throws Exception{
		
		//String val = req.getParameter("table");
		MovieVO movie = new MovieVO("영화이름1","개봉일1","장르1","관람등급1","감독이름1","배우이름1");
		model.addAttribute("movie", movie);
		
		return "movie";
	}
	
	
}
