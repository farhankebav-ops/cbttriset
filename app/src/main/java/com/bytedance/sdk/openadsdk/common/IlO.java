package com.bytedance.sdk.openadsdk.common;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import b0.b;
import com.bytedance.sdk.component.utils.vAh;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.CacheDirFactory;
import com.bytedance.sdk.openadsdk.core.model.OOq;
import com.bytedance.sdk.openadsdk.core.model.oeT;
import java.io.File;
import java.io.FileFilter;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class IlO {
    private static final HashMap<String, IlO> IlO = new HashMap<>();
    private static final HashMap<String, C0074IlO> MY = new HashMap<>();
    private final String Cc;
    private final Context EO;
    private final C0074IlO tV;
    private final Map<oeT, Long> vCE = Collections.synchronizedMap(new HashMap());

    private IlO(Context context, String str) {
        this.EO = context;
        C0074IlO c0074IlO = MY.get(str);
        this.tV = c0074IlO == null ? new C0074IlO(str) : c0074IlO;
        this.Cc = str;
    }

    private String EO() {
        return ((b) CacheDirFactory.getICacheDir(0)).c();
    }

    public void MY() {
        File[] fileArrListFiles;
        try {
            int i2 = Build.VERSION.SDK_INT;
            boolean zBc = com.bytedance.sdk.openadsdk.core.DmF.Bc(this.Cc);
            String str = zBc ? "files" : "shared_prefs";
            File file = i2 >= 24 ? new File(this.EO.getDataDir(), str) : new File(this.EO.getDatabasePath("1").getParentFile().getParentFile(), str);
            if (file.exists() && file.isDirectory() && (fileArrListFiles = file.listFiles(new FileFilter() { // from class: com.bytedance.sdk.openadsdk.common.IlO.1
                @Override // java.io.FileFilter
                public boolean accept(File file2) {
                    if (file2 != null) {
                        return file2.getName().contains(IlO.this.Cc);
                    }
                    return false;
                }
            })) != null) {
                for (File file2 : fileArrListFiles) {
                    if (zBc) {
                        try {
                            com.bytedance.sdk.component.utils.Bc.EO(file2);
                        } catch (Throwable unused) {
                        }
                    } else {
                        String strReplace = file2.getName().replace(".xml", "");
                        if (Build.VERSION.SDK_INT >= 24) {
                            this.EO.deleteSharedPreferences(strReplace);
                        } else {
                            this.EO.getSharedPreferences(strReplace, 0).edit().clear().apply();
                            com.bytedance.sdk.component.utils.Bc.EO(file2);
                        }
                    }
                }
            }
        } catch (Throwable unused2) {
        }
        try {
            File file3 = new File(EO());
            if (file3.exists() && file3.isDirectory()) {
                com.bytedance.sdk.component.utils.Bc.EO(file3);
            }
        } catch (Throwable unused3) {
        }
    }

    public static boolean IlO() {
        return com.bytedance.sdk.openadsdk.AXM.IlO.IlO("material_cache_disk_format", 0) == 1;
    }

    public boolean EO(String str) {
        return this.tV.lEW(str);
    }

    public static IlO IlO(String str) {
        IlO ilO;
        HashMap<String, IlO> map = IlO;
        IlO ilO2 = map.get(str);
        if (ilO2 != null) {
            return ilO2;
        }
        synchronized (IlO.class) {
            try {
                ilO = map.get(str);
                if (ilO == null) {
                    ilO = new IlO(com.bytedance.sdk.openadsdk.core.cl.IlO(), str);
                    map.put(str, ilO);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return ilO;
    }

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.common.IlO$IlO, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class C0074IlO {
        protected final String IlO;
        private final HashSet<String> lEW = new HashSet<>();
        String MY = "material_data";
        String EO = "has_played";
        String tV = "create_time";
        String Cc = "in_use_process";
        String vCE = "req_id";
        String Bc = "ad_slot";

        public C0074IlO(String str) {
            this.IlO = TextUtils.isEmpty(str) ? "" : str;
        }

        public void Bc(String str) {
            try {
                com.bytedance.sdk.openadsdk.multipro.tV.tV.IlO(IlO(str), this.Cc, vAh.MY(com.bytedance.sdk.openadsdk.core.cl.IlO()));
                this.lEW.add(str);
            } catch (Throwable unused) {
            }
        }

        public long Cc(String str) {
            try {
                return com.bytedance.sdk.openadsdk.multipro.tV.tV.IlO(IlO(str), this.tV, 0L);
            } catch (Throwable unused) {
                return 0L;
            }
        }

        public void DmF(String str) {
            try {
                com.bytedance.sdk.openadsdk.multipro.tV.tV.IlO(IlO(str));
                this.lEW.remove(str);
            } catch (Throwable unused) {
            }
        }

        public String EO(String str) {
            try {
                return com.bytedance.sdk.openadsdk.multipro.tV.tV.MY(IlO(str), this.vCE, null);
            } catch (Throwable unused) {
                return null;
            }
        }

        public String IlO(String str) {
            if (TextUtils.isEmpty(str)) {
                str = "0";
            }
            return a1.a.s(new StringBuilder(), this.IlO, "_cache_", str);
        }

        public String MY(String str) {
            try {
                return com.bytedance.sdk.openadsdk.multipro.tV.tV.MY(IlO(str), this.MY, null);
            } catch (Throwable unused) {
                return null;
            }
        }

        public boolean lEW(String str) {
            try {
                String strIlO = IlO(str);
                String strMY = com.bytedance.sdk.openadsdk.multipro.tV.tV.MY(strIlO, this.Cc, "");
                if (TextUtils.isEmpty(strMY)) {
                    return false;
                }
                if (strMY.equals(vAh.MY(com.bytedance.sdk.openadsdk.core.cl.IlO())) && !this.lEW.contains(str)) {
                    com.bytedance.sdk.openadsdk.multipro.tV.tV.IlO(strIlO, this.Cc, "");
                    return false;
                }
            } catch (Throwable unused) {
            }
            return true;
        }

        public String tV(String str) {
            try {
                return com.bytedance.sdk.openadsdk.multipro.tV.tV.MY(IlO(str), this.Bc, null);
            } catch (Throwable unused) {
                return null;
            }
        }

        public boolean vCE(String str) {
            try {
                return com.bytedance.sdk.openadsdk.multipro.tV.tV.IlO(IlO(str), this.EO, true);
            } catch (Throwable unused) {
                return true;
            }
        }

        public void IlO(AdSlot adSlot, String str, String str2) {
            try {
                String codeId = adSlot.getCodeId();
                String strIlO = IlO(codeId);
                com.bytedance.sdk.openadsdk.multipro.tV.tV.IlO(strIlO, this.EO, Boolean.FALSE);
                com.bytedance.sdk.openadsdk.multipro.tV.tV.IlO(strIlO, this.tV, Long.valueOf(System.currentTimeMillis()));
                com.bytedance.sdk.openadsdk.multipro.tV.tV.IlO(strIlO, this.MY, str);
                com.bytedance.sdk.openadsdk.multipro.tV.tV.IlO(strIlO, this.Cc, "");
                com.bytedance.sdk.openadsdk.multipro.tV.tV.IlO(strIlO, this.vCE, str2);
                com.bytedance.sdk.openadsdk.multipro.tV.tV.IlO(strIlO, this.Bc, adSlot.toJsonObj().toString());
                this.lEW.remove(codeId);
            } catch (Throwable unused) {
            }
        }
    }

    public static void IlO(String str, C0074IlO c0074IlO) {
        MY.put(str, c0074IlO);
    }

    public void IlO(String str, oeT oet) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String strEO = this.tV.EO(str);
        String strJAC = oet != null ? oet.JAC() : "";
        if (TextUtils.isEmpty(strEO) || TextUtils.isEmpty(strJAC) || strEO.equals(strJAC)) {
            this.tV.DmF(str);
        }
    }

    public void IlO(AdSlot adSlot, com.bytedance.sdk.openadsdk.core.model.IlO ilO) {
        oeT oetVCE;
        if ((ilO != null && ilO.vCE() != null && ilO.vCE().uAj()) || ilO == null || adSlot == null || !TextUtils.isEmpty(adSlot.getBidAdm()) || (oetVCE = ilO.vCE()) == null || oetVCE.ps() == 2) {
            return;
        }
        try {
            this.tV.IlO(adSlot, ilO.ea(), ilO.MY());
        } catch (Throwable unused) {
        }
    }

    private boolean MY(oeT oet) {
        if (oet != null) {
            return OOq.cL(oet) || oet.fdM() != null;
        }
        return false;
    }

    public String IlO(oeT oet) {
        if (oet == null || oet.fdM() == null || TextUtils.isEmpty(oet.fdM().g)) {
            return null;
        }
        return IlO(oet.fdM().g, oet.fdM().a(), oet.hHv());
    }

    public void MY(String str) {
        this.tV.Bc(str);
    }

    public String IlO(String str, String str2, int i2) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (TextUtils.isEmpty(str2)) {
            str2 = com.bytedance.sdk.component.utils.Cc.IlO(str);
        }
        File fileIlO = IlO(str2, i2);
        if (fileIlO == null || !fileIlO.exists() || !fileIlO.isFile() || fileIlO.length() <= 0) {
            return null;
        }
        return fileIlO.getAbsolutePath();
    }

    public com.bytedance.sdk.openadsdk.core.model.IlO IlO(String str, boolean z2) {
        com.bytedance.sdk.openadsdk.core.model.IlO ilOEO;
        AdSlot adSlotMY;
        oeT oetVCE;
        try {
            String strMY = this.tV.MY(str);
            if (!TextUtils.isEmpty(strMY)) {
                JSONObject jSONObject = new JSONObject(strMY);
                if (jSONObject.has("cypher")) {
                    jSONObject = com.bytedance.sdk.openadsdk.core.cl.EO().IlO(jSONObject);
                }
                if (jSONObject.has("creatives")) {
                    ilOEO = com.bytedance.sdk.openadsdk.core.model.IlO.EO(jSONObject);
                } else {
                    oeT oetIlO = com.bytedance.sdk.openadsdk.core.MY.IlO(jSONObject);
                    com.bytedance.sdk.openadsdk.core.model.IlO ilO = new com.bytedance.sdk.openadsdk.core.model.IlO();
                    ilO.IlO(oetIlO);
                    ilOEO = ilO;
                }
                if (ilOEO != null && ilOEO.Cc()) {
                    if (z2) {
                        Iterator<oeT> it = ilOEO.tV().iterator();
                        while (it.hasNext()) {
                            if (!MY(it.next())) {
                                it.remove();
                            }
                        }
                    }
                    if (ilOEO.Cc()) {
                        String strTV = this.tV.tV(str);
                        if (!TextUtils.isEmpty(strTV) && (adSlotMY = com.bytedance.sdk.openadsdk.core.MY.MY(new JSONObject(strTV))) != null && (oetVCE = ilOEO.vCE()) != null) {
                            oetVCE.IlO(adSlotMY);
                        }
                        return ilOEO;
                    }
                }
            }
        } catch (JSONException unused) {
        }
        return null;
    }

    public com.bytedance.sdk.openadsdk.core.model.IlO IlO(String str, long j) {
        long jCc = this.tV.Cc(str);
        boolean zVCE = this.tV.vCE(str);
        if (System.currentTimeMillis() - jCc >= j || zVCE) {
            return null;
        }
        return IlO(str, true);
    }

    private File IlO(String str, int i2) {
        return new File(((b) CacheDirFactory.getICacheDir(i2)).c(), str);
    }
}
