package com.example.sky.DTO;

import lombok.Data;

/**
 * @author chengbb
 * @date 2019.12.26
 */
@Data
public class AlarmMessageDto {

    /**
     * 范围id。所有范围都在org.apache.skywalking.oap.server.core.source.DefaultScopeDefine中定义
     */
    private int scopeId;

    /**
     * 范围
     */
    private String scope;

    /**
     * 目标范围实体名称
     */
    private String name;

    /**
     * 您在中配置的规则名称alarm-settings.yml
     */
    private String ruleName;

    /**
     * 作用域实体的ID，与名称匹配
     */
    private String id0;

    /**
     * 不使用
     */
    private int id1;

    /**
     * 报警文本消息
     */
    private String alarmMessage;

    /**
     * 时间，以毫秒为单位，介于当前时间和UTC 1970年1月1日午夜之间
     */
    private long startTime;

    public int getScopeId() {
        return scopeId;
    }

    public void setScopeId(int scopeId) {
        this.scopeId = scopeId;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRuleName() {
        return ruleName;
    }

    public void setRuleName(String ruleName) {
        this.ruleName = ruleName;
    }

    public String getId0() {
        return id0;
    }

    public void setId0(String id0) {
        this.id0 = id0;
    }

    public int getId1() {
        return id1;
    }

    public void setId1(int id1) {
        this.id1 = id1;
    }

    public String getAlarmMessage() {
        return alarmMessage;
    }

    public void setAlarmMessage(String alarmMessage) {
        this.alarmMessage = alarmMessage;
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }
}
