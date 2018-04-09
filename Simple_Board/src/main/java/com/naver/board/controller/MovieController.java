package com.naver.board.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.naver.board.domain.ActorVO;
import com.naver.board.domain.BoardVO;
import com.naver.board.domain.MovieVO;
import com.naver.board.service.BoardService;
import com.naver.board.service.MovieService;

@Controller
public class MovieController {

	@Inject
	private MovieService movieService;
	
	@RequestMapping(value="/movie", method=RequestMethod.GET)
	public String selectAll(Model model, HttpServletRequest req) throws Exception{
		String mid = req.getParameter("mid");
		System.out.println(mid);
		
		MovieVO movieOne = movieService.selectOne(mid);
		model.addAttribute("movie", movieOne);
		
		List<ActorVO> actors = movieService.selectActor(mid);
		model.addAttribute("actors", actors);
	
		List<ActorVO> directors = movieService.selectDirector(mid);
		model.addAttribute("directors", directors);
		
		return "movie";
	}
	
}
