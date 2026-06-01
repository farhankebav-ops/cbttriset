package com.ironsource;

import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.model.NetworkSettings;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class Hf {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f6947a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f6948b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f6949c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Boolean f6950d;

    public Hf(String str, boolean z2, Boolean bool, String str2) {
        this.f6947a = str2;
        this.f6948b = str;
        this.f6949c = z2;
        this.f6950d = bool;
    }

    public final String a() {
        return this.f6947a;
    }

    public final boolean b() {
        return kotlin.jvm.internal.k.a(this.f6950d, Boolean.TRUE);
    }

    public final boolean a(NetworkSettings networkSettings, IronSource.a adUnit) {
        kotlin.jvm.internal.k.e(networkSettings, "networkSettings");
        kotlin.jvm.internal.k.e(adUnit, "adUnit");
        String str = this.f6948b;
        if (str == null || str.length() == 0) {
            return true;
        }
        Kf kf = Kf.f7064a;
        return kotlin.jvm.internal.k.a(kf.a(networkSettings), this.f6948b) && kf.a(networkSettings, adUnit) == this.f6949c;
    }

    public /* synthetic */ Hf(String str, boolean z2, Boolean bool, String str2, int i2, kotlin.jvm.internal.f fVar) {
        this(str, z2, (i2 & 4) != 0 ? Boolean.FALSE : bool, (i2 & 8) != 0 ? null : str2);
    }
}
