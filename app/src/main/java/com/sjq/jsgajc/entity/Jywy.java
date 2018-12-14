package com.sjq.jsgajc.entity;

public class Jywy {
    private String id;
    private String title;
    private String zzdw;
    private String zzxm;
    private String[] context;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getZzdw() {
        return zzdw;
    }

    public void setZzdw(String zzdw) {
        this.zzdw = zzdw;
    }

    public String getZzxm() {
        return zzxm;
    }

    public void setZzxm(String zzxm) {
        this.zzxm = zzxm;
    }

    public String[] getContext() {
        return context;
    }

    public void setContext(String[] context) {
        this.context = context;
    }

    public Jywy(String id, String title, String zzdw, String zzxm, String[] context) {
        this.id = id;
        this.title = title;
        this.zzdw = zzdw;
        this.zzxm = zzxm;
        this.context = context;
    }
}
