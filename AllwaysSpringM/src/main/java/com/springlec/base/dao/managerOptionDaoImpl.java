package com.springlec.base.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.springlec.base.model.managerOptionDto;

public class managerOptionDaoImpl implements managerOptionDao {

	SqlSession sqlSession;
	
	public static String nameSpace = "com.springlec.base.dao.managerOptionDao";
	
	@Override
	public List<managerOptionDto> optionlist() throws Exception {
		return sqlSession.selectList(nameSpace + ".optionlist");
	}

	@Override
	public int optioncheck(String optionName, String option) throws Exception {
		return sqlSession.selectOne(nameSpace + ".optioncheck");
	}

	@Override
	public void optionadd(String cakeoptionCategory, String cakeoptionValue, String cakeoptionPrice) throws Exception {
		sqlSession.insert(nameSpace + ".optionadd");
	}

	@Override
	public List<managerOptionDto> optionsearch(String option, String Query) throws Exception {
		return sqlSession.selectList(nameSpace + ".optionsearch");
	}

	@Override
	public managerOptionDto optiondetail1(String cakeoptionId) throws Exception {
		// TODO Auto-generated method stub
		return (managerOptionDto)sqlSession.selectList(nameSpace + ".optiondetail1");
	}
	
	@Override
	public List<managerOptionDto> optiondetail2() throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(nameSpace + ".optiondetail2");
	}

	@Override
	public int optionupdatechk(String optionName, String option) throws Exception {
		return sqlSession.selectOne(nameSpace + ".optionupdatechk");
	}

	@Override
	public void optionupdate(String cakeoptionId, String cakeoptionCategory, String cakeoptionValue,
			String cakeoptionPrice) throws Exception {
		sqlSession.update(nameSpace + ".optionupdate");
	}

	@Override
	public void optiondelete(String cakeoptionId) throws Exception {
		sqlSession.update(nameSpace + ".optiondelete");
	}

}
