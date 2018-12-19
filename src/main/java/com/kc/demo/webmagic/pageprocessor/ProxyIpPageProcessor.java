package com.kc.demo.webmagic.pageprocessor;

import com.kc.demo.webmagic.model.ProxyIp;
import com.kc.demo.webmagic.utils.UserAgentUtils;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Selectable;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: kc
 * @date: 2018-12-10 10:30
 * @description:
 */
@Component
public class ProxyIpPageProcessor implements PageProcessor {


    private final Site site = Site.me()
            .setTimeOut(6000)
            .setRetryTimes(3)
            .setSleepTime(1000)
            .setCharset("UTF-8")
            .addHeader("Referer", "https://www.google.com/")
            .addHeader("Host","www.xicidaili.com")
            .addHeader("Cookie","_free_proxy_session=BAh7B0kiD3Nlc3Npb25faWQGOgZFVEkiJTBkZWUwODk4YWQ2Y2U0ZGE1NWNiYzhlODIyM2NmOWUxBjsAVEkiEF9jc3JmX3Rva2VuBjsARkkiMUR6YXFrYzhQc2FibEZNeHZDeTR4eDZJaklxVWU5cW5lUENJRGI1d0V4UjA9BjsARg%3D%3D--b1c0a4171f11955f86c40ac9fd895a80967d41fd")
            .setUserAgent(UserAgentUtils.randomUserAgent());

    @Override
    public void process(Page page) {
        List<Selectable> nodes = page.getHtml().xpath("//*[@id=\"ip_list\"]/tbody/tr").nodes();
        List<ProxyIp> result = new ArrayList<>();
        if (nodes != null && nodes.size() > 0) {
            //移除表头
            nodes.remove(0);
            for (Selectable tmp : nodes) {
                ProxyIp proxyIp = new ProxyIp();
                proxyIp.setIp(tmp.xpath("//tr/td[2]/text()").get());
                proxyIp.setPort(Integer.valueOf(tmp.xpath("//tr/td[3]/text()").get()));
                if (null != tmp.xpath("//tr/td[4]/a/text()").toString()) {

                    proxyIp.setAddr(tmp.xpath("//tr/td[4]/a/text()").toString());
                } else {
                    proxyIp.setAddr(tmp.xpath("//tr/td[4]/text()").toString());
                }
                proxyIp.setType(tmp.xpath("//tr/td[6]/text()").toString());

                result.add(proxyIp);
            }
        }
        page.putField("result", result);
        page.addTargetRequest("http://www.xicidaili.com/nn/2");
        page.addTargetRequest("http://www.xicidaili.com/nn/3");

    }

    @Override
    public Site getSite() {
        return site;
    }

    public static void main(String[] args) {
        Spider.create(new ProxyIpPageProcessor())
                .addUrl("http://www.xicidaili.com/nn/1").thread(3).run();
    }
}
