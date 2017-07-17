# IntegrationSystem
## 项目介绍

本项目集成了团购系统服务器端，团购系统客户端，银行系统，短信系统，零售商系统5大java系统，系统之间使用RMI, Web service, JMS技术进行通信。

## 模块组成

### GroupPurchase
包括团购系统的服务器端和客户端，使用RMI进行通信。均使用提供的jar包。

RMI部分的实现：

 - 数据对象序列化：GroupPurchaseItem
 - 本地接口实现Remote：
    listGroupPurchase 获取零售端发布的团购信息
    submitPurchase 向零售端提交购买信息
 - 均在GPMS中实现过这两个接口，通过GroupPurchaseManagementSystem的实例进行远程调用

### Retail
用java重写了原来提供的C++系统。实现三个主要功能：

 1. 商品信息发布->团购系统
 2. 输入验证码确认购买->团购系统
 3. 历史转账记录查询->银行系统

### Bank
用java重写了原来提供的C++系统。模拟实现两个主要功能：

 1. 接受转账
 2. 查询转账记录

### ShortMessage
接收团购系统发送过来的验证码，并在短信系统中输出。

#### Retail-GPMS
零售端作为团购系统的客户端，调用GPMS提供的确认购买，以及向GPMS发布团购商品信息。
使用Web Service技术，这里使用JAX-WS实现对远程方法的调用。服务器端通过@WebService等注解标注类与方法,然后定义WebService的发布地址，这个地址就是提供给外界访问Webervice的URL地址。客户端可通过JWS自带的wsimport命令在客户端本地生成代码供客户端访问调用,以其实现对服务器方法的调用管理(自动生成的代码在gpms中)

#### Retail-Bank
使用Web Service技术，类似上面这里不赘述

#### Bank-GPMS
使用Web Service技术，类似上面这里不赘述

#### GPMS-ShortMessage
使用JMS技术
短信系统的使用方法如下：
①必须先安装ActiveMQ，下载地址：http://activemq.apache.org， 按照官网说明安装和运行ActiveMQ
②运行成功后应该可以访问 http://localhost:8161/admin，初始用户名/密码为：admin/admin
③运行Application类，本程序开始监听短信
④复制Sender类到团购系统中，调用sender中的方法发送信息
⑤本程序显示接受到的短信内容


## 集成时遇到的问题
在同一局域网的不同计算机上分别部署几个项目时的集成问题
