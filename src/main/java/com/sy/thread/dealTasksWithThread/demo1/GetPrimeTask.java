package com.sy.thread.dealTasksWithThread.demo1;

/**
 * @Author:peiliang
 * @Description:
 * @Date:2019/11/19 21:46
 * @Modified By:
 * @Version: 1.0
 */

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class GetPrimeTask implements Callable<List<Long>> {

    private Long start;
    private Long end;

    public GetPrimeTask(Long start, Long end) {
        this.start = start;
        this.end = end;
    }

    public List<Long> call() throws Exception {
        // TODO Auto-generated method stub
        List<Long> primeNumberList = new ArrayList<Long>();

        for (Long i = start; i <= end; i++) {
            if (Math.isPrimeNumber(i)) {
                primeNumberList.add(i);
            }
        }

        return primeNumberList;
    }

}