package com.unity3d.services.store.gpbl.bridges.billingclient;

import android.content.Context;
import com.unity3d.services.store.gpbl.bridges.billingclient.v6.BillingClientBridge;
import com.unity3d.services.store.gpbl.bridges.billingclient.v6.BillingClientBuilderBridge;
import com.unity3d.services.store.gpbl.bridges.billingclient.v8.QueryProductDetailsResultsBridge;
import kotlin.jvm.internal.k;
import q5.j;
import r2.q;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class BillingClientAdapterFactory {
    private final BillingClientAdapter createV6Adapter(Context context, int i2) {
        Object objM;
        try {
            BillingClientBuilderBridge builder = BillingClientBridge.newBuilder(context);
            k.d(builder, "builder");
            objM = new com.unity3d.services.store.gpbl.bridges.billingclient.v6.BillingClientAdapter(builder, i2);
        } catch (Throwable th) {
            objM = q.M(th);
        }
        if (objM instanceof j) {
            objM = null;
        }
        return (BillingClientAdapter) objM;
    }

    public static /* synthetic */ BillingClientAdapter createV6Adapter$default(BillingClientAdapterFactory billingClientAdapterFactory, Context context, int i2, int i8, Object obj) {
        if ((i8 & 2) != 0) {
            i2 = 6;
        }
        return billingClientAdapterFactory.createV6Adapter(context, i2);
    }

    /* JADX INFO: renamed from: createV8Adapter-IoAF18A, reason: not valid java name */
    private final Object m3240createV8AdapterIoAF18A(Context context) {
        try {
            com.unity3d.services.store.gpbl.bridges.billingclient.v8.BillingClientAdapter billingClientAdapter = new com.unity3d.services.store.gpbl.bridges.billingclient.v8.BillingClientAdapter(com.unity3d.services.store.gpbl.bridges.billingclient.v8.BillingClientBridge.Companion.newBuilder(context));
            if (new QueryProductDetailsResultsBridge(new Object()).exists()) {
                return billingClientAdapter;
            }
            throw new FallbackException(7);
        } catch (Throwable th) {
            return q.M(th);
        }
    }

    public final BillingClientAdapter createBillingClientAdapter(Context context) {
        k.e(context, "context");
        Object objM3240createV8AdapterIoAF18A = m3240createV8AdapterIoAF18A(context);
        Throwable thA = q5.k.a(objM3240createV8AdapterIoAF18A);
        if (thA != null) {
            objM3240createV8AdapterIoAF18A = thA instanceof FallbackException ? createV6Adapter(context, ((FallbackException) thA).getDetectedVersion()) : createV6Adapter$default(this, context, 0, 2, null);
        }
        return (BillingClientAdapter) objM3240createV8AdapterIoAF18A;
    }
}
