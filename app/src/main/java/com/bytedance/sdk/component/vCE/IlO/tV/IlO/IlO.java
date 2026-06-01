package com.bytedance.sdk.component.vCE.IlO.tV.IlO;

import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.unity3d.ads.core.domain.HandleInvocationsFromAdViewer;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class IlO implements com.bytedance.sdk.component.vCE.IlO.tV.IlO {
    private long Bc;
    private long Cc;
    private String DmF;
    private byte EO;
    private String EV;
    protected JSONObject IlO;
    private MY MY;
    private byte NV;
    private String lEW;
    private int rp;
    private byte tV;
    private long vCE;

    public IlO(String str, JSONObject jSONObject) {
        this.DmF = str;
        this.IlO = jSONObject;
    }

    public static com.bytedance.sdk.component.vCE.IlO.tV.IlO EO(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            int iOptInt = jSONObject.optInt("type");
            int iOptInt2 = jSONObject.optInt(HandleInvocationsFromAdViewer.KEY_DOWNLOAD_PRIORITY);
            IlO ilO = new IlO();
            ilO.IlO((byte) iOptInt);
            ilO.MY((byte) iOptInt2);
            ilO.IlO(jSONObject.optJSONObject(NotificationCompat.CATEGORY_EVENT));
            ilO.IlO(jSONObject.optString("localId"));
            ilO.MY(jSONObject.optString("genTime"));
            ilO.IlO(jSONObject.optInt("channel"));
            return ilO;
        } catch (JSONException unused) {
            return null;
        }
    }

    @Override // com.bytedance.sdk.component.vCE.IlO.tV.IlO
    public synchronized JSONObject Bc() {
        MY my;
        try {
            if (this.IlO == null && (my = this.MY) != null) {
                this.IlO = my.IlO(EV());
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.IlO;
    }

    @Override // com.bytedance.sdk.component.vCE.IlO.tV.IlO
    public byte Cc() {
        return this.tV;
    }

    @Override // com.bytedance.sdk.component.vCE.IlO.tV.IlO
    public long DmF() {
        return this.vCE;
    }

    public String EV() {
        return this.EV;
    }

    @Override // com.bytedance.sdk.component.vCE.IlO.tV.IlO
    public MY IlO() {
        return this.MY;
    }

    @Override // com.bytedance.sdk.component.vCE.IlO.tV.IlO
    public byte MY() {
        return this.NV;
    }

    @Override // com.bytedance.sdk.component.vCE.IlO.tV.IlO
    public int NV() {
        return this.rp;
    }

    @Override // com.bytedance.sdk.component.vCE.IlO.tV.IlO
    public long lEW() {
        return this.Cc;
    }

    public String rp() {
        return this.lEW;
    }

    @Override // com.bytedance.sdk.component.vCE.IlO.tV.IlO
    public byte tV() {
        return this.EO;
    }

    @Override // com.bytedance.sdk.component.vCE.IlO.tV.IlO
    public String vCE() {
        if (TextUtils.isEmpty(this.DmF)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("localId", this.DmF);
            jSONObject.put(NotificationCompat.CATEGORY_EVENT, Bc());
            jSONObject.put("genTime", rp());
            jSONObject.put(HandleInvocationsFromAdViewer.KEY_DOWNLOAD_PRIORITY, (int) this.tV);
            jSONObject.put("type", (int) this.EO);
            jSONObject.put("channel", this.rp);
        } catch (Throwable unused) {
        }
        return jSONObject.toString();
    }

    @Override // com.bytedance.sdk.component.vCE.IlO.tV.IlO
    public void IlO(JSONObject jSONObject) {
        this.IlO = jSONObject;
    }

    @Override // com.bytedance.sdk.component.vCE.IlO.tV.IlO
    public void MY(String str) {
        this.lEW = str;
    }

    @Override // com.bytedance.sdk.component.vCE.IlO.tV.IlO
    public void IlO(byte b8) {
        this.EO = b8;
    }

    @Override // com.bytedance.sdk.component.vCE.IlO.tV.IlO
    public void MY(long j) {
        this.vCE = j;
    }

    public IlO(String str, MY my) {
        this.DmF = str;
        this.MY = my;
    }

    @Override // com.bytedance.sdk.component.vCE.IlO.tV.IlO
    public void IlO(String str) {
        this.DmF = str;
    }

    @Override // com.bytedance.sdk.component.vCE.IlO.tV.IlO
    public void MY(byte b8) {
        this.tV = b8;
    }

    @Override // com.bytedance.sdk.component.vCE.IlO.tV.IlO
    public void IlO(long j) {
        this.Cc = j;
    }

    @Override // com.bytedance.sdk.component.vCE.IlO.tV.IlO
    public void IlO(int i2) {
        this.rp = i2;
    }

    private IlO() {
    }

    public void EO(byte b8) {
        this.NV = b8;
    }

    @Override // com.bytedance.sdk.component.vCE.IlO.tV.IlO
    public String EO() {
        return this.DmF;
    }

    @Override // com.bytedance.sdk.component.vCE.IlO.tV.IlO
    public void EO(long j) {
        this.Bc = j;
    }
}
