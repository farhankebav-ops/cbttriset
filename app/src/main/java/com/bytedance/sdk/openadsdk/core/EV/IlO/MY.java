package com.bytedance.sdk.openadsdk.core.EV.IlO;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.bytedance.sdk.openadsdk.cL.Bc;
import com.bytedance.sdk.openadsdk.core.EV.MY.EO;
import com.bytedance.sdk.openadsdk.utils.BS;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class MY {
    public int Cc;
    protected int EO;
    public int IlO;
    protected final Context MY;
    protected double tV;
    public IlO vCE;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class IlO {
        public boolean EO;
        public int IlO;
        public int MY;
    }

    public MY(Context context, int i2, int i8) {
        this.EO = 0;
        this.tV = 0.0d;
        if (i8 > 0 && i2 > 0) {
            this.tV = ((double) i2) / ((double) i8);
        }
        float fBc = BS.Bc(context);
        if (fBc != 0.0f && i2 > 0) {
            this.EO = (int) (i2 / fBc);
        }
        this.MY = context.getApplicationContext();
    }

    public abstract com.bytedance.sdk.openadsdk.core.EV.IlO IlO(String str, List<EO> list);

    public void IlO(Exception exc, int i2) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("exception", exc.getMessage());
            jSONObject.put("error_code", i2);
            com.bytedance.sdk.openadsdk.ea.EO.IlO().IlO("load_vast", jSONObject);
        } catch (Exception unused) {
        }
    }

    public String MY(String str, List<EO> list) {
        String strTV;
        int i2 = this.IlO;
        if (i2 >= 5) {
            return null;
        }
        this.IlO = i2 + 1;
        if (str == null) {
            return null;
        }
        try {
            com.bytedance.sdk.component.Bc.MY.MY myEO = Bc.IlO().MY().EO();
            myEO.MY(str);
            com.bytedance.sdk.component.Bc.MY myIlO = myEO.IlO();
            strTV = myIlO.tV();
            try {
                myIlO.IlO();
                return strTV;
            } catch (Exception e) {
                e = e;
                IlO(e, 0);
                if (!list.isEmpty()) {
                    EO.MY(list, com.bytedance.sdk.openadsdk.core.EV.IlO.IlO.WRAPPER_TIMEOUT, -1L, null);
                }
                return strTV;
            }
        } catch (Exception e4) {
            e = e4;
            strTV = null;
        }
    }

    public boolean IlO(@Nullable String str) {
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        try {
            return Integer.parseInt(str) < 2;
        } catch (NumberFormatException unused) {
            return true;
        }
    }
}
