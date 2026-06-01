package com.bytedance.sdk.openadsdk.tV.IlO;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class IlO {
    public static final MY IlO = new MY(0);
    public static final MY MY = new MY(1);
    public static final MY EO = new MY(2);
    public static final MY tV = new MY(0);
    public static final MY Cc = new MY(1);
    public static final MY vCE = new MY(2);

    public static void IlO(MY my, boolean z2, int i2, long j) {
        try {
            my.Bc.getAndSet(true);
            if (z2) {
                my.IlO.incrementAndGet();
                my.EO.addAndGet(j);
                return;
            }
            my.MY.incrementAndGet();
            Integer num = my.vCE.get(Integer.valueOf(i2));
            if (num != null) {
                my.vCE.put(Integer.valueOf(i2), Integer.valueOf(num.intValue() + 1));
            } else {
                my.vCE.put(Integer.valueOf(i2), 1);
            }
        } catch (Throwable unused) {
        }
    }

    public static void MY() {
        try {
            com.bytedance.sdk.openadsdk.ea.EO.MY("net_upload_monitor", com.bytedance.sdk.openadsdk.multipro.tV.IlO.MY("tt_sdk_event_net_ad", "tt_sdk_event_net_ad", ""));
            com.bytedance.sdk.openadsdk.multipro.tV.IlO.IlO("tt_sdk_event_net_ad");
            com.bytedance.sdk.openadsdk.ea.EO.MY("net_upload_monitor", com.bytedance.sdk.openadsdk.multipro.tV.IlO.MY("tt_sdk_event_net_state", "tt_sdk_event_net_state", ""));
            com.bytedance.sdk.openadsdk.multipro.tV.IlO.IlO("tt_sdk_event_net_state");
            com.bytedance.sdk.openadsdk.ea.EO.MY("net_upload_monitor", com.bytedance.sdk.openadsdk.multipro.tV.IlO.MY("tt_sdk_event_net_trail", "tt_sdk_event_net_trail", ""));
            com.bytedance.sdk.openadsdk.multipro.tV.IlO.IlO("tt_sdk_event_net_trail");
            com.bytedance.sdk.openadsdk.ea.EO.MY("db_upload_monitor", com.bytedance.sdk.openadsdk.multipro.tV.IlO.MY("tt_sdk_event_db_ad", "tt_sdk_event_db_ad", ""));
            com.bytedance.sdk.openadsdk.multipro.tV.IlO.IlO("tt_sdk_event_db_ad");
            com.bytedance.sdk.openadsdk.ea.EO.MY("db_upload_monitor", com.bytedance.sdk.openadsdk.multipro.tV.IlO.MY("tt_sdk_event_db_state", "tt_sdk_event_db_state", ""));
            com.bytedance.sdk.openadsdk.multipro.tV.IlO.IlO("tt_sdk_event_db_state");
            com.bytedance.sdk.openadsdk.ea.EO.MY("db_upload_monitor", com.bytedance.sdk.openadsdk.multipro.tV.IlO.MY("tt_sdk_event_db_trail", "tt_sdk_event_db_trail", ""));
            com.bytedance.sdk.openadsdk.multipro.tV.IlO.IlO("tt_sdk_event_db_trail");
        } catch (Throwable unused) {
        }
    }

    public static void IlO(MY my, boolean z2) {
        try {
            my.Bc.getAndSet(true);
            if (z2) {
                my.IlO.incrementAndGet();
            } else {
                my.MY.incrementAndGet();
            }
        } catch (Throwable unused) {
        }
    }

    public static void IlO(MY my) {
        try {
            my.Bc.getAndSet(true);
            my.Cc.incrementAndGet();
        } catch (Throwable unused) {
        }
    }

    public static void IlO() {
        try {
            MY my = IlO;
            if (my.Bc.get()) {
                com.bytedance.sdk.openadsdk.multipro.tV.IlO.IlO("tt_sdk_event_net_ad", "tt_sdk_event_net_ad", my.IlO().toString());
            }
            MY my2 = MY;
            if (my2.Bc.get()) {
                com.bytedance.sdk.openadsdk.multipro.tV.IlO.IlO("tt_sdk_event_net_state", "tt_sdk_event_net_state", my2.IlO().toString());
            }
            MY my3 = EO;
            if (my3.Bc.get()) {
                com.bytedance.sdk.openadsdk.multipro.tV.IlO.IlO("tt_sdk_event_net_trail", "tt_sdk_event_net_trail", my3.IlO().toString());
            }
            MY my4 = tV;
            if (my4.Bc.get()) {
                com.bytedance.sdk.openadsdk.multipro.tV.IlO.IlO("tt_sdk_event_db_ad", "tt_sdk_event_db_ad", my4.MY().toString());
            }
            MY my5 = Cc;
            if (my5.Bc.get()) {
                com.bytedance.sdk.openadsdk.multipro.tV.IlO.IlO("tt_sdk_event_db_state", "tt_sdk_event_db_state", my5.MY().toString());
            }
            MY my6 = vCE;
            if (my6.Bc.get()) {
                com.bytedance.sdk.openadsdk.multipro.tV.IlO.IlO("tt_sdk_event_db_trail", "tt_sdk_event_db_trail", my6.MY().toString());
            }
        } catch (Throwable unused) {
        }
    }
}
