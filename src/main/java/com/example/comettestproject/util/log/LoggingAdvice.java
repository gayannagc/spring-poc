package com.example.comettestproject.util.log;



import com.example.comettestproject.util.constants.Constants;
import com.example.comettestproject.util.constants.LoggingAdviceConstants;
import com.example.comettestproject.util.exception.BaseException;
import com.example.comettestproject.util.resultenum.ResponseCodeEnum;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.slf4j.MDC;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.concurrent.ExecutionException;

@Aspect
@Component
@Slf4j
public class LoggingAdvice {

    @Around("@annotation(org.springframework.web.bind.annotation.GetMapping) && args(.., request)")
    public Object logGetMethod(ProceedingJoinPoint jointPoint, HttpServletRequest request) throws Throwable {
        MethodSignature methodSignature = (MethodSignature) jointPoint.getSignature();
        String className = methodSignature.getDeclaringTypeName();
        String methodName = methodSignature.getName();
        long start = System.currentTimeMillis();
        MDC.put(LoggingAdviceConstants.API_NAME, methodName);
        MDC.put(LoggingAdviceConstants.CLASS_NAME, className);
        MDC.put(LoggingAdviceConstants.METHOD_NAME, methodName);
        log.info(LoggingAdviceConstants.REQUEST_INITIATED,request.getMethod(),request.getRequestURI());
        log.debug(LoggingAdviceConstants.FULL_REQUEST, Arrays.toString(jointPoint.getArgs()));
        return logResponseAndHeader(jointPoint,start,className,methodName);
    }

    @Around("@annotation(org.springframework.web.bind.annotation.PostMapping) && args(@RequestBody body,.., request)")
    public Object logPostMethod(ProceedingJoinPoint jointPoint, HttpServletRequest request,Object body) throws Throwable {
        MethodSignature methodSignature = (MethodSignature) jointPoint.getSignature();
        String className = methodSignature.getDeclaringTypeName();
        String methodName = methodSignature.getName();
        long start = System.currentTimeMillis();
        MDC.put(LoggingAdviceConstants.API_NAME, methodName);
        MDC.put(LoggingAdviceConstants.CLASS_NAME, className);
        MDC.put(LoggingAdviceConstants.METHOD_NAME, methodName);
        log.info(LoggingAdviceConstants.REQUEST_INITIATED,request.getMethod(),request.getRequestURI());
        log.debug(LoggingAdviceConstants.FULL_REQUEST, Arrays.toString(jointPoint.getArgs()));
        return logResponseAndHeader(jointPoint,start,className,methodName);
    }

    public Object logResponseAndHeader(ProceedingJoinPoint joinPoint,long start, String className, String methodName) throws Throwable {
        ObjectMapper mapper = new ObjectMapper();
        Object result = null;
        MDC.put(LoggingAdviceConstants.CLASS_NAME, className);
        MDC.put(LoggingAdviceConstants.METHOD_NAME, methodName);
        try {
            result = joinPoint.proceed();
            String response = mapper.writeValueAsString(result);
            JSONParser parser = new JSONParser();
            String resultCode = (String) ((JSONObject) ((JSONObject) ((JSONObject) parser.parse(response)).get("body")).get("result")).get("resultCode");
            String resultDescription = (String) ((JSONObject) ((JSONObject) ((JSONObject) parser.parse(response)).get("body")).get("result")).get("resultDescription");
            Long statusCodeValue= (Long) ((JSONObject) parser.parse(response)).get("statusCodeValue");
            long elapsedTime = System.currentTimeMillis() - start;
            log.debug(LoggingAdviceConstants.FULL_RESPONSE,response);
            log.info(LoggingAdviceConstants.REQUEST_TERMINATED,resultDescription, resultCode,statusCodeValue,elapsedTime);
            return result;

        } catch (BaseException ex) {
            long elapsedTime = System.currentTimeMillis() - start;
            log.error(LoggingAdviceConstants.EXCEPTION_REQUEST_TERMINATED,ex.getMessage(),ex.getReason(),ex.getResultCode(),ex.getHttpStatus(),displayStackStraceArray(ex.getStackTraceElement()),elapsedTime);
            log.debug(LoggingAdviceConstants.EXCEPTION_STACKTRACE, Arrays.toString(ex.getStackTraceElement()));
            throw new BaseException(ex.getMessage(), ex.getReason(),ex.getHttpStatus(),ex.getResultCode(),ex.getStackTraceElement());
        } catch (Exception ex) {
            long elapsedTime = System.currentTimeMillis() - start;
            log.error(LoggingAdviceConstants.EXCEPTION_REQUEST_TERMINATED,ex.getMessage(),ResponseCodeEnum.EXCEPTION_ADVISER_CONTROLLER.description(), ResponseCodeEnum.EXCEPTION_ADVISER_CONTROLLER.code(),HttpStatus.INTERNAL_SERVER_ERROR,displayStackStraceArray(ex.getStackTrace()),elapsedTime);
            log.debug(LoggingAdviceConstants.EXCEPTION_STACKTRACE, Arrays.toString(ex.getStackTrace()));
            throw new BaseException(ex.getMessage(), ResponseCodeEnum.EXCEPTION_ADVISER_SERVICE_LAYER.description(),HttpStatus.INTERNAL_SERVER_ERROR,ResponseCodeEnum.EXCEPTION_ADVISER_SERVICE_LAYER.code(),ex.getStackTrace());
        }
    }

    @Around("execution(* com.example.comettestproject.service..*(..)))")
    public Object logServiceInfo(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        String className = null;
        String methodName = null;
        long start = System.currentTimeMillis();
        try {
            MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();
            className = methodSignature.getDeclaringTypeName();
            methodName = methodSignature.getName();
            MDC.put(LoggingAdviceConstants.CLASS_NAME, className);
            MDC.put(LoggingAdviceConstants.METHOD_NAME, methodName);
            log.debug(LoggingAdviceConstants.SERVICE_INITIATED, new ObjectMapper().writeValueAsString(proceedingJoinPoint.getArgs()));
            Object object = proceedingJoinPoint.proceed();
            MDC.put(LoggingAdviceConstants.CLASS_NAME, className);
            MDC.put(LoggingAdviceConstants.METHOD_NAME, methodName);
            long elapsedTime = System.currentTimeMillis() - start;
            log.debug(LoggingAdviceConstants.SERVICE_TERMINATED, new ObjectMapper().writeValueAsString(object), elapsedTime);
            return object;
//        }catch (ExecutionException ex){
//            MDC.put(LoggingAdviceConstants.CLASS_NAME, className);
//            MDC.put(LoggingAdviceConstants.METHOD_NAME, methodName);
//            long elapsedTime = System.currentTimeMillis() - start;
//            throw ex;
        }  catch (BaseException ex) {
            MDC.put(LoggingAdviceConstants.CLASS_NAME, className);
            MDC.put(LoggingAdviceConstants.METHOD_NAME, methodName);
            long elapsedTime = System.currentTimeMillis() - start;
            log.error(LoggingAdviceConstants.EXCEPTION_SERVICE_TERMINATED, ex.getMessage(),ex.getReason(),ex.getResultCode(),ex.getHttpStatus(),elapsedTime);
            throw new BaseException(ex.getMessage(), ex.getReason(),ex.getHttpStatus(),ex.getResultCode(),ex.getStackTraceElement());
        } catch (Exception ex) {
            MDC.put(LoggingAdviceConstants.CLASS_NAME, className);
            MDC.put(LoggingAdviceConstants.METHOD_NAME, methodName);
            long elapsedTime = System.currentTimeMillis() - start;
            log.error(LoggingAdviceConstants.EXCEPTION_SERVICE_TERMINATED, ex.getMessage(),ResponseCodeEnum.EXCEPTION_ADVISER_SERVICE_LAYER.description(),ResponseCodeEnum.EXCEPTION_ADVISER_SERVICE_LAYER.code(),HttpStatus.INTERNAL_SERVER_ERROR,elapsedTime);
            throw new BaseException(ex.getMessage(), ResponseCodeEnum.EXCEPTION_ADVISER_SERVICE_LAYER.description(),HttpStatus.INTERNAL_SERVER_ERROR,ResponseCodeEnum.EXCEPTION_ADVISER_SERVICE_LAYER.code(),ex.getStackTrace());
        }
    }
//
//

