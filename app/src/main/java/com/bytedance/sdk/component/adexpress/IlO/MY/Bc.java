package com.bytedance.sdk.component.adexpress.IlO.MY;

import android.text.TextUtils;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class Bc {
    private static volatile Bc IlO;
    private AtomicBoolean MY = new AtomicBoolean(false);

    private Bc() {
    }

    private JSONObject EO(String str) {
        com.bytedance.sdk.component.adexpress.IlO.IlO.EO EO = com.bytedance.sdk.component.adexpress.IlO.IlO.IlO.IlO().EO();
        if (EO == null) {
            return null;
        }
        com.bytedance.sdk.component.Bc.MY.MY myBc = EO.Bc();
        myBc.MY(str);
        com.bytedance.sdk.component.Bc.MY myIlO = myBc.IlO();
        if (myIlO != null) {
            try {
                if (myIlO.vCE() && myIlO.tV() != null) {
                    return new JSONObject(myIlO.tV());
                }
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public Set<String> MY(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return vCE.IlO().MY(str);
    }

    public static Bc IlO() {
        if (IlO == null) {
            synchronized (Bc.class) {
                try {
                    if (IlO == null) {
                        IlO = new Bc();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return IlO;
    }

    private void MY() {
        if (com.bytedance.sdk.component.adexpress.IlO.IlO.IlO.IlO().EO() == null) {
            return;
        }
        int iIlO = com.bytedance.sdk.component.adexpress.IlO.IlO.IlO.IlO().EO().IlO();
        if (iIlO <= 0) {
            iIlO = 100;
        }
        List<com.bytedance.sdk.component.adexpress.IlO.EO.MY> listMY = vCE.IlO().MY();
        if (listMY == null || listMY.isEmpty() || iIlO >= listMY.size()) {
            if (listMY == null) {
                return;
            }
            listMY.size();
            return;
        }
        TreeMap treeMap = new TreeMap();
        for (com.bytedance.sdk.component.adexpress.IlO.EO.MY my : listMY) {
            treeMap.put(my.Bc(), my);
        }
        HashSet hashSet = new HashSet();
        int size = (int) (listMY.size() - (iIlO * 0.75f));
        int i2 = 0;
        for (Map.Entry entry : treeMap.entrySet()) {
            if (entry != null && i2 < size) {
                i2++;
                ((Long) entry.getKey()).getClass();
                com.bytedance.sdk.component.adexpress.IlO.EO.MY my2 = (com.bytedance.sdk.component.adexpress.IlO.EO.MY) entry.getValue();
                if (my2 != null) {
                    hashSet.add(my2.MY());
                }
            }
        }
        IlO(hashSet);
        this.MY.set(false);
    }

    public com.bytedance.sdk.component.adexpress.IlO.EO.MY IlO(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return vCE.IlO().IlO(str);
    }

    public void IlO(com.bytedance.sdk.component.adexpress.IlO.EO.tV tVVar, String str) {
        String strLEW;
        if (tVVar == null) {
            return;
        }
        final String str2 = tVVar.IlO;
        final String str3 = tVVar.EO;
        final String str4 = tVVar.MY;
        final String str5 = tVVar.tV;
        final String str6 = tVVar.Cc;
        if (com.bytedance.sdk.component.adexpress.IlO.IlO.IlO.IlO().EO() != null) {
            strLEW = com.bytedance.sdk.component.adexpress.IlO.IlO.IlO.IlO().EO().lEW();
        } else {
            strLEW = "";
        }
        final String str7 = TextUtils.isEmpty(str) ? strLEW : str;
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        com.bytedance.sdk.component.adexpress.tV.tV.IlO(new com.bytedance.sdk.component.lEW.lEW("saveTemplate") { // from class: com.bytedance.sdk.component.adexpress.IlO.MY.Bc.1
            @Override // java.lang.Runnable
            public void run() throws Throwable {
                Bc.this.IlO(str2, str3, str4, str5, str6, str7);
            }
        }, 10);
    }

    private void MY(String str, String str2, String str3, String str4, String str5, String str6) {
        vCE.IlO().IlO(new com.bytedance.sdk.component.adexpress.IlO.EO.MY().IlO(str).MY(str2).EO(str3).tV(str4).Cc(str5).vCE(str6).IlO(Long.valueOf(System.currentTimeMillis())), false);
        MY();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void IlO(String str, String str2, String str3, String str4, String str5, String str6) throws Throwable {
        String str7;
        try {
            try {
                if (IlO(str) != null) {
                    if (!TextUtils.isEmpty(str4)) {
                        if (!TextUtils.isEmpty(str3)) {
                            str7 = str5;
                            MY(str6, str, str3, str2, str4, str7);
                        }
                    }
                    return;
                }
                str7 = str5;
                if (TextUtils.isEmpty(str4) || TextUtils.isEmpty(str3)) {
                    IlO(str2, str6, str);
                } else {
                    MY(str6, str, str3, str2, str4, str7);
                }
                boolean zIlO = lEW.IlO(str7);
                if (!MY.Cc() || zIlO) {
                    Cc.MY().IlO(true);
                }
            } catch (Throwable th) {
                th = th;
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            throw th;
        }
    }

    private void IlO(String str, String str2, String str3) {
        JSONObject jSONObjectEO;
        if (TextUtils.isEmpty(str) || (jSONObjectEO = EO(str)) == null) {
            return;
        }
        String strOptString = jSONObjectEO.optString("md5");
        String strOptString2 = jSONObjectEO.optString("version");
        String strOptString3 = jSONObjectEO.optString("data");
        if (TextUtils.isEmpty(strOptString) || TextUtils.isEmpty(strOptString2) || TextUtils.isEmpty(strOptString3)) {
            return;
        }
        com.bytedance.sdk.component.adexpress.IlO.EO.MY myIlO = new com.bytedance.sdk.component.adexpress.IlO.EO.MY().IlO(str2).MY(str3).EO(strOptString).tV(str).Cc(strOptString3).vCE(strOptString2).IlO(Long.valueOf(System.currentTimeMillis()));
        vCE.IlO().IlO(myIlO, false);
        MY();
        if (lEW.IlO(strOptString2)) {
            myIlO.vCE(strOptString2);
            Cc.MY().IlO(true);
        }
    }

    public void IlO(Set<String> set) {
        try {
            vCE.IlO().IlO(set);
        } catch (Throwable th) {
            th.getMessage();
        }
    }
}
