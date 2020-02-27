package com.eks.lazyfragment;

import android.view.View;

import com.eks.ekslazyfragment.R;
import com.eks.lazyfragment.lazy.BaseLazyFragment;
import com.eks.lazyfragment.lazy.BaseLazyFragment;

import org.jetbrains.annotations.NotNull;

/**
 * Created by Riggs on 2020/2/27
 */
public class EFragment extends BaseLazyFragment {
    @Override
    public int getInflatLayout() {
        return R.layout.layout_e;
    }

    @Override
    public void onInvisible() {
        System.out.println("E停止加载");
    }

    @Override
    public void onVisible() {
        System.out.println("E开始加载");
    }

    @Override
    public void initCompleted(@NotNull View inflatedView) {

    }
}
