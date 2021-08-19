/**
  * Copyright 2021 json.cn 
  */
package pojo;
import java.util.Date;
import java.util.List;

/**
 * Auto-generated: 2021-08-19 23:32:58
 *
 * @author json.cn (i@json.cn)
 * @website http://www.json.cn/java2pojo/
 */
public class JsonRootBean {

    private String owner;
    private String tableName;
    private String operationType;
    private String columnNum;
    private String scn;
    private String seqid;
    private String tranid;
    private Date opTs;
    private Date loaderTime;
    private String rowid;
    private List<AfterColumnList> afterColumnList;
    private String ognTopic;
    private String ognPartition;
    private String ognOffset;
    private String sysCode;
    private Date dmgrProcessStartTime;
    private Date dmgrProcessEndTime;
    private String pkNames;
    private String pkValues;
    public void setOwner(String owner) {
         this.owner = owner;
     }
     public String getOwner() {
         return owner;
     }

    public void setTableName(String tableName) {
         this.tableName = tableName;
     }
     public String getTableName() {
         return tableName;
     }

    public void setOperationType(String operationType) {
         this.operationType = operationType;
     }
     public String getOperationType() {
         return operationType;
     }

    public void setColumnNum(String columnNum) {
         this.columnNum = columnNum;
     }
     public String getColumnNum() {
         return columnNum;
     }

    public void setScn(String scn) {
         this.scn = scn;
     }
     public String getScn() {
         return scn;
     }

    public void setSeqid(String seqid) {
         this.seqid = seqid;
     }
     public String getSeqid() {
         return seqid;
     }

    public void setTranid(String tranid) {
         this.tranid = tranid;
     }
     public String getTranid() {
         return tranid;
     }

    public void setOpTs(Date opTs) {
         this.opTs = opTs;
     }
     public Date getOpTs() {
         return opTs;
     }

    public void setLoaderTime(Date loaderTime) {
         this.loaderTime = loaderTime;
     }
     public Date getLoaderTime() {
         return loaderTime;
     }

    public void setRowid(String rowid) {
         this.rowid = rowid;
     }
     public String getRowid() {
         return rowid;
     }

    public void setAfterColumnList(List<AfterColumnList> afterColumnList) {
         this.afterColumnList = afterColumnList;
     }
     public List<AfterColumnList> getAfterColumnList() {
         return afterColumnList;
     }

    public void setOgnTopic(String ognTopic) {
         this.ognTopic = ognTopic;
     }
     public String getOgnTopic() {
         return ognTopic;
     }

    public void setOgnPartition(String ognPartition) {
         this.ognPartition = ognPartition;
     }
     public String getOgnPartition() {
         return ognPartition;
     }

    public void setOgnOffset(String ognOffset) {
         this.ognOffset = ognOffset;
     }
     public String getOgnOffset() {
         return ognOffset;
     }

    public void setSysCode(String sysCode) {
         this.sysCode = sysCode;
     }
     public String getSysCode() {
         return sysCode;
     }

    public void setDmgrProcessStartTime(Date dmgrProcessStartTime) {
         this.dmgrProcessStartTime = dmgrProcessStartTime;
     }
     public Date getDmgrProcessStartTime() {
         return dmgrProcessStartTime;
     }

    public void setDmgrProcessEndTime(Date dmgrProcessEndTime) {
         this.dmgrProcessEndTime = dmgrProcessEndTime;
     }
     public Date getDmgrProcessEndTime() {
         return dmgrProcessEndTime;
     }

    public void setPkNames(String pkNames) {
         this.pkNames = pkNames;
     }
     public String getPkNames() {
         return pkNames;
     }

    public void setPkValues(String pkValues) {
         this.pkValues = pkValues;
     }
     public String getPkValues() {
         return pkValues;
     }


    @Override
    public String toString() {
        return "JsonRootBean{" +
                "owner='" + owner + '\'' +
                ", tableName='" + tableName + '\'' +
                ", operationType='" + operationType + '\'' +
                ", columnNum='" + columnNum + '\'' +
                ", scn='" + scn + '\'' +
                ", seqid='" + seqid + '\'' +
                ", tranid='" + tranid + '\'' +
                ", opTs=" + opTs +
                ", loaderTime=" + loaderTime +
                ", rowid='" + rowid + '\'' +
                ", afterColumnList=" + afterColumnList +
                ", ognTopic='" + ognTopic + '\'' +
                ", ognPartition='" + ognPartition + '\'' +
                ", ognOffset='" + ognOffset + '\'' +
                ", sysCode='" + sysCode + '\'' +
                ", dmgrProcessStartTime=" + dmgrProcessStartTime +
                ", dmgrProcessEndTime=" + dmgrProcessEndTime +
                ", pkNames='" + pkNames + '\'' +
                ", pkValues='" + pkValues + '\'' +
                '}';
    }
}