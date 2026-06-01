package com.iab.omid.library.unity3d.internal;

import android.view.View;
import androidx.annotation.Nullable;
import com.iab.omid.library.unity3d.adsession.FriendlyObstructionPurpose;

/* JADX INFO: loaded from: classes3.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.iab.omid.library.unity3d.weakreference.a f6092a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f6093b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final FriendlyObstructionPurpose f6094c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f6095d;

    public e(View view, FriendlyObstructionPurpose friendlyObstructionPurpose, @Nullable String str) {
        this.f6092a = new com.iab.omid.library.unity3d.weakreference.a(view);
        this.f6093b = view.getClass().getCanonicalName();
        this.f6094c = friendlyObstructionPurpose;
        this.f6095d = str;
    }

    public String a() {
        return this.f6095d;
    }

    public FriendlyObstructionPurpose b() {
        return this.f6094c;
    }

    public com.iab.omid.library.unity3d.weakreference.a c() {
        return this.f6092a;
    }

    public String d() {
        return this.f6093b;
    }
}
