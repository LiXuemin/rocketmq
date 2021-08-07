### build
```
git pull
git switch release-4.9.0
mvn -Prelease-all -DskipTests clean install -U
cd distribution/target/rocketmq-4.9.0/rocketmq-4.9.0
```

`.\bin\mqnamesrv.cmd`

rocketmq还是得用jdk8
```
.\bin\mqnamesrv.cmd
OpenJDK 64-Bit Server VM warning: Option UseConcMarkSweepGC was deprecated in version 9.0 and will likely be removed in a future release.
Unrecognized VM option 'UseCMSCompactAtFullCollection'
Error: Could not create the Java Virtual Machine.
Error: A fatal exception has occurred. Program will exit.
PS D:\lixuemin\rocketmq\distribution\target\rocketmq-4.9.0\rocketmq-4.9.0> java -version
openjdk version "11.0.11" 2021-04-20
OpenJDK Runtime Environment AdoptOpenJDK-11.0.11+9 (build 11.0.11+9)
OpenJDK 64-Bit Server VM AdoptOpenJDK-11.0.11+9 (build 11.0.11+9, mixed mode)

```

jdk11编译，jdk8运行就会报错，改用jdk8重新编译
```
.\bin\tools.cmd  org.apache.rocketmq.example.quickstart.Producer
java.lang.IllegalStateException: org.apache.rocketmq.remoting.exception.RemotingSendRequestException: send request to <ocalhost/127.0.0.1:9876> failed11:41:04.477 [NettyClientSelector_1] INFO  RocketmqRemoting - closeChannel: close the connection to remote address[127.0.0.1:9876] result: true

11:41:04.477 [NettyClientSelector_1] INFO  RocketmqRemoting - closeChannel: close the connection to remote address[127.0.0.1:9876] result: true
        at org.apache.rocketmq.client.impl.factory.MQClientInstance.updateTopicRouteInfoFromNameServer(MQClientInstance.java:679)
        at org.apache.rocketmq.client.impl.factory.MQClientInstance.updateTopicRouteInfoFromNameServer(MQClientInstance.java:509)
        at org.apache.rocketmq.client.impl.producer.DefaultMQProducerImpl.tryToFindTopicPublishInfo(DefaultMQProducerImpl.java:702)
        at org.apache.rocketmq.client.impl.producer.DefaultMQProducerImpl.sendDefaultImpl(DefaultMQProducerImpl.java:566)
        at org.apache.rocketmq.client.impl.producer.DefaultMQProducerImpl.send(DefaultMQProducerImpl.java:1384)
        at org.apache.rocketmq.client.impl.producer.DefaultMQProducerImpl.send(DefaultMQProducerImpl.java:1328)
        at org.apache.rocketmq.client.producer.DefaultMQProducer.send(DefaultMQProducer.java:330)
        at org.apache.rocketmq.example.quickstart.Producer.main(Producer.java:67)
Caused by: org.apache.rocketmq.remoting.exception.RemotingSendRequestException: send request to <ocalhost/127.0.0.1:9876> failed
        at org.apache.rocketmq.remoting.netty.NettyRemotingAbstract.invokeSyncImpl(NettyRemotingAbstract.java:439)
        at org.apache.rocketmq.remoting.netty.NettyRemotingClient.invokeSync(NettyRemotingClient.java:377)
        at org.apache.rocketmq.client.impl.MQClientAPIImpl.getTopicRouteInfoFromNameServer(MQClientAPIImpl.java:1365)
        at org.apache.rocketmq.client.impl.MQClientAPIImpl.getTopicRouteInfoFromNameServer(MQClientAPIImpl.java:1355)
        at org.apache.rocketmq.client.impl.factory.MQClientInstance.updateTopicRouteInfoFromNameServer(MQClientInstance.java:622)
        ... 7 more
Caused by: io.netty.handler.codec.EncoderException: java.lang.NoSuchMethodError: java.nio.ByteBuffer.flip()Ljava/nio/ByteBuffer;
        at io.netty.handler.codec.MessageToByteEncoder.write(MessageToByteEncoder.java:125)
        at io.netty.channel.AbstractChannelHandlerContext.invokeWrite0(AbstractChannelHandlerContext.java:743)
        at io.netty.channel.AbstractChannelHandlerContext.invokeWrite(AbstractChannelHandlerContext.java:735)
        at io.netty.channel.AbstractChannelHandlerContext.write(AbstractChannelHandlerContext.java:820)
        at io.netty.channel.AbstractChannelHandlerContext.write(AbstractChannelHandlerContext.java:728)
        at io.netty.handler.timeout.IdleStateHandler.write(IdleStateHandler.java:284)
        at io.netty.channel.AbstractChannelHandlerContext.invokeWrite0(AbstractChannelHandlerContext.java:743)
        at io.netty.channel.AbstractChannelHandlerContext.invokeWrite(AbstractChannelHandlerContext.java:735)
        at io.netty.channel.AbstractChannelHandlerContext.write(AbstractChannelHandlerContext.java:820)
        at io.netty.channel.AbstractChannelHandlerContext.write(AbstractChannelHandlerContext.java:728)
        at io.netty.channel.ChannelDuplexHandler.write(ChannelDuplexHandler.java:106)
        at io.netty.channel.AbstractChannelHandlerContext.invokeWrite0(AbstractChannelHandlerContext.java:743)
        at io.netty.channel.AbstractChannelHandlerContext.invokeWrite(AbstractChannelHandlerContext.java:735)
        at io.netty.channel.AbstractChannelHandlerContext.access$1900(AbstractChannelHandlerContext.java:36)
        at io.netty.channel.AbstractChannelHandlerContext$AbstractWriteTask.write(AbstractChannelHandlerContext.java:1072)
        at io.netty.channel.AbstractChannelHandlerContext$WriteAndFlushTask.write(AbstractChannelHandlerContext.java:1126)
        at io.netty.channel.AbstractChannelHandlerContext$AbstractWriteTask.run(AbstractChannelHandlerContext.java:1061)
        at io.netty.util.concurrent.DefaultEventExecutor.run(DefaultEventExecutor.java:41)
        at io.netty.util.concurrent.SingleThreadEventExecutor$2.run(SingleThreadEventExecutor.java:140)
        at java.lang.Thread.run(Thread.java:748)
Caused by: java.lang.NoSuchMethodError: java.nio.ByteBuffer.flip()Ljava/nio/ByteBuffer;
        at org.apache.rocketmq.remoting.protocol.RemotingCommand.encodeHeader(RemotingCommand.java:427)
        at org.apache.rocketmq.remoting.protocol.RemotingCommand.encodeHeader(RemotingCommand.java:400)
        at org.apache.rocketmq.remoting.netty.NettyEncoder.encode(NettyEncoder.java:38)
        at org.apache.rocketmq.remoting.netty.NettyEncoder.encode(NettyEncoder.java:30)
        at io.netty.handler.codec.MessageToByteEncoder.write(MessageToByteEncoder.java:107)
        ... 19 more
```