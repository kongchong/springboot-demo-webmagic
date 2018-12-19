package com.kc.demo.webmagic.mapper;

import com.kc.demo.webmagic.model.ProxyIp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.BaseMapper;

import java.util.List;

@Mapper
public interface ProxyIpMapper extends BaseMapper<ProxyIp> {

    @Select("SELECT * FROM proxy_ip WHERE ip= #{ip} AND `port` = #{port}")
    List<ProxyIp> selectByIpAndPort(@Param("ip") String ip, @Param("port") Integer port);

}