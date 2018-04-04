package com.naver.board.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.naver.board.domain.BoardVO;

//Repository�� �ڵ����� Bean�� ��Ͻ����ش�
@Repository
public class BoardDaoImpl implements BoardDao {
	
	// been�� �ִ� SqlSession�� �� �� �ְ� ���ش�
	// SqlSession�� mybatis�� ����� �� �ְ� ���ش�
	@Inject
	private SqlSession sqlSession;
	
	private static final String namespace = "com.naver.mapper.boardMapper";
	
	@Override
	public List<BoardVO> selectAll(String val) throws Exception {
		
		Map<String, Object> parameter = new HashMap<String, Object>();
		parameter.put("param", val);
		// boardMapper.xml�� �ִ� namespace�� selsectAll�� �����´�
		return sqlSession.selectList(namespace + ".selectAll", parameter);
		
	}

}