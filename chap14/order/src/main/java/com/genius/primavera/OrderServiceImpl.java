package com.genius.primavera;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Slf4j
@Service
public class OrderServiceImpl implements OrderService {

	@Override
	public Mono<List<Order>> findByUserId(String userId) throws InterruptedException {
		log.info("Start Find Id : {}", userId);
		Thread.sleep(50);
		Mono<List<Order>> orders = Mono.just(newOrderInstance(100));
		log.info("Stop Find Id : {}", userId);
		return orders;
	}

	private List<Order> newOrderInstance(int n) {
		List<Order> orders = new ArrayList<>();
		for (int i = 1; i <= n; i++) {
			orders.add(new Order(i, i));
		}
		return orders;
	}
}