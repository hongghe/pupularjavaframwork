package com.hongghe.jpa.servlet;

import com.alibaba.druid.support.http.StatViewServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;

/**
 * Druid is setting.
 *
 * @author: hongghe
 * @date: 2019-01-11 21:01
 */
@WebServlet(urlPatterns = "/druid/*", initParams = {
        @WebInitParam(name = "allow", value = "127.0.0.1"), // IP白名单 (没有配置或者为空，则允许所有访问)
        @WebInitParam(name="deny",value="127.0.0.2"), // IP黑名单 (存在共同时，deny优先于allow)
        @WebInitParam(name="loginUsername",value="druid"),// 用户名
        @WebInitParam(name="loginPassword",value="druid"),// 密码
        @WebInitParam(name="resetEnable",value="false")// 禁用HTML页面上的“Reset All”功能
})
public class DruidStatViewServlet extends StatViewServlet {

    private static final long serialVersionUID = 8430819001454966187L;

    public DruidStatViewServlet() {
        super();
    }

    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    protected String process(String url) {
        return super.process(url);
    }
}