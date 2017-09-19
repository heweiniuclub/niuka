package com.niuka.common.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;

/**
 * 扩展Map类
 *
 * @author jiangtao
 */
public class ExtendMap<K, V> extends HashMap<K, V> {
    private static final long serialVersionUID = 1L;
    private boolean           success          = true;
    private List<String>      errorMsg         = new ArrayList<String>();
    private String            exceptionMsg;

    public ExtendMap() {
        super();
    }

    public ExtendMap(Map<K, V> map) {
        this.putAll(map);
    }

    @SuppressWarnings("unchecked")
    public ExtendMap(String json) {
        this.putAll(JSON.parseObject(json, Map.class));
    }

    public ExtendMap(K key[], V value[]) {
        super();

        for (int i = 0; i < key.length; i++) {
            this.put(key[i], value[i]);
        }
    }

    public boolean getBoolean(K key) {
        return Boolean.parseBoolean(getString(key));
    }

    public double getDouble(K key) {
        return getString(key).equals("")
               ? 0
               : Double.parseDouble(getString(key));
    }

    public List<String> getErrorMsg() {
        return this.errorMsg;
    }

    public void setErrorMsg(String msg) {
        if (this.isSuccess()) {
            this.setSuccess(false);
        }

        this.errorMsg.add(msg);
    }

    public String getExcepMsg() {
        return this.exceptionMsg;
    }

    public void setExcepMsg(String emsg) {
        if (this.isSuccess()) {
            this.setSuccess(false);
        }

        this.exceptionMsg = emsg;
    }

    public float getFloat(K key) {
        return getString(key).equals("")
               ? 0
               : Float.parseFloat(getString(key));
    }

    public int getInt(K key) {
        return getString(key).equals("")
               ? 0
               : Integer.parseInt(getString(key));
    }

    public Integer getInteger(K key) {
        return getString(key).equals("")
               ? 0
               : Integer.parseInt(getString(key));
    }

    public long getLong(K key) {
        return getString(key).equals("")
               ? 0
               : Long.parseLong(getString(key));
    }

    public String getString(K key) {
        return (this.get(key) != null)
               ? this.get(key).toString()
               : "";
    }

    public boolean isSuccess() {
        return this.success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
