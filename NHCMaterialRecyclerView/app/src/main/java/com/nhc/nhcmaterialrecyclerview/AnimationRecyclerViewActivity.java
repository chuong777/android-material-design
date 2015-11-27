package com.nhc.nhcmaterialrecyclerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import jp.wasabeef.recyclerview.animators.SlideInLeftAnimator;

public class AnimationRecyclerViewActivity extends AppCompatActivity {
    @Bind(R.id.my_recycler_view)
    RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private List<String> data = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic_recycler_view);
        ButterKnife.bind(this);
        generateData();

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        recyclerView.setHasFixedSize(true);

        // use a linear layout manager
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        // specify an adapter (see also next example)
        adapter = new AnimationRecyclerViewAdapter(data);
        recyclerView.setAdapter(adapter);

        //animation
        recyclerView.setItemAnimator(new SlideInLeftAnimator());
        recyclerView.getItemAnimator().setAddDuration(200);
        recyclerView.getItemAnimator().setRemoveDuration(200);
        recyclerView.getItemAnimator().setMoveDuration(200);
        recyclerView.getItemAnimator().setChangeDuration(200);
    }

    private void generateData() {
        data.add("Monday");
        data.add("Tuesday");
        data.add("Wednesday");
        data.add("Thursday");
        data.add("Friday");
        data.add("Saturday");
        data.add("Sunday");
        data.add("Monday");
        data.add("Tuesday");
        data.add("Wednesday");
        data.add("Thursday");
        data.add("Friday");
        data.add("Saturday");
        data.add("Sunday");
    }
}
