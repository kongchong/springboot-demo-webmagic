package com.kc.demo.webmagic.runner;

import com.kc.demo.webmagic.pageprocessor.ProxyIpPageProcessor;
import com.kc.demo.webmagic.pipeline.ProxyIpPipeLine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Spider;

/**
 * @author: kc
 * @date: 2018-12-14 10:00
 * @description:
 */
@Component
public class StartRunner implements ApplicationRunner {

    @Autowired
    private ProxyIpPageProcessor proxyIpPageProcessor;

    @Autowired
    private ProxyIpPipeLine proxyIpPipeLine;

    @Override
    public void run(ApplicationArguments args) {
        Spider.create(proxyIpPageProcessor)
                .addPipeline(proxyIpPipeLine)
                .addUrl("http://www.xicidaili.com/nn/1")
                .thread(3)
                .start();
    }
}
