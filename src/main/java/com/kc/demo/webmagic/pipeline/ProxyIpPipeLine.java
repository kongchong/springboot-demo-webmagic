package com.kc.demo.webmagic.pipeline;

import com.kc.demo.webmagic.mapper.ProxyIpMapper;
import com.kc.demo.webmagic.model.ProxyIp;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

import java.util.List;

/**
 * @author: kc
 * @date: 2018-12-14 10:57
 * @description:
 */
@Component
public class ProxyIpPipeLine implements Pipeline {

    @Autowired
    private ProxyIpMapper proxyIpMapper;

    @Override
    public void process(ResultItems resultItems, Task task) {
        List<ProxyIp> results = resultItems.get("result");
        results.forEach(result -> {
            List<ProxyIp> proxyIps = proxyIpMapper.selectByIpAndPort(result.getIp(), result.getPort());
            if (CollectionUtils.isEmpty(proxyIps)) {
                proxyIpMapper.insertSelective(result);
            }
        });

    }
}
