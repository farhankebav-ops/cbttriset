package com.iab.omid.library.ironsrc.internal;

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
    private static j f6000d = new j();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private WeakReference<Context> f6001a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f6002b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f6003c = false;

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
                z2 = jVar.f6003c;
                z7 = true;
            } else {
                if (!intent.getAction().equals("android.intent.action.SCREEN_ON")) {
                    return;
                }
                jVar = j.this;
                z2 = jVar.f6003c;
                z7 = false;
            }
            jVar.a(z7, z2);
            j.this.f6002b = z7;
        }
    }

    public static j b() {
        return f6000d;
    }

    public void a() {
        Context context = this.f6001a.get();
        if (context == null) {
            return;
        }
        boolean zIsDeviceLocked = ((KeyguardManager) context.getSystemService("keyguard")).isDeviceLocked();
        a(this.f6002b, zIsDeviceLocked);
        this.f6003c = zIsDeviceLocked;
    }

    public void a(Context context) {
        if (context == null) {
            return;
        }
        this.f6001a = new WeakReference<>(context);
        IntentFilter intentFilter = new IntentFilter("android.intent.action.SCREEN_OFF");
        intentFilter.addAction("android.intent.action.SCREEN_ON");
        context.registerReceiver(new a(), intentFilter);
    }

    public void a(boolean z2, boolean z7) {
        if ((z7 || z2) == (this.f6003c || this.f6002b)) {
            return;
        }
        Iterator<com.iab.omid.library.ironsrc.adsession.a> it = c.c().b().iterator();
        while (it.hasNext()) {
            it.next().getAdSessionStatePublisher().b(z7 || z2);
        }
    }
}
