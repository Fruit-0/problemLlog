package com.design.singleton;

/**
 * @version 1.0.0
 * @项目名称：单例模式-懒汉模式
 * @类名称：
 * @类描述：
 * @功能描述：
 * @author：FRUIT
 * @创建时间：2022/1/25 0:03
 * @修改备注
 * @修改记录： 修改时间 修改人员 修改原因
 * --------------------------------------------------
 */
public class SingletonLazy {
    //默认不会实例化，什么时候用就什么时候new
    private static SingletonLazy singletonLazy = null;

    public SingletonLazy() {
    }

    public static synchronized SingletonLazy getInstance(){
        //什么时候用就什么时候new
        if (singletonLazy ==null){
            singletonLazy = new SingletonLazy();
        }
        return singletonLazy;
    }
}
