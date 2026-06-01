package com.iab.omid.library.vungle.internal;

import android.content.Context;
import androidx.annotation.NonNull;
import com.iab.omid.library.vungle.internal.d;
import java.util.Date;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public class a implements d.a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static a f6182f = new a(new d());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected com.iab.omid.library.vungle.utils.f f6183a = new com.iab.omid.library.vungle.utils.f();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Date f6184b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f6185c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private d f6186d;
    private boolean e;

    private a(d dVar) {
        this.f6186d = dVar;
    }

    public static a a() {
        return f6182f;
    }

    private void c() {
        if (!this.f6185c || this.f6184b == null) {
            return;
        }
        Iterator<com.iab.omid.library.vungle.adsession.a> it = c.c().a().iterator();
        while (it.hasNext()) {
            it.next().d().a(b());
        }
    }

    public Date b() {
        Date date = this.f6184b;
        if (date != null) {
            return (Date) date.clone();
        }
        return null;
    }

    public void d() {
        Date dateA = this.f6183a.a();
        Date date = this.f6184b;
        if (date == null || dateA.after(date)) {
            this.f6184b = dateA;
            c();
        }
    }

    public void a(@NonNull Context context) {
        if (this.f6185c) {
            return;
        }
        this.f6186d.a(context);
        this.f6186d.a(this);
        this.f6186d.e();
        this.e = this.f6186d.c();
        this.f6185c = true;
    }

    @Override // com.iab.omid.library.vungle.internal.d.a
    public void a(boolean z2) {
        if (!this.e && z2) {
            d();
        }
        this.e = z2;
    }
}
