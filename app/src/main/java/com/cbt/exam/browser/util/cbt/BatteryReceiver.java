package com.cbt.exam.browser.util.cbt;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.TextView;
import com.google.firebase.analytics.FirebaseAnalytics;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class BatteryReceiver extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextView f5208a;

    public BatteryReceiver(TextView textView) {
        this.f5208a = textView;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        this.f5208a.setText("" + ((intent.getIntExtra(FirebaseAnalytics.Param.LEVEL, 0) * 100) / intent.getIntExtra("scale", 100)) + "%");
    }
}
