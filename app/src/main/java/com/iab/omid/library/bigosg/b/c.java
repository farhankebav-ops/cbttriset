package com.iab.omid.library.bigosg.b;

import android.view.View;
import androidx.annotation.Nullable;
import com.iab.omid.library.bigosg.adsession.FriendlyObstructionPurpose;

/* JADX INFO: loaded from: classes3.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.iab.omid.library.bigosg.e.a f5774a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f5775b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final FriendlyObstructionPurpose f5776c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f5777d;

    public c(View view, FriendlyObstructionPurpose friendlyObstructionPurpose, @Nullable String str) {
        this.f5774a = new com.iab.omid.library.bigosg.e.a(view);
        this.f5775b = view.getClass().getCanonicalName();
        this.f5776c = friendlyObstructionPurpose;
        this.f5777d = str;
    }

    public com.iab.omid.library.bigosg.e.a a() {
        return this.f5774a;
    }

    public String b() {
        return this.f5775b;
    }

    public FriendlyObstructionPurpose c() {
        return this.f5776c;
    }

    public String d() {
        return this.f5777d;
    }
}
