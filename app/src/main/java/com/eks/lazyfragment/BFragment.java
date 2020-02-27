package com.eks.lazyfragment;

import android.view.View;

import com.eks.lazyfragment.R;
import com.eks.lazyfragment.lazy.BaseLazyFragment;

import org.jetbrains.annotations.NotNull;

/**
 * Created by Riggs on 2020/2/27
 */
public class BFragment extends BaseLazyFragment {
    @Override
    public int getInflatLayout() {
        return R.layout.layout_b;
    }

    @Override
    public void onInvisible() {
        System.out.println("B停止加载");
    }

    @Override
    public void onVisible() {
        System.out.println("B开始加载");
    }

    @Override
    public void initCompleted(@NotNull View inflatedView) {

    }
}
