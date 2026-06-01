package com.iab.omid.library.vungle.internal;

import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import java.lang.ref.WeakReference;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public class j {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static j f6211d = new j();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private WeakReference<Context> f6212a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f6213b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f6214c = false;

    public class a extends BroadcastReceiver {
        public a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            j jVar;
            boolean z2;
            boolean z7;
            if (intent.getAction().equals("android.intent.action.SCREEN_OFF")) {
                jVar = j.this;
                z2 = jVar.f6214c;
                z7 = true;
            } else {
                if (!intent.getAction().equals("android.intent.action.SCREEN_ON")) {
                    return;
                }
                jVar = j.this;
                z2 = jVar.f6214c;
                z7 = false;
            }
            jVar.a(z7, z2);
            j.this.f6213b = z7;
        }
    }

    public static j b() {
        return f6211d;
    }

    public void a() {
        Context context = this.f6212a.get();
        if (context == null) {
            return;
        }
        boolean zIsDeviceLocked = ((KeyguardManager) context.getSystemService("keyguard")).isDeviceLocked();
        a(this.f6213b, zIsDeviceLocked);
        this.f6214c = zIsDeviceLocked;
    }

    public void a(Context context) {
        if (context == null) {
            return;
        }
        this.f6212a = new WeakReference<>(context);
        IntentFilter intentFilter = new IntentFilter("android.intent.action.SCREEN_OFF");
        intentFilter.addAction("android.intent.action.SCREEN_ON");
        context.registerReceiver(new a(), intentFilter);
    }

    public void a(boolean z2, boolean z7) {
        if ((z7 || z2) == (this.f6214c || this.f6213b)) {
            return;
        }
        Iterator<com.iab.omid.library.vungle.adsession.a> it = c.c().b().iterator();
        while (it.hasNext()) {
            it.next().d().b(z7 || z2);
        }
    }
}
