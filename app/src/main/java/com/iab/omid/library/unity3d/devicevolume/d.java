package com.iab.omid.library.unity3d.devicevolume;

import android.content.Context;
import android.database.ContentObserver;
import android.media.AudioManager;
import android.os.Handler;
import android.provider.Settings;
import com.unity3d.services.core.device.MimeTypes;

/* JADX INFO: loaded from: classes3.dex */
public final class d extends ContentObserver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f6076a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final AudioManager f6077b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final a f6078c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final c f6079d;
    private float e;

    public d(Handler handler, Context context, a aVar, c cVar) {
        super(handler);
        this.f6076a = context;
        this.f6077b = (AudioManager) context.getSystemService(MimeTypes.BASE_TYPE_AUDIO);
        this.f6078c = aVar;
        this.f6079d = cVar;
    }

    private float a() {
        return this.f6078c.a(this.f6077b.getStreamVolume(3), this.f6077b.getStreamMaxVolume(3));
    }

    private void b() {
        this.f6079d.a(this.e);
    }

    public void c() {
        this.e = a();
        b();
        this.f6076a.getContentResolver().registerContentObserver(Settings.System.CONTENT_URI, true, this);
    }

    public void d() {
        this.f6076a.getContentResolver().unregisterContentObserver(this);
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z2) {
        super.onChange(z2);
        float fA = a();
        if (a(fA)) {
            this.e = fA;
            b();
        }
    }

    private boolean a(float f4) {
        return f4 != this.e;
    }
}
