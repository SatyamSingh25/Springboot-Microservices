## Springboot Microservice structure


#### :) Dependencies added in each microservice
| Config Server | Service registry | API Gateway   | Depatment Service                             | Employee Service |
|---------------|------------------|---------------|-----------------------------------------------|------------------|
| Config server | Eureka Server    | Gateway       | Eureka Client                                 | Eureka Client    |
|               | Spring Web       | Eureka Client | Spring Web                                    | Spring web       |
|               |                  | Actuator      | Actuator                                      | Actuator         |
|               |                  | Zipkin        | Config Client                                 | Config Client    |
|               |                  |               | - Zipkin<br/> - Lombok<br/> - Spring Reactive | - Zipkin<br/> - Lombok<br/> - Spring Reactive                 |
