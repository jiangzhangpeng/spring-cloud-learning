package cn.com.clumsybear.filter;

import static org.springframework.cloud.gateway.support.ServerWebExchangeUtils.GATEWAY_REQUEST_URL_ATTR;

import java.net.URI;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import reactor.core.publisher.Mono;
@Component
public class RequestRecorderGlobalFilter implements GlobalFilter, Ordered {
	private Logger logger = LoggerFactory.getLogger(RequestRecorderGlobalFilter.class);
	private static final String START_TIME = "startTime";
	private static Map<String, String> threadData = new HashMap<>();
    private static Map<String, Integer> threadNum = new HashMap<>();

	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
		 //路由到哪一个微服务
//      Route gatewayUrl = exchange.getRequiredAttribute(ServerWebExchangeUtils.GATEWAY_ROUTE_ATTR);
//      URI uri = gatewayUrl.getUri();
      //路径处理
      URI requestUrl = exchange.getRequiredAttribute(GATEWAY_REQUEST_URL_ATTR);
      //时间处理
      SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss,SSS");
      Date date = Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant());
      String startDate = sdf.format(date);
      exchange.getAttributes().put(START_TIME, System.currentTimeMillis());
      return chain.filter(exchange).then(Mono.fromRunnable(() -> {
          Long startTime = exchange.getAttribute(START_TIME);
          if (startTime != null) {
              long endTime = System.currentTimeMillis();
              long times = endTime - startTime;
              logger.info("[{}] [{}] [{}] [{}]   ", getMethodId(), 
                      requestUrl + (exchange.getRequest().getQueryParams() == null ? "" : "?" + exchange.getRequest().getQueryParams()),
                      times, startDate
                      );

          }
      }));
	}

	  /**
     * 获取线程号
     *
     * @return 线程号
     */
    private static String getThreadId() {
        return String.valueOf(Thread.currentThread().getId());
    }

    /**
     * 获取业务ID
     *
     * @return 业务ID
     */
	/*
	 * private static String getServiceId() {
	 * 
	 * String serviceID;
	 * 
	 * if (AopThreadLocal.getAopServiceid() != null) { serviceID =
	 * AopThreadLocal.getAopServiceid(); } else { serviceID = getUuid();
	 * AopThreadLocal.setAopServiceid(serviceID); } return serviceID; }
	 */

    /**
     * 获取方法ID
     *
     * @return 方法ID
     */
    private static String getMethodId() {
        String threadId = getThreadId();
        return threadData.get(threadId + "|" + threadNum.get(threadId));
    }

	/*
	 * public static String getLoginUser() { if
	 * (AopThreadLocal.getThreadLocalRequest() != null) { return
	 * AopThreadLocal.getThreadLocalRequest().getUser(); } return null; }
	 */

    /**
     * 获取UUID
     *
     * @return UUID
     */
	/*
	 * private static String getUuid() { if
	 * ("true".equalsIgnoreCase(AopLogConfig.UUID_ON_OFF)) { return
	 * UUIDGenerator.getInstance().generateRandomBasedUUID().toString();//
	 * 切面方法id,应为方法主键 } return ""; }
	 */

    @Override
    public int getOrder() {
        return Ordered.LOWEST_PRECEDENCE;
    }

}
