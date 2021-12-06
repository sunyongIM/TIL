package mc.sn.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mc.sn.test.dao.LonginDao;
import mc.sn.test.vo.LonginVO;

@Service
public class LonginServiceimpl implements LonginService {

	@Autowired
	private LonginDao dao;
	
	@Override
	public LonginVO loginTest(String id, String password) {
		// TODO Auto-generated method stub
		LonginVO vo = new LonginVO(id, password, "temp");
		
		return dao.selectTest(vo);
	}

}
