package com.db.tradingapp.signal.impl;

import com.db.tradingapp.config.TradingAppAlgo;
import com.db.tradingapp.signal.SignalProcessor;
import org.springframework.stereotype.Component;

@Component
public class Signal3Processor implements SignalProcessor {

    @Override
    public int getSignalId() {
        return 3;
    }

    @Override
    public void process(TradingAppAlgo algo) {
        algo.setAlgoParam(1,90);
        algo.setAlgoParam(2,15);
        algo.performCalc();
        algo.submitToMarket();
    }
}
