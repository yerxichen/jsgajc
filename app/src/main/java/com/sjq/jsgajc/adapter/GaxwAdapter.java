package com.sjq.jsgajc.adapter;

import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.sjq.jsgajc.R;
import com.sjq.jsgajc.entity.Gaxw;

import java.util.List;

public class GaxwAdapter extends BaseQuickAdapter<Gaxw,BaseViewHolder>{

    public GaxwAdapter(int layoutResId, @Nullable List<Gaxw> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, Gaxw item) {
        helper.setImageResource(R.id.iv,item.getResid());
        helper.setText(R.id.tv_ftitle,item.getFtitle());
        helper.setText(R.id.tv_lb,item.getLb());
        helper.setText(R.id.tv_ddsj,item.getDd()+" "+item.getSj());
    }
}
