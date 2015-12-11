package com.cpoopc.cpmvp.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.cpoopc.cpmvp.R;
import com.cpoopc.cpmvp.model.ItemBean;
import com.cpoopc.cpmvp.mvp.base.BaseP;
import com.cpoopc.cpmvp.mvp.base.BaseV;
import com.cpoopc.cpmvp.util.DebugLog;


/**
 * User: cpoopc
 * Date: 2015-12-11
 * Time: 18:20
 * Ver.: 0.1
 */
public class MvpTextItem<M> extends LinearLayout implements BaseV<M>, View.OnClickListener {

    private TextView mTvTitle;
    private ImageView mIvHead;

    private BaseP<M, MvpTextItem<M>> presenter;
    private M model;

    public void setPresenter(BaseP<M, MvpTextItem<M>> presenter) {
        this.presenter = presenter;
    }

    public MvpTextItem(Context context) {
        super(context);
        init(null, 0);
    }

    public MvpTextItem(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs, 0);
    }

    public MvpTextItem(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(attrs, defStyle);
    }

    private void init(AttributeSet attrs, int defStyle) {
        View layout = LayoutInflater.from(getContext()).inflate(R.layout.mvp_text_item, this);
        mTvTitle = (TextView) layout.findViewById(R.id.tv_title);
        mIvHead = (ImageView) layout.findViewById(R.id.iv_head);
        mTvTitle.setOnClickListener(this);
        mIvHead.setOnClickListener(this);
    }

    @Override
    public void setModel(M model) {
        this.model = model;
    }

    @Override
    public M getModel() {
        return model;
    }


    @Override
    public void onClick(View v) {
        if (presenter != null) {
            presenter.onViewClick(this, v);
        }
    }

    public static class MvpTextItemPresenter implements BaseP<String, MvpTextItem<String>> {
        @Override
        public void bindData(MvpTextItem<String> view, String model) {
            view.setModel(model);
            view.mTvTitle.setText(model);
        }

        @Override
        public void onViewClick(MvpTextItem<String> mainView, View eventView) {
            DebugLog.i(" " + mainView.getModel());
            if (eventView == mainView.mTvTitle) {
                DebugLog.i("点击标题");
                mainView.mTvTitle.setText("哈哈哈");
                mainView.setModel("哈哈哈");
            } else if (eventView == mainView.mIvHead) {
                DebugLog.i("点击图片");
                mainView.mTvTitle.setText("点击图片");
                mainView.setModel("点击图片");
            }
        }

        @Override
        public boolean onViewEvent(int eventType, MvpTextItem<String> mainView, View eventView) {
            return false;
        }
    }

    public static class MvpTextItemPresenter2 implements BaseP<ItemBean, MvpTextItem<ItemBean>> {
        @Override
        public void bindData(MvpTextItem<ItemBean> view, ItemBean model) {
            view.setModel(model);
            view.mTvTitle.setText(model.getTitle());
        }

        @Override
        public void onViewClick(MvpTextItem<ItemBean> mainView, View eventView) {
            DebugLog.i(" " + mainView.getModel());
            if (eventView == mainView.mTvTitle) {
                DebugLog.i("点击标题");
                mainView.mTvTitle.setText("哈哈哈");
                mainView.getModel().setTitle("哈哈哈");
            } else if (eventView == mainView.mIvHead) {
                DebugLog.i("点击图片");
                mainView.mTvTitle.setText("点击图片");
                mainView.getModel().setTitle("点击图片");
            }
        }

        @Override
        public boolean onViewEvent(int eventType, MvpTextItem<ItemBean> mainView, View eventView) {
            return false;
        }
    }

}
