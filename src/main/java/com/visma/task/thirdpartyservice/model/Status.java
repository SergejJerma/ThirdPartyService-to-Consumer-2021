package com.visma.task.thirdpartyservice.model;

public class Status {

    private String uuid;
    private StatusType statusType;

    public Status(String uuid, StatusType statusType) {
        this.uuid = uuid;
        this.statusType = statusType;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public StatusType getStatusType() {
        return statusType;
    }

    public void setStatusType(StatusType statusType) {
        this.statusType = statusType;
    }
}
