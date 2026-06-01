package com.bytedance.sdk.openadsdk.tV.IlO;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class lEW implements com.bytedance.sdk.component.vCE.IlO.IlO.Cc {
    public static final lEW IlO = new lEW();
    private volatile SQLiteDatabase MY;

    @Override // com.bytedance.sdk.component.vCE.IlO.IlO.Cc
    public String Cc() {
        return "logstatsbatch";
    }

    @Override // com.bytedance.sdk.component.vCE.IlO.IlO.Cc
    public String EO() {
        return null;
    }

    @Override // com.bytedance.sdk.component.vCE.IlO.IlO.Cc
    public SQLiteDatabase IlO(Context context) {
        if (this.MY == null) {
            synchronized (this) {
                try {
                    if (this.MY == null) {
                        this.MY = com.bytedance.sdk.openadsdk.core.Cc.IlO(context).IlO().IlO();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return this.MY;
    }

    @Override // com.bytedance.sdk.component.vCE.IlO.IlO.Cc
    public String MY() {
        return "adevent";
    }

    @Override // com.bytedance.sdk.component.vCE.IlO.IlO.Cc
    public String tV() {
        return "logstats";
    }

    @Override // com.bytedance.sdk.component.vCE.IlO.IlO.Cc
    public String vCE() {
        return null;
    }

    @Override // com.bytedance.sdk.component.vCE.IlO.IlO.Cc
    public String IlO() {
        return "loghighpriority";
    }
}
