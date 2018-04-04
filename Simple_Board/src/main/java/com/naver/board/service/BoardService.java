package com.naver.board.service;

import java.util.List;

import com.naver.board.domain.BoardVO;

public interface BoardService {
	
	public List<BoardVO> selectAll(String val) throws Exception;
	
}
