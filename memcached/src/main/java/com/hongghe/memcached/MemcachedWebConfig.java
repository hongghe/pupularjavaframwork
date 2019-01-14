package com.hongghe.memcached;

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
import java.lang.ref.PhantomReference;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author hongghe 2018/12/28
 */
@Configuration
public class MemcachedWebConfig extends WebMvcConfigurationSupport {

    public MemcachedWebConfig() {
        super();
    }

    /**
     * Returns a hash code value for the object. This method is
     * supported for the benefit of hash tables such as those provided by
     * {@link HashMap}.
     * <p>
     * The general contract of {@code hashCode} is:
     * <ul>
     * <li>Whenever it is invoked on the same object more than once during
     * an execution of a Java application, the {@code hashCode} method
     * must consistently return the same integer, provided no information
     * used in {@code equals} comparisons on the object is modified.
     * This integer need not remain consistent from one execution of an
     * application to another execution of the same application.
     * <li>If two objects are equal according to the {@code equals(Object)}
     * method, then calling the {@code hashCode} method on each of
     * the two objects must produce the same integer result.
     * <li>It is <em>not</em> required that if two objects are unequal
     * according to the {@link Object#equals(Object)}
     * method, then calling the {@code hashCode} method on each of the
     * two objects must produce distinct integer results.  However, the
     * programmer should be aware that producing distinct integer results
     * for unequal objects may improve the performance of hash tables.
     * </ul>
     * <p>
     * As much as is reasonably practical, the hashCode method defined by
     * class {@code Object} does return distinct integers for distinct
     * objects. (This is typically implemented by converting the internal
     * address of the object into an integer, but this implementation
     * technique is not required by the
     * Java&trade; programming language.)
     *
     * @return a hash code value for this object.
     * @see Object#equals(Object)
     * @see System#identityHashCode
     */
    @Override
    public int hashCode() {
        return super.hashCode();
    }

    /**
     * Indicates whether some other object is "equal to" this one.
     * <p>
     * The {@code equals} method implements an equivalence relation
     * on non-null object references:
     * <ul>
     * <li>It is <i>reflexive</i>: for any non-null reference value
     * {@code x}, {@code x.equals(x)} should return
     * {@code true}.
     * <li>It is <i>symmetric</i>: for any non-null reference values
     * {@code x} and {@code y}, {@code x.equals(y)}
     * should return {@code true} if and only if
     * {@code y.equals(x)} returns {@code true}.
     * <li>It is <i>transitive</i>: for any non-null reference values
     * {@code x}, {@code y}, and {@code z}, if
     * {@code x.equals(y)} returns {@code true} and
     * {@code y.equals(z)} returns {@code true}, then
     * {@code x.equals(z)} should return {@code true}.
     * <li>It is <i>consistent</i>: for any non-null reference values
     * {@code x} and {@code y}, multiple invocations of
     * {@code x.equals(y)} consistently return {@code true}
     * or consistently return {@code false}, provided no
     * information used in {@code equals} comparisons on the
     * objects is modified.
     * <li>For any non-null reference value {@code x},
     * {@code x.equals(null)} should return {@code false}.
     * </ul>
     * <p>
     * The {@code equals} method for class {@code Object} implements
     * the most discriminating possible equivalence relation on objects;
     * that is, for any non-null reference values {@code x} and
     * {@code y}, this method returns {@code true} if and only
     * if {@code x} and {@code y} refer to the same object
     * ({@code x == y} has the value {@code true}).
     * <p>
     * Note that it is generally necessary to override the {@code hashCode}
     * method whenever this method is overridden, so as to maintain the
     * general contract for the {@code hashCode} method, which states
     * that equal objects must have equal hash codes.
     *
     * @param obj the reference object with which to compare.
     * @return {@code true} if this object is the same as the obj
     * argument; {@code false} otherwise.
     * @see #hashCode()
     * @see HashMap
     */
    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    /**
     * Creates and returns a copy of this object.  The precise meaning
     * of "copy" may depend on the class of the object. The general
     * intent is that, for any object {@code x}, the expression:
     * <blockquote>
     * <pre>
     * x.clone() != x</pre></blockquote>
     * will be true, and that the expression:
     * <blockquote>
     * <pre>
     * x.clone().getClass() == x.getClass()</pre></blockquote>
     * will be {@code true}, but these are not absolute requirements.
     * While it is typically the case that:
     * <blockquote>
     * <pre>
     * x.clone().equals(x)</pre></blockquote>
     * will be {@code true}, this is not an absolute requirement.
     * <p>
     * By convention, the returned object should be obtained by calling
     * {@code super.clone}.  If a class and all of its superclasses (except
     * {@code Object}) obey this convention, it will be the case that
     * {@code x.clone().getClass() == x.getClass()}.
     * <p>
     * By convention, the object returned by this method should be independent
     * of this object (which is being cloned).  To achieve this independence,
     * it may be necessary to modify one or more fields of the object returned
     * by {@code super.clone} before returning it.  Typically, this means
     * copying any mutable objects that comprise the internal "deep structure"
     * of the object being cloned and replacing the references to these
     * objects with references to the copies.  If a class contains only
     * primitive fields or references to immutable objects, then it is usually
     * the case that no fields in the object returned by {@code super.clone}
     * need to be modified.
     * <p>
     * The method {@code clone} for class {@code Object} performs a
     * specific cloning operation. First, if the class of this object does
     * not implement the interface {@code Cloneable}, then a
     * {@code CloneNotSupportedException} is thrown. Note that all arrays
     * are considered to implement the interface {@code Cloneable} and that
     * the return type of the {@code clone} method of an array type {@code T[]}
     * is {@code T[]} where T is any reference or primitive type.
     * Otherwise, this method creates a new instance of the class of this
     * object and initializes all its fields with exactly the contents of
     * the corresponding fields of this object, as if by assignment; the
     * contents of the fields are not themselves cloned. Thus, this method
     * performs a "shallow copy" of this object, not a "deep copy" operation.
     * <p>
     * The class {@code Object} does not itself implement the interface
     * {@code Cloneable}, so calling the {@code clone} method on an object
     * whose class is {@code Object} will result in throwing an
     * exception at run time.
     *
     * @return a clone of this instance.
     * @throws CloneNotSupportedException if the object's class does not
     *                                    support the {@code Cloneable} interface. Subclasses
     *                                    that override the {@code clone} method can also
     *                                    throw this exception to indicate that an instance cannot
     *                                    be cloned.
     * @see Cloneable
     */
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    /**
     * Returns a string representation of the object. In general, the
     * {@code toString} method returns a string that
     * "textually represents" this object. The result should
     * be a concise but informative representation that is easy for a
     * person to read.
     * It is recommended that all subclasses override this method.
     * <p>
     * The {@code toString} method for class {@code Object}
     * returns a string consisting of the name of the class of which the
     * object is an instance, the at-sign character `{@code @}', and
     * the unsigned hexadecimal representation of the hash code of the
     * object. In other words, this method returns a string equal to the
     * value of:
     * <blockquote>
     * <pre>
     * getClass().getName() + '@' + Integer.toHexString(hashCode())
     * </pre></blockquote>
     *
     * @return a string representation of the object.
     */
    @Override
    public String toString() {
        return super.toString();
    }

    /**
     * Called by the garbage collector on an object when garbage collection
     * determines that there are no more references to the object.
     * A subclass overrides the {@code finalize} method to dispose of
     * system resources or to perform other cleanup.
     * <p>
     * The general contract of {@code finalize} is that it is invoked
     * if and when the Java&trade; virtual
     * machine has determined that there is no longer any
     * means by which this object can be accessed by any thread that has
     * not yet died, except as a result of an action taken by the
     * finalization of some other object or class which is ready to be
     * finalized. The {@code finalize} method may take any action, including
     * making this object available again to other threads; the usual purpose
     * of {@code finalize}, however, is to perform cleanup actions before
     * the object is irrevocably discarded. For example, the finalize method
     * for an object that represents an input/output connection might perform
     * explicit I/O transactions to break the connection before the object is
     * permanently discarded.
     * <p>
     * The {@code finalize} method of class {@code Object} performs no
     * special action; it simply returns normally. Subclasses of
     * {@code Object} may override this definition.
     * <p>
     * The Java programming language does not guarantee which thread will
     * invoke the {@code finalize} method for any given object. It is
     * guaranteed, however, that the thread that invokes finalize will not
     * be holding any user-visible synchronization locks when finalize is
     * invoked. If an uncaught exception is thrown by the finalize method,
     * the exception is ignored and finalization of that object terminates.
     * <p>
     * After the {@code finalize} method has been invoked for an object, no
     * further action is taken until the Java virtual machine has again
     * determined that there is no longer any means by which this object can
     * be accessed by any thread that has not yet died, including possible
     * actions by other objects or classes which are ready to be finalized,
     * at which point the object may be discarded.
     * <p>
     * The {@code finalize} method is never invoked more than once by a Java
     * virtual machine for any given object.
     * <p>
     * Any exception thrown by the {@code finalize} method causes
     * the finalization of this object to be halted, but is otherwise
     * ignored.
     *
     * @throws Throwable the {@code Exception} raised by this method
     * @jls 12.6 Finalization of Class Instances
     * @see WeakReference
     * @see PhantomReference
     */
    @Override
    protected void finalize() throws Throwable {
        super.finalize();
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
