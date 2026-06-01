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
public final class x extends CountDownTimer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5203a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ExamQR f5204b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ x(ExamQR examQR, long j, int i2) {
        super(j, 1000L);
        this.f5203a = i2;
        this.f5204b = examQR;
    }

    @Override // android.os.CountDownTimer
    public final void onFinish() {
        switch (this.f5203a) {
            case 0:
                ExamQR examQR = this.f5204b;
                examQR.h.setText(examQR.getResources().getString(R.string.txt_countdown_finish));
                examQR.h.setTextColor(examQR.getResources().getColor(R.color.red_700));
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(500L);
                alphaAnimation.setStartOffset(30L);
                alphaAnimation.setRepeatMode(2);
                alphaAnimation.setRepeatCount(-1);
                examQR.h.startAnimation(alphaAnimation);
                Dialog dialog = examQR.l;
                if (dialog != null && dialog.isShowing()) {
                    examQR.l.dismiss();
                }
                Dialog dialog2 = new Dialog(examQR);
                examQR.l = dialog2;
                dialog2.requestWindowFeature(1);
                examQR.l.setContentView(R.layout.dialog_timeisup);
                examQR.l.setCancelable(true);
                Window window = examQR.l.getWindow();
                Objects.requireNonNull(window);
                window.setBackgroundDrawable(new ColorDrawable(0));
                WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
                layoutParams.copyFrom(examQR.l.getWindow().getAttributes());
                layoutParams.width = -2;
                layoutParams.height = -2;
                examQR.l.findViewById(R.id.bt_exit).setOnClickListener(new i(examQR, 1));
                examQR.l.setCancelable(false);
                examQR.l.show();
                examQR.l.getWindow().setAttributes(layoutParams);
                break;
            default:
                ExamQR examQR2 = this.f5204b;
                examQR2.e.setVisibility(8);
                Toast.makeText(examQR2, R.string.txt_penalty_finish, 0).show();
                break;
        }
    }

    @Override // android.os.CountDownTimer
    public final void onTick(long j) {
        int i2 = this.f5203a;
        ExamQR examQR = this.f5204b;
        switch (i2) {
            case 0:
                TimeUnit timeUnit = TimeUnit.MILLISECONDS;
                String str = String.format("%02d:%02d:%02d", Long.valueOf(timeUnit.toHours(j) % 24), Long.valueOf(timeUnit.toMinutes(j) % 60), Long.valueOf(timeUnit.toSeconds(j) % 60));
                long j3 = j / 1000;
                if (j3 < 11) {
                    examQR.h.setText(j3 + " " + examQR.getResources().getString(R.string.txt_countdown_detik));
                    examQR.h.setTextColor(examQR.getResources().getColor(R.color.red_700));
                    AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                    alphaAnimation.setDuration(500L);
                    alphaAnimation.setStartOffset(30L);
                    alphaAnimation.setRepeatMode(2);
                    examQR.h.startAnimation(alphaAnimation);
                } else {
                    examQR.h.setText(str);
                }
                if (j3 == 600) {
                    Toast.makeText(examQR, "10 " + examQR.getResources().getString(R.string.txt_countdown_menit), 1).show();
                }
                if (j3 == 300) {
                    Toast.makeText(examQR, "5 " + examQR.getResources().getString(R.string.txt_countdown_menit), 1).show();
                }
                if (j3 == 60) {
                    Toast.makeText(examQR, "1 " + examQR.getResources().getString(R.string.txt_countdown_menit), 1).show();
                }
                if (j3 == 30) {
                    Toast.makeText(examQR, "30 " + examQR.getResources().getString(R.string.txt_countdown_detik), 1).show();
                }
                if (j3 == 20) {
                    Toast.makeText(examQR, "20 " + examQR.getResources().getString(R.string.txt_countdown_detik), 0).show();
                }
                break;
            default:
                ((TextView) examQR.findViewById(R.id.txt_penalty_countdown)).setText(String.format(Locale.getDefault(), "%02d:%02d:%02d", Long.valueOf((j / 3600000) % 24), Long.valueOf((j / RealWebSocket.CANCEL_AFTER_CLOSE_MILLIS) % 60), Long.valueOf((j / 1000) % 60)));
                break;
        }
    }
}
