package t树的遍历.TreeStructureInAndroidDev;

/**
 * 我们都知道在安卓系统里面，每个ViewGroup里面又会包含多个或者零个View,
 * 每一个View 或者 ViewGroup 都有一个整型的Id，那么每次我们在使用ViewGroup的findViewById(int id)的时候，
 * 我们是以什么方式来查找并返回在当前ViewGroup下面，我们要查找的View呢？
 * <p>
 * 请完成以下方法
 * <p>
 * //返回一个在 ViewGroup 下面的一个View，id 为方法的第二个参数
 * public static View find(ViewGroup vg, int id){
 * }
 * <p>
 * 可以使用的方法有:
 * 1.View -> getId() 返回一个int 的 id
 * 2.ViewGroup -> getChildCount() 返回一个int的孩子数量
 * 3. ViewGroup -> getChildAt(int index) 返回一个孩子，返回值为View。
 * <p>
 * 我们每个ViewGroup都可能有多个孩子，每个孩子既可能是ViewGroup，也可能只是View
 */
public class ViewGroupAndSubView {
    private static final int NO_ID = -1;

    public static View find(ViewGroup viewGroup, int id) {
        if (viewGroup == null || id == NO_ID) {
            return null;
        }
        //循环遍历所有的孩子
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            View child = viewGroup.getChildAt(i);
            if (child.getId() == id) {
                return child;
            }
            //如果当前孩子id不同，但是是一个ViewGroup，那么我们递归往下找
            if (child instanceof ViewGroup) {
                View v = find((ViewGroup) child, id);
                if (v != null) {
                    return v;
                }
            }
        }
        return null;
    }
}

@Deprecated
class View {
    int getId() {
        return 1;
    }
}
@Deprecated
class ViewGroup extends View {
    int getChildCount() {
        return 1;
    }

    View getChildAt(int index) {
        return new View();
    }
}