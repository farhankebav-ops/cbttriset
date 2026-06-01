package com.bytedance.sdk.openadsdk.core.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import com.bytedance.sdk.component.utils.pP;
import com.bytedance.sdk.openadsdk.utils.BS;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class ea extends View {
    private Drawable Cc;
    private int EO;
    private final Path IlO;
    private final boolean MY;
    private Drawable tV;
    private float vCE;

    public ea(Context context) {
        this(context, false);
    }

    private void IlO() {
        Context context = getContext();
        this.tV = pP.EO(context, this.MY ? "tt_star_thick_dark" : "tt_star_thick");
        this.Cc = pP.EO(context, "tt_star");
    }

    private void MY() {
        int width = getWidth();
        int height = getHeight();
        if (this.vCE <= 0.0f || width <= 0 || height <= 0) {
            return;
        }
        this.IlO.reset();
        this.IlO.addRect(new RectF(0.0f, 0.0f, width * this.vCE, height), Path.Direction.CCW);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.EO <= 0) {
            return;
        }
        int iSave = canvas.save();
        for (int i2 = 0; i2 < 5; i2++) {
            this.tV.draw(canvas);
            canvas.translate(this.EO, 0.0f);
        }
        canvas.restoreToCount(iSave);
        canvas.clipPath(this.IlO);
        for (int i8 = 0; i8 < 5; i8++) {
            this.Cc.draw(canvas);
            canvas.translate(this.EO, 0.0f);
        }
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i8) {
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(this.EO * 5, BasicMeasure.EXACTLY), View.MeasureSpec.makeMeasureSpec(this.EO, BasicMeasure.EXACTLY));
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i8, int i9, int i10) {
        super.onSizeChanged(i2, i8, i9, i10);
        MY();
    }

    public ea(Context context, boolean z2) {
        super(context);
        this.IlO = new Path();
        this.MY = z2;
        IlO();
    }

    public void IlO(double d8, int i2) {
        int iIlO = (int) BS.IlO(getContext(), i2, false);
        this.EO = iIlO;
        this.tV.setBounds(0, 0, iIlO, iIlO);
        Drawable drawable = this.Cc;
        int i8 = this.EO;
        drawable.setBounds(0, 0, i8, i8);
        this.vCE = ((float) d8) / 5.0f;
        MY();
        requestLayout();
    }
}
