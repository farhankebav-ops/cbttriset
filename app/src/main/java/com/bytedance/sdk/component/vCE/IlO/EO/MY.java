package com.bytedance.sdk.component.vCE.IlO.EO;

import com.bytedance.sdk.component.vCE.IlO.Cc;
import com.bytedance.sdk.component.vCE.IlO.lEW;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class MY {
    public static void IlO(AtomicLong atomicLong, int i2) {
        Cc ccZPa = lEW.Bc().zPa();
        if (ccZPa == null || !ccZPa.Bc() || atomicLong == null) {
            return;
        }
        atomicLong.getAndAdd(i2);
    }
}
