package com.niuka.common.service.mybatis.impl;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import com.niuka.common.constant.Constant;
import com.niuka.common.dao.mybatis.Dao;
import com.niuka.common.exception.DaoException;
import com.niuka.common.exception.ServiceException;
import com.niuka.common.model.ExtendMap;
import com.niuka.common.model.Pagination;
import com.niuka.common.model.PersistentObject;
import com.niuka.common.service.mybatis.Service;
import com.niuka.common.util.Common;
import com.niuka.common.util.ValidateUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;



/**
 * Service基类，实现了数据的CRUD
 * 
 * @param <DAO>
 * @param <T>
 * @param <ID>
 * @author hewei
 */
public abstract class ServiceImpl<DAO extends Dao<T, ID>, T extends PersistentObject, ID extends Serializable>
		implements Service<T, ID> {

	public static final Logger LOGGER = LoggerFactory.getLogger(ServiceImpl.class);
	

	/**
	 * 由子类注入实体DAO
	 */
	protected DAO dao;

	public abstract void setDao(DAO dao);

	/**
	 * 查询所有分页
	 * 
	 * @param p
	 * @return
	 */
	public Pagination<T> findByAllPagination(Pagination<T> p) {
		dao.findByAll(p);
		return p;
	}

	/**
	 * 通过主键查询实体
	 * 
	 * @param PK
	 *            pk
	 * @return T
	 */
	public T get(ID pk) {
		return dao.get(pk);
	}

	/**
	 * 通过主键集合查询实体
	 * 
	 * @param List
	 *            <PK> pks
	 * @return List<T>
	 */
	public List<T> get(Collection<ID> pks) {
		List<T> list = new ArrayList<T>(pks.size());
		for (ID pk : pks) {
			list.add(get(pk));
		}
		return list;
	}

	/**
	 * 插入/更新实体
	 * 
	 * @param T
	 *            t
	 * 
	 */
	public void save(T t) {
		if (t.getId() == null) {
			dao.insert(t);
		}
		else {
			dao.update(t);
		}
	}

	/**
	 * 插入/更新实体集合
	 * 
	 * @param List
	 *            <T> ts
	 */
	public void save(Collection<T> ts) {
		for (T t : ts) {
			save(t);
		}
	}

	/**
	 * 更新实体
	 * 
	 * @param T
	 *            t
	 */
	public void update(T t) {
		verifyRows(dao.update(t), 1, "数据库更新失败");
	}

	/**
	 * 更新实体集合
	 * 
	 * @param List
	 *            <T> ts
	 */
	public void update(Collection<T> ts) {
		for (T t : ts) {
			update(t);
		}
	}

	/**
	 * 删除实体
	 * 
	 * @param T
	 *            t
	 */
	@SuppressWarnings("unchecked")
	public void delete(T t) {
		deleteById((ID) t.getId());
	}

	/**
	 * 删除实体集合
	 * 
	 * @param List
	 *            <T> ts
	 */
	public void delete(Collection<T> ts) {
		for (T t : ts) {
			delete(t);
		}
	}

	/**
	 * 通过主键删除实体
	 * 
	 * @param PK
	 *            pk
	 * @return T
	 */
	public void deleteById(ID id) {
		deleteById(Arrays.asList(id));
	}

	/**
	 * 通过主键集合删除实体 注：这里别把List改为Collection，会导致覆盖方法的List<ID>调用不到
	 * 
	 * @param List
	 *            <PK> pks
	 * @return List<T>
	 */
	public void deleteById(List<ID> idList) {
		verifyRows(dao.deleteById(idList), idList.size(), "数据库删除失败");
	}

	/**
	 * 为高并发环境出现的更新和删除操作，验证更新数据库记录条数
	 * 
	 * @param updateRows
	 * @param rows
	 * @param message
	 */
	protected void verifyRows(int updateRows, int rows, String message) {
		if (updateRows != rows) {
			DaoException e = new DaoException(message);
			LOGGER.error("need update is {}, but real update rows is {}.", rows, updateRows, e);
			throw e;
		}
	}
	
	
	
	
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	
    /**
     * 输出错误
     *
     * @param result 结果
     * @param msg
     */
    protected void outError(Map<String, Object> result, String msg) {
        if (result == null) {
            return;
        }
        result.put(Constant.MSG_STATUS, Constant.MSG_ERROR_STATUS);
        result.put(Constant.MSG_MSG, msg);
    }

    /**
     * 输出成功
     *
     * @param result 结果
     * @param obj
     */
    protected void outSuccess(Map<String, Object> result, Object obj) {
        if (result == null) {
            return;
        }
        result.put(Constant.MSG_STATUS, Constant.MSG_SUCCESS_CODE);
        result.put(Constant.MSG_MSG, Constant.MSG_SUCCESS);
        result.put(Constant.MSG_RESULT, obj);
    }

    /**
     * 输出成功 空结果
     *
     * @param result 结果
     */
    protected void outSuccess(Map<String, Object> result) {
        outSuccess(result, null);
    }

    /**
     * 参数为空
     *
     * @param result 结果
     */
    protected void outParamEmptyError(Map<String, Object> result) {
        outError(result, Constant.PARAM_IS_NOT_EMPTY);
    }

    /**
     * 获取当前时间和日期
     *
     * @return
     */
    protected Timestamp getNowDateTime() {
        return new Timestamp(System.currentTimeMillis());
    }
    
    /**
     * 获取当前日期
     *
     * @return
     */
    protected Date getNowDate() {
        return new Date(System.currentTimeMillis());
    }

    /**
     * 检查id不能小于0
     * 抛出异常方便回滚
     * 2016-9-7 09:56:39
     * lf
     *
     * @param id
     */
    protected void checkIdException(Integer id) {
        if (id == null || id <= 0) {
            throw new ServiceException();
        }
    }

    /**
     * 检查参数不能为空
     * 2016-9-13 17:11:59
     * lf
     *
     * @param params 参数
     * @param result
     * @return
     */
    protected boolean checkParams(ExtendMap<String, Object> params, Map<String, Object> result) {
        // 检查参数
        if (CollectionUtils.isEmpty(params)) {
            //参数为空
            outParamEmptyError(result);
            return true;
        }
        return false;
    }

    /**
     * 检查会员id
     * 2016-9-13 17:15:36
     * lf
     *
     * @param result
     * @param personalId 会员id
     * @return
     */
    protected boolean checkPersonalId(Map<String, Object> result, String personalId) {
        if (!ValidateUtils.isUnsignedInteger(personalId)) {
            //参数为空
            outParamEmptyError(result);
            return true;
        }
        return false;
    }


//    /**
//     * 获取分页数据
//     * 2016-9-14 11:24:28
//     * lf
//     *
//     * @param params
//     */
//    protected Page getPage(ExtendMap<String, Object> params) {
//        // 检查参数
//        if (CollectionUtils.isEmpty(params)) {
//            return new Page(1, Constant.PAGE_SIZE);
//        }
//        // 获取分页数据
//        Integer pageSize = params.getInt("pageSize");
//        Integer curPage = params.getInt("curPage");
//        if (curPage == null || curPage <= 0) {
//            curPage = 1;
//        }
//        if (pageSize == null || pageSize <= 0) {
//            pageSize = Constant.PAGE_SIZE;
//        }
//        return new Page(curPage, pageSize);
//    }
//
//
//    /**
//     * 设置条件的分页
//     * 2016-9-14 11:24:35
//     * lf
//     *
//     * @param page
//     * @param criteria
//     * @param count    总条数
//     */
//    protected void setCriteriaPage(Page page, Criteria criteria, int count) {
//        if (page == null) {
//            page = new Page(1, Constant.PAGE_SIZE);
//        }
//        page.setTotalItem(count);
//        criteria.setCurrentPage(page.getCurPage());
//        criteria.setPageSize(page.getPageSize());
//    }

    /**
     * 处理结果中的日期
     * 转换为字符串
     * 2016-9-14 14:15:41
     * lf
     *
     * @param result
     */
    protected void formatDateTime(List<Map<String, Object>> result) {
        if (!CollectionUtils.isEmpty(result)) {
            for (Map<String, Object> map : result) {
                formatDateTime(map);
            }
        }
    }

    /**
     * 处理结果中的日期
     * 转换为字符串
     * 2016-9-14 14:36:22
     * lf
     *
     * @param map
     */
    protected void formatDateTime(Map<String, Object> map) {
        if (!CollectionUtils.isEmpty(map)) {
            for (String k : map.keySet()) {
                Object o = map.get(k);
                if (o instanceof java.util.Date) {
                    java.util.Date date = (java.util.Date) o;
                    map.put(k, Common.dateTimeFormat(date));
                }
            }
        }
    }

    /**
     * 将list转换为字符串
     * 2016-9-18 09:47:13
     * lf
     *
     * @param typeids
     * @param split
     * @param <T>
     * @return
     */
    protected <T> String listToString(List<T> typeids, String split) {
        StringBuilder inStr = new StringBuilder();
        if (!CollectionUtils.isEmpty(typeids)) {
            for (T t : typeids) {
                inStr.append(t).append(split);
            }
        } else {
            return "";
        }
        return inStr.substring(0, inStr.length() - 1);
    }

    /**
     * 将字符串数组转换为字符串
     * 2016-9-18 09:47:13
     * lf
     *
     * @param ids
     * @param split
     * @return
     */
    protected String arrayToString(String[] ids, String split) {
        StringBuilder inStr = new StringBuilder();
        if (!ArrayUtils.isEmpty(ids)) {
            for (String str : ids) {
                inStr.append(str).append(split);
            }
        } else {
            return "";
        }
        return inStr.substring(0, inStr.length() - 1);
    }

    /**
     * 将字符串数组转换为字符串
     * 2016-9-18 17:54:00
     * lf
     *
     * @param ids
     * @return
     */
    protected String arrayToString(String[] ids) {
        return arrayToString(ids, ",");
    }


    /**
     * 将list转换为字符串
     * 使用“，”个隔开
     * 2016-9-18 09:47:19
     * lf
     *
     * @param typeids
     * @param <T>
     * @return
     */
    protected <T> String listToString(List<T> typeids) {
        return listToString(typeids, ",");
    }


    /**
     * 查询数据检查
     *
     * @param result
     * @param count
     * @return
     */
    protected boolean checkCount(Map<String, Object> result, int count) {
        if (count <= 0) {
            outSuccess(result, "没有数据！");
            return true;
        }
        return false;
    }

    /**
     * 查询数字
     *
     * @param result
     * @param num
     * @return
     */
    protected boolean checkNum(Map<String, Object> result, int num) {
        if (num <= 0) {
            outParamEmptyError(result);
            return true;
        }
        return false;
    }
    
    /**
     * 查询数字
     *
     * @param result
     * @param nums
     * @return
     */
    protected boolean checkNum(Map<String, Object> result, int... nums) {
        for (int num :nums) {
            if (num <= 0) {
                outParamEmptyError(result);
                return true;
            }
        }
        return false;
    }
    
    /**
     * 查询double类型的数据
     *
     * @param result
     * @param num
     * @return
     */
    protected boolean checkDouble(Map<String, Object> result, Double num) {
        if (num <= 0) {
            outParamEmptyError(result);
            return true;
        }
        return false;
    }
    
    /**
     * 查询double类型的数据
     *
     * @param result
     * @param nums
     * @return
     */
    protected boolean checkDouble(Map<String, Object> result, Double... nums) {
        for (Double num :nums) {
            if (num <= 0) {
                outParamEmptyError(result);
                return true;
            }
        }
        return false;
    }

//    /**
//     * 查询系统设置
//     *
//     * @param fields 查询字段使用“,”隔开
//     * @return
//     */
//    protected Map<String, Object> querySystemSet(String fields) {
//    	LOGGER.info("查询系统设置..............................");
//        try {
//            Map<String, Object> result = new HashMap<>();
//            if (StringUtils.isBlank(fields)) {
//                return result;
//            }
//            return baseManager.selectUnique("system_set", new Criteria(), fields);
//        } catch (Exception e) {
//            LOG.error("查询系统设置失败....................", e);
//            throw new ManagerException("查询系统设置失败....");
//        }
//    }
//    
//    protected Integer addLog(String content,HttpServletRequest request) {
//    	LOGGER.info("添加日志记录..............................");
//        Integer num=0;
//        try {        	
//        	Map<String,Object> paramMap=new HashMap<String,Object>();
//			paramMap.put("createtime", Common.getSystemLoginTime());
//			paramMap.put("create_ip", request.getSession().getAttribute("create_ip"));
//			paramMap.put("content", content);
//			paramMap.put("handler", WebUtils.getLoginUserId(request));
//			num=baseManager.add("sys_log", paramMap);
//			LOG.info("添加日志记录成功");        	
//        } catch (Exception e) {
//            LOG.error("添加日志记录失败....................", e);
//            throw new ManagerException("添加日志记录失败....");
//        }
//        return num;
//    }

    /**
     * 检查结果
     *
     * @param result
     * @param datas
     * @param msg
     * @return
     */
    protected boolean checkResult(Map<String, Object> result, List<Map<String, Object>> datas, String msg) {
        if (CollectionUtils.isEmpty(datas)) {
            outError(result, msg);
            return true;
        }
        return false;
    }

    /**
     * 检查结果
     *
     * @param result
     * @param datas
     * @param msg
     * @return
     */
    protected boolean checkResult(Map<String, Object> result, Map<String, Object> datas, String msg) {
        if (CollectionUtils.isEmpty(datas)) {
            outError(result, msg);
            return true;
        }
        return false;
    }

    /**
     * 获取session属性
     *
     * @param username
     * @param request
     * @return
     */
    protected Object getAttribute(String username, HttpServletRequest request) {
        return request.getSession().getAttribute(username);
    }

    /**
     * 设置session属性
     *
     * @param username
     * @param request
     */
    protected void setAttribute(String username, HttpServletRequest request, Object value) {
        request.getSession().setAttribute(username, value);
    }

    /**
     * 清除属性
     *
     * @param request
     * @param phone
     */
    protected void removeAttibute(HttpServletRequest request, String phone) {
        request.getSession().removeAttribute(phone);
    }

    /**
     * 参数数为空
     *
     * @param result
     * @param content
     * @return
     */
    protected boolean notImpty(Map<String, Object> result, String content) {
        if (StringUtils.isBlank(content)) {
            outParamEmptyError(result);
            return true;
        }
        return false;
    }
//
//
//    /**
//     * 添加订单日志
//     *
//     * @param remark
//     * @param orderNum
//     * @param orderId
//     */
//    protected void addOrderLog(String content, String remark, String orderNum, Integer orderId) {
//        try {
//            LOG.info("addOrderLog.....................................");
//            Map<String, Object> data = new HashMap<>();
//            data.put("content", content);
//            data.put("createtime", getNowDateTime());
//            data.put("order_id", orderId);
//            data.put("order_num", orderNum);
//            data.put("remark", remark);
//            baseManager.add("order_log", data);
//        } catch (Exception e) {
//            LOG.error("记录订单日志失败....", e.getMessage());
//            throw new ManagerException("记录订单日志失败....");
//        }
//    }

    /**
     * 获取未来 第 past 天的日期
     *
     * @param past
     * @return
     */
    public static String getFetureDate(int past) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) + past);
        java.util.Date today = calendar.getTime();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String result = format.format(today);
        return result;
    }
    
    /**
     * 获得当前时间的前n天 是哪一天
     * @param i
     * @return
     */
    public String getLastDate(int i) {
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();  
        c.add(Calendar.DATE, -i);
        String preMonday = sdf.format(c.getTime());
        return preMonday;
	}

