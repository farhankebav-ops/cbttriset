package com.ironsource;

import com.ironsource.AbstractC2547s3;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class Jg<Smash extends AbstractC2547s3<?>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Kg<Smash> f7032a;

    public Jg(Kg<Smash> smashPicker) {
        kotlin.jvm.internal.k.e(smashPicker, "smashPicker");
        this.f7032a = smashPicker;
    }

    public final List<Smash> a() {
        return this.f7032a.c();
    }

    public final boolean b() {
        return this.f7032a.c().isEmpty() && this.f7032a.a().isEmpty();
    }

    public final boolean c() {
        return this.f7032a.d() == 0;
    }
}
