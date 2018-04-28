package com.pms.service;

import java.util.List;

import com.pms.pojo.Suggest;

public interface SuggestService {
	public int insertByOwner(Suggest record);
	public List<Suggest> getAllSuggest();
	public Suggest getBySuggestId(Integer id);
	public int deleteBySuggestId(Integer id);
	public List<Suggest> getAllSuggestByOwner(Integer ownerId);
	public int updateByAdmin(Suggest record);
}
