package com.example.dell.am0928;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.dell.am0928.fragment.frag1;
import com.example.dell.am0928.fragment.frag2;
import com.example.dell.am0928.fragment.frag3;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MainActivity extends AppCompatActivity {


    @BindView(R.id.fram_layouts)
    FrameLayout framLayout;
    @BindView(R.id.rb_1)
    RadioButton rb1;
    @BindView(R.id.rb_2)
    RadioButton rb2;
    @BindView(R.id.rb_3)
    RadioButton rb3;
    @BindView(R.id.radio_group)
    RadioGroup radioGroup;
    private FragmentManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);




        ArrayList<Fragment> list = new ArrayList<>();
        final frag1 frag1 = new frag1();
        final frag2 frag2 = new frag2();
        final frag3 frag3 = new frag3();
        list.add(frag1);
        list.add(frag2);
        list.add(frag3);
        manager = getSupportFragmentManager();
        manager.beginTransaction().replace(R.id.fram_layouts, frag1).commit();
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                FragmentTransaction transaction = manager.beginTransaction();
                switch (checkedId){
                    case R.id.rb_1:
                        transaction.replace(R.id.fram_layouts,frag1);
                        break;
                    case R.id.rb_2:
                        transaction.replace(R.id.fram_layouts,frag2);
                        break;
                    case R.id.rb_3:
                        transaction.replace(R.id.fram_layouts,frag3);
                        break;
                }
                transaction.commit();
            }
        });

    }
}
