package com.db.tradingapp.signal.impl;

import com.db.tradingapp.config.TradingAppAlgo;
import com.db.tradingapp.signal.SignalProcessor;
import org.springframework.stereotype.Component;

@Component
public class Signal1Processor implements SignalProcessor {

    @Override
    public int getSignalId() {
        return 1;
    }

    @Override
    public void process(TradingAppAlgo algo) {
        algo.setUp();
        algo.setAlgoParam(1,60);
        algo.performCalc();
        algo.submitToMarket();
    }
}
