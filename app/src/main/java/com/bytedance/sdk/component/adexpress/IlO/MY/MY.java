package com.bytedance.sdk.component.adexpress.IlO.MY;

import android.text.TextUtils;
import android.util.Pair;
import android.webkit.WebResourceResponse;
import com.bytedance.sdk.component.adexpress.IlO.EO.IlO;
import com.bytedance.sdk.component.adexpress.tV.DmF;
import com.ironsource.G5;
import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class MY {
    static Object IlO = new Object();

    private static File Bc(String str) {
        List<Pair<String, String>> listMY;
        IlO.MY myCc = tV().Cc();
        if (myCc != null && (listMY = myCc.MY()) != null && listMY.size() > 0) {
            for (Pair<String, String> pair : listMY) {
                Object obj = pair.second;
                if (obj != null && ((String) obj).equals(str)) {
                    return new File(Cc.lEW(), (String) pair.first);
                }
            }
        }
        return null;
    }

    public static boolean Cc() {
        return Cc.MY().Cc();
    }

    public static String EO() {
        return vCE.EO();
    }

    public static void IlO() {
        Cc.MY();
    }

    public static void MY() {
        try {
            lEW.tV();
            File fileLEW = Cc.lEW();
            if (fileLEW == null || !fileLEW.exists()) {
                return;
            }
            if (fileLEW.getParentFile() != null) {
                com.bytedance.sdk.component.utils.Bc.EO(fileLEW.getParentFile());
            } else {
                com.bytedance.sdk.component.utils.Bc.EO(fileLEW);
            }
        } catch (Throwable unused) {
        }
    }

    public static com.bytedance.sdk.component.adexpress.IlO.EO.IlO tV() {
        return Cc.MY().vCE();
    }

    @Deprecated
    private static String vCE() {
        com.bytedance.sdk.component.adexpress.IlO.EO.IlO ilOTV = tV();
        if (ilOTV == null) {
            return null;
        }
        return ilOTV.tV();
    }

    private static boolean Cc(String str) {
        com.bytedance.sdk.component.adexpress.IlO.EO.IlO ilOTV;
        List<IlO.C0049IlO> listVCE;
        if (!Cc() || (ilOTV = tV()) == null || (listVCE = ilOTV.vCE()) == null) {
            return false;
        }
        for (IlO.C0049IlO c0049IlO : listVCE) {
            if (c0049IlO != null && TextUtils.equals(str, c0049IlO.IlO())) {
                return true;
            }
        }
        return false;
    }

    public static com.bytedance.sdk.component.adexpress.IlO.EO.MY EO(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        com.bytedance.sdk.component.adexpress.IlO.EO.MY myIlO = Bc.IlO().IlO(str);
        if (myIlO != null) {
            myIlO.IlO(Long.valueOf(System.currentTimeMillis()));
            IlO(myIlO);
        }
        return myIlO;
    }

    public static com.bytedance.sdk.component.adexpress.IlO.EO.MY IlO(String str) {
        return Bc.IlO().IlO(str);
    }

    public static String tV(String str) {
        com.bytedance.sdk.component.adexpress.IlO.EO.IlO ilO;
        com.bytedance.sdk.component.adexpress.IlO.EO.IlO ilOTV = tV();
        if (ilOTV == null) {
            return null;
        }
        if (TextUtils.isEmpty(str)) {
            return vCE();
        }
        Map<String, com.bytedance.sdk.component.adexpress.IlO.EO.IlO> mapIlO = ilOTV.IlO();
        if (mapIlO == null || mapIlO.size() <= 0 || (ilO = mapIlO.get(str)) == null) {
            return null;
        }
        return ilO.tV();
    }

    public static void IlO(com.bytedance.sdk.component.adexpress.IlO.EO.tV tVVar) {
        Bc.IlO().IlO(tVVar, tVVar.vCE);
    }

    private static File vCE(String str) {
        if (Cc()) {
            Iterator<IlO.C0049IlO> it = tV().vCE().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                IlO.C0049IlO next = it.next();
                if (next.IlO() != null && next.IlO().equals(str)) {
                    File file = new File(Cc.lEW(), com.bytedance.sdk.component.utils.Cc.IlO(next.IlO()));
                    String strIlO = com.bytedance.sdk.component.utils.Cc.IlO(file);
                    if (next.MY() == null || !next.MY().equals(strIlO)) {
                        break;
                    }
                    return file;
                }
            }
        }
        return null;
    }

    private static void IlO(final com.bytedance.sdk.component.adexpress.IlO.EO.MY my) {
        com.bytedance.sdk.component.adexpress.tV.tV.IlO(new com.bytedance.sdk.component.lEW.lEW("updateTmplTime") { // from class: com.bytedance.sdk.component.adexpress.IlO.MY.MY.1
            @Override // java.lang.Runnable
            public void run() {
                synchronized (MY.IlO) {
                    vCE.IlO().IlO(my, true);
                }
            }
        }, 10);
    }

    public static IlO IlO(String str, DmF.IlO ilO, String str2, String str3) {
        File fileVCE;
        IlO ilO2 = new IlO();
        if (TextUtils.isEmpty(str3)) {
            fileVCE = null;
        } else {
            fileVCE = MY(str3, str);
            if (fileVCE != null) {
                ilO2.IlO(1);
            }
        }
        if (fileVCE == null && (fileVCE = Bc(str)) != null) {
            ilO2.IlO(3);
        }
        if (fileVCE == null && (fileVCE = vCE(str)) != null) {
            ilO2.IlO(2);
        }
        if (!TextUtils.isEmpty(str3)) {
            if (!IlO(str, str3)) {
                ilO2.IlO(4);
            }
        } else if (!Cc(str)) {
            ilO2.IlO(6);
        }
        ilO2.MY();
        if (fileVCE != null) {
            try {
                ilO2.IlO(new WebResourceResponse(ilO.IlO(), G5.N, new FileInputStream(fileVCE)));
            } catch (Throwable unused) {
            }
        }
        return ilO2;
    }

    public static boolean EO(JSONObject jSONObject) {
        Object objOpt;
        if (jSONObject == null) {
            return false;
        }
        try {
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("creatives");
            if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
                for (int i2 = 0; i2 < jSONArrayOptJSONArray.length(); i2++) {
                    JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i2);
                    if (jSONObjectOptJSONObject == null || (objOpt = jSONObjectOptJSONObject.opt("template_Plugin")) == null || TextUtils.isEmpty(objOpt.toString())) {
                        return false;
                    }
                }
                return true;
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public static Set<String> MY(String str) {
        return Bc.IlO().MY(str);
    }

    private static File MY(String str, String str2) {
        com.bytedance.sdk.component.adexpress.IlO.EO.IlO ilO;
        com.bytedance.sdk.component.adexpress.IlO.EO.IlO ilOTV = tV();
        if (ilOTV != null && Cc()) {
            Map<String, com.bytedance.sdk.component.adexpress.IlO.EO.IlO> mapIlO = ilOTV.IlO();
            if (mapIlO.size() != 0 && (ilO = mapIlO.get(str)) != null) {
                Iterator<IlO.C0049IlO> it = ilO.vCE().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    IlO.C0049IlO next = it.next();
                    if (next.IlO() != null && next.IlO().equals(str2)) {
                        File file = new File(Cc.lEW(), com.bytedance.sdk.component.utils.Cc.IlO(next.IlO()));
                        String strIlO = com.bytedance.sdk.component.utils.Cc.IlO(file);
                        if (next.MY() == null || !next.MY().equals(strIlO)) {
                            break;
                        }
                        return file;
                    }
                }
            }
        }
        return null;
    }

    public static boolean MY(JSONObject jSONObject) {
        Object objOpt;
        return (jSONObject == null || (objOpt = jSONObject.opt("xTemplate")) == null || TextUtils.isEmpty(objOpt.toString())) ? false : true;
    }

    private static boolean IlO(String str, String str2) {
        com.bytedance.sdk.component.adexpress.IlO.EO.IlO ilOTV;
        com.bytedance.sdk.component.adexpress.IlO.EO.IlO ilO;
        if (!Cc() || (ilOTV = tV()) == null) {
            return false;
        }
        Map<String, com.bytedance.sdk.component.adexpress.IlO.EO.IlO> mapIlO = ilOTV.IlO();
        if (mapIlO.size() == 0 || (ilO = mapIlO.get(str2)) == null) {
            return false;
        }
        for (IlO.C0049IlO c0049IlO : ilO.vCE()) {
            if (c0049IlO != null && TextUtils.equals(str, c0049IlO.IlO())) {
                return true;
            }
        }
        return false;
    }

    public static boolean IlO(JSONObject jSONObject) {
        Object objOpt;
        return (jSONObject == null || (objOpt = jSONObject.opt("template_Plugin")) == null || TextUtils.isEmpty(objOpt.toString())) ? false : true;
    }
}
