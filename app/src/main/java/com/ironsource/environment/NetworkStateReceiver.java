package com.ironsource.environment;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.ironsource.C2531r4;
import com.ironsource.Dc;
import com.ironsource.environment.thread.IronSourceThreadManager;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class NetworkStateReceiver extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ConnectivityManager f8486a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Dc f8487b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f8488c = false;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            NetworkStateReceiver networkStateReceiver = NetworkStateReceiver.this;
            Dc dc = networkStateReceiver.f8487b;
            if (dc != null) {
                dc.a(networkStateReceiver.f8488c);
            }
        }
    }

    public NetworkStateReceiver(Context context, Dc dc) {
        this.f8487b = dc;
        if (context != null) {
            this.f8486a = (ConnectivityManager) context.getSystemService("connectivity");
        }
        a();
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent == null || intent.getExtras() == null || !a()) {
            return;
        }
        b();
    }

    private boolean a() {
        boolean z2 = this.f8488c;
        ConnectivityManager connectivityManager = this.f8486a;
        if (connectivityManager != null) {
            try {
                NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                this.f8488c = activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting();
            } catch (Exception e) {
                C2531r4.d().a(e);
                this.f8488c = false;
            }
        } else {
            this.f8488c = false;
        }
        return z2 != this.f8488c;
    }

    private void b() {
        IronSourceThreadManager.INSTANCE.postMediationBackgroundTask(new a());
    }
}
