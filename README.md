####  Quartz
+ Job：具体需要执行的任务
+ JobDetail：该任务的信息，包括具体执行的任务以及其他一些相关的信息
+ Trigger：触发器
+ Scheduler：任务调度器
+ Misfire：错过的，指本来应该被执行但是实际没有被执行的任务调度

#### 最简单的 Quartz 定时任务
1. 创建 Job。
2. 创建 JobDetailFactoryBean。顾名思义，可以用于生成 JobDetail 。
3. 创建 Trigger。作用：配置定时时间。
4. 创建 SchedulerFactoryBean。作用：启动定时任务。

<http://www.quartz-scheduler.org/documentation/quartz-2.x/configuration/ConfigJDBCJobStoreClustering.html>

Spring+quartz 实现动态管理任务
<http://itindex.net/detail/53315-spring-quartz-%E7%AE%A1%E7%90%86>

Quartz集群中的每个节点是一个独立的Quartz应用，它又管理着其他的节点。该集群需要分别对每个节点分别启动或停止，不像应用服务器的集群，独立的Quartz节点并不与另一个节点或是管理节点通信。Quartz应用是通过数据库表来感知到另一应用。只有使用持久的JobStore才能完成Quqrtz集群。

---
org.quartz.jobStore.class属性为JobStoreTX，将任务持久化到数据中。
因为集群中节点依赖于数据库来传播Scheduler实例的状态，你只能在使用JDBC JobStore时应用Quartz集群。

org.quartz.jobStore.isClustered属性为true，通知Scheduler实例要它参与到一个集群当中。

org.quartz.jobStore.clusterCheckinInterval属性定义了Scheduler实例检入到数据库中的频率(单位：毫秒)。
Scheduler检查是否其他的实例到了它们应当检入的时候未检入；这能指出一个失败的Scheduler实例，
且当前 Scheduler会以此来接管任何执行失败并可恢复的Job。通过检入操作，Scheduler 也会更新自身的状态记录。
clusterChedkinInterval越小，Scheduler节点检查失败的Scheduler实例就越频繁。默认值是 15000 (即15 秒)。


Quartz应用与集群原理分析:<http://tech.meituan.com/mt-crm-quartz.html>

分布式调度QUARTZ+SPRING:<http://www.blogjava.net/paulwong/archive/2014/11/14/420104.html>

<http://www.jianshu.com/p/14f86c6efe22>


quartz 在集群中的任务切换??


---

Elastic-Job - 分布式定时任务框架<https://my.oschina.net/u/719192/blog/506062>


