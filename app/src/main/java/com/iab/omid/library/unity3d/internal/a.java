package com.iab.omid.library.unity3d.internal;

import android.content.Context;
import androidx.annotation.NonNull;
import com.iab.omid.library.unity3d.internal.d;
import java.util.Date;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public class a implements d.a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static a f6080f = new a(new d());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected com.iab.omid.library.unity3d.utils.f f6081a = new com.iab.omid.library.unity3d.utils.f();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Date f6082b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f6083c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private d f6084d;
    private boolean e;

    private a(d dVar) {
        this.f6084d = dVar;
    }

    public static a a() {
        return f6080f;
    }

    private void c() {
        if (!this.f6083c || this.f6082b == null) {
            return;
        }
        Iterator<com.iab.omid.library.unity3d.adsession.a> it = c.c().a().iterator();
        while (it.hasNext()) {
            it.next().getAdSessionStatePublisher().a(b());
        }
    }

    public Date b() {
        Date date = this.f6082b;
        if (date != null) {
            return (Date) date.clone();
        }
        return null;
    }

    public void d() {
        Date dateA = this.f6081a.a();
        Date date = this.f6082b;
        if (date == null || dateA.after(date)) {
            this.f6082b = dateA;
            c();
        }
    }

    public void a(@NonNull Context context) {
        if (this.f6083c) {
            return;
        }
        this.f6084d.a(context);
        this.f6084d.a(this);
        this.f6084d.e();
        this.e = this.f6084d.c();
        this.f6083c = true;
    }

    @Override // com.iab.omid.library.unity3d.internal.d.a
    public void a(boolean z2) {
        if (!this.e && z2) {
            d();
        }
        this.e = z2;
    }
}
