package com.bytedance.sdk.component.adexpress.tV;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class tV {
    public static void IlO(com.bytedance.sdk.component.lEW.lEW lew, int i2) {
        if (lew == null) {
            return;
        }
        com.bytedance.sdk.component.adexpress.IlO.IlO.EO EO = com.bytedance.sdk.component.adexpress.IlO.IlO.IlO.IlO().EO();
        ExecutorService executorServiceBWL = EO != null ? EO.bWL() : null;
        if (executorServiceBWL == null) {
            com.bytedance.sdk.component.lEW.vCE.IlO(lew, i2);
        } else {
            lew.setPriority(i2);
            executorServiceBWL.execute(lew);
        }
    }

    public static void MY(com.bytedance.sdk.component.lEW.lEW lew, int i2) {
        if (lew == null) {
            return;
        }
        com.bytedance.sdk.component.adexpress.IlO.IlO.EO EO = com.bytedance.sdk.component.adexpress.IlO.IlO.IlO.IlO().EO();
        ExecutorService executorServiceHp = EO != null ? EO.hp() : null;
        if (executorServiceHp == null) {
            com.bytedance.sdk.component.lEW.vCE.IlO(lew);
        } else {
            lew.setPriority(i2);
            executorServiceHp.execute(lew);
        }
    }

    public static ScheduledFuture IlO(Runnable runnable, long j, TimeUnit timeUnit) {
        return com.bytedance.sdk.component.lEW.vCE.vCE().schedule(runnable, j, timeUnit);
    }
}
