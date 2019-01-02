package com.keymobile.model.tree;

import java.util.List;

public interface IRootTree {
    void setName(String name);
    
    void setChildrenList(List<IRootTree> childrenList);

    List<IRootTree> getChildrenList();

    void setExpanded(boolean expanded);

    boolean isExpanded();
}
