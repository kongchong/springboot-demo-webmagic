package com.kc.demo.webmagic.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 实体类通用继承类
 *
 * @author: kc
 * @date: 2018-12-13 11:18
 */
public class RecordEntity implements Serializable {

    private static final long serialVersionUID = 7026470724648329551L;

    private Date createdTime;

    private Date lastModifiedTime;

    /**
     * @return created_time
     */
    public Date getCreatedTime() {
        return createdTime;
    }

    /**
     * @param createdTime
     */
    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }


    /**
     * @return last_modified_time
     */
    public Date getLastModifiedTime() {
        return lastModifiedTime;
    }

    /**
     * @param lastModifiedTime
     */
    public void setLastModifiedTime(Date lastModifiedTime) {
        this.lastModifiedTime = lastModifiedTime;
    }


}
