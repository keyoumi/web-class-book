package com.classbook.controller;

import com.classbook.utils.VerCodeUtils;
import com.google.code.kaptcha.impl.DefaultKaptcha;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;

@Controller
public class VerCodeController {
    /**
     * 登录验证码SessionKey
     */
    public static final String LOGIN_VALIDATE_CODE = "login_validate_code";
    @Resource
    private DefaultKaptcha captchaProducer;

    /**
     * 登录验证码图片
     * http://localhost:8080/loginValidateCode
     */
    @RequestMapping(value = {"/loginValidateCode"})
    public void loginValidateCode(HttpServletRequest request, HttpServletResponse response) throws Exception {
        VerCodeUtils.validateCode(request, response, captchaProducer, LOGIN_VALIDATE_CODE);
    }

    /**
     * 检查验证码是否正确
     */
    @RequestMapping("/checkLoginValidateCode")
    @ResponseBody
    public HashMap checkLoginValidateCode(HttpServletRequest request, @RequestParam("validateCode") String validateCode) {
        String loginValidateCode = request.getSession().getAttribute(LOGIN_VALIDATE_CODE).toString();
        HashMap<String, Object> map = new HashMap<String, Object>();
        if (loginValidateCode == null) {
            map.put("status", null);//验证码过期
        } else if (loginValidateCode.equals(validateCode)) {
            map.put("status", true);//验证码正确
        } else if (!loginValidateCode.equals(validateCode)) {
            map.put("status", false);//验证码不正确
        }
        map.put("code", 200);
        return map;
    }
}