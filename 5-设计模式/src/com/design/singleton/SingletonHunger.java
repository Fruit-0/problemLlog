package com.design.singleton;

/**
 * @version 1.0.0
 * @项目名称：
 * @类名称：单例模式-饿汉式
 * @类描述：
 * @功能描述：
 * @author：FRUIT
 * @创建时间：2022/1/25 0:07
 * @修改备注
 * @修改记录： 修改时间 修改人员 修改原因
 * --------------------------------------------------
 */
public class SingletonHunger {
    //一开始类加载的时候就实例化，创建单实例对象
    private static SingletonHunger singletonHunger = new SingletonHunger();

    public SingletonHunger() {

    }
    public static SingletonHunger getInstance(){
        return singletonHunger;
    }

}
