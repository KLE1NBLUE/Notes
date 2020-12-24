package com.zane.utils.Test;

import com.zane.utils.Cal;
import com.zane.utils.CalImpl;
import com.zane.utils.MyInvocationHandler;

public class Test {
    public static void main(String[] args) {
//        Cal cal = new CalImpl();
//        cal.add(1,1);
//        cal.div(1,1);
//        cal.mul(1,1);
//        cal.sub(1,1);
        Cal cal = new CalImpl();
        MyInvocationHandler myInvocationHandler = new MyInvocationHandler();
        Cal cal1 = (Cal) myInvocationHandler.bind(cal);
        cal1.add(1, 1);
        cal1.div(6, 2);
        cal1.mul(2, 3);
        cal1.sub(2, 1);

    }
}
