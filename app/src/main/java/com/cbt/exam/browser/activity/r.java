package com.cbt.exam.browser.activity;

import android.content.SharedPreferences;
import android.view.KeyEvent;
import android.widget.CompoundButton;
import android.widget.EditText;
import com.google.android.material.chip.Chip;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class r implements CompoundButton.OnCheckedChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5193a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ KeyEvent.Callback f5194b;

    public /* synthetic */ r(KeyEvent.Callback callback, int i2) {
        this.f5193a = i2;
        this.f5194b = callback;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public final void onCheckedChanged(CompoundButton compoundButton, boolean z2) {
        int i2 = this.f5193a;
        KeyEvent.Callback callback = this.f5194b;
        switch (i2) {
            case 0:
                SharedPreferences.Editor editor = (SharedPreferences.Editor) ((ActivityCreateConfig) callback).A.f3264c;
                editor.putBoolean("lastconfig", z2);
                editor.apply();
                break;
            case 1:
                EditText editText = (EditText) callback;
                int i8 = ActivityCreateConfig.B;
                if (!z2) {
                    editText.setVisibility(8);
                    editText.setText("");
                } else {
                    editText.setVisibility(0);
                }
                break;
            case 2:
                SharedPreferences.Editor editor2 = (SharedPreferences.Editor) ((MainActivity) callback).f5154q.f3264c;
                editor2.putBoolean("useragent", z2);
                editor2.apply();
                break;
            default:
                CompoundButton.OnCheckedChangeListener onCheckedChangeListener = ((Chip) callback).e;
                if (onCheckedChangeListener != null) {
                    onCheckedChangeListener.onCheckedChanged(compoundButton, z2);
                }
                break;
        }
    }
}
