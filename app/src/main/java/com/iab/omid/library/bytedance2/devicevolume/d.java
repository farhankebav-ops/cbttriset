package com.iab.omid.library.bytedance2.devicevolume;

import android.content.Context;
import android.database.ContentObserver;
import android.media.AudioManager;
import android.os.Handler;
import android.provider.Settings;
import com.unity3d.services.core.device.MimeTypes;

/* JADX INFO: loaded from: classes3.dex */
public final class d extends ContentObserver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f5863a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final AudioManager f5864b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final a f5865c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final c f5866d;
    private float e;

    public d(Handler handler, Context context, a aVar, c cVar) {
        super(handler);
        this.f5863a = context;
        this.f5864b = (AudioManager) context.getSystemService(MimeTypes.BASE_TYPE_AUDIO);
        this.f5865c = aVar;
        this.f5866d = cVar;
    }

    private float a() {
        return this.f5865c.a(this.f5864b.getStreamVolume(3), this.f5864b.getStreamMaxVolume(3));
    }

    private void b() {
        this.f5866d.a(this.e);
    }

    public void c() {
        this.e = a();
        b();
        this.f5863a.getContentResolver().registerContentObserver(Settings.System.CONTENT_URI, true, this);
    }

    public void d() {
        this.f5863a.getContentResolver().unregisterContentObserver(this);
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
