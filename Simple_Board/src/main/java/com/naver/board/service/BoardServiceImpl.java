package com.naver.board.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.naver.board.dao.BoardDao;
import com.naver.board.domain.BoardVO;

// 서비스단에는 Service로 어노테이션한다
// root-context.xml에 bean이 추가된다
@Service
public class BoardServiceImpl implements BoardService{

	@Inject
	private BoardDao boardDao;

	@Override
	public List<BoardVO> selectAll(int page) throws Exception {
		
		return boardDao.selectAll(page);
	}

	@Override
	public BoardVO selectOne(String val) throws Exception {

		return boardDao.selectOne(val);
	}

	@Override
	public List<BoardVO> selectYear(String year, String name, int page) throws Exception {

		return boardDao.selectYear(year, name, page);
	}
	
	@Override
	public int selectCnt(String year, String name) throws Exception {
		
		return boardDao.selectCnt(year, name);
	}
	
	
}
