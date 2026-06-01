package com.mimikridev.ads.util;

import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class Response implements Serializable {
    public boolean status;
    public String title = "";
    public String message = "";

    public String getMessage() {
        return this.message;
    }

    public String getTitle() {
        return this.title;
    }

    public boolean isStatus() {
        return this.status;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public void setStatus(boolean z2) {
        this.status = z2;
    }

    public void setTitle(String str) {
        this.title = str;
    }
}
