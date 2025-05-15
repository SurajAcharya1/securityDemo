package com.example.securityDemo.qualifierPractice;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class ServerRunner {

    private final Server local;

    private final Server production;

    public ServerRunner(@Qualifier("local") Server local,
                        @Qualifier("production") Server production) {
        this.local = local;
        this.production = production;
    }

    void st() {
        local.runServer();
    }

    void stp() {
        production.runServer();
    }



}
