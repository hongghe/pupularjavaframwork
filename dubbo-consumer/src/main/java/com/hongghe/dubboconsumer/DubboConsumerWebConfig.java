package com.hongghe.dubboconsumer;

import com.hongghe.dubboconsumer.interceptor.LoginInterceptor;
import com.hongghe.dubboconsumer.interceptor.UserInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.PathMatcher;
import org.springframework.web.accept.ContentNegotiationManager;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;
import org.springframework.web.util.UrlPathHelper;

/**
 * @author: hongghe @date: 2019-01-05 12:25
 */
@Configuration
public class DubboConsumerWebConfig extends WebMvcConfigurationSupport {

    /**
     * Return a {@link RequestMappingHandlerMapping} ordered at 0 for mapping
     * requests to annotated controllers.
     */
    @Override
    public RequestMappingHandlerMapping requestMappingHandlerMapping() {
        return super.requestMappingHandlerMapping();
    }

    /**
     * Protected method for plugging in a custom subclass of
     * {@link RequestMappingHandlerMapping}.
     *
     * @since 4.0
     */
    @Override
    protected RequestMappingHandlerMapping createRequestMappingHandlerMapping() {
        return super.createRequestMappingHandlerMapping();
    }

    /**
     * Override this method to add Spring MVC interceptors for
     * pre- and post-processing of controller invocation.
     *
     * @param registry
     * @see InterceptorRegistry
     */
    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new UserInterceptor());
        registry.addInterceptor(new LoginInterceptor());
        super.addInterceptors(registry);
    }

    /**
     * Callback for building the {@link PathMatchConfigurer}.
     * Delegates to {@link #configurePathMatch}.
     *
     * @since 4.1
     */
    @Override
    protected PathMatchConfigurer getPathMatchConfigurer() {
        return super.getPathMatchConfigurer();
    }

    /**
     * Override this method to configure path matching options.
     *
     * @param configurer
     * @see PathMatchConfigurer
     * @since 4.0.3
     */
    @Override
    protected void configurePathMatch(PathMatchConfigurer configurer) {
        super.configurePathMatch(configurer);
    }

    /**
     * Return a global {@link PathMatcher} instance for path matching
     * patterns in {@link HandlerMapping HandlerMappings}.
     * This instance can be configured using the {@link PathMatchConfigurer}
     * in {@link #configurePathMatch(PathMatchConfigurer)}.
     *
     * @since 4.1
     */
    @Override
    public PathMatcher mvcPathMatcher() {
        return super.mvcPathMatcher();
    }

    /**
     * Return a global {@link UrlPathHelper} instance for path matching
     * patterns in {@link HandlerMapping HandlerMappings}.
     * This instance can be configured using the {@link PathMatchConfigurer}
     * in {@link #configurePathMatch(PathMatchConfigurer)}.
     *
     * @since 4.1
     */
    @Override
    public UrlPathHelper mvcUrlPathHelper() {
        return super.mvcUrlPathHelper();
    }

    /**
     * Return a {@link ContentNegotiationManager} instance to use to determine
     * requested {@linkplain MediaType media types} in a given request.
     */
    @Override
    public ContentNegotiationManager mvcContentNegotiationManager() {
        return super.mvcContentNegotiationManager();
    }
}
