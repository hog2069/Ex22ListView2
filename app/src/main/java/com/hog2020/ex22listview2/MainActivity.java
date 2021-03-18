package com.hog2020.ex22listview2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    ListView listView;
    EditText et;

    //대량의 데이터를 가지고 있는 배열 or ArrayList
    ArrayList<String> datas= new ArrayList<String>();

    //아답터 참조변수
    ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //테스트 목적으로 String 데이터 3개 정도 추가
//        datas.add(new String("aaa"));
//        datas.add(new String("bbb"));
//        datas.add("ccc");//자동 new String()

        listView=findViewById(R.id.listview);
        et=findViewById(R.id.et);

        //ListView 가 보여줄 View 들을 만들어 내는 작업을
        //수행하는 Adapter 객체 생성
        adapter=new ArrayAdapter(this, android.R.layout.simple_list_item_1,datas);
        listView.setAdapter(adapter);

        //리스트 뷰의 아이템이 비어있을때 보여지는 뷰를 설정
        TextView tvempty=findViewById(R.id.tv_empty);
        listView.setEmptyView(tvempty);

        //리스트뷰 항목을  롱~~클릭삭제
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

                datas.remove(position);
                adapter.notifyDataSetChanged();

                return true;
            }
        });
    }

    public void clickADD(View view) {

        //리스트 뷰가 보여주는 대량의 데이터|(datas)를 추가
        String s=et.getText().toString();
        datas.add(s);

        //리스트뷰 갱신 -아답터에게 데이터의 변경이 있다고 공지
        adapter.notifyDataSetChanged();

        et.setText("");


    }
}