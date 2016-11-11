package com.example.sandeep.samplegreendao.result;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.afollestad.materialdialogs.MaterialDialog;
import com.example.sandeep.samplegreendao.R;
import com.example.sandeep.samplegreendao.dagger.AppComponent;
import com.example.sandeep.samplegreendao.dagger.MyApplication;
import com.example.sandeep.samplegreendao.result.dagger.DaggerResultComponent;
import com.example.sandeep.samplegreendao.result.dagger.ResultModule;

import java.util.List;

import javax.inject.Inject;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class ResultActivity extends AppCompatActivity implements ResultView {

    @Inject
    ResultPresenter presenter;
    private String teacherName;
 


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
            presenter.onOneRelClicked();
        }
    }

    @OnClick(R.id.button_many_rel)
    public void onClick(View view) {
        //to show one-to- one relationship between teacher and student
        if (presenter != null) {
            presenter.onManyRelClicked();
        }
    }

    @Override
    public void showDailog(List<FeedBackDetails> list) {


        boolean wrapInScrollView = true;
        MaterialDialog dialog =  new MaterialDialog.Builder(this)
                .customView(R.layout.feedback_item_layout, wrapInScrollView)
        .show();

        View dialogView = dialog.getCustomView();
        TextView nameText = (TextView) dialogView.findViewById(R.id.student_name);
        TextView teacherName = (TextView) dialogView.findViewById(R.id.teacher_name);
        TextView ratingText = (TextView) dialogView.findViewById(R.id.rating_text);

        nameText.setText("Student Name " + list.get(0).getStudentName());
        teacherName.setText("Teacher Name " + list.get(0).getTeachersName());
        ratingText.setText("Teacher rating " + list.get(0).getTeachersRating());

    }

    @Override
    public void showTeacherList(List<String> list) {
        new MaterialDialog.Builder(this)
                .title("Select Teacher")
                .items(list)
                .itemsCallbackSingleChoice(-1, new MaterialDialog.ListCallbackSingleChoice() {
                    @Override
                    public boolean onSelection(MaterialDialog materialDialog, View view, int i,
                                               CharSequence charSequence) {
                         teacherName = String.valueOf(charSequence);
                        presenter.setSelectedTeacher(teacherName);
                        return false;
                    }
                })
                .show();

    }

    @Override
    public void showVoterList(List<String> list) {
        new MaterialDialog.Builder(this)
                .title("voter List for "+ teacherName)
                .items(list)
                .show();
    }
}
