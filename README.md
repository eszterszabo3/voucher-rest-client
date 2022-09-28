# REST Client
## Running Prometheus

1. Open Docker
2. `docker run -d -p 9090:9090 -v "/$(pwd)/prometheus/prometheus.yml:/etc/prometheus/prometheus.yml" prom/prometheus`

Useful Prometheus queries for Rest Client start with:
httpcomponents_httpclient_pool_

## Running Gatling - Performance Testing framework

**Ensure server and REST client is running before attempting Gatling run**
 
`./gradlew gatlingRun `

**Example output of Terminal window and report found in *examples***


