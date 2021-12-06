package mc.sn.test.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import mc.sn.test.vo.LonginVO;

@Repository
public class LonginDaoimpl implements LonginDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public LonginVO selectTest(LonginVO longinvo) {
		LonginVO vo = sqlSession.selectOne("mapper.test2.loginById", longinvo);
		return vo;
	}

}
