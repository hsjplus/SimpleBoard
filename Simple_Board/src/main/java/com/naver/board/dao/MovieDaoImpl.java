package com.naver.board.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.naver.board.domain.ActorVO;
import com.naver.board.domain.BoardVO;
import com.naver.board.domain.CommentVO;
import com.naver.board.domain.MovieVO;

//Repository�� �ڵ����� Bean�� ��Ͻ����ش�
@Repository
public class MovieDaoImpl implements MovieDao {
	
	// bean�� �ִ� SqlSession�� �� �� �ְ� ���ش�
	// SqlSession�� mybatis�� ����� �� �ְ� ���ش�
	@Inject
	private SqlSession sqlSession;
	
	private static final String namespace = "com.naver.mapper.movieMapper";

	@Override
	public MovieVO selectOne(String mid) throws Exception {
			
		Map<String, Object> parameter = new HashMap<String, Object>();
		parameter.put("mid", mid);
			
		return sqlSession.selectOne(namespace + ".selectOne", parameter);
	}
	
	@Override
	public List<ActorVO> selectActor(String mid) throws Exception {
			
		Map<String, Object> parameter = new HashMap<String, Object>();
		parameter.put("mid", mid);
			
		return sqlSession.selectList(namespace + ".selectActor", parameter);
	}	

	@Override
	public List<ActorVO> selectDirector(String mid) throws Exception {
			
		Map<String, Object> parameter = new HashMap<String, Object>();
		parameter.put("mid", mid);
			
		return sqlSession.selectList(namespace + ".selectDirector", parameter);
	}

	@Override
	public List<CommentVO> selectComment(String mid) throws Exception {
		
		Map<String, Object> parameter = new HashMap<String, Object>();
		parameter.put("mid", mid);
		String mtable = "m_" + mid.substring(0, 4);
		parameter.put("mtable", mtable);
			
		return sqlSession.selectList(namespace + ".selectComment", parameter);
	}	
	
}

