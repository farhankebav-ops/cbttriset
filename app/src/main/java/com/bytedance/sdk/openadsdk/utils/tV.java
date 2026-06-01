package com.bytedance.sdk.openadsdk.utils;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class tV {

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class IlO implements View.OnLayoutChangeListener {
        private int EO;
        private final Drawable IlO;
        private int MY;

        public IlO(Drawable drawable) {
            this.IlO = drawable;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i2, int i8, int i9, int i10, int i11, int i12, int i13, int i14) {
            int i15 = i9 - i2;
            int i16 = i10 - i8;
            if (i15 == this.MY && i16 == this.EO) {
                return;
            }
            this.MY = i15;
            this.EO = i16;
            this.IlO.setBounds(0, 0, i15, i16);
        }
    }

    public static void IlO(ViewGroup viewGroup, com.bytedance.sdk.openadsdk.core.model.oeT oet) {
        if (viewGroup == null || oet == null || TextUtils.isEmpty(oet.kw())) {
            return;
        }
        try {
            int i2 = zPa.EeJ;
            if (viewGroup.getTag(i2) != null) {
                return;
            }
            viewGroup.setTag(i2, Integer.valueOf(i2));
            Drawable drawableIlO = IlO(viewGroup.getResources(), oet);
            if (drawableIlO == null) {
                return;
            }
            viewGroup.setForeground(drawableIlO);
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.oeT.EO("add overlay fail", th.getMessage());
        }
    }

    public static void IlO(Activity activity, com.bytedance.sdk.openadsdk.core.model.oeT oet) {
        if (activity == null || oet == null || TextUtils.isEmpty(oet.kw())) {
            return;
        }
        try {
            View decorView = activity.getWindow().getDecorView();
            int i2 = zPa.EeJ;
            if (decorView.getTag(i2) != null) {
                return;
            }
            activity.getWindow().getDecorView().setTag(i2, Integer.valueOf(i2));
            Drawable drawableIlO = IlO(activity.getResources(), oet);
            if (drawableIlO == null) {
                return;
            }
            activity.getWindow().getDecorView().setForeground(drawableIlO);
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.oeT.EO("add overlay fail", th.getMessage());
        }
    }

    @Nullable
    private static Drawable IlO(Resources resources, com.bytedance.sdk.openadsdk.core.model.oeT oet) {
        try {
            String strKw = oet.kw();
            if (TextUtils.isEmpty(strKw)) {
                return null;
            }
            byte[] bArrDecode = Base64.decode(strKw, 0);
            BitmapDrawable bitmapDrawable = new BitmapDrawable(resources, BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length));
            Shader.TileMode tileMode = Shader.TileMode.REPEAT;
            bitmapDrawable.setTileModeXY(tileMode, tileMode);
            bitmapDrawable.setTargetDensity(resources.getDisplayMetrics());
            return bitmapDrawable;
        } catch (Throwable unused) {
            return null;
        }
    }
}
