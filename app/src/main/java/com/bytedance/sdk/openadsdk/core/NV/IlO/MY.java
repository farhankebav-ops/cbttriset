package com.bytedance.sdk.openadsdk.core.NV.IlO;

import a1.a;
import android.text.TextUtils;
import com.bytedance.sdk.component.lEW.lEW;
import com.bytedance.sdk.openadsdk.cL.Bc;
import com.bytedance.sdk.openadsdk.core.DmF;
import com.bytedance.sdk.openadsdk.core.cl;
import com.bytedance.sdk.openadsdk.utils.mmj;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class MY {
    private static volatile MY IlO;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public interface IlO {
        void IlO(int i2, String str, String str2);

        void IlO(JSONObject jSONObject, String str);
    }

    private void MY(String str, String str2, String str3, String str4, String str5) {
        com.bytedance.sdk.openadsdk.core.NV.IlO.IlO ilO = new com.bytedance.sdk.openadsdk.core.NV.IlO.IlO();
        ilO.EO(str).Cc(str3).tV(str4).MY(str2).IlO(str5).IlO(Long.valueOf(System.currentTimeMillis()));
        EO.IlO().IlO(ilO);
        MY();
    }

    public static MY IlO() {
        if (IlO == null) {
            synchronized (MY.class) {
                try {
                    if (IlO == null) {
                        IlO = new MY();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return IlO;
    }

    public void IlO(com.bytedance.sdk.openadsdk.core.NV.Bc.IlO ilO, String str) {
        if (ilO == null || TextUtils.isEmpty(ilO.IlO())) {
            return;
        }
        StringBuilder sbX = a.x(str, "_");
        sbX.append(ilO.IlO());
        final String string = sbX.toString();
        final String strEO = ilO.EO();
        final String strMY = ilO.MY();
        final String strTV = ilO.tV();
        String strCc = ilO.Cc();
        if (TextUtils.isEmpty(strCc)) {
            if (str.equals("ad")) {
                strCc = DmF.MY().tV();
            } else if (str.equals("adv3")) {
                strCc = DmF.MY().tV() + "_v3";
            }
        }
        final String str2 = strCc;
        mmj.IlO(new lEW("saveUGenTemplate") { // from class: com.bytedance.sdk.openadsdk.core.NV.IlO.MY.1
            @Override // java.lang.Runnable
            public void run() {
                MY.this.IlO(string, strEO, strMY, strTV, str2);
            }
        }, 10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void MY() {
        int iTV = cl.tV().tV();
        if (iTV <= 0) {
            iTV = 100;
        }
        List<com.bytedance.sdk.openadsdk.core.NV.IlO.IlO> listMY = EO.IlO().MY();
        if (listMY == null || listMY.isEmpty() || iTV >= listMY.size()) {
            if (listMY == null) {
                return;
            }
            listMY.size();
            return;
        }
        int size = (int) (listMY.size() - (iTV * 0.75f));
        if (size <= 0) {
            return;
        }
        TreeMap treeMap = new TreeMap();
        for (com.bytedance.sdk.openadsdk.core.NV.IlO.IlO ilO : listMY) {
            treeMap.put(ilO.tV(), ilO);
        }
        HashSet hashSet = new HashSet();
        int i2 = 0;
        for (Map.Entry entry : treeMap.entrySet()) {
            if (entry != null && i2 < size) {
                i2++;
                com.bytedance.sdk.openadsdk.core.NV.IlO.IlO ilO2 = (com.bytedance.sdk.openadsdk.core.NV.IlO.IlO) entry.getValue();
                if (ilO2 != null) {
                    hashSet.add(ilO2.IlO());
                }
            }
        }
        IlO(hashSet);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void IlO(String str, String str2, String str3, String str4, String str5) {
        if (IlO(str, str3) != null) {
            if (TextUtils.isEmpty(str4) || TextUtils.isEmpty(str3)) {
                return;
            }
            MY(str2, str3, str5, str4, str);
            return;
        }
        if (TextUtils.isEmpty(str4)) {
            IlO(str2, str, str3, str5, (IlO) null);
        } else {
            MY(str2, str3, str5, str4, str);
        }
    }

    public void IlO(String str, String str2, String str3, String str4, String str5, final IlO ilO) {
        if (TextUtils.isEmpty(str3) || TextUtils.isEmpty(str4)) {
            if (ilO != null) {
                ilO.IlO(1, "id  or md5 is empty", "net");
                return;
            }
            return;
        }
        String strD = a.D(str, "_", str3);
        com.bytedance.sdk.openadsdk.core.NV.IlO.IlO IlO2 = IlO(strD, str4);
        if (IlO2 != null && !TextUtils.isEmpty(IlO2.Cc())) {
            IlO(IlO2);
            if (ilO != null) {
                try {
                    ilO.IlO(new JSONObject(IlO2.Cc()), "local");
                    return;
                } catch (JSONException unused) {
                    ilO.IlO(2, "parse json exception data is " + IlO2.Cc(), "local");
                    return;
                }
            }
            return;
        }
        IlO(str2, strD, str4, str5, new IlO() { // from class: com.bytedance.sdk.openadsdk.core.NV.IlO.MY.2
            @Override // com.bytedance.sdk.openadsdk.core.NV.IlO.MY.IlO
            public void IlO(JSONObject jSONObject, String str6) {
                IlO ilO2 = ilO;
                if (ilO2 != null) {
                    ilO2.IlO(jSONObject, str6);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.NV.IlO.MY.IlO
            public void IlO(int i2, String str6, String str7) {
                IlO ilO2 = ilO;
                if (ilO2 != null) {
                    ilO2.IlO(i2, str6, str7);
                }
            }
        });
    }

    private void IlO(final String str, final String str2, final String str3, final String str4, final IlO ilO) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            if (ilO != null) {
                ilO.IlO(1, "template url or id  or md5 is empty", "net");
            }
        } else {
            com.bytedance.sdk.component.Bc.MY.MY myEO = Bc.IlO().MY().EO();
            myEO.MY(str);
            myEO.IlO(7);
            myEO.IlO("load_ug_t");
            myEO.IlO(new com.bytedance.sdk.component.Bc.IlO.IlO() { // from class: com.bytedance.sdk.openadsdk.core.NV.IlO.MY.3
                @Override // com.bytedance.sdk.component.Bc.IlO.IlO
                public void IlO(com.bytedance.sdk.component.Bc.MY.EO eo, com.bytedance.sdk.component.Bc.MY my) {
                    if (my == null) {
                        return;
                    }
                    if (!my.vCE()) {
                        IlO ilO2 = ilO;
                        if (ilO2 != null) {
                            ilO2.IlO(3, "net code error code is " + my.IlO() + " message is " + my.MY(), "net");
                            return;
                        }
                        return;
                    }
                    String strTV = my.tV();
                    if (TextUtils.isEmpty(strTV)) {
                        IlO ilO3 = ilO;
                        if (ilO3 != null) {
                            ilO3.IlO(3, "net data is null", "net");
                            return;
                        }
                        return;
                    }
                    EO.IlO().IlO(new com.bytedance.sdk.openadsdk.core.NV.IlO.IlO().IlO(str2).MY(str3).EO(str).Cc(str4).tV(strTV).IlO(Long.valueOf(System.currentTimeMillis())));
                    MY.this.MY();
                    if (ilO != null) {
                        try {
                            ilO.IlO(new JSONObject(strTV), "net");
                        } catch (JSONException unused) {
                            ilO.IlO(2, "parse json exception data is".concat(String.valueOf(strTV)), "net");
                        }
                    }
                }

                @Override // com.bytedance.sdk.component.Bc.IlO.IlO
                public void IlO(com.bytedance.sdk.component.Bc.MY.EO eo, IOException iOException) {
                    IlO ilO2 = ilO;
                    if (ilO2 != null) {
                        ilO2.IlO(3, "net error " + iOException.getMessage(), "net");
                    }
                }
            });
        }
    }

    public Set<com.bytedance.sdk.openadsdk.core.NV.IlO.IlO> IlO(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return EO.IlO().IlO(str);
    }

    public String IlO(String str, String str2, String str3) {
        com.bytedance.sdk.openadsdk.core.NV.IlO.IlO IlO2 = IlO(a.D(str, "_", str2), str3);
        if (IlO2 == null) {
            return null;
        }
        IlO(IlO2);
        return IlO2.Cc();
    }

    private com.bytedance.sdk.openadsdk.core.NV.IlO.IlO IlO(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        return EO.IlO().IlO(str, str2);
    }

    private void IlO(final com.bytedance.sdk.openadsdk.core.NV.IlO.IlO ilO) {
        ilO.IlO(Long.valueOf(System.currentTimeMillis()));
        mmj.IlO(new lEW("updateTmplTime") { // from class: com.bytedance.sdk.openadsdk.core.NV.IlO.MY.4
            @Override // java.lang.Runnable
            public void run() {
                EO.IlO().IlO(ilO);
            }
        }, 10);
    }

    public void IlO(Set<String> set) {
        try {
            EO.IlO().IlO(set);
        } catch (Throwable th) {
            th.getMessage();
        }
    }
}
