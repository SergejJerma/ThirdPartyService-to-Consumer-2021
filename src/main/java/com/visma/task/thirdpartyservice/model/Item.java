package com.visma.task.thirdpartyservice.model;

public class Item {

    private String uuid;
    private StatusType status;

    public Item(String uuid, StatusType status) {
        this.uuid = uuid;
        this.status = status;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public StatusType getStatus() {
        return status;
    }

    public void setStatus(StatusType status) {
        this.status = status;
    }
}
