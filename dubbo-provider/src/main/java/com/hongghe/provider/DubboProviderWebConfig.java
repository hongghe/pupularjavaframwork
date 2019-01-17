package com.hongghe.provider;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.format.FormatterRegistry;
import org.springframework.format.support.FormattingConversionService;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.util.PathMatcher;
import org.springframework.validation.MessageCodesResolver;
import org.springframework.validation.Validator;
import org.springframework.web.accept.ContentNegotiationManager;
import org.springframework.web.bind.support.ConfigurableWebBindingInitializer;
import org.springframework.web.method.support.CompositeUriComponentsContributor;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.handler.BeanNameUrlHandlerMapping;
import org.springframework.web.servlet.handler.HandlerMappingIntrospector;
import org.springframework.web.servlet.mvc.HttpRequestHandlerAdapter;
import org.springframework.web.servlet.mvc.SimpleControllerHandlerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.ExceptionHandlerExceptionResolver;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;
import org.springframework.web.servlet.resource.ResourceUrlProvider;
import org.springframework.web.util.UrlPathHelper;

import javax.servlet.ServletContext;
import java.util.List;
import java.util.Map;

/**
 * @author: hongghe @date: 2019-01-05 15:42
 */
@Configuration
public class DubboProviderWebConfig extends WebMvcConfigurationSupport {

    public DubboProviderWebConfig() {
        super();
    }

