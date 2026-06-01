package com.bytedance.adsdk.ugeno.DmF.tV;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Shader;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.net.Uri;
import android.util.Log;
import android.widget.ImageView;
import androidx.core.view.ViewCompat;
import com.bytedance.adsdk.ugeno.IlO.Cc;
import com.bytedance.adsdk.ugeno.IlO.vCE;
import com.bytedance.adsdk.ugeno.core.IAnimation;
import com.bytedance.adsdk.ugeno.tV;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class IlO extends ImageView implements Cc, IAnimation {
    static final /* synthetic */ boolean MY = true;
    private vCE AXM;
    private ColorStateList Bc;
    private final float[] Cc;
    private ColorFilter DmF;
    private float EO;
    private Drawable EV;
    private boolean NV;
    private boolean bWL;
    private Shader.TileMode cL;
    private ImageView.ScaleType cl;
    private int ea;
    private Shader.TileMode es;
    private boolean hp;
    private float lEW;
    private boolean rp;
    private Drawable vCE;
    private tV xF;
    private int zPa;
    public static final Shader.TileMode IlO = Shader.TileMode.CLAMP;
    private static final ImageView.ScaleType[] tV = {ImageView.ScaleType.MATRIX, ImageView.ScaleType.FIT_XY, ImageView.ScaleType.FIT_START, ImageView.ScaleType.FIT_CENTER, ImageView.ScaleType.FIT_END, ImageView.ScaleType.CENTER, ImageView.ScaleType.CENTER_CROP, ImageView.ScaleType.CENTER_INSIDE};

    /* JADX INFO: renamed from: com.bytedance.adsdk.ugeno.DmF.tV.IlO$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] IlO;

        static {
            int[] iArr = new int[ImageView.ScaleType.values().length];
            IlO = iArr;
            try {
                iArr[ImageView.ScaleType.FIT_CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                IlO[ImageView.ScaleType.FIT_START.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                IlO[ImageView.ScaleType.FIT_END.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                IlO[ImageView.ScaleType.FIT_XY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                IlO[ImageView.ScaleType.CENTER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                IlO[ImageView.ScaleType.CENTER_CROP.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                IlO[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public IlO(Context context) {
        super(context);
        this.Cc = new float[]{0.0f, 0.0f, 0.0f, 0.0f};
        this.Bc = ColorStateList.valueOf(ViewCompat.MEASURED_STATE_MASK);
        this.lEW = 0.0f;
        this.DmF = null;
        this.NV = false;
        this.rp = false;
        this.hp = false;
        this.bWL = false;
        Shader.TileMode tileMode = IlO;
        this.cL = tileMode;
        this.es = tileMode;
        this.AXM = new vCE(this);
    }

    private void EO() {
        IlO(this.EV, this.cl);
    }

    private Drawable IlO() {
        Resources resources = getResources();
        Drawable drawable = null;
        if (resources == null) {
            return null;
        }
        int i2 = this.ea;
        if (i2 != 0) {
            try {
                drawable = resources.getDrawable(i2);
            } catch (Exception e) {
                Log.w("RoundedImageView", "Unable to find resource: " + this.ea, e);
                this.ea = 0;
            }
        }
        return MY.IlO(drawable);
    }

    private Drawable MY() {
        Resources resources = getResources();
        Drawable drawable = null;
        if (resources == null) {
            return null;
        }
        int i2 = this.zPa;
        if (i2 != 0) {
            try {
                drawable = resources.getDrawable(i2);
            } catch (Exception e) {
                Log.w("RoundedImageView", "Unable to find resource: " + this.zPa, e);
                this.zPa = 0;
            }
        }
        return MY.IlO(drawable);
    }

    private void tV() {
        Drawable drawable = this.EV;
        if (drawable == null || !this.NV) {
            return;
        }
        Drawable drawableMutate = drawable.mutate();
        this.EV = drawableMutate;
        if (this.rp) {
            drawableMutate.setColorFilter(this.DmF);
        }
    }

    @Override // android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        tV tVVar = this.xF;
        if (tVVar != null) {
            tVVar.MY(canvas);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        invalidate();
    }

    public int getBorderColor() {
        return this.Bc.getDefaultColor();
    }

    public ColorStateList getBorderColors() {
        return this.Bc;
    }

    public float getBorderRadius() {
        return this.AXM.IlO();
    }

    public float getBorderWidth() {
        return this.lEW;
    }

    public float getCornerRadius() {
        return getMaxCornerRadius();
    }

    public float getMaxCornerRadius() {
        float fMax = 0.0f;
        for (float f4 : this.Cc) {
            fMax = Math.max(f4, fMax);
        }
        return fMax;
    }

    @Override // com.bytedance.adsdk.ugeno.IlO.Cc, com.bytedance.adsdk.ugeno.core.IAnimation
    public float getRipple() {
        return this.EO;
    }

    @Override // com.bytedance.adsdk.ugeno.IlO.Cc
    public float getRubIn() {
        return this.AXM.getRubIn();
    }

    @Override // android.widget.ImageView
    public ImageView.ScaleType getScaleType() {
        return this.cl;
    }

    @Override // com.bytedance.adsdk.ugeno.IlO.Cc
    public float getShine() {
        return this.AXM.getShine();
    }

    @Override // com.bytedance.adsdk.ugeno.IlO.Cc
    public float getStretch() {
        return this.AXM.getStretch();
    }

    public Shader.TileMode getTileModeX() {
        return this.cL;
    }

    public Shader.TileMode getTileModeY() {
        return this.es;
    }

    @Override // android.widget.ImageView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        tV tVVar = this.xF;
        if (tVVar != null) {
            tVVar.Bc();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        tV tVVar = this.xF;
        if (tVVar != null) {
            tVVar.lEW();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        tV tVVar = this.xF;
        if (tVVar != null) {
            tVVar.IlO(canvas, this);
            this.xF.IlO(canvas);
        }
    }

    @Override // android.view.View
    public void onLayout(boolean z2, int i2, int i8, int i9, int i10) {
        tV tVVar = this.xF;
        if (tVVar != null) {
            tVVar.IlO(i2, i8, i9, i10);
        }
        super.onLayout(z2, i2, i8, i9, i10);
    }

    @Override // android.widget.ImageView, android.view.View
    public void onMeasure(int i2, int i8) {
        tV tVVar = this.xF;
        if (tVVar == null) {
            super.onMeasure(i2, i8);
        } else {
            int[] iArrIlO = tVVar.IlO(i2, i8);
            super.onMeasure(iArrIlO[0], iArrIlO[1]);
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i8, int i9, int i10) {
        super.onSizeChanged(i2, i8, i9, i10);
        tV tVVar = this.xF;
        if (tVVar != null) {
            tVVar.MY(i2, i8, i9, i9);
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z2) {
        super.onWindowFocusChanged(z2);
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        setBackgroundDrawable(drawable);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i2) {
        ColorDrawable colorDrawable = new ColorDrawable(i2);
        this.vCE = colorDrawable;
        setBackgroundDrawable(colorDrawable);
    }

    @Override // android.view.View
    @Deprecated
    public void setBackgroundDrawable(Drawable drawable) {
        this.vCE = drawable;
        IlO(true);
        super.setBackgroundDrawable(this.vCE);
    }

    @Override // android.view.View
    public void setBackgroundResource(int i2) {
        if (this.zPa != i2) {
            this.zPa = i2;
            Drawable drawableMY = MY();
            this.vCE = drawableMY;
            setBackgroundDrawable(drawableMY);
        }
    }

    public void setBorderColor(int i2) {
        setBorderColor(ColorStateList.valueOf(i2));
    }

    public void setBorderRadius(float f4) {
        vCE vce = this.AXM;
        if (vce != null) {
            vce.IlO(f4);
        }
    }

    public void setBorderWidth(int i2) {
        setBorderWidth(getResources().getDimension(i2));
    }

    @Override // android.widget.ImageView
    public void setColorFilter(ColorFilter colorFilter) {
        if (this.DmF != colorFilter) {
            this.DmF = colorFilter;
            this.rp = true;
            this.NV = true;
            tV();
            invalidate();
        }
    }

    public void setCornerRadius(float f4) {
        IlO(f4, f4, f4, f4);
    }

    public void setCornerRadiusDimen(int i2) {
        float dimension = getResources().getDimension(i2);
        IlO(dimension, dimension, dimension, dimension);
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        this.ea = 0;
        this.EV = MY.IlO(bitmap);
        EO();
        super.setImageDrawable(this.EV);
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        this.ea = 0;
        this.EV = MY.IlO(drawable);
        EO();
        super.setImageDrawable(drawable);
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i2) {
        if (this.ea != i2) {
            this.ea = i2;
            this.EV = IlO();
            EO();
            super.setImageDrawable(this.EV);
        }
    }

    @Override // android.widget.ImageView
    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        setImageDrawable(getDrawable());
    }

    public void setOval(boolean z2) {
        this.hp = z2;
        EO();
        IlO(false);
        invalidate();
    }

    @Override // com.bytedance.adsdk.ugeno.core.IAnimation
    public void setRipple(float f4) {
        this.EO = f4;
        vCE vce = this.AXM;
        if (vce != null) {
            vce.MY(f4);
        }
        postInvalidate();
    }

    public void setRubIn(float f4) {
        vCE vce = this.AXM;
        if (vce != null) {
            vce.Cc(f4);
        }
    }

    @Override // android.widget.ImageView
    public void setScaleType(ImageView.ScaleType scaleType) {
        if (!MY && scaleType == null) {
            throw new AssertionError();
        }
        if (this.cl != scaleType) {
            this.cl = scaleType;
            int i2 = AnonymousClass1.IlO[scaleType.ordinal()];
            if (i2 == 1 || i2 == 2 || i2 == 3 || i2 == 4) {
                super.setScaleType(scaleType);
            } else {
                super.setScaleType(ImageView.ScaleType.FIT_XY);
            }
            EO();
            IlO(false);
            invalidate();
        }
    }

    public void setShine(float f4) {
        vCE vce = this.AXM;
        if (vce != null) {
            vce.EO(f4);
        }
    }

    public void setStretch(float f4) {
        vCE vce = this.AXM;
        if (vce != null) {
            vce.tV(f4);
        }
    }

    public void setTileModeX(Shader.TileMode tileMode) {
        if (this.cL == tileMode) {
            return;
        }
        this.cL = tileMode;
        EO();
        IlO(false);
        invalidate();
    }

    public void setTileModeY(Shader.TileMode tileMode) {
        if (this.es == tileMode) {
            return;
        }
        this.es = tileMode;
        EO();
        IlO(false);
        invalidate();
    }

    public void setBorderColor(ColorStateList colorStateList) {
        if (this.Bc.equals(colorStateList)) {
            return;
        }
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(ViewCompat.MEASURED_STATE_MASK);
        }
        this.Bc = colorStateList;
        EO();
        IlO(false);
        if (this.lEW > 0.0f) {
            invalidate();
        }
    }

    public void setBorderWidth(float f4) {
        if (this.lEW == f4) {
            return;
        }
        this.lEW = f4;
        EO();
        IlO(false);
        invalidate();
    }

    private void IlO(boolean z2) {
        if (this.bWL) {
            if (z2) {
                this.vCE = MY.IlO(this.vCE);
            }
            IlO(this.vCE, ImageView.ScaleType.FIT_XY);
        }
    }

    private void IlO(Drawable drawable, ImageView.ScaleType scaleType) {
        if (drawable == null) {
            return;
        }
        if (drawable instanceof MY) {
            MY my = (MY) drawable;
            my.IlO(scaleType).IlO(this.lEW).IlO(this.Bc).IlO(this.hp).IlO(this.cL).MY(this.es);
            float[] fArr = this.Cc;
            if (fArr != null) {
                my.IlO(fArr[0], fArr[1], fArr[2], fArr[3]);
            }
            tV();
            return;
        }
        if (drawable instanceof LayerDrawable) {
            LayerDrawable layerDrawable = (LayerDrawable) drawable;
            int numberOfLayers = layerDrawable.getNumberOfLayers();
            for (int i2 = 0; i2 < numberOfLayers; i2++) {
                IlO(layerDrawable.getDrawable(i2), scaleType);
            }
        }
    }

    public void IlO(float f4, float f8, float f9, float f10) {
        float[] fArr = this.Cc;
        if (fArr[0] == f4 && fArr[1] == f8 && fArr[2] == f10 && fArr[3] == f9) {
            return;
        }
        fArr[0] = f4;
        fArr[1] = f8;
        fArr[3] = f9;
        fArr[2] = f10;
        EO();
        IlO(false);
        invalidate();
    }

    public void IlO(tV tVVar) {
        this.xF = tVVar;
    }
}
