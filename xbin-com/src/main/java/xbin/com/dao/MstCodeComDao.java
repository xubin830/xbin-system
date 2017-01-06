package xbin.com.dao;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MstCodeComDao extends BaseJdbcDao{

	/** SQL文本：获取业务代码数据 */
	private static final String SQL_SELECT_CODE_LIST = "SELECT CODE, NAME, ATTR01, ATTR02, ATTR03, ATTR04, ATTR05, ATTR06, ATTR07, ATTR08, ATTR09, ATTR10, EXPIRED FROM MST_CODE WHERE TYPE = ?";
	
	public List<JSONObject> getTypeList(String type){
		return this.queryForJsonList(SQL_SELECT_CODE_LIST, type);
	}

}
