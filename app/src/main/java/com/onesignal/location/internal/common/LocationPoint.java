package com.onesignal.location.internal.common;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class LocationPoint {
    private Float accuracy;
    private Boolean bg;
    private Double lat;
    private Double log;
    private Long timeStamp;
    private Integer type;

    public final Float getAccuracy() {
        return this.accuracy;
    }

    public final Boolean getBg() {
        return this.bg;
    }

    public final Double getLat() {
        return this.lat;
    }

    public final Double getLog() {
        return this.log;
    }

    public final Long getTimeStamp() {
        return this.timeStamp;
    }

    public final Integer getType() {
        return this.type;
    }

    public final void setAccuracy(Float f4) {
        this.accuracy = f4;
    }

    public final void setBg(Boolean bool) {
        this.bg = bool;
    }

    public final void setLat(Double d8) {
        this.lat = d8;
    }

    public final void setLog(Double d8) {
        this.log = d8;
    }

    public final void setTimeStamp(Long l) {
        this.timeStamp = l;
    }

    public final void setType(Integer num) {
        this.type = num;
    }

    public String toString() {
        return "LocationPoint{lat=" + this.lat + ", log=" + this.log + ", accuracy=" + this.accuracy + ", type=" + this.type + ", bg=" + this.bg + ", timeStamp=" + this.timeStamp + '}';
    }
}
