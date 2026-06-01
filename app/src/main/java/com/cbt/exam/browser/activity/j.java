package com.cbt.exam.browser.activity;

import android.widget.Toast;
import androidx.activity.OnBackPressedCallback;
import com.cbt.exam.browser.R;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class j extends OnBackPressedCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5176a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ BaseActivity f5177b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ j(BaseActivity baseActivity, int i2) {
        super(true);
        this.f5176a = i2;
        this.f5177b = baseActivity;
    }

    @Override // androidx.activity.OnBackPressedCallback
    public final void handleOnBackPressed() {
        switch (this.f5176a) {
            case 0:
                ActivityCbtBrowser activityCbtBrowser = (ActivityCbtBrowser) this.f5177b;
                if (activityCbtBrowser.f5061b.canGoBack()) {
                    activityCbtBrowser.f5061b.goBack();
                }
                break;
            case 1:
                ActivityConfigConfirm activityConfigConfirm = (ActivityConfigConfirm) this.f5177b;
                activityConfigConfirm.f5124a.g();
                activityConfigConfirm.finish();
                activityConfigConfirm.overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
                break;
            case 2:
                ActivityCreateConfig activityCreateConfig = (ActivityCreateConfig) this.f5177b;
                activityCreateConfig.f5124a.g();
                activityCreateConfig.finish();
                activityCreateConfig.overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
                break;
            case 3:
                ActivityGenerateConfig activityGenerateConfig = (ActivityGenerateConfig) this.f5177b;
                activityGenerateConfig.f5124a.g();
                activityGenerateConfig.finish();
                activityGenerateConfig.overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
                break;
            case 4:
                ActivityScanner activityScanner = (ActivityScanner) this.f5177b;
                activityScanner.finish();
                activityScanner.overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
                break;
            case 5:
                ConfirmActivity confirmActivity = (ConfirmActivity) this.f5177b;
                confirmActivity.finish();
                confirmActivity.overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
                break;
            case 6:
                ExamQR examQR = (ExamQR) this.f5177b;
                if (examQR.f5130b.canGoBack()) {
                    examQR.f5130b.goBack();
                }
                break;
            default:
                long jCurrentTimeMillis = System.currentTimeMillis();
                MainActivity mainActivity = (MainActivity) this.f5177b;
                if (jCurrentTimeMillis - mainActivity.f5147b <= 2000) {
                    mainActivity.finish();
                } else {
                    Toast.makeText(mainActivity, mainActivity.getString(R.string.press_again_to_exit), 1).show();
                    mainActivity.f5147b = System.currentTimeMillis();
                }
                break;
        }
    }
}
