package com.bytedance.sdk.openadsdk.activity;

import android.app.Activity;
import android.os.Build;
import com.bytedance.sdk.component.utils.oeT;
import java.lang.reflect.Field;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class TTBaseActivity extends Activity {
    protected boolean Bc = false;

    public void MY(boolean z2) {
        this.Bc = z2;
    }

    @Override // android.app.Activity
    public void finish() {
        try {
            super.finish();
        } catch (Exception unused) {
        }
    }

    @Override // android.app.Activity
    public void onPause() {
        if (Build.VERSION.SDK_INT < 33) {
            super.onPause();
            return;
        }
        try {
            try {
                super.onPause();
            } catch (IllegalArgumentException unused) {
                Field declaredField = Activity.class.getDeclaredField("mCalled");
                declaredField.setAccessible(true);
                declaredField.set(this, Boolean.TRUE);
            }
        } catch (Exception unused2) {
        }
    }

    @Override // android.app.Activity
    public void onResume() {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 > 28 || i2 < 24) {
            super.onResume();
            return;
        }
        try {
            super.onResume();
        } catch (IllegalArgumentException e) {
            oeT.IlO("TTBaseActivity", "super.onResume() run fail", e);
            try {
                Field declaredField = Activity.class.getDeclaredField("mCalled");
                declaredField.setAccessible(true);
                declaredField.set(this, Boolean.TRUE);
            } catch (Exception e4) {
                oeT.IlO("TTBaseActivity", "onResume set mCalled fail", e4);
            }
        }
    }
}
