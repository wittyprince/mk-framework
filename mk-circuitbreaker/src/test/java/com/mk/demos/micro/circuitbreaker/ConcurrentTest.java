//package com.mk.demos.micro.circuitbreaker;
//
//import lombok.extern.slf4j.Slf4j;
//import org.junit.jupiter.api.RepeatedTest;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.web.client.RestTemplate;
//
//import java.util.HashMap;
//import java.util.concurrent.ExecutorService;
//import java.util.concurrent.Executors;
//
///**
// * 模拟并发请求 test
// */
//@Slf4j
//@SpringBootTest
//public class ConcurrentTest {
//
//    @Autowired(required = false)
//    private RestTemplate restTemplate;
//
//    private final String url = "http://localhost:8080/payment/abc";
//
//
//    @Test
//    @RepeatedTest(10)
//    public void concurrentTest() {
////        Thread t1 = new Thread(new Runnable() {
////            @Override
////            public void run() {
////                Object forObject = restTemplate.getForObject(url, Object.class, new HashMap<>());
////                log.info("forObject: [{}]", forObject);
////            }
////        });
//////        t1.start();
//
//        try {
//            for (int i=0; i<10; i++) {
//                Thread t = new Thread(new MyThread(String.valueOf(i)));
//                t.start();
//                t.join();
//            }
//        } catch (Exception e) {
//            log.error(e.getMessage());
//        }
//
//
//        ExecutorService executorService = Executors.newFixedThreadPool(10);
//
//
//    }
//
//    class MyThread implements Runnable{
//        private String name;
//        public MyThread() {
//        }
//
//        public MyThread(String name) {
//            this.name = name;
//        }
//
//        @Override
//        public void run() {
//            Object forObject = restTemplate.getForObject(url, Object.class, new HashMap<>());
//            log.info("[{}]===forObject: [{}]", name, forObject);
//        }
//    }
//}
