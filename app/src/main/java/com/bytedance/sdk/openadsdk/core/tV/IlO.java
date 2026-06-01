package com.bytedance.sdk.openadsdk.core.tV;

import a1.a;
import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.sdk.component.utils.Bc;
import com.bytedance.sdk.component.utils.Cc;
import com.bytedance.sdk.openadsdk.CacheDirFactory;
import com.bytedance.sdk.openadsdk.core.cl;
import com.bytedance.sdk.openadsdk.core.model.oeT;
import com.bytedance.sdk.openadsdk.core.rp.EO.EO;
import com.bytedance.sdk.openadsdk.ea.IlO.tV;
import com.bytedance.sdk.openadsdk.multipro.MY;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class IlO {
    private final List<String> IlO = new CopyOnWriteArrayList();
    private final EO MY = new EO(5, 5, true);
    private final ConcurrentHashMap<String, Long> EO = new ConcurrentHashMap<>();

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.tV.IlO$IlO, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class C0111IlO {
        private static final IlO IlO = new IlO();
    }

    private boolean EO(String str) {
        return !this.IlO.contains(str);
    }

    public File MY(String str) {
        String strIlO = Cc.IlO(str);
        if (strIlO == null) {
            return null;
        }
        String name = new File(CacheDirFactory.getRootDir()).getName();
        return Bc.IlO(cl.IlO(), MY.EO(), MY.EO() ? a.C(name, "/music/") : a.C(name, "//music/"), strIlO);
    }

    public void EO() {
        com.bytedance.sdk.openadsdk.ea.EO.IlO("music_preload_start", false, new com.bytedance.sdk.openadsdk.ea.MY() { // from class: com.bytedance.sdk.openadsdk.core.tV.IlO.2
            @Override // com.bytedance.sdk.openadsdk.ea.MY
            public com.bytedance.sdk.openadsdk.ea.IlO.EO getLogStats() throws Exception {
                tV tVVarIlO = tV.MY().IlO("music_preload_start");
                tVVarIlO.IlO();
                return tVVarIlO;
            }
        });
    }

    public static IlO IlO() {
        return C0111IlO.IlO;
    }

    public void IlO(com.bytedance.sdk.openadsdk.core.model.IlO ilO) {
        List<oeT> listTV = ilO.tV();
        if (listTV == null || listTV.size() == 0) {
            return;
        }
        for (int i2 = 0; i2 < listTV.size(); i2++) {
            oeT oet = listTV.get(i2);
            if (oet != null) {
                IlO(oet);
            }
        }
    }

    public InputStream IlO(String str) {
        File fileMY = MY(str);
        if (fileMY == null || !IlO(fileMY)) {
            return null;
        }
        try {
            return new FileInputStream(fileMY);
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.oeT.EO("MusicCacheManager", e.getMessage());
            return null;
        }
    }

    private void IlO(oeT oet) {
        oeT.IlO ilOUvo;
        String strEV;
        if (oet == null || (ilOUvo = oet.uvo()) == null || (strEV = ilOUvo.EV()) == null || !strEV.contains("music_url")) {
            return;
        }
        EO();
        String strTV = ilOUvo.tV();
        if (TextUtils.isEmpty(strTV)) {
            try {
                new JSONObject().put("result", 0);
            } catch (JSONException e) {
                com.bytedance.sdk.component.utils.oeT.EO("MusicCacheManager", e.getMessage());
            }
            IlO(0, -1L, 10001, "music url string is null");
            return;
        }
        File fileMY = MY(strTV);
        if (fileMY == null) {
            return;
        }
        fileMY.getPath();
        if (IlO(fileMY)) {
            IlO(2, -1L, -1, null);
        } else {
            IlO(oet, strTV, fileMY);
        }
    }

    public void MY() {
        File fileIlO = IlO(cl.IlO(), MY.EO());
        fileIlO.getAbsolutePath();
        try {
            this.MY.IlO(fileIlO);
        } catch (IOException e) {
            com.bytedance.sdk.component.utils.oeT.IlO("MusicCacheManager", "trimFileCache fail", e);
        }
    }

    private boolean IlO(File file) {
        return file.exists() && file.length() != 0;
    }

    private void IlO(oeT oet, String str, File file) {
        if (EO(str)) {
            this.EO.put(str, Long.valueOf(SystemClock.elapsedRealtime()));
            com.bytedance.sdk.component.Bc.MY.IlO ilOTV = com.bytedance.sdk.openadsdk.cL.Bc.IlO().MY().tV();
            ilOTV.MY(str);
            ilOTV.IlO(file.getParent(), file.getName());
            ilOTV.EO(str);
            this.IlO.add(str);
            ilOTV.IlO(new com.bytedance.sdk.component.Bc.IlO.IlO() { // from class: com.bytedance.sdk.openadsdk.core.tV.IlO.1
                @Override // com.bytedance.sdk.component.Bc.IlO.IlO
                public void IlO(com.bytedance.sdk.component.Bc.MY.EO eo, com.bytedance.sdk.component.Bc.MY my) {
                    my.EO();
                    my.IlO();
                    String strEO = eo.EO();
                    Long l = (Long) IlO.this.EO.get(strEO);
                    if (my.vCE() && my.Cc() != null && my.Cc().exists()) {
                        my.Cc();
                        if (l != null) {
                            IlO.this.EO.remove(strEO);
                            IlO.this.IlO(1, SystemClock.elapsedRealtime() - l.longValue(), -1, null);
                        }
                        try {
                            Bc.MY(my.Cc());
                        } catch (IOException e) {
                            com.bytedance.sdk.component.utils.oeT.EO("MusicCacheManager", e.getMessage());
                        }
                    }
                    if (my.vCE() || l == null) {
                        return;
                    }
                    IlO.this.IlO(0, SystemClock.elapsedRealtime() - l.longValue(), -2, "http response status code isn't 200");
                }

                @Override // com.bytedance.sdk.component.Bc.IlO.IlO
                public void IlO(com.bytedance.sdk.component.Bc.MY.EO eo, IOException iOException) {
                    Long l = (Long) IlO.this.EO.get(eo.EO());
                    if (l != null) {
                        IlO.this.IlO(0, SystemClock.elapsedRealtime() - l.longValue(), -2, "http response status code isn't 200");
                    }
                }
            });
        }
    }

    private File IlO(Context context, boolean z2) {
        String strC;
        String name = new File(CacheDirFactory.getRootDir()).getName();
        if (MY.EO()) {
            strC = a.C(name, "/music");
        } else {
            strC = a.C(name, "//music");
        }
        return Bc.IlO(context, z2, strC);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void IlO(final int i2, final long j, final int i8, final String str) {
        com.bytedance.sdk.openadsdk.ea.EO.IlO("music_preload_finish", false, new com.bytedance.sdk.openadsdk.ea.MY() { // from class: com.bytedance.sdk.openadsdk.core.tV.IlO.3
            @Override // com.bytedance.sdk.openadsdk.ea.MY
            public com.bytedance.sdk.openadsdk.ea.IlO.EO getLogStats() throws Exception {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("result", i2);
                long j3 = j;
                if (j3 != -1) {
                    jSONObject.put("load_duration", j3);
                }
                tV tVVarMY = tV.MY().IlO("music_preload_finish").MY(jSONObject.toString());
                if (!TextUtils.isEmpty(str)) {
                    tVVarMY.MY(i8);
                    tVVarMY.vCE(str);
                }
                tVVarMY.IlO();
                return tVVarMY;
            }
        });
    }

    public void IlO(final boolean z2) {
        com.bytedance.sdk.openadsdk.ea.EO.IlO("music_cache", false, new com.bytedance.sdk.openadsdk.ea.MY() { // from class: com.bytedance.sdk.openadsdk.core.tV.IlO.4
            @Override // com.bytedance.sdk.openadsdk.ea.MY
            public com.bytedance.sdk.openadsdk.ea.IlO.EO getLogStats() throws Exception {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("result", z2);
                tV tVVarMY = tV.MY().IlO("music_cache").MY(jSONObject.toString());
                tVVarMY.IlO();
                return tVVarMY;
            }
        });
    }
}
