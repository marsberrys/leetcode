package solutions.s1114;

import base.ListNode;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;


/**
 * 1114. 按序打印
 * @Author weixun
 * @Date 2021-10-10
 * @See https://leetcode-cn.com/problems/print-in-order/
 */
public class Solution {

    class Foo {

        private AtomicInteger flag = new AtomicInteger(0);

        public Foo() {

        }

        public void first(Runnable printFirst) throws InterruptedException {
            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            flag.incrementAndGet();
        }

        public void seconTd(Runnable printSecond) throws InterruptedException {
            while(flag.get() != 1) {
            }
            // printSecond.run() outputs "second". Do not change or remove this line.
            printSecond.run();
            flag.incrementAndGet();
        }

        public void third(Runnable printThird) throws InterruptedException {
            while(flag.get() != 2) {
            }
            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();
            flag.incrementAndGet();
        }
    }

    @Test
    public void test() {



        System.out.println("ok");
    }
}
