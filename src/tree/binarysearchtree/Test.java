package tree.binarysearchtree;
import tree.binarysearchtree.BinarySortTree;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
//        758, 190, 672, 607, 884, 225, 425, 758, 514, 59
        BinarySortTree tree = new BinarySortTree();
        System.out.println(tree.getSize());
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add((int) (Math.random() * 1000));
        }

        for (Integer aList : list) {
            tree.insert(aList);
        }
        System.out.println(tree.getSize());

        System.out.println("原始序列：" + list);
        System.out.println("序列中的最小值：" + tree.searchMin());
        System.out.println("序列中的最大值：" + tree.searchMax());
        System.out.println("排序后的序列：" + tree.inorderTraversalC());
        System.out.println("序列大小：" + tree.getSize());

        for (Integer aList : list) {
            System.out.println("删除的元素是：" + aList);
            tree.delete(aList);
            System.out.println("删除后的序列：" + tree.inorderTraversalC());
            System.out.println("序列大小：" + tree.getSize());
        }
    }

}
