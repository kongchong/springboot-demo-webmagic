package com.kc.demo.webmagic.model;

import javax.persistence.Column;
import javax.persistence.Id;

public class ProxyIp extends RecordEntity {

    @Id
    private Long id;

    private String ip;

    private Integer port;

    private String addr;

    private String type;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr == null ? null : addr.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    @Override
    public String toString() {
        return "ProxyIp{" +
                "id=" + id +
                ", ip='" + ip + '\'' +
                ", port=" + port +
                ", addr='" + addr + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}