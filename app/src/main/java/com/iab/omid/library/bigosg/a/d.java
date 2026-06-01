package com.iab.omid.library.bigosg.a;

import android.content.Context;
import android.database.ContentObserver;
import android.media.AudioManager;
import android.os.Handler;
import android.provider.Settings;
import com.unity3d.services.core.device.MimeTypes;

/* JADX INFO: loaded from: classes3.dex */
public final class d extends ContentObserver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f5746a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final AudioManager f5747b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final a f5748c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final c f5749d;
    private float e;

    public d(Handler handler, Context context, a aVar, c cVar) {
        super(handler);
        this.f5746a = context;
        this.f5747b = (AudioManager) context.getSystemService(MimeTypes.BASE_TYPE_AUDIO);
        this.f5748c = aVar;
        this.f5749d = cVar;
    }

    private float c() {
        return this.f5748c.a(this.f5747b.getStreamVolume(3), this.f5747b.getStreamMaxVolume(3));
    }

    private void d() {
        this.f5749d.a(this.e);
    }

    public final void a() {
        this.e = c();
        d();
        this.f5746a.getContentResolver().registerContentObserver(Settings.System.CONTENT_URI, true, this);
    }

    public final void b() {
        this.f5746a.getContentResolver().unregisterContentObserver(this);
    }

    @Override // android.database.ContentObserver
    public final void onChange(boolean z2) {
        super.onChange(z2);
        float fC = c();
        if (a(fC)) {
            this.e = fC;
            d();
        }
    }

    private boolean a(float f4) {
        return f4 != this.e;
    }
}