    @Around("execution(* com.example.comettestproject.client..*(..)))")
    public Object logClientInfo(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        String className = null;
        String methodName = null;
        long start = System.currentTimeMillis();
        try {
            System.out.println("log Client Info: " + Thread.currentThread().getName());
            MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();
            className = methodSignature.getDeclaringTypeName();
            methodName = methodSignature.getName();
            MDC.put(LoggingAdviceConstants.CLASS_NAME, className);
            MDC.put(LoggingAdviceConstants.METHOD_NAME, methodName);
//            log.debug(LoggingAdviceConstants.HTTP_CLIENT_INITIATED,new ObjectMapper().writeValueAsString(proceedingJoinPoint.getArgs()));
            Object object=proceedingJoinPoint.proceed();
            MDC.put(LoggingAdviceConstants.CLASS_NAME, className);
            MDC.put(LoggingAdviceConstants.METHOD_NAME, methodName);
            long elapsedTime = System.currentTimeMillis() - start;
//            log.debug(LoggingAdviceConstants.HTTP_CLIENT_TERMINATED,new ObjectMapper().writeValueAsString(object),elapsedTime);
            return object;
        }  catch (BaseException ex) {
            MDC.put(LoggingAdviceConstants.CLASS_NAME, className);
            MDC.put(LoggingAdviceConstants.METHOD_NAME, methodName);
            long elapsedTime = System.currentTimeMillis() - start;
            log.error(LoggingAdviceConstants.EXCEPTION_HTTP_CLIENT_TERMINATED, ex.getMessage(),ex.getReason(),ex.getResultCode(),ex.getHttpStatus(),elapsedTime);
            throw new BaseException(ex.getMessage(), ex.getReason(),ex.getHttpStatus(),ex.getResultCode(),ex.getStackTraceElement());
        } catch (Exception ex) {
            MDC.put(LoggingAdviceConstants.CLASS_NAME, className);
            MDC.put(LoggingAdviceConstants.METHOD_NAME, methodName);
            long elapsedTime = System.currentTimeMillis() - start;
            log.error(LoggingAdviceConstants.EXCEPTION_HTTP_CLIENT_TERMINATED, ex.getMessage(),ResponseCodeEnum.EXCEPTION_ADVISER_ADAPTER_INTEGRATION_LAYER.description(),ResponseCodeEnum.EXCEPTION_ADVISER_ADAPTER_INTEGRATION_LAYER.code(),HttpStatus.INTERNAL_SERVER_ERROR,elapsedTime);
            throw new BaseException(ex.getMessage(), ResponseCodeEnum.EXCEPTION_ADVISER_ADAPTER_INTEGRATION_LAYER.description(),HttpStatus.INTERNAL_SERVER_ERROR,ResponseCodeEnum.EXCEPTION_ADVISER_ADAPTER_INTEGRATION_LAYER.code(),ex.getStackTrace());
        }
    }

    public String displayStackStraceArray(StackTraceElement[] stackTraceElements) {
        StringBuilder stringBuilder = new StringBuilder();
        if (stackTraceElements != null && stackTraceElements.length != 0){
            for (StackTraceElement elem : stackTraceElements) {
                if (elem.getClassName().startsWith(LoggingAdviceConstants.PACKAGE_ROOT) && elem.getLineNumber() > 0) {
                    stringBuilder.append(elem.toString());
                    break;
                }
            }

        }else {
            stringBuilder.append(Constants.STACK_TRACE_UNAVAILABLE);
        }
        return stringBuilder.toString();
    }
}

