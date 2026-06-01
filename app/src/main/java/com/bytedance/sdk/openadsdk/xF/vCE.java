package com.bytedance.sdk.openadsdk.xF;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import androidx.core.app.NotificationCompat;
import com.ironsource.C2300e4;
import com.ironsource.Q6;
import com.vungle.ads.internal.presenter.MRAIDPresenter;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class vCE {
    private Context IlO;
    private WeakReference<lEW> MY;
    private Map<String, IlO> EO = new HashMap();
    private SensorEventListener tV = new SensorEventListener() { // from class: com.bytedance.sdk.openadsdk.xF.vCE.1
        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
            lEW lewTV;
            if (sensorEvent.sensor.getType() != 1 || (lewTV = vCE.this.tV()) == null) {
                return;
            }
            float[] fArr = sensorEvent.values;
            float f4 = fArr[0];
            float f8 = fArr[1];
            float f9 = fArr[2];
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("x", f4);
                jSONObject.put("y", f8);
                jSONObject.put("z", f9);
                lewTV.IlO("accelerometer_callback", jSONObject);
            } catch (Throwable unused) {
            }
        }

        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i2) {
        }
    };
    private SensorEventListener Cc = new SensorEventListener() { // from class: com.bytedance.sdk.openadsdk.xF.vCE.12
        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
            lEW lewTV;
            if (sensorEvent.sensor.getType() != 4 || (lewTV = vCE.this.tV()) == null) {
                return;
            }
            float degrees = (float) Math.toDegrees(sensorEvent.values[0]);
            float degrees2 = (float) Math.toDegrees(sensorEvent.values[1]);
            float degrees3 = (float) Math.toDegrees(sensorEvent.values[2]);
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("x", degrees);
                jSONObject.put("y", degrees2);
                jSONObject.put("z", degrees3);
                lewTV.IlO("gyro_callback", jSONObject);
            } catch (Throwable unused) {
            }
        }

        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i2) {
        }
    };
    private SensorEventListener vCE = new SensorEventListener() { // from class: com.bytedance.sdk.openadsdk.xF.vCE.23
        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
            lEW lewTV;
            if (sensorEvent.sensor.getType() != 10 || (lewTV = vCE.this.tV()) == null) {
                return;
            }
            float[] fArr = sensorEvent.values;
            float f4 = fArr[0];
            float f8 = fArr[1];
            float f9 = fArr[2];
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("x", f4);
                jSONObject.put("y", f8);
                jSONObject.put("z", f9);
                lewTV.IlO("accelerometer_grativityless_callback", jSONObject);
            } catch (Throwable unused) {
            }
        }

        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i2) {
        }
    };
    private SensorEventListener Bc = new SensorEventListener() { // from class: com.bytedance.sdk.openadsdk.xF.vCE.34
        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
            if (sensorEvent.sensor.getType() == 1) {
                float[] fArr = sensorEvent.values;
                float[] fArr2 = NV.MY;
                System.arraycopy(fArr, 0, fArr2, 0, fArr2.length);
            } else if (sensorEvent.sensor.getType() == 2) {
                float[] fArr3 = sensorEvent.values;
                float[] fArr4 = NV.EO;
                System.arraycopy(fArr3, 0, fArr4, 0, fArr4.length);
            }
            float[] fArr5 = NV.tV;
            SensorManager.getRotationMatrix(fArr5, null, NV.MY, NV.EO);
            float[] fArr6 = NV.Cc;
            SensorManager.getOrientation(fArr5, fArr6);
            lEW lewTV = vCE.this.tV();
            if (lewTV == null) {
                return;
            }
            float f4 = fArr6[0];
            float f8 = fArr6[1];
            float f9 = fArr6[2];
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("alpha", f4);
                jSONObject.put("beta", f8);
                jSONObject.put("gamma", f9);
                lewTV.IlO("rotation_vector_callback", jSONObject);
            } catch (Throwable unused) {
            }
        }

        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i2) {
        }
    };

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public interface IlO {
        JSONObject IlO(JSONObject jSONObject) throws Throwable;
    }

    public vCE(lEW lew) {
        this.IlO = lew.IlO();
        this.MY = new WeakReference<>(lew);
        EO();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.bytedance.sdk.openadsdk.xF.IlO Cc() {
        lEW lewTV = tV();
        if (lewTV == null) {
            return null;
        }
        return lewTV.cl();
    }

    private void EO() {
        this.EO.put("adInfo", new IlO() { // from class: com.bytedance.sdk.openadsdk.xF.vCE.45
            @Override // com.bytedance.sdk.openadsdk.xF.vCE.IlO
            public JSONObject IlO(JSONObject jSONObject) throws Throwable {
                lEW lewTV = vCE.this.tV();
                if (lewTV == null) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                JSONObject jSONObjectEs = lewTV.es();
                if (jSONObjectEs != null) {
                    jSONObjectEs.put("code", 1);
                    return jSONObjectEs;
                }
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("code", -1);
                return jSONObject3;
            }
        });
        this.EO.put("appInfo", new IlO() { // from class: com.bytedance.sdk.openadsdk.xF.vCE.56
            @Override // com.bytedance.sdk.openadsdk.xF.vCE.IlO
            public JSONObject IlO(JSONObject jSONObject) throws Throwable {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("code", 1);
                jSONObject2.put("appName", "playable_sdk");
                jSONObject2.put("playableSdkEdition", "6.6.0");
                JSONArray jSONArray = new JSONArray();
                Iterator<String> it = vCE.this.IlO().iterator();
                while (it.hasNext()) {
                    jSONArray.put(it.next());
                }
                jSONObject2.put("supportList", jSONArray);
                lEW lewTV = vCE.this.tV();
                if (lewTV != null) {
                    jSONObject2.put("deviceId", lewTV.Bc());
                    jSONObject2.put("netType", lewTV.zPa());
                    jSONObject2.put("innerAppName", lewTV.tV());
                    jSONObject2.put("appName", lewTV.Cc());
                    jSONObject2.put("appVersion", lewTV.vCE());
                    Map<String, String> mapMY = lewTV.MY();
                    for (String str : mapMY.keySet()) {
                        jSONObject2.put(str, mapMY.get(str));
                    }
                }
                return jSONObject2;
            }
        });
        this.EO.put("playableSDKInfo", new IlO() { // from class: com.bytedance.sdk.openadsdk.xF.vCE.61
            @Override // com.bytedance.sdk.openadsdk.xF.vCE.IlO
            public JSONObject IlO(JSONObject jSONObject) throws Throwable {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("code", 1);
                jSONObject2.put("appName", "playable_sdk");
                jSONObject2.put("playableSdkEdition", "6.6.0");
                jSONObject2.put(Q6.F, "android");
                return jSONObject2;
            }
        });
        this.EO.put("subscribe_app_ad", new IlO() { // from class: com.bytedance.sdk.openadsdk.xF.vCE.62
            @Override // com.bytedance.sdk.openadsdk.xF.vCE.IlO
            public JSONObject IlO(JSONObject jSONObject) throws Throwable {
                com.bytedance.sdk.openadsdk.xF.IlO ilOCc = vCE.this.Cc();
                JSONObject jSONObject2 = new JSONObject();
                if (ilOCc == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.EO.put("download_app_ad", new IlO() { // from class: com.bytedance.sdk.openadsdk.xF.vCE.63
            @Override // com.bytedance.sdk.openadsdk.xF.vCE.IlO
            public JSONObject IlO(JSONObject jSONObject) throws Throwable {
                com.bytedance.sdk.openadsdk.xF.IlO ilOCc = vCE.this.Cc();
                JSONObject jSONObject2 = new JSONObject();
                if (ilOCc == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.EO.put(C2300e4.h.f8376o, new IlO() { // from class: com.bytedance.sdk.openadsdk.xF.vCE.2
            @Override // com.bytedance.sdk.openadsdk.xF.vCE.IlO
            public JSONObject IlO(JSONObject jSONObject) throws Throwable {
                lEW lewTV = vCE.this.tV();
                if (lewTV == null) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("code", 1);
                jSONObject3.put("viewStatus", lewTV.DmF());
                return jSONObject3;
            }
        });
        this.EO.put("getVolume", new IlO() { // from class: com.bytedance.sdk.openadsdk.xF.vCE.3
            @Override // com.bytedance.sdk.openadsdk.xF.vCE.IlO
            public JSONObject IlO(JSONObject jSONObject) throws Throwable {
                lEW lewTV = vCE.this.tV();
                if (lewTV == null) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("code", 1);
                jSONObject3.put("endcard_mute", lewTV.lEW());
                return jSONObject3;
            }
        });
        this.EO.put("getScreenSize", new IlO() { // from class: com.bytedance.sdk.openadsdk.xF.vCE.4
            @Override // com.bytedance.sdk.openadsdk.xF.vCE.IlO
            public JSONObject IlO(JSONObject jSONObject) throws Throwable {
                lEW lewTV = vCE.this.tV();
                if (lewTV == null) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                JSONObject jSONObjectCL = lewTV.cL();
                jSONObjectCL.put("code", 1);
                return jSONObjectCL;
            }
        });
        this.EO.put("start_accelerometer_observer", new IlO() { // from class: com.bytedance.sdk.openadsdk.xF.vCE.5
            @Override // com.bytedance.sdk.openadsdk.xF.vCE.IlO
            public JSONObject IlO(JSONObject jSONObject) throws Throwable {
                JSONObject jSONObject2 = new JSONObject();
                int iOptInt = 2;
                if (jSONObject != null) {
                    try {
                        iOptInt = jSONObject.optInt("interval_android", 2);
                    } catch (Throwable th) {
                        Bc.IlO("PlayableJsBridge", "invoke start_accelerometer_observer error", th);
                        jSONObject2.put("code", -1);
                        jSONObject2.put("codeMsg", th.toString());
                        return jSONObject2;
                    }
                }
                NV.IlO(vCE.this.IlO, vCE.this.tV, iOptInt);
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.EO.put("close_accelerometer_observer", new IlO() { // from class: com.bytedance.sdk.openadsdk.xF.vCE.6
            @Override // com.bytedance.sdk.openadsdk.xF.vCE.IlO
            public JSONObject IlO(JSONObject jSONObject) throws Throwable {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    NV.IlO(vCE.this.IlO, vCE.this.tV);
                    jSONObject2.put("code", 1);
                    return jSONObject2;
                } catch (Throwable th) {
                    Bc.IlO("PlayableJsBridge", "invoke close_accelerometer_observer error", th);
                    jSONObject2.put("code", -1);
                    jSONObject2.put("codeMsg", th.toString());
                    return jSONObject2;
                }
            }
        });
        this.EO.put("start_gyro_observer", new IlO() { // from class: com.bytedance.sdk.openadsdk.xF.vCE.7
            @Override // com.bytedance.sdk.openadsdk.xF.vCE.IlO
            public JSONObject IlO(JSONObject jSONObject) throws Throwable {
                JSONObject jSONObject2 = new JSONObject();
                int iOptInt = 2;
                if (jSONObject != null) {
                    try {
                        iOptInt = jSONObject.optInt("interval_android", 2);
                    } catch (Throwable th) {
                        Bc.IlO("PlayableJsBridge", "invoke start_gyro_observer error", th);
                        jSONObject2.put("code", -1);
                        jSONObject2.put("codeMsg", th.toString());
                        return jSONObject2;
                    }
                }
                NV.MY(vCE.this.IlO, vCE.this.Cc, iOptInt);
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.EO.put("close_gyro_observer", new IlO() { // from class: com.bytedance.sdk.openadsdk.xF.vCE.8
            @Override // com.bytedance.sdk.openadsdk.xF.vCE.IlO
            public JSONObject IlO(JSONObject jSONObject) throws Throwable {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    NV.IlO(vCE.this.IlO, vCE.this.Cc);
                    jSONObject2.put("code", 1);
                    return jSONObject2;
                } catch (Throwable th) {
                    Bc.IlO("PlayableJsBridge", "invoke close_gyro_observer error", th);
                    jSONObject2.put("code", -1);
                    jSONObject2.put("codeMsg", th.toString());
                    return jSONObject2;
                }
            }
        });
        this.EO.put("start_accelerometer_grativityless_observer", new IlO() { // from class: com.bytedance.sdk.openadsdk.xF.vCE.9
            @Override // com.bytedance.sdk.openadsdk.xF.vCE.IlO
            public JSONObject IlO(JSONObject jSONObject) throws Throwable {
                JSONObject jSONObject2 = new JSONObject();
                int iOptInt = 2;
                if (jSONObject != null) {
                    try {
                        iOptInt = jSONObject.optInt("interval_android", 2);
                    } catch (Throwable th) {
                        Bc.IlO("PlayableJsBridge", "invoke start_accelerometer_grativityless_observer error", th);
                        jSONObject2.put("code", -1);
                        jSONObject2.put("codeMsg", th.toString());
                        return jSONObject2;
                    }
                }
                NV.EO(vCE.this.IlO, vCE.this.vCE, iOptInt);
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.EO.put("close_accelerometer_grativityless_observer", new IlO() { // from class: com.bytedance.sdk.openadsdk.xF.vCE.10
            @Override // com.bytedance.sdk.openadsdk.xF.vCE.IlO
            public JSONObject IlO(JSONObject jSONObject) throws Throwable {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    NV.IlO(vCE.this.IlO, vCE.this.vCE);
                    jSONObject2.put("code", 1);
                    return jSONObject2;
                } catch (Throwable th) {
                    Bc.IlO("PlayableJsBridge", "invoke close_accelerometer_grativityless_observer error", th);
                    jSONObject2.put("code", -1);
                    jSONObject2.put("codeMsg", th.toString());
                    return jSONObject2;
                }
            }
        });
        this.EO.put("start_rotation_vector_observer", new IlO() { // from class: com.bytedance.sdk.openadsdk.xF.vCE.11
            @Override // com.bytedance.sdk.openadsdk.xF.vCE.IlO
            public JSONObject IlO(JSONObject jSONObject) throws Throwable {
                JSONObject jSONObject2 = new JSONObject();
                int iOptInt = 2;
                if (jSONObject != null) {
                    try {
                        iOptInt = jSONObject.optInt("interval_android", 2);
                    } catch (Throwable th) {
                        Bc.IlO("PlayableJsBridge", "invoke start_rotation_vector_observer error", th);
                        jSONObject2.put("code", -1);
                        jSONObject2.put("codeMsg", th.toString());
                        return jSONObject2;
                    }
                }
                NV.tV(vCE.this.IlO, vCE.this.Bc, iOptInt);
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.EO.put("close_rotation_vector_observer", new IlO() { // from class: com.bytedance.sdk.openadsdk.xF.vCE.13
            @Override // com.bytedance.sdk.openadsdk.xF.vCE.IlO
            public JSONObject IlO(JSONObject jSONObject) throws Throwable {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    NV.IlO(vCE.this.IlO, vCE.this.Bc);
                    jSONObject2.put("code", 1);
                    return jSONObject2;
                } catch (Throwable th) {
                    Bc.IlO("PlayableJsBridge", "invoke close_rotation_vector_observer error", th);
                    jSONObject2.put("code", -1);
                    jSONObject2.put("codeMsg", th.toString());
                    return jSONObject2;
                }
            }
        });
        this.EO.put("device_shake", new IlO() { // from class: com.bytedance.sdk.openadsdk.xF.vCE.14
            @Override // com.bytedance.sdk.openadsdk.xF.vCE.IlO
            public JSONObject IlO(JSONObject jSONObject) throws Throwable {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    NV.IlO(vCE.this.IlO, 300L);
                    jSONObject2.put("code", 1);
                    return jSONObject2;
                } catch (Throwable th) {
                    Bc.IlO("PlayableJsBridge", "invoke device_shake error", th);
                    jSONObject2.put("code", -1);
                    jSONObject2.put("codeMsg", th.toString());
                    return jSONObject2;
                }
            }
        });
        this.EO.put("device_shake_short", new IlO() { // from class: com.bytedance.sdk.openadsdk.xF.vCE.15
            @Override // com.bytedance.sdk.openadsdk.xF.vCE.IlO
            public JSONObject IlO(JSONObject jSONObject) throws Throwable {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    NV.IlO(vCE.this.IlO, 150L);
                    jSONObject2.put("code", 1);
                    return jSONObject2;
                } catch (Throwable th) {
                    Bc.IlO("PlayableJsBridge", "invoke device_shake error", th);
                    jSONObject2.put("code", -1);
                    jSONObject2.put("codeMsg", th.toString());
                    return jSONObject2;
                }
            }
        });
        this.EO.put("playable_style", new IlO() { // from class: com.bytedance.sdk.openadsdk.xF.vCE.16
            @Override // com.bytedance.sdk.openadsdk.xF.vCE.IlO
            public JSONObject IlO(JSONObject jSONObject) throws Throwable {
                lEW lewTV = vCE.this.tV();
                JSONObject jSONObject2 = new JSONObject();
                if (lewTV == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                JSONObject jSONObjectEO = lewTV.EO();
                jSONObjectEO.put("code", 1);
                return jSONObjectEO;
            }
        });
        this.EO.put("sendReward", new IlO() { // from class: com.bytedance.sdk.openadsdk.xF.vCE.17
            @Override // com.bytedance.sdk.openadsdk.xF.vCE.IlO
            public JSONObject IlO(JSONObject jSONObject) throws Throwable {
                lEW lewTV = vCE.this.tV();
                JSONObject jSONObject2 = new JSONObject();
                if (lewTV == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                lewTV.AXM();
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.EO.put("webview_time_track", new IlO() { // from class: com.bytedance.sdk.openadsdk.xF.vCE.18
            @Override // com.bytedance.sdk.openadsdk.xF.vCE.IlO
            public JSONObject IlO(JSONObject jSONObject) throws Throwable {
                return new JSONObject();
            }
        });
        this.EO.put("playable_event", new IlO() { // from class: com.bytedance.sdk.openadsdk.xF.vCE.19
            @Override // com.bytedance.sdk.openadsdk.xF.vCE.IlO
            public JSONObject IlO(JSONObject jSONObject) throws Throwable {
                lEW lewTV = vCE.this.tV();
                JSONObject jSONObject2 = new JSONObject();
                if (lewTV == null || jSONObject == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                lewTV.MY(jSONObject.optString(NotificationCompat.CATEGORY_EVENT, null), jSONObject.optJSONObject("params"));
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.EO.put("reportAd", new IlO() { // from class: com.bytedance.sdk.openadsdk.xF.vCE.20
            @Override // com.bytedance.sdk.openadsdk.xF.vCE.IlO
            public JSONObject IlO(JSONObject jSONObject) throws Throwable {
                lEW lewTV = vCE.this.tV();
                JSONObject jSONObject2 = new JSONObject();
                if (lewTV == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.EO.put(MRAIDPresenter.CLOSE, new IlO() { // from class: com.bytedance.sdk.openadsdk.xF.vCE.21
            @Override // com.bytedance.sdk.openadsdk.xF.vCE.IlO
            public JSONObject IlO(JSONObject jSONObject) throws Throwable {
                lEW lewTV = vCE.this.tV();
                JSONObject jSONObject2 = new JSONObject();
                if (lewTV == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.EO.put("openAdLandPageLinks", new IlO() { // from class: com.bytedance.sdk.openadsdk.xF.vCE.22
            @Override // com.bytedance.sdk.openadsdk.xF.vCE.IlO
            public JSONObject IlO(JSONObject jSONObject) throws Throwable {
                lEW lewTV = vCE.this.tV();
                JSONObject jSONObject2 = new JSONObject();
                if (lewTV == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.EO.put("get_viewport", new IlO() { // from class: com.bytedance.sdk.openadsdk.xF.vCE.24
            @Override // com.bytedance.sdk.openadsdk.xF.vCE.IlO
            public JSONObject IlO(JSONObject jSONObject) throws Throwable {
                lEW lewTV = vCE.this.tV();
                JSONObject jSONObject2 = new JSONObject();
                if (lewTV == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                JSONObject jSONObjectXF = lewTV.xF();
                jSONObjectXF.put("code", 1);
                return jSONObjectXF;
            }
        });
        this.EO.put("jssdk_load_finish", new IlO() { // from class: com.bytedance.sdk.openadsdk.xF.vCE.25
            @Override // com.bytedance.sdk.openadsdk.xF.vCE.IlO
            public JSONObject IlO(JSONObject jSONObject) throws Throwable {
                lEW lewTV = vCE.this.tV();
                JSONObject jSONObject2 = new JSONObject();
                if (lewTV == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                lewTV.vSq();
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.EO.put("playable_material_render_result", new IlO() { // from class: com.bytedance.sdk.openadsdk.xF.vCE.26
            @Override // com.bytedance.sdk.openadsdk.xF.vCE.IlO
            public JSONObject IlO(JSONObject jSONObject) throws Throwable {
                lEW lewTV = vCE.this.tV();
                JSONObject jSONObject2 = new JSONObject();
                if (lewTV == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                lewTV.DmF(jSONObject);
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.EO.put("detect_change_playable_click", new IlO() { // from class: com.bytedance.sdk.openadsdk.xF.vCE.27
            @Override // com.bytedance.sdk.openadsdk.xF.vCE.IlO
            public JSONObject IlO(JSONObject jSONObject) throws Throwable {
                lEW lewTV = vCE.this.tV();
                JSONObject jSONObject2 = new JSONObject();
                if (lewTV == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                JSONObject jSONObjectNV = lewTV.NV();
                jSONObjectNV.put("code", 1);
                return jSONObjectNV;
            }
        });
        this.EO.put("check_camera_permission", new IlO() { // from class: com.bytedance.sdk.openadsdk.xF.vCE.28
            @Override // com.bytedance.sdk.openadsdk.xF.vCE.IlO
            public JSONObject IlO(JSONObject jSONObject) throws Throwable {
                lEW lewTV = vCE.this.tV();
                JSONObject jSONObject2 = new JSONObject();
                if (lewTV == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                JSONObject jSONObjectHp = lewTV.hp();
                jSONObjectHp.put("code", 1);
                return jSONObjectHp;
            }
        });
        this.EO.put("check_external_storage", new IlO() { // from class: com.bytedance.sdk.openadsdk.xF.vCE.29
            @Override // com.bytedance.sdk.openadsdk.xF.vCE.IlO
            public JSONObject IlO(JSONObject jSONObject) throws Throwable {
                lEW lewTV = vCE.this.tV();
                JSONObject jSONObject2 = new JSONObject();
                if (lewTV == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                JSONObject jSONObjectBWL = lewTV.bWL();
                if (jSONObjectBWL.isNull("result")) {
                    jSONObjectBWL.put("code", -1);
                    return jSONObjectBWL;
                }
                jSONObjectBWL.put("code", 1);
                return jSONObjectBWL;
            }
        });
        this.EO.put("playable_open_camera", new IlO() { // from class: com.bytedance.sdk.openadsdk.xF.vCE.30
            @Override // com.bytedance.sdk.openadsdk.xF.vCE.IlO
            public JSONObject IlO(JSONObject jSONObject) throws Throwable {
                lEW lewTV = vCE.this.tV();
                JSONObject jSONObject2 = new JSONObject();
                if (lewTV == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.EO.put("playable_pick_photo", new IlO() { // from class: com.bytedance.sdk.openadsdk.xF.vCE.31
            @Override // com.bytedance.sdk.openadsdk.xF.vCE.IlO
            public JSONObject IlO(JSONObject jSONObject) throws Throwable {
                lEW lewTV = vCE.this.tV();
                JSONObject jSONObject2 = new JSONObject();
                if (lewTV == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.EO.put("playable_download_media_in_photos", new IlO() { // from class: com.bytedance.sdk.openadsdk.xF.vCE.32
            @Override // com.bytedance.sdk.openadsdk.xF.vCE.IlO
            public JSONObject IlO(JSONObject jSONObject) throws Throwable {
                lEW lewTV = vCE.this.tV();
                JSONObject jSONObject2 = new JSONObject();
                if (lewTV == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                lewTV.IlO(jSONObject);
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.EO.put("playable_preventTouchEvent", new IlO() { // from class: com.bytedance.sdk.openadsdk.xF.vCE.33
            @Override // com.bytedance.sdk.openadsdk.xF.vCE.IlO
            public JSONObject IlO(JSONObject jSONObject) throws Throwable {
                lEW lewTV = vCE.this.tV();
                JSONObject jSONObject2 = new JSONObject();
                if (lewTV == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                lewTV.MY(jSONObject);
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.EO.put("playable_settings_info", new IlO() { // from class: com.bytedance.sdk.openadsdk.xF.vCE.35
            @Override // com.bytedance.sdk.openadsdk.xF.vCE.IlO
            public JSONObject IlO(JSONObject jSONObject) throws Throwable {
                lEW lewTV = vCE.this.tV();
                JSONObject jSONObject2 = new JSONObject();
                if (lewTV == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                JSONObject jSONObjectEa = lewTV.ea();
                jSONObjectEa.put("code", 1);
                return jSONObjectEa;
            }
        });
        this.EO.put("playable_load_main_scene", new IlO() { // from class: com.bytedance.sdk.openadsdk.xF.vCE.36
            @Override // com.bytedance.sdk.openadsdk.xF.vCE.IlO
            public JSONObject IlO(JSONObject jSONObject) throws Throwable {
                lEW lewTV = vCE.this.tV();
                JSONObject jSONObject2 = new JSONObject();
                if (lewTV == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                lewTV.oeT();
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.EO.put("playable_enter_section", new IlO() { // from class: com.bytedance.sdk.openadsdk.xF.vCE.37
            @Override // com.bytedance.sdk.openadsdk.xF.vCE.IlO
            public JSONObject IlO(JSONObject jSONObject) throws Throwable {
                lEW lewTV = vCE.this.tV();
                JSONObject jSONObject2 = new JSONObject();
                if (lewTV == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                lewTV.tV(jSONObject);
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.EO.put("playable_end", new IlO() { // from class: com.bytedance.sdk.openadsdk.xF.vCE.38
            @Override // com.bytedance.sdk.openadsdk.xF.vCE.IlO
            public JSONObject IlO(JSONObject jSONObject) throws Throwable {
                lEW lewTV = vCE.this.tV();
                JSONObject jSONObject2 = new JSONObject();
                if (lewTV == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                lewTV.vAh();
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.EO.put("playable_finish_play_playable", new IlO() { // from class: com.bytedance.sdk.openadsdk.xF.vCE.39
            @Override // com.bytedance.sdk.openadsdk.xF.vCE.IlO
            public JSONObject IlO(JSONObject jSONObject) throws Throwable {
                lEW lewTV = vCE.this.tV();
                JSONObject jSONObject2 = new JSONObject();
                if (lewTV == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                lewTV.kBB();
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.EO.put("playable_transfrom_module_show", new IlO() { // from class: com.bytedance.sdk.openadsdk.xF.vCE.40
            @Override // com.bytedance.sdk.openadsdk.xF.vCE.IlO
            public JSONObject IlO(JSONObject jSONObject) throws Throwable {
                lEW lewTV = vCE.this.tV();
                JSONObject jSONObject2 = new JSONObject();
                if (lewTV == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                lewTV.pP();
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.EO.put("playable_transfrom_module_change_color", new IlO() { // from class: com.bytedance.sdk.openadsdk.xF.vCE.41
            @Override // com.bytedance.sdk.openadsdk.xF.vCE.IlO
            public JSONObject IlO(JSONObject jSONObject) throws Throwable {
                lEW lewTV = vCE.this.tV();
                JSONObject jSONObject2 = new JSONObject();
                if (lewTV == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                lewTV.tl();
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.EO.put("playable_set_scroll_rect", new IlO() { // from class: com.bytedance.sdk.openadsdk.xF.vCE.42
            @Override // com.bytedance.sdk.openadsdk.xF.vCE.IlO
            public JSONObject IlO(JSONObject jSONObject) throws Throwable {
                lEW lewTV = vCE.this.tV();
                JSONObject jSONObject2 = new JSONObject();
                if (lewTV == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.EO.put("playable_click_area", new IlO() { // from class: com.bytedance.sdk.openadsdk.xF.vCE.43
            @Override // com.bytedance.sdk.openadsdk.xF.vCE.IlO
            public JSONObject IlO(JSONObject jSONObject) throws Throwable {
                lEW lewTV = vCE.this.tV();
                JSONObject jSONObject2 = new JSONObject();
                if (lewTV == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                lewTV.Cc(jSONObject);
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.EO.put("playable_real_play_start", new IlO() { // from class: com.bytedance.sdk.openadsdk.xF.vCE.44
            @Override // com.bytedance.sdk.openadsdk.xF.vCE.IlO
            public JSONObject IlO(JSONObject jSONObject) throws Throwable {
                lEW lewTV = vCE.this.tV();
                JSONObject jSONObject2 = new JSONObject();
                if (lewTV == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.EO.put("playable_material_first_frame_show", new IlO() { // from class: com.bytedance.sdk.openadsdk.xF.vCE.46
            @Override // com.bytedance.sdk.openadsdk.xF.vCE.IlO
            public JSONObject IlO(JSONObject jSONObject) throws Throwable {
                lEW lewTV = vCE.this.tV();
                JSONObject jSONObject2 = new JSONObject();
                if (lewTV == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                lewTV.OOq();
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.EO.put("playable_stuck_check_pong", new IlO() { // from class: com.bytedance.sdk.openadsdk.xF.vCE.47
            @Override // com.bytedance.sdk.openadsdk.xF.vCE.IlO
            public JSONObject IlO(JSONObject jSONObject) throws Throwable {
                lEW lewTV = vCE.this.tV();
                JSONObject jSONObject2 = new JSONObject();
                if (lewTV == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                lewTV.wPn();
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.EO.put("playable_material_adnormal_mask", new IlO() { // from class: com.bytedance.sdk.openadsdk.xF.vCE.48
            @Override // com.bytedance.sdk.openadsdk.xF.vCE.IlO
            public JSONObject IlO(JSONObject jSONObject) throws Throwable {
                lEW lewTV = vCE.this.tV();
                JSONObject jSONObject2 = new JSONObject();
                if (lewTV == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                lewTV.vCE(jSONObject);
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.EO.put("playable_long_press_panel", new IlO() { // from class: com.bytedance.sdk.openadsdk.xF.vCE.49
            @Override // com.bytedance.sdk.openadsdk.xF.vCE.IlO
            public JSONObject IlO(JSONObject jSONObject) throws Throwable {
                lEW lewTV = vCE.this.tV();
                JSONObject jSONObject2 = new JSONObject();
                if (lewTV == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.EO.put("playable_alpha_player_play", new IlO() { // from class: com.bytedance.sdk.openadsdk.xF.vCE.50
            @Override // com.bytedance.sdk.openadsdk.xF.vCE.IlO
            public JSONObject IlO(JSONObject jSONObject) throws Throwable {
                lEW lewTV = vCE.this.tV();
                JSONObject jSONObject2 = new JSONObject();
                if (lewTV == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.EO.put("playable_transfrom_module_highlight", new IlO() { // from class: com.bytedance.sdk.openadsdk.xF.vCE.51
            @Override // com.bytedance.sdk.openadsdk.xF.vCE.IlO
            public JSONObject IlO(JSONObject jSONObject) throws Throwable {
                lEW lewTV = vCE.this.tV();
                JSONObject jSONObject2 = new JSONObject();
                if (lewTV == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.EO.put("playable_send_click_event", new IlO() { // from class: com.bytedance.sdk.openadsdk.xF.vCE.52
            @Override // com.bytedance.sdk.openadsdk.xF.vCE.IlO
            public JSONObject IlO(JSONObject jSONObject) throws Throwable {
                lEW lewTV = vCE.this.tV();
                JSONObject jSONObject2 = new JSONObject();
                if (lewTV == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.EO.put("playable_query_media_permission_declare", new IlO() { // from class: com.bytedance.sdk.openadsdk.xF.vCE.53
            @Override // com.bytedance.sdk.openadsdk.xF.vCE.IlO
            public JSONObject IlO(JSONObject jSONObject) throws Throwable {
                lEW lewTV = vCE.this.tV();
                JSONObject jSONObject2 = new JSONObject();
                if (lewTV == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                JSONObject jSONObjectBc = lewTV.Bc(jSONObject);
                jSONObjectBc.put("code", 1);
                return jSONObjectBc;
            }
        });
        this.EO.put("playable_query_media_permission_enable", new IlO() { // from class: com.bytedance.sdk.openadsdk.xF.vCE.54
            @Override // com.bytedance.sdk.openadsdk.xF.vCE.IlO
            public JSONObject IlO(JSONObject jSONObject) throws Throwable {
                lEW lewTV = vCE.this.tV();
                JSONObject jSONObject2 = new JSONObject();
                if (lewTV == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                JSONObject jSONObjectLEW = lewTV.lEW(jSONObject);
                jSONObjectLEW.put("code", 1);
                return jSONObjectLEW;
            }
        });
        this.EO.put("playable_apply_media_permission", new IlO() { // from class: com.bytedance.sdk.openadsdk.xF.vCE.55
            @Override // com.bytedance.sdk.openadsdk.xF.vCE.IlO
            public JSONObject IlO(JSONObject jSONObject) throws Throwable {
                com.bytedance.sdk.openadsdk.xF.IlO ilOCc = vCE.this.Cc();
                JSONObject jSONObject2 = new JSONObject();
                if (ilOCc == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.EO.put("playable_start_kws", new IlO() { // from class: com.bytedance.sdk.openadsdk.xF.vCE.57
            @Override // com.bytedance.sdk.openadsdk.xF.vCE.IlO
            public JSONObject IlO(JSONObject jSONObject) throws Throwable {
                com.bytedance.sdk.openadsdk.xF.IlO ilOCc = vCE.this.Cc();
                JSONObject jSONObject2 = new JSONObject();
                if (ilOCc == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.EO.put("playable_close_kws", new IlO() { // from class: com.bytedance.sdk.openadsdk.xF.vCE.58
            @Override // com.bytedance.sdk.openadsdk.xF.vCE.IlO
            public JSONObject IlO(JSONObject jSONObject) throws Throwable {
                com.bytedance.sdk.openadsdk.xF.IlO ilOCc = vCE.this.Cc();
                JSONObject jSONObject2 = new JSONObject();
                if (ilOCc == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.EO.put("playable_video_preload_task_add", new IlO() { // from class: com.bytedance.sdk.openadsdk.xF.vCE.59
            @Override // com.bytedance.sdk.openadsdk.xF.vCE.IlO
            public JSONObject IlO(JSONObject jSONObject) throws Throwable {
                com.bytedance.sdk.openadsdk.xF.IlO ilOCc = vCE.this.Cc();
                JSONObject jSONObject2 = new JSONObject();
                if (ilOCc == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.EO.put("playable_video_preload_task_cancel", new IlO() { // from class: com.bytedance.sdk.openadsdk.xF.vCE.60
            @Override // com.bytedance.sdk.openadsdk.xF.vCE.IlO
            public JSONObject IlO(JSONObject jSONObject) throws Throwable {
                com.bytedance.sdk.openadsdk.xF.IlO ilOCc = vCE.this.Cc();
                JSONObject jSONObject2 = new JSONObject();
                if (ilOCc == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public lEW tV() {
        WeakReference<lEW> weakReference = this.MY;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    public Set<String> IlO() {
        return this.EO.keySet();
    }

    public void MY() {
        NV.IlO(this.IlO, this.tV);
        NV.IlO(this.IlO, this.Cc);
        NV.IlO(this.IlO, this.vCE);
        NV.IlO(this.IlO, this.Bc);
    }

    public JSONObject IlO(String str, JSONObject jSONObject) {
        try {
            IlO ilO = this.EO.get(str);
            if (ilO == null) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("code", -1);
                return jSONObject2;
            }
            return ilO.IlO(jSONObject);
        } catch (Throwable th) {
            Bc.IlO("PlayableJsBridge", "invoke error", th);
            return null;
        }
    }
}
