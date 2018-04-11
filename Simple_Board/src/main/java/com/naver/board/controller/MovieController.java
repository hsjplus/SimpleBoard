package com.naver.board.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.naver.board.domain.ActorVO;
import com.naver.board.domain.BoardVO;
import com.naver.board.domain.CommentVO;
import com.naver.board.domain.MovieVO;
import com.naver.board.service.BoardService;
import com.naver.board.service.MovieService;

@Controller
public class MovieController {
	
	public static List<CommentVO> pcomments;
	public static List<CommentVO> ncomments;
	public static List<CommentVO> scomments;
	public static List<CommentVO> acomments;
	public static List<CommentVO> vcomments;
	
	public static int pcnt = 0;
	public static int ncnt = 0;
	public static int scnt = 0;
	public static int acnt = 0;
	public static int vcnt = 0;
	
	@Inject
	private MovieService movieService;
		
	@RequestMapping(value="/ajax/resBody", method=RequestMethod.GET)
	@ResponseBody
	public String resStringBody(HttpServletRequest req) throws Exception{
		
		ObjectMapper mapper = new ObjectMapper(); 
		
/*		HashMap<String,String> map = new HashMap<>();
		map.put("aaa", "value of aaa");
		
		List<HashMap<String,String>> lists = new ArrayList<>();
		lists.add(map);
		lists.add(map);*/
		
/*		List<CommentVO> lists = new ArrayList<>();
		CommentVO vo = new CommentVO();
		vo.setComments("contents1");
		vo.setRegdate("data1");
		lists.add(vo);
		lists.add(vo);*/
		
		int num = Integer.parseInt(String.valueOf(req.getParameter("num")));
		int type = Integer.parseInt(String.valueOf(req.getParameter("type")));
		
		List<CommentVO> showComments = null;
		int showCnt = 0;
		
		if(type==0) {pcnt = pcnt + num; showComments = pcomments; showCnt = pcnt;} 
		else if(type ==1) {ncnt = ncnt + num; showComments = ncomments; showCnt = ncnt;}  
		else if(type ==2) {scnt = scnt + num; showComments = scomments; showCnt = scnt;}
		else if(type ==3) {acnt = acnt + num; showComments = acomments; showCnt = acnt;}
		else if(type ==4) {vcnt = vcnt + num; showComments = vcomments; showCnt = vcnt;}
		
		String str = mapper.writeValueAsString(showComments.subList(5*showCnt, 5*(showCnt+1)));
		
		return str;
	}
	
	
	@RequestMapping(value="/ajax_test", method=RequestMethod.GET)
	public String ajaxPractice(Model model) throws Exception{
		
		return "ajax_test";
	}
	
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
		
		List<CommentVO> comments = movieService.selectComment(mid);
		pcomments = new ArrayList<>();
		ncomments = new ArrayList<>();
		scomments = new ArrayList<>();
		acomments = new ArrayList<>();
		vcomments = new ArrayList<>();
		
		System.out.println("후기 전체 개수:"+comments.size());
		
		for (int i = 0; i < comments.size(); i++) {
			if (comments.get(i).getPn().equals("0")) {
				//if(ncomments.size() < 50) {
					ncomments.add(comments.get(i));
				//}
			}
			
			if (comments.get(i).getPn().equals("1")) {
				//if(pcomments.size() < 50) { 
					pcomments.add(comments.get(i));
				//}
			}		
			
			if (comments.get(i).getTopic().equals("0")) {
				//if(stories.size() < 50) 
					scomments.add(comments.get(i));
			}
			
			if (comments.get(i).getTopic().equals("1")) {
				//if(actings.size() < 50) 
					acomments.add(comments.get(i));
			}
			
			if (comments.get(i).getTopic().equals("2")) {
				//if(videos.size() < 50) 
					vcomments.add(comments.get(i));
			}
			
			/*if(pcomments.size() == 50 && ncomments.size() ==50 && stories.size() ==50 
					&& actings.size() ==50 && videos.size() == 50) {
					System.out.println("50개씩 모두 입력됨 ");
					break;
				} */
			
		}
		
		model.addAttribute("pcomments", pcomments.subList(0, 5));	
		model.addAttribute("ncomments", ncomments.subList(0, 5));			
		model.addAttribute("stories", scomments.subList(0, 5));
		model.addAttribute("actings", acomments.subList(0, 5));
		model.addAttribute("videos", vcomments.subList(0, 5));
		
		// count 관련 값 초기화 
		pcnt = 0;
		ncnt = 0;
		scnt = 0;
		acnt = 0;
		vcnt = 0;
		
		return "movie";
	}
	
}
