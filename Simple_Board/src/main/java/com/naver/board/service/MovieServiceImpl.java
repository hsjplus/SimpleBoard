package com.naver.board.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.naver.board.dao.BoardDao;
import com.naver.board.dao.MovieDao;
import com.naver.board.domain.ActorVO;
import com.naver.board.domain.BoardVO;
import com.naver.board.domain.MovieVO;

// 서비스단에는 Service로 어노테이션한다
// root-context.xml에 bean이 추가된다
@Service
public class MovieServiceImpl implements MovieService{

	@Inject
	private MovieDao movieDao;

	@Override
	public MovieVO selectOne(String mid) throws Exception {

		return movieDao.selectOne(mid);
	}

	@Override
	public List<ActorVO> selectActor(String mid) throws Exception {
		return movieDao.selectActor(mid);
	}
	
	@Override
	public List<ActorVO> selectDirector(String mid) throws Exception {
		return movieDao.selectDirector(mid);
	}
	
	
	
}
