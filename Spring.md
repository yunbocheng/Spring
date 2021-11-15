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

- 通知表示切面的执行时间，Advice 也叫增强。上例中的 MyInvocationHandler 就可以理 解为是一种通知。换个角度来说，通知定义了增强代码切入到目标代码的时间点，是目标方 法执行之前执行，还是之后执行等。通知类型不同，切入时间不同。

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

- **execution(public * *(..))** :  指定切入点的位置，任意公共的方法。
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

