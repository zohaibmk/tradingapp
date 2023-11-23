package com.db.tradingapp.controller;

import libraries.SignalHandler;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SignalController {

    private final SignalHandler signalHandler;

    public SignalController(SignalHandler signalHandler) {
        this.signalHandler = signalHandler;
    }

    @GetMapping("/signal/{signalId}")
    public ResponseEntity<Void> receiveSignal(@PathVariable int signalId) {
        try {
            signalHandler.handleSignal(signalId);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }
}
