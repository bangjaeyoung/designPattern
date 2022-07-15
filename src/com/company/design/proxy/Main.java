package com.company.design.proxy;

import com.company.design.aop.AopBrowser;
import java.util.concurrent.atomic.AtomicLong;

public class Main {

    public static void main(String[] args) {

//        Browser browser = new Browser("www.naver.com");
//        browser.show();
//        browser.show();
//        browser.show();
//        browser.show();
//        browser.show();
//        // 매번 로딩이 일어남

//        IBrowser browser = new BrowserProxy("www.naver.com");
//        browser.show();
//        browser.show();
//        browser.show();
//        browser.show();
//        browser.show();
//        // 처음만 로딩을 하고 그 다음부터는 cache된 결과만 나옴


        //AopBrowser
        AtomicLong start = new AtomicLong();
        AtomicLong end = new AtomicLong();

        IBrowser aopBrowser = new AopBrowser("www.naver.com",
                ()->{
                    System.out.println("before");
                    start.set(System.currentTimeMillis());
                },
                ()-> {
                    long now = System.currentTimeMillis();
                    end.set(now - start.get());
                }
                );

        aopBrowser.show();
        System.out.println("loading time : " + end.get());
        // 첫 번째 로딩 타임은 1.5초

        aopBrowser.show();
        System.out.println("loading time : " + end.get());
        // 두 번째 로딩 타임은 0초 (캐시를 이용했기 때문)
    }
}
