package com.example.sandeep.samplegreendao.result;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.example.sandeep.samplegreendao.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class ResultActivity extends AppCompatActivity {

    @Bind(R.id.recyclerView)
    RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.button_one_rel)
    public void onButtonClick(View view){
        //to show one-to- one relationship between teacher and student


    }

    @OnClick(R.id.button_many_rel)
    public void onClick(View view){

    }


}
