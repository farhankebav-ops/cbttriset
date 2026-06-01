package com.ironsource;

import android.text.TextUtils;
import com.ironsource.AbstractC2477o0;
import com.ironsource.D0;
import com.ironsource.mediationsdk.logger.IronLog;
import java.util.Arrays;

/* JADX INFO: renamed from: com.ironsource.fc, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class C2326fc extends AbstractC2477o0 {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2326fc(C2459n0 adTools, C2344gc adUnitData, InterfaceC2362hc listener) {
        String str;
        int iB;
        super(adTools, adUnitData, listener, null, 8, null);
        kotlin.jvm.internal.k.e(adTools, "adTools");
        kotlin.jvm.internal.k.e(adUnitData, "adUnitData");
        kotlin.jvm.internal.k.e(listener, "listener");
        C2434ld c2434ldG = g();
        IronLog.INTERNAL.verbose("placement = " + c2434ldG);
        if (c2434ldG == null || TextUtils.isEmpty(c2434ldG.c())) {
            str = String.format("can't load native ad - %s", Arrays.copyOf(new Object[]{c2434ldG == null ? "placement is null" : "placement name is empty"}, 1));
            iB = C2663z0.b(adUnitData.b().a());
        } else {
            str = null;
            iB = 510;
        }
        if (str != null) {
            IronLog.API.error(a(str));
            a(iB, str);
        }
    }

    @Override // com.ironsource.AbstractC2477o0
    public C a() {
        return new ah(this, 3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AbstractC2662z a(C2326fc this$0, A adInstanceData, G adInstancePayload) {
        kotlin.jvm.internal.k.e(this$0, "this$0");
        kotlin.jvm.internal.k.e(adInstanceData, "adInstanceData");
        kotlin.jvm.internal.k.e(adInstancePayload, "adInstancePayload");
        return new Xb(new V0(this$0.f(), D0.b.PROVIDER), adInstanceData, adInstancePayload, new AbstractC2477o0.a());
    }
}
