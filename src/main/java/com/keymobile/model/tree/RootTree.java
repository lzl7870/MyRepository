package com.keymobile.model.tree;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RootTree {
    private String name;
    private List<RootTree> secondaryTreeList;
}
