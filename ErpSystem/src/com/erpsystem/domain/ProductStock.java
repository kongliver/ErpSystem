package com.erpsystem.domain;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @function   库存
 * @author     极客空
 * @date       2018年10月2日 下午3:11:57
 * @copyright  MR.Liu
 * @address    成都
 *
 *`psid` varchar(50) NOT NULL DEFAULT '',
  `productName` varchar(50) NOT NULL,
  `productCount` int(50) NOT NULL,
  `repertoryNum` int(50) NOT NULL,
  `productType` tinyint(10) NOT NULL,
 */
@Getter @Setter
public class ProductStock {

    /** 库存编号 */
    private String psid;
    /** 库存产品名 */
    private String productName;
    /** 库存产品数量 */
    private Integer productCount;
    /** 仓库编号 */
    private Integer repertoryNum;
    /** 库存产品类别   1：原材料       2：成品  */
    private Integer productType;
    
    public ProductStock() {}
    public ProductStock(String psid, String productName, Integer productCount, Integer repertoryNum,
            Integer productType) {
        super();
        this.psid = psid;
        this.productName = productName;
        this.productCount = productCount;
        this.repertoryNum = repertoryNum;
        this.productType = productType;
    }
    
    @Override
    public String toString() {
        return "ProductStock [psid=" + psid + ", productName=" + productName + ", productCount=" + productCount
                + ", repertoryNum=" + repertoryNum + ", productType=" + productType + "]";
    }
   
}
