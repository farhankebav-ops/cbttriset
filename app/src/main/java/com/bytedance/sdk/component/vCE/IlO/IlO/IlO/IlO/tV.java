package com.bytedance.sdk.component.vCE.IlO.IlO.IlO.IlO;

import a1.a;
import android.content.Context;
import com.bytedance.sdk.component.vCE.IlO.lEW;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class tV extends IlO {
    public tV(Context context, com.bytedance.sdk.component.vCE.IlO.tV.MY.IlO ilO) {
        super(context, ilO);
    }

    @Override // com.bytedance.sdk.component.vCE.IlO.IlO.IlO.IlO.IlO
    public byte EO() {
        return (byte) 1;
    }

    @Override // com.bytedance.sdk.component.vCE.IlO.IlO.IlO.IlO.IlO, com.bytedance.sdk.component.vCE.IlO.IlO.IlO.IlO.EO
    public String MY() {
        com.bytedance.sdk.component.vCE.IlO.IlO.Cc ccTV = lEW.Bc().tV();
        if (ccTV != null) {
            return ccTV.IlO();
        }
        return null;
    }

    @Override // com.bytedance.sdk.component.vCE.IlO.IlO.IlO.IlO.IlO
    public byte tV() {
        return (byte) 0;
    }

    public static String EO(String str) {
        return a.m("CREATE TABLE IF NOT EXISTS ", str, " (_id INTEGER PRIMARY KEY AUTOINCREMENT,id TEXT UNIQUE,value TEXT ,gen_time TEXT , retry INTEGER default 0 , encrypt INTEGER default 0)");
    }
}
