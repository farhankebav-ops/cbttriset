package com.cbt.exam.browser.activity;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.text.Editable;
import android.view.View;
import android.widget.Toast;
import com.cbt.exam.browser.R;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class p implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5186a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ TextInputEditText f5187b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ TextInputLayout f5188c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Dialog f5189d;
    public final /* synthetic */ BaseActivity e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ Object f5190f;

    public /* synthetic */ p(BaseActivity baseActivity, TextInputEditText textInputEditText, TextInputLayout textInputLayout, Object obj, Dialog dialog, int i2) {
        this.f5186a = i2;
        this.e = baseActivity;
        this.f5187b = textInputEditText;
        this.f5188c = textInputLayout;
        this.f5190f = obj;
        this.f5189d = dialog;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i2 = this.f5186a;
        Dialog dialog = this.f5189d;
        Object obj = this.f5190f;
        TextInputLayout textInputLayout = this.f5188c;
        TextInputEditText textInputEditText = this.f5187b;
        BaseActivity baseActivity = this.e;
        switch (i2) {
            case 0:
                ActivityConfigConfirm activityConfigConfirm = (ActivityConfigConfirm) baseActivity;
                String str = (String) obj;
                int i8 = ActivityConfigConfirm.f5077s;
                activityConfigConfirm.getClass();
                Editable text = textInputEditText.getText();
                Objects.requireNonNull(text);
                if (!text.toString().trim().isEmpty()) {
                    textInputLayout.setErrorEnabled(false);
                    if (textInputEditText.getText().toString().trim().equals(str)) {
                        Toast.makeText(activityConfigConfirm, activityConfigConfirm.getString(R.string.txt_token_toast1), 1).show();
                        activityConfigConfirm.s();
                    } else {
                        textInputLayout.setError(activityConfigConfirm.getString(R.string.txt_token_toast2));
                        Toast.makeText(activityConfigConfirm, activityConfigConfirm.getString(R.string.txt_token_toast2), 0).show();
                    }
                    dialog.dismiss();
                } else {
                    textInputLayout.setError(activityConfigConfirm.getString(R.string.txt_token_warn));
                }
                break;
            default:
                MainActivity mainActivity = (MainActivity) baseActivity;
                SharedPreferences sharedPreferences = (SharedPreferences) obj;
                int i9 = MainActivity.f5146s;
                mainActivity.getClass();
                Editable text2 = textInputEditText.getText();
                Objects.requireNonNull(text2);
                String strTrim = text2.toString().trim();
                if (!strTrim.isEmpty()) {
                    textInputLayout.setErrorEnabled(false);
                    sharedPreferences.edit().putString("autoSave", strTrim).apply();
                    dialog.dismiss();
                    Intent intent = new Intent(mainActivity.getBaseContext(), (Class<?>) ExamQR.class);
                    intent.putExtra("url", strTrim);
                    intent.putExtra("timer", 0);
                    intent.putExtra("timerstat", 0);
                    intent.putExtra("useragent", "0");
                    intent.putExtra("from", "main_activity");
                    mainActivity.startActivity(intent);
                    mainActivity.overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                } else {
                    textInputLayout.setError(mainActivity.getString(R.string.txt_inputurl_err_msg));
                }
                break;
        }
    }
}
