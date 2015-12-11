package com.cpoopc.cpmvp.mvp.base;

/**
 * User: cpoopc
 * Date: 2015-12-11
 * Time: 10:15
 * Ver.: 0.1
 */
public interface BaseV<M> {

    /**
     * 保存模型
     * @param model
     */
    void setModel(M model);

    /**
     * 获取模型
     * @return
     */
    M getModel();

}
