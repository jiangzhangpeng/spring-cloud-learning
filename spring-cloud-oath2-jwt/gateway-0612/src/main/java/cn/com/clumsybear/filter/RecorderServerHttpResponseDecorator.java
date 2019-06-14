package cn.com.clumsybear.filter;

import java.util.LinkedList;
import java.util.List;

import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.http.server.reactive.ServerHttpResponseDecorator;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class RecorderServerHttpResponseDecorator extends ServerHttpResponseDecorator {
	private final List<DataBuffer> dataBuffers = new LinkedList<>();
	private boolean bufferCached = false;
	private Mono<Void> progress = null;

	public RecorderServerHttpResponseDecorator(ServerHttpResponse delegate) {
		super(delegate);
	}
}
