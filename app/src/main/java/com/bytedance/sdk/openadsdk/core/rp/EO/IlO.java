package com.bytedance.sdk.openadsdk.core.rp.EO;

import a1.a;
import android.text.TextUtils;
import android.webkit.WebResourceResponse;
import com.bytedance.sdk.component.lEW.lEW;
import com.bytedance.sdk.component.utils.Bc;
import com.bytedance.sdk.component.utils.Cc;
import com.bytedance.sdk.component.utils.es;
import com.bytedance.sdk.component.utils.lMM;
import com.bytedance.sdk.openadsdk.core.DmF;
import com.bytedance.sdk.openadsdk.core.cl;
import com.bytedance.sdk.openadsdk.core.model.OOq;
import com.bytedance.sdk.openadsdk.core.model.oeT;
import com.bytedance.sdk.openadsdk.utils.mmj;
import com.bytedance.sdk.openadsdk.xF.IlO.tV;
import com.ironsource.G5;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class IlO {
    private static volatile IlO IlO;
    private String MY;
    private final Map<oeT, MY> EO = new ConcurrentHashMap();
    private final Map<String, JSONObject> tV = new ConcurrentHashMap();
    private final AtomicBoolean Cc = new AtomicBoolean(false);
    private final Set<String> vCE = Collections.synchronizedSet(new HashSet());
    private final ConcurrentHashMap<String, com.bytedance.sdk.component.Bc.MY.IlO> Bc = new ConcurrentHashMap<>();
    private final Map<String, String> lEW = new ConcurrentHashMap();

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.rp.EO.IlO$IlO, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public interface InterfaceC0104IlO {
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class MY {
        long EO;
        long IlO;
        long MY;
        long tV;

        private MY() {
        }

        public MY EO(long j) {
            this.EO = j;
            return this;
        }

        public long IlO() {
            return this.MY - this.IlO;
        }

        public long MY() {
            return this.tV - this.EO;
        }

        public MY tV(long j) {
            this.tV = j;
            return this;
        }

        public MY IlO(long j) {
            this.IlO = j;
            return this;
        }

        public MY MY(long j) {
            this.MY = j;
            return this;
        }
    }

    private IlO() {
    }

    private boolean Cc(File file) {
        return file != null && file.exists() && file.isFile() && file.canRead();
    }

    public static void EO(File file) {
        try {
            if (!file.exists() || file.setLastModified(System.currentTimeMillis())) {
                return;
            }
            file.renameTo(file);
            file.lastModified();
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public File tV(File file) {
        File file2 = new File(file, "tt_open_ad_sdk_check_res.dat");
        return Cc(file2) ? file2 : new File(file, "tt_open_ad_sdk_check_res.dat");
    }

    public void MY() {
        if (this.Cc.get()) {
            return;
        }
        mmj.IlO(new lEW("PlayableCache_init") { // from class: com.bytedance.sdk.openadsdk.core.rp.EO.IlO.1
            @Override // java.lang.Runnable
            public void run() {
                File[] fileArrListFiles;
                try {
                    String strTV = IlO.this.tV();
                    if (!TextUtils.isEmpty(strTV)) {
                        File file = new File(strTV);
                        if (file.exists() && file.isDirectory() && (fileArrListFiles = file.listFiles()) != null) {
                            for (File file2 : fileArrListFiles) {
                                if (file2 != null) {
                                    try {
                                        File fileIlO = IlO.IlO(file2);
                                        if (fileIlO != null && fileIlO.exists()) {
                                            IlO.this.lEW.put(file2.getName(), fileIlO.getAbsolutePath());
                                        }
                                        IlO.this.IlO(IlO.this.tV(fileIlO), true);
                                    } catch (Throwable unused) {
                                    }
                                }
                            }
                        }
                    }
                } catch (Throwable unused2) {
                }
                com.bytedance.sdk.openadsdk.xF.IlO.EO.IlO().IlO(IlO.this.lEW);
                IlO.this.Cc.set(true);
            }
        });
    }

    private String Cc() {
        if (TextUtils.isEmpty(this.MY)) {
            try {
                File file = new File(cl.IlO().getCacheDir(), "playable");
                if (!file.exists()) {
                    file.mkdirs();
                }
                this.MY = file.getAbsolutePath();
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.oeT.EO("PlayableCache", "init root path error: ".concat(String.valueOf(th)));
            }
        }
        return this.MY;
    }

    public static void MY(File file) {
        EO(file);
        try {
            DmF.MY().zPa().IlO(file);
        } catch (Throwable unused) {
        }
    }

    public static IlO IlO() {
        if (IlO == null) {
            synchronized (IlO.class) {
                try {
                    if (IlO == null) {
                        IlO = new IlO();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return IlO;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String tV() {
        File file = new File(Cc(), "games");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file.getAbsolutePath();
    }

    public void MY(oeT oet) {
        if (oet == null || oet.fdM() == null || TextUtils.isEmpty(oet.fdM().f4690i) || !com.bytedance.sdk.openadsdk.AXM.IlO.IlO("can_cancel_playable", false)) {
            return;
        }
        com.bytedance.sdk.component.Bc.MY.IlO ilO = this.Bc.get(oet.fdM().f4690i);
        if (ilO != null) {
            ilO.MY();
        }
    }

    public Map<String, String> EO() {
        return this.lEW;
    }

    public boolean IlO(oeT oet) {
        if (this.Cc.get() && oet != null && oet.fdM() != null && oet.fdM().f4690i != null) {
            try {
                if (!TextUtils.isEmpty(this.lEW.get(Cc.IlO(oet.fdM().f4690i)))) {
                    return true;
                }
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject IlO(File file, boolean z2) {
        byte[] bArrTV;
        String strMY;
        try {
            if (!Cc(file) || (bArrTV = Bc.tV(file)) == null || bArrTV.length <= 0) {
                return null;
            }
            if (TextUtils.equals(file.getName(), "tt_open_ad_sdk_check_res.dat")) {
                strMY = com.bytedance.sdk.component.utils.IlO.EO(new String(bArrTV));
            } else {
                strMY = com.bytedance.sdk.component.tV.IlO.MY(new String(bArrTV), com.bytedance.sdk.openadsdk.core.IlO.MY());
            }
            if (TextUtils.isEmpty(strMY)) {
                return null;
            }
            JSONObject jSONObject = new JSONObject(strMY);
            if (z2 && jSONObject.length() > 0) {
                this.tV.put(file.getParentFile().getName(), jSONObject);
            }
            return jSONObject;
        } catch (Throwable unused) {
            return null;
        }
    }

    public WebResourceResponse IlO(String str, String str2, String str3) {
        File fileIlO;
        try {
            WebResourceResponse webResourceResponseIlO = com.bytedance.sdk.openadsdk.xF.IlO.EO.IlO().IlO(str3);
            if (webResourceResponseIlO != null) {
                return webResourceResponseIlO;
            }
            if (this.Cc.get() && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
                try {
                    if ((str3.startsWith("http://") || str3.startsWith("https://")) && str3.contains("?")) {
                        str3 = str3.split("\\?")[0];
                        if (str3.endsWith("/")) {
                            str3 = str3.substring(0, str3.length() - 1);
                        }
                    }
                } catch (Throwable unused) {
                }
                String strIlO = es.IlO(cl.IlO(), str3);
                com.bytedance.sdk.openadsdk.ea.EO.EO(strIlO, str3);
                if (TextUtils.isEmpty(strIlO)) {
                    return null;
                }
                String strIlO2 = Cc.IlO(str);
                if (TextUtils.isEmpty(strIlO2)) {
                    return null;
                }
                String str4 = this.lEW.get(strIlO2);
                if (!TextUtils.isEmpty(str4)) {
                    fileIlO = new File(str4);
                } else {
                    fileIlO = IlO(new File(tV(), strIlO2));
                    if (fileIlO != null && fileIlO.exists()) {
                        this.lEW.put(strIlO2, fileIlO.getAbsolutePath());
                    }
                }
                if (fileIlO != null && fileIlO.exists()) {
                    String strIlO3 = IlO(str2);
                    if (TextUtils.isEmpty(strIlO3)) {
                        return null;
                    }
                    String strReplace = str3.replace(strIlO3, "");
                    if (!TextUtils.isEmpty(strReplace) && !strReplace.startsWith("https://") && !strReplace.startsWith("http://")) {
                        File file = new File(fileIlO, strReplace);
                        if (file.exists() && IlO(strIlO2, strReplace, file) && file.getCanonicalPath().startsWith(fileIlO.getCanonicalPath())) {
                            return new WebResourceResponse(strIlO, G5.N, new FileInputStream(file));
                        }
                    }
                }
            }
            return null;
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.oeT.IlO("PlayableCache", "playable intercept error: ", th);
        }
        return null;
    }

    public static File IlO(File file) {
        File[] fileArrListFiles;
        if (file != null && file.isDirectory() && (fileArrListFiles = file.listFiles()) != null && fileArrListFiles.length != 0) {
            for (File file2 : fileArrListFiles) {
                if (file2 != null && file2.isFile() && "index.html".equals(file2.getName())) {
                    return file;
                }
            }
            for (File file3 : fileArrListFiles) {
                if (file3 != null && file3.isDirectory()) {
                    return IlO(file3);
                }
            }
        }
        return null;
    }

    private String IlO(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String[] strArrSplit = str.split("\\?");
        if (strArrSplit != null && strArrSplit.length == 2) {
            String str2 = strArrSplit[0];
            if (str2 != null && str2.endsWith("/")) {
                str = str.substring(0, strArrSplit.length - 1);
            }
            String str3 = strArrSplit[0];
            if (str3 != null && str3.endsWith("index.html")) {
                str = strArrSplit[0];
            }
        }
        return str.replace("index.html", "");
    }

    private boolean IlO(String str, String str2, File file) {
        if (file != null && file.exists()) {
            JSONObject jSONObject = this.tV.get(str);
            if (jSONObject == null) {
                return true;
            }
            String strOptString = jSONObject.optString(str2);
            if (strOptString != null && strOptString.equalsIgnoreCase(Cc.IlO(file))) {
                return true;
            }
        }
        return false;
    }

    public void IlO(final oeT oet, final InterfaceC0104IlO interfaceC0104IlO) {
        File file;
        if (tV.IlO().MY() && oet != null && OOq.vCE(oet) && oet.ssS() != null && !TextUtils.isEmpty(oet.ssS().getBidAdm())) {
            com.bytedance.sdk.openadsdk.core.rp.EO.MY.IlO(oet, -705, "server bidding pre render");
            IlO(interfaceC0104IlO, false);
            return;
        }
        if (oet != null && oet.fdM() != null && !TextUtils.isEmpty(oet.fdM().f4690i)) {
            final String str = oet.fdM().f4690i;
            if (this.vCE.contains(str)) {
                return;
            }
            this.EO.put(oet, new MY().IlO(System.currentTimeMillis()));
            com.bytedance.sdk.openadsdk.core.rp.EO.MY.IlO(oet);
            String strIlO = Cc.IlO(str);
            final File file2 = new File(tV(), strIlO);
            String str2 = this.lEW.get(strIlO);
            if (TextUtils.isEmpty(str2)) {
                file = IlO(file2);
                if (file != null && file.exists()) {
                    this.lEW.put(strIlO, file.getAbsolutePath());
                }
            } else {
                file = new File(str2);
            }
            if (file != null && file.exists()) {
                com.bytedance.sdk.openadsdk.core.rp.EO.MY.IlO(oet, -702, (String) null);
                EO(file2);
                this.EO.remove(oet);
                IlO(interfaceC0104IlO, true);
                return;
            }
            try {
                Bc.EO(file2);
            } catch (Throwable unused) {
            }
            this.vCE.add(str);
            File file3 = new File(Cc(), a.C(strIlO, ".zip"));
            com.bytedance.sdk.component.Bc.MY.IlO ilOTV = com.bytedance.sdk.openadsdk.cL.Bc.IlO().MY().tV();
            this.Bc.put(str, ilOTV);
            ilOTV.MY(str);
            ilOTV.IlO(file3.getParent(), file3.getName());
            ilOTV.IlO(7);
            ilOTV.IlO("playable_download");
            ilOTV.IlO(new com.bytedance.sdk.component.Bc.IlO.IlO() { // from class: com.bytedance.sdk.openadsdk.core.rp.EO.IlO.2
                @Override // com.bytedance.sdk.component.Bc.IlO.IlO
                public void IlO(com.bytedance.sdk.component.Bc.MY.EO eo, final com.bytedance.sdk.component.Bc.MY my) {
                    IlO.this.vCE.remove(str);
                    IlO.this.Bc.remove(str);
                    final MY my2 = (MY) IlO.this.EO.remove(oet);
                    if (my2 != null) {
                        my2.MY(System.currentTimeMillis());
                    }
                    if (my.vCE() && my.Cc() != null && my.Cc().exists()) {
                        mmj.MY(new lEW("downloadZip") { // from class: com.bytedance.sdk.openadsdk.core.rp.EO.IlO.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                boolean z2;
                                long jIlO;
                                long jMY;
                                try {
                                    MY my3 = my2;
                                    if (my3 != null) {
                                        my3.EO(System.currentTimeMillis());
                                    }
                                    lMM.IlO(my.Cc().getAbsolutePath(), file2.getAbsolutePath());
                                    MY my4 = my2;
                                    if (my4 != null) {
                                        my4.tV(System.currentTimeMillis());
                                    }
                                    MY my5 = my2;
                                    if (my5 != null) {
                                        jIlO = my5.IlO();
                                        jMY = my2.MY();
                                    } else {
                                        jIlO = 0;
                                        jMY = 0;
                                    }
                                    com.bytedance.sdk.openadsdk.core.rp.EO.MY.IlO(oet, jIlO, jMY);
                                    IlO.MY(file2);
                                    z2 = true;
                                    try {
                                        File fileIlO = IlO.IlO(file2);
                                        if (fileIlO != null && fileIlO.exists()) {
                                            IlO.this.lEW.put(file2.getName(), fileIlO.getAbsolutePath());
                                        }
                                        IlO.this.IlO(IlO.this.tV(fileIlO), true);
                                    } catch (Throwable unused2) {
                                    }
                                } catch (Throwable th) {
                                    com.bytedance.sdk.component.utils.oeT.IlO("PlayableCache", "unzip error: ", th);
                                    com.bytedance.sdk.openadsdk.core.rp.EO.MY.IlO(oet, -704, th.getMessage());
                                    z2 = false;
                                }
                                try {
                                    my.Cc().delete();
                                } catch (Throwable unused3) {
                                }
                                AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                                IlO.this.IlO(interfaceC0104IlO, z2);
                            }
                        });
                    } else {
                        com.bytedance.sdk.openadsdk.core.rp.EO.MY.IlO(oet, my.IlO() != 0 ? my.IlO() : -700, (String) null);
                        IlO.this.IlO(interfaceC0104IlO, false);
                    }
                }

                @Override // com.bytedance.sdk.component.Bc.IlO.IlO
                public void IlO(com.bytedance.sdk.component.Bc.MY.EO eo, IOException iOException) {
                    IlO.this.vCE.remove(str);
                    IlO.this.Bc.remove(str);
                    IlO.this.EO.remove(oet);
                    com.bytedance.sdk.openadsdk.core.rp.EO.MY.IlO(oet, -700, iOException.getMessage());
                    IlO.this.IlO(interfaceC0104IlO, false);
                }
            });
            return;
        }
        com.bytedance.sdk.openadsdk.core.rp.EO.MY.IlO(oet, -701, (String) null);
        IlO(interfaceC0104IlO, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void IlO(final InterfaceC0104IlO interfaceC0104IlO, final boolean z2) {
        mmj.IlO(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.rp.EO.IlO.3
            @Override // java.lang.Runnable
            public void run() {
            }
        });
    }
}
