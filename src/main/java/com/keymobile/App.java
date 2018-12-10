package com.keymobile;

import com.keymobile.model.Card;
import com.keymobile.model.Man;
import com.keymobile.model.Sub;
import com.keymobile.model.tree.FourthTree;
import com.keymobile.model.tree.RootTree;
import com.keymobile.model.tree.SecondaryTree;
import com.keymobile.model.tree.ThirdTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

/**
 * Hello world!
 */
public class App {
    private static int LENGTH = 1;
    public static String getGraph(int length, int width) {
        StringBuilder sb = new StringBuilder(80);

        for (int i = 0; i < length; i++) {
            sb.append("*");
        }
        for (int w = 1; w < width - 1; w++) {
            sb.append("\n").append("*");
            for (int i = 1; i < length - 1; i++) {
                sb.append(" ");
            }
            sb.append("*");
        }
        sb.append("\n");
        for (int i = 0; i < length; i++) {
            sb.append("*");
        }
        return sb.toString();
    }
    public static RootTree getFullTree(int length, int width){
        RootTree rootTree = new RootTree();
        rootTree.setName("第一层1");
        RootTree secondaryTree = new RootTree();
        RootTree secondaryTree1 = new RootTree();
        secondaryTree1.setName("第二层2");
        secondaryTree.setName("第二层1");
        RootTree thirdTree = new RootTree();
        RootTree thirdTree2 = new RootTree();
        secondaryTree.setSecondaryTreeList(Arrays.asList(thirdTree, thirdTree2));
        thirdTree.setName("第三层1");
        RootTree fourthTree1 = new RootTree();
        fourthTree1.setName("第四层1");
        RootTree fourthTree2 = new RootTree();
        fourthTree2.setName("第四层2");
        thirdTree.setSecondaryTreeList(Arrays.asList(fourthTree1, fourthTree2));
        thirdTree2.setName("第三层2");
        RootTree fourthTree3 = new RootTree();
        fourthTree3.setName("第四层3");
        RootTree fourthTree4 = new RootTree();
        fourthTree4.setName("第四层4");
        thirdTree2.setSecondaryTreeList(Arrays.asList(fourthTree3, fourthTree4));
        RootTree thirdTree3 = new RootTree();
        thirdTree3.setName("第三层3");
        secondaryTree1.setSecondaryTreeList(Arrays.asList(thirdTree3));
        //往第二层加元素
        rootTree.setSecondaryTreeList(Arrays.asList(secondaryTree,secondaryTree1));
        traverse(rootTree.getSecondaryTreeList());
        return null;
    }

    /**
     * 遍历list
     * @param list
     * @return
     */
    public static void traverse(List<? extends RootTree> list){
        for (RootTree secondaryTree : list) {
            System.out.println(secondaryTree.getName());
            LENGTH++;
            List<RootTree> thirdTreeList = secondaryTree.getSecondaryTreeList();
            if(thirdTreeList != null && !thirdTreeList.isEmpty()){
                traverse(thirdTreeList);
            }
        }
        System.out.println(LENGTH);
    }
    public static void main(String[] args) {
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
        getFullTree(0,0);
    }
}
