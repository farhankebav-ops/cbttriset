package com.iab.omid.library.ironsrc.internal;

import android.content.Context;
import androidx.annotation.NonNull;
import com.iab.omid.library.ironsrc.internal.d;
import java.util.Date;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public class a implements d.a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static a f5971f = new a(new d());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected com.iab.omid.library.ironsrc.utils.f f5972a = new com.iab.omid.library.ironsrc.utils.f();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Date f5973b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f5974c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private d f5975d;
    private boolean e;

    private a(d dVar) {
        this.f5975d = dVar;
    }

    public static a a() {
        return f5971f;
    }

    private void c() {
        if (!this.f5974c || this.f5973b == null) {
            return;
        }
        Iterator<com.iab.omid.library.ironsrc.adsession.a> it = c.c().a().iterator();
        while (it.hasNext()) {
            it.next().getAdSessionStatePublisher().a(b());
        }
    }

    public Date b() {
        Date date = this.f5973b;
        if (date != null) {
            return (Date) date.clone();
        }
        return null;
    }

    public void d() {
        Date dateA = this.f5972a.a();
        Date date = this.f5973b;
        if (date == null || dateA.after(date)) {
            this.f5973b = dateA;
            c();
        }
    }

    public void a(@NonNull Context context) {
        if (this.f5974c) {
            return;
        }
        this.f5975d.a(context);
        this.f5975d.a(this);
        this.f5975d.e();
        this.e = this.f5975d.c();
        this.f5974c = true;
    }

    @Override // com.iab.omid.library.ironsrc.internal.d.a
    public void a(boolean z2) {
        if (!this.e && z2) {
            d();
        }
        this.e = z2;
    }
}
