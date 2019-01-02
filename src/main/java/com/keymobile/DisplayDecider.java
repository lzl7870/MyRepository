package com.keymobile;

import com.keymobile.model.tree.IRootTree;
import com.keymobile.serivce.IGetFullTreeService;
import com.keymobile.serivce.impl.GetFullTreeServiceImpl;

public class DisplayDecider {
    private int width;
    private int height;

    public DisplayDecider(int width, int height){
        this.width = width;
        this.height = height;
    }

    public void process(IRootTree rootTree){
        IGetFullTreeService fullTreeService = new GetFullTreeServiceImpl();
        System.out.println(fullTreeService.getFullTree(rootTree, width, height));
    }
}
