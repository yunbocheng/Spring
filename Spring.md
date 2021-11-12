# Spring 框架

## 第一章 Spring概述

### 1.Spring框架介绍

- **Spring**：出现在2002年左右，降低企业级开发难度。帮助进行模块之间、类与类之间的管理，帮助开发人员创建对象，管理对象之间的关系。

- 2003年传入国内，被大量使用。2017出现新的流行框架SpringBoot，核心思想与Spring相同。

- **核心技术**：IoC、AOP，能使模块之间、类之间解耦合。
- 依赖：class A使用class B的属性或方法，称之为class A依赖class B。
- **官网**：spring.io

### 2.Spring框架的特点

- 轻量：Spring的所需要的jar包都非常小，一般1M以下，几百kb。核心功能所需要的jar包总共3M左右。Spring框架运行占有资源少，运行效率高，不依赖其他jar。
-  针对接口编程，解耦合：Spring提供了Ioc控制反转，由容器管理对象，对象的依赖关系。原来在程序代码中的对象创建方式(反射机制、new)，现在由容器完成，对象之间的依赖解耦合。
-  AOP 编程的支持：通过Spring提供的AOP功能，方便进行面向切面的编程，许多不容易使用OOP实现的功能可以通过AOP轻松应对。
- 方便集成各种优秀框架：Spring不排斥各种优秀的开源框架，相反Spring可以降低各种框架的使用难度，Spring提供了对各种优秀框的直接支持。

### 3. Spring体系结构

![image-20211111160508537](https://gitee.com/YunboCheng/imageBad/raw/master/image/image-20211111160508537.png)

Spring 由 20 多个模块组成，它们可以分为数据访问/集成（Data Access/Integration）、 Web、面向切面编程（AOP, Aspects）、提供JVM的代理 （Instrumentation）、消息发送（Messaging）、 核心容器（Core Container）和测试（Test）。

- **myBatis存在于Data Access**
- **SpringMVC中存在于Web**
- **Java对象存在于Core Container中**
- **测试类似于junit，进行代码测试的**

## 第二章 IoC控制反转

#### **2.1 控制反转的概念**

- **控制反转**（IoC，Inversion of Control），是一个概念，是一种思想。指将传统上由程序代 码直接操控的对象调用权交给容器，通过容器来实现对象的装配和管理。控制反转就是对对 象控制权的转移，从程序代码本身反转到了外部容器。通过容器实现对象的创建，属性赋值， 依赖的管理。
- **控制：**创建对象，对象的属性值赋值，对象之间的关系管理。
- **反转：**把原来的开发人员管理，创建对象的权限转移交给代码之外的容器实现。由容器代替开发人员管理对象。创建对象，给属性赋值。
- **正转：**把原来的开发人员管理，创建对象的权限转移给代码之外的容器实现。由容器代替开发人员管理对象，创建对象，给属性赋值。
- **容器：**是一个服务软件，一个框架(Spring)
- **Ioc 的实现**：
  -  依赖查找：DL( Dependency Lookup ),容器提供回调接口和上下文环境给组件。
  -  依赖注入：DI(Dependency Injection)，程序代码不做定位查询，这些工作由容器自行完成。**Spring 框架使用依赖注入（DI）实现 IoC。**

**Java中创建对象的方式**

- 构造方法，new Student()
- 反射 ：Class
- 序列化 ：数据库
- 克隆 : Clone
- 动态代理 ：AOP

- IoC  :  控制反转

**IoC的体现**

**之前学习到的应用控制反转的实例：Servlet对象的创建管理，这一工作完全交给了Web容器。**

 Tomcat就是一个容器：里面存放有Servlet对象、Listener对象、Filter对象等。

**IoC的技术实现**

- DI是IoC的技术实现，DI(Dependency Injection) : 依赖注入，只需要在程序中提供要使用的对象名就可以，至于对象如何在容器中创建、赋值、查找都由容器内部实现。
- Spring是使用DI实现了IoC的功能，**Spring底层创建对象，是使用的反射机制**

#### 2.2 Spring第一个程序



 