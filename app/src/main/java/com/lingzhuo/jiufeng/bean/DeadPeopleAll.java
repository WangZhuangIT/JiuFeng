package com.lingzhuo.jiufeng.bean;

import java.util.List;

/**
 * Created by Wang on 2016/7/7.
 */
public class DeadPeopleAll {
    private int CupState;
    private int FlowerState;
    private int IncensoryState;
    private String ManPhoto;
    private String MemorialNumber;
    private String Mp3State;
    private String TombType;
    private String bh;
    private String exCode;
    private String exMsg;
    private String id;
    private String qh;
    private List<DeadPeople> rows;
    private int total;

    public DeadPeopleAll() {
    }

    public DeadPeopleAll(int cupState, int flowerState, int incensoryState, String manPhoto, String memorialNumber, String mp3State, String tombType, String bh, String exCode, String exMsg, String id, String qh, List<DeadPeople> rows, int total) {
        CupState = cupState;
        FlowerState = flowerState;
        IncensoryState = incensoryState;
        ManPhoto = manPhoto;
        MemorialNumber = memorialNumber;
        Mp3State = mp3State;
        TombType = tombType;
        this.bh = bh;
        this.exCode = exCode;
        this.exMsg = exMsg;
        this.id = id;
        this.qh = qh;
        this.rows = rows;
        this.total = total;
    }

    public int getCupState() {
        return CupState;
    }

    public void setCupState(int cupState) {
        CupState = cupState;
    }

    public int getFlowerState() {
        return FlowerState;
    }

    public void setFlowerState(int flowerState) {
        FlowerState = flowerState;
    }

    public int getIncensoryState() {
        return IncensoryState;
    }

    public void setIncensoryState(int incensoryState) {
        IncensoryState = incensoryState;
    }

    public String getManPhoto() {
        return ManPhoto;
    }

    public void setManPhoto(String manPhoto) {
        ManPhoto = manPhoto;
    }

    public String getMemorialNumber() {
        return MemorialNumber;
    }

    public void setMemorialNumber(String memorialNumber) {
        MemorialNumber = memorialNumber;
    }

    public String getMp3State() {
        return Mp3State;
    }

    public void setMp3State(String mp3State) {
        Mp3State = mp3State;
    }

    public String getTombType() {
        return TombType;
    }

    public void setTombType(String tombType) {
        TombType = tombType;
    }

    public String getBh() {
        return bh;
    }

    public void setBh(String bh) {
        this.bh = bh;
    }

    public String getExCode() {
        return exCode;
    }

    public void setExCode(String exCode) {
        this.exCode = exCode;
    }

    public String getExMsg() {
        return exMsg;
    }

    public void setExMsg(String exMsg) {
        this.exMsg = exMsg;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getQh() {
        return qh;
    }

    public void setQh(String qh) {
        this.qh = qh;
    }

    public List<DeadPeople> getRows() {
        return rows;
    }

    public void setRows(List<DeadPeople> rows) {
        this.rows = rows;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
