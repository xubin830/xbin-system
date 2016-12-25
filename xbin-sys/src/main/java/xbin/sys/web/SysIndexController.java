package xbin.sys.web;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import xbin.sys.facade.SysUserFacade;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class SysIndexController {

    @Resource
    private SysUserFacade sysUserFacade;


    @RequestMapping("/sysindex.html")
    public ModelAndView index(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView ret = new ModelAndView();
        List<JSONObject> list = this.sysUserFacade.getList();
        for (JSONObject jsonObject : list) {
            System.out.println(jsonObject);
        }
        System.out.println(this.sysUserFacade.getById("admin"));
        System.out.println(this.sysUserFacade.generateKey());
        return ret;
    }
    

    
    

}
