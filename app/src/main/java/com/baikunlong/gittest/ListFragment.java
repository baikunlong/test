package com.baikunlong.gittest;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

public class ListFragment extends android.app.ListFragment {

	boolean dualPane; // �Ƿ���һ����ͬʱ��ʾ�б����ϸ����
	int curCheckPosition = 0; // ��ǰѡ�������λ��

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);

		MyAdapter ad=new MyAdapter(getActivity(), DataBase.getPersons());
		setListAdapter(ad); // Ϊ�б�����������

		View detailFrame = getActivity().findViewById(R.id.detail);
		dualPane = detailFrame != null &&
				detailFrame.getVisibility() == View.VISIBLE;
		if (savedInstanceState != null) {
			curCheckPosition = savedInstanceState.getInt("curChoice", 0); // ���µ�ǰѡ�������λ��
		}
		
		if (dualPane) { // �����һ����ͬʱ��ʾ�б����ϸ����
			getListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE); // �����б�Ϊ��ѡģʽ
			showDetails(curCheckPosition); // ��ʾ��ϸ����
		}
	}

	// ��дonSaveInstanceState()���������浱ǰѡ�е��б��������ֵ
	@Override
	public void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		outState.putInt("curChoice", curCheckPosition);
	}

	// ��дonListItemClick()����
	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {
		showDetails(position); // ����showDetails()������ʾ��ϸ����
	}

	void showDetails(int index) {
        curCheckPosition = index; // ���±��浱ǰ����λ�õı�����ֵΪ��ǰѡ��ֵ

        if (dualPane) { // ����һ����ͬʱ��ʾ�б����ϸ����ʱ

            getListView().setItemChecked(index, true); // ����ѡ���б���Ϊѡ��״̬

            DetailFragment details = (DetailFragment) getFragmentManager().findFragmentById(R.id.detail);
            if (details == null || details.getShownIndex() != index) { // ������
                details = DetailFragment.newInstance(index);
                FragmentTransaction ft = getFragmentManager()
                        .beginTransaction();// ���һ��FragmentTransaction��ʵ��
                ft.replace(R.id.detail, details); // �滻ԭ����ʾ����ϸ����
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE); // ����ת��Ч��
                ft.commit(); // �ύ����

            }

        }
    }
}
