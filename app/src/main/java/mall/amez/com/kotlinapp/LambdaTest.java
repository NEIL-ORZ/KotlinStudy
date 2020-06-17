package mall.amez.com.kotlinapp;

import android.util.Log;

/**
 * @USER NEIL.Z
 * @TIME 2020/4/2 13:58
 * @DESC
 */
public class LambdaTest {

    public void test() {
        Test1 test1 = () -> 5;// 1. 不需要参数,
        Test2 test2 = x -> x * 5;// 2. 接收一个参数(数字类型),返回
        Test3 test3 = (x, y) -> x * y;// 3. 接受2个参数(数字),并返回
        Test4 test4 = () -> Log.e("zh", "print");
    }

    interface Test1 {
        int test1();
    }

    interface Test2 {
        int test2(int a);
    }

    interface Test3 {
        int test3(int a, int b);
    }

    interface Test4 {
        void test4();
    }

    public interface Test5 {
        void test5(int a);
    }
}
