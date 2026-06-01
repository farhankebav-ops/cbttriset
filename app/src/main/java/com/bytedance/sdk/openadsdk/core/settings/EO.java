package com.bytedance.sdk.openadsdk.core.settings;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.bytedance.sdk.openadsdk.core.cl;
import com.bytedance.sdk.openadsdk.utils.nvX;
import java.io.File;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class EO {
    private static final ConcurrentHashMap<String, MY> IlO = new ConcurrentHashMap<>();

    @WorkerThread
    public static void IlO(boolean z2) {
        File fileMY = MY();
        try {
            if (fileMY.exists()) {
                HashMap<String, MY> mapMY = MY(new JSONArray(new String(com.bytedance.sdk.component.utils.Bc.tV(fileMY))));
                if (mapMY.isEmpty()) {
                    return;
                }
                for (Map.Entry<String, MY> entry : mapMY.entrySet()) {
                    IlO.put(entry.getKey(), entry.getValue());
                }
                return;
            }
            String strMY = com.bytedance.sdk.openadsdk.multipro.MY.EO() ? com.bytedance.sdk.openadsdk.multipro.tV.IlO.MY("tt_sdk_settings", "ad_slot_conf", null) : nvX.IlO("tt_sdk_settings", cl.IlO()).IlO("ad_slot_conf", (String) null);
            if (TextUtils.isEmpty(strMY)) {
                return;
            }
            HashMap<String, MY> mapMY2 = MY(new JSONArray(strMY));
            if (mapMY2.isEmpty()) {
                return;
            }
            ConcurrentHashMap<String, MY> concurrentHashMap = IlO;
            concurrentHashMap.clear();
            concurrentHashMap.putAll(mapMY2);
        } catch (Exception unused) {
        }
    }

    @NonNull
    private static HashMap<String, MY> MY(JSONArray jSONArray) {
        HashMap<String, MY> map = new HashMap<>();
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            try {
                MY myIlO = IlO(jSONArray.getJSONObject(i2));
                if (myIlO != null) {
                    map.put(myIlO.IlO, myIlO);
                }
            } catch (Exception unused) {
            }
        }
        return map;
    }

    @NonNull
    private static File MY() {
        return new File(cl.IlO().getFilesDir(), "tt_ads_conf_sr");
    }

    private static MY MY(String str) {
        return new MY(str, 1);
    }

    private static MY IlO(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        return new MY(jSONObject);
    }

    @NonNull
    public static MY IlO(String str) {
        MY my = IlO.get(str);
        return my == null ? MY(str) : my;
    }

    @WorkerThread
    public static void IlO(JSONArray jSONArray) throws Throwable {
        if (jSONArray == null) {
            return;
        }
        File fileMY = MY();
        File file = new File(fileMY.getParent(), fileMY.getName() + ".tmp");
        FileWriter fileWriter = null;
        try {
            try {
                if (file.exists()) {
                    file.delete();
                }
                FileWriter fileWriter2 = new FileWriter(file);
                try {
                    fileWriter2.write(jSONArray.toString());
                    file.renameTo(fileMY);
                    nvX.IlO("tt_sdk_settings", cl.IlO()).IlO("ad_slot_conf");
                    if (file.exists()) {
                        file.delete();
                    }
                    com.bytedance.sdk.openadsdk.utils.hp.IlO(fileWriter2);
                } catch (Exception e) {
                    e = e;
                    fileWriter = fileWriter2;
                    Log.e("SdkSettings.AdSlot", "saveAdSlotToLocal: ", e);
                    if (file.exists()) {
                        file.delete();
                    }
                    com.bytedance.sdk.openadsdk.utils.hp.IlO(fileWriter);
                } catch (Throwable th) {
                    th = th;
                    fileWriter = fileWriter2;
                    if (file.exists()) {
                        file.delete();
                    }
                    com.bytedance.sdk.openadsdk.utils.hp.IlO(fileWriter);
                    throw th;
                }
            } catch (Exception e4) {
                e = e4;
            }
            HashMap<String, MY> mapMY = MY(jSONArray);
            if (mapMY.isEmpty()) {
                return;
            }
            for (Map.Entry<String, MY> entry : mapMY.entrySet()) {
                IlO.put(entry.getKey(), entry.getValue());
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static void IlO() {
        File fileMY = MY();
        if (fileMY.exists()) {
            fileMY.delete();
        }
    }
}
