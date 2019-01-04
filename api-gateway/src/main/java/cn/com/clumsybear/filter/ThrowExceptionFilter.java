package cn.com.clumsybear.filter;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

@Component
public class ThrowExceptionFilter extends ZuulFilter {
	private static Logger log = LoggerFactory.getLogger(ThrowExceptionFilter.class);

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		log.info("This is a pre filter,it will throw a RuntimeException!");
		RequestContext ctx = RequestContext.getCurrentContext();
		try {
			doSomething();
		} catch (Exception e) {
			ctx.set("error.status_code", HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			ctx.set("error.exception", e);
			ctx.setThrowable(e);
		
		}
		return null;
	}

	private void doSomething() {
		throw new RuntimeException("Exist some error...");
	}

	@Override
	public String filterType() {
		return "pre";
	}

	@Override
	public int filterOrder() {
		return 0;
	}

}
