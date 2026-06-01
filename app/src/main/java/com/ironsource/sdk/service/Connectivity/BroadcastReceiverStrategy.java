package com.ironsource.sdk.service.Connectivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;
import com.ironsource.C2246b4;
import com.ironsource.C2531r4;
import com.ironsource.InterfaceC2602v7;
import com.ironsource.InterfaceC2619w7;
import com.ironsource.mediationsdk.logger.IronLog;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class BroadcastReceiverStrategy implements InterfaceC2602v7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final InterfaceC2619w7 f10207a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private BroadcastReceiver f10208b = new BroadcastReceiver() { // from class: com.ironsource.sdk.service.Connectivity.BroadcastReceiverStrategy.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String strB = C2246b4.b(context);
            if (strB.equals("none")) {
                BroadcastReceiverStrategy.this.f10207a.a();
            } else {
                BroadcastReceiverStrategy.this.f10207a.a(strB, new JSONObject());
            }
        }
    };

    public BroadcastReceiverStrategy(InterfaceC2619w7 interfaceC2619w7) {
        this.f10207a = interfaceC2619w7;
    }

    @Override // com.ironsource.InterfaceC2602v7
    public void b(Context context) {
        try {
            context.registerReceiver(this.f10208b, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        } catch (Exception e) {
            C2531r4.d().a(e);
            IronLog.INTERNAL.error(e.toString());
        }
    }

    @Override // com.ironsource.InterfaceC2602v7
    public JSONObject c(Context context) {
        return new JSONObject();
    }

    @Override // com.ironsource.InterfaceC2602v7
    public void a(Context context) {
        try {
            context.unregisterReceiver(this.f10208b);
        } catch (IllegalArgumentException e) {
            C2531r4.d().a(e);
        } catch (Exception e4) {
            C2531r4.d().a(e4);
            Log.e("ContentValues", "unregisterConnectionReceiver - " + e4);
        }
    }

    @Override // com.ironsource.InterfaceC2602v7
    public void a() {
        this.f10208b = null;
    }
}
