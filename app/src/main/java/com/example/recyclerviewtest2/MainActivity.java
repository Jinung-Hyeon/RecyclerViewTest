package com.example.recyclerviewtest2;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<String> list, testlist;
    ArrayList<List<String>> list2;
    LinearLayout pageButton_layout;
    Button button;
    RecyclerView recyclerView;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);

        ActionBar ac = getSupportActionBar();
        ac.hide();
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        list = new ArrayList<>();
        list2 = new ArrayList<List<String>>();
        list.add("아이템 1");
        list.add("아이템 2");
        list.add("아이템 3");
        list.add("아이템 4");
        list.add("아이템 5");
        list.add("아이템 6");
        list.add("아이템 7");
        list.add("아이템 8");
        list.add("아이템 9");
        list.add("아이템 10");
        list.add("아이템 11");
        list.add("아이템 12");
        list.add("아이템 13");


        if (list.size() < 6){
            list2.add(list);
        } else {
            // 갯수가 6의 배수일때
            if (list.size() % 6 == 0){
                for (int i = 0; i < (list.size() / 6); i++){
                    testlist = new ArrayList<>();
                    for (int j = 0; j < 6; j++) {

                        testlist.add("아이템 " + (j + (i * 6)));
                    }
                    list2.add(testlist);
                    Log.d("msgmsg", "list2: " + list2);
                }

                Log.d("msgmsg", "list: " + list);
                Log.d("msgmsg", "testlist: " + testlist);
                Log.d("msgmsg", "list2: " + list2);
            } else { // 갯수가 6의배수가 아닐때
                for (int i = 0; i <= list.size() / 6; i++){
                    testlist = new ArrayList<>();
                    if (i == list.size() / 6){
                        for (int j = 0; j < list.size() % 6; j++) {
                            testlist.add("아이템 " + (j + (i * 6)));
                        }
                    } else {
                        for (int j = 0; j < 6; j++) {

                            testlist.add("아이템 " + (j + (i * 6)));
                        }
                    }

                    list2.add(testlist);
                    Log.d("msgmsg", "list2: " + list2);
                }

                Log.d("msgmsg", "list: " + list);
                Log.d("msgmsg", "testlist: " + testlist);
                Log.d("msgmsg", "list2: " + list2);
            }
        }



        //list2.add(list);
        //Log.d("msgmsg", "onCreate: " + list2);
        Log.d("msgmsg", "13 / 6 : " + 12 / 6 + " 13 % 6 : " + 7 % 6);

        recyclerView = findViewById(R.id.recycler1);
        button = findViewById(R.id.next);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recyclerView.smoothScrollToPosition(1);
            }
        });
        pageButton_layout = findViewById(R.id.pageButton_layout);
        FragmentA fragmentA = new FragmentA(list2);
        FragmentB fragmentB = new FragmentB();

        getSupportFragmentManager().beginTransaction().replace(R.id.QnAFrame, fragmentA).commit();
        getSupportFragmentManager().beginTransaction().replace(R.id.guideFrame, fragmentB).commit();
        createTextView();
    }

    private void createTextView() {
        int dp = 35;
        float mScale = getResources().getDisplayMetrics().density;
        TextView tv_left = new TextView(this);
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        lp.leftMargin = (int) (10 * mScale);
        tv_left.setText("<");
        tv_left.setWidth((int) (dp * mScale));
        tv_left.setHeight((int) (dp * mScale));
        tv_left.setGravity(Gravity.CENTER);
        tv_left.setLayoutParams(lp);
        tv_left.setBackground(getResources().getDrawable(R.drawable.bg_custom_button, null));
        pageButton_layout.addView(tv_left);

        for (int i = 1; i <= list2.size(); i++) {
            TextView textView = new TextView(this);
            lp.leftMargin = (int) (10 * mScale);
            textView.setText(""+i);
            textView.setId(i);
            textView.setWidth((int) (dp * mScale));
            textView.setHeight((int) (dp * mScale));
            textView.setGravity(Gravity.CENTER);
            textView.setLayoutParams(lp);
            textView.setBackground(getResources().getDrawable(R.drawable.bg_custom_button, null));
            pageButton_layout.addView(textView);
        }

        TextView tv_right = new TextView(this);
        lp.leftMargin = (int) (10 * mScale);
        tv_right.setText(">");
        tv_right.setWidth((int) (dp * mScale));
        tv_right.setHeight((int) (dp * mScale));
        tv_right.setGravity(Gravity.CENTER);
        tv_right.setLayoutParams(lp);
        tv_right.setBackground(getResources().getDrawable(R.drawable.bg_custom_button, null));
        pageButton_layout.addView(tv_right);
        Log.d("msgmsg", "createTextView: " + 1 % 3);

    }

}