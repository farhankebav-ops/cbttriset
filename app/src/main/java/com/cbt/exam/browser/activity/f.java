package com.cbt.exam.browser.activity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ProgressBar;
import android.widget.Toast;
import androidx.core.app.NotificationCompat;
import com.cbt.exam.browser.R;
import com.mimikridev.utilmanager.toast.ToastUtil;
import java.util.Objects;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class f implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5167a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ BaseActivity f5168b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f5169c;

    public /* synthetic */ f(BaseActivity baseActivity, Object obj, int i2) {
        this.f5167a = i2;
        this.f5168b = baseActivity;
        this.f5169c = obj;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i2;
        int i8 = this.f5167a;
        Object obj = this.f5169c;
        BaseActivity baseActivity = this.f5168b;
        switch (i8) {
            case 0:
                ProgressBar progressBar = ActivityCbtBrowser.P;
                ((ActivityCbtBrowser) baseActivity).v();
                ((Dialog) obj).dismiss();
                break;
            case 1:
                ActivityGenerateConfig activityGenerateConfig = (ActivityGenerateConfig) baseActivity;
                Intent intent = (Intent) obj;
                int i9 = ActivityGenerateConfig.y;
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("url", intent.getStringExtra("url"));
                    jSONObject.put("nama_ujian", intent.getStringExtra("nama_ujian"));
                    jSONObject.put("nama_sekolah", intent.getStringExtra("nama_sekolah"));
                    jSONObject.put("logo", intent.getStringExtra("logo"));
                    jSONObject.put("custom_ua_status", intent.getBooleanExtra("customUA_on", false));
                    jSONObject.put("custom_ua", intent.getStringExtra("customUA_text"));
                    try {
                        String stringExtra = intent.getStringExtra("timer_value");
                        Objects.requireNonNull(stringExtra);
                        i2 = Integer.parseInt(stringExtra);
                    } catch (Exception unused) {
                        i2 = 0;
                    }
                    jSONObject.put("timer_status", intent.getBooleanExtra("timer_on", false));
                    jSONObject.put("timer", i2);
                    jSONObject.put("msg_status", intent.getBooleanExtra("message_on", false));
                    jSONObject.put(NotificationCompat.CATEGORY_MESSAGE, intent.getStringExtra("message_text"));
                    jSONObject.put("token_masuk_status", intent.getBooleanExtra("tokenMasuk_on", false));
                    jSONObject.put("token_masuk", intent.getStringExtra("tokenMasuk_text"));
                    jSONObject.put("token_keluar_status", intent.getBooleanExtra("tokenKeluar_on", false));
                    jSONObject.put("token_keluar", intent.getStringExtra("tokenKeluar_text"));
                    jSONObject.put("link_keluar_status", intent.getBooleanExtra("linkKeluar_on", false));
                    jSONObject.put("link_keluar", intent.getStringExtra("linkKeluar_text"));
                    jSONObject.put("allow_copy_paste", intent.getBooleanExtra("copyPaste_on", false));
                    jSONObject.put("allow_screenshoot", intent.getBooleanExtra("screenshoot_on", false));
                    jSONObject.put("clear_cache", intent.getBooleanExtra("clearCache_on", false));
                    activityGenerateConfig.f5115v = a.a.x(jSONObject);
                    String stringExtra2 = intent.getStringExtra("filename");
                    if (stringExtra2 == null || stringExtra2.isEmpty()) {
                        activityGenerateConfig.f5116w = "cbtconfig_" + System.currentTimeMillis() + ".cbt";
                    } else {
                        activityGenerateConfig.f5116w = stringExtra2 + "_" + System.currentTimeMillis() + ".cbt";
                    }
                    Intent intent2 = new Intent("android.intent.action.CREATE_DOCUMENT");
                    intent2.setType("application/octet-stream");
                    intent2.putExtra("android.intent.extra.TITLE", activityGenerateConfig.f5116w);
                    activityGenerateConfig.f5114u.launch(intent2);
                    activityGenerateConfig.overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                } catch (Exception e) {
                    e.printStackTrace();
                    Toast.makeText(activityGenerateConfig, "Error: " + e.getMessage(), 1).show();
                    ToastUtil.showError(activityGenerateConfig, "Error: " + e.getMessage());
                    return;
                }
                break;
            case 2:
                ProgressBar progressBar2 = ExamQR.B;
                ((ExamQR) baseActivity).v();
                ((Dialog) obj).dismiss();
                break;
            default:
                int i10 = MainActivity.f5146s;
                view.startAnimation(AnimationUtils.loadAnimation((MainActivity) baseActivity, android.R.anim.fade_out));
                new Handler(Looper.getMainLooper()).postDelayed(new a3.b((Dialog) obj, 18), 150L);
                break;
        }
    }
}
