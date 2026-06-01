package com.vungle.ads.internal.util;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.webkit.WebView;
import com.vungle.ads.internal.presenter.WebViewManager;
import kotlin.jvm.internal.k;
import q5.i;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class ViewUtility {
    public static final ViewUtility INSTANCE = new ViewUtility();

    private ViewUtility() {
    }

    public final int dpToPixels(Context context, int i2) {
        k.e(context, "context");
        return (int) ((i2 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public final i getDeviceWidthAndHeightWithOrientation(Context context, int i2) {
        k.e(context, "context");
        Resources resources = context.getApplicationContext().getResources();
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        int i8 = resources.getConfiguration().orientation;
        if (i2 == 0) {
            i2 = i8;
        }
        return i2 == i8 ? new i(Integer.valueOf(Math.round(displayMetrics.widthPixels / displayMetrics.density)), Integer.valueOf(Math.round(displayMetrics.heightPixels / displayMetrics.density))) : new i(Integer.valueOf(Math.round(displayMetrics.heightPixels / displayMetrics.density)), Integer.valueOf(Math.round(displayMetrics.widthPixels / displayMetrics.density)));
    }

    public final WebView getWebView(Context context, String str) throws InstantiationException {
        k.e(context, "context");
        try {
            return WebViewManager.INSTANCE.getOrCreateWebView(context, str);
        } catch (Resources.NotFoundException e) {
            throw new InstantiationException("Cannot instantiate WebView due to Resources.NotFoundException: " + e + ".message");
        } catch (Exception e4) {
            throw new InstantiationException(e4.getMessage());
        }
    }
}
