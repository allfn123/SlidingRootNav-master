package com.yarolegovich.slidingrootnav.sample.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import com.yarolegovich.slidingrootnav.sample.R;

/**
 * Created by luoguizhao on 2017/10/7.
 */

public class HeadView extends LinearLayout {
    public HeadView(Context context, AttributeSet attrs){
        super(context,attrs);

        LayoutInflater.from(context).inflate(R.layout.head_view,this);

    }
}
