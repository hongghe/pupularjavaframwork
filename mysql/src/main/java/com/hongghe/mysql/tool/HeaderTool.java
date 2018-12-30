package com.hongghe.mysql.tool;

import com.google.common.base.Strings;
import com.hongghe.mysql.domain.Header;
import org.springframework.lang.Nullable;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.RequestAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author hongghe 2018/12/29
 */
public class HeaderTool {

    private HeaderTool() {}

    public static Header buildFromHttp(HttpServletRequest httpRequest, @Nullable HttpServletResponse httpResponse, String app) {
        Long uuid = 0L;
        String skey = "";
        String ua = "";
        Long uncheckedUid = 0L;
        Long channel = 0L;
        String source = "";
        if (httpRequest.getCookies() != null) {
            for (Cookie cookie : httpRequest.getCookies()) {
                if ("uuid".equals(cookie.getName())) {
                    Long tmp = Long.valueOf(cookie.getValue());
                    if (tmp != null) {
                        uuid = tmp;
                    }
                } else if ("skey".equals(cookie.getName())) {
                    String tmp = String.valueOf(cookie.getValue());
                    if (!Strings.isNullOrEmpty(tmp)) {
                        skey = tmp;
                    }
                } else if ("ua".equals(cookie.getName())) {
                    String tmp =String.valueOf(cookie.getValue());
                    if (!Strings.isNullOrEmpty(tmp)) {
                        ua = tmp;
                    }
                } else if ("uid".equals(cookie.getName())) {
                    Long tmp = Long.valueOf(cookie.getValue());
                    if (tmp != null) {
                        uncheckedUid = tmp;
                    }
                } else if ("channel".equals(cookie.getName())) {
                    String channelStr = cookie.getValue();
                    int idx = channelStr == null ? -1 : channelStr.indexOf('_');
                    if (idx >= 0) {
                        channelStr = channelStr.substring(0, idx);
                    }
                    Long tmp = Long.valueOf(channelStr);
                    if (tmp != null) {
                        channel = tmp;
                    }
                } else if ("source".equals(cookie.getName())) {
                    String tmp = String.valueOf(cookie.getValue());
                    if (!Strings.isNullOrEmpty(tmp)) {
                        source = tmp;
                    }
                }
            }
        }

        String channelParamStr = httpRequest.getParameter("channel");
        int idx = channelParamStr == null ? -1 : channelParamStr.indexOf('_');
        if (idx >= 0) {
            channelParamStr = channelParamStr.substring(0, idx);
        }
        final Long channelParam = Long.valueOf(channelParamStr);
        if (!Strings.isNullOrEmpty(channelParam.toString()) && !channelParam.equals(channel)) {
            channel = channelParam;
            if (httpResponse != null) {
                Cookie cookie = new Cookie("channel", String.valueOf(channel));
                cookie.setMaxAge(-1);
                cookie.setPath("/");
                httpResponse.addCookie(cookie);
            }
        }

        final String sourceParam =httpRequest.getParameter("source");
        if (!Strings.isNullOrEmpty(sourceParam) && !sourceParam.equals(source)) {
            source = sourceParam;
            if (httpResponse != null) {
                Cookie cookie = new Cookie("source", String.valueOf(source));
                cookie.setMaxAge(-1);
                cookie.setPath("/");
                httpResponse.addCookie(cookie);
            }
        }

        return Header.builder()
                .uuid(uuid)
                .skey(skey)
                .ua(ua)
                .uid(uncheckedUid)
                .channelId(channel)
                .source(source)
                .build();
    }


    private static final String HTTP_REQUEST_ATTR_HEADER = HeaderTool.class.getName() + ".HTTP_REQUEST_ATTR_HEADER";

    public static void setHeaderToHttpRequestAttr(HttpServletRequest request, Header header) {
        request.setAttribute(HTTP_REQUEST_ATTR_HEADER, header);
    }

    public static Header getHeaderFromHttpRequestAttr(HttpServletRequest request) {
        return (Header) request.getAttribute(HTTP_REQUEST_ATTR_HEADER);
    }

    public static Header getHeaderFromHttpRequestAttr(NativeWebRequest webRequest) {
        return (Header) webRequest.getAttribute(HTTP_REQUEST_ATTR_HEADER, RequestAttributes.SCOPE_REQUEST);
    }


}
