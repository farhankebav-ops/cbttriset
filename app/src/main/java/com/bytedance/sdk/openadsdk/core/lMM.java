package com.bytedance.sdk.openadsdk.core;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.bytedance.sdk.openadsdk.BuildConfig;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.activity.TTLandingPageActivity;
import com.bytedance.sdk.openadsdk.activity.TTPlayableLandingPageActivity;
import com.bytedance.sdk.openadsdk.activity.TTVideoLandingPageLink2Activity;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAd;
import com.bytedance.sdk.openadsdk.multipro.MY.IlO;
import com.bytedance.sdk.openadsdk.tV.MY;
import com.bytedance.sdk.openadsdk.utils.zLG;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class lMM {
    private static boolean IlO = false;

    public static void IlO(boolean z2) {
        IlO = z2;
    }

    public static boolean MY(Context context, String str, com.bytedance.sdk.openadsdk.core.model.oeT oet, int i2, String str2, boolean z2) {
        try {
            Intent intentIlO = IlO(context, str, oet, i2, (PAGNativeAd) null, (com.bytedance.sdk.openadsdk.core.EO.IlO) null, str2, z2, true);
            if (!(context instanceof Activity)) {
                intentIlO.addFlags(268435456);
            }
            context.startActivity(intentIlO);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    private static com.bytedance.sdk.openadsdk.ea.IlO.MY IlO(int i2, com.bytedance.sdk.openadsdk.core.model.oeT oet) {
        com.bytedance.sdk.openadsdk.ea.IlO.MY my = new com.bytedance.sdk.openadsdk.ea.IlO.MY();
        my.IlO(MY.IlO.IlO);
        my.IlO(oet);
        my.MY(zLG.IlO(oet));
        my.IlO(i2);
        my.IlO(false);
        my.MY(oet.Jz());
        return my;
    }

    public static boolean IlO(Context context, com.bytedance.sdk.openadsdk.core.model.oeT oet, int i2, @Nullable PAGNativeAd pAGNativeAd, @Nullable com.bytedance.sdk.openadsdk.core.EO.IlO ilO, String str, @Nullable com.bytedance.sdk.openadsdk.es.IlO.IlO.vCE vce, boolean z2, int i8) {
        String strIlO;
        com.bytedance.sdk.openadsdk.tV.EO.IlO(IlO(-1, oet));
        if (context != null && oet != null && i2 != -1) {
            com.bytedance.sdk.openadsdk.core.model.EV evZTS = oet.zTS();
            HashMap map = new HashMap();
            if (oet.lQ() == 0) {
                map.put("dpl_probability_jump", Boolean.valueOf(i8 >= 11));
            }
            if (i8 != 0 && oet.xJ()) {
                map.put("dsp_click_type", Integer.valueOf(i8));
            }
            if (evZTS != null && !TextUtils.isEmpty(evZTS.IlO())) {
                if (IlO(context, oet, i2, str, z2, map)) {
                    com.bytedance.sdk.openadsdk.tV.EO.IlO(IlO(2, oet));
                    com.bytedance.sdk.openadsdk.utils.Cc.IlO(oet);
                    return true;
                }
                if (evZTS.EO() != 2 || oet.uI() == 5 || oet.uI() == 15) {
                    if (evZTS.EO() == 1 && !TextUtils.isEmpty(evZTS.MY())) {
                        strIlO = evZTS.MY();
                    } else {
                        strIlO = IlO(oet);
                    }
                } else if (vce != null) {
                    if (!vce.IlO()) {
                        if (vce.Cc()) {
                            com.bytedance.sdk.openadsdk.tV.EO.IlO(oet, str, "open_fallback_url", map);
                            com.bytedance.sdk.openadsdk.tV.EO.IlO(IlO(3, oet));
                            com.bytedance.sdk.openadsdk.utils.Cc.IlO(oet);
                            return true;
                        }
                        strIlO = IlO(evZTS, oet);
                        com.bytedance.sdk.openadsdk.tV.EO.IlO(IlO(3, oet));
                    } else {
                        com.bytedance.sdk.openadsdk.tV.EO.IlO(oet, str, "open_fallback_url", map);
                        com.bytedance.sdk.openadsdk.tV.EO.IlO(IlO(3, oet));
                        com.bytedance.sdk.openadsdk.utils.Cc.IlO(oet);
                        return true;
                    }
                } else {
                    strIlO = IlO(evZTS, oet);
                }
                com.bytedance.sdk.openadsdk.tV.EO.IlO(oet, str, "open_fallback_url", map);
            } else {
                strIlO = IlO(oet);
            }
            String str2 = strIlO;
            if (oet.lQ() == 0 && !TextUtils.isEmpty(str2) && str2.contains("play.google.com/store")) {
                String strSubstring = str2.substring(str2.indexOf("?id=") + 4);
                com.bytedance.sdk.openadsdk.tV.EO.IlO(IlO(4, oet));
                boolean zIlO = com.bytedance.sdk.openadsdk.es.IlO.IlO.tV.IlO(context, str2, strSubstring, str, oet);
                if (zIlO) {
                    com.bytedance.sdk.openadsdk.utils.Cc.IlO(oet);
                }
                return zIlO;
            }
            boolean zIlO2 = IlO(context, oet, i2, pAGNativeAd, ilO, str, z2, str2);
            if (zIlO2) {
                com.bytedance.sdk.openadsdk.utils.Cc.IlO(oet);
            }
            return zIlO2;
        }
        com.bytedance.sdk.openadsdk.tV.EO.IlO(IlO(1, oet));
        return false;
    }

    private static String IlO(com.bytedance.sdk.openadsdk.core.model.EV ev, com.bytedance.sdk.openadsdk.core.model.oeT oet) {
        if (!TextUtils.isEmpty(ev.MY())) {
            return ev.MY();
        }
        return IlO(oet);
    }

    private static String IlO(com.bytedance.sdk.openadsdk.core.model.oeT oet) {
        if (oet.xJ() && oet.QfH() != null) {
            return oet.QfH().DmF();
        }
        return oet.pFe();
    }

    public static boolean IlO(Context context, com.bytedance.sdk.openadsdk.core.model.oeT oet, int i2, String str, boolean z2, Map<String, Object> map) {
        if (oet == null) {
            return false;
        }
        com.bytedance.sdk.openadsdk.core.model.EV evZTS = oet.zTS();
        if (evZTS != null && !TextUtils.isEmpty(evZTS.IlO())) {
            if (map == null) {
                map = new HashMap<>();
            }
            Map<String, Object> map2 = map;
            String strIlO = evZTS.IlO();
            if (com.bytedance.sdk.openadsdk.es.IlO.IlO.EO.IlO()) {
                return com.bytedance.sdk.openadsdk.es.IlO.IlO.EO.IlO(context, strIlO, oet, i2, map2, z2);
            }
            Uri uri = Uri.parse(strIlO);
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(uri);
            if (zLG.lEW(context)) {
                zLG.MY myIlO = zLG.IlO(context, intent);
                if (myIlO.MY > 0) {
                    if (cl.tV().lEW()) {
                        zLG.IlO(oet, str);
                    }
                    if (!(context instanceof Activity)) {
                        intent.addFlags(268435456);
                    }
                    map2.put("can_query_install", 1);
                    map2.put("matched_count", Integer.valueOf(myIlO.MY));
                    map2.put("url", strIlO);
                    ComponentName componentName = myIlO.IlO;
                    if (componentName != null) {
                        intent.setComponent(componentName);
                    }
                    com.bytedance.sdk.openadsdk.tV.EO.IlO(oet, str, "open_url_app", map2);
                    try {
                        context.startActivity(intent);
                        com.bytedance.sdk.openadsdk.tV.rp.IlO().IlO(map2).IlO(oet, str);
                        com.bytedance.sdk.openadsdk.tV.EO.IlO("dp_start_act_success", oet, str, map2);
                        return true;
                    } catch (Exception e) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("exception", e.getMessage());
                            jSONObject.put("intent", intent.toString());
                            jSONObject.put("can_query_install", 1);
                        } catch (Exception unused) {
                        }
                        tV.IlO(oet, str, -4, jSONObject);
                        if (!cl.tV().lEW()) {
                            IlO(context, oet.pFe(), oet, i2, str, z2);
                        }
                        return false;
                    }
                }
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("intent", intent.toString());
                    jSONObject2.put("can_query_install", 1);
                } catch (Exception unused2) {
                }
                tV.IlO(oet, str, -3, jSONObject2);
            } else {
                try {
                    if (cl.tV().lEW()) {
                        zLG.IlO(oet, str);
                    }
                    if (!(context instanceof Activity)) {
                        intent.addFlags(268435456);
                    }
                    map2.put("can_query_install", 0);
                    com.bytedance.sdk.openadsdk.tV.EO.IlO(oet, str, "open_url_app", map2);
                    context.startActivity(intent);
                    com.bytedance.sdk.openadsdk.tV.rp.IlO().IlO(map2).IlO(oet, str);
                    return true;
                } catch (Throwable unused3) {
                }
            }
            return false;
        }
        tV.IlO(oet, str, evZTS == null ? -1 : -2, evZTS != null ? evZTS.tV() : null);
        return false;
    }

    public static boolean IlO(Context context, com.bytedance.sdk.openadsdk.core.model.oeT oet, int i2, PAGNativeAd pAGNativeAd, com.bytedance.sdk.openadsdk.core.EO.IlO ilO, String str, boolean z2, String str2) {
        if (TextUtils.isEmpty(str2) && !com.bytedance.sdk.openadsdk.core.model.OOq.MY(oet)) {
            com.bytedance.sdk.openadsdk.tV.EO.IlO(IlO(5, oet));
            return false;
        }
        int iJz = oet.Jz();
        if (iJz != 2 && iJz != 8) {
            com.bytedance.sdk.component.utils.MY.IlO(context, IlO(context, str2, oet, i2, pAGNativeAd, ilO, str, z2), null);
            IlO = false;
            return true;
        }
        return com.bytedance.sdk.openadsdk.utils.vAh.IlO(context, str2, oet, MY.IlO.IlO);
    }

    public static boolean IlO(Context context, String str, com.bytedance.sdk.openadsdk.core.model.oeT oet, int i2, String str2, boolean z2) {
        try {
            context.startActivity(IlO(context, str, oet, i2, (PAGNativeAd) null, (com.bytedance.sdk.openadsdk.core.EO.IlO) null, str2, z2));
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    private static Intent IlO(Context context, String str, com.bytedance.sdk.openadsdk.core.model.oeT oet, int i2, @Nullable PAGNativeAd pAGNativeAd, com.bytedance.sdk.openadsdk.core.EO.IlO ilO, String str2, boolean z2) {
        return IlO(context, str, oet, i2, pAGNativeAd, ilO, str2, z2, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static Intent IlO(Context context, String str, com.bytedance.sdk.openadsdk.core.model.oeT oet, int i2, @Nullable PAGNativeAd pAGNativeAd, com.bytedance.sdk.openadsdk.core.EO.IlO ilO, String str2, boolean z2, boolean z7) {
        Intent intent;
        if (!z7 && com.bytedance.sdk.openadsdk.core.model.OOq.MY(oet) && (pAGNativeAd != 0 || ilO != null)) {
            intent = new Intent(context, (Class<?>) TTPlayableLandingPageActivity.class);
            intent.putExtra("ad_pending_download", IlO(oet, z2));
            String strRp = com.bytedance.sdk.openadsdk.core.model.OOq.rp(oet);
            if (!TextUtils.isEmpty(strRp)) {
                if (strRp.contains("?")) {
                    str = strRp.concat("&orientation=portrait");
                } else {
                    str = strRp.concat("?orientation=portrait");
                }
            }
        } else {
            intent = (z7 || oet.Jz() != 3 || !(oet.vAh() == 2 || (oet.vAh() == 1 && IlO)) || oet.bYL()) ? new Intent(context, (Class<?>) TTLandingPageActivity.class) : new Intent(context, (Class<?>) TTVideoLandingPageLink2Activity.class);
        }
        intent.putExtra("url", str);
        intent.putExtra("gecko_id", oet.tU());
        intent.putExtra("web_title", oet.dm());
        intent.putExtra("sdk_version", BuildConfig.VERSION_CODE);
        intent.putExtra("adid", oet.ED());
        intent.putExtra("log_extra", oet.KT());
        com.bytedance.sdk.openadsdk.multipro.MY.IlO ilOEO = null;
        intent.putExtra("icon_url", oet.HTA() == null ? null : oet.HTA().IlO());
        intent.putExtra("event_tag", str2);
        intent.putExtra("source", i2);
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        if (com.bytedance.sdk.openadsdk.multipro.MY.EO()) {
            intent.putExtra(TTAdConstant.MULTI_PROCESS_MATERIALMETA, oet.eDn().toString());
        } else {
            pP.IlO().vCE();
            pP.IlO().IlO(oet);
        }
        if (oet.uI() == 5 || oet.uI() == 15 || oet.uI() == 50) {
            if (pAGNativeAd != 0) {
                if (pAGNativeAd instanceof IlO.InterfaceC0114IlO) {
                    ilOEO = ((IlO.InterfaceC0114IlO) pAGNativeAd).vCE();
                } else if (pAGNativeAd instanceof com.bytedance.sdk.openadsdk.IlO.MY.IlO.MY) {
                    ilOEO = ((com.bytedance.sdk.openadsdk.IlO.MY.IlO.MY) pAGNativeAd).MY();
                }
                if (ilOEO != null) {
                    intent.putExtra(TTAdConstant.MULTI_PROCESS_DATA, ilOEO.IlO().toString());
                }
            }
            if (ilO != null && ilO.MY() && (ilOEO = ilO.EO()) != null) {
                intent.putExtra(TTAdConstant.MULTI_PROCESS_DATA, ilOEO.IlO().toString());
            }
            if (ilOEO != null) {
                intent.putExtra("video_is_auto_play", ilOEO.tV);
                if (com.bytedance.sdk.component.utils.ea.tV()) {
                    ilOEO.IlO().toString();
                }
            }
        }
        return intent;
    }

    private static boolean IlO(com.bytedance.sdk.openadsdk.core.model.oeT oet, boolean z2) {
        if (z2 && oet != null && oet.Jz() == 4) {
            return com.bytedance.sdk.openadsdk.core.model.OOq.MY(oet);
        }
        return false;
    }
}
