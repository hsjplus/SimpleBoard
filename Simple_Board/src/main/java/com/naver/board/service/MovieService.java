package com.naver.board.service;

import java.util.List;

import com.naver.board.domain.ActorVO;
import com.naver.board.domain.MovieVO;

public interface MovieService {
	
	public MovieVO selectOne(String mid) throws Exception;
	public List<ActorVO> selectActor(String mid) throws Exception;
	public List<ActorVO> selectDirector(String mid) throws Exception;
	
}