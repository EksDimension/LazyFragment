package com.eks.lazyfragment;

import android.content.Intent;
import android.view.View;

import com.eks.ekslazyfragment.R;
import com.eks.lazyfragment.lazy.BaseLazyFragment;

import org.jetbrains.annotations.NotNull;

/**
 * Created by Riggs on 2020/2/27
 */
public class CFragment extends BaseLazyFragment {
    @Override
    public int getInflatLayout() {
        return R.layout.layout_c;
    }

    @Override
    public void onInvisible() {
        System.out.println("C停止加载");
    }

    @Override
    public void onVisible() {
        System.out.println("C开始加载");
    }

    @Override
    public void initCompleted(@NotNull View inflatedView) {
        inflatedView.findViewById(R.id.btnStartActivity).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), SecondActivity.class));
            }
        });
    }
}
