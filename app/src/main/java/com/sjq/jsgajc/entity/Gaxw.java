package com.sjq.jsgajc.entity;

import android.view.View;

import com.chad.library.adapter.base.BaseViewHolder;

/**
 * 首页新闻列表-公安新闻
 */
public class Gaxw {
    private String id; //主键
    private int resid;//图片id
    private String title; //标题
    private String ftitle; //副标题
    private String lb; //类别
    private String dd; //地点
    private String sj; //时间
    private String xxxxtitle;//详细信息标题
    private String[] xxxxnr;//详细信息标题

    public Gaxw(String id, int resid, String title, String ftitle, String lb, String dd, String sj, String xxxxtitle, String[] xxxxnr) {
        this.id = id;
        this.resid = resid;
        this.title = title;
        this.ftitle = ftitle;
        this.lb = lb;
        this.dd = dd;
        this.sj = sj;
        this.xxxxtitle = xxxxtitle;
        this.xxxxnr = xxxxnr;
    }

    public String getXxxxtitle() {
        return xxxxtitle;
    }

    public void setXxxxtitle(String xxxxtitle) {
        this.xxxxtitle = xxxxtitle;
    }

    public String[] getXxxxnr() {
        return xxxxnr;
    }

    public void setXxxxnr(String[] xxxxnr) {
        this.xxxxnr = xxxxnr;
    }

    public String getFtitle() {
        return ftitle;
    }

    public void setFtitle(String ftitle) {
        this.ftitle = ftitle;
    }

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

    public String getLb() {
        return lb;
    }

    public void setLb(String lb) {
        this.lb = lb;
    }

    public String getDd() {
        return dd;
    }

    public void setDd(String dd) {
        this.dd = dd;
    }

    public String getSj() {
        return sj;
    }

    public void setSj(String sj) {
        this.sj = sj;
    }

    public int getResid() {
        return resid;
    }

    public void setResid(int resid) {
        this.resid = resid;
    }
}
