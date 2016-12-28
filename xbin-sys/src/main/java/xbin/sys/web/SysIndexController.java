package xbin.sys.web;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import xbin.com.dao.RoleFuncComDao;
import xbin.com.util.RequestUtils;
import xbin.com.util.ResponseUtils;
import xbin.sys.facade.SysUserFacade;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@Controller
public class SysIndexController {

    @Resource
    private SysUserFacade sysUserFacade;

    private RoleFuncComDao roleFuncComDao;

    public RoleFuncComDao getRoleFuncComDao() {
        return roleFuncComDao;
    }
    @Autowired
    public void setRoleFuncComDao(RoleFuncComDao roleFuncComDao) {
        this.roleFuncComDao = roleFuncComDao;
    }

    /**
     * <B>方法名称：</B>系统首页<BR>
     * <B>概要说明：</B><BR>
     *
     * @param request 页面请求
     * @param response 页面响应
     * @return ModelAndView 模型视图
     */
    @RequestMapping("/sysindex.html")
    public ModelAndView index(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView ret = new ModelAndView();
        String userId = RequestUtils.getCurrentUserId(request);
        String userName = RequestUtils.getCurrentUserName(request);
        String roleCode = RequestUtils.getCurrentRoleCode(request);
        String orgId = RequestUtils.getCurrentOrgId(request);
        List<JSONObject> funcList = this.roleFuncComDao.getFuncList(roleCode, "01");
        ret.addObject("funcList", funcList.toString());
        return ret;
    }

    @RequestMapping("/sysFuncList.json")
    public void sysFuncList(HttpServletRequest request, HttpServletResponse response, String id){
        String roleCode = RequestUtils.getCurrentRoleCode(request);
        List<JSONObject> records = new ArrayList<JSONObject>();
        List<JSONObject> funcList = this.roleFuncComDao.getFuncList(roleCode, id);
        for (JSONObject jsonObject : funcList) {
            JSONObject record = new JSONObject();
            //'id' ,'text' , 'type' , 'leaf', 'url'
            record.put("id", jsonObject.getString("FUNC_CODE"));
            record.put("text", jsonObject.getString("FUNC_NAME"));
            record.put("type", jsonObject.getString("FUNC_TYPE"));
            record.put("leaf", true);
            record.put("url", jsonObject.getString("FUNC_PATH"));
            records.add(record);
        }
        ResponseUtils.putJsonResponse(response, records);

    }
    
    

}