    /**
     * Set the Spring {@link ApplicationContext}, e.g. for resource loading.
     *
     * @param applicationContext
     */
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) {
        super.setApplicationContext(applicationContext);
    }

    /**
     * Set the {@link ServletContext}, e.g. for resource handling,
     * looking up file extensions, etc.
     *
     * @param servletContext
     */
    @Override
    public void setServletContext(ServletContext servletContext) {
        super.setServletContext(servletContext);
    }

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

    @Override
    protected Map<String, MediaType> getDefaultMediaTypes() {
        return super.getDefaultMediaTypes();
    }

    /**
     * Override this method to configure content negotiation.
     *
     * @param configurer
     * @see DefaultServletHandlerConfigurer
     */
    @Override
    protected void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
        super.configureContentNegotiation(configurer);
    }

    /**
     * Return a handler mapping ordered at 1 to map URL paths directly to
     * view names. To configure view controllers, override
     * {@link #addViewControllers}.
     */
    @Override
    public HandlerMapping viewControllerHandlerMapping() {
        return super.viewControllerHandlerMapping();
    }

    /**
     * Override this method to add view controllers.
     *
     * @param registry
     * @see ViewControllerRegistry
     */
    @Override
    protected void addViewControllers(ViewControllerRegistry registry) {
        super.addViewControllers(registry);
    }

    /**
     * Return a {@link BeanNameUrlHandlerMapping} ordered at 2 to map URL
     * paths to controller bean names.
     */
    @Override
    public BeanNameUrlHandlerMapping beanNameHandlerMapping() {
        return super.beanNameHandlerMapping();
    }

    /**
     * Return a handler mapping ordered at Integer.MAX_VALUE-1 with mapped
     * resource handlers. To configure resource handling, override
     * {@link #addResourceHandlers}.
     */
    @Override
    public HandlerMapping resourceHandlerMapping() {
        return super.resourceHandlerMapping();
    }

    /**
     * Override this method to add resource handlers for serving static resources.
     *
     * @param registry
     * @see ResourceHandlerRegistry
     */
    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        super.addResourceHandlers(registry);
    }

    /**
     * A {@link ResourceUrlProvider} bean for use with the MVC dispatcher.
     *
     * @since 4.1
     */
    @Override
    public ResourceUrlProvider mvcResourceUrlProvider() {
        return super.mvcResourceUrlProvider();
    }

    /**
     * Return a handler mapping ordered at Integer.MAX_VALUE with a mapped
     * default servlet handler. To configure "default" Servlet handling,
     * override {@link #configureDefaultServletHandling}.
     */
    @Override
    public HandlerMapping defaultServletHandlerMapping() {
        return super.defaultServletHandlerMapping();
    }

    /**
     * Override this method to configure "default" Servlet handling.
     *
     * @param configurer
     * @see DefaultServletHandlerConfigurer
     */
    @Override
    protected void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        super.configureDefaultServletHandling(configurer);
    }

    /**
     * Returns a {@link RequestMappingHandlerAdapter} for processing requests
     * through annotated controller methods. Consider overriding one of these
     * other more fine-grained methods:
     * <ul>
     * <li>{@link #addArgumentResolvers} for adding custom argument resolvers.
     * <li>{@link #addReturnValueHandlers} for adding custom return value handlers.
     * <li>{@link #configureMessageConverters} for adding custom message converters.
     * </ul>
     */
    @Override
    public RequestMappingHandlerAdapter requestMappingHandlerAdapter() {
        return super.requestMappingHandlerAdapter();
    }

    /**
     * Protected method for plugging in a custom subclass of
     * {@link RequestMappingHandlerAdapter}.
     *
     * @since 4.3
     */
    @Override
    protected RequestMappingHandlerAdapter createRequestMappingHandlerAdapter() {
        return super.createRequestMappingHandlerAdapter();
    }

    /**
     * Return the {@link ConfigurableWebBindingInitializer} to use for
     * initializing all {@link WebDataBinder} instances.
     */
    @Override
    protected ConfigurableWebBindingInitializer getConfigurableWebBindingInitializer() {
        return super.getConfigurableWebBindingInitializer();
    }

    /**
     * Override this method to provide a custom {@link MessageCodesResolver}.
     */
    @Override
    protected MessageCodesResolver getMessageCodesResolver() {
        return super.getMessageCodesResolver();
    }

    /**
     * Override this method to configure asynchronous request processing options.
     *
     * @param configurer
     * @see AsyncSupportConfigurer
     */
    @Override
    protected void configureAsyncSupport(AsyncSupportConfigurer configurer) {
        super.configureAsyncSupport(configurer);
    }

    /**
     * Return a {@link FormattingConversionService} for use with annotated controllers.
     * <p>See {@link #addFormatters} as an alternative to overriding this method.
     */
    @Override
    public FormattingConversionService mvcConversionService() {
        return super.mvcConversionService();
    }

    /**
     * Override this method to add custom {@link Converter} and/or {@link Formatter}
     * delegates to the common {@link FormattingConversionService}.
     *
     * @param registry
     * @see #mvcConversionService()
     */
    @Override
    protected void addFormatters(FormatterRegistry registry) {
        super.addFormatters(registry);
    }

    /**
     * Return a global {@link Validator} instance for example for validating
     * {@code @ModelAttribute} and {@code @RequestBody} method arguments.
     * Delegates to {@link #getValidator()} first and if that returns {@code null}
     * checks the classpath for the presence of a JSR-303 implementations
     * before creating a {@code OptionalValidatorFactoryBean}.If a JSR-303
     * implementation is not available, a no-op {@link Validator} is returned.
     */
    @Override
    public Validator mvcValidator() {
        return super.mvcValidator();
    }

    /**
     * Override this method to provide a custom {@link Validator}.
     */
    @Override
    protected Validator getValidator() {
        return super.getValidator();
    }

    /**
     * Add custom {@link HandlerMethodArgumentResolver HandlerMethodArgumentResolvers}
     * to use in addition to the ones registered by default.
     * <p>Custom argument resolvers are invoked before built-in resolvers except for
     * those that rely on the presence of annotations (e.g. {@code @RequestParameter},
     * {@code @PathVariable}, etc). The latter can be customized by configuring the
     * {@link RequestMappingHandlerAdapter} directly.
     *
     * @param argumentResolvers the list of custom converters (initially an empty list)
     */
    @Override
    protected void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        super.addArgumentResolvers(argumentResolvers);
    }

    /**
     * Add custom {@link HandlerMethodReturnValueHandler HandlerMethodReturnValueHandlers}
     * in addition to the ones registered by default.
     * <p>Custom return value handlers are invoked before built-in ones except for
     * those that rely on the presence of annotations (e.g. {@code @ResponseBody},
     * {@code @ModelAttribute}, etc). The latter can be customized by configuring the
     * {@link RequestMappingHandlerAdapter} directly.
     *
     * @param returnValueHandlers the list of custom handlers (initially an empty list)
     */
    @Override
    protected void addReturnValueHandlers(List<HandlerMethodReturnValueHandler> returnValueHandlers) {
        super.addReturnValueHandlers(returnValueHandlers);
    }

    /**
     * Override this method to add custom {@link HttpMessageConverter HttpMessageConverters}
     * to use with the {@link RequestMappingHandlerAdapter} and the
     * {@link ExceptionHandlerExceptionResolver}.
     * <p>Adding converters to the list turns off the default converters that would
     * otherwise be registered by default. Also see {@link #addDefaultHttpMessageConverters}
     * for adding default message converters.
     *
     * @param converters a list to add message converters to (initially an empty list)
     */
    @Override
    protected void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        super.configureMessageConverters(converters);
    }

    /**
     * Override this method to extend or modify the list of converters after it has
     * been configured. This may be useful for example to allow default converters
     * to be registered and then insert a custom converter through this method.
     *
     * @param converters the list of configured converters to extend
     * @since 4.1.3
     */
    @Override
    protected void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        super.extendMessageConverters(converters);
    }

    /**
     * Return an instance of {@link CompositeUriComponentsContributor} for use with
     * {@link MvcUriComponentsBuilder}.
     *
     * @since 4.0
     */
    @Override
    public CompositeUriComponentsContributor mvcUriComponentsContributor() {
        return super.mvcUriComponentsContributor();
    }

    /**
     * Returns a {@link HttpRequestHandlerAdapter} for processing requests
     * with {@link HttpRequestHandler HttpRequestHandlers}.
     */
    @Override
    public HttpRequestHandlerAdapter httpRequestHandlerAdapter() {
        return super.httpRequestHandlerAdapter();
    }

    /**
     * Returns a {@link SimpleControllerHandlerAdapter} for processing requests
     * with interface-based controllers.
     */
    @Override
    public SimpleControllerHandlerAdapter simpleControllerHandlerAdapter() {
        return super.simpleControllerHandlerAdapter();
    }

    /**
     * Returns a {@link HandlerExceptionResolverComposite} containing a list of exception
     * resolvers obtained either through {@link #configureHandlerExceptionResolvers} or
     * through {@link #addDefaultHandlerExceptionResolvers}.
     * <p><strong>Note:</strong> This method cannot be made final due to CGLIB constraints.
     * Rather than overriding it, consider overriding {@link #configureHandlerExceptionResolvers}
     * which allows for providing a list of resolvers.
     */
    @Override
    public HandlerExceptionResolver handlerExceptionResolver() {
        return super.handlerExceptionResolver();
    }

    /**
     * Override this method to configure the list of
     * {@link HandlerExceptionResolver HandlerExceptionResolvers} to use.
     * <p>Adding resolvers to the list turns off the default resolvers that would otherwise
     * be registered by default. Also see {@link #addDefaultHandlerExceptionResolvers}
     * that can be used to add the default exception resolvers.
     *
     * @param exceptionResolvers a list to add exception resolvers to (initially an empty list)
     */
    @Override
    protected void configureHandlerExceptionResolvers(List<HandlerExceptionResolver> exceptionResolvers) {
        super.configureHandlerExceptionResolvers(exceptionResolvers);
    }

    /**
     * Override this method to extend or modify the list of
     * {@link HandlerExceptionResolver HandlerExceptionResolvers} after it has been configured.
     * <p>This may be useful for example to allow default resolvers to be registered
     * and then insert a custom one through this method.
     *
     * @param exceptionResolvers the list of configured resolvers to extend.
     * @since 4.3
     */
    @Override
    protected void extendHandlerExceptionResolvers(List<HandlerExceptionResolver> exceptionResolvers) {
        super.extendHandlerExceptionResolvers(exceptionResolvers);
    }

    /**
     * Protected method for plugging in a custom subclass of
     * {@link ExceptionHandlerExceptionResolver}.
     *
     * @since 4.3
     */
    @Override
    protected ExceptionHandlerExceptionResolver createExceptionHandlerExceptionResolver() {
        return super.createExceptionHandlerExceptionResolver();
    }

    /**
     * Register a {@link ViewResolverComposite} that contains a chain of view resolvers
     * to use for view resolution.
     * By default this resolver is ordered at 0 unless content negotiation view
     * resolution is used in which case the order is raised to
     * {@link Ordered#HIGHEST_PRECEDENCE
     * Ordered.HIGHEST_PRECEDENCE}.
     * <p>If no other resolvers are configured,
     * {@link ViewResolverComposite#resolveViewName(String, Locale)} returns null in order
     * to allow other potential {@link ViewResolver} beans to resolve views.
     *
     * @since 4.1
     */
    @Override
    public ViewResolver mvcViewResolver() {
        return super.mvcViewResolver();
    }

    /**
     * Override this method to configure view resolution.
     *
     * @param registry
     * @see ViewResolverRegistry
     */
    @Override
    protected void configureViewResolvers(ViewResolverRegistry registry) {
        super.configureViewResolvers(registry);
    }

    /**
     * Override this method to configure cross origin requests processing.
     *
     * @param registry
     * @see CorsRegistry
     * @since 4.2
     */
    @Override
    protected void addCorsMappings(CorsRegistry registry) {
        super.addCorsMappings(registry);
    }

    @Override
    public HandlerMappingIntrospector mvcHandlerMappingIntrospector() {
        return super.mvcHandlerMappingIntrospector();
    }
}
