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

见项目。

## 第三章 AOP 面向切面编程

### 3.1 动态代理

**动态代理的分类**

- jdk动态代理：使用jdk中的Proxy、Method、InvocationHanderl创建代理对象。jdk动态代理要求目标类必须实现接口。要求：目标类中必须实现接口

- cglib动态代理：第三方工具，创建代理对象，原理是继承。通过继承目标类，创建子类，子类就是代理对象。要求：目标类必须能够继承，目标类不能是final的，方法也不能是final的。**其子类就是代理对象。**

**动态代理的作用：**

- 在目标类源代码不改变的情况下，增加新的功能(即方法)
- 减少代码的重复
- 专注业务逻辑代码
- 解耦合，让你的业务红能和日志，事务与非事务功能分离

### 3.2 AOP面向切面编程

- AOP就是基于动态代理的，可以使用jdk、cglib两种代理模式。AOP就是动态代理的规范化，把动态代理的实现步骤，方式都定义好了，让开发人员用一种统一的方式，使用动态代理。它的功能和动态代理是一样的。

AOP（Aspect Orient Programming），面向切面编程。面向切面编程是从动态角度考虑程序运行过程。 

**AOP 底层，就是采用动态代理模式实现的。采用了两种代理：JDK 的动态代理，与 CGLIB 的动态代理。**

**所谓的切面：就是给目标类增加的额外的功能。**

**切面的特点：一般都是与业务无关的功能，并且这个功能可以独立使用。**

**精准概念：**

- AOP 为 Aspect Oriented Programming 的缩写，意为：面向切面编程，可通过运行期动态代理实现程序功能的统一维护的一种技术。AOP 是 Spring 框架中的一个重要内容。利用 AOP 可以对业务逻辑的各个部分进行隔离，从而使得业务逻辑各部分之间的耦合度降低，提高程 序的可重用性，同时提高了开发的效率。  

**怎么理解面向切面编程**

