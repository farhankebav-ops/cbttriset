package com.bytedance.adsdk.MY;

import a1.a;
import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import com.bytedance.adsdk.MY.Cc.vAh;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class DmF extends Drawable implements Animatable, Drawable.Callback {
    private int AXM;
    private Matrix BS;
    private boolean Bc;
    private final com.bytedance.adsdk.MY.vCE.EO Cc;
    private RectF DM;
    private MY DmF;
    AXM EO;
    private final ValueAnimator.AnimatorUpdateListener EV;
    String IlO;
    EO MY;
    private final ArrayList<IlO> NV;
    private final Matrix OOq;
    private Rect YA;
    private tV bWL;
    private boolean cL;
    private boolean cl;
    private RectF dY;
    private com.bytedance.adsdk.MY.MY.IlO ea;
    private boolean es;
    private boolean gQ;
    private String hp;
    private boolean kBB;
    private boolean lEW;
    private Paint lMM;
    private RectF mmj;
    private Rect nvX;
    private Canvas oc;
    private boolean oeT;
    private xF pP;
    private com.bytedance.adsdk.MY.MY.MY rp;
    private View ssS;
    private Bc tV;
    private boolean tl;
    private boolean vAh;
    private boolean vCE;
    private Rect vSq;
    private Bitmap wPn;
    private com.bytedance.adsdk.MY.EO.EO.MY xF;
    private Matrix zLG;
    private Map<String, Typeface> zPa;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public interface IlO {
        void IlO(Bc bc);
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public enum MY {
        NONE,
        PLAY,
        RESUME
    }

    public DmF() {
        com.bytedance.adsdk.MY.vCE.EO eo = new com.bytedance.adsdk.MY.vCE.EO();
        this.Cc = eo;
        this.vCE = true;
        this.Bc = false;
        this.lEW = false;
        this.DmF = MY.NONE;
        this.NV = new ArrayList<>();
        ValueAnimator.AnimatorUpdateListener animatorUpdateListener = new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.adsdk.MY.DmF.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (DmF.this.xF != null) {
                    DmF.this.xF.IlO(DmF.this.Cc.vCE());
                }
            }
        };
        this.EV = animatorUpdateListener;
        this.cL = false;
        this.es = true;
        this.AXM = 255;
        this.pP = xF.AUTOMATIC;
        this.tl = false;
        this.OOq = new Matrix();
        this.gQ = false;
        eo.addUpdateListener(animatorUpdateListener);
    }

    private void DM() {
        if (this.oc != null) {
            return;
        }
        this.oc = new Canvas();
        this.DM = new RectF();
        this.zLG = new Matrix();
        this.BS = new Matrix();
        this.vSq = new Rect();
        this.dY = new RectF();
        this.lMM = new com.bytedance.adsdk.MY.IlO.IlO();
        this.nvX = new Rect();
        this.YA = new Rect();
        this.mmj = new RectF();
    }

    private com.bytedance.adsdk.MY.MY.IlO YA() {
        if (getCallback() == null) {
            return null;
        }
        if (this.ea == null) {
            com.bytedance.adsdk.MY.MY.IlO ilO = new com.bytedance.adsdk.MY.MY.IlO(getCallback(), this.MY);
            this.ea = ilO;
            String str = this.IlO;
            if (str != null) {
                ilO.IlO(str);
            }
        }
        return this.ea;
    }

    private void dY() {
        Bc bc = this.tV;
        if (bc == null) {
            return;
        }
        this.tl = this.pP.IlO(Build.VERSION.SDK_INT, bc.IlO(), bc.MY());
    }

    private boolean lMM() {
        return this.vCE || this.Bc;
    }

    private Context mmj() {
        Drawable.Callback callback = getCallback();
        if (callback != null && (callback instanceof View)) {
            return ((View) callback).getContext();
        }
        return null;
    }

    private com.bytedance.adsdk.MY.MY.MY nvX() {
        com.bytedance.adsdk.MY.MY.MY my = this.rp;
        if (my != null && !my.IlO(mmj())) {
            this.rp = null;
        }
        if (this.rp == null) {
            this.rp = new com.bytedance.adsdk.MY.MY.MY(getCallback(), this.hp, this.bWL, this.tV.zPa());
        }
        return this.rp;
    }

    private boolean zLG() {
        Drawable.Callback callback = getCallback();
        if (!(callback instanceof View)) {
            return false;
        }
        ViewParent parent = ((View) callback).getParent();
        return (parent instanceof ViewGroup) && !((ViewGroup) parent).getClipChildren();
    }

    public int AXM() {
        return this.Cc.getRepeatCount();
    }

    public boolean Bc() {
        return this.tl;
    }

    public boolean Cc() {
        return this.cL;
    }

    public boolean DmF() {
        return this.kBB;
    }

    public boolean EO() {
        return this.es;
    }

    public void EV() {
        if (this.xF == null) {
            this.NV.add(new IlO() { // from class: com.bytedance.adsdk.MY.DmF.6
                @Override // com.bytedance.adsdk.MY.DmF.IlO
                public void IlO(Bc bc) {
                    DmF.this.EV();
                }
            });
            return;
        }
        dY();
        if (lMM() || AXM() == 0) {
            if (isVisible()) {
                this.Cc.EV();
                this.DmF = MY.NONE;
            } else {
                this.DmF = MY.PLAY;
            }
        }
        if (lMM()) {
            return;
        }
        EO((int) (zPa() < 0.0f ? bWL() : ea()));
        this.Cc.rp();
        if (isVisible()) {
            return;
        }
        this.DmF = MY.NONE;
    }

    public void NV() {
        if (this.Cc.isRunning()) {
            this.Cc.cancel();
            if (!isVisible()) {
                this.DmF = MY.NONE;
            }
        }
        this.tV = null;
        this.xF = null;
        this.rp = null;
        this.Cc.lEW();
        invalidateSelf();
    }

    public void OOq() {
        this.NV.clear();
        this.Cc.cancel();
        if (isVisible()) {
            return;
        }
        this.DmF = MY.NONE;
    }

    public float bWL() {
        return this.Cc.ea();
    }

    public void cL() {
        this.Cc.removeAllListeners();
    }

    public void cl() {
        this.Cc.removeAllUpdateListeners();
        this.Cc.addUpdateListener(this.EV);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Cc.IlO("Drawable#draw");
        try {
            if (this.tl) {
                IlO(canvas, this.xF);
            } else {
                IlO(canvas);
            }
        } catch (Throwable unused) {
        }
        this.gQ = false;
        Cc.MY("Drawable#draw");
    }

    public float ea() {
        return this.Cc.zPa();
    }

    public int es() {
        return (int) this.Cc.Bc();
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.AXM;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        Bc bc = this.tV;
        if (bc == null) {
            return -1;
        }
        return bc.tV().height();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        Bc bc = this.tV;
        if (bc == null) {
            return -1;
        }
        return bc.tV().width();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public void hp() {
        if (this.xF == null) {
            this.NV.add(new IlO() { // from class: com.bytedance.adsdk.MY.DmF.7
                @Override // com.bytedance.adsdk.MY.DmF.IlO
                public void IlO(Bc bc) {
                    DmF.this.hp();
                }
            });
            return;
        }
        dY();
        if (lMM() || AXM() == 0) {
            if (isVisible()) {
                this.Cc.bWL();
                this.DmF = MY.NONE;
            } else {
                this.DmF = MY.RESUME;
            }
        }
        if (lMM()) {
            return;
        }
        EO((int) (zPa() < 0.0f ? bWL() : ea()));
        this.Cc.rp();
        if (isVisible()) {
            return;
        }
        this.DmF = MY.NONE;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        Drawable.Callback callback = getCallback();
        if (callback == null) {
            return;
        }
        callback.invalidateDrawable(this);
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        if (this.gQ) {
            return;
        }
        this.gQ = true;
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return oeT();
    }

    public AXM kBB() {
        return this.EO;
    }

    public es lEW() {
        Bc bc = this.tV;
        if (bc != null) {
            return bc.EO();
        }
        return null;
    }

    public float oc() {
        return this.Cc.vCE();
    }

    public boolean oeT() {
        com.bytedance.adsdk.MY.vCE.EO eo = this.Cc;
        if (eo == null) {
            return false;
        }
        return eo.isRunning();
    }

    public boolean pP() {
        return this.zPa == null && this.EO == null && this.tV.bWL().size() > 0;
    }

    public void rp() {
        this.NV.clear();
        this.Cc.rp();
        if (isVisible()) {
            return;
        }
        this.DmF = MY.NONE;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        Drawable.Callback callback = getCallback();
        if (callback == null) {
            return;
        }
        callback.scheduleDrawable(this, runnable, j);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
        this.AXM = i2;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z2, boolean z7) {
        boolean zIsVisible = isVisible();
        boolean visible = super.setVisible(z2, z7);
        if (z2) {
            MY my = this.DmF;
            if (my == MY.PLAY) {
                EV();
                return visible;
            }
            if (my == MY.RESUME) {
                hp();
                return visible;
            }
        } else {
            if (this.Cc.isRunning()) {
                wPn();
                this.DmF = MY.RESUME;
                return visible;
            }
            if (zIsVisible) {
                this.DmF = MY.NONE;
            }
        }
        return visible;
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        Drawable.Callback callback = getCallback();
        if ((callback instanceof View) && ((View) callback).isInEditMode()) {
            return;
        }
        EV();
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        rp();
    }

    public String tV() {
        return this.hp;
    }

    public Bc tl() {
        return this.tV;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        Drawable.Callback callback = getCallback();
        if (callback == null) {
            return;
        }
        callback.unscheduleDrawable(this, runnable);
    }

    public boolean vAh() {
        if (isVisible()) {
            return this.Cc.isRunning();
        }
        MY my = this.DmF;
        return my == MY.PLAY || my == MY.RESUME;
    }

    public xF vCE() {
        return this.tl ? xF.SOFTWARE : xF.HARDWARE;
    }

    public RectF vSq() {
        return this.DM;
    }

    public void wPn() {
        this.NV.clear();
        this.Cc.hp();
        if (isVisible()) {
            return;
        }
        this.DmF = MY.NONE;
    }

    public int xF() {
        return this.Cc.getRepeatMode();
    }

    public float zPa() {
        return this.Cc.NV();
    }

    public void Bc(boolean z2) {
        this.Bc = z2;
    }

    public void Cc(boolean z2) {
        this.kBB = z2;
    }

    public void EO(boolean z2) {
        this.oeT = z2;
        Bc bc = this.tV;
        if (bc != null) {
            bc.MY(z2);
        }
    }

    public void IlO(View view) {
        this.ssS = view;
    }

    public com.bytedance.adsdk.MY.EO.EO.MY MY() {
        return this.xF;
    }

    public void tV(boolean z2) {
        if (this.vAh == z2) {
            return;
        }
        this.vAh = z2;
        com.bytedance.adsdk.MY.EO.EO.MY my = this.xF;
        if (my != null) {
            my.IlO(z2);
        }
    }

    public void vCE(boolean z2) {
        this.lEW = z2;
    }

    public void Bc(String str) {
        this.IlO = str;
        com.bytedance.adsdk.MY.MY.IlO ilOYA = YA();
        if (ilOYA != null) {
            ilOYA.IlO(str);
        }
    }

    public void Cc(int i2) {
        this.Cc.setRepeatCount(i2);
    }

    public View IlO() {
        return this.ssS;
    }

    public void MY(boolean z2) {
        this.cL = z2;
    }

    public void lEW(boolean z2) {
        this.Cc.EO(z2);
    }

    public NV vCE(String str) {
        Bc bc = this.tV;
        if (bc == null) {
            return null;
        }
        return bc.zPa().get(str);
    }

    public Bitmap Cc(String str) {
        com.bytedance.adsdk.MY.MY.MY myNvX = nvX();
        if (myNvX != null) {
            return myNvX.IlO(str);
        }
        return null;
    }

    public void IlO(boolean z2, Context context) {
        if (this.cl == z2) {
            return;
        }
        this.cl = z2;
        if (this.tV != null) {
            IlO(context);
        }
    }

    public void MY(final int i2) {
        if (this.tV == null) {
            this.NV.add(new IlO() { // from class: com.bytedance.adsdk.MY.DmF.10
                @Override // com.bytedance.adsdk.MY.DmF.IlO
                public void IlO(Bc bc) {
                    DmF.this.MY(i2);
                }
            });
        } else {
            this.Cc.MY(i2 + 0.99f);
        }
    }

    public void EO(final String str) {
        Bc bc = this.tV;
        if (bc == null) {
            this.NV.add(new IlO() { // from class: com.bytedance.adsdk.MY.DmF.13
                @Override // com.bytedance.adsdk.MY.DmF.IlO
                public void IlO(Bc bc2) {
                    DmF.this.EO(str);
                }
            });
            return;
        }
        com.bytedance.adsdk.MY.EO.vCE vceEO = bc.EO(str);
        if (vceEO != null) {
            MY((int) (vceEO.IlO + vceEO.MY));
            return;
        }
        throw new IllegalArgumentException(a.m("Cannot find marker with name ", str, "."));
    }

    public void tV(final String str) {
        Bc bc = this.tV;
        if (bc == null) {
            this.NV.add(new IlO() { // from class: com.bytedance.adsdk.MY.DmF.2
                @Override // com.bytedance.adsdk.MY.DmF.IlO
                public void IlO(Bc bc2) {
                    DmF.this.tV(str);
                }
            });
            return;
        }
        com.bytedance.adsdk.MY.EO.vCE vceEO = bc.EO(str);
        if (vceEO != null) {
            int i2 = (int) vceEO.IlO;
            IlO(i2, ((int) vceEO.MY) + i2);
            return;
        }
        throw new IllegalArgumentException(a.m("Cannot find marker with name ", str, "."));
    }

    public void MY(final float f4) {
        Bc bc = this.tV;
        if (bc == null) {
            this.NV.add(new IlO() { // from class: com.bytedance.adsdk.MY.DmF.11
                @Override // com.bytedance.adsdk.MY.DmF.IlO
                public void IlO(Bc bc2) {
                    DmF.this.MY(f4);
                }
            });
        } else {
            this.Cc.MY(com.bytedance.adsdk.MY.vCE.Cc.IlO(bc.vCE(), this.tV.Bc(), f4));
        }
    }

    public void IlO(boolean z2) {
        if (z2 != this.es) {
            this.es = z2;
            com.bytedance.adsdk.MY.EO.EO.MY my = this.xF;
            if (my != null) {
                my.MY(z2);
            }
            invalidateSelf();
        }
    }

    public void MY(final String str) {
        Bc bc = this.tV;
        if (bc == null) {
            this.NV.add(new IlO() { // from class: com.bytedance.adsdk.MY.DmF.12
                @Override // com.bytedance.adsdk.MY.DmF.IlO
                public void IlO(Bc bc2) {
                    DmF.this.MY(str);
                }
            });
            return;
        }
        com.bytedance.adsdk.MY.EO.vCE vceEO = bc.EO(str);
        if (vceEO != null) {
            IlO((int) vceEO.IlO);
            return;
        }
        throw new IllegalArgumentException(a.m("Cannot find marker with name ", str, "."));
    }

    public void IlO(String str) {
        this.hp = str;
    }

    public boolean IlO(Bc bc, Context context) {
        if (this.tV == bc) {
            return false;
        }
        this.gQ = true;
        NV();
        this.tV = bc;
        IlO(context);
        this.Cc.IlO(bc);
        tV(this.Cc.getAnimatedFraction());
        Iterator it = new ArrayList(this.NV).iterator();
        while (it.hasNext()) {
            IlO ilO = (IlO) it.next();
            if (ilO != null) {
                ilO.IlO(bc);
            }
            it.remove();
        }
        this.NV.clear();
        bc.MY(this.oeT);
        dY();
        Drawable.Callback callback = getCallback();
        if (callback instanceof ImageView) {
            ImageView imageView = (ImageView) callback;
            imageView.setImageDrawable(null);
            imageView.setImageDrawable(this);
        }
        return true;
    }

    public void EO(float f4) {
        this.Cc.EO(f4);
    }

    public void EO(final int i2) {
        if (this.tV == null) {
            this.NV.add(new IlO() { // from class: com.bytedance.adsdk.MY.DmF.4
                @Override // com.bytedance.adsdk.MY.DmF.IlO
                public void IlO(Bc bc) {
                    DmF.this.EO(i2);
                }
            });
        } else {
            this.Cc.IlO(i2);
        }
    }

    public void tV(final float f4) {
        if (this.tV == null) {
            this.NV.add(new IlO() { // from class: com.bytedance.adsdk.MY.DmF.5
                @Override // com.bytedance.adsdk.MY.DmF.IlO
                public void IlO(Bc bc) {
                    DmF.this.tV(f4);
                }
            });
            return;
        }
        Cc.IlO("Drawable#setProgress");
        this.Cc.IlO(this.tV.IlO(f4));
        Cc.MY("Drawable#setProgress");
    }

    public void MY(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.Cc.removeUpdateListener(animatorUpdateListener);
    }

    public void MY(Animator.AnimatorListener animatorListener) {
        this.Cc.removeListener(animatorListener);
    }

    private void MY(int i2, int i8) {
        Bitmap bitmap = this.wPn;
        if (bitmap != null && bitmap.getWidth() >= i2 && this.wPn.getHeight() >= i8) {
            if (this.wPn.getWidth() > i2 || this.wPn.getHeight() > i8) {
                Bitmap bitmapCreateBitmap = Bitmap.createBitmap(this.wPn, 0, 0, i2, i8);
                this.wPn = bitmapCreateBitmap;
                this.oc.setBitmap(bitmapCreateBitmap);
                this.gQ = true;
                return;
            }
            return;
        }
        Bitmap bitmapCreateBitmap2 = Bitmap.createBitmap(i2, i8, Bitmap.Config.ARGB_8888);
        this.wPn = bitmapCreateBitmap2;
        this.oc.setBitmap(bitmapCreateBitmap2);
        this.gQ = true;
    }

    public void tV(int i2) {
        this.Cc.setRepeatMode(i2);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }

    public void IlO(xF xFVar) {
        this.pP = xFVar;
        dY();
    }

    private void IlO(Context context) {
        Bc bc = this.tV;
        if (bc == null) {
            return;
        }
        com.bytedance.adsdk.MY.EO.EO.MY my = new com.bytedance.adsdk.MY.EO.EO.MY(this, vAh.IlO(bc), bc.hp(), bc, context);
        this.xF = my;
        if (this.vAh) {
            my.IlO(true);
        }
        this.xF.MY(this.es);
    }

    public void IlO(final int i2) {
        if (this.tV == null) {
            this.NV.add(new IlO() { // from class: com.bytedance.adsdk.MY.DmF.8
                @Override // com.bytedance.adsdk.MY.DmF.IlO
                public void IlO(Bc bc) {
                    DmF.this.IlO(i2);
                }
            });
        } else {
            this.Cc.IlO(i2);
        }
    }

    public void IlO(final float f4) {
        Bc bc = this.tV;
        if (bc == null) {
            this.NV.add(new IlO() { // from class: com.bytedance.adsdk.MY.DmF.9
                @Override // com.bytedance.adsdk.MY.DmF.IlO
                public void IlO(Bc bc2) {
                    DmF.this.IlO(f4);
                }
            });
        } else {
            IlO((int) com.bytedance.adsdk.MY.vCE.Cc.IlO(bc.vCE(), this.tV.Bc(), f4));
        }
    }

    public void IlO(final int i2, final int i8) {
        if (this.tV == null) {
            this.NV.add(new IlO() { // from class: com.bytedance.adsdk.MY.DmF.3
                @Override // com.bytedance.adsdk.MY.DmF.IlO
                public void IlO(Bc bc) {
                    DmF.this.IlO(i2, i8);
                }
            });
        } else {
            this.Cc.IlO(i2, i8 + 0.99f);
        }
    }

    public void IlO(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.Cc.addUpdateListener(animatorUpdateListener);
    }

    public void IlO(Animator.AnimatorListener animatorListener) {
        this.Cc.addListener(animatorListener);
    }

    public void IlO(Boolean bool) {
        this.vCE = bool.booleanValue();
    }

    public void IlO(tV tVVar) {
        this.bWL = tVVar;
        com.bytedance.adsdk.MY.MY.MY my = this.rp;
        if (my != null) {
            my.IlO(tVVar);
        }
    }

    public void IlO(EO eo) {
        this.MY = eo;
        com.bytedance.adsdk.MY.MY.IlO ilO = this.ea;
        if (ilO != null) {
            ilO.IlO(eo);
        }
    }

    public void IlO(Map<String, Typeface> map) {
        if (map == this.zPa) {
            return;
        }
        this.zPa = map;
        invalidateSelf();
    }

    public void IlO(AXM axm) {
        this.EO = axm;
    }

    public Bitmap IlO(String str, Bitmap bitmap) {
        com.bytedance.adsdk.MY.MY.MY myNvX = nvX();
        if (myNvX == null) {
            return null;
        }
        Bitmap bitmapIlO = myNvX.IlO(str, bitmap);
        invalidateSelf();
        return bitmapIlO;
    }

    public Typeface IlO(com.bytedance.adsdk.MY.EO.EO eo) {
        Map<String, Typeface> map = this.zPa;
        if (map != null) {
            String strIlO = eo.IlO();
            if (map.containsKey(strIlO)) {
                return map.get(strIlO);
            }
            String strMY = eo.MY();
            if (map.containsKey(strMY)) {
                return map.get(strMY);
            }
            String str = eo.IlO() + "-" + eo.EO();
            if (map.containsKey(str)) {
                return map.get(str);
            }
        }
        com.bytedance.adsdk.MY.MY.IlO ilOYA = YA();
        if (ilOYA != null) {
            return ilOYA.IlO(eo);
        }
        return null;
    }

    private void IlO(Canvas canvas) {
        com.bytedance.adsdk.MY.EO.EO.MY my = this.xF;
        Bc bc = this.tV;
        if (my == null || bc == null) {
            return;
        }
        this.OOq.reset();
        if (!getBounds().isEmpty()) {
            this.OOq.preScale(r2.width() / bc.tV().width(), r2.height() / bc.tV().height());
            this.OOq.preTranslate(r2.left, r2.top);
        }
        my.IlO(canvas, this.OOq, this.AXM);
    }

    private void IlO(Canvas canvas, com.bytedance.adsdk.MY.EO.EO.MY my) {
        if (this.tV == null || my == null) {
            return;
        }
        DM();
        canvas.getMatrix(this.zLG);
        canvas.getClipBounds(this.vSq);
        IlO(this.vSq, this.dY);
        this.zLG.mapRect(this.dY);
        IlO(this.dY, this.vSq);
        if (this.es) {
            this.DM.set(0.0f, 0.0f, getIntrinsicWidth(), getIntrinsicHeight());
        } else {
            my.IlO(this.DM, (Matrix) null, false);
        }
        this.zLG.mapRect(this.DM);
        Rect bounds = getBounds();
        float fWidth = bounds.width() / getIntrinsicWidth();
        float fHeight = bounds.height() / getIntrinsicHeight();
        IlO(this.DM, fWidth, fHeight);
        if (!zLG()) {
            RectF rectF = this.DM;
            Rect rect = this.vSq;
            rectF.intersect(rect.left, rect.top, rect.right, rect.bottom);
        }
        int iCeil = (int) Math.ceil(this.DM.width());
        int iCeil2 = (int) Math.ceil(this.DM.height());
        if (iCeil == 0 || iCeil2 == 0) {
            return;
        }
        MY(iCeil, iCeil2);
        if (this.gQ) {
            this.OOq.set(this.zLG);
            this.OOq.preScale(fWidth, fHeight);
            Matrix matrix = this.OOq;
            RectF rectF2 = this.DM;
            matrix.postTranslate(-rectF2.left, -rectF2.top);
            this.wPn.eraseColor(0);
            my.IlO(this.oc, this.OOq, this.AXM);
            this.zLG.invert(this.BS);
            this.BS.mapRect(this.mmj, this.DM);
            IlO(this.mmj, this.YA);
        }
        this.nvX.set(0, 0, iCeil, iCeil2);
        canvas.drawBitmap(this.wPn, this.nvX, this.YA, this.lMM);
    }

    private void IlO(RectF rectF, Rect rect) {
        rect.set((int) Math.floor(rectF.left), (int) Math.floor(rectF.top), (int) Math.ceil(rectF.right), (int) Math.ceil(rectF.bottom));
    }

    private void IlO(Rect rect, RectF rectF) {
        rectF.set(rect.left, rect.top, rect.right, rect.bottom);
    }

    private void IlO(RectF rectF, float f4, float f8) {
        rectF.set(rectF.left * f4, rectF.top * f8, rectF.right * f4, rectF.bottom * f8);
    }
}
