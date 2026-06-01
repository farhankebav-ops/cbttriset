package com.bytedance.sdk.openadsdk.core.lEW.IlO;

import android.content.Context;
import android.util.Pair;
import android.view.View;
import android.view.Window;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.utils.BS;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class IlO {
    @NonNull
    public static Pair<Float, Float> IlO(Window window, int i2) {
        View decorView = window.getDecorView();
        float[] fArrIlO = {decorView.getWidth() - (decorView.getPaddingLeft() * 2), decorView.getHeight() - (decorView.getPaddingTop() * 2)};
        fArrIlO[0] = BS.EO(window.getContext(), fArrIlO[0]);
        float fEO = BS.EO(window.getContext(), fArrIlO[1]);
        fArrIlO[1] = fEO;
        if (fArrIlO[0] < 10.0f || fEO < 10.0f) {
            fArrIlO = IlO(window.getContext(), BS.EO(window.getContext(), BS.IlO()), i2);
        }
        float fMax = Math.max(fArrIlO[0], fArrIlO[1]);
        float fMin = Math.min(fArrIlO[0], fArrIlO[1]);
        if (i2 == 1) {
            fArrIlO[0] = fMin;
            fArrIlO[1] = fMax;
        } else {
            fArrIlO[0] = fMax;
            fArrIlO[1] = fMin;
        }
        return new Pair<>(Float.valueOf(fArrIlO[0]), Float.valueOf(fArrIlO[1]));
    }

    public static float MY(Context context) {
        return BS.EO(context, BS.rp(context));
    }

    private static float[] IlO(Context context, int i2, int i8) {
        float fIlO = IlO(context);
        float fMY = MY(context);
        if ((i8 == 1) != (fIlO > fMY)) {
            float f4 = fIlO + fMY;
            fMY = f4 - fMY;
            fIlO = f4 - fMY;
        }
        if (i8 == 1) {
            fIlO -= i2;
        } else {
            fMY -= i2;
        }
        return new float[]{fMY, fIlO};
    }

    public static float IlO(Context context) {
        return BS.EO(context, BS.EV(context));
    }
}
