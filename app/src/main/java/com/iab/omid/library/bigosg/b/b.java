package com.iab.omid.library.bigosg.b;

import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.annotation.NonNull;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static b f5768a = new b();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Context f5769b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private BroadcastReceiver f5770c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f5771d;
    private boolean e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private a f5772f;

    public interface a {
        void a(boolean z2);
    }

    private b() {
    }

    public static b a() {
        return f5768a;
    }

    private void e() {
        this.f5770c = new BroadcastReceiver() { // from class: com.iab.omid.library.bigosg.b.b.1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                KeyguardManager keyguardManager;
                if (intent == null) {
                    return;
                }
                if ("android.intent.action.SCREEN_OFF".equals(intent.getAction())) {
                    b.this.a(true);
                    return;
                }
                if ("android.intent.action.USER_PRESENT".equals(intent.getAction())) {
                    b.this.a(false);
                } else {
                    if (!"android.intent.action.SCREEN_ON".equals(intent.getAction()) || (keyguardManager = (KeyguardManager) context.getSystemService("keyguard")) == null || keyguardManager.inKeyguardRestrictedInputMode()) {
                        return;
                    }
                    b.this.a(false);
                }
            }
        };
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        intentFilter.addAction("android.intent.action.SCREEN_ON");
        intentFilter.addAction("android.intent.action.USER_PRESENT");
        this.f5769b.registerReceiver(this.f5770c, intentFilter);
    }

    private void f() {
        BroadcastReceiver broadcastReceiver;
        Context context = this.f5769b;
        if (context == null || (broadcastReceiver = this.f5770c) == null) {
            return;
        }
        context.unregisterReceiver(broadcastReceiver);
        this.f5770c = null;
    }

    private void g() {
        boolean z2 = !this.e;
        Iterator<com.iab.omid.library.bigosg.adsession.a> it = com.iab.omid.library.bigosg.b.a.a().b().iterator();
        while (it.hasNext()) {
            it.next().getAdSessionStatePublisher().a(z2);
        }
    }

    public void b() {
        e();
        this.f5771d = true;
        g();
    }

    public void c() {
        f();
        this.f5771d = false;
        this.e = false;
        this.f5772f = null;
    }

    public boolean d() {
        return !this.e;
    }

    public void a(@NonNull Context context) {
        this.f5769b = context.getApplicationContext();
    }

    public void a(a aVar) {
        this.f5772f = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z2) {
        if (this.e != z2) {
            this.e = z2;
            if (this.f5771d) {
                g();
                a aVar = this.f5772f;
                if (aVar != null) {
                    aVar.a(d());
                }
            }
        }
    }
}