//    /**
//     * 查询所有省份信息
//     */
//	@Override
//	public List<Map<String, Object>> queryAllProvince() {
//		Criteria criteria = new Criteria();
//		return baseManager.selectByParam("province", criteria, "id","province_name");
//	}
//
//	/**
//	 * 根据省份id获取城市信息
//	 */
//	@Override
//	public List<Map<String, Object>> queryCityByPid(int pid) {
//		Criteria criteria = new Criteria();
//		criteria.put("province_id", pid);
//		return baseManager.selectByParam("city", criteria, "id","province_id","city_name","zip_code");
//	}
//
//	/**
//	 * 根据城市ID查询区域信息
//	 */
//	@Override
//	public List<Map<String, Object>> queryAreaByCid(int cid) {
//		Criteria criteria = new Criteria();
//		criteria.put("city_id", cid);
//		return baseManager.selectByParam("area", criteria, "id","area_name","city_id");
//	}
//
//	/**
//	 * 根据区域ID查询街道信息
//	 */
//	@Override
//	public List<Map<String, Object>> queryTownByAid(int aid) {
//		Criteria criteria = new Criteria();
//		criteria.put("area_id", aid);
//		return baseManager.selectByParam("town", criteria, "id","town_name","area_id");
//	}
//	
//	/**
//	 * 检查会员是否存在和有效
//	 */
//	protected boolean checkPersonalExist(Integer personalId) {
//		Criteria criteria = new Criteria();
//		criteria.put("id", personalId);
//		criteria.put("isvalid", 0);
//		int count = baseManager.selectCount("personal_member", criteria);
//		if(count > 0){
//			return false;
//		}
//		return true;
//	}
//	/**
//	 * 检查会员是否存在和有效
//	 */
//	protected boolean checkShopExist(Integer shopId) {
//		Criteria criteria = new Criteria();
//		criteria.put("id", shopId);
//		criteria.put("status", 1);
//		int count = baseManager.selectCount("shop", criteria);
//		if(count > 0){
//			return false;
//		}
//		return true;
//	}
//	/**
//	 * 检查会员是否存在和有效
//	 */
//	protected boolean checkProductExist(Integer proId) {
//		Criteria criteria = new Criteria();
//		criteria.put("id", proId);
//		criteria.put("isvalid", 0);
//		int count = baseManager.selectCount("product", criteria);
//		if(count > 0){
//			return false;
//		}
//		return true;
//	}
	
    /**
     * 检查字符串参数不能为空
     * 2017-03-22 11:33:09
     * lf
     * @param result
     * @param strs
     * @return
     */
    protected boolean checkString(Map<String, Object> result, String ... strs) {
        if (ArrayUtils.isEmpty(strs)) throw new RuntimeException("参数不能为空！");
        for (String str:strs) {
            if (StringUtils.isBlank(str)){
                outParamEmptyError(result);
                return true;
            }
        }
        return false;
    }
    
