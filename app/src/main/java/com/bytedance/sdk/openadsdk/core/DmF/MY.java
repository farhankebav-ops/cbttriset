package com.bytedance.sdk.openadsdk.core.DmF;

import android.text.TextUtils;
import android.view.MotionEvent;
import androidx.annotation.NonNull;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class MY {
    private static com.bytedance.sdk.openadsdk.core.DmF.IlO IlO;
    private String MY;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class IlO {
        private static final MY IlO = new MY();
    }

    public int Bc() {
        com.bytedance.sdk.openadsdk.core.DmF.IlO ilO = IlO;
        if (ilO != null) {
            return ilO.Bc();
        }
        return 1;
    }

    public String Cc() {
        com.bytedance.sdk.openadsdk.core.DmF.IlO ilO = IlO;
        return ilO != null ? ilO.Cc() : "";
    }

    public boolean EO() {
        com.bytedance.sdk.openadsdk.core.DmF.IlO ilO = IlO;
        if (ilO == null) {
            return false;
        }
        return ilO.MY();
    }

    public void IlO(String str) {
        com.bytedance.sdk.openadsdk.core.DmF.IlO ilO;
        if (TextUtils.isEmpty(str) || (ilO = IlO) == null) {
            return;
        }
        ilO.IlO(str);
    }

    public void MY(String str) {
        com.bytedance.sdk.openadsdk.core.DmF.IlO ilO;
        if (TextUtils.isEmpty(str) || (ilO = IlO) == null) {
            return;
        }
        ilO.MY(str);
    }

    public String tV() {
        String strTV;
        com.bytedance.sdk.openadsdk.core.DmF.IlO ilO = IlO;
        return (ilO == null || (strTV = ilO.tV()) == null) ? "" : strTV;
    }

    public long vCE() {
        com.bytedance.sdk.openadsdk.core.DmF.IlO ilO = IlO;
        if (ilO != null) {
            return ilO.vCE();
        }
        return 0L;
    }

    private MY() {
        this.MY = null;
        IlO = new com.bytedance.sdk.openadsdk.core.DmF.IlO();
    }

    public static MY MY() {
        return IlO.IlO;
    }

    public void IlO(Map<String, Object> map) {
        com.bytedance.sdk.openadsdk.core.DmF.IlO ilO = IlO;
        if (ilO != null) {
            ilO.IlO(map);
        }
    }

    public void IlO() {
        com.bytedance.sdk.openadsdk.core.DmF.IlO ilO = IlO;
        if (ilO != null) {
            ilO.EO();
        }
    }

    public void IlO(@NonNull String str, Map<String, Object> map) {
        com.bytedance.sdk.openadsdk.core.DmF.IlO ilO = IlO;
        if (ilO != null) {
            ilO.IlO(str, map);
        }
    }

    public Map<String, String> IlO(String str, byte[] bArr) {
        com.bytedance.sdk.openadsdk.core.DmF.IlO ilO = IlO;
        if (ilO != null) {
            return ilO.IlO(str, bArr);
        }
        return new HashMap();
    }

    public void IlO(MotionEvent motionEvent) {
        com.bytedance.sdk.openadsdk.core.DmF.IlO ilO = IlO;
        if (ilO != null) {
            ilO.IlO(motionEvent);
        }
    }
}
