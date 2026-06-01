package com.vungle.ads.internal.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.util.Base64;
import android.widget.ImageView;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class WatermarkView extends ImageView {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WatermarkView(Context context, String watermark) {
        super(context);
        k.e(context, "context");
        k.e(watermark, "watermark");
        byte[] overlayBytes = Base64.decode(watermark, 0);
        k.d(overlayBytes, "overlayBytes");
        Bitmap overlayBm = BitmapFactory.decodeByteArray(overlayBytes, 0, overlayBytes.length);
        k.d(overlayBm, "overlayBm");
        Resources resources = context.getResources();
        k.d(resources, "context.resources");
        BitmapDrawable bitmapDrawable = new BitmapDrawable(resources, overlayBm);
        Shader.TileMode tileMode = Shader.TileMode.REPEAT;
        bitmapDrawable.setTileModeXY(tileMode, tileMode);
        bitmapDrawable.setTargetDensity(context.getResources().getDisplayMetrics());
        setBackground(bitmapDrawable);
        setClickable(false);
        setFocusable(false);
    }
}
