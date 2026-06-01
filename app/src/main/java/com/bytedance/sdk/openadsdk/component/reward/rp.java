package com.bytedance.sdk.openadsdk.component.reward;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import b0.b;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.CacheDirFactory;
import com.bytedance.sdk.openadsdk.common.IlO;
import com.bytedance.sdk.openadsdk.core.cl;
import com.bytedance.sdk.openadsdk.core.model.OOq;
import com.bytedance.sdk.openadsdk.core.model.oeT;
import java.io.File;
import java.io.FileFilter;
import java.util.Iterator;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class rp {
    private static volatile rp IlO;
    private final IlO.C0074IlO EO;
    private final Context MY;

    private rp(Context context) {
        this.MY = context == null ? cl.IlO() : context.getApplicationContext();
        this.EO = new IlO.C0074IlO("sp_reward_video");
    }

    private boolean MY(oeT oet) {
        if (oet != null) {
            return OOq.EO(oet) || oet.fdM() != null;
        }
        return false;
    }

    public void IlO(String str, oeT oet) {
        if (com.bytedance.sdk.openadsdk.common.IlO.IlO()) {
            com.bytedance.sdk.openadsdk.common.IlO.IlO("sp_reward_video").IlO(str, oet);
            return;
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String strEO = this.EO.EO(str);
        String strJAC = oet != null ? oet.JAC() : "";
        if (TextUtils.isEmpty(strEO) || TextUtils.isEmpty(strJAC) || strEO.equals(strJAC)) {
            this.EO.DmF(str);
        }
    }

    public void IlO() {
        File[] fileArrListFiles;
        String str;
        File file;
        File[] fileArrListFiles2;
        if (com.bytedance.sdk.openadsdk.common.IlO.IlO()) {
            com.bytedance.sdk.openadsdk.common.IlO.IlO("sp_reward_video").MY();
            return;
        }
        try {
            int i2 = Build.VERSION.SDK_INT;
            boolean zBc = com.bytedance.sdk.openadsdk.core.DmF.Bc("sp_reward_video");
            if (zBc) {
                str = "files";
            } else {
                str = "shared_prefs";
            }
            if (i2 >= 24) {
                file = new File(this.MY.getDataDir(), str);
            } else {
                file = new File(this.MY.getDatabasePath("1").getParentFile().getParentFile(), str);
            }
            if (file.exists() && file.isDirectory() && (fileArrListFiles2 = file.listFiles(new FileFilter() { // from class: com.bytedance.sdk.openadsdk.component.reward.rp.1
                @Override // java.io.FileFilter
                public boolean accept(File file2) {
                    if (file2 != null) {
                        return file2.getName().contains("sp_reward_video");
                    }
                    return false;
                }
            })) != null) {
                for (File file2 : fileArrListFiles2) {
                    if (zBc) {
                        try {
                            com.bytedance.sdk.component.utils.Bc.EO(file2);
                        } catch (Throwable unused) {
                        }
                    } else {
                        String strReplace = file2.getName().replace(".xml", "");
                        if (Build.VERSION.SDK_INT >= 24) {
                            this.MY.deleteSharedPreferences(strReplace);
                        } else {
                            this.MY.getSharedPreferences(strReplace, 0).edit().clear().apply();
                            com.bytedance.sdk.component.utils.Bc.EO(file2);
                        }
                    }
                }
            }
        } catch (Throwable unused2) {
        }
        try {
            File cacheDir = this.MY.getCacheDir();
            if (cacheDir == null || !cacheDir.exists() || !cacheDir.isDirectory() || (fileArrListFiles = cacheDir.listFiles(new FileFilter() { // from class: com.bytedance.sdk.openadsdk.component.reward.rp.2
                @Override // java.io.FileFilter
                public boolean accept(File file3) {
                    if (file3 != null) {
                        return file3.getName().contains("reward_video_cache");
                    }
                    return false;
                }
            })) == null) {
                return;
            }
            for (File file3 : fileArrListFiles) {
                try {
                    com.bytedance.sdk.component.utils.Bc.EO(file3);
                } catch (Throwable unused3) {
                }
            }
        } catch (Throwable unused4) {
        }
    }

    public void IlO(AdSlot adSlot, com.bytedance.sdk.openadsdk.core.model.IlO ilO) {
        oeT oetVCE;
        if (ilO == null || ilO.vCE() == null || !ilO.vCE().uAj()) {
            if (com.bytedance.sdk.openadsdk.common.IlO.IlO()) {
                com.bytedance.sdk.openadsdk.common.IlO.IlO("sp_reward_video").IlO(adSlot, ilO);
                return;
            }
            if (ilO == null || ilO.EV() || adSlot == null || !TextUtils.isEmpty(adSlot.getBidAdm()) || (oetVCE = ilO.vCE()) == null || oetVCE.ps() == 2) {
                return;
            }
            String strMY = ilO.MY();
            synchronized (ilO) {
                try {
                    if (!ilO.EV()) {
                        try {
                            this.EO.IlO(adSlot, ilO.bWL().toString(), strMY);
                        } catch (Throwable unused) {
                            ilO.rp();
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public static rp IlO(Context context) {
        if (IlO == null) {
            synchronized (rp.class) {
                try {
                    if (IlO == null) {
                        IlO = new rp(context);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return IlO;
    }

    public String IlO(oeT oet) {
        if (com.bytedance.sdk.openadsdk.common.IlO.IlO()) {
            return com.bytedance.sdk.openadsdk.common.IlO.IlO("sp_reward_video").IlO(oet);
        }
        if (oet == null || oet.fdM() == null || TextUtils.isEmpty(oet.fdM().g)) {
            return null;
        }
        return IlO(oet.fdM().g, oet.fdM().a(), oet.hHv());
    }

    public String IlO(String str, String str2, int i2) {
        File fileIlO;
        if (com.bytedance.sdk.openadsdk.common.IlO.IlO()) {
            return com.bytedance.sdk.openadsdk.common.IlO.IlO("sp_reward_video").IlO(str, str2, i2);
        }
        if (!TextUtils.isEmpty(str) && (fileIlO = IlO(str2, i2)) != null && fileIlO.exists() && fileIlO.isFile() && fileIlO.length() > 0) {
            return fileIlO.getAbsolutePath();
        }
        return null;
    }

    public com.bytedance.sdk.openadsdk.core.model.IlO IlO(String str, boolean z2) {
        com.bytedance.sdk.openadsdk.core.model.IlO ilOEO;
        if (com.bytedance.sdk.openadsdk.common.IlO.IlO()) {
            com.bytedance.sdk.openadsdk.common.IlO IlO2 = com.bytedance.sdk.openadsdk.common.IlO.IlO("sp_reward_video");
            com.bytedance.sdk.openadsdk.core.model.IlO IlO3 = IlO2.IlO(str, 10500000L);
            if (z2 && IlO3 != null && Cc.MY() == 2 && IlO2.EO(str)) {
                return null;
            }
            return IlO3;
        }
        long jCc = this.EO.Cc(str);
        boolean zVCE = this.EO.vCE(str);
        boolean zLEW = this.EO.lEW(str);
        int iMY = Cc.MY();
        if (System.currentTimeMillis() - jCc < 10500000 && !zVCE && (!z2 || iMY != 2 || !zLEW)) {
            try {
                String strMY = this.EO.MY(str);
                if (!TextUtils.isEmpty(strMY)) {
                    JSONObject jSONObject = new JSONObject(strMY);
                    if (jSONObject.has("cypher")) {
                        jSONObject = cl.EO().IlO(jSONObject);
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
                        Iterator<oeT> it = ilOEO.tV().iterator();
                        while (it.hasNext()) {
                            if (!MY(it.next())) {
                                it.remove();
                            }
                        }
                        if (ilOEO.Cc()) {
                            return ilOEO;
                        }
                    }
                }
            } catch (Exception unused) {
            }
        }
        return null;
    }

    private File IlO(String str, int i2) {
        return new File(((b) CacheDirFactory.getICacheDir(i2)).c(), str);
    }

    public void IlO(String str) {
        if (com.bytedance.sdk.openadsdk.common.IlO.IlO()) {
            com.bytedance.sdk.openadsdk.common.IlO.IlO("sp_reward_video").MY(str);
        } else {
            this.EO.Bc(str);
        }
    }
}
