package com.ResumeParse.DAO;

import java.util.Map;
import java.util.regex.Pattern;

import com.ResumeParse.DTO.UserVO;

public interface ParseDataDAO {

	public String Find(Pattern p,String text);
	public void insert(UserVO user);
	public Map<String,Integer> TotalSkills(UserVO user);
	public Map<String,Integer> GetUsers();
	public void UploadFiles(String[] Filepaths);
	public UserVO GetData(String Filename);
}
