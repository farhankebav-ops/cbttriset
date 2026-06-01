package com.iab.omid.library.vungle.internal;

import android.view.View;
import androidx.annotation.Nullable;
import com.iab.omid.library.vungle.adsession.FriendlyObstructionPurpose;

/* JADX INFO: loaded from: classes3.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.iab.omid.library.vungle.weakreference.a f6194a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f6195b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final FriendlyObstructionPurpose f6196c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f6197d;

    public e(View view, FriendlyObstructionPurpose friendlyObstructionPurpose, @Nullable String str) {
        this.f6194a = new com.iab.omid.library.vungle.weakreference.a(view);
        this.f6195b = view.getClass().getCanonicalName();
        this.f6196c = friendlyObstructionPurpose;
        this.f6197d = str;
    }

    public String a() {
        return this.f6197d;
    }

    public FriendlyObstructionPurpose b() {
        return this.f6196c;
    }

    public com.iab.omid.library.vungle.weakreference.a c() {
        return this.f6194a;
    }

    public String d() {
        return this.f6195b;
    }
}
