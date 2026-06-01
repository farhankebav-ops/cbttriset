package com.ironsource;

import android.content.Context;
import com.ironsource.mediationsdk.logger.IronLog;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class A4 implements S8, R8 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final A7 f6321a;

    public A4() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    @Override // com.ironsource.R8
    public void a(Context context, EnumC2667z4 source, String key, String value) {
        q5.x xVar;
        kotlin.jvm.internal.k.e(context, "context");
        kotlin.jvm.internal.k.e(source, "source");
        kotlin.jvm.internal.k.e(key, "key");
        kotlin.jvm.internal.k.e(value, "value");
        F4 f4A = this.f6321a.a(context, source);
        if (f4A != null) {
            f4A.b(key, value);
            xVar = q5.x.f13520a;
        } else {
            xVar = null;
        }
        if (xVar == null) {
            IronLog.INTERNAL.error("Shared storage does not exist for source: " + source);
        }
    }

    public A4(A7 sharedSignalsStorageFactory) {
        kotlin.jvm.internal.k.e(sharedSignalsStorageFactory, "sharedSignalsStorageFactory");
        this.f6321a = sharedSignalsStorageFactory;
    }

    @Override // com.ironsource.S8
    public String a(Context context, EnumC2667z4 source, String key) {
        kotlin.jvm.internal.k.e(context, "context");
        kotlin.jvm.internal.k.e(source, "source");
        kotlin.jvm.internal.k.e(key, "key");
        F4 f4A = this.f6321a.a(context, source);
        if (f4A != null) {
            return ih.a(f4A, key, null, 2, null);
        }
        IronLog.INTERNAL.error("Shared storage does not exist for source: " + source);
        return null;
    }

    public /* synthetic */ A4(A7 a72, int i2, kotlin.jvm.internal.f fVar) {
        this((i2 & 1) != 0 ? new D4() : a72);
    }
}
