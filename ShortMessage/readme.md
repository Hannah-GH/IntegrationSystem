#### 短信系统使用方法：
1. 必须先安装ActiveMQ，下载地址：http://activemq.apache.org， 按照官网说明安装和运行ActiveMQ
2. 运行成功后应该可以访问 http://localhost:8161/admin，初始用户名/密码为：admin/admin
3. 运行Application类，本程序开始监听短信
4. 复制Sender类到团购系统中，调用sender中的方法发送信息
5. 本程序显示接受到的短信内容