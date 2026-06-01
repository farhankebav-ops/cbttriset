package com.bytedance.sdk.openadsdk.core.EV;

import a1.a;
import com.bytedance.sdk.openadsdk.core.EV.EO.IlO;
import com.bytedance.sdk.openadsdk.core.EV.MY.EO;
import com.bytedance.sdk.openadsdk.core.model.oeT;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class EO {
    protected List<com.bytedance.sdk.openadsdk.core.EV.MY.EO> Bc;
    protected String Cc;
    protected IlO.EnumC0084IlO EO;
    protected int IlO;
    protected int MY;
    private String NV;
    protected String lEW;
    private oeT rp;
    protected IlO.MY tV;
    protected List<com.bytedance.sdk.openadsdk.core.EV.MY.EO> vCE;
    private final AtomicBoolean EV = new AtomicBoolean(false);
    protected String DmF = "endcard_click";

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.EV.EO$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] IlO;

        static {
            int[] iArr = new int[IlO.MY.values().length];
            IlO = iArr;
            try {
                iArr[IlO.MY.STATIC_RESOURCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                IlO[IlO.MY.HTML_RESOURCE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                IlO[IlO.MY.IFRAME_RESOURCE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public EO(int i2, int i8, IlO.EnumC0084IlO enumC0084IlO, IlO.MY my, String str, List<com.bytedance.sdk.openadsdk.core.EV.MY.EO> list, List<com.bytedance.sdk.openadsdk.core.EV.MY.EO> list2, String str2) {
        this.vCE = new ArrayList();
        this.Bc = new ArrayList();
        this.IlO = i2;
        this.MY = i8;
        this.EO = enumC0084IlO;
        this.tV = my;
        this.Cc = str;
        this.vCE = list;
        this.Bc = list2;
        this.lEW = str2;
    }

    public String Cc() {
        if (this.tV == IlO.MY.STATIC_RESOURCE && this.EO == IlO.EnumC0084IlO.IMAGE) {
            return this.Cc;
        }
        return null;
    }

    public int EO() {
        return this.MY;
    }

    public void IlO(long j) {
        com.bytedance.sdk.openadsdk.core.EV.MY.EO.IlO(this.vCE, null, j, this.NV, new EO.MY(this.DmF, this.rp));
    }

    public int MY() {
        return this.IlO;
    }

    public String tV() {
        int i2 = AnonymousClass1.IlO[this.tV.ordinal()];
        if (i2 == 1) {
            IlO.EnumC0084IlO enumC0084IlO = this.EO;
            if (enumC0084IlO == IlO.EnumC0084IlO.IMAGE) {
                return a.r(new StringBuilder("<html><head></head><body style=\"margin:0;padding:0\"><img src=\""), this.Cc, "\" width=\"100%\" style=\"max-width:100%;max-height:100%;\" /></body></html>");
            }
            if (enumC0084IlO == IlO.EnumC0084IlO.JAVASCRIPT) {
                return a.r(new StringBuilder("<script src=\""), this.Cc, "\"></script>");
            }
            return null;
        }
        if (i2 == 2) {
            return this.Cc;
        }
        if (i2 != 3) {
            return null;
        }
        StringBuilder sb = new StringBuilder("<iframe frameborder=\"0\" scrolling=\"no\" marginheight=\"0\" marginwidth=\"0\" style=\"border: 0px; margin: 0px;\" width=\"");
        sb.append(this.IlO);
        sb.append("\" height=\"");
        sb.append(this.MY);
        sb.append("\" src=\"");
        return a.r(sb, this.Cc, "\"></iframe>");
    }

    public String vCE() {
        return this.Cc;
    }

    public static float IlO(int i2, int i8, int i9, int i10, IlO.MY my, IlO.EnumC0084IlO enumC0084IlO) {
        if (i8 == 0 || i10 == 0) {
            return 0.0f;
        }
        float f4 = i2;
        float f8 = i9;
        return IlO(my, enumC0084IlO) / ((Math.abs((f4 - f8) / f4) + Math.abs((f4 / i8) - (f8 / i10))) + 1.0f);
    }

    public void MY(long j) {
        if (this.EV.compareAndSet(false, true)) {
            com.bytedance.sdk.openadsdk.core.EV.MY.EO.MY(this.Bc, null, j, this.NV);
        }
    }

    public static EO MY(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        int iOptInt = jSONObject.optInt("width");
        int iOptInt2 = jSONObject.optInt("height");
        String strOptString = jSONObject.optString("creativeType", IlO.EnumC0084IlO.NONE.toString());
        String strOptString2 = jSONObject.optString("resourceType", IlO.MY.HTML_RESOURCE.toString());
        String strOptString3 = jSONObject.optString("contentUrl");
        String strOptString4 = jSONObject.optString("clickThroughUri");
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("clickTrackers");
        JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray("creativeViewTrackers");
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < jSONArrayOptJSONArray.length(); i2++) {
            arrayList.add(new EO.IlO(jSONArrayOptJSONArray.optString(i2)).IlO());
        }
        ArrayList arrayList2 = new ArrayList();
        for (int i8 = 0; i8 < jSONArrayOptJSONArray2.length(); i8++) {
            arrayList2.add(new EO.IlO(jSONArrayOptJSONArray2.optString(i8)).IlO());
        }
        return new EO(iOptInt, iOptInt2, IlO.EnumC0084IlO.valueOf(strOptString), IlO.MY.valueOf(strOptString2), strOptString3, arrayList, arrayList2, strOptString4);
    }

    private static float IlO(IlO.MY my, IlO.EnumC0084IlO enumC0084IlO) {
        int i2 = AnonymousClass1.IlO[my.ordinal()];
        if (i2 != 1) {
            if (i2 != 2) {
                return i2 != 3 ? 0.0f : 1.0f;
            }
            return 1.2f;
        }
        if (IlO.EnumC0084IlO.JAVASCRIPT.equals(enumC0084IlO)) {
            return 1.0f;
        }
        return IlO.EnumC0084IlO.IMAGE.equals(enumC0084IlO) ? 0.8f : 0.0f;
    }

    public void IlO(String str) {
        this.NV = str;
    }

    public JSONObject IlO() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("width", this.IlO);
        jSONObject.put("height", this.MY);
        jSONObject.put("creativeType", this.EO.toString());
        jSONObject.put("resourceType", this.tV.toString());
        jSONObject.put("contentUrl", this.Cc);
        jSONObject.put("clickThroughUri", this.lEW);
        jSONObject.put("clickTrackers", com.bytedance.sdk.openadsdk.core.EV.MY.EO.IlO(this.vCE));
        jSONObject.put("creativeViewTrackers", com.bytedance.sdk.openadsdk.core.EV.MY.EO.IlO(this.Bc));
        return jSONObject;
    }

    public void IlO(oeT oet) {
        this.rp = oet;
    }
}
