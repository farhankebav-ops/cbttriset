package com.bytedance.sdk.component.adexpress.vCE;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.Xfermode;
import android.view.View;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class rp extends View {
    private int Bc;
    private int Cc;
    private int[] DmF;
    private int EO;
    private Paint EV;
    Rect IlO;
    Rect MY;
    private Bitmap NV;
    private LinearGradient bWL;
    private final List<IlO> ea;
    private PorterDuff.Mode hp;
    private int lEW;
    private Xfermode rp;
    private int tV;
    private int vCE;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class IlO {
        private final int IlO;
        private int MY = 0;

        public IlO(int i2) {
            this.IlO = i2;
        }

        public void IlO() {
            this.MY += this.IlO;
        }
    }

    public rp(Context context) {
        super(context);
        this.hp = PorterDuff.Mode.DST_IN;
        this.ea = new ArrayList();
        IlO();
    }

    private void IlO() {
        this.EO = com.bytedance.sdk.component.utils.pP.tV(getContext(), "tt_splash_unlock_image_arrow");
        this.tV = Color.parseColor("#00ffffff");
        this.Cc = Color.parseColor("#ffffffff");
        int color = Color.parseColor("#00ffffff");
        this.vCE = color;
        this.Bc = 10;
        this.lEW = 40;
        this.DmF = new int[]{this.tV, this.Cc, color};
        setLayerType(1, null);
        this.EV = new Paint(1);
        this.NV = BitmapFactory.decodeResource(getResources(), this.EO);
        this.rp = new PorterDuffXfermode(this.hp);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawBitmap(this.NV, this.IlO, this.MY, this.EV);
        canvas.save();
        Iterator<IlO> it = this.ea.iterator();
        while (it.hasNext()) {
            IlO next = it.next();
            this.bWL = new LinearGradient(next.MY, 0.0f, next.MY + this.lEW, this.Bc, this.DmF, (float[]) null, Shader.TileMode.CLAMP);
            this.EV.setColor(-1);
            this.EV.setShader(this.bWL);
            Canvas canvas2 = canvas;
            canvas2.drawRect(0.0f, 0.0f, getWidth(), getHeight(), this.EV);
            this.EV.setShader(null);
            next.IlO();
            if (next.MY > getWidth()) {
                it.remove();
            }
            canvas = canvas2;
        }
        Canvas canvas3 = canvas;
        this.EV.setXfermode(this.rp);
        canvas3.drawBitmap(this.NV, this.IlO, this.MY, this.EV);
        this.EV.setXfermode(null);
        canvas3.restore();
        invalidate();
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i8, int i9, int i10) {
        super.onSizeChanged(i2, i8, i9, i10);
        if (this.NV == null) {
            return;
        }
        this.IlO = new Rect(0, 0, this.NV.getWidth(), this.NV.getHeight());
        this.MY = new Rect(0, 0, getWidth(), getHeight());
    }

    public void IlO(int i2) {
        this.ea.add(new IlO(i2));
        postInvalidate();
    }
}
