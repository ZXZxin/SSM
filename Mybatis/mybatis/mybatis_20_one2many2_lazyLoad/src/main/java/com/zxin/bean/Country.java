package com.zxin.bean;

import java.util.Set;

public class Country {
    private Integer cid;
    private String cname;
    // 关联属性
    private Set<Minister> ministers; // 一般在一对多的关系中使用Set而不是List，因为Set的无序性和不可重复性
    public Integer getCid() {
        return cid;
    }
    public void setCid(Integer cid) {
        this.cid = cid;
    }
    public String getCname() {
        return cname;
    }
    public void setCname(String cname) {
        this.cname = cname;
    }
    public Set<Minister> getMinisters() {
        return ministers;
    }
    public void setMinisters(Set<Minister> ministers) {
        this.ministers = ministers;
    }
    @Override
    public String toString() {
        return "Country [cid=" + cid + ", cname=" + cname + ", ministers="
                + ministers + "]";
    }
}
