package com.keymobile.model.tree.impl;

import com.keymobile.model.tree.IRootTree;

import java.util.List;

public class RootTreeImpl implements IRootTree {
    private String name;
    private List<IRootTree> childrenList;
    private boolean expanded;
    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setChildrenList(List<IRootTree> childrenList) {
        this.childrenList = childrenList;
    }

    @Override
    public List<IRootTree> getChildrenList() {
        return childrenList;
    }

    @Override
    public void setExpanded(boolean expanded) {
        this.expanded = expanded;
    }

    @Override
    public boolean isExpanded() {
        return expanded;
    }

    @Override
    public String toString() {
        return "RootTreeImpl{" +
                "name='" + name + '\'' +
                ", childrenList=" + childrenList +
                ", expanded=" + expanded +
                '}';
    }
}
