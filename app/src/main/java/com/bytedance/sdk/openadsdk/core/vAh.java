package com.bytedance.sdk.openadsdk.core;

import android.os.Build;
import androidx.annotation.Nullable;
import com.bytedance.sdk.component.embedapplog.PangleEncryptConstant;
import com.ironsource.Q6;
import com.vungle.ads.internal.signals.SignalManager;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class vAh {
    private static final AtomicInteger EO;
    private static final AtomicInteger IlO;
    private static final AtomicInteger MY;
    private static final AtomicInteger tV;

    static {
        AtomicInteger atomicInteger = new AtomicInteger();
        IlO = atomicInteger;
        AtomicInteger atomicInteger2 = new AtomicInteger();
        MY = atomicInteger2;
        AtomicInteger atomicInteger3 = new AtomicInteger();
        EO = atomicInteger3;
        AtomicInteger atomicInteger4 = new AtomicInteger();
        tV = atomicInteger4;
        atomicInteger.addAndGet(com.bytedance.sdk.openadsdk.multipro.tV.tV.IlO("encrypt_statistics_file", "encrypt_success_count", 0));
        atomicInteger2.addAndGet(com.bytedance.sdk.openadsdk.multipro.tV.tV.IlO("encrypt_statistics_file", "encrypt_fail_count", 0));
        atomicInteger3.addAndGet(com.bytedance.sdk.openadsdk.multipro.tV.tV.IlO("encrypt_statistics_file", "decrypt_success_count", 0));
        atomicInteger4.addAndGet(com.bytedance.sdk.openadsdk.multipro.tV.tV.IlO("encrypt_statistics_file", "decrypt_fail_count", 0));
    }

    public static void IlO() {
        try {
            long jIlO = com.bytedance.sdk.openadsdk.multipro.tV.tV.IlO("encrypt_statistics_file", "upload_time_key", 0L);
            if (jIlO <= 0 || System.currentTimeMillis() - jIlO < SignalManager.TWENTY_FOUR_HOURS_MILLIS) {
                if (jIlO <= 0 || jIlO > System.currentTimeMillis()) {
                    com.bytedance.sdk.openadsdk.multipro.tV.tV.IlO("encrypt_statistics_file", "upload_time_key", Long.valueOf(System.currentTimeMillis()));
                    return;
                }
                return;
            }
            MY();
            synchronized (vAh.class) {
                IlO.set(0);
                MY.set(0);
                EO.set(0);
                tV.set(0);
                com.bytedance.sdk.openadsdk.multipro.tV.tV.IlO("encrypt_statistics_file");
                com.bytedance.sdk.openadsdk.multipro.tV.tV.IlO("encrypt_statistics_file", "upload_time_key", Long.valueOf(System.currentTimeMillis()));
            }
        } catch (Throwable unused) {
        }
    }

    private static void MY() {
        final int i2 = IlO.get();
        final int i8 = MY.get();
        final int i9 = EO.get();
        final int i10 = tV.get();
        com.bytedance.sdk.openadsdk.ea.EO.IlO("crypt_v4_statistics", false, new com.bytedance.sdk.openadsdk.ea.MY() { // from class: com.bytedance.sdk.openadsdk.core.vAh.1
            @Override // com.bytedance.sdk.openadsdk.ea.MY
            @Nullable
            public com.bytedance.sdk.openadsdk.ea.IlO.EO getLogStats() throws Exception {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("encrypt_success_count", i2);
                    jSONObject.put("encrypt_fail_count", i8);
                    jSONObject.put("decrypt_success_count", i9);
                    jSONObject.put("decrypt_fail_count", i10);
                } catch (Throwable unused) {
                }
                return com.bytedance.sdk.openadsdk.ea.IlO.tV.MY().IlO("crypt_v4_statistics").MY(jSONObject.toString());
            }
        });
    }

    public static synchronized void MY(boolean z2) {
        if (z2) {
            com.bytedance.sdk.openadsdk.multipro.tV.tV.IlO("encrypt_statistics_file", "encrypt_success_count", Integer.valueOf(IlO.incrementAndGet()));
        } else {
            com.bytedance.sdk.openadsdk.multipro.tV.tV.IlO("encrypt_statistics_file", "encrypt_fail_count", Integer.valueOf(MY.incrementAndGet()));
        }
    }

    public static void IlO(final int i2, final PangleEncryptConstant.CryptDataScene cryptDataScene, final int i8) {
        com.bytedance.sdk.openadsdk.ea.EO.IlO("crypt_v4_fail", false, new com.bytedance.sdk.openadsdk.ea.MY() { // from class: com.bytedance.sdk.openadsdk.core.vAh.2
            @Override // com.bytedance.sdk.openadsdk.ea.MY
            @Nullable
            public com.bytedance.sdk.openadsdk.ea.IlO.EO getLogStats() throws Exception {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("crypt", i2);
                    jSONObject.put("scene", cryptDataScene.value());
                    jSONObject.put("reason", i8);
                    if (i8 == 6) {
                        jSONObject.put(Q6.B, Build.MODEL);
                        jSONObject.put("vendor", Build.MANUFACTURER);
                    }
                } catch (Throwable unused) {
                }
                return com.bytedance.sdk.openadsdk.ea.IlO.tV.MY().IlO("crypt_v4_fail").MY(jSONObject.toString());
            }
        });
    }

    public static synchronized void IlO(boolean z2) {
        if (z2) {
            com.bytedance.sdk.openadsdk.multipro.tV.tV.IlO("encrypt_statistics_file", "decrypt_success_count", Integer.valueOf(EO.incrementAndGet()));
        } else {
            com.bytedance.sdk.openadsdk.multipro.tV.tV.IlO("encrypt_statistics_file", "decrypt_fail_count", Integer.valueOf(EO.incrementAndGet()));
        }
    }

    public static void IlO(JSONObject jSONObject) {
        MY(jSONObject != null && jSONObject.optInt("cypher") == 4);
    }
}
