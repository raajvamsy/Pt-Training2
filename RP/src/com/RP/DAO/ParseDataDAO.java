package com.RP.DAO;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import com.RP.DTO.UserVO;

public interface ParseDataDAO {

	public String Find(Pattern p,String text);
	public void insert(UserVO user);
	public Map<String,Integer> TotalSkills(List<UserVO> lu);
	public Map<String,Integer> GetUsers(List<UserVO> lu);
	public List<UserVO> UploadFiles(String[] Filepaths);
	public UserVO GetData(String Filename);
}
