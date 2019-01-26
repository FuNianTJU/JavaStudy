package _异常_;

/**
 * 栈轨迹示例 2 
 * @author yan
 *
 */
public class MyClass {
	public static void main(String[] args) {
        crunch(null);
    }
    static void crunch(int[] a) {
        mash(a);
    }
    static void mash(int[] b) {
        System.out.println(b[0]);
    }

}
