package com.naver.board.dao;

import java.util.List;

import com.naver.board.domain.BoardVO;

public interface BoardDao {

	public List<BoardVO> selectAll(int val) throws Exception;
	
	public BoardVO selectOne(String val) throws Exception;
	
	public List<BoardVO> selectYear(String year, String name, int page) throws Exception;
	
	public int selectCnt(String year, String name) throws Exception;
}
