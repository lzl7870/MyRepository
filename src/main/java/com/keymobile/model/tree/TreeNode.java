package com.keymobile.model.tree;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TreeNode {
    //左节点
    private TreeNode left;
    //右节点
    private TreeNode right;
    //元素
    private Object ele;

}
