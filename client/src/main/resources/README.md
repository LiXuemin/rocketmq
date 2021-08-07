producer.start()启动流程
...

几个重要的职责类
1. DefaultMQProducerImpl: Producer的内部实现类，大部分producer的发送逻辑，都在此类中。
2. MQClientInstance: 这个类中封装了客户端中一些通用的业务逻辑，无论Producer还是Consumer最终与服务端交互时，都需要调用这个类中的方法。
3. MQClientAPIImpl: 封装了客户端服务端的RPC，对调用者隐藏了真正网络通信部分的具体实现。
4. NettyRemotingClient: RocketMQ各进程之间网络通信的底层实现类。