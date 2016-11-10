package com.example.sandeep.samplegreendao.result;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.sandeep.samplegreendao.R;
import com.example.sandeep.samplegreendao.dagger.AppComponent;
import com.example.sandeep.samplegreendao.dagger.MyApplication;
import com.example.sandeep.samplegreendao.result.dagger.DaggerResultComponent;
import com.example.sandeep.samplegreendao.result.dagger.ResultModule;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class ResultActivity extends AppCompatActivity implements ResultView {

    @Inject
    ResultPresenter presenter;
    @Bind(R.id.recyclerView)
    RecyclerView recyclerView;
    private FeedBackDetailAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        ButterKnife.bind(this);
        setupComponent(MyApplication.get(this).getAppComponent());
    }

    private void setupComponent(AppComponent component) {
        DaggerResultComponent.builder()
                .appComponent(component)
                .resultModule(new ResultModule(this))
                .build()
                .inject(this);
    }

    @OnClick(R.id.button_one_rel)
    public void onButtonClick(View view) {
        //to show one-to- one relationship between teacher and student
        if (presenter != null) {
            presenter.onOneRelClicked("1");
        }
    }

    @OnClick(R.id.button_many_rel)
    public void onClick(View view) {

    }

    public void attachAdapter() {
        adapter = new FeedBackDetailAdapter(this.getApplicationContext());
        RecyclerView.LayoutManager manager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(manager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
    }

}
