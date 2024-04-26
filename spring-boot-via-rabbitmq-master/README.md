# RabbitMQ via Spring Boot
## Exchange
In messaging systems, an exchange is a type of message router that routes messages to one or more queues. Queues are the destinations where messages are stored until they are consumed by the application. In Spring Boot, different types of exchanges are used to route messages to specific queues based on the routing key, message pattern, or header value.

1. **Direct Exchange**: It routes the message to a queue based on the message routing key. Direct exchange is used when a message needs to be delivered to a specific queue.
2. **Fanout Exchange**: It routes the message to all the queues that are bound to it. Fanout exchange is used when a message needs to be delivered to all the queues that are listening to it.
3. **Topic Exchange**: It routes the message to a queue based on the message routing key pattern. Topic exchange is used when a message needs to be delivered to one or many queues based on the message pattern.
4. **Headers Exchange**: It routes the message to a queue based on header values instead of routing key. Headers exchange is used when a message needs to be delivered to one or many queues based on the header value.