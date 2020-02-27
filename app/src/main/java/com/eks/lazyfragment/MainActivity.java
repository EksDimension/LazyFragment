package com.eks.lazyfragment;

import android.os.Bundle;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
    protected TabLayout tlTop;
    protected ViewPager vpContainer;
    protected String[] tabString;
    protected String[] tabStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tlTop = findViewById(R.id.tlTop);
        vpContainer = findViewById(R.id.vpContainer);

        tlTop.setupWithViewPager(vpContainer);
        tabString = new String[]{"A"
                , "B"
                , "C"
                , "D"
                , "E"
        };
        vpContainer.setAdapter(new FragmentPagerAdapter(this.getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                switch (position) {
                    case 0:
                        return new AFragment();
                    case 1:
                        return new BFragment();
                    case 2:
                        return new CFragment();
                    case 3:
                        return new DFragment();
                    case 4:
                        return new EFragment();
                }
                return new AFragment();
            }

            @Nullable
            @Override
            public CharSequence getPageTitle(int position) {
                return tabString[position];
            }

            @Override
            public int getCount() {
                return tabString.length;
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
//                super.destroyItem(container, position, object);
            }
        });
    }
}
