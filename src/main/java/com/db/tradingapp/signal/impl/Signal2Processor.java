package com.db.tradingapp.signal.impl;

import com.db.tradingapp.config.TradingAppAlgo;
import com.db.tradingapp.signal.SignalProcessor;
import org.springframework.stereotype.Component;

@Component
public class Signal2Processor implements SignalProcessor {

    @Override
    public int getSignalId() {
        return 2;
    }

    @Override
    public void process(TradingAppAlgo algo) {
        algo.reverse();
        algo.setAlgoParam(1,80);
        algo.submitToMarket();
    }
}
