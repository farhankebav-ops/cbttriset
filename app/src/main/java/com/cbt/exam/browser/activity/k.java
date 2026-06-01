package com.cbt.exam.browser.activity;

import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.CountDownTimer;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.widget.TextView;
import android.widget.Toast;
import com.cbt.exam.browser.R;
import java.util.Locale;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import okhttp3.internal.ws.RealWebSocket;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class k extends CountDownTimer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5178a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ActivityCbtBrowser f5179b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ k(ActivityCbtBrowser activityCbtBrowser, long j, int i2) {
        super(j, 1000L);
        this.f5178a = i2;
        this.f5179b = activityCbtBrowser;
    }

    @Override // android.os.CountDownTimer
    public final void onFinish() {
        switch (this.f5178a) {
            case 0:
                ActivityCbtBrowser activityCbtBrowser = this.f5179b;
                activityCbtBrowser.f5065i.setText(activityCbtBrowser.getResources().getString(R.string.txt_countdown_finish));
                activityCbtBrowser.f5065i.setTextColor(activityCbtBrowser.getResources().getColor(R.color.red_700));
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(500L);
                alphaAnimation.setStartOffset(30L);
                alphaAnimation.setRepeatMode(2);
                alphaAnimation.setRepeatCount(-1);
                activityCbtBrowser.f5065i.startAnimation(alphaAnimation);
                Dialog dialog = activityCbtBrowser.N;
                if (dialog != null && dialog.isShowing()) {
                    activityCbtBrowser.N.dismiss();
                }
                Dialog dialog2 = new Dialog(activityCbtBrowser);
                activityCbtBrowser.N = dialog2;
                dialog2.requestWindowFeature(1);
                activityCbtBrowser.N.setContentView(R.layout.dialog_timeisup);
                activityCbtBrowser.N.setCancelable(true);
                Window window = activityCbtBrowser.N.getWindow();
                Objects.requireNonNull(window);
                window.setBackgroundDrawable(new ColorDrawable(0));
                WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
                layoutParams.copyFrom(activityCbtBrowser.N.getWindow().getAttributes());
                layoutParams.width = -2;
                layoutParams.height = -2;
                activityCbtBrowser.N.findViewById(R.id.bt_exit).setOnClickListener(new i(activityCbtBrowser, 0));
                activityCbtBrowser.N.setCancelable(false);
                activityCbtBrowser.N.show();
                activityCbtBrowser.N.getWindow().setAttributes(layoutParams);
                break;
            default:
                ActivityCbtBrowser activityCbtBrowser2 = this.f5179b;
                activityCbtBrowser2.e.setVisibility(8);
                Toast.makeText(activityCbtBrowser2, R.string.txt_penalty_finish, 0).show();
                break;
        }
    }

    @Override // android.os.CountDownTimer
    public final void onTick(long j) {
        int i2 = this.f5178a;
        ActivityCbtBrowser activityCbtBrowser = this.f5179b;
        switch (i2) {
            case 0:
                TimeUnit timeUnit = TimeUnit.MILLISECONDS;
                String str = String.format("%02d:%02d:%02d", Long.valueOf(timeUnit.toHours(j) % 24), Long.valueOf(timeUnit.toMinutes(j) % 60), Long.valueOf(timeUnit.toSeconds(j) % 60));
                long j3 = j / 1000;
                if (j3 < 11) {
                    activityCbtBrowser.f5065i.setText(j3 + " " + activityCbtBrowser.getResources().getString(R.string.txt_countdown_detik));
                    activityCbtBrowser.f5065i.setTextColor(activityCbtBrowser.getResources().getColor(R.color.red_700));
                    AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                    alphaAnimation.setDuration(500L);
                    alphaAnimation.setStartOffset(30L);
                    alphaAnimation.setRepeatMode(2);
                    activityCbtBrowser.f5065i.startAnimation(alphaAnimation);
                } else {
                    activityCbtBrowser.f5065i.setText(str);
                }
                if (j3 == 600) {
                    Toast.makeText(activityCbtBrowser, "10 " + activityCbtBrowser.getResources().getString(R.string.txt_countdown_menit), 1).show();
                }
                if (j3 == 300) {
                    Toast.makeText(activityCbtBrowser, "5 " + activityCbtBrowser.getResources().getString(R.string.txt_countdown_menit), 1).show();
                }
                if (j3 == 60) {
                    Toast.makeText(activityCbtBrowser, "1 " + activityCbtBrowser.getResources().getString(R.string.txt_countdown_menit), 1).show();
                }
                if (j3 == 30) {
                    Toast.makeText(activityCbtBrowser, "30 " + activityCbtBrowser.getResources().getString(R.string.txt_countdown_detik), 1).show();
                }
                if (j3 == 20) {
                    Toast.makeText(activityCbtBrowser, "20 " + activityCbtBrowser.getResources().getString(R.string.txt_countdown_detik), 0).show();
                }
                break;
            default:
                ((TextView) activityCbtBrowser.findViewById(R.id.txt_penalty_countdown)).setText(String.format(Locale.getDefault(), "%02d:%02d:%02d", Long.valueOf((j / 3600000) % 24), Long.valueOf((j / RealWebSocket.CANCEL_AFTER_CLOSE_MILLIS) % 60), Long.valueOf((j / 1000) % 60)));
                break;
        }
    }
}
