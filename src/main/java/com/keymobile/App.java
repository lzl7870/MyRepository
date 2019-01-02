package com.keymobile;

import com.keymobile.model.tree.TreeNode;
import com.keymobile.serivce.IGetFullTreeService;
import com.keymobile.serivce.impl.GetFullTreeServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Hello world!
 */
public class App {

    /**
     * 深度遍历树
     *
     * @return
     */
    public List<Object> depthFirstSearch(TreeNode root) {
        List<Object> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode tree = stack.pop();
            if (tree.getRight() != null) {
                stack.push(tree.getRight());
            }
            if (tree.getLeft() != null) {
                stack.push(tree.getLeft());
            }
            list.add(tree.getEle());//出栈了就放进list统计
        }
        return list;
    }


    public static void main(String[] args) {
        /*IGetFullTreeService fullTreeService = new GetFullTreeServiceImpl();
        System.out.println(fullTreeService.getFullTree(15, 4));*/
        //System.out.println(getFullTree(14));
        /*StringTokenizer stringTokenizer = new StringTokenizer("string(100)", "()");
        while (stringTokenizer.hasMoreTokens()) {
            System.out.println(stringTokenizer.nextToken());
        }*/
        /*String str = "100|66,55:200|567,90:102|43,54";

        StringTokenizer strToke = new StringTokenizer(str, "|");// 默认不打印分隔符
        // StringTokenizer strToke=new StringTokenizer(str,":,|",true);//打印分隔符
        // StringTokenizer strToke=new StringTokenizer(str,":,|",false);//不打印分隔符
        while (strToke.hasMoreTokens()) {
            System.out.println(strToke.nextToken());
        }*/
        /*List<Man> mans = new ArrayList<>();
        mans.add(new Man("001", "张三", Arrays.asList(new Card("工商银行", "9558800001"), new Card("工商银行", "9558800002"), new Card("建设银行", "6227001234"))));
        mans.add(new Man("002", "李四", Arrays.asList(new Card("招商银行", "6225800002"), new Card("建设银行", "6227035248"))));
        mans.add(new Man("003", "王五", Arrays.asList(new Card("建设银行", "6227056547"), new Card("中国银行", "6013832547"), new Card("民生银行", "4074058542"))));
        mans.add(new Man("004", "赵六", Arrays.asList(new Card("工商银行", "9558832458"), new Card("工商银行", "9558832547"), new Card("建设银行", "6227032578"))));
        mans.add(new Man("005", "孙七", Arrays.asList(new Card("中国银行", "6013825847"), new Card("农业银行", "6228836547"), new Card("招商银行", "6225014582"))));
        mans.add(new Man("006", "张三", Arrays.asList(new Card("工商银行", "9558832587"), new Card("交通银行", "6222814578"), new Card("工商银行", "9558865427"))));
        List<Card> cards = mans.stream().filter(m -> "张三".equals(m.getName())).flatMap(m -> m.getCards().stream())
                .collect(Collectors.toList());
        cards.forEach(System.out::println);*/
        //System.out.println(getGraph(20, 10));

        //System.out.println(backPackQuestion(6, 4));
        /*Sub s = new Sub();
        s.getObject();*/
        Integer i1 = 400;
        Integer i2 = 400;
        Integer i3 = 0;
        Integer i4 = new Integer(400);
        Integer i5 = new Integer(400);
        Integer i6 = new Integer(0);

        System.out.println("i1=i2\t" + (i1 == i2));
        System.out.println("i1=i2+i3\t" + (i1 == i2 + i3));//会自动拆箱，所以比较的是数值
        System.out.println("i4=i5\t" + (i4 == i5));
        System.out.println("i4=i5+i6\t" + (i4 == i5 + i6));//会自动拆箱，所以比较的是数值
    }
}
