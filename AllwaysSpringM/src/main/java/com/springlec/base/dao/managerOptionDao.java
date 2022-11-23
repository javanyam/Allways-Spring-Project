package com.springlec.base.dao;

import java.util.List;

import com.springlec.base.model.managerOptionDto;

public interface managerOptionDao {

	public List<managerOptionDto> optionlist() throws Exception;
	public int optioncheck(String optionName, String option) throws Exception;
	public void optionadd(String cakeoptionCategory, String cakeoptionValue, String cakeoptionPrice) throws Exception;
	public List<managerOptionDto> optionsearch(String option, String Query) throws Exception;
	public managerOptionDto optiondetail1(String cakeoptionId) throws Exception;
	public List<managerOptionDto> optiondetail2() throws Exception;
	public int optionupdatechk(String optionName, String option) throws Exception;
	public void optionupdate(String cakeoptionId, String cakeoptionCategory, String cakeoptionValue, String cakeoptionPrice) throws Exception;
	public void optiondelete(String cakeoptionId) throws Exception;
	
}
