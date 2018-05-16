线程启动方式:三种
继承Thread类:UserTread extends  Thread
实现Runable接口:UserRunnable implements  Runnable
实现callable接口(泛型可以填Object类,具有返回值):UserCallable implements Callable<T>

线程中断的方式:
stop已经废弃
现在使用interrupt方法,仅在线程中断位置添加中断标志位,设置为true,java中会安全中断多线程
如果run方法总抛出InterruptException异常,并不会正常添加中断标志位,flag依然是false,所以不会进行中断操作
如果希望正常进行中断,则在异常处理中新增方法,将中断标志位手动设置为true ( interrupt(); )

在外部手动设置中断标志位的时候,如果发生阻塞,线程不会判断当前线程是否需要中断,而是一直阻塞在哪里,
建议:两种方法结合使用



线程的状态:


                                    阻塞状态

                           sleep时间到         sleep

新建线程 -> start -> 就绪状态 ->join获取时间片 -> 运行状态 ->run结束或者手动终止 -> 死亡状态

                            notify              wait

                                    阻塞状态

Yield方法:让出当前线程的cpu时间, 让cpu重新选择线程处理(当然,os可以再次选择这个线程继续执行)
Join方法:让当前线程执行完成以后,调用join方法的线程来接着执行(面试题如何让线程有顺序的输出)


线程的优先级:
在不同的虚拟机和操作系统是有差异的,优先级的设置仅仅是确定大体上的执行方向,并不确定


守护线程:
例如java总的GC 垃圾回收线程
