package com.sjq.jsgajc.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.sjq.jsgajc.R;
import com.sjq.jsgajc.entity.Jywy;

import java.util.List;

public class XgtjAdapter extends BaseQuickAdapter<Jywy,BaseViewHolder>{

    public XgtjAdapter(int layoutResId, @Nullable List<Jywy> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, Jywy item) {
        helper.setText(R.id.tv_title,item.getTitle());
    }
}
