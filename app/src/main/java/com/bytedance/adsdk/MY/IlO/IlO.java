package com.bytedance.adsdk.MY.IlO;

import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.os.Build;
import android.os.LocaleList;
import androidx.core.view.ViewCompat;
import com.bytedance.adsdk.MY.vCE.Cc;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class IlO extends Paint {
    public IlO() {
    }

    @Override // android.graphics.Paint
    public void setAlpha(int i2) {
        if (Build.VERSION.SDK_INT >= 29) {
            super.setAlpha(Cc.IlO(i2, 0, 255));
        } else {
            setColor((Cc.IlO(i2, 0, 255) << 24) | (getColor() & ViewCompat.MEASURED_SIZE_MASK));
        }
    }

    public IlO(int i2) {
        super(i2);
    }

    public IlO(PorterDuff.Mode mode) {
        setXfermode(new PorterDuffXfermode(mode));
    }

    public IlO(int i2, PorterDuff.Mode mode) {
        super(i2);
        setXfermode(new PorterDuffXfermode(mode));
    }

    @Override // android.graphics.Paint
    public void setTextLocales(LocaleList localeList) {
    }
}
