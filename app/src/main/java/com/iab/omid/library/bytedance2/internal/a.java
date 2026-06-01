package com.iab.omid.library.bytedance2.internal;

import android.content.Context;
import androidx.annotation.NonNull;
import com.iab.omid.library.bytedance2.internal.d;
import java.util.Date;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public class a implements d.a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static a f5867f = new a(new d());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected com.iab.omid.library.bytedance2.utils.f f5868a = new com.iab.omid.library.bytedance2.utils.f();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Date f5869b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f5870c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private d f5871d;
    private boolean e;

    private a(d dVar) {
        this.f5871d = dVar;
    }

    public static a a() {
        return f5867f;
    }

    private void c() {
        if (!this.f5870c || this.f5869b == null) {
            return;
        }
        Iterator<com.iab.omid.library.bytedance2.adsession.a> it = c.c().a().iterator();
        while (it.hasNext()) {
            it.next().getAdSessionStatePublisher().a(b());
        }
    }

    public Date b() {
        Date date = this.f5869b;
        if (date != null) {
            return (Date) date.clone();
        }
        return null;
    }

    public void d() {
        Date dateA = this.f5868a.a();
        Date date = this.f5869b;
        if (date == null || dateA.after(date)) {
            this.f5869b = dateA;
            c();
        }
    }

    public void a(@NonNull Context context) {
        if (this.f5870c) {
            return;
        }
        this.f5871d.a(context);
        this.f5871d.a(this);
        this.f5871d.e();
        this.e = this.f5871d.c();
        this.f5870c = true;
    }

    @Override // com.iab.omid.library.bytedance2.internal.d.a
    public void a(boolean z2) {
        if (!this.e && z2) {
            d();
        }
        this.e = z2;
    }
}
