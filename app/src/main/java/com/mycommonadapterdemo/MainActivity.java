package com.mycommonadapterdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Checkable;
import android.widget.ListView;
import android.widget.Toast;

import com.mycommonadapterdemo.adapter.MyCommonAdapter;
import com.mycommonadapterdemo.adapter.ViewHolder;
import com.mycommonadapterdemo.bean.TestBean;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private static final String TAG = "MainActivity";

    private ListView mListView;
    private List<TestBean> mList = new ArrayList<>();
    private MyCommonAdapter<TestBean> mAdapter;

    int[] resId = {R.mipmap.pic1, R.mipmap.pic2, R.mipmap.pic3, R.mipmap.pic4, R.mipmap.pic5, R.mipmap.pic6,
            R.mipmap.pic7, R.mipmap.pic8, R.mipmap.pic9, R.mipmap.pic1, R.mipmap.pic2, R.mipmap.pic3, R.mipmap.pic4,
            R.mipmap.pic5, R.mipmap.pic6, R.mipmap.pic7, R.mipmap.pic8, R.mipmap.pic9, R.mipmap.pic4, R.mipmap.pic5,
            R.mipmap.pic2};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mListView = (ListView) findViewById(R.id.mListView);
        for (int i = 0; i < 20; i++) {
            TestBean tb = new TestBean();
            tb.setTitle("标题" + i);
            tb.setDes("简介" + i);
            tb.setBtn("按钮" + i);
            tb.setSelect(false);
            tb.setImageRes(resId[i]);
            mList.add(tb);
        }
        mAdapter = new MyCommonAdapter<TestBean>(this, R.layout.test_list_item, mList) {


            public void getView(ViewHolder viewHolder, TestBean item) {
                viewHolder.setText(R.id.test_title, item.getTitle());
                viewHolder.setText(R.id.test_des, item.getDes());
                viewHolder.setText(R.id.test_button, item.getBtn());
                viewHolder.setImageResource(R.id.test_image, item.getImageRes());
                viewHolder.setChecked(R.id.test_check, item.isSelect());

                viewHolder.setTag(R.id.test_image, viewHolder.getItemPosition());
                viewHolder.setTag(R.id.test_button, viewHolder.getItemPosition());
                viewHolder.setTag(R.id.test_check, viewHolder.getItemPosition());

                viewHolder.setOnClickListener(R.id.test_image, this);
                viewHolder.setOnClickListener(R.id.test_button, this);
                viewHolder.setOnClickListener(R.id.test_check, this);


            }

            @Override
            public void onClick(View v) {

                Integer index = (Integer) v.getTag();
                Log.i(TAG, "onClick: index==" + index);

                switch (v.getId()) {
                    case R.id.test_image:
                        Toast.makeText(MainActivity.this, "点击了头像=" + index, Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.test_button:
                        Toast.makeText(MainActivity.this, "点击了按钮==" + index, Toast.LENGTH_SHORT).show();
                        break;


                    case R.id.test_check:
                        mList.get(index).setSelect(!mList.get(index).isSelect());
                        ((Checkable) v).setChecked(mList.get(index).isSelect());
                        mAdapter.notifyDataSetChanged();
                        break;
                    default:
                        break;
                }


            }
        };
        mListView.setAdapter(mAdapter);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "点击了条目===" + position, Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void toRecycle(View view) {


    }
}
