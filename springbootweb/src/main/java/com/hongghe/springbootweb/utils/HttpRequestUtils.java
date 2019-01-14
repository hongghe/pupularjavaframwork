package com.hongghe.springbootweb.utils;

import com.hongghe.springbootweb.domain.HttpRequestEntity;
import com.hongghe.springbootweb.domain.HttpResponseEntity;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author: hongghe @date: 2019-01-13 17:18
 */
public class HttpRequestUtils {

    /**
     * 解析请求内容中的属性
     * @param request 请求内容
     * @return 属性
     */
    public HttpRequestEntity toRequestEntity(HttpServletRequest request) {
        HttpRequestEntity entity = new HttpRequestEntity();
        entity.setCookie(request.getCookies());
        entity.setRequestMethod(request.getMethod());
        return entity;
    }

    /**
     * 解析出HTTP请求中的应答的内容信息
     * @param response 应答的信息
     * @return 解析的结果
     */
    public HttpResponseEntity toResponse(HttpServletResponse response) {
        HttpResponseEntity entity = new HttpResponseEntity();
        entity.setCode(response.getStatus());
        return entity;
    }
}
