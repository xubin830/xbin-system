package xbin.sys.service;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xbin.sys.dao.SysUserDao;
import xbin.sys.facade.SysUserFacade;

import java.util.Collections;
import java.util.List;


@Service("sysUserService")
@com.alibaba.dubbo.config.annotation.Service(interfaceClass=xbin.sys.facade.SysUserFacade.class, protocol = {"rest", "dubbo"})
public class SysUserService implements SysUserFacade {


	@Autowired
	private SysUserDao sysUserDao;

	@Override
	public String generateKey() throws Exception {
		return this.sysUserDao.generateKey();
	}

	@Override
	public JSONObject getById(String id) {
		//get
		//http://localhost:8888/xbin-sys-service/sysUserService/getById/{id}
		return this.sysUserDao.getById(id);
	}

	@Override
	public List<JSONObject> getList() throws Exception {
		//post
		//http://localhost:8888/xbin-sys-service/sysUserService/getById/getList
		List<JSONObject> list = this.sysUserDao.getList();
		if(!list.isEmpty()){
			return list;
		} else {
			return Collections.emptyList();
		}
	}

	@Override
	public int insert(JSONObject jsonObject) throws Exception {
		return this.sysUserDao.insert(jsonObject);
	}


}
