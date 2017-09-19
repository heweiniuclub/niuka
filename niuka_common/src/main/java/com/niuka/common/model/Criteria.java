package com.niuka.common.model;

import java.text.SimpleDateFormat;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.niuka.common.util.StringUtils;

/**
 * 公用条件查询类
 */
public class Criteria {
    private long currentPage = 1;    // 当前页
    private long totalCount  = 0;    // 总行数
    private long pageSize    = 0;    // 页大小

    /**
     * 存放条件查询值
     */
    private Map<String, Object> condition;

    /**
     * 是否相异
     */
    protected boolean distinct;

    /**
     * 排序字段
     */
    protected String orderByClause;

    /**
     * 分页字段
     */
    protected String limitClause;

    /**
     * 范围条件
     *
     * @param example
     */
    protected String betweenClause;

    /**
     * in条件的查询
     */
    protected String inCondition;

    /**
     * like 模糊查询
     */
    protected String likeCondition;

    /**
     * not in 模糊查询
     */
    protected String notInCondition;

    public Criteria() {
        condition = new HashMap<String, Object>();
    }

    protected Criteria(Criteria example) {
        this.orderByClause = example.orderByClause;
        this.condition     = example.condition;
        this.distinct      = example.distinct;
        this.limitClause   = example.limitClause;
        this.betweenClause = example.betweenClause;
    }

    public void clear() {
        condition.clear();
        orderByClause  = null;
        distinct       = false;
        limitClause    = null;
        betweenClause  = null;
        inCondition    = null;
        likeCondition  = null;
        notInCondition = null;
    }

    /**
     * @param condition 查询的条件名称
     * @param value     查询的值
     */
    public Criteria put(String condition, Object value) {
        this.condition.put(condition, value);

        return this;
    }

    public String getBetweenClause() {
        return betweenClause;
    }

    public void setBetweenClause(String beginClause, String endClause, int fieldType, String field) {
        if (fieldType == 1) {    // 时间范围的条件查询
            if ((beginClause == null) || beginClause.equals("")) {
                beginClause = "2016-01-01";
            }

            if ((endClause == null) || endClause.equals("")) {
                SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
                Calendar         c  = Calendar.getInstance();

                c.add(Calendar.DAY_OF_MONTH, 1);
                endClause = sf.format(c.getTime());
            }

            this.betweenClause = "and DATE_FORMAT(" + field + ",'%Y-%m-%d') >= '" + beginClause + "' and DATE_FORMAT("
                                 + field + ",'%Y-%m-%d') <= '" + endClause + "'";
        } else if (fieldType == 2) {    // 普通字段的范围条件查询
            String totalCondition = "";
            String beginCondition = "and " + field + ">= " + beginClause;
            String endCondition   = " and " + field + "<= " + endClause;

            if ((beginClause != null) &&!beginClause.equals("")) {
                totalCondition = beginCondition;
            }

            if ((endClause != null) &&!endClause.equals("")) {
                totalCondition += endCondition;
            }

            this.betweenClause = totalCondition;
        }
    }

    public Map<String, Object> getCondition() {
        return condition;
    }

    public void setCondition(Map<String, Object> condition) {
        this.condition = condition;
    }

    public long getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(long currentPage) {
        this.currentPage = currentPage;
    }

    /**
     * @param distinct 是否相异
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public String getInCondition() {
        return inCondition;
    }

    public void setInCondition(String field, List<Object> data) {
        if ((data != null) && (data.size() > 0)) {
            String str = "";

            for (int i = 0; i < data.size(); i++) {
                Object o = data.get(i);

                str += o;
                str += ",";

                if (i == data.size() - 1) {
                    break;
                }
            }

            str              = str.substring(0, str.length() - 1);
            this.inCondition = "and " + field + " in (" + str + ")";
        } else {
            this.inCondition = "";
        }
    }

    /**
     * in条件
     * 2016-10-17 11:59:20 lf
     * @param field
     * @param objs
     */
    public void setInCondition(String field, Object... objs) {
        if (StringUtils.isBlank(field)) {
            this.inCondition = "";
        } else {
            StringBuilder inStr = new StringBuilder();

            for (Object obj : objs) {
                inStr.append(obj).append(",");
            }

            String substring = inStr.substring(0, inStr.length() - 1);

            setInCondition(field, substring);
        }
    }

    /**
     * in条件
     * 2016-10-17 11:59:20 lf
     * @param field
     * @param inStr
     */
    public void setInCondition(String field, String inStr) {
        if (StringUtils.isBlank(inStr) || StringUtils.isBlank(field)) {
            this.inCondition = "";
        } else {
            this.inCondition = "and " + field + " in (" + inStr + ")";
        }
    }

    public String getLikeCondition() {
        return likeCondition;
    }

    public void setLikeCondition(String likeCondition) {
        this.likeCondition = likeCondition;

//      if(data!=null&&!data.equals("")){
//              this.likeCondition = "and "+field+" like '%"+data+"%'";
//      }else{
//              this.likeCondition = null;
//      }
    }

    public String getLimitClause() {
        if (pageSize == 0) {
            return "";
        }

        long pageOffset = (this.currentPage - 1) * this.pageSize;

        limitClause = " limit " + pageOffset + "," + pageSize;

        return limitClause;
    }

    public void setLimitClause(int pageOffset, int pageSize) {
        this.limitClause = " limit " + pageOffset + "," + pageSize;
    }

    public String getNotInCondition() {
        return notInCondition;
    }

    public void setNotInCondition(String field, List<Object> data) {
        if ((data != null) && (data.size() > 0)) {
            String str = "";

            for (int i = 0; i < data.size(); i++) {
                Object o = data.get(i);

                str += o;
                str += ",";

                if (i == data.size() - 1) {
                    break;
                }
            }

            str                 = str.substring(0, str.length() - 1);
            this.notInCondition = "and " + field + " not in (" + str + ")";
        } else {
            this.notInCondition = "";
        }
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * @param orderByClause 排序字段
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public long getPageSize() {
        return pageSize;
    }

    public void setPageSize(long pageSize) {
        this.pageSize = pageSize;
    }

    /**
     * 得到总行数
     */
    public long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(long totalCount) {
        this.totalCount = totalCount;
    }

    /**
     * 得到总页数
     *
     * @return
     */
    public long getTotalPage() {
        long pageCount = this.totalCount / this.pageSize + 1;

        // 如果模板==0，且总数大于1，则减一
        if ((this.totalCount % this.pageSize == 0) && (pageCount > 1)) {
            pageCount--;
        }

        return pageCount;
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
