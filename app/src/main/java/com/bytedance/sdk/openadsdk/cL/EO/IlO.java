package com.bytedance.sdk.openadsdk.cl.EO;

import android.content.Context;
import android.content.SharedPreferences;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class IlO {
    private final SharedPreferences IlO;

    public IlO(Context context) {
        this.IlO = context.getSharedPreferences("pag_monitor_record", 0);
    }

    public long IlO() {
        return this.IlO.getLong("last_upload_time", 0L);
    }

    public void IlO(long j) {
        SharedPreferences.Editor editorEdit = this.IlO.edit();
        editorEdit.putLong("last_upload_time", j);
        editorEdit.apply();
    }
}
