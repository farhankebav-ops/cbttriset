package com.bytedance.sdk.openadsdk.xF.IlO;

import a1.a;
import android.text.TextUtils;
import android.webkit.WebResourceResponse;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.Key;
import com.bytedance.sdk.component.lEW.lEW;
import com.bytedance.sdk.component.utils.es;
import com.bytedance.sdk.component.utils.lMM;
import com.bytedance.sdk.component.utils.oeT;
import com.bytedance.sdk.component.utils.zPa;
import com.bytedance.sdk.openadsdk.cL.Bc;
import com.bytedance.sdk.openadsdk.core.bWL;
import com.bytedance.sdk.openadsdk.core.cl;
import com.bytedance.sdk.openadsdk.core.settings.DmF;
import com.bytedance.sdk.openadsdk.utils.mmj;
import com.bytedance.sdk.openadsdk.xF.MY.IlO;
import com.ironsource.Q6;
import java.io.File;
import java.io.FileInputStream;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class EO {
    private static volatile EO IlO;
    private final Set<String> Cc = Collections.synchronizedSet(new HashSet());
    private String EO;
    private String MY;
    private String tV;

    private String Cc() {
        if (TextUtils.isEmpty(this.EO)) {
            StringBuilder sb = new StringBuilder();
            sb.append(tV());
            String strR = a.r(sb, File.separator, "common");
            File file = new File(strR);
            if (!file.exists()) {
                file.mkdirs();
            }
            this.EO = strR;
        }
        return this.EO;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void EO() {
        mmj.IlO(new lEW("pag_plb_res_check") { // from class: com.bytedance.sdk.openadsdk.xF.IlO.EO.2
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.sdk.openadsdk.xF.MY.IlO ilOMY = com.bytedance.sdk.openadsdk.xF.MY.IlO.MY(com.bytedance.sdk.openadsdk.multipro.tV.tV.MY("pag_plb_config", Q6.B, ""));
                if (ilOMY != null) {
                    EO.this.IlO(ilOMY, null, 0);
                }
            }
        });
    }

    private String tV() {
        if (TextUtils.isEmpty(this.MY)) {
            try {
                File file = new File(cl.IlO().getCacheDir(), "playable");
                if (!file.exists()) {
                    file.mkdirs();
                }
                this.MY = file.getAbsolutePath();
            } catch (Throwable th) {
                oeT.EO("PlayableResManager", "init root path error: ".concat(String.valueOf(th)));
            }
        }
        return this.MY;
    }

    private String vCE() {
        if (TextUtils.isEmpty(this.tV)) {
            StringBuilder sb = new StringBuilder();
            sb.append(tV());
            String strR = a.r(sb, File.separator, "pregames");
            File file = new File(strR);
            if (!file.exists()) {
                file.mkdirs();
            }
            this.tV = strR;
        }
        return this.tV;
    }

    public void MY() {
        if (DmF.IlO() && com.bytedance.sdk.openadsdk.AXM.IlO.IlO("plb_res_enable", 0) == 1) {
            long jCurrentTimeMillis = System.currentTimeMillis() - com.bytedance.sdk.openadsdk.multipro.tV.tV.IlO("pag_plb_config", "last_update_time", 0L);
            final String strIlO = com.bytedance.sdk.openadsdk.AXM.IlO.IlO("plb_res", "");
            long jIlO = com.bytedance.sdk.openadsdk.AXM.IlO.IlO("plb_res_fetch_interval", 3600000);
            if (jIlO <= 0 || jIlO > 259200000) {
                jIlO = 3600000;
            }
            if (jCurrentTimeMillis < jIlO || TextUtils.isEmpty(strIlO)) {
                return;
            }
            int iIlO = com.bytedance.sdk.openadsdk.AXM.IlO.IlO("plb_res_delay_fetch_time", 0);
            if (iIlO <= 0) {
                MY(strIlO);
            } else {
                bWL.MY().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.xF.IlO.EO.3
                    @Override // java.lang.Runnable
                    public void run() {
                        EO.this.MY(strIlO);
                    }
                }, iIlO);
            }
        }
    }

    private static String EO(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        int iIndexOf = str.indexOf("?");
        if (iIndexOf != -1) {
            str = str.substring(0, iIndexOf);
        }
        int iLastIndexOf = str.lastIndexOf(".");
        if (iLastIndexOf == -1) {
            return "";
        }
        return "." + str.substring(iLastIndexOf + 1);
    }

    public static EO IlO() {
        if (IlO == null) {
            synchronized (EO.class) {
                try {
                    if (IlO == null) {
                        IlO = new EO();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return IlO;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void MY(final String str) {
        mmj.IlO(new lEW("pag_plb_update_config") { // from class: com.bytedance.sdk.openadsdk.xF.IlO.EO.4
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.sdk.component.Bc.MY.MY myEO = Bc.IlO().MY().EO();
                try {
                    myEO.MY(com.bytedance.sdk.openadsdk.lEW.tV.IlO(myEO, str));
                    com.bytedance.sdk.component.Bc.MY myIlO = myEO.IlO();
                    if (myIlO == null || !myIlO.vCE()) {
                        return;
                    }
                    String strTV = myIlO.tV();
                    com.bytedance.sdk.openadsdk.xF.MY.IlO ilOMY = com.bytedance.sdk.openadsdk.xF.MY.IlO.MY(strTV);
                    com.bytedance.sdk.openadsdk.multipro.tV.tV.IlO("pag_plb_config", "last_update_time", Long.valueOf(System.currentTimeMillis()));
                    if (ilOMY != null) {
                        com.bytedance.sdk.openadsdk.xF.MY.IlO ilOMY2 = com.bytedance.sdk.openadsdk.xF.MY.IlO.MY(com.bytedance.sdk.openadsdk.multipro.tV.tV.MY("pag_plb_config", Q6.B, ""));
                        if (ilOMY2 != null && ilOMY.IlO().equals(ilOMY2.IlO())) {
                            return;
                        }
                        com.bytedance.sdk.openadsdk.multipro.tV.tV.IlO("pag_plb_config", Q6.B, strTV);
                        EO.this.IlO(ilOMY, ilOMY2, 1);
                    }
                } catch (Exception e) {
                    oeT.EO("PlayableResManager", e.getMessage());
                }
            }
        });
    }

    public void IlO(Map<String, String> map) {
        File[] fileArrListFiles;
        if (DmF.IlO() && com.bytedance.sdk.openadsdk.AXM.IlO.IlO("plb_res_enable", 0) == 1) {
            String strVCE = vCE();
            if (!TextUtils.isEmpty(strVCE)) {
                File file = new File(strVCE);
                if (file.exists() && file.isDirectory() && (fileArrListFiles = file.listFiles()) != null) {
                    for (File file2 : fileArrListFiles) {
                        if (file2 != null) {
                            try {
                                File fileIlO = com.bytedance.sdk.openadsdk.core.rp.EO.IlO.IlO(file2);
                                if (fileIlO != null && fileIlO.exists()) {
                                    map.put(file2.getName(), fileIlO.getAbsolutePath());
                                }
                            } catch (Throwable unused) {
                            }
                        }
                    }
                }
            }
            int iIlO = com.bytedance.sdk.openadsdk.AXM.IlO.IlO("plb_res_delay_fetch_time", 0);
            if (iIlO <= 0) {
                EO();
            } else {
                bWL.MY().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.xF.IlO.EO.1
                    @Override // java.lang.Runnable
                    public void run() {
                        EO.this.EO();
                    }
                }, iIlO);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void IlO(com.bytedance.sdk.openadsdk.xF.MY.IlO ilO, @Nullable com.bytedance.sdk.openadsdk.xF.MY.IlO ilO2, int i2) {
        List<IlO.C0124IlO> listEO = null;
        IlO(ilO.MY(), ilO2 == null ? null : ilO2.MY(), 1, i2);
        List<IlO.C0124IlO> listEO2 = ilO.EO();
        if (ilO2 != null) {
            listEO = ilO2.EO();
        }
        IlO(listEO2, listEO, 2, i2);
    }

    private void IlO(@Nullable List<IlO.C0124IlO> list, @Nullable List<IlO.C0124IlO> list2, int i2, int i8) {
        if (list == null || list.isEmpty()) {
            return;
        }
        String strCc = i2 == 1 ? Cc() : vCE();
        for (IlO.C0124IlO c0124IlO : list) {
            String strIlO = c0124IlO.IlO();
            String strIlO2 = zPa.IlO(strIlO);
            if (!TextUtils.isEmpty(strIlO2)) {
                if (i2 == 1) {
                    StringBuilder sbR = androidx.camera.core.processing.util.a.r(strIlO2);
                    sbR.append(EO(strIlO));
                    strIlO2 = sbR.toString();
                }
                String str = strIlO2;
                File file = new File(strCc, str);
                boolean zExists = file.exists();
                if (i8 == 1) {
                    if (zExists && list2 != null && list2.contains(c0124IlO)) {
                        com.bytedance.sdk.openadsdk.core.rp.EO.IlO.EO(file);
                    } else {
                        int i9 = i2;
                        IlO(strIlO, strCc, str, i9, file, zExists);
                        i2 = i9;
                    }
                } else if (!zExists) {
                    int i92 = i2;
                    IlO(strIlO, strCc, str, i92, file, zExists);
                    i2 = i92;
                }
            }
        }
    }

    private void IlO(final String str, final String str2, final String str3, final int i2, final File file, final boolean z2) {
        String strConcat;
        if (this.Cc.contains(str)) {
            return;
        }
        if (i2 == 2) {
            strConcat = a.C(str3, ".zip");
        } else {
            strConcat = z2 ? "tmp".concat(String.valueOf(str3)) : str3;
        }
        this.Cc.add(str);
        com.bytedance.sdk.component.Bc.MY.IlO ilOTV = Bc.IlO().MY().tV();
        ilOTV.MY(str);
        ilOTV.IlO(str2, strConcat);
        final com.bytedance.sdk.component.Bc.MY myIlO = ilOTV.IlO();
        this.Cc.remove(str);
        if (myIlO == null || !myIlO.vCE() || myIlO.Cc() == null || !myIlO.Cc().exists()) {
            File file2 = new File(a.s(androidx.camera.core.processing.util.a.r(str2), File.separator, str3, ".tmp"));
            if (file2.exists()) {
                try {
                    file2.delete();
                    return;
                } catch (Throwable unused) {
                    return;
                }
            }
            return;
        }
        if (i2 == 2) {
            mmj.MY(new lEW("downloadZip") { // from class: com.bytedance.sdk.openadsdk.xF.IlO.EO.5
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (z2) {
                            file.delete();
                        }
                        String str4 = str2 + File.separator + str3;
                        lMM.IlO(myIlO.Cc().getAbsolutePath(), str4);
                        File file3 = new File(str4);
                        File fileIlO = com.bytedance.sdk.openadsdk.core.rp.EO.IlO.IlO(file3);
                        if (fileIlO != null && fileIlO.exists()) {
                            com.bytedance.sdk.openadsdk.core.rp.EO.IlO.IlO().EO().put(file3.getName(), fileIlO.getAbsolutePath());
                        }
                        com.bytedance.sdk.openadsdk.core.rp.EO.IlO.MY(file3);
                    } catch (Throwable th) {
                        oeT.EO("PlayableResManager", "unzip error: ", th, "tp=", Integer.valueOf(i2), ", url=", str);
                    }
                    try {
                        myIlO.Cc().delete();
                    } catch (Throwable unused2) {
                    }
                }
            });
        } else if (z2) {
            file.delete();
            myIlO.Cc().renameTo(file);
        }
    }

    public WebResourceResponse IlO(String str) {
        if (DmF.IlO() && com.bytedance.sdk.openadsdk.AXM.IlO.IlO("plb_res_enable", 0) == 1) {
            String strIlO = zPa.IlO(str);
            if (TextUtils.isEmpty(strIlO)) {
                return null;
            }
            String strCc = Cc();
            StringBuilder sbR = androidx.camera.core.processing.util.a.r(strIlO);
            sbR.append(EO(str));
            File file = new File(strCc, sbR.toString());
            if (file.exists()) {
                try {
                    return new WebResourceResponse(es.IlO(cl.IlO(), str), Key.STRING_CHARSET_NAME, new FileInputStream(file));
                } catch (Throwable unused) {
                }
            }
        }
        return null;
    }
}
