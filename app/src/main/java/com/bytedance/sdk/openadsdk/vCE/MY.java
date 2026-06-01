package com.bytedance.sdk.openadsdk.vCE;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import androidx.work.WorkRequest;
import com.bytedance.sdk.component.utils.lEW;
import com.bytedance.sdk.component.utils.oeT;
import com.bytedance.sdk.openadsdk.core.bWL;
import com.bytedance.sdk.openadsdk.ea.EO;
import com.bytedance.sdk.openadsdk.ea.IlO.tV;
import com.bytedance.sdk.openadsdk.utils.lMM;
import com.ironsource.C2318f4;
import com.ironsource.C2461n2;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class MY {
    private static volatile MY IlO;
    private final ConcurrentHashMap<String, com.bytedance.sdk.openadsdk.zPa.IlO> MY = new ConcurrentHashMap<>();
    private com.bytedance.sdk.openadsdk.zPa.IlO EO = null;
    private volatile boolean tV = false;
    private volatile HandlerThread Cc = null;
    private volatile Handler vCE = null;
    private String Bc = "";
    private int lEW = 0;
    private volatile long DmF = 0;
    private final Runnable NV = new Runnable() { // from class: com.bytedance.sdk.openadsdk.vCE.MY.6
        @Override // java.lang.Runnable
        public void run() {
            try {
                JSONObject jSONObject = new JSONObject();
                JSONObject jSONObject2 = new JSONObject();
                try {
                    if (IlO.IlO().Cc()) {
                        Set<String> setKeySet = MY.this.MY.keySet();
                        if (setKeySet.size() > MY.this.lEW) {
                            MY.this.lEW = setKeySet.size();
                        }
                        HashSet hashSet = new HashSet(5);
                        ArrayList arrayList = new ArrayList(setKeySet.size());
                        arrayList.addAll(MY.this.MY.values());
                        Collections.sort(arrayList);
                        for (int i2 = 0; i2 < arrayList.size() && i2 < 5; i2++) {
                            hashSet.add(((com.bytedance.sdk.openadsdk.zPa.IlO) arrayList.get(i2)).MY());
                        }
                        try {
                            for (String str : setKeySet) {
                                com.bytedance.sdk.openadsdk.zPa.IlO ilO = (com.bytedance.sdk.openadsdk.zPa.IlO) MY.this.MY.get(str);
                                if (ilO != null) {
                                    JSONObject jSONObjectIlO = ilO.IlO(jSONObject2);
                                    if (hashSet.contains(str)) {
                                        jSONObject.put(str, jSONObjectIlO);
                                    }
                                }
                            }
                            jSONObject.put("common", jSONObject2);
                        } catch (JSONException e) {
                            oeT.EO(e.getMessage(), new Object[0]);
                        }
                    } else {
                        try {
                            if (MY.this.EO != null) {
                                jSONObject.put("common", MY.this.EO.IlO(jSONObject2));
                            }
                        } catch (JSONException e4) {
                            oeT.EO(e4.getMessage(), new Object[0]);
                        }
                    }
                } catch (Throwable th) {
                    oeT.EO(th.getMessage(), new Object[0]);
                }
                MY.this.Bc = jSONObject.toString();
                MY my = MY.this;
                my.IlO(my.NV, IlO.IlO().tV());
            } catch (OutOfMemoryError e8) {
                oeT.EO(e8.getMessage(), new Object[0]);
            }
        }
    };

    private MY() {
    }

    private void Cc() {
        if (this.tV) {
            return;
        }
        this.tV = true;
        IlO(this.NV, IlO.IlO().tV());
    }

    private Handler EO() {
        if (this.Cc == null || !this.Cc.isAlive()) {
            synchronized (bWL.class) {
                try {
                    if (this.Cc == null || !this.Cc.isAlive()) {
                        this.Cc = lEW.IlO("csj_feature", -1);
                        this.vCE = new Handler(this.Cc.getLooper());
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        } else if (this.vCE == null) {
            synchronized (bWL.class) {
                try {
                    if (this.vCE == null) {
                        this.vCE = new Handler(this.Cc.getLooper());
                    }
                } finally {
                }
            }
        }
        return this.vCE;
    }

    private void tV() {
        final long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (jElapsedRealtime - this.DmF > WorkRequest.MIN_BACKOFF_MILLIS) {
            EO.IlO("track_feature_result", false, new com.bytedance.sdk.openadsdk.ea.MY() { // from class: com.bytedance.sdk.openadsdk.vCE.MY.1
                @Override // com.bytedance.sdk.openadsdk.ea.MY
                @Nullable
                public com.bytedance.sdk.openadsdk.ea.IlO.EO getLogStats() throws Exception {
                    MY.this.DmF = jElapsedRealtime;
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(NotificationCompat.CATEGORY_MESSAGE, String.valueOf(MY.this.lEW));
                    return tV.MY().IlO("track_feature_result").MY(jSONObject.toString());
                }
            });
        }
    }

    public void MY() {
        try {
            if (IlO.IlO().EO()) {
                IlO(new Runnable() { // from class: com.bytedance.sdk.openadsdk.vCE.MY.7
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!IlO.IlO().Cc()) {
                            if (MY.this.EO != null) {
                                MY.this.EO.IlO();
                            }
                        } else {
                            Iterator it = MY.this.MY.keySet().iterator();
                            while (it.hasNext()) {
                                com.bytedance.sdk.openadsdk.zPa.IlO ilO = (com.bytedance.sdk.openadsdk.zPa.IlO) MY.this.MY.get((String) it.next());
                                if (ilO != null) {
                                    ilO.IlO();
                                }
                            }
                        }
                    }
                });
            }
        } catch (OutOfMemoryError e) {
            oeT.EO(e.getMessage(), new Object[0]);
        }
    }

    private void IlO(Runnable runnable) {
        if (lMM.IlO || runnable == null) {
            return;
        }
        try {
            EO().post(runnable);
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void IlO(Runnable runnable, long j) {
        if (lMM.IlO || runnable == null) {
            return;
        }
        try {
            EO().postDelayed(runnable, j);
        } catch (Throwable unused) {
        }
    }

    public static MY IlO() {
        if (IlO == null) {
            synchronized (com.bytedance.sdk.openadsdk.core.EO.class) {
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

    public void IlO(JSONObject jSONObject) {
        if (IlO.IlO().EO()) {
            try {
                jSONObject.put("feature_data", this.Bc);
                tV();
            } catch (JSONException e) {
                oeT.EO(e.getMessage(), new Object[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void IlO(@NonNull String str, @NonNull String str2, String str3) {
        try {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && IlO.IlO().EO()) {
                Cc();
                if (IlO.IlO().Cc()) {
                    com.bytedance.sdk.openadsdk.zPa.IlO ilO = this.MY.get(str2);
                    if (ilO == null) {
                        ilO = new com.bytedance.sdk.openadsdk.zPa.IlO(str2);
                    }
                    ilO.IlO(str, str3);
                    this.MY.put(str2, ilO);
                    return;
                }
                if (this.EO == null) {
                    this.EO = new com.bytedance.sdk.openadsdk.zPa.IlO(str2);
                }
                this.EO.IlO(str, str3);
            }
        } catch (OutOfMemoryError e) {
            oeT.EO(e.getMessage(), new Object[0]);
        }
    }

    public void IlO(@NonNull final String str, @NonNull final String str2, final String str3, String str4) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || !IlO.IlO().EO()) {
            return;
        }
        if (!C2461n2.f9471v.equals(str) && !C2318f4.f8523d.equals(str) && !"dislike".equals(str)) {
            if (IlO.IlO().cL()) {
                if (TextUtils.isEmpty(str4)) {
                    return;
                }
                if (!"rewarded_video".equals(str4) && !"fullscreen_interstitial_ad".equals(str4) && !"open_ad".equals(str4)) {
                    return;
                }
            }
            if ("feed_play".equals(str) || "feed_pause".equals(str) || "feed_continue".equals(str) || "feed_over".equals(str) || "feed_break".equals(str) || "play_error".equals(str)) {
                IlO(new Runnable() { // from class: com.bytedance.sdk.openadsdk.vCE.MY.3
                    @Override // java.lang.Runnable
                    public void run() {
                        MY.this.IlO(str, str2, str3);
                    }
                });
                return;
            }
            return;
        }
        IlO(new Runnable() { // from class: com.bytedance.sdk.openadsdk.vCE.MY.2
            @Override // java.lang.Runnable
            public void run() {
                MY.this.IlO(str, str2, str3);
            }
        });
    }

    public void IlO(@NonNull final String str, final com.bytedance.sdk.openadsdk.core.model.oeT oet) {
        if (!TextUtils.isEmpty(str) && IlO.IlO().EO() && com.bytedance.sdk.openadsdk.core.model.oeT.Cc(oet)) {
            if (!IlO.IlO().cL() || oet.fHv() == 8 || oet.fHv() == 7 || oet.fHv() == 3) {
                if ("videoPercent30".equals(str) || "videoForceBreak".equals(str)) {
                    IlO(new Runnable() { // from class: com.bytedance.sdk.openadsdk.vCE.MY.4
                        @Override // java.lang.Runnable
                        public void run() {
                            String strJm = oet.Jm();
                            String strJAC = oet.JAC();
                            if (TextUtils.isEmpty(strJm)) {
                                return;
                            }
                            MY.this.IlO(str, strJm, strJAC);
                        }
                    });
                }
            }
        }
    }

    public void IlO(@NonNull final String str, final com.bytedance.sdk.openadsdk.core.model.oeT oet, final String str2) {
        if (TextUtils.isEmpty(str) || !IlO.IlO().EO()) {
            return;
        }
        if ("landingStart".equals(str) || "landingFinish".equals(str) || "landingContinue".equals(str) || "landingPause".equals(str)) {
            IlO(new Runnable() { // from class: com.bytedance.sdk.openadsdk.vCE.MY.5
                @Override // java.lang.Runnable
                public void run() {
                    com.bytedance.sdk.openadsdk.core.model.oeT oet2 = oet;
                    if (oet2 == null || TextUtils.isEmpty(oet2.Jm())) {
                        return;
                    }
                    MY.this.IlO(str, oet.Jm(), oet.JAC() + str2);
                }
            });
        }
    }
}
