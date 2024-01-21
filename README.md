# ZuiSystemInfo  - 0.1 **Magia Record**

ZuiSystemInfo  - Magia Record 

Zui系统信息       - 魔法少女小圆

## 项目背景 - 0.1 魔法少女小圆版本 Magia Record version

​	该项目分为注册端和服务端。

​			服务端用来暴露接口用于发送当前服务器的配置信息和当前微服务的使用内存等信息，如CPU占用，磁盘等，并且实时交互，在安全方面，会使用JWT进行保证安全性。

​			注册端功能拥有一个配置列表，这个列表是注册端向列表的服务器进行请求 with JWT，获取到配置，并且实时更新。

## 使用方面

​	如果是客户端，那么只需要使用**@EnableZuiSystemServer**就可获取出此信息。

​	如果是客户端，那么就需要使用**@EnableZuiSystemConfig** 操作方式有3种，

​			A：在yml中配置所有服务端的信息，然后进行请求。 静态方案

​			B:   在yml中设置开启ZuiSystemInfo:interface 客户端配置接口，通过然后向外暴露接口进行配置  动态

​			C:  在B的基础上，在yml 将ZuiSystemInfo:web:ui 设置为true, 然后通过http://127.0.0.1:/ZuiSystemInfo/web/index.html 进行配置。 图形化，动态
