package com.ironsource;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.LinkProperties;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkRequest;
import android.os.Build;
import android.util.Log;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.ironsource.jc, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class C2397jc implements InterfaceC2602v7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f8792a = "jc";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f8793b = 23;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final InterfaceC2619w7 f8794c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private ConnectivityManager.NetworkCallback f8795d;

    /* JADX INFO: renamed from: com.ironsource.jc$a */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class a extends ConnectivityManager.NetworkCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f8796a;

        public a(Context context) {
            this.f8796a = context;
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onAvailable(Network network) {
            if (network != null) {
                C2397jc.this.f8794c.a(C2246b4.a(network, this.f8796a), C2246b4.a(this.f8796a, network));
                return;
            }
            InterfaceC2619w7 interfaceC2619w7 = C2397jc.this.f8794c;
            String strB = C2246b4.b(this.f8796a);
            Context context = this.f8796a;
            interfaceC2619w7.a(strB, C2246b4.a(context, C2246b4.a(context)));
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
            if (network != null) {
                C2397jc.this.f8794c.b(C2246b4.a(network, this.f8796a), C2246b4.a(this.f8796a, network));
            }
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLinkPropertiesChanged(Network network, LinkProperties linkProperties) {
            if (network != null) {
                C2397jc.this.f8794c.b(C2246b4.a(network, this.f8796a), C2246b4.a(this.f8796a, network));
            }
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLost(Network network) {
            if (C2246b4.b(this.f8796a).equals("none")) {
                C2397jc.this.f8794c.a();
            }
        }
    }

    public C2397jc(InterfaceC2619w7 interfaceC2619w7) {
        this.f8794c = interfaceC2619w7;
    }

    @Override // com.ironsource.InterfaceC2602v7
    public void b(Context context) {
        if (Build.VERSION.SDK_INT >= this.f8793b) {
            a(context);
            if (C2246b4.b(context).equals("none")) {
                this.f8794c.a();
            }
            if (this.f8795d == null) {
                this.f8795d = new a(context);
            }
            NetworkRequest networkRequestBuild = new NetworkRequest.Builder().addCapability(12).build();
            try {
                ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                if (connectivityManager != null) {
                    connectivityManager.registerNetworkCallback(networkRequestBuild, this.f8795d);
                }
            } catch (Exception e) {
                C2531r4.d().a(e);
                Log.e(this.f8792a, "NetworkCallback was not able to register");
            }
        }
    }

    @Override // com.ironsource.InterfaceC2602v7
    public JSONObject c(Context context) {
        return C2246b4.a(context, C2246b4.a(context));
    }

    @Override // com.ironsource.InterfaceC2602v7
    public void a(Context context) {
        ConnectivityManager connectivityManager;
        if (Build.VERSION.SDK_INT < this.f8793b || this.f8795d == null || context == null || (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) == null) {
            return;
        }
        try {
            connectivityManager.unregisterNetworkCallback(this.f8795d);
        } catch (Exception e) {
            C2531r4.d().a(e);
            Log.e(this.f8792a, "NetworkCallback for was not registered or already unregistered");
        }
    }

    @Override // com.ironsource.InterfaceC2602v7
    public void a() {
        this.f8795d = null;
    }
}
