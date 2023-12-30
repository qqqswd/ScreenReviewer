package screenreviewer.aop;


import com.alibaba.fastjson.JSONObject;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import screenreviewer.mapper.OperateLogMapper;
import screenreviewer.pojo.OperateLog;
import screenreviewer.utils.JwtUtils;

import java.time.LocalDateTime;
import java.util.Arrays;

@Slf4j // 操作日志
@Component
@Aspect // 切面类
public class LogAspect {

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private OperateLogMapper operateLogMapper;

    @Around("@annotation(screenreviewer.annotation.Log)") // 匹配的是方法上加有@Log的方法
    public Object recordLog(ProceedingJoinPoint joinPoint) throws Throwable {
        // 操作人ID --当前登录人员
        // 获取请求头中的jwt令牌，解析令牌
        String jwt = request.getHeader("token");
        Claims claims = JwtUtils.parseJWT(jwt);
        String operateUser = (String) claims.get("id");

        // 操作时间
        LocalDateTime operateTime = LocalDateTime.now();

        // 操作类名
        String className = joinPoint.getSignature().getName();

        // 操作方法名
        String methodName = joinPoint.getTarget().getClass().getName();

        // 操作方法参数
        Object[] args = joinPoint.getArgs();
        String methodParams = Arrays.toString(args);

        // 开始计时
        long begin = System.currentTimeMillis();

        // 调用原始目标方法执行
        Object result = joinPoint.proceed();

        long end = System.currentTimeMillis();

        // 方法返回值
        String returnValue = JSONObject.toJSONString(result);

        // 操作耗时
        Long costTime = end - begin;

        // 记录操作日志

        OperateLog operateLog = new OperateLog(null, operateUser, operateTime, className, methodName, methodParams, returnValue, costTime);
        operateLogMapper.insert(operateLog);

        log.info("AOP记录操作日志:{}", operateLog);

        return result;
    }
}