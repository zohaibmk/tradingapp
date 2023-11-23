package com.db.tradingapp.config;

import com.db.tradingapp.signal.SignalProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Configuration
public class SignalProcessorConfiguration {

    @Bean
    public Map<Integer, SignalProcessor> signalProcessorMap(List<SignalProcessor> signalProcessors) {
        return signalProcessors.stream().collect(Collectors.toMap(SignalProcessor::getSignalId, Function.identity()));
    }
}
