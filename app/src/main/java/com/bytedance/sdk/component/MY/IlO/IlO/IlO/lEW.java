package com.bytedance.sdk.component.MY.IlO.IlO.IlO;

import android.text.TextUtils;
import com.bytedance.sdk.component.MY.IlO.bWL;
import com.bytedance.sdk.component.MY.IlO.ea;
import com.bytedance.sdk.component.MY.IlO.rp;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class lEW extends bWL {
    public static int IlO = -1;
    String Cc;
    rp EO;
    HttpURLConnection MY;
    int tV;

    public lEW(HttpURLConnection httpURLConnection, rp rpVar) {
        this.tV = IlO;
        this.MY = httpURLConnection;
        this.EO = rpVar;
    }

    @Override // com.bytedance.sdk.component.MY.IlO.bWL
    public com.bytedance.sdk.component.MY.IlO.vCE Bc() {
        if (this.MY == null) {
            return new com.bytedance.sdk.component.MY.IlO.vCE(new String[0]);
        }
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, List<String>> entry : this.MY.getHeaderFields().entrySet()) {
            for (String str : entry.getValue()) {
                if (!"Content-Range".equalsIgnoreCase(entry.getKey()) || EO() != 206) {
                    arrayList.add(entry.getKey());
                    arrayList.add(str);
                }
            }
        }
        return new com.bytedance.sdk.component.MY.IlO.vCE((String[]) arrayList.toArray(new String[arrayList.size()]));
    }

    @Override // com.bytedance.sdk.component.MY.IlO.bWL
    public String Cc() throws IOException {
        return !TextUtils.isEmpty(this.Cc) ? this.Cc : this.MY.getResponseMessage();
    }

    public rp DmF() {
        return this.EO;
    }

    @Override // com.bytedance.sdk.component.MY.IlO.bWL
    public int EO() {
        try {
            return this.MY.getResponseCode();
        } catch (Exception unused) {
            return this.tV;
        }
    }

    @Override // com.bytedance.sdk.component.MY.IlO.bWL
    public long IlO() {
        return 0L;
    }

    @Override // com.bytedance.sdk.component.MY.IlO.bWL
    public long MY() {
        return 0L;
    }

    @Override // com.bytedance.sdk.component.MY.IlO.bWL, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        try {
            vCE().close();
        } catch (Exception unused) {
        }
    }

    @Override // com.bytedance.sdk.component.MY.IlO.bWL
    public com.bytedance.sdk.component.MY.IlO.NV lEW() {
        if (DmF() == null || DmF().MY == null) {
            return null;
        }
        return new com.bytedance.sdk.component.MY.IlO.NV(DmF().MY);
    }

    @Override // com.bytedance.sdk.component.MY.IlO.bWL
    public boolean tV() {
        return EO() >= 200 && EO() < 300;
    }

    public String toString() {
        return "";
    }

    @Override // com.bytedance.sdk.component.MY.IlO.bWL
    public ea vCE() {
        DmF dmF;
        com.bytedance.sdk.component.EO.IlO.IlO ilO;
        com.bytedance.sdk.component.EO.IlO.IlO ilO2;
        rp rpVar = this.EO;
        if (rpVar != null && (ilO2 = rpVar.MY) != null) {
            ilO2.EV();
        }
        try {
            try {
                dmF = new DmF(this.MY);
            } catch (Throwable th) {
                th.getMessage();
                dmF = null;
            }
        } catch (Exception unused) {
            HttpURLConnection httpURLConnection = this.MY;
            dmF = new DmF(httpURLConnection, httpURLConnection.getErrorStream());
        }
        rp rpVar2 = this.EO;
        if (rpVar2 != null && (ilO = rpVar2.MY) != null) {
            ilO.hp();
        }
        return dmF;
    }

    public lEW(int i2, String str, rp rpVar) {
        this.Cc = str;
        this.EO = rpVar;
        this.tV = i2;
    }
}
