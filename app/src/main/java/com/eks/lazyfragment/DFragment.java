package com.eks.lazyfragment;

import android.view.View;

import com.eks.lazyfragment.R;
import com.eks.lazyfragment.lazy.BaseLazyFragment;

import org.jetbrains.annotations.NotNull;

/**
 * Created by Riggs on 2020/2/27
 */
public class DFragment extends BaseLazyFragment {
    @Override
    public int getInflatLayout() {
        return R.layout.layout_d;
    }

    @Override
    public void onInvisible() {
        System.out.println("D停止加载");
    }

    @Override
    public void onVisible() {
        System.out.println("D开始加载");
    }

    @Override
    public void initCompleted(@NotNull View inflatedView) {

    }
}
