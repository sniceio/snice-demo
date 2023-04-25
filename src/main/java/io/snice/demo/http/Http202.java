package io.snice.demo.http;

import io.snice.testing.core.scenario.Simulation;
import io.snice.testing.runtime.Snice;

import static io.snice.testing.core.CoreDsl.scenario;
import static io.snice.testing.http.HttpDsl.get;
import static io.snice.testing.http.HttpDsl.http;
import static io.snice.testing.http.check.HttpCheckSupport.status;

public class Http202 extends Simulation {

    {
        final var http = http().baseUrl("http://local.honeypot.snice.io");
        final var get = get("/error").check(status().is(500));
        final var scenario = scenario("Simple GET error").execute(get);
        setUp(scenario).protocols(http);


    }

    public static void main(final String... args) throws Exception {
        Snice.start(args).sync();
    }

}
