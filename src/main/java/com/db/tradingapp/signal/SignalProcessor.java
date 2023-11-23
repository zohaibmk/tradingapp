package com.db.tradingapp.signal;

import com.db.tradingapp.config.TradingAppAlgo;

public interface SignalProcessor {

    int getSignalId();

    void process(TradingAppAlgo algo);
}
