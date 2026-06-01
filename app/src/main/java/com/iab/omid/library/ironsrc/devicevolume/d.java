package com.iab.omid.library.ironsrc.devicevolume;

import android.content.Context;
import android.database.ContentObserver;
import android.media.AudioManager;
import android.os.Handler;
import android.provider.Settings;
import com.unity3d.services.core.device.MimeTypes;

/* JADX INFO: loaded from: classes3.dex */
public final class d extends ContentObserver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f5967a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final AudioManager f5968b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final a f5969c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final c f5970d;
    private float e;

    public d(Handler handler, Context context, a aVar, c cVar) {
        super(handler);
        this.f5967a = context;
        this.f5968b = (AudioManager) context.getSystemService(MimeTypes.BASE_TYPE_AUDIO);
        this.f5969c = aVar;
        this.f5970d = cVar;
    }

    private float a() {
        return this.f5969c.a(this.f5968b.getStreamVolume(3), this.f5968b.getStreamMaxVolume(3));
    }

    private void b() {
        this.f5970d.a(this.e);
    }

    public void c() {
        this.e = a();
        b();
        this.f5967a.getContentResolver().registerContentObserver(Settings.System.CONTENT_URI, true, this);
    }

    public void d() {
        this.f5967a.getContentResolver().unregisterContentObserver(this);
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
