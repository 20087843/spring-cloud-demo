Kafka 安装配置(windows)
===

#### 安装配置
1. kafka 安装文件下载
    - [下载地址](http://kafka.apache.org/downloads)
2. 解压缩安装包
3. 配置 config\zookeeper.properties 中数据目录(dataDir)和服务端口(clientPort)
4. 配置 config\server.properties 中日志目录(log.dirs)和zookeeper 端口(zookeeper.connect)
5. 进入kafka根目录，启动 zookeeper 服务
    ```text
      bin\windows\kafka-server-start.bat config\server.properties
    ```
6. 进入kafka根目录，启动 kafka 服务
    ```text
      bin\windows\zookeeper-server-start.bat config\zookeeper.properties
    ```

#### 注意事项
1. kafka 基于 zookeeper, 必须先启动 zookeeper, 然后再启动 kafka
2. xxx.properties 中目录分割符必须是双反斜杠。eg. dataDir=C:\\Applications\\kafka2.12\\data