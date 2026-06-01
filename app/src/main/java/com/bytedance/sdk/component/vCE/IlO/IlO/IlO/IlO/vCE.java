package com.bytedance.sdk.component.vCE.IlO.IlO.IlO.IlO;

import a1.a;
import android.content.Context;
import com.bytedance.sdk.component.vCE.IlO.lEW;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class vCE extends Bc {
    public vCE(Context context, com.bytedance.sdk.component.vCE.IlO.tV.MY.IlO ilO) {
        super(context, ilO);
    }

    @Override // com.bytedance.sdk.component.vCE.IlO.IlO.IlO.IlO.Bc
    public byte EO() {
        return (byte) 3;
    }

    @Override // com.bytedance.sdk.component.vCE.IlO.IlO.IlO.IlO.Bc
    public byte IlO() {
        return (byte) 1;
    }

    @Override // com.bytedance.sdk.component.vCE.IlO.IlO.IlO.IlO.Bc, com.bytedance.sdk.component.vCE.IlO.IlO.IlO.IlO.EO
    public String MY() {
        return lEW.Bc().tV().Cc();
    }

    public static String IlO(String str) {
        return a.m("CREATE TABLE IF NOT EXISTS ", str, " (_id INTEGER PRIMARY KEY AUTOINCREMENT,id TEXT UNIQUE,value TEXT ,gen_time TEXT , retry INTEGER default 0 , encrypt INTEGER default 0)");
    }
}
