package com.instagram.common.viewpoint.core;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.ViewCompat;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.cl, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1442cl extends RelativeLayout {
    public final Paint A00;
    public final RectF A01;

    public C1442cl(C1477dL c1477dL, String str) {
        super(c1477dL);
        float f4 = c1477dL.getResources().getDisplayMetrics().density;
        TextView textView = new TextView(c1477dL);
        textView.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        textView.setTextSize(16.0f);
        textView.setText(str);
        textView.setTypeface(Typeface.defaultFromStyle(1));
        setGravity(17);
        float density = 6.0f * f4;
        int i2 = (int) density;
        textView.setPadding(i2, i2, i2, i2);
        addView(textView);
        this.A00 = new Paint();
        this.A00.setStyle(Paint.Style.FILL);
        this.A00.setColor(-1);
        this.A01 = new RectF();
        XP.A0K(this, 0);
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        float f4 = getContext().getResources().getDisplayMetrics().density;
        this.A01.set(0.0f, 0.0f, getWidth(), getHeight());
        canvas.drawRoundRect(this.A01, f4 * 10.0f, 10.0f * f4, this.A00);
        super.onDraw(canvas);
    }
}