//    /**
//     * 根据积分判断满足的VIP等级
//     * @param i
//     * @return
//     */
//    protected Integer checkIsVIPUpgrade(int totalIntegral) {
//    	Integer vipLevelId = 0;
//		List<Map<String, Object>> vipLevel = baseManager.selectSql("SELECT id,MAX(integral) integral FROM vip_level WHERE integral<=" + totalIntegral + " GROUP BY integral ORDER BY integral DESC");
//		if (!CollectionUtils.isEmpty(vipLevel)) {
//			vipLevelId = ClassUtil.getInteger(vipLevel.get(0), "id");
//		}
//		return vipLevelId;
//	}
//    
//    /**
//	 * 根据店铺ID查询店铺商品
//	 * @param currentShopId
//	 * @return
//	 */
//    protected String queryShopPro(Integer currentShopId) {
//		StringBuffer sb = new StringBuffer();
//		Criteria criteria = new Criteria();
//		criteria.put("shop_id", currentShopId);
//		List<Map<String, Object>> shopPor = baseManager.selectByParam("shop_product", criteria, "id,pro_id");
//		if (!CollectionUtils.isEmpty(shopPor)) {
//			for (Map<String, Object> pro : shopPor) {
//				Integer proId = ClassUtil.getInteger(pro, "pro_id");
//				sb.append(proId + ",");
//			}
//			return sb.substring(0, sb.length()-1);
//		}
//		return "";
//	}
    
//    protected boolean checkCustomerExist(Integer customerId) {
//    	Criteria criteria = new Criteria();
//		criteria.put("id", customerId);
//		criteria.put("isvalid", 0);
//		int count = dao.
////		int count = baseManager.selectCount("personal_member", criteria);
//		if(count > 0){
//			return false;
//		}
//		return true;
//	}
}
