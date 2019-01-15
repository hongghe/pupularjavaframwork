package com.hongghe.prometheus.interceptor;

import io.prometheus.client.Counter;
import io.prometheus.client.Summary;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.AsyncHandlerInterceptor;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author: hongghe @date: 2019-01-15 15:26
 */
public class PrometheusInterceptor implements HandlerInterceptor {

    private static final Counter STARTING_COUNTER = Counter.build()
            .namespace("promethus")
            .subsystem("http")
            .name("started_total_apollo")
            .labelNames("bean", "method")
            .help("The help")
            .register();

    private static final Summary COMPLETE_SUMMARY = Summary.build()
            .namespace("apollo_test")
            .subsystem("http")
            .name("apollo_test_name")
            .labelNames("bean", "method", "status", "exception")
            .help("Summary of http response latency (in seconds) for completed invoke.")
            .register();
    private static final String HOLDER_REQUEST_ATTR = PrometheusInterceptor.class.getName() + ".HOLDER_REQUEST_ATTR";

    /**
     * Intercept the execution of a handler. Called after HandlerMapping determined
     * an appropriate handler object, but before HandlerAdapter invokes the handler.
     * <p>DispatcherServlet processes a handler in an execution chain, consisting
     * of any number of interceptors, with the handler itself at the end.
     * With this method, each interceptor can decide to abort the execution chain,
     * typically sending a HTTP error or writing a custom response.
     * <p><strong>Note:</strong> special considerations apply for asynchronous
     * request processing. For more details see
     * {@link AsyncHandlerInterceptor}.
     * <p>The default implementation returns {@code true}.
     *
     * @param request  current HTTP request
     * @param response current HTTP response
     * @param handler  chosen handler to execute, for type and/or instance evaluation
     * @return {@code true} if the execution chain should proceed with the
     * next interceptor or the handler itself. Else, DispatcherServlet assumes
     * that this interceptor has already dealt with the response itself.
     * @throws Exception in case of errors
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (request.getAttribute(HOLDER_REQUEST_ATTR) != null) {
            return true;
        }
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Holder holder = new Holder(handlerMethod.getBeanType().getName(), handlerMethod.getMethod().getName(), System.currentTimeMillis());
        request.setAttribute(HOLDER_REQUEST_ATTR, holder);
        STARTING_COUNTER.labels(holder.bean, holder.method).inc();
        return true;
    }

    /**
     * Intercept the execution of a handler. Called after HandlerAdapter actually
     * invoked the handler, but before the DispatcherServlet renders the view.
     * Can expose additional model objects to the view via the given ModelAndView.
     * <p>DispatcherServlet processes a handler in an execution chain, consisting
     * of any number of interceptors, with the handler itself at the end.
     * With this method, each interceptor can post-process an execution,
     * getting applied in inverse order of the execution chain.
     * <p><strong>Note:</strong> special considerations apply for asynchronous
     * request processing. For more details see
     * {@link AsyncHandlerInterceptor}.
     * <p>The default implementation is empty.
     *
     * @param request      current HTTP request
     * @param response     current HTTP response
     * @param handler      handler (or {@link HandlerMethod}) that started asynchronous
     *                     execution, for type and/or instance examination
     * @param modelAndView the {@code ModelAndView} that the handler returned
     *                     (can also be {@code null})
     * @throws Exception in case of errors
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    }

    /**
     * Callback after completion of request processing, that is, after rendering
     * the view. Will be called on any outcome of handler execution, thus allows
     * for proper resource cleanup.
     * <p>Note: Will only be called if this interceptor's {@code preHandle}
     * method has successfully completed and returned {@code true}!
     * <p>As with the {@code postHandle} method, the method will be invoked on each
     * interceptor in the chain in reverse order, so the first interceptor will be
     * the last to be invoked.
     * <p><strong>Note:</strong> special considerations apply for asynchronous
     * request processing. For more details see
     * {@link AsyncHandlerInterceptor}.
     * <p>The default implementation is empty.
     *
     * @param request  current HTTP request
     * @param response current HTTP response
     * @param handler  handler (or {@link HandlerMethod}) that started asynchronous
     *                 execution, for type and/or instance examination
     * @param ex       exception thrown on handler execution, if any
     * @throws Exception in case of errors
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        Holder holder = (Holder) request.getAttribute(HOLDER_REQUEST_ATTR);
        if (holder != null) {
            COMPLETE_SUMMARY.labels(holder.bean, holder.method, String.valueOf(response.getStatus()), ex == null ? "none" : ex.getClass().getName())
                    .observe((System.currentTimeMillis() - holder.beginTime) / 1000D);
        }
    }

    private static class Holder {
        final String bean;
        final String method;
        final long beginTime;
        Holder(String bean, String method, long beginTime) {
            this.bean = bean;
            this.method = method;
            this.beginTime = beginTime;
        }
    }
}
