package com.baikunlong.gittest;

import java.util.*;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

public class MyAdapter extends BaseAdapter {
    private List<Person> persons;  //���ݼ�
    private LayoutInflater inflater;

    public MyAdapter(Context context, List<Person> persons) {
        inflater = LayoutInflater.from(context); //����Activity����LayoutInflater
        this.persons = persons;
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return persons.size();
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return persons.get(position);
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null)
            convertView = inflater.inflate(R.layout.item, parent, false); //���ز���
        //��������
        TextView tName = (TextView) convertView.findViewById(R.id.tName);
        TextView tPhone = (TextView) convertView.findViewById(R.id.tPhone);
        TextView tEmail = (TextView) convertView.findViewById(R.id.tEmail);
        TextView tIntro = (TextView) convertView.findViewById(R.id.tIntro);
//		CheckBox ckSelect = convertView.findViewById(R.id.ckSelect);
//		ckSelect.setSelected(false);
        Person p = persons.get(position); //ȡ����ǰ��
        tName.setText(p.getName());
        tPhone.setText(p.getPhone());
        tEmail.setText(p.getEmail());
        tIntro.setText(p.getIntro());
        return convertView;
    }

}
