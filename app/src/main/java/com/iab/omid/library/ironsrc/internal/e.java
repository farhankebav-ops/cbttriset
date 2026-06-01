package com.iab.omid.library.ironsrc.internal;

import android.view.View;
import androidx.annotation.Nullable;
import com.iab.omid.library.ironsrc.adsession.FriendlyObstructionPurpose;

/* JADX INFO: loaded from: classes3.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.iab.omid.library.ironsrc.weakreference.a f5983a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f5984b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final FriendlyObstructionPurpose f5985c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f5986d;

    public e(View view, FriendlyObstructionPurpose friendlyObstructionPurpose, @Nullable String str) {
        this.f5983a = new com.iab.omid.library.ironsrc.weakreference.a(view);
        this.f5984b = view.getClass().getCanonicalName();
        this.f5985c = friendlyObstructionPurpose;
        this.f5986d = str;
    }

    public String a() {
        return this.f5986d;
    }

    public FriendlyObstructionPurpose b() {
        return this.f5985c;
    }

    public com.iab.omid.library.ironsrc.weakreference.a c() {
        return this.f5983a;
    }

    public String d() {
        return this.f5984b;
    }
}
