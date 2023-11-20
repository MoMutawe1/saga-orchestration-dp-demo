package com.orchestrationdemo.orderservicems.consumer;

import com.orchestrationdemo.orderservicems.model.OrchestratorRequest;
import com.orchestrationdemo.orderservicems.model.OrchestratorResponse;
import com.orchestrationdemo.orderservicems.service.UpdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Flux;

import java.util.function.Consumer;
import java.util.function.Supplier;

@Configuration
public class OrderConsumer {

    @Autowired
    private Flux<OrchestratorRequest> flux;

    @Autowired
    private UpdateService update;

    @Bean
    public Supplier<Flux<OrchestratorRequest>> supplier() {
        return () -> flux;
    }

    @Bean
    public Consumer<Flux<OrchestratorResponse>> consumer() {
        return c -> c
                .doOnNext(a -> System.out.println("Consuming::" + a))
                .flatMap(responseDTO -> update.updateOrder(responseDTO))
                .subscribe();
    };
}
