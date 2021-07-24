package com.qooapp.kotlin.spring.controller

import com.qooapp.kotlin.spring.concurrent.AsyncService
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.text.SimpleDateFormat
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.util.*
import java.util.concurrent.*
import java.util.concurrent.atomic.AtomicInteger
import java.util.concurrent.locks.Lock
import java.util.concurrent.locks.ReadWriteLock
import java.util.concurrent.locks.ReentrantLock
import java.util.concurrent.locks.ReentrantReadWriteLock


@Api(tags = ["并发案例"])
@RequestMapping("/concurrent")
@RestController
class ConcurrentController {
    companion object {

        /**
         * 每次运行的线程数
         */
        private const val ROUND_COUNT = 5

        /**
         * 每次运行的线程数
         */
        private const val THREAD_COUNT = 5

        /**
         * 线程内执行的操作数
         */
        private const val PLUS_COUNT = 1000

        val RANDOM: Random = Random()
    }

    var count = 0


    @ApiOperation("并发问题-1")
    @GetMapping("/problem-1")
    @Throws(InterruptedException::class)
    fun concurrentProblem1(): Any? {
        val result: MutableMap<String, Any> = HashMap()
        val start = System.currentTimeMillis()
        for (round in 1..ROUND_COUNT) {
            //创建一个固定数量的线程池
            val executorService = Executors.newFixedThreadPool(THREAD_COUNT)

            //以线程池容量做循环,给每个线程安排一个任务
            for (i in 0 until THREAD_COUNT) {

                //使用拉姆达表达式指定执行的任务.  此处拉姆达实现的是 函数式接口 java.util.concurrent.Executor
                executorService.execute {
                    for (j in 0 until PLUS_COUNT) {
                        count++
                        try {
                            Thread.sleep(1L)
                        } catch (e: InterruptedException) {
                            //这个异常发生在其他进程想要关闭本进程.一般情况下这里做资源回收和 return.
                            //不建议无视此异常.因为关闭不了可能会被强行关闭,导致连资源回收的机会都没有.
                            e.printStackTrace()
                            return@execute
                        }
                    }
                }
            }
            //标注线程池为关闭.线程池不会再接收新的任务.在所有任务完成后关闭
            executorService.shutdown()
            //等待所有进程结束. 最多等待10分钟.
            executorService.awaitTermination(10, TimeUnit.MINUTES)
            result["round-$round"] = count
            count = 0
        }
        result["正确结果应该是"] = THREAD_COUNT * PLUS_COUNT
        result["共耗时(ms)"] = System.currentTimeMillis() - start
        return result
    }

    @Synchronized
    private fun addCount() {
        count++
    }

    //可重入锁, 参数可以传递一个boolean 表示是否公平, 是一种锁竞争情况下的分配方案.
    var reentrantLock: Lock = ReentrantLock()

    //读写分开的锁
    var readWriteLock: ReadWriteLock = ReentrantReadWriteLock()

    @ApiOperation("使用锁")
    @GetMapping("/lock")
    @Throws(InterruptedException::class)
    fun lock(): Any? {
        val result: MutableMap<String, Any> = HashMap()
        val start = System.currentTimeMillis()
        for (round in 1..ROUND_COUNT) {
            //创建一个固定数量的线程池
            val executorService = Executors.newFixedThreadPool(THREAD_COUNT)

            //以线程池容量做循环,给每个线程安排一个任务
            for (i in 0 until THREAD_COUNT) {

                //使用拉姆达表达式指定执行的任务.  此处拉姆达实现的是 函数式接口 java.util.concurrent.Executor
                executorService.execute {
                    for (j in 0 until PLUS_COUNT) {

                        //使用同步块
//                        addCount()

//                        try {
//                            readWriteLock.writeLock().lock()
//                            // 只读操作可以只用读锁 readWriteLock.readLock().lock();
//                            // 释放只读锁 readWriteLock.readLock().unlock();
//                            //锁住数据后的操作请在try块中进行
//                            count++
//                        } finally {
//                            // 释放操作请在 finally 块中进行,因为 finally可以保证 不管是否发生异常都会执行.
//                            // 注意:finally块中不允许使用return
//                            readWriteLock.writeLock().unlock()
//                        }


                        try {
                            reentrantLock.lock()
                            //锁住数据后的操作请在try块中进行
                            count++
                        } finally {
                            // 释放操作请在 finally 块中进行,因为 finally可以保证 不管是否发生异常都会执行.
                            // 注意:finally块中不允许使用return
                            reentrantLock.unlock()
                        }
//                        try {
//                            Thread.sleep(1L)
//                        } catch (e: InterruptedException) {
//                            //这个异常发生在其他进程想要关闭本进程.一般情况下这里做资源回收和 return.
//                            //不建议无视此异常.因为关闭不了可能会被强行关闭,导致连资源回收的机会都没有.
//                            e.printStackTrace()
//                            return@execute
//                        }
                    }
                }
            }
            //标注线程池为关闭.线程池不会再接收新的任务.在所有任务完成后关闭
            executorService.shutdown()
            //等待所有进程结束. 最多等待10分钟.
            executorService.awaitTermination(10, TimeUnit.MINUTES)
            result["round-$round"] = count
            count = 0
        }
        result["正确结果应该是"] = THREAD_COUNT * PLUS_COUNT
        result["共耗时(ms)"] = System.currentTimeMillis() - start
        return result
    }

    var atomicInteger = AtomicInteger(0)

    @ApiOperation("并发演示-1")
    @GetMapping("/demo-1")
    @Throws(InterruptedException::class)
    fun concurrentDemo1(): Any? {
        val result: MutableMap<String, Any> = HashMap()
        val start = System.currentTimeMillis()
        for (round in 1..ROUND_COUNT) {
            //创建一个固定数量的线程池
            val executorService = Executors.newFixedThreadPool(THREAD_COUNT)

            //以线程池容量做循环,给每个线程安排一个任务
            for (i in 0 until THREAD_COUNT) {

                //使用拉姆达表达式指定执行的任务.  此处拉姆达实现的是 函数式接口 java.util.concurrent.Executor
                executorService.execute {
                    for (j in 0 until PLUS_COUNT) {
                        atomicInteger.incrementAndGet()
                        try {
                            Thread.sleep(1L)
                        } catch (e: InterruptedException) {
                            //这个异常发生在其他进程想要关闭本进程.一般情况下这里做资源回收和 return.
                            //不建议无视此异常.因为关闭不了可能会被强行关闭,导致连资源回收的机会都没有.
                            e.printStackTrace()
                            return@execute
                        }
                    }
                }
            }
            //标注线程池为关闭.线程池不会再接收新的任务.在所有任务完成后关闭
            executorService.shutdown()
            //等待所有进程结束. 最多等待10分钟.
            executorService.awaitTermination(10, TimeUnit.MINUTES)
            result["round-$round"] = atomicInteger.get()
        }
        result["正确结果应该是"] = THREAD_COUNT * PLUS_COUNT * ROUND_COUNT
        result["共耗时(ms)"] = System.currentTimeMillis() - start
        return result
    }

    //这个类线程不安全.请注意不要跨进程共享.
    var sdf = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")

    @ApiOperation("线程非安全")
    @GetMapping("/thread-unsafe")
    @Throws(InterruptedException::class)
    fun threadUnsafe(): Any? {
        val result: MutableMap<String, Any> = HashMap()

        //创建一个固定数量的线程池
        val executorService = Executors.newFixedThreadPool(THREAD_COUNT)

        //以线程池容量做循环,给每个线程安排一个任务
        //为了方便查看结果.降低了执行次数
        var i = 0
        while (i < THREAD_COUNT) {


            //使用拉姆达表达式指定执行的任务.  此处拉姆达实现的是 函数式接口 java.util.concurrent.Executor
            executorService.execute {
                var j = 0
                while (j < PLUS_COUNT) {


                    //java日期处理一般使用 Calendar 类,也可以使用第三方工具类
                    val instance = Calendar.getInstance()
                    //设置一个随机值
                    instance.timeInMillis = RANDOM.nextInt(126801377) * 1000 + 1426801377000L
                    val date = instance.time
                    val sdfResult = sdf.format(date)

                    //使用
                    val innerSdf = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
                    val realResult = innerSdf.format(date)
                    result[realResult] = sdfResult
                    try {
                        Thread.sleep(1L)
                    } catch (e: InterruptedException) {
                        //这个异常发生在其他进程想要关闭本进程.一般情况下这里做资源回收和 return.
                        //不建议无视此异常.因为关闭不了可能会被强行关闭,导致连资源回收的机会都没有.
                        e.printStackTrace()
                        return@execute
                    }
                    j += 50
                }
            }
            i += 2
        }
        //标注线程池为关闭.线程池不会再接收新的任务.在所有任务完成后关闭
        executorService.shutdown()
        //等待所有进程结束. 最多等待10分钟.
        executorService.awaitTermination(10, TimeUnit.MINUTES)
        return result
    }

