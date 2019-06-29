package com.ykf.suanfa.test;

/**
 * 描述:
 *
 * @author yukaifei
 * @create 2019-01-24 20:41
 */
public class Single {
    private Single() {
    }
    private static class Instance{
        private static Single single = new Single();
    }
    public static Single getInstance(){
        return  Instance.single;
    }
}

