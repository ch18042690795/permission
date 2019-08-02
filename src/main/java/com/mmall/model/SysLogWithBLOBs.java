package com.mmall.model;

public class SysLogWithBLOBs extends SysLog {
    private String oldValues;

    private String newValues;

    public String getOldValue() {
        return oldValues;
    }

    public void setOldValue(String oldValue) {
        oldValues = (oldValue == null) ? null : oldValue.trim();
    }

    public String getNewValue() {
        return newValues;
    }

    public void setNewValue(String newValue) {
        newValues = newValue == null ? null : newValue.trim();
    }
}