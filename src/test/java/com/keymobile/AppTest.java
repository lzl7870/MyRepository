package com.keymobile;

import static org.junit.Assert.assertTrue;

import com.keymobile.model.tree.IRootTree;
import com.keymobile.model.tree.impl.RootTreeImpl;
import com.keymobile.serivce.IGetFullTreeService;
import com.keymobile.serivce.impl.GetFullTreeServiceImpl;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

/**
 * Unit test for simple App.
 */
public class AppTest {
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() {
        assertTrue(true);
    }

    @Test
    public void test() {
        String path = "F:/cellDataRings.txt";
        InputStreamReader isr = null;
        BufferedReader br = null;
        try {
            File file = new File(path);
            System.out.println(file.exists());
            isr = new InputStreamReader(new FileInputStream(file), "UTF-8");
            br = new BufferedReader(isr);
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testTree(){
        RootTreeImpl rootTree = new RootTreeImpl();
        rootTree.setName("数据中心数据地图");
        IRootTree secondaryTree1 = new RootTreeImpl();
        secondaryTree1.setName("核能");
        IRootTree secondaryTree2 = new RootTreeImpl();
        secondaryTree2.setName("新能源");
        IRootTree secondaryTree3 = new RootTreeImpl();
        secondaryTree3.setName("金融");
        IRootTree secondaryTree4 = new RootTreeImpl();
        secondaryTree4.setName("核燃料");
        IRootTree secondaryTree5 = new RootTreeImpl();
        secondaryTree5.setName("公共");
        IRootTree thirdTree1 = new RootTreeImpl();
        thirdTree1.setName("设计");
        IRootTree thirdTree2 = new RootTreeImpl();
        thirdTree2.setName("研发");
        IRootTree thirdTree3 = new RootTreeImpl();
        thirdTree3.setName("建设");
        IRootTree thirdTree4 = new RootTreeImpl();
        thirdTree4.setName("运营");
        IRootTree thirdTree5 = new RootTreeImpl();
        thirdTree5.setName("延寿");
        IRootTree thirdTree6 = new RootTreeImpl();
        thirdTree6.setName("退役");
        secondaryTree1.setChildrenList(Arrays.asList(thirdTree1, thirdTree2, thirdTree3, thirdTree4,
                thirdTree5, thirdTree6));
        IRootTree fourthTree1 = new RootTreeImpl();
        fourthTree1.setName("设计管理");
        IRootTree fourthTree2 = new RootTreeImpl();
        fourthTree2.setName("协同设计");
        thirdTree1.setChildrenList(Arrays.asList(fourthTree1, fourthTree2));
        IRootTree fourthTree3 = new RootTreeImpl();
        fourthTree3.setName("项目管理");
        IRootTree fourthTree4 = new RootTreeImpl();
        fourthTree4.setName("技术服务");
        IRootTree fourthTree5 = new RootTreeImpl();
        fourthTree5.setName("高端设备供货");
        IRootTree fourthTree6 = new RootTreeImpl();
        fourthTree6.setName("科技研发");
        thirdTree2.setChildrenList(Arrays.asList(fourthTree3, fourthTree4, fourthTree5, fourthTree6));
        IRootTree fourthTree7 = new RootTreeImpl();
        fourthTree7.setName("项目管理");
        IRootTree fourthTree8 = new RootTreeImpl();
        fourthTree8.setName("调试管理");
        IRootTree fourthTree9 = new RootTreeImpl();
        fourthTree9.setName("施工管理");
        IRootTree fourthTree10 = new RootTreeImpl();
        fourthTree10.setName("材料与采购管理");
        thirdTree3.setChildrenList(Arrays.asList(fourthTree7, fourthTree8, fourthTree9, fourthTree10));
        IRootTree fourthTree11 = new RootTreeImpl();
        fourthTree11.setName("生产准备");
        IRootTree fourthTree12 = new RootTreeImpl();
        fourthTree12.setName("生产管理");
        IRootTree fourthTree13 = new RootTreeImpl();
        fourthTree13.setName("培训管理");
        IRootTree fourthTree14 = new RootTreeImpl();
        fourthTree14.setName("安全管理");
        IRootTree fourthTree15 = new RootTreeImpl();
        fourthTree15.setName("技术管理");
        IRootTree fourthTree16 = new RootTreeImpl();
        fourthTree16.setName("维修管理");
        thirdTree4.setChildrenList(Arrays.asList(fourthTree11, fourthTree12, fourthTree13, fourthTree14,
                fourthTree15, fourthTree16));
        IRootTree fourthTree17 = new RootTreeImpl();
        fourthTree17.setName("其他");
        thirdTree5.setChildrenList(Collections.singletonList(fourthTree17));
        IRootTree fourthTree18 = new RootTreeImpl();
        fourthTree18.setName("其他");
        thirdTree6.setChildrenList(Collections.singletonList(fourthTree18));
        IRootTree thirdTree7 = new RootTreeImpl();
        thirdTree7.setName("设备");
        secondaryTree4.setChildrenList(Collections.singletonList(thirdTree7));
        IRootTree thirdTree8 = new RootTreeImpl();
        thirdTree8.setName("公司治理");
        IRootTree thirdTree9 = new RootTreeImpl();
        thirdTree9.setName("战略管理");
        IRootTree thirdTree10 = new RootTreeImpl();
        thirdTree10.setName("公司营运管理");
        IRootTree thirdTree11 = new RootTreeImpl();
        thirdTree11.setName("科研管理");
        IRootTree thirdTree12 = new RootTreeImpl();
        thirdTree12.setName("市场开发与销售管理");
        IRootTree thirdTree13 = new RootTreeImpl();
        thirdTree13.setName("安质环管理");
        IRootTree thirdTree14 = new RootTreeImpl();
        thirdTree14.setName("资产经营管理");
        IRootTree thirdTree15 = new RootTreeImpl();
        thirdTree15.setName("人力资源管理");
        IRootTree thirdTree16 = new RootTreeImpl();
        thirdTree16.setName("党委及干部管理");
        IRootTree thirdTree17 = new RootTreeImpl();
        thirdTree17.setName("企业文化官管理");
        IRootTree thirdTree18 = new RootTreeImpl();
        thirdTree18.setName("财务管理");
        IRootTree thirdTree19 = new RootTreeImpl();
        thirdTree19.setName("审计监察巡视管理");
        IRootTree thirdTree20 = new RootTreeImpl();
        thirdTree20.setName("行政综合管理");
        IRootTree thirdTree21 = new RootTreeImpl();
        thirdTree21.setName("公共关系管理");
        IRootTree thirdTree22 = new RootTreeImpl();
        thirdTree22.setName("品牌与宣传");
        IRootTree thirdTree23 = new RootTreeImpl();
        thirdTree23.setName("信息化管理");
        IRootTree thirdTree24 = new RootTreeImpl();
        thirdTree24.setName("法律事务管理");
        IRootTree thirdTree25 = new RootTreeImpl();
        thirdTree25.setName("企业培训管理");
        IRootTree thirdTree26 = new RootTreeImpl();
        thirdTree26.setName("党群管理");
        secondaryTree5.setChildrenList(Arrays.asList(thirdTree8, thirdTree9, thirdTree10, thirdTree11,
                thirdTree12, thirdTree13, thirdTree14, thirdTree15, thirdTree16, thirdTree17, thirdTree18,
                thirdTree19, thirdTree20, thirdTree21, thirdTree22, thirdTree23, thirdTree24, thirdTree25, thirdTree26));
        //往第二层加元素
        rootTree.setChildrenList(Arrays.asList(secondaryTree1, secondaryTree2, secondaryTree3, secondaryTree4, secondaryTree5));
        new DisplayDecider(14, 4).process(rootTree);
    }

}