    //这个类线程安全
    var dtf: DateTimeFormatter = DateTimeFormatter
        .ofPattern("yyyy-MM-dd HH:mm:ss")
        .withZone(ZoneId.systemDefault())

    @ApiOperation("线程安全")
    @GetMapping("/thread-safe")
    @Throws(InterruptedException::class)
    fun threadSafe(): Any? {
        val result: MutableMap<String, Any> = HashMap()

        //创建一个固定数量的线程池
        val executorService = Executors.newFixedThreadPool(THREAD_COUNT)

        //为了方便查看结果.降低了执行次数
        var i = 0
        while (i < THREAD_COUNT) {

            //使用拉姆达表达式指定执行的任务.  此处拉姆达实现的是 函数式接口 java.util.concurrent.Executor
            executorService.execute {
                var j = 0
                while (j < PLUS_COUNT) {

                    //java日期处理一般使用 Calendar 类,也可以使用第三方工具类
                    val instance = Calendar.getInstance()
                    //设置一个随机值
                    instance.timeInMillis = RANDOM.nextInt(126801377) * 1000 + 1426801377000L
                    val date = instance.time
                    val sdfResult = dtf.format(date.toInstant())

                    //使用
                    val innerSdf = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
                    val realResult = innerSdf.format(date)
                    result[realResult] = sdfResult
                    try {
                        Thread.sleep(1L)
                    } catch (e: InterruptedException) {
                        //这个异常发生在其他进程想要关闭本进程.一般情况下这里做资源回收和 return.
                        //不建议无视此异常.因为关闭不了可能会被强行关闭,导致连资源回收的机会都没有.
                        e.printStackTrace()
                        return@execute
                    }
                    j += 50
                }
            }
            i += 2
        }

        //标注线程池为关闭.线程池不会再接收新的任务.在所有任务完成后关闭
        executorService.shutdown()
        //等待所有进程结束. 最多等待10分钟.
        executorService.awaitTermination(10, TimeUnit.MINUTES)
        return result
    }

    @Autowired
    lateinit var asyncMethod: AsyncService

    @ApiOperation("调用异步方法")
    @GetMapping("/call-async")
    @Throws(
        InterruptedException::class,
        TimeoutException::class,
        ExecutionException::class
    )
    fun callAsync(): Any? {
        val result: MutableMap<String, Any> = HashMap()
        val start = System.currentTimeMillis()
        val resultList: MutableList<Future<Any>> = ArrayList<Future<Any>>()

        //调用多次异步方法
        for (i in 0 until THREAD_COUNT) {
            val objectFuture: Future<Any> = asyncMethod.asyncMethod(i, i * 3)
            resultList.add(objectFuture)
        }

        //模拟其他耗时操作
        Thread.sleep(2000)

        //请求获取异步方法的返回值.会阻塞当前线程,如果超时将抛出异常.
        for (i in resultList.indices) {
            result["call-$i"] = resultList[i].get(1, TimeUnit.MINUTES)
        }
        result["共耗时(ms)"] = System.currentTimeMillis() - start
        return result
    }

    @ApiOperation("快速失败机制")
    @GetMapping("/fail-fast")
    fun failFast(): Any? {
        val result: MutableMap<String, Any> = HashMap()
        val list: MutableList<String> = ArrayList()
        for (i in 0..9) {
            list.add(i.toString())
        }
//        for (s in list) {
//            if ("2" == s) {
//                list.remove(s)
//            }
//        }
        val iterator = list.iterator()
        while (iterator.hasNext()) {
            val next = iterator.next()
            if ("2" == next) {
                iterator.remove();
            }
        }
        result["list size"] = list.size
        return result
    }


}