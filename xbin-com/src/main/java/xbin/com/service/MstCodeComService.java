package xbin.com.service;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xbin.com.dao.MstCodeComDao;

import java.util.List;

@Service
public class MstCodeComService {

	private MstCodeComDao mstCodeComDao;

	public MstCodeComDao getMstCodeComDao() {
		return mstCodeComDao;
	}
	@Autowired
	public void setMstCodeComDao(MstCodeComDao mstCodeComDao) {
		this.mstCodeComDao = mstCodeComDao;
	}
	
	public List<JSONObject> getTypeList(String type){
		return this.mstCodeComDao.getTypeList(type);
	}
	
}
