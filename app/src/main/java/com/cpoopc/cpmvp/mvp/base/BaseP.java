package com.cpoopc.cpmvp.mvp.base;

import android.view.View;

/**
 *
 * @author cpoopc
 * Date: 2015-12-11
 * Time: 10:15
 * Ver.: 0.1
 */
public interface BaseP<M, V extends BaseV<M>> {

    class ViewEvent{
        public final static int onClick = 0x01;
        public final static int onLongClick = 0x02;
    }

    /**
     * 模型->视图
     * 解析模型,设置视图状态
     * @param view  view需要实现保存模型的方法
     * @param model 绑定到view的模型
     */
    void bindData(V view, M model);

    /**
     * 视图交互事件回调
     * @param mainView  视图本身
     * @param eventView 触发事件的子视图
     */
    void onViewClick(V mainView, View eventView);

    /**
     * 其他视图交互事件
     * @param eventType
     * @param mainView
     * @param eventView
     * @return
     */
    boolean onViewEvent(int eventType, V mainView, View eventView);

}
