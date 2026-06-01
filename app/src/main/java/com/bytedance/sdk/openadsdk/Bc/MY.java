package com.bytedance.sdk.openadsdk.Bc;

import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.bykv.vk.openvk.preload.falconx.loader.ILoader;
import com.bykv.vk.openvk.preload.geckox.GeckoHubImp;
import com.bykv.vk.openvk.preload.geckox.IThreadPoolCallback;
import com.bykv.vk.openvk.preload.geckox.model.WebResourceResponseModel;
import com.bykv.vk.openvk.preload.geckox.statistic.IStatisticMonitor;
import com.bytedance.sdk.component.utils.oeT;
import com.bytedance.sdk.openadsdk.core.cl;
import com.bytedance.sdk.openadsdk.core.rp;
import com.bytedance.sdk.openadsdk.ea.EO;
import com.bytedance.sdk.openadsdk.tV.EO;
import com.bytedance.sdk.openadsdk.utils.mmj;
import java.security.SecureRandom;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class MY {
    private static final String[] IlO = {"gecko16-normal-useast5.tiktokv.us"};

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public interface IlO {
        void IlO();
    }

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.Bc.MY$MY, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class C0066MY {
        private static final MY IlO = new MY();
    }

    public static void EO() {
        try {
            GeckoHubImp.setThreadPoolExecutorCallback(new IThreadPoolCallback() { // from class: com.bytedance.sdk.openadsdk.Bc.MY.2
                @Override // com.bykv.vk.openvk.preload.geckox.IThreadPoolCallback
                public ExecutorService getThreadPool() {
                    return mmj.Cc();
                }
            });
        } catch (Throwable th) {
            oeT.IlO("GeckoHub", "setThreadPoolExecutor error", th);
        }
    }

    private static String tV() {
        String[] strArrHL = cl.tV().hL();
        if (strArrHL == null) {
            strArrHL = IlO;
        }
        String str = strArrHL[new SecureRandom().nextInt(strArrHL.length)];
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        SecureRandom secureRandom = new SecureRandom();
        String[] strArr = IlO;
        return strArr[secureRandom.nextInt(strArr.length)];
    }

    public ILoader MY() {
        try {
            return GeckoHubImp.inst(cl.IlO()).getGeckoResLoader();
        } catch (Throwable th) {
            oeT.IlO("GeckoHub", "getGeckoResLoader error", th);
            return null;
        }
    }

    private MY() {
        try {
            GeckoHubImp.inst(cl.IlO());
        } catch (Throwable th) {
            oeT.IlO("GeckoHub", "GeckoHubImp init error", th);
        }
    }

    public static MY IlO() {
        return C0066MY.IlO;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void MY(Map<String, com.bytedance.sdk.openadsdk.core.model.oeT> map, JSONObject jSONObject, String str) {
        try {
            JSONObject jSONObject2 = new JSONObject();
            if (jSONObject == null) {
                jSONObject2.put("success", false);
                jSONObject2.put(NotificationCompat.CATEGORY_MESSAGE, str);
                jSONObject2.put("code", 1);
                jSONObject = jSONObject2;
            }
            Iterator<com.bytedance.sdk.openadsdk.core.model.oeT> it = map.values().iterator();
            while (it.hasNext()) {
                EO.IlO(it.next(), jSONObject);
            }
        } catch (Throwable th) {
            oeT.IlO("GeckoHub", "upLoadStateEvent error", th);
        }
    }

    public void IlO(Map<String, com.bytedance.sdk.openadsdk.core.model.oeT> map) {
        IlO(map, (IlO) null, false);
    }

    public void IlO(final Map<String, com.bytedance.sdk.openadsdk.core.model.oeT> map, final IlO ilO, boolean z2) {
        try {
            String strIlO = rp.IlO(cl.IlO());
            if (TextUtils.isEmpty(strIlO)) {
                return;
            }
            for (com.bytedance.sdk.openadsdk.core.model.oeT oet : map.values()) {
                if (oet != null) {
                    if (!z2 && oet.CuC()) {
                        map.remove(oet.tU());
                    } else {
                        EO.MY(oet);
                    }
                }
            }
            if (map.isEmpty()) {
                return;
            }
            GeckoHubImp.setRandomHost(tV());
            GeckoHubImp.inst(cl.IlO()).preload(strIlO, new IStatisticMonitor() { // from class: com.bytedance.sdk.openadsdk.Bc.MY.1
                @Override // com.bykv.vk.openvk.preload.geckox.statistic.IStatisticMonitor
                public void upload(String str, JSONObject jSONObject) {
                    if ("geckosdk_update_stats".equals(str)) {
                        com.bytedance.sdk.openadsdk.core.model.oeT oet2 = (com.bytedance.sdk.openadsdk.core.model.oeT) map.get(jSONObject.optString("channel"));
                        if (oet2 != null) {
                            EO.IlO.IlO(str, jSONObject, oet2);
                            return;
                        }
                        return;
                    }
                    if ("download_gecko_end".equals(str)) {
                        IlO ilO2 = ilO;
                        if (ilO2 != null) {
                            ilO2.IlO();
                        }
                        MY.MY(map, jSONObject, "");
                    }
                }
            }, map.keySet(), new com.bytedance.sdk.openadsdk.Bc.IlO());
        } catch (Throwable th) {
            MY(map, null, th.toString());
            oeT.IlO("GeckoHub", "releaseGeckoResLoader error", th);
        }
    }

    public void IlO(ILoader iLoader) {
        if (iLoader != null) {
            try {
                GeckoHubImp.inst(cl.IlO()).releaseGeckoResLoader(iLoader);
            } catch (Throwable th) {
                oeT.IlO("GeckoHub", "releaseGeckoResLoader error", th);
            }
        }
    }

    public WebResourceResponseModel IlO(ILoader iLoader, String str, String str2) {
        if (iLoader == null) {
            return null;
        }
        try {
            return GeckoHubImp.inst(cl.IlO()).findResAndMsg(iLoader, str, str2);
        } catch (Throwable th) {
            oeT.IlO("GeckoHub", "findRes error", th);
            return null;
        }
    }

    public int IlO(ILoader iLoader, String str) {
        try {
            return GeckoHubImp.inst(cl.IlO()).getResCount(iLoader, str);
        } catch (Throwable th) {
            oeT.IlO("GeckoHub", "getResCount error", th);
            return 0;
        }
    }
}
