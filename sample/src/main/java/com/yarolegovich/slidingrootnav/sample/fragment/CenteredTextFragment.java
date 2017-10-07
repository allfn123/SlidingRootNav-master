package com.yarolegovich.slidingrootnav.sample.fragment;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.yarolegovich.slidingrootnav.sample.LoginRegisterActivity;
import com.yarolegovich.slidingrootnav.sample.R;
import com.yarolegovich.slidingrootnav.sample.SampleActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


/**
 * Created by yarolegovich on 25.03.2017.
 */

public class CenteredTextFragment extends Fragment {

    private static final String EXTRA_TEXT = "text";

    private String fragmentType = null;

    public static CenteredTextFragment createFor(String text) {
        CenteredTextFragment fragment = new CenteredTextFragment();
        fragment.fragmentType = text;
        Bundle args = new Bundle();
        args.putString(EXTRA_TEXT, text);
        fragment.setArguments(args);//向Fragment传参数
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //指定使用哪个fragment来替换
        if ("head".equals(fragmentType)){
            return inflater.inflate(R.layout.user_settings, container, false);
        }
        else{
            return inflater.inflate(R.layout.fragment_text, container, false);
        }
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        final String text = getArguments().getString(EXTRA_TEXT);
        if (text.equals("head")){
            if (SampleActivity.loginOrNot == false){
                String[] mListTitle = {"登陆", "注册"};
                ArrayList<Map<String,Object>>  mData = new ArrayList<Map<String, Object>>();

                for (int i = 0; i < mListTitle.length; i++){
                    Map<String,Object> item = new HashMap<String,Object>();
                    item.put("title",mListTitle[i]);
                    mData.add(item);
                }
                SimpleAdapter adapter = new SimpleAdapter(view.getContext(),mData,R.layout.headview_item,
                        new String[]{"title"},new int[]{R.id.tv_title});


                ListView lv_selections = (ListView) view.findViewById(R.id.lv_selections);
                lv_selections.setAdapter(adapter);

                lv_selections.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        Intent intent=new Intent();
                        intent.setClass(view.getContext(), LoginRegisterActivity.class);
                        startActivity(intent);
                    }
                });
            } else if (text.equals("Music")){

            } else {
                final String[] mListTitle = {"头像", "用户名","昵称","性别","登陆选项","修改密码","实名认证","个性签名"};
                String[] mListInfo = {"123", "234","33333","22","","","YES","Hello World!"};
                ArrayList<Map<String,Object>>  mData = new ArrayList<Map<String, Object>>();

                for (int i = 0; i < mListTitle.length; i++){
                    Map<String,Object> item = new HashMap<String,Object>();
                    item.put("title",mListTitle[i]);
                    item.put("info",mListInfo[i]);
                    mData.add(item);
                }
                SimpleAdapter adapter = new SimpleAdapter(view.getContext(),mData,R.layout.headview_item,
                        new String[]{"title","info"},new int[]{R.id.tv_title,R.id.tv_info});


                ListView lv_selections = (ListView) view.findViewById(R.id.lv_selections);
                lv_selections.setAdapter(adapter);

                lv_selections.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        Toast.makeText(view.getContext(),mListTitle[i],Toast.LENGTH_SHORT).show();
                    }
                });
            }



        } else {
            TextView textView = view.findViewById(R.id.text);
            textView.setText(text);
            textView.setOnClickListener(new View.OnClickListener() {
                @Override public void onClick(View v) {
                    Toast.makeText(v.getContext(), text, Toast.LENGTH_SHORT).show();
                }
            });
        }

    }
}
