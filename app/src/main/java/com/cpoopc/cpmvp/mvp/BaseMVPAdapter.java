package com.cpoopc.cpmvp.mvp;/**
 * Created by cpoopc on 2015/8/3.
 */

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;


import com.cpoopc.cpmvp.mvp.base.BaseP;
import com.cpoopc.cpmvp.mvp.base.BaseV;

import java.util.ArrayList;
import java.util.List;


/**
 * mvp适配器
 * User: cpoopc
 * Date: 2015-12-11
 * Time: 10:15
 * Ver.: 0.1
 */
public abstract class BaseMVPAdapter<M, V extends View & BaseV<M>> extends BaseAdapter {

    private BaseP<M, V> presenter;
    protected List<M> itemList;

    public BaseMVPAdapter(BaseP<M, V> presenter) {
        if (presenter == null) {
            throw new NullPointerException("需要提供一个presenter");
        }
        this.presenter = presenter;
    }

    public BaseMVPAdapter(BaseP<M, V> presenter, List<M> itemList) {
        if (presenter == null) {
            throw new NullPointerException("需要提供一个presenter");
        }
        this.presenter = presenter;
        this.itemList = itemList;
    }

    public BaseP<M, V> getPresenter() {
        return presenter;
    }

    public List<M> getItems() {
        return itemList;
    }

    public void setItems(List<M> contacts) {
        this.itemList = contacts;
        notifyDataSetChanged();
    }

    public void addItem(M item) {
        if (this.itemList == null) {
            this.itemList = new ArrayList<>();
        }
        this.itemList.add(item);
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        if (itemList == null) {
            return 0;
        }
        return itemList.size();
    }

    @Override
    public M getItem(int position) {
        if (itemList == null || position > itemList.size() - 1) {
            return null;
        }
        return itemList.get(position);
    }


    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        V remindView = null;
        if (convertView != null) {
            remindView = (V) convertView;
        } else {
            remindView = createView();
        }
        M item = getItem(position);
        presenter.bindData(remindView, item);
        return remindView;
    }

    protected abstract V createView();

}
