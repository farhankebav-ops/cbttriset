package com.cbt.exam.browser.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.ProgressBar;
import com.cbt.exam.browser.R;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class h extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5172a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ BaseActivity f5173b;

    public /* synthetic */ h(BaseActivity baseActivity, int i2) {
        this.f5172a = i2;
        this.f5173b = baseActivity;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        int i2 = this.f5172a;
        BaseActivity baseActivity = this.f5173b;
        switch (i2) {
            case 0:
                ActivityCbtBrowser activityCbtBrowser = (ActivityCbtBrowser) baseActivity;
                ProgressBar progressBar = ActivityCbtBrowser.P;
                NetworkInfo activeNetworkInfo = ((ConnectivityManager) activityCbtBrowser.getSystemService("connectivity")).getActiveNetworkInfo();
                if (activeNetworkInfo == null) {
                    activityCbtBrowser.k.setImageResource(R.drawable.ic_baseline_cloud_off_24);
                    activityCbtBrowser.f5062c.setVisibility(0);
                    activityCbtBrowser.f5061b.setVisibility(4);
                } else {
                    int type = activeNetworkInfo.getType();
                    if (type == 0) {
                        activityCbtBrowser.k.setImageResource(R.drawable.ic_baseline_signal_cellular_alt_24);
                        activityCbtBrowser.f5062c.setVisibility(8);
                        activityCbtBrowser.f5063d.setVisibility(8);
                        activityCbtBrowser.f5061b.setVisibility(0);
                    } else if (type == 1) {
                        activityCbtBrowser.k.setImageResource(R.drawable.ic_baseline_wifi_24);
                        activityCbtBrowser.f5062c.setVisibility(8);
                        activityCbtBrowser.f5063d.setVisibility(8);
                        activityCbtBrowser.f5061b.setVisibility(0);
                    } else {
                        activityCbtBrowser.k.setImageResource(R.drawable.ic_baseline_cloud_off_24);
                        activityCbtBrowser.f5062c.setVisibility(0);
                        activityCbtBrowser.f5061b.setVisibility(4);
                    }
                }
                break;
            default:
                ExamQR examQR = (ExamQR) baseActivity;
                ProgressBar progressBar2 = ExamQR.B;
                NetworkInfo activeNetworkInfo2 = ((ConnectivityManager) examQR.getSystemService("connectivity")).getActiveNetworkInfo();
                if (activeNetworkInfo2 == null) {
                    examQR.p.setImageResource(R.drawable.ic_baseline_cloud_off_24);
                    examQR.f5131c.setVisibility(0);
                    examQR.f5130b.setVisibility(4);
                } else {
                    int type2 = activeNetworkInfo2.getType();
                    if (type2 == 0) {
                        examQR.p.setImageResource(R.drawable.ic_baseline_signal_cellular_alt_24);
                        examQR.f5131c.setVisibility(8);
                        examQR.f5132d.setVisibility(8);
                        examQR.f5130b.setVisibility(0);
                    } else if (type2 == 1) {
                        examQR.p.setImageResource(R.drawable.ic_baseline_wifi_24);
                        examQR.f5131c.setVisibility(8);
                        examQR.f5132d.setVisibility(8);
                        examQR.f5130b.setVisibility(0);
                    } else {
                        examQR.p.setImageResource(R.drawable.ic_baseline_cloud_off_24);
                        examQR.f5131c.setVisibility(0);
                        examQR.f5130b.setVisibility(4);
                    }
                }
                break;
        }
    }
}
