package com.naver.board.dao;

import java.util.List;

import com.naver.board.domain.ActorVO;
import com.naver.board.domain.CommentVO;
import com.naver.board.domain.MovieVO;

public interface MovieDao {

	public MovieVO selectOne(String mid) throws Exception;
	public List<ActorVO> selectActor(String mid) throws Exception;
	public List<ActorVO> selectDirector(String mid) throws Exception;
	public List<CommentVO> selectComment(String mid) throws Exception;
	
}
