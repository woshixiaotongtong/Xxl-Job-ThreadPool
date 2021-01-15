package com.dj.lgnjob.task;

import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.XxlJob;
import com.xxl.job.core.util.ShardingUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.Executor;


@Component
public class DemoTask extends IJobHandler {


    private Logger logger = LoggerFactory.getLogger(DemoTask.class);

    @Autowired
    private Executor taskExecutor;

    @XxlJob(value = "test-task")
    @Override
    public ReturnT<String> execute(String s) {

        // XxlJob节点上下文信息
        ShardingUtil.ShardingVO shardingVo = ShardingUtil.getShardingVo();

        //XxlJob节点总数
        int total = shardingVo.getTotal();
        // XxlJob节点片号
        int index = shardingVo.getIndex();


        // 如果是集群化的微服务且业务需要操作到数据库并进行数据隔离;
        // 可以这样查询数据   List<Object>   = (sql =>  id % total = index)



        // 开启多线程处理数据
        for (int i = 0; i < 10; i++) {

            taskExecutor.execute(() -> {
                printLogger(total,index);
            });
        }


        logger.info("执行完成");
        return SUCCESS;
    }

    public void printLogger(int total, int index) {
        for (int i = 0; i < 5; i++) {
            logger.info("ThreadName{},分片总数{},分片号{}", Thread.currentThread().getName(), total, index);
        }
    }
}
