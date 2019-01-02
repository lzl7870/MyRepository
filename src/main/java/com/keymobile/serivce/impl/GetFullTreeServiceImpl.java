package com.keymobile.serivce.impl;

import com.keymobile.model.tree.IRootTree;
import com.keymobile.serivce.IGetFullTreeService;

import java.util.*;

public class GetFullTreeServiceImpl implements IGetFullTreeService {

    private static int LENGTH = 1;
    private static List<Integer> nodeSizeList = new ArrayList<>();//存放每个物品的重量(每个父节点所拥有子节点的个数)
    private static final boolean EXPANDED = true;//标记展开
    private static List<Integer> checkedNodeList;//选中的第几个物品

    @Override
    public IRootTree getFullTree(IRootTree rootTree, int width, int height) {
        return traverse(rootTree, width, height);
    }

    /**
     * 遍历树
     *
     * @param root
     * @return
     */
    private static IRootTree traverse(IRootTree root, int width, int height) {
        LENGTH = 1;
        List<IRootTree> childrenList = root.getChildrenList();
        childrenList.forEach(s -> LENGTH++);
        if (LENGTH > width) {
            //直接返回根节点
            return root;
        }
        root.setExpanded(EXPANDED);
        LENGTH--;
        int tempLength = LENGTH;
        root.setExpanded(EXPANDED);//标记展开
        //统计第三层长度，看看是否不超过width
        for (IRootTree secondaryTree : childrenList) {
            List<IRootTree> thirdTreeList = secondaryTree.getChildrenList();
            if(thirdTreeList != null && !thirdTreeList.isEmpty()){
                LENGTH += thirdTreeList.size() - 1;
            }
        }
        if(LENGTH > width){
            LENGTH = tempLength;
            //一个个展开
            tempLength = getBestLength(width, tempLength, childrenList);
        }else {//第三层全部展开都没超过width
            tempLength = LENGTH;//保存长度
            for (IRootTree secondaryTree : childrenList) {
                secondaryTree.setExpanded(EXPANDED);//标志展开
            }
        }
        //第四层循环
        for (IRootTree secondaryTree : childrenList) {
            //如果第二层有标志被展开
            if(secondaryTree.isExpanded()){
                List<IRootTree> thirdTreeList = secondaryTree.getChildrenList();
                tempLength = getBestLength(width, tempLength, thirdTreeList);
            }
        }
        System.out.println(LENGTH);
        return root;
    }

    private static int getBestLength(int width, int tempLength, List<IRootTree> childrenTreeList) {
        int num = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] weight = new int[1];
        //FIXME 其实weight和value相同，后期可以去掉，现在方便理解则用
        int[] value = new int[1];
        for (int i = 0; i < childrenTreeList.size(); i++) {
            IRootTree childrenTree = childrenTreeList.get(i);
            //遍历第三(四)层，分别存进数组
            List<IRootTree> grandchildrenTreeList = childrenTree.getChildrenList();
            if (grandchildrenTreeList != null && !grandchildrenTreeList.isEmpty()) {
                //设置第三(四)层数组对比
                int size = grandchildrenTreeList.size();
                nodeSizeList.add(size);
                weight = Arrays.copyOf(weight, num + 2);//扩容
                value = Arrays.copyOf(value, num + 2);//扩容
                weight[num + 1] = value[num + 1] = size;
                //如果第三层只有一个
                if (size == 1) {
                    childrenTree.setExpanded(EXPANDED);
                }
                map.put(num, i);
                num++;
            }
        }
        //如果有第四层
        if (!nodeSizeList.isEmpty()) {
            //选出最优解
            backPackQuestion(nodeSizeList.size(), width - LENGTH, weight, value);
            for (Integer number : checkedNodeList) {
                IRootTree grandchildrenTree = childrenTreeList.get(map.get(number - 1));//哪几个第二(三)节点被选中的,因为list组的是以1开始的
                LENGTH += (grandchildrenTree.getChildrenList().size() - 1);
                grandchildrenTree.setExpanded(EXPANDED);
            }
            tempLength = LENGTH;
            nodeSizeList = new ArrayList<>();
        }
        return tempLength;
    }
    /**
     * 01背包问题
     *
     * @param number   多少个物品
     * @param capacity 书包的容量
     */
    private static void backPackQuestion(int number, int capacity, int[] weight, int[] value) {
        checkedNodeList = new ArrayList<>();
        int[][] table = new int[number + 1][capacity + 1];
        int max = 0;
        int row = 0;//记录最后的i值
        int column = 0;//记录最后的j值
        for (int i = 1; i <= number; i++) {
            //如果重量为1，直接选中，因为重量1不占空间
            if(weight[i] == 1){
                checkedNodeList.add(i);
            }
            for (int j = 1; j <= capacity; j++) {
                //第一种情况，装不下，则把上一次的书包价值算成当前价值
                if (j < weight[i] - 1) {
                    table[i][j] = table[i - 1][j];
                    if (table[i][j] > max) {
                        max = table[i][j];
                        row = i;
                        column = j;
                    }
                } else {
                    //如果上次装的比较大，则不装
                    if (table[i - 1][j] > table[i - 1][j - (weight[i] - 1)] + value[i] - 1) {
                        table[i][j] = table[i - 1][j];
                        if (table[i][j] > max) {
                            max = table[i][j];
                            row = i;
                            column = j;
                        }
                    } else {
                        //否则就装进去
                        table[i][j] = table[i - 1][j - (weight[i] - 1)] + value[i] - 1;//减掉父节点
                        if (table[i][j] > max) {
                            max = table[i][j];
                            row = i;
                            column = j;
                        }
                    }
                }
            }
        }
        System.out.println("物品:" + row + "," + "容量:" + column);
        findWhat(row, column, table, weight, value);
        for (int i = 0; i <= number; i++) {
            for (int j = 0; j <= capacity; j++) {
                System.out.print(table[i][j]);
            }
            System.out.println();
        }
    }

    /**
     * 回溯遍历找出存进去的物品
     * @param i 第几个物品
     * @param j 背包容量
     * @param table 表格
     */
    private static void findWhat(int i, int j, int[][]table,int[] weight, int[] value) {
        if (i > 0) {
            if (j >= weight[i] - 1 && table[i - 1][j - (weight[i] - 1)] + value[i] - 1 == table[i][j]) {
                checkedNodeList.add(i);//记录起来
                findWhat(i - 1, j - (weight[i] - 1), table, weight, value);//回溯到上一个
            } else if (table[i - 1][j] == table[i][j]) {
                findWhat(i - 1, j, table, weight, value);
            }
        }
    }
}
