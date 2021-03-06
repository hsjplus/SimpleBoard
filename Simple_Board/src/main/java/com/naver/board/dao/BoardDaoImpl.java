package com.naver.board.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.naver.board.domain.BoardVO;

//Repository는 자동으로 Bean에 등록시켜준다
@Repository
public class BoardDaoImpl implements BoardDao {
	
	// been에 있는 SqlSession을 쓸 수 있게 해준다
	// SqlSession은 mybatis를 사용할 수 있게 해준다
	@Inject
	private SqlSession sqlSession;
	
	private static final String namespace = "com.naver.mapper.boardMapper";
	
	@Override
	public List<BoardVO> selectAll(int page) throws Exception {
		
		Map<String, Object> parameter = new HashMap<String, Object>();
		parameter.put("page", page);
		// boardMapper.xml에 있는 namespace와 selsectAll을 가져온다
		return sqlSession.selectList(namespace + ".selectAll", parameter);
		
	}

	@Override
	public BoardVO selectOne(String val) throws Exception {
			
		Map<String, Object> parameter = new HashMap<String, Object>();
		parameter.put("val", val);
			
		return sqlSession.selectOne(namespace + ".selectOne", parameter);
	}

	@Override
	public List<BoardVO> selectYear(String year, String name, int page) throws Exception {
		Map<String, Object> parameter = new HashMap<String, Object>();
		parameter.put("year", year);
		parameter.put("name", name);
		parameter.put("page", page);
		
		
		return sqlSession.selectList(namespace + ".selectYear", parameter);
	}

	@Override 
	public int selectCnt(String year, String name) throws Exception {
		Map<String, Object> parameter = new HashMap<String, Object>();
		parameter.put("year", year);
		parameter.put("name", name);
		
		return sqlSession.selectOne(namespace + ".selectCnt", parameter);
	}
	
}

