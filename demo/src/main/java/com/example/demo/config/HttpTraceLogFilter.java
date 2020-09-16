package com.example.demo.config;

import cn.smallbun.screw.core.util.StringUtils;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.entity.OperatingRecordLog;
import com.example.demo.entity.OperatingRecordLogWithBLOBs;
import com.example.demo.mapper.OperatingRecordLogMapper;
import io.micrometer.core.instrument.MeterRegistry;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.http.RequestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;
import org.springframework.web.util.WebUtils;
import org.apache.*;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Date;
import java.util.Map;
import java.util.Objects;

/**
 * @Author: chenjianeng
 * @Date：2020/9/15 15:21
 */
@Slf4j
public class HttpTraceLogFilter extends OncePerRequestFilter implements Ordered {

    @Autowired
    private OperatingRecordLogMapper operatingRecordLogMapper;

    /**
     * 统一拦截的接口路径配置
     */
    private static final String NEED_TRACE_PATH_PREFIX = "/v1";
    /**
     * 拦截类型
     */
    private static final String IGNORE_CONTENT_TYPE = "multipart/form-data";

    private  MeterRegistry registry;

    public HttpTraceLogFilter(MeterRegistry registry) {
        this.registry = registry;
    }

    @Override
    public int getOrder() {
        return Ordered.LOWEST_PRECEDENCE - 10;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        if (!isRequestValid(request)) {
            filterChain.doFilter(request, response);
            return;
        }
        if (!(request instanceof ContentCachingRequestWrapper)) {
            request = new ContentCachingRequestWrapper(request);
        }
        if (!(response instanceof ContentCachingResponseWrapper)) {
            response = new ContentCachingResponseWrapper(response);
        }
        int status = HttpStatus.INTERNAL_SERVER_ERROR.value();
        long startTime = System.currentTimeMillis();
        try {
            filterChain.doFilter(request, response);
            status = response.getStatus();
        } finally {
            //请求路径
            String path = request.getRequestURI();
            if (path.startsWith(NEED_TRACE_PATH_PREFIX) && !Objects.equals(IGNORE_CONTENT_TYPE, request.getContentType())) {
                // 记录日志
                OperatingRecordLogWithBLOBs recordLog = new OperatingRecordLogWithBLOBs();
                recordLog.setApiUri(path);
                //方法
                recordLog.setMethod(request.getMethod());
                //耗时
                long timeConsuming = System.currentTimeMillis() - startTime;
                recordLog.setTimeConsuming(timeConsuming);
                recordLog.setCreateTime(new Date());
                //请求参数
                String requestBody = getRequestBody(request);
                if (StringUtils.isNotBlank(requestBody)) {
                    recordLog.setRequestParam(requestBody.replaceAll("\\s ", ""));
                } else {
                    recordLog.setRequestParam("");
                }
                //Http状态
                recordLog.setStatus(String.valueOf(status));
                //响应参数
                String responseBody = getResponseBody(response);
                if (StringUtils.isBlank(responseBody)) {
                    recordLog.setResponseParam("");
                    recordLog.setResponseCode(-1);
                } else {
                    Map stringToMap = JSONObject.parseObject(responseBody);
                    Integer code = (Integer) stringToMap.get("code");
                    if (null == code) {
                        recordLog.setResponseCode(-1);
                    } else {
                        recordLog.setResponseCode(code);
                    }
                    String message = (String) stringToMap.get("message");
                    if (StringUtils.isNotBlank(message)) {
                        recordLog.setResponseMessage(message);
                    } else {
                        recordLog.setResponseMessage("");
                    }
                    //返回参数占用空间较大 目前先不记录
                    //recordLog.setResponseParam(responseBody);
                    recordLog.setResponseParam("");
                }

                //获取用户凭证
                String token = request.getHeader("token");
                if (StringUtils.isBlank(token)) {
                    token = request.getParameter("token");
                }
                if (StringUtils.isBlank(token)) {
                    recordLog.setToken("");
                    recordLog.setMemberId(0);
                } else {
                    recordLog.setToken(token);
              /*      UserLoginInfoVo userLoginInfoVo = UserTokenHolder.getUserLoginInfoVo();
                    if (null != userLoginInfoVo) {
                        recordLog.setMemberId(userLoginInfoVo.getUserId());
                    } else {
                        recordLog.setMemberId(0);
                    }*/
                }
                recordLog.setRequestType(IGNORE_CONTENT_TYPE);
                //请求ip
              /*  String ipAddr = RequestUtil.get(request);
                if (StringUtils.isBlank(ipAddr)) {
                    recordLog.setIpAddress("");
                } else {
                    recordLog.setIpAddress(ipAddr);
                }*/
                operatingRecordLogMapper.insert(recordLog);
            }
            updateResponse(response);
        }
    }

    private boolean isRequestValid(HttpServletRequest request) {
        try {
            new URI(request.getRequestURL().toString());
            return true;
        } catch (URISyntaxException ex) {
            return false;
        }
    }

    private String getRequestBody(HttpServletRequest request) {
        String requestBody = "";
        ContentCachingRequestWrapper wrapper = WebUtils.getNativeRequest(request, ContentCachingRequestWrapper.class);
        if (wrapper != null) {
            try {
                //requestBody = IOUtils.toString(wrapper.getContentAsByteArray(), wrapper.getCharacterEncoding());
                System.out.println(wrapper);
            } catch (Exception e) {
                return "";
            }
        }
        return requestBody;
    }

    private String getResponseBody(HttpServletResponse response) {
        String responseBody = "";
        ContentCachingResponseWrapper wrapper = WebUtils.getNativeResponse(response, ContentCachingResponseWrapper.class);
        if (wrapper != null) {
            try {
              //  responseBody = IOUtils.toString(wrapper.getContentAsByteArray(), wrapper.getCharacterEncoding());
                System.out.println(wrapper);
            } catch (Exception e) {
                return responseBody;
            }
        }
        return responseBody;
    }

    private void updateResponse(HttpServletResponse response) throws IOException {
        ContentCachingResponseWrapper responseWrapper = WebUtils.getNativeResponse(response, ContentCachingResponseWrapper.class);
        Objects.requireNonNull(responseWrapper).copyBodyToResponse();
    }

}