- 需要在分析项目功能时，找出切面（重点）
- 合理的安排切面的执行时间(在目标放前，还是目标方法之后。）
- 合理的安排切面执行的位置，在哪个类，哪个方法中增加切面。

**针对AOP切面编程的分析**

- 面向切面编程，就是将交叉业务逻辑封装成切面，利用 AOP 容器的功能将切面织入到 主业务逻辑中。所谓交叉业务逻辑是指，通用的、与主业务逻辑无关的代码，如安全检查、 事务、日志、缓存等。 若不使用 AOP，则会出现代码纠缠，即交叉业务逻辑与主业务逻辑混合在一起。这样， 会使主业务逻辑变的混杂不清。 

- 例如，转账，在真正转账业务逻辑前后，需要权限控制、日志记录、加载事务、结束事 务等交叉业务逻辑，而这些业务逻辑与主业务逻辑间并无直接关系。但，它们的代码量所占 比重能达到总代码量的一半甚至还多。它们的存在，不仅产生了大量的“冗余”代码，还大 大干扰了主业务逻辑---转账。

**面向切面编程有什么好处**

- 减少重复代码的书写
- 专业业务的开发

**注意：面向切面编程只是面向对象的一种补充。**

**使用AOP减少重复代码，专注业务实现**

![image-20211113230022281](https://gitee.com/YunboCheng/imageBad/raw/master/image/image-20211113230022281.png)

### 3.3 AOP编程术语(重点)

#### **3.3.1 切面（Aspect）** 

- 切面泛指交叉业务逻辑。上例中的事务处理、日志处理就可以理解为切面。常用的切面 是通知（Advice）。实际就是对主业务逻辑的一种增强。切面就是表示功能的增强，就是一堆实现某个功能的代码，并且这个功能与业务没有关系。可以独立运行，时独立于业务存在的一段功能代码。常见的切面：日志、事务、统计信息、参数检查、权限验证等。

#### 3.3.2 连接点（JoinPoint）

- 连接点指可以被切面织入的具体方法，通常业务接口中的方法均为连接点。连接业务方法和切面的位置，就是某个业务接口中的业务方法。

#### 3.3.3 切入点（Pointcut）

- 切入点指声明的一个或多个连接点的集合。通过切入点指定一组方法。

**注意：被标记为 final 的方法是不能作为连接点与切入点的。因为最终的是不能被修改的，不 能被增强的。**

#### 3.3.4 目标对象（Target）

- 目 标 对 象 指 将 要 被 增 强 的 对 象 。 即 包 含 主 业 务 逻 辑 的 类 的 对 象 。 上 例 中 的 StudentServiceImpl 的对象若被增强，则该类称为目标类，该类对象称为目标对象。当然， 不被增强，也就无所谓目标不目标了。

#### 3.3.5 通知（Advice）

- 表示切面的执行时间，Advice 也叫增强。上例中的 MyInvocationHandler 就可以理 解为是一种通知。换个角度来说，通知定义了增强代码切入到目标代码的时间点，是目标方 法执行之前执行，还是之后执行等。通知类型不同，切入时间不同。

**切入点定义切入的位置，通知定义切入的时间。**



### 3.4 AOP实现框架

#### 3.4.1 一个切面的三个关键要素

- 切面的功能代码：代表切面干什么了
- 切面的执行位置 ，使用Pointcut表示切面执行的位置
- 切面的执行时间，使用Advice表示时间，在目标放之前，还是在目标方法之后。

#### 3.4.2 AOP技术的实现

**AOP是一个规范，是动态代理的一个规范化，一个标准。**

**AOP的技术实现框架的技术(两种)**

- spring : spring在内部实现了aop规范，可以完成aop的工作。spring主要在事务处理的时候使用aop。在实际开发中，很少使用spring的aop实现。因为spring的aop比较笨重。
- aspectJ : 一个开源的专门用来做aop的框架。spring框架中继承了aspectJ 框架，通过spring就可以使用aspectJ框架的功能。

### 3.5 AspectJ 框架

#### 3.5.1 AspectJ介绍

- 对于 AOP 这种编程思想，很多框架都进行了实现。Spring 就是其中之一，可以完成面向 切面编程。然而，AspectJ 也实现了 AOP 的功能，且其实现方式更为简捷，使用更为方便， 而且还支持注解式开发。所以，Spring 又将 AspectJ 的对于 AOP 的实现也引入到了自己的框 架中。

**在 Spring 中使用 AOP 开发时，一般使用 AspectJ 的实现方式。**

- AspectJ 是一个优秀面向切面的框架，它扩展了 Java 语言，提供了强大的切面实现。AspectJ 是Eclipse基金会的一个开源项目

![image-20211114143205314](https://gitee.com/YunboCheng/imageBad/raw/master/image/image-20211114143205314.png)

- a seamless aspect-oriented extension to the Javatm programming language（一种基于 Java 平台 的面向切面编程的语言）

- Java platform compatible（兼容 Java 平台，可以无缝扩展）
- easy to learn and use（易学易用）

#### 3.5.2 AspectJ实现aop的两种方式

- 使用xml的配置文件：配置全局事务
- 使用注解，实际开发中用到的就是注解的方式。aspectJ有5个注解。

#### 3.5.3 AspectJ框架的使用方式

- **切面的执行时间**：这个执行时间在规范中叫做Advice(通知、增强)。在aspectJ框架中使用注解表示。也可以使用xml配置文件中的标签表示。

  - @Before  （前置通知）
  - @AfterReturning  （后置通知）
  - @Around  （环绕通知）
  - @AfterThrowing （异常通知）
  - @After （最终通知）

  **以上的五个注解都是表示切面执行的时间。**

- **切面的执行位置：** 使用切入点表达式

#### 3.5.4 AspectJ的通知类型(了解)

AspectJ中常用的五种类型：

- 前置通知 （@Before）
- 后置通知 （@AfterReturning）
- 环绕通知   (@Around)
- 异常通知 （@AfterThrowing）
- 最终通知 （@After）

#### 3.5.5 切入点表达式语法(指定切入点的位置)

AspectJ 定义了专门的表达式用于指定切入点。表达式的原型是：

```java
// 参数之间使用空格分开
execution(modifiers-pattern? ret-type-pattern 
declaring-type-pattern?name-pattern(param-pattern)
throws-pattern?)

// 以上的4个部分，注意这个参数只写参数的类型吗，而不写参数的形参值。
execution(访问权限 方法返回值 包名.类名.方法名称(方法的参数类型) 异常类型)
```

**解释AspectJ参数信息**

- modifiers-pattern ：访问权限类型
- **ret-type-pattern ：** 返回值类型
- declaring-type-pattern ：包名类名
- **name-pattern(param-pattern) ：** 方法名(参数类型和参数个数)
- throws-pattern ： 抛出异常类型

**注意：? 代表可选的部分。也就是上面没有标粗的参数。**

**切入点表达式要匹配的对象就是目标方法的方法名。所以，execution 表达式中明显就 是方法的签名。**

#### 3.5.6 切入点表达式使用同配符

![](https://gitee.com/YunboCheng/imageBad/raw/master/image/20211114153823.png)

**在AspectJ可以使用通配符的目的 ：为了可以在配置文件中使用一个注解来获取到多个目标对象，然后给这些目标对象添加统一的功能或者补充其他的功能。**

**举列说明：（只有返回值类型以及方法名(参数)这两个参数不可以省略，所在在简化的切点表达中肯定存在这两个参数的信息）**

- **execution(public * *(..))** :  指定切入点的位置，任意类任意公共的方法。
- **execution(* set*(...)) : ** 指定切入点的位置，任意一个以 "set" 开始的方法。
- **execution(* com.yunbocheng.service.* .*(..)) :** 指定切入点的位置是service包中的任意类中的任意方法。
- **execution(* com.yunbocheng.service..* .*(..))：**指定切入点的位置是 service包或者子包中的任意类的任意方法。".."出现在类名中时，后面必须跟"*"，表示包、子包下的所有类。
- **execution(* *..service. * .*(..))：** 指定切入点的位置是：多级包下的service子包下所有类(接口)中所有方法为切入点。
- **execution(* *.service. * .*(..))：** 指定切入点的位置是：一级包下的service子包下所有类(接口)中所有方法为切入点。
- **execution(* joke(String,*)) ：** 指定所有的包中的 joke() 方法，该方法的第一个参数为String，第二个参数可以是任意类型。如：joke(String s1,String s2) 、joke(String s1,double d)
- **execution(* joke(String,..))：** 所有的 joke()方法，该方法第一个参数为 String，后面可以有任意个参数且 参数类型不限，如 joke(String s1)、joke(String s1,String s2)和 joke(String s1,double d2,String s3) 都是。

### 3.6 AspectJ 基于注解的 AOP 实现(掌握)

![](https://gitee.com/YunboCheng/imageBad/raw/master/image/20211115103431.png)



- 在 AspectJ 实现 AOP 时，要引入 AOP 的约束。配置文件中使用的 AOP 约束中的标签， 均是 AspectJ 框架使用的，而非 Spring 框架本身在实现 AOP 时使用的。
- **AspectJ 对于 AOP 的实现有注解和配置文件两种方式，常用是注解方式。**

**第一步：定义业务接口与实现类**

![image-20211115093838676](https://gitee.com/YunboCheng/imageBad/raw/master/image/image-20211115093838676.png)

**第二步：定义切面类**

类中定义了若干普通方法，将作为不同的通知方法，用来增强功能。

![](https://gitee.com/YunboCheng/imageBad/raw/master/image/20211115093933.png)

**第三步：在spring配置文件(applicationContext.xml)中声明目标对象以及切面类对象**

![](https://gitee.com/YunboCheng/imageBad/raw/master/image/20211115094040.png)

**第四步：在spring的配置文件(applicationContext.xml)注册 AspectJ 的自动代理**

- 在定义好切面 Aspect 后，需要通知 Spring 容器，让容器生成“目标类+ 切面”的代理 对象。这个代理是由容器自动生成的。只需要在 Spring 配置文件中注册一个基于 aspectj 的 自动代理生成器，其就会自动扫描到@Aspect 注解，并按通知类型与切入点，将其织入，并 生成代理。

![image-20211115094650017](https://gitee.com/YunboCheng/imageBad/raw/master/image/image-20211115094650017.png)

- 的底层是由 AnnotationAwareAspectJAutoProxyCreator 实现的。 从其类名就可看出，是基于 AspectJ 的注解适配自动代理生成器。
- **其工作原理是，通过扫描找到@Aspect 定义的切面类，再由切 面类根据切入点找到目标类的目标方法，再由通知类型找到切入的时间点。**

**第五步：测试类中使用目标对象的 id来进行定位**

![image-20211115094838802](https://gitee.com/YunboCheng/imageBad/raw/master/image/image-20211115094838802.png)

### 3.7 几种通知的使用方式

#### 3.7.1 [掌握]@Before 前置通知-方法有 JoinPoint 参数

- 在目标方法执行之前执行。被注解为前置通知的方法，可以包含一个 JoinPoint 类型参 数。该类型的对象本身就是切入点表达式。**通过该参数，可获取切入点表达式、方法签名、 目标对象等。** 

**不光前置通知的方法，可以包含一个 JoinPoint 类型参数，所有的通知方法均可包含该 参数。**

- **前置通知的核心代码，其余代码和以上代码一致。**

![](https://gitee.com/YunboCheng/imageBad/raw/master/image/20211115093415.png)

#### 3.7.2  [掌握]@AfterReturning 后置通知-注解有 returning 属性

- 在目标方法执行之后执行。**由于是目标方法之后执行，所以可以获取到目标方法的返回值。**该注解的 returning 属性就是用于指定接收方法返回值的变量名的。所以，被注解为后置通知的方法，除了可以包含 JoinPoint 参数外，还可以包含用于接收返回值的变量。该变量最好为 Object 类型，因为目标方法的返回值可能是任何类型。

![](https://gitee.com/YunboCheng/imageBad/raw/master/image/20211115095302.png)



#### 3.7.3 [掌握]@Around 环绕通知-增强方法有 ProceedingJoinPoint 参数

- 在目标方法执行之前之后执行。被注解为环绕增强的方法要有返回值，Object 类型。并 且方法可以包含一个 ProceedingJoinPoint 类型的参数。接口 ProceedingJoinPoint 其有一个 proceed()方法，用于执行目标方法。若目标方法有返回值，则该方法的返回值就是目标方法 的返回值。最后，环绕增强方法将其返回值返回。该增强方法实际是拦截了目标方法的执行。

![](https://gitee.com/YunboCheng/imageBad/raw/master/image/20211115095521.png)

#### 3.7.4 [了解]@AfterThrowing 异常通知-注解中有 throwing 属性

- 在目标方法抛出异常后执行。该注解的 throwing 属性用于指定所发生的异常类对象。 当然，被注解为异常通知的方法可以包含一个参数 Throwable，参数名称为 throwing 指定的 名称，表示发生的异常对象。

![](https://gitee.com/YunboCheng/imageBad/raw/master/image/20211115095821.png)

![](https://gitee.com/YunboCheng/imageBad/raw/master/image/20211115095837.png)

#### 3.7.5  [了解]@After 最终通知

- 无论目标方法是否抛出异常，该增强均会被执行。

![](https://gitee.com/YunboCheng/imageBad/raw/master/image/20211115095923.png)

## 第四章 Spring集成MyBatis

- Spring与MyBatis的整合需要借助于MyBatis的一个子项目MyBatis-Spring。通过MyBatis-Spring可以将MyBatis无缝的整合到Spring中，包括事务管理、Mapper生成、异常类型转化等，甚至是模板和支持工具类也有提供：SqlSessionTemplate

### 4.1 集成技术分析

- 将 MyBatis 与 Spring 进行整合，主要解决的问题就是将 SqlSessionFactory 对象交由 Spring 来管理。所以，该整合，只需要将 SqlSessionFactory 的对象生成器 SqlSessionFactoryBean 注 册在 Spring 容器中，再将其注入给 Dao 的实现类即可完成整合。
- **实现 Spring 与 MyBatis 的整合常用的方式：扫描的 Mapper 动态代理**
- Spring 像插线板一样，mybatis 框架是插头，可以容易的组合到一起。插线板 spring 插 上 mybatis，两个框架就是一个整体。

- 把MyBatis框架和spring集成在一起，向一个框架一样使用。**使用的是 IoC技术**，因为IoC能创建对象。可以把mybatis框架中的对象交给spring统一创建，开发人员从spring中获取对象。开发人员就不用同时面对两个或者多个框架了，就面对一个spring框架就可以了。

**mybatis使用步骤：**

1. 定义dao接口，StudentDao

2. 定义mapper文件 StudentDao.xml

3. 定义mybatis主配置文件 mybatis.xml

4. 创建web的代理对象，StudentDao  dao = sqlSession.getMapper(StudentDao.class);

   List< Student > students =  dao.selcetStudents();

要是用dao对象，需要使用getMapper()方法.

怎么能使用getMapper()方法，需要哪些条件

1. 获取SqlSession对象，需要使用SqlSessionFactory的openSession()方法。
2. 创建SqlSessionFactory对象。通过读取mybatis的主配置文件，能创建SqlSessionFactory对象。

**通过以上说明：我们需要让spring创建以下对象**

1. 创建独立的连接池类对象，使用阿里的druid连接池。
2. 创建SqlSessionFactory对象。
3. 创建出dao对象。

使用xml的bean标签进行创建。

**整合MyBatis的最核心的思想：使用spring的IoC核心技术，把mybatis框架中使用的对象交给spring统一创建和管理。spring是容器，存在项目中要使用到的各种对象。例如：Service对象、Dao对象，工具类等。**

### 4.2 继承技术实现

#### 4.2.1 MySQL 创建数据库 springdb,新建表 Student

![image-20211116153214673](https://gitee.com/YunboCheng/imageBad/raw/master/image/image-20211116153214673.png)



#### 4.2.2 maven 依赖 pom.xml

```xml
<dependency>
<groupId>junit</groupId>
<artifactId>junit</artifactId>
<version>4.11</version>
<scope>test</scope>
</dependency>
<dependency>
<groupId>org.springframework</groupId>
<artifactId>spring-context</artifactId>
<version>5.2.5.RELEASE</version>
</dependency>
<dependency>
<groupId>org.springframework</groupId>
<artifactId>spring-tx</artifactId>
<version>5.2.5.RELEASE</version>
</dependency>
<dependency>
<groupId>org.springframework</groupId>
<artifactId>spring-jdbc</artifactId>
<version>5.2.5.RELEASE</version>
</dependency>
<dependency>
<groupId>org.mybatis</groupId>
<artifactId>mybatis</artifactId>
<version>3.5.1</version>
</dependency>
<dependency>
<groupId>org.mybatis</groupId>
<artifactId>mybatis-spring</artifactId>
<version>1.3.1</version>
</dependency>
<dependency>
<groupId>mysql</groupId>
<artifactId>mysql-connector-java</artifactId>
<version>5.1.9</version>
</dependency>
<dependency>
<groupId>com.alibaba</groupId>
<artifactId>druid</artifactId>
<version>1.1.12</version>
</dependency>

```

#### 4.2.3 定义实体类 Student

![image-20211116153326777](https://gitee.com/YunboCheng/imageBad/raw/master/image/image-20211116153326777.png)

#### 4.2.4 定义 StudentDao 接口

![](https://gitee.com/YunboCheng/imageBad/raw/master/image/20211116153348.png)

#### 4.2.5  定义映射文件 mapper

- 在 Dao 接口的包中创建 MyBatis 的映射文件 mapper，命名与接口名相同，本例为StudentDao.xml。mapper 中的 namespace 取值也为 Dao 接口的全限定性名。

![](https://gitee.com/YunboCheng/imageBad/raw/master/image/20211116153435.png)

#### 4.2.6 定义 Service 接口和实现类

- 接口定义：

![image-20211116153511602](https://gitee.com/YunboCheng/imageBad/raw/master/image/image-20211116153511602.png)

- 实现类定义：

![image-20211116153539647](https://gitee.com/YunboCheng/imageBad/raw/master/image/image-20211116153539647.png)

#### 4.2.7 定义 MyBatis 主配置文件

- 在 src 下定义 MyBatis 的主配置文件，命名为 mybatis.xml。

**这里有两点需要注意：**

（1）主配置文件中不再需要数据源的配置了。因为数据源要交给 Spring 容器来管理了。 

（2）这里对 mapper 映射文件的注册，使用标签，即只需给出 mapper 映射文件 所在的包即可。因为 mapper 的名称与 Dao 接口名相同，可以使用这种简单注册方式。这种 方式的好处是，若有多个映射文件，这里的配置也是不用改变的。当然,也可使用原来的标签方式。

![](https://gitee.com/YunboCheng/imageBad/raw/master/image/20211116153655.png)

#### 4.2.8 修改 Spring 配置文件

#### **4.2.8.1 数据源的配置(掌握)**

- 使用 JDBC 模板，首先需要配置好数据源，数据源直接以 Bean 的形式配置在 Spring 配 置文件中。根据数据源的不同，其配置方式不同：

**(1) Druid 数据源 DruidDataSource**

- Druid 是阿里的开源数据库连接池。是 Java 语言中最好的数据库连接池。Druid 能 够提供强大的监控和扩展功能。Druid 与其他数据库连接池的最大区别是提供数据库的配置连接池。

**官方属性**

![](https://gitee.com/YunboCheng/imageBad/raw/master/image/20211116154045.png)

**spring配置文件**

![image-20211116154140441](https://gitee.com/YunboCheng/imageBad/raw/master/image/image-20211116154140441.png)

**(2)从属性文件读取数据库连接信息**

- 为了便于维护，可以将数据库连接信息写入到属性文件中，使 Spring 配置文件从中读取 数据。
- **属性文件名称自定义，但一般都是放在 src 下。**

![](https://gitee.com/YunboCheng/imageBad/raw/master/image/20211116154443.png)

- Spring 配置文件从属性文件中读取数据时，需要在的 value 属性中使用${ }， 将在属性文件中定义的 key 括起来，以引用指定属性的值。

![](https://gitee.com/YunboCheng/imageBad/raw/master/image/20211116154513.png)

- 该属性文件若要被 Spring 配置文件读取，其必须在配置文件中进行注册。使用 标签。

![](https://gitee.com/YunboCheng/imageBad/raw/master/image/20211116154613.png)



#### **4.2.8.2  注册 SqlSessionFactoryBean**

![](https://gitee.com/YunboCheng/imageBad/raw/master/image/20211116154718.png)

#### **4.2.8.3   定义 Mapper 扫描配置器 MapperScannerConfigurer**

- Mapper 扫描配置器 MapperScannerConfigurer 会自动生成指定的基本包中 mapper 的代理对象。该 Bean 无需设置 id 属性。**value使用分号或逗号设置多个包。**

![](https://gitee.com/YunboCheng/imageBad/raw/master/image/20211116155009.png)

#### 4.2.9 向 Service 注入接口名

- 向 Service 注入 Mapper 代理对象时需要注意，由于通过 Mapper 扫描配置器 MapperScannerConfigurer 生成的 Mapper 代理对象没有名称，所以在向 Service 注入 Mapper 代理时，无法通过名称注入。但可通过接口的简单类名注入，因为生成的是这个 Dao 接口 的对象。
- 重点：以前我们需要自己手动创建一个引用类型的id值，然后赋值给引用该类型的bean中的ref属性。但是使用spring之后，不用我们自己去手动赋给引用类型的bean的id值，此时使用的spring中的MapperScannerConfigurer为我们自动的通过反射机制创建的出的接口的实现类对象，且这个实现类对象的类名是接口名称的首字母小写，也就是id值。

![image-20211116163809779](https://gitee.com/YunboCheng/imageBad/raw/master/image/image-20211116163809779.png)

#### 4.2.10 Spring 配置文件全部配置

![image-20211116163847141](https://gitee.com/YunboCheng/imageBad/raw/master/image/image-20211116163847141.png)



## 第五章 Spring的事务

### 5.1 针对事务的分析

什么是事务：

- 在mysql中提出了关于事务的一词。事务是指一组sql语句的集合，集合中有多条sql语句。可能是delete、update、insert等语句。我们希望这些sql语句同时成功或者失败才可以完成相应的功能。**比如转账系统。**这些sql语句的执行是一致的，作为一个整体执行。

在什么时候使用事务

- 当项目中实现某个功能需要多个表的时候，或者是多个sql语句的insert、update、delete。需要保证这些语句都是同时成功或者失败的时候才能完成某个功能。不可以是单独的某个sql语句执行成功那么功能就实现的。

在Java代码中写程序，控制事务，此时事务应该放到哪里？

- Service类的业务方法上，因为在Service类中的某个功能(方法)可能需要多个Dao中的方法才可以完成这个业务，而dao是执行sql语句的，此时就可以把这些dao调用的方法看做是一个业务

通常使用JDBC访问数据库、mybatis访问数据库是怎么处理业务的。

- JDBC访问数据库：处理事务 (Connection conn ;  conn.commit(); conn.rollback();)
- mybatis访问数据库：处理事务（sqlSession.commit() ; sqlSession.rollback(); ）

- hibernate访问数据库 ：处理事务（Session.commit() ;  Session.rollback();）

以上处理业务有什么不足

1. 不同的数据库需要不同的事务处理对象，方法不同，需要了解不同数据库事务的技术的原理
2. 掌握多种数据库中事务处理的业务逻辑。什么时候提交事务，什么时候回滚事务。
3. 处理事务的多中国方法不同。

解决事务处理的不足之处

- 使用spring框架统一解决事务处理

### 5.2 Spring处理事务的统一方式

- 事务原本是数据库中的概念，在 Dao 层。但一般情况下，需要将事务提升到业务层， 即 Service 层。这样做是为了能够使用事务的特性来管理具体的业务。

在 Spring 中通常可以通过以下两种方式来实现对事务的管理：

1. 使用 Spring 的事务注解管理事务
2. 使用 AspectJ 的 AOP 配置管理事务 

**spring提供了一种统一处理事务的模型，能使用统一步骤，方式完成多种不同数据库访问技术的事务处理。**

- 使用spring的事务处理机制，可以完成mybatis访问数据库的事务处理。
- 使用spring的事务处理机制，可以完成hibernate访问数据库的事务处理。

![image-20211116201918300](https://gitee.com/YunboCheng/imageBad/raw/master/image/image-20211116201918300.png)

![](https://gitee.com/YunboCheng/imageBad/raw/master/image/20211116203146.png)

![image-20211116210252534](https://gitee.com/YunboCheng/imageBad/raw/master/image/image-20211116210252534.png)

### 5.3 Spring事务管理API

- Spring 的事务管理，主要用到两个事务相关的接口。

#### （1） 事务管理器接口(重点)

- **事务管理器是 PlatformTransactionManager 接口对象。**其主要用于完成事务的提交、回 滚，及获取事务的状态信息。

![](https://gitee.com/YunboCheng/imageBad/raw/master/image/20211116210506.png)

**事务管理器是 PlatformTransactionManager 接口对象。常用的两个实现类：**

- **DataSourceTransactionManager：**使用 JDBC 或 MyBatis 进行数据库操作时使用。

-  **HibernateTransactionManager：**使用 Hibernate 进行持久化数据时使用。

**Spring的回滚方式(理解)**

- Spring 事务的默认回滚方式是：**发生运行时异常和 error 时回滚，发生受查(编译)异常时提交。**不过，对于受查异常，程序员也可以手工设置其回滚方式。

**回顾错误与异常**

![](https://gitee.com/YunboCheng/imageBad/raw/master/image/20211116210912.png)

- Throwable 类是 Java 语言中所有错误或异常的超类。只有当对象是此类(或其子类之一) 的实例时，才能通过 Java 虚拟机或者 Java 的 throw 语句抛出。
- Error 是程序在运行过程中出现的无法处理的错误，比如 OutOfMemoryError、 ThreadDeath、NoSuchMethodError 等。当这些错误发生时，程序是无法处理（捕获或抛出） 的，JVM 一般会终止线程。
- 程序在编译和运行时出现的另一类错误称之为异常，它是 JVM 通知程序员的一种方式。 通过这种方式，让程序员知道已经或可能出现错误，要求程序员对其进行处理。

**异常分为运行时异常与受查异常。**

- 运行时异常，是 RuntimeException 类或其子类，即只有在运行时才出现的异常。如， NullPointerException、ArrayIndexOutOfBoundsException、IllegalArgumentException 等均属于 运行时异常。这些异常由 JVM 抛出，在编译时不要求必须处理（捕获或抛出）。但，只要代 码编写足够仔细，程序足够健壮，运行时异常是可以避免的。
- 受查异常，也叫编译时异常，即在代码编写时要求必须捕获或抛出的异常，若不处理， 则无法通过编译。如 SQLException，ClassNotFoundException，IOException 等都属于受查异常。
- RuntimeException 及其子类以外的异常，均属于受查异常。当然，用户自定义的 Exception 的子类，即用户自定义的异常也属受查异常。程序员在定义异常时，只要未明确声明定义的 为 RuntimeException 的子类，那么定义的就是受查异常。

#### （2） 事务定义接口

- 事务定义接口 TransactionDefinition 中定义了事务描述相关的三类常量：**事务隔离级别、 事务传播行为、事务默认超时时限**，及对它们的操作

![](https://gitee.com/YunboCheng/imageBad/raw/master/image/20211116211111.png)

**定义了五个事务隔离级别常量(掌握)**

**这些常量均是以 ISOLATION_开头。即形如 ISOLATION_XXX。**

➢ DEFAULT：采用 DB 默认的事务隔离级别。MySql 的默认为 REPEATABLE_READ； Oracle 默认为 READ_COMMITTED。 

➢ READ_UNCOMMITTED：读未提交。未解决任何并发问题。

 ➢ READ_COMMITTED：读已提交。解决脏读，存在不可重复读与幻读。 

➢ REPEATABLE_READ：可重复读。解决脏读、不可重复读，存在幻读 。

➢ SERIALIZABLE：串行化。不存在并发问题。



**定义了七个事务传播行为常量(掌握)**

- 所谓事务传播行为是指，处于不同事务中的方法在相互调用时，执行期间事务的维护情 况。如，A 事务中的方法 doSome()调用 B 事务中的方法 doOther()，在调用执行期间事务的 维护情况，就称为事务传播行为。事务传播行为是加在方法上的。

事务传播行为常量都是以 PROPAGATION_ 开头，形如 PROPAGATION_XXX。

- **PROPAGATION_REQUIRED** 

- **PROPAGATION_REQUIRES_NEW** 
- **PROPAGATION_SUPPORTS**

重点掌握前三个

-  PROPAGATION_MANDATORY  
- PROPAGATION_NESTED 
- PROPAGATION_NEVER 
- PROPAGATION_NOT_SUPPORTED

**PROPAGATION_REQUIRED：**

- 指定的方法必须在事务内执行。若当前存在事务，就加入到当前事务中；若当前没有事 务，则创建一个新事务。这种传播行为是最常见的选择，也是 Spring 默认的事务传播行为。
- 如该传播行为加在 doOther()方法上。若 doSome()方法在调用 doOther()方法时就是在事 务内运行的，则 doOther()方法的执行也加入到该事务内执行。若 doSome()方法在调用 doOther()方法时没有在事务内执行，则 doOther()方法会创建一个事务，并在其中执行。

![](https://gitee.com/YunboCheng/imageBad/raw/master/image/20211116213005.png)

**PROPAGATION_SUPPORTS**

- 指定的方法支持当前事务，但若当前没有事务，也可以以非事务方式执行。

![image-20211116213029151](https://gitee.com/YunboCheng/imageBad/raw/master/image/image-20211116213029151.png)

**PROPAGATION_REQUIRES_NEW**

- 总是新建一个事务，若当前存在事务，就将当前事务挂起，直到新事务执行完毕

![image-20211116213054881](C:/Users/YunboCheng/AppData/Roaming/Typora/typora-user-images/image-20211116213054881.png)

**定义了默认事务超时时限**

- 常量 TIMEOUT_DEFAULT 定义了事务底层默认的超时时限，sql 语句的执行时长。
- 注意，事务的超时时限起作用的条件比较多，且超时的时间计算点较复杂。所以，该 值一般就使用默认值即可。

![](https://gitee.com/YunboCheng/imageBad/raw/master/image/20211116215806.png)

**总结spring的事务**

1. 管理事务的是：事务管理和他的实现类

2. spring的事务的一个统一模型

   1）指定要使用的事务管理器实现类，使用<bean>

   2）指定哪些类，哪些方法需要加入事务的功能。

   3） 指定方法需要的隔离级别，传播行为，超时等

3. 我们需要告诉spring，项目中类信息、方法的名称、方法的事务传播行为。

#### 5.4 使用 Spring 的事务注解管理事务(掌握)

通过@Transactional 注解方式，可将事务织入到相应 public 方法中，实现事务管理。

需要注意的是，@Transactional 若用在方法上，只能用于 public 方法上。对于其他非 public 方法，如果加上了注解@Transactional，虽然 Spring 不会报错，但不会将指定事务织入到该 方法中。因为 Spring 会忽略掉所有非 public 方法上的@Transaction 注解。

**若@Transaction 注解在类上，则表示该类上所有的方法均将在执行时织入事务。**

**若@Transaction 注解在方法上，则表示该方法只能是public修饰的才可以将在执行时织入事务。**

@Transactional 的所有可选属性如下所示：

➢ **propagation：**用于设置事务传播属性。该属性类型为 Propagation 枚举，默认值为	Propagation.REQUIRED。

➢ **isolation：**用于设置事务的隔离级别。该属性类型为 Isolation 枚举，默认值为 Isolation.DEFAULT。

 ➢ **readOnly：**用于设置该方法对数据库的操作是否是只读的。该属性为 boolean，默认值 为 false。 

➢ **timeout：**用于设置本操作与数据库连接的超时时限。单位为秒，类型为 int，默认值为 -1，即没有时限。

 ➢ **rollbackFor：**指定需要回滚的异常类。类型为 Class[]，默认值为空数组。当然，若只有 一个异常类时，可以不使用数组。

 ➢ **rollbackForClassName：**指定需要回滚的异常类类名。类型为 String[]，默认值为空数组。 当然，若只有一个异常类时，可以不使用数组。 

➢ **noRollbackFor：**指定不需要回滚的异常类。类型为 Class[]，默认值为空数组。当然，若 只有一个异常类时，可以不使用数组。 

➢ **noRollbackForClassName：**指定不需要回滚的异常类类名。类型为 String[]，默认值为空 数组。当然，若只有一个异常类时，可以不使用数组。

