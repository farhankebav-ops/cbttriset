package com.ironsource;

import android.content.Context;
import com.ironsource.mediationsdk.utils.IronSourceUtils;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class Ie implements N8 {
    @Override // com.ironsource.N8
    public void a(Context context, String key, int i2) {
        kotlin.jvm.internal.k.e(context, "context");
        kotlin.jvm.internal.k.e(key, "key");
        IronSourceUtils.b(context, key, i2);
    }

    @Override // com.ironsource.N8
    public int b(Context context, String key, int i2) {
        kotlin.jvm.internal.k.e(context, "context");
        kotlin.jvm.internal.k.e(key, "key");
        return IronSourceUtils.a(context, key, i2);
    }

    @Override // com.ironsource.N8
    public void a(Context context, String key, long j) {
        kotlin.jvm.internal.k.e(context, "context");
        kotlin.jvm.internal.k.e(key, "key");
        IronSourceUtils.b(context, key, j);
    }

    @Override // com.ironsource.N8
    public long b(Context context, String key, long j) {
        kotlin.jvm.internal.k.e(context, "context");
        kotlin.jvm.internal.k.e(key, "key");
        return IronSourceUtils.a(context, key, j);
    }
}
