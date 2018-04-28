package com.pms.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.pms.dao.SuggestMapper;
import com.pms.pojo.Suggest;
import com.pms.service.SuggestService;

@Service("suggestService")
public class SuggestServiceImpl implements SuggestService {
	@Resource(name = "suggestMapper")
	private SuggestMapper suggestMapper;
	
	public int insertByOwner(Suggest record){
		return suggestMapper.insertByOwner(record);
	}
	
	public List<Suggest> getAllSuggest(){
		return suggestMapper.selectAllSuggest();
	}
	
	public Suggest getBySuggestId(Integer id){
		return suggestMapper.selectByPrimaryKey(id);
	}
	
	public int deleteBySuggestId(Integer id){
		return suggestMapper.deleteByPrimaryKey(id);
	}
	
	public List<Suggest> getAllSuggestByOwner(Integer ownerId){
		return suggestMapper.selectAllSuggestByOwner(ownerId);
	}
	
	public int updateByAdmin(Suggest record){
		return suggestMapper.updateByAdmin(record);
	}
}
