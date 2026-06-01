package com.ironsource;

import com.ironsource.mediationsdk.logger.IronSourceError;

/* JADX INFO: renamed from: com.ironsource.pe, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class C2508pe extends IllegalArgumentException {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final IronSourceError f9672a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f9673b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2508pe(IronSourceError error) {
        super(error.getErrorMessage());
        kotlin.jvm.internal.k.e(error, "error");
        this.f9672a = error;
        this.f9673b = error.getErrorCode();
    }

    public final IronSourceError a() {
        return this.f9672a;
    }

    public final int b() {
        return this.f9673b;
    }
}
