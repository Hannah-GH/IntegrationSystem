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
使用Web Service技术，零售端作为团购系统的客户端，调用GPMS提供的确认购买，以及向GPMS发布团购商品信息。

#### Retail-Bank
使用Web Service技术

#### Bank-GPMS
使用Web Service技术

#### GPMS-ShortMessage
使用JMS技术


## 集成时遇到的问题
