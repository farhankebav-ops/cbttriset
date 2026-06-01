package com.ironsource;

import com.ironsource.mediationsdk.logger.IronSourceError;
import java.util.Objects;

/* JADX INFO: renamed from: com.ironsource.f8, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class C2322f8 extends Throwable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final IronSourceError f8527a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2322f8(IronSourceError error) {
        super(error.getErrorMessage());
        kotlin.jvm.internal.k.e(error, "error");
        this.f8527a = error;
    }

    public final IronSourceError a() {
        return this.f8527a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !C2322f8.class.equals(obj.getClass())) {
            return false;
        }
        C2322f8 c2322f8 = (C2322f8) obj;
        if (this.f8527a.getErrorCode() != c2322f8.f8527a.getErrorCode()) {
            return false;
        }
        return kotlin.jvm.internal.k.a(this.f8527a.getErrorMessage(), c2322f8.f8527a.getErrorMessage());
    }

    public int hashCode() {
        return Objects.hash(Integer.valueOf(this.f8527a.getErrorCode()), this.f8527a.getErrorMessage());
    }
}
