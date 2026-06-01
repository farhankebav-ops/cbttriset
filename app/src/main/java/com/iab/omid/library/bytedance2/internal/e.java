package com.iab.omid.library.bytedance2.internal;

import android.view.View;
import androidx.annotation.Nullable;
import com.iab.omid.library.bytedance2.adsession.FriendlyObstructionPurpose;

/* JADX INFO: loaded from: classes3.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.iab.omid.library.bytedance2.weakreference.a f5879a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f5880b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final FriendlyObstructionPurpose f5881c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f5882d;

    public e(View view, FriendlyObstructionPurpose friendlyObstructionPurpose, @Nullable String str) {
        this.f5879a = new com.iab.omid.library.bytedance2.weakreference.a(view);
        this.f5880b = view.getClass().getCanonicalName();
        this.f5881c = friendlyObstructionPurpose;
        this.f5882d = str;
    }

    public String a() {
        return this.f5882d;
    }

    public FriendlyObstructionPurpose b() {
        return this.f5881c;
    }

    public com.iab.omid.library.bytedance2.weakreference.a c() {
        return this.f5879a;
    }

    public String d() {
        return this.f5880b;
    }
}
