package com.keymobile.serivce;

import com.keymobile.model.tree.IRootTree;

/**
 * 获取全部展开最大的树
 */
public interface IGetFullTreeService {
    IRootTree getFullTree(IRootTree rootTree, int width, int height);
}
