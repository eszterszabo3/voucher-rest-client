import io.gatling.javaapi.core.*;
import io.gatling.javaapi.http.*;

import static io.gatling.javaapi.core.CoreDsl.*;
import static io.gatling.javaapi.http.HttpDsl.*;

public class BasicSimulation extends Simulation {

    HttpProtocolBuilder httpProtocol = http
            .baseUrl("http://localhost:8080/");

    ScenarioBuilder scn = scenario("REST Client")
            .exec(http("request_1") // 8
                    .get("/vouchers-rest-client/0"));

    {
        setUp(
                scn.injectOpen(rampUsers(1000).during(30))
        ).protocols(httpProtocol);
    }
}