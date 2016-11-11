package com.example.sandeep.samplegreendao.feedback;

import android.content.Intent;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sandeep.samplegreendao.R;
import com.example.sandeep.samplegreendao.dagger.AppComponent;
import com.example.sandeep.samplegreendao.dagger.MyApplication;
import com.example.sandeep.samplegreendao.feedback.dagger.DaggerFeedBackComponent;
import com.example.sandeep.samplegreendao.feedback.dagger.FeedBackModule;
import com.example.sandeep.samplegreendao.result.ResultActivity;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class StudentActivity extends AppCompatActivity implements StudentView {

    @Inject
    StudentPresenter presenter;

    @Bind(R.id.name_text)
    EditText nameText;
    @Bind(R.id.father_name)
    EditText fatherNameText;
    @Bind(R.id.class_text)
    EditText classText;
    @Bind(R.id.roll_no_text)
    EditText rollNosText;
    @Bind(R.id.teacher_text)
    EditText teacherName;
    @Bind(R.id.teacher_id_text)
    EditText teacherIdText;
    @Bind(R.id.subject)
    EditText subjectText;
    @Bind(R.id.rating_text)
    EditText ratingText;
    @Bind(R.id.user_detail_text)
    TextView userDetailsText;
    @Bind(R.id.input_layout_user_name)
    TextInputLayout nameLayout;
    @Bind(R.id.input_layout_father_name)
    TextInputLayout dadLayout;
    @Bind(R.id.input_layout_user_class)
    TextInputLayout classLayout;
    @Bind(R.id.input_layout_user_roll_no)
    TextInputLayout rollNosLayout;
    @Bind(R.id.teacher_text_layout)
    TextInputLayout teacherLayout;
    @Bind(R.id.input_layout_subject)
    TextInputLayout subjectLayout;
    @Bind(R.id.input_layout_teacher_id)
    TextInputLayout idLayout;
    @Bind(R.id.rating_text_layout)
    TextInputLayout ratingLayout;
    @Bind(R.id.appBar)
    AppBarLayout appBarLayout;
    @Bind(R.id.submit_fab)
    FloatingActionButton submitButton;
    @Bind(R.id.fab)
    FloatingActionButton button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setupComponent(MyApplication.get(this).getAppComponent());
    }

    private void setupComponent(AppComponent component) {
        DaggerFeedBackComponent.builder()
                .appComponent(component)
                .feedBackModule(new FeedBackModule(this))
                .build()
                .inject(this);
        if (presenter != null) {
            presenter.attachPresenter();
        }
    }

    @OnClick(R.id.fab)
    public void onSubmitButtonClick(View view) {
        if (presenter != null) {
            presenter.SubmitFeedBackDetails(nameText.getText().toString(), fatherNameText.getText().toString(), classText.getText().toString(), rollNosText.getText().toString(), false);
        }
    }

    @Override
    public void initAppBarLayout() {
        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
                if (Math.abs(i) >= appBarLayout.getTotalScrollRange() - 90) {
                    userDetailsText.setVisibility(View.GONE);
                } else {
                    userDetailsText.setVisibility(View.VISIBLE);
                }
            }
        });

        setVisibility(false);

    }

    @Override
    public void navigateToResultActivity() {
        startActivity(new Intent(StudentActivity.this, ResultActivity.class));
    }

    private void setVisibility(boolean visible) {
        if (visible) {
            button.setVisibility(View.GONE);
            submitButton.setVisibility(View.VISIBLE);
            teacherLayout.setVisibility(View.VISIBLE);
            idLayout.setVisibility(View.VISIBLE);
            subjectLayout.setVisibility(View.VISIBLE);
            ratingLayout.setVisibility(View.VISIBLE);
            nameLayout.setVisibility(View.GONE);
            rollNosLayout.setVisibility(View.GONE);
            classLayout.setVisibility(View.GONE);
            dadLayout.setVisibility(View.GONE);
        } else {
            button.setVisibility(View.VISIBLE);
            submitButton.setVisibility(View.GONE);
            nameLayout.setVisibility(View.VISIBLE);
            rollNosLayout.setVisibility(View.VISIBLE);
            classLayout.setVisibility(View.VISIBLE);
            dadLayout.setVisibility(View.VISIBLE);
            teacherLayout.setVisibility(View.GONE);
            idLayout.setVisibility(View.GONE);
            subjectLayout.setVisibility(View.GONE);
            ratingLayout.setVisibility(View.GONE);
        }
    }

    @Override
    public void showTeacherFeedBackForm() {
        setVisibility(true);
    }

    @Override
    public void showToast(int stringId) {
        Toast.makeText(StudentActivity.this, getResources().getString(stringId), Toast.LENGTH_SHORT).show();
    }

    @OnClick(R.id.submit_fab)
    public void OnSubmitButtonClicked(View view) {
        if (presenter != null) {
            presenter.SubmitFeedBackDetails(teacherName.getText().toString(), subjectText.getText().toString(), ratingText.getText().toString(), teacherIdText.getText().toString(), true);
        }
    }
}
