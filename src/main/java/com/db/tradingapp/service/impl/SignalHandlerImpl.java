package com.db.tradingapp.service.impl;

import com.db.tradingapp.config.TradingAppAlgo;
import com.db.tradingapp.service.SignalHandlerException;
import com.db.tradingapp.signal.SignalProcessor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import libraries.SignalHandler;

import java.util.Map;

@Service
public class SignalHandlerImpl implements SignalHandler {

    protected static final Logger LOGGER = LoggerFactory.getLogger(SignalHandlerImpl.class);
    private final TradingAppAlgo algo;
    private final Map<Integer, SignalProcessor> signalProcessors;

    public SignalHandlerImpl(TradingAppAlgo algo, Map<Integer, SignalProcessor> signalProcessors) {
        this.algo = algo;
        this.signalProcessors = signalProcessors;
    }

    @Override
    public void handleSignal(int signal) {
        LOGGER.atInfo().addArgument(signal).log("Processing for Signal : '{}'");

        // Validate Signal for Positive Integers.
        validateSignal(signal);

        // Get specific signal processor which is assigned to input signal and process
        processSignal(signal);
    }

    private void validateSignal(int signal) {
        LOGGER.atInfo().log("Validating Signal!");

        if (!(signal > 0 && signal < Integer.MAX_VALUE)) {
            LOGGER.atInfo().addArgument(signal).log("The signal '{}' is invalid!");
            throw new SignalHandlerException("The signal '" + signal + "' is invalid!");
        }
    }

    private void processSignal(int signal) {
        SignalProcessor signalProcessor = signalProcessors.get(signal);
        if (signalProcessor != null) {
            LOGGER.atInfo().addArgument(signal).log("Signal Processor for Signal : '{}' called!");
            signalProcessor.process(algo);
        } else {
            LOGGER.atInfo().log("Default Signal Processor called!");
            algo.cancelTrades();
        }
    }
}
