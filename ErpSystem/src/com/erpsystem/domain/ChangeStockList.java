package com.erpsystem.domain;

/**
 * 
 * @function   库存异动类
 * @author     极客空
 * @date       2018年10月3日 上午11:04:12
 * @copyright  MR.Liu
 * @address    成都
 *
 *`chid` varchar(50) NOT NULL DEFAULT '',
  `psid` varchar(50) NOT NULL,
  `changeCount` int(20) NOT NULL,
  `oprTime` datetime NOT NULL,
  `oprPerson` varchar(50) NOT NULL,
  `oprType` tinyint(5) NOT NULL,
 */
public class ChangeStockList {

    /** 库存异动记录编号，uuid */
    private String chid;
    /** 库存品编号 */
    private String psid;
    /** 变化数量 */
    private Integer changeCount;
    /** 操作时间 */
    private String oprTime;
    /** 操作人 */
    private String oprPerson;
    /** 操作类型   1：入库    2：出库 */
    private Integer oprType;
    
    public ChangeStockList() {}
    public ChangeStockList(String chid, String psid, Integer changeCount, String oprTime, String oprPerson,
            Integer oprType) {
        super();
        this.chid = chid;
        this.psid = psid;
        this.changeCount = changeCount;
        this.oprTime = oprTime;
        this.oprPerson = oprPerson;
        this.oprType = oprType;
    }
    
    @Override
    public String toString() {
        return "ChangeStockList [chid=" + chid + ", psid=" + psid + ", changeCount=" + changeCount + ", oprTime="
                + oprTime + ", oprPerson=" + oprPerson + ", oprType=" + oprType + "]";
    }
    
    public String getChid() {
        return chid;
    }
    public void setChid(String chid) {
        this.chid = chid;
    }
    public String getPsid() {
        return psid;
    }
    public void setPsid(String psid) {
        this.psid = psid;
    }
    public Integer getChangeCount() {
        return changeCount;
    }
    public void setChangeCount(Integer changeCount) {
        this.changeCount = changeCount;
    }
    public String getOprTime() {
        return oprTime;
    }
    public void setOprTime(String oprTime) {
        this.oprTime = oprTime;
    }
    public String getOprPerson() {
        return oprPerson;
    }
    public void setOprPerson(String oprPerson) {
        this.oprPerson = oprPerson;
    }
    public Integer getOprType() {
        return oprType;
    }
    public void setOprType(Integer oprType) {
        this.oprType = oprType;
    }
    
}
