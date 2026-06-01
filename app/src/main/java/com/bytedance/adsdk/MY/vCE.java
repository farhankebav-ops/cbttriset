package com.bytedance.adsdk.MY;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import com.bytedance.adsdk.MY.Bc;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import org.json.JSONArray;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class vCE extends ImageView {
    private static final String IlO = "vCE";
    private static final EV<Throwable> MY = new EV<Throwable>() { // from class: com.bytedance.adsdk.MY.vCE.1
        @Override // com.bytedance.adsdk.MY.EV
        public void IlO(Throwable th) {
            com.bytedance.adsdk.MY.vCE.vCE.IlO(th);
        }
    };
    private com.bytedance.adsdk.MY.EO.EO.EO AXM;
    private final DmF Bc;
    private EV<Throwable> Cc;
    private int DmF;
    private final EV<Bc> EO;
    private boolean EV;
    private boolean NV;
    private JSONArray OOq;
    private final Set<Object> bWL;
    private int cL;
    private final Handler cl;
    private hp<Bc> ea;
    private Handler es;
    private final Set<tV> hp;
    private int kBB;
    private String lEW;
    private MY oc;
    private int oeT;
    private int pP;
    private boolean rp;
    private final EV<Throwable> tV;
    private String tl;
    private int vAh;
    private int vCE;
    private IlO vSq;
    private final Runnable wPn;
    private long xF;
    private Bc zPa;

    /* JADX INFO: renamed from: com.bytedance.adsdk.MY.vCE$5, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static /* synthetic */ class AnonymousClass5 {
        static final /* synthetic */ int[] IlO;

        static {
            int[] iArr = new int[ImageView.ScaleType.values().length];
            IlO = iArr;
            try {
                iArr[ImageView.ScaleType.CENTER_CROP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                IlO[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                IlO[ImageView.ScaleType.CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                IlO[ImageView.ScaleType.FIT_CENTER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class EO extends View.BaseSavedState {
        public static final Parcelable.Creator<EO> CREATOR = new Parcelable.Creator<EO>() { // from class: com.bytedance.adsdk.MY.vCE.EO.1
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: IlO, reason: merged with bridge method [inline-methods] */
            public EO createFromParcel(Parcel parcel) {
                return new EO(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: IlO, reason: merged with bridge method [inline-methods] */
            public EO[] newArray(int i2) {
                return new EO[i2];
            }
        };
        int Bc;
        String Cc;
        float EO;
        String IlO;
        int MY;
        boolean tV;
        int vCE;

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeString(this.IlO);
            parcel.writeFloat(this.EO);
            parcel.writeInt(this.tV ? 1 : 0);
            parcel.writeString(this.Cc);
            parcel.writeInt(this.vCE);
            parcel.writeInt(this.Bc);
        }

        public EO(Parcelable parcelable) {
            super(parcelable);
        }

        private EO(Parcel parcel) {
            super(parcel);
            this.IlO = parcel.readString();
            this.EO = parcel.readFloat();
            this.tV = parcel.readInt() == 1;
            this.Cc = parcel.readString();
            this.vCE = parcel.readInt();
            this.Bc = parcel.readInt();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public interface IlO {
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public interface MY {
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public enum tV {
        SET_ANIMATION,
        SET_PROGRESS,
        SET_REPEAT_MODE,
        SET_REPEAT_COUNT,
        SET_IMAGE_ASSETS,
        PLAY_OPTION
    }

    public vCE(Context context) {
        super(context);
        this.EO = new EV<Bc>() { // from class: com.bytedance.adsdk.MY.vCE.6
            @Override // com.bytedance.adsdk.MY.EV
            public void IlO(Bc bc) {
                vCE.this.setComposition(bc);
            }
        };
        this.tV = new EV<Throwable>() { // from class: com.bytedance.adsdk.MY.vCE.7
            @Override // com.bytedance.adsdk.MY.EV
            public void IlO(Throwable th) {
                if (vCE.this.vCE != 0) {
                    vCE vce = vCE.this;
                    vce.setImageResource(vce.vCE);
                }
                (vCE.this.Cc == null ? vCE.MY : vCE.this.Cc).IlO(th);
            }
        };
        this.vCE = 0;
        this.Bc = new DmF();
        this.NV = false;
        this.EV = false;
        this.rp = true;
        this.hp = new HashSet();
        this.bWL = new HashSet();
        this.cl = new Handler(Looper.getMainLooper());
        this.cL = 0;
        this.xF = 0L;
        this.wPn = new Runnable() { // from class: com.bytedance.adsdk.MY.vCE.4
            @Override // java.lang.Runnable
            public void run() {
                Log.i("TMe", "--==--- timer callback, timer: " + vCE.this.oeT + ", " + vCE.this.vAh);
                if (vCE.this.oeT > vCE.this.vAh) {
                    vCE.cL(vCE.this);
                    com.bytedance.adsdk.MY.EO.EO.EO eo = vCE.this.AXM;
                    StringBuilder sb = new StringBuilder();
                    sb.append(vCE.this.oeT);
                    eo.IlO(sb.toString());
                    vCE.this.invalidate();
                    vCE.this.ea();
                    return;
                }
                if (vCE.this.kBB < 0 || vCE.this.pP < 0) {
                    Log.i("TMe", "--==--- timer end, frame invalid: " + vCE.this.kBB + "," + vCE.this.pP);
                } else {
                    Log.i("TMe", "--==--- timer end, play anim, startframe: " + vCE.this.kBB);
                    vCE.this.IlO();
                    vCE vce = vCE.this;
                    vce.setFrame(vce.kBB);
                    vCE.this.IlO(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.adsdk.MY.vCE.4.1
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            if (vCE.this.getFrame() < vCE.this.pP - 1 || vCE.this.getFrame() >= vCE.this.pP + 2) {
                                return;
                            }
                            Log.i("TMe", "--==--- timer end, play anim, endframe: " + vCE.this.pP);
                            vCE.this.MY(this);
                            vCE.this.vCE();
                        }
                    });
                }
                if ((!TextUtils.isEmpty(vCE.this.tl) || (vCE.this.OOq != null && vCE.this.OOq.length() > 0)) && vCE.this.oc != null) {
                    MY unused = vCE.this.oc;
                    String unused2 = vCE.this.tl;
                    JSONArray unused3 = vCE.this.OOq;
                }
            }
        };
        lEW();
    }

    public static /* synthetic */ int Cc(vCE vce) {
        int i2 = vce.cL;
        vce.cL = i2 + 1;
        return i2;
    }

    public static /* synthetic */ int cL(vCE vce) {
        int i2 = vce.oeT;
        vce.oeT = i2 - 1;
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Bc.IlO getGlobalConfig() {
        Bc bcTl;
        DmF dmF = this.Bc;
        if (dmF == null || (bcTl = dmF.tl()) == null) {
            return null;
        }
        return bcTl.EV();
    }

    private Bc.MY getGlobalEvent() {
        Bc bcTl;
        DmF dmF = this.Bc;
        if (dmF == null || (bcTl = dmF.tl()) == null) {
            return null;
        }
        return bcTl.NV();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getPlayDelayedELExpressTimeS() {
        Bc bcTl;
        DmF dmF = this.Bc;
        if (dmF == null || (bcTl = dmF.tl()) == null) {
            return null;
        }
        return bcTl.DmF();
    }

    private void setCompositionTask(hp<Bc> hpVar) {
        this.hp.add(tV.SET_ANIMATION);
        cl();
        hp();
        this.ea = hpVar.IlO(this.EO).EO(this.tV);
    }

    public boolean getClipToCompositionBounds() {
        return this.Bc.EO();
    }

    public Bc getComposition() {
        return this.zPa;
    }

    public long getDuration() {
        Bc bc = this.zPa;
        if (bc != null) {
            return (long) bc.Cc();
        }
        return 0L;
    }

    public int getFrame() {
        return this.Bc.es();
    }

    public String getImageAssetsFolder() {
        return this.Bc.tV();
    }

    public boolean getMaintainOriginalImageBounds() {
        return this.Bc.Cc();
    }

    public float getMaxFrame() {
        return this.Bc.ea();
    }

    public float getMinFrame() {
        return this.Bc.bWL();
    }

    public es getPerformanceTracker() {
        return this.Bc.lEW();
    }

    public float getProgress() {
        return this.Bc.oc();
    }

    public xF getRenderMode() {
        return this.Bc.vCE();
    }

    public int getRepeatCount() {
        return this.Bc.AXM();
    }

    public int getRepeatMode() {
        return this.Bc.xF();
    }

    public float getSpeed() {
        return this.Bc.zPa();
    }

    @Override // android.view.View
    public void invalidate() {
        super.invalidate();
        Drawable drawable = getDrawable();
        if ((drawable instanceof DmF) && ((DmF) drawable).vCE() == xF.SOFTWARE) {
            this.Bc.invalidateSelf();
        }
    }

    @Override // android.widget.ImageView, android.view.View, android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        Drawable drawable2 = getDrawable();
        DmF dmF = this.Bc;
        if (drawable2 == dmF) {
            super.invalidateDrawable(dmF);
        } else {
            super.invalidateDrawable(drawable);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (isInEditMode() || !this.EV) {
            return;
        }
        this.Bc.EV();
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        zPa();
        Handler handler = this.es;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        EO();
        MY();
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        int i2;
        if (!(parcelable instanceof EO)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        EO eo = (EO) parcelable;
        super.onRestoreInstanceState(eo.getSuperState());
        this.lEW = eo.IlO;
        Set<tV> set = this.hp;
        tV tVVar = tV.SET_ANIMATION;
        if (!set.contains(tVVar) && !TextUtils.isEmpty(this.lEW)) {
            setAnimation(this.lEW);
        }
        this.DmF = eo.MY;
        if (!this.hp.contains(tVVar) && (i2 = this.DmF) != 0) {
            setAnimation(i2);
        }
        if (!this.hp.contains(tV.SET_PROGRESS)) {
            IlO(eo.EO, false);
        }
        if (!this.hp.contains(tV.PLAY_OPTION) && eo.tV) {
            IlO();
        }
        if (!this.hp.contains(tV.SET_IMAGE_ASSETS)) {
            setImageAssetsFolder(eo.Cc);
        }
        if (!this.hp.contains(tV.SET_REPEAT_MODE)) {
            setRepeatMode(eo.vCE);
        }
        if (this.hp.contains(tV.SET_REPEAT_COUNT)) {
            return;
        }
        setRepeatCount(eo.Bc);
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        EO eo = new EO(super.onSaveInstanceState());
        eo.IlO = this.lEW;
        eo.MY = this.DmF;
        eo.EO = this.Bc.oc();
        eo.tV = this.Bc.vAh();
        eo.Cc = this.Bc.tV();
        eo.vCE = this.Bc.xF();
        eo.Bc = this.Bc.AXM();
        return eo;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int[][] iArr;
        com.bytedance.adsdk.MY.EO.EO.IlO IlO2 = IlO(motionEvent);
        if (IlO2 == null) {
            if (getGlobalConfig() == null || getGlobalConfig().IlO != 1) {
                return super.onTouchEvent(motionEvent);
            }
            return false;
        }
        String strDmF = IlO2.DmF();
        if (IlO2 instanceof com.bytedance.adsdk.MY.EO.EO.MY) {
            if (getGlobalConfig() == null || getGlobalConfig().IlO != 1) {
                return super.onTouchEvent(motionEvent);
            }
            return false;
        }
        if (strDmF != null && strDmF.startsWith("CSJCLOSE")) {
            zPa();
        }
        NV nvIlO = IlO(IlO2.Cc());
        if (nvIlO != null && motionEvent.getAction() == 1) {
            IlO(strDmF, nvIlO.Cc(), nvIlO.Bc());
            int[][] iArrVCE = nvIlO.vCE();
            if (iArrVCE != null) {
                IlO(iArrVCE);
            } else if (getGlobalEvent() != null && (iArr = getGlobalEvent().MY) != null) {
                IlO(iArr);
            }
        }
        if (strDmF == null || !strDmF.startsWith("CSJNTP")) {
            return super.onTouchEvent(motionEvent);
        }
        return false;
    }

    public void setAnimation(int i2) {
        this.DmF = i2;
        this.lEW = null;
        setCompositionTask(IlO(i2));
    }

    public void setAnimationFromJson(String str) {
        IlO(str, (String) null);
    }

    public void setAnimationFromUrl(String str) {
        setCompositionTask(this.rp ? lEW.IlO(getContext(), str) : lEW.IlO(getContext(), str, (String) null));
    }

    public void setApplyingOpacityToLayersEnabled(boolean z2) {
        this.Bc.Cc(z2);
    }

    public void setCacheComposition(boolean z2) {
        this.rp = z2;
    }

    public void setClipToCompositionBounds(boolean z2) {
        this.Bc.IlO(z2);
    }

    public void setComposition(Bc bc) {
        if (Cc.IlO) {
            Log.v(IlO, "Set Composition \n".concat(String.valueOf(bc)));
        }
        this.Bc.setCallback(this);
        this.zPa = bc;
        this.NV = true;
        boolean zIlO = this.Bc.IlO(bc, getContext().getApplicationContext());
        this.NV = false;
        if (getDrawable() != this.Bc || zIlO) {
            if (!zIlO) {
                cL();
            }
            onVisibilityChanged(this, getVisibility());
            requestLayout();
            Iterator<Object> it = this.bWL.iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
    }

    public void setDefaultFontFileExtension(String str) {
        this.Bc.Bc(str);
    }

    public void setFailureListener(EV<Throwable> ev) {
        this.Cc = ev;
    }

    public void setFallbackResource(int i2) {
        this.vCE = i2;
    }

    public void setFontAssetDelegate(com.bytedance.adsdk.MY.EO eo) {
        this.Bc.IlO(eo);
    }

    public void setFontMap(Map<String, Typeface> map) {
        this.Bc.IlO(map);
    }

    public void setFrame(int i2) {
        this.Bc.EO(i2);
    }

    public void setIgnoreDisabledSystemAnimations(boolean z2) {
        this.Bc.Bc(z2);
    }

    public void setImageAssetDelegate(com.bytedance.adsdk.MY.tV tVVar) {
        this.Bc.IlO(tVVar);
    }

    public void setImageAssetsFolder(String str) {
        this.Bc.IlO(str);
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        hp();
        super.setImageBitmap(bitmap);
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        hp();
        super.setImageDrawable(drawable);
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i2) {
        hp();
        super.setImageResource(i2);
    }

    public void setLottieAnimListener(IlO ilO) {
        this.vSq = ilO;
    }

    public void setLottieClicklistener(MY my) {
        this.oc = my;
    }

    public void setMaintainOriginalImageBounds(boolean z2) {
        this.Bc.MY(z2);
    }

    public void setMaxFrame(int i2) {
        this.Bc.MY(i2);
    }

    public void setMaxProgress(float f4) {
        this.Bc.MY(f4);
    }

    public void setMinAndMaxFrame(String str) {
        this.Bc.tV(str);
    }

    public void setMinFrame(int i2) {
        this.Bc.IlO(i2);
    }

    public void setMinProgress(float f4) {
        this.Bc.IlO(f4);
    }

    public void setOutlineMasksAndMattes(boolean z2) {
        this.Bc.tV(z2);
    }

    public void setPerformanceTrackingEnabled(boolean z2) {
        this.Bc.EO(z2);
    }

    public void setProgress(float f4) {
        IlO(f4, true);
    }

    public void setRenderMode(xF xFVar) {
        this.Bc.IlO(xFVar);
    }

    public void setRepeatCount(int i2) {
        this.hp.add(tV.SET_REPEAT_COUNT);
        this.Bc.Cc(i2);
    }

    public void setRepeatMode(int i2) {
        this.hp.add(tV.SET_REPEAT_MODE);
        this.Bc.tV(i2);
    }

    public void setSafeMode(boolean z2) {
        this.Bc.vCE(z2);
    }

    public void setSpeed(float f4) {
        this.Bc.EO(f4);
    }

    public void setTextDelegate(AXM axm) {
        this.Bc.IlO(axm);
    }

    public void setUseCompositionFrameRate(boolean z2) {
        this.Bc.lEW(z2);
    }

    public void setView(View view) {
        this.Bc.IlO(view);
    }

    @Override // android.view.View
    public void unscheduleDrawable(Drawable drawable) {
        DmF dmF;
        if (!this.NV && drawable == (dmF = this.Bc) && dmF.oeT()) {
            vCE();
        } else if (!this.NV && (drawable instanceof DmF)) {
            DmF dmF2 = (DmF) drawable;
            if (dmF2.oeT()) {
                dmF2.wPn();
            }
        }
        super.unscheduleDrawable(drawable);
    }

    private void DmF() {
        IlO(new Animator.AnimatorListener() { // from class: com.bytedance.adsdk.MY.vCE.8
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                vCE.this.MY(this);
                vCE.this.bWL();
                vCE.this.EV();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
    }

    private void EO(Matrix matrix, float f4, float f8, float f9, float f10) {
        matrix.postTranslate((f4 - f9) / 2.0f, (f8 - f10) / 2.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void EV() {
        final Bc.IlO globalConfig = getGlobalConfig();
        if (globalConfig == null || globalConfig.Cc <= 0) {
            return;
        }
        if (TextUtils.isEmpty(globalConfig.vCE) && globalConfig.Bc == null) {
            return;
        }
        int maxFrame = globalConfig.Cc;
        if (maxFrame > getMaxFrame()) {
            maxFrame = (int) getMaxFrame();
        }
        final float maxFrame2 = maxFrame / getMaxFrame();
        IlO(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.adsdk.MY.vCE.10
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                Object animatedValue = valueAnimator.getAnimatedValue();
                if (!(animatedValue instanceof Float) || ((Float) animatedValue).floatValue() < maxFrame2) {
                    return;
                }
                vCE.this.MY(this);
                if (vCE.this.oc != null) {
                    MY unused = vCE.this.oc;
                }
            }
        });
    }

    private void MY(RectF rectF, RectF rectF2) {
        float width = getWidth();
        float height = getHeight();
        float fWidth = this.Bc.getBounds().width();
        float fHeight = this.Bc.getBounds().height();
        if (width == 0.0f || height == 0.0f || fWidth == 0.0f || fHeight == 0.0f) {
            return;
        }
        Matrix matrix = new Matrix();
        int i2 = AnonymousClass5.IlO[getScaleType().ordinal()];
        if (i2 == 1) {
            IlO(matrix, width, height, fWidth, fHeight);
        } else if (i2 == 2) {
            MY(matrix, width, height, fWidth, fHeight);
        } else if (i2 == 3) {
            EO(matrix, width, height, fWidth, fHeight);
        } else if (i2 == 4) {
            tV(matrix, width, height, fWidth, fHeight);
        }
        matrix.mapRect(rectF, rectF2);
    }

    private void NV() {
        IlO(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.adsdk.MY.vCE.9
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int i2;
                Object animatedValue = valueAnimator.getAnimatedValue();
                if (!(animatedValue instanceof Float) || ((Float) animatedValue).floatValue() < 0.98f) {
                    return;
                }
                vCE.Cc(vCE.this);
                Bc.IlO globalConfig = vCE.this.getGlobalConfig();
                if (globalConfig != null && (i2 = globalConfig.tV) > 0 && i2 > vCE.this.cL) {
                    vCE.this.bWL();
                    vCE.this.IlO();
                    vCE.this.setProgress(0.0f);
                } else {
                    vCE.this.MY(this);
                    if (vCE.this.vSq != null) {
                        IlO unused = vCE.this.vSq;
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bWL() {
        DmF dmF;
        int i2;
        int i8;
        final int i9;
        if (this.zPa == null || (dmF = this.Bc) == null) {
            return;
        }
        AXM axmKBB = dmF.kBB();
        Bc.EO eoLEW = this.zPa.lEW();
        if (eoLEW == null || axmKBB == null) {
            return;
        }
        final int i10 = eoLEW.IlO;
        if (i10 < 0) {
            Log.i("TMe", "--==--- timer fail, ke is invalid: ".concat(String.valueOf(i10)));
            return;
        }
        int[] iArr = eoLEW.Cc;
        final int i11 = -1;
        if (iArr == null || iArr.length < 2) {
            i2 = -1;
            i8 = -1;
        } else {
            i8 = iArr[0];
            i2 = iArr[1];
        }
        String strIlO = axmKBB.IlO(eoLEW.EO);
        String strIlO2 = axmKBB.IlO(eoLEW.tV);
        try {
            i9 = Integer.parseInt(strIlO);
            try {
                i11 = Integer.parseInt(strIlO2);
            } catch (NumberFormatException unused) {
            }
        } catch (NumberFormatException unused2) {
            i9 = -1;
        }
        Log.i("TMe", "--==--- prepare timer, startS: " + i9 + ", lenS: " + i11);
        if (TextUtils.isEmpty(eoLEW.MY)) {
            Log.i("TMe", "--==--- timer fail, id is invalid: " + eoLEW.MY);
            return;
        }
        Log.i("TMe", "--==--- timer, id:" + eoLEW.MY);
        com.bytedance.adsdk.MY.EO.EO.EO EO2 = EO(eoLEW.MY);
        if (EO2 != null) {
            Log.i("TMe", "--==--- timer success");
            this.tl = eoLEW.vCE;
            this.OOq = eoLEW.Bc;
            this.AXM = EO2;
            this.oeT = i9;
            this.vAh = i9 - i11;
            this.kBB = i8;
            this.pP = i2;
            StringBuilder sb = new StringBuilder();
            sb.append(this.oeT);
            EO2.IlO(sb.toString());
            IlO(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.adsdk.MY.vCE.3
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    if (vCE.this.getFrame() < i10 - 1 || vCE.this.getFrame() >= i10 + 2) {
                        return;
                    }
                    Log.i("TMe", "--==--- enter timer point, frame: " + vCE.this.getFrame());
                    vCE.this.MY(this);
                    if (i9 < 0 || i11 < 0) {
                        Log.i("TMe", "--==--- enter timer callback, NOT start timer");
                    } else {
                        Log.i("TMe", "--==--- enter timer callback, start timer");
                        vCE.this.ea();
                    }
                    vCE.this.vCE();
                }
            });
        }
    }

    private void cL() {
        boolean zTV = tV();
        setImageDrawable(null);
        setImageDrawable(this.Bc);
        if (zTV) {
            this.Bc.hp();
        }
    }

    private void cl() {
        this.zPa = null;
        this.Bc.NV();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ea() {
        this.cl.postDelayed(this.wPn, 1000L);
    }

    private void hp() {
        hp<Bc> hpVar = this.ea;
        if (hpVar != null) {
            hpVar.MY(this.EO);
            this.ea.tV(this.tV);
        }
    }

    private void lEW() {
        setSaveEnabled(false);
        this.rp = true;
        setFallbackResource(0);
        setImageAssetsFolder("");
        IlO(0.0f, false);
        IlO(false, getContext().getApplicationContext());
        setIgnoreDisabledSystemAnimations(false);
        this.Bc.IlO(Boolean.valueOf(com.bytedance.adsdk.MY.vCE.vCE.IlO(getContext()) != 0.0f));
        DmF();
        NV();
        rp();
    }

    private void rp() {
        IlO(new Animator.AnimatorListener() { // from class: com.bytedance.adsdk.MY.vCE.11
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                AXM axmKBB;
                final long jElapsedRealtime = SystemClock.elapsedRealtime() - vCE.this.xF;
                vCE.this.MY(this);
                String playDelayedELExpressTimeS = vCE.this.getPlayDelayedELExpressTimeS();
                if (!TextUtils.isEmpty(playDelayedELExpressTimeS) && (axmKBB = vCE.this.Bc.kBB()) != null) {
                    try {
                        int i2 = Integer.parseInt(axmKBB.IlO(playDelayedELExpressTimeS)) * 1000;
                        if (vCE.this.xF > 0) {
                            long jElapsedRealtime2 = (vCE.this.xF + ((long) i2)) - SystemClock.elapsedRealtime();
                            Log.i("TMe", "--==-- lottie delayed time: ".concat(String.valueOf(jElapsedRealtime2)));
                            if (jElapsedRealtime2 > 0) {
                                vCE.this.vCE();
                                vCE.this.setVisibility(8);
                                if (vCE.this.es == null) {
                                    vCE.this.es = new Handler(Looper.getMainLooper());
                                }
                                vCE.this.es.removeCallbacksAndMessages(null);
                                vCE.this.es.postDelayed(new Runnable() { // from class: com.bytedance.adsdk.MY.vCE.11.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        Log.i("TMe", "--==-- lottie real start play");
                                        vCE.this.setVisibility(0);
                                        vCE.this.IlO();
                                        vCE.this.IlO(jElapsedRealtime);
                                    }
                                }, jElapsedRealtime2);
                                return;
                            }
                        }
                    } catch (NumberFormatException unused) {
                    }
                }
                vCE.this.IlO(jElapsedRealtime);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
    }

    private void tV(Matrix matrix, float f4, float f8, float f9, float f10) {
        if (f9 >= f4 || f10 >= f8) {
            if (f9 / f10 >= f4 / f8) {
                float f11 = f4 / f9;
                matrix.preScale(f11, f11);
                matrix.postTranslate(0.0f, (f8 - (f10 * f11)) / 2.0f);
                return;
            } else {
                float f12 = f8 / f10;
                matrix.preScale(f12, f12);
                matrix.postTranslate((f4 - (f9 * f12)) / 2.0f, 0.0f);
                return;
            }
        }
        if (f9 / f10 >= f4 / f8) {
            float f13 = f4 / f9;
            matrix.preScale(f13, f13);
            matrix.postTranslate(0.0f, (f8 - (f10 * f13)) / 2.0f);
        } else {
            float f14 = f8 / f10;
            matrix.preScale(f14, f14);
            matrix.postTranslate((f4 - (f9 * f14)) / 2.0f, 0.0f);
        }
    }

    private void zPa() {
        this.cl.removeCallbacksAndMessages(null);
    }

    public void Cc() {
        this.hp.add(tV.PLAY_OPTION);
        this.Bc.OOq();
    }

    public void setMaxFrame(String str) {
        this.Bc.EO(str);
    }

    public void setMinFrame(String str) {
        this.Bc.MY(str);
    }

    public void vCE() {
        this.EV = false;
        this.Bc.wPn();
    }

    private com.bytedance.adsdk.MY.EO.EO.EO EO(String str) {
        com.bytedance.adsdk.MY.EO.EO.MY MY2;
        DmF dmF = this.Bc;
        if (dmF == null || (MY2 = dmF.MY()) == null) {
            return null;
        }
        return IlO(MY2, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void IlO(long j) {
        Map<String, Object> map;
        Bc.IlO globalConfig = getGlobalConfig();
        if (this.vSq != null) {
            HashMap map2 = new HashMap();
            map2.put("duration", Long.valueOf(j));
            if (globalConfig == null || (map = globalConfig.MY) == null || map.isEmpty()) {
                return;
            }
            map2.putAll(globalConfig.MY);
        }
    }

    public void setAnimation(String str) {
        this.lEW = str;
        this.DmF = 0;
        setCompositionTask(MY(str));
    }

    public void EO() {
        this.Bc.cL();
    }

    private NV IlO(String str) {
        DmF dmF;
        Bc bcTl;
        Map<String, NV> mapZPa;
        if (TextUtils.isEmpty(str) || (dmF = this.Bc) == null || (bcTl = dmF.tl()) == null || (mapZPa = bcTl.zPa()) == null) {
            return null;
        }
        return mapZPa.get(str);
    }

    public boolean tV() {
        return this.Bc.oeT();
    }

    private void MY(Matrix matrix, float f4, float f8, float f9, float f10) {
        if (f9 < f4 && f10 < f8) {
            matrix.postTranslate((f4 - f9) / 2.0f, (f8 - f10) / 2.0f);
            return;
        }
        if (f9 / f10 >= f4 / f8) {
            float f11 = f4 / f9;
            matrix.preScale(f11, f11);
            matrix.postTranslate(0.0f, (f8 - (f10 * f11)) / 2.0f);
        } else {
            float f12 = f8 / f10;
            matrix.preScale(f12, f12);
            matrix.postTranslate((f4 - (f9 * f12)) / 2.0f, 0.0f);
        }
    }

    private void IlO(int[][] iArr) {
        if (iArr == null || iArr.length == 0) {
            return;
        }
        try {
            int[] iArr2 = iArr[0];
            int i2 = iArr2[0];
            final int i8 = iArr2[1];
            if (i2 < 0 || i8 < 0) {
                return;
            }
            Log.i("TMe", "--==--- inel enter, play anim, startframe: ".concat(String.valueOf(i2)));
            zPa();
            IlO();
            setFrame(i2);
            IlO(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.adsdk.MY.vCE.12
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    if (vCE.this.getFrame() < i8 - 1 || vCE.this.getFrame() >= i8 + 2) {
                        return;
                    }
                    Log.i("TMe", "--==--- inel enter, play anim end, endframe: " + i8 + ", realFrame: " + vCE.this.getFrame());
                    vCE.this.MY(this);
                    vCE.this.vCE();
                }
            });
        } catch (Throwable unused) {
        }
    }

    private hp<Bc> MY(final String str) {
        if (isInEditMode()) {
            return new hp<>(new Callable<rp<Bc>>() { // from class: com.bytedance.adsdk.MY.vCE.2
                @Override // java.util.concurrent.Callable
                /* JADX INFO: renamed from: IlO, reason: merged with bridge method [inline-methods] */
                public rp<Bc> call() throws Exception {
                    return vCE.this.rp ? lEW.EO(vCE.this.getContext(), str) : lEW.EO(vCE.this.getContext(), str, null);
                }
            }, true);
        }
        return this.rp ? lEW.MY(getContext(), str) : lEW.MY(getContext(), str, (String) null);
    }

    public void MY(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.Bc.MY(animatorUpdateListener);
    }

    private void IlO(String str, String str2, JSONArray jSONArray) {
        Bc.MY globalEvent = getGlobalEvent();
        if (globalEvent != null && str != null) {
            if (TextUtils.isEmpty(str2) && !str.contains("CSJNO")) {
                str2 = globalEvent.IlO;
            }
            if ((jSONArray == null || jSONArray.length() <= 0) && !str.contains("CSJLELNO")) {
                jSONArray = globalEvent.EO;
            }
        }
        if (!TextUtils.isEmpty(str2) || jSONArray == null) {
            return;
        }
        jSONArray.length();
    }

    public void MY() {
        this.Bc.cl();
    }

    public void MY(Animator.AnimatorListener animatorListener) {
        this.Bc.MY(animatorListener);
    }

    private com.bytedance.adsdk.MY.EO.EO.IlO IlO(MotionEvent motionEvent) {
        com.bytedance.adsdk.MY.EO.EO.MY MY2;
        DmF dmF = this.Bc;
        if (dmF == null || (MY2 = dmF.MY()) == null) {
            return null;
        }
        return IlO(MY2, motionEvent);
    }

    private com.bytedance.adsdk.MY.EO.EO.IlO IlO(com.bytedance.adsdk.MY.EO.EO.MY my, MotionEvent motionEvent) {
        com.bytedance.adsdk.MY.EO.EO.IlO IlO2;
        for (com.bytedance.adsdk.MY.EO.EO.IlO ilO : my.rp()) {
            if (ilO instanceof com.bytedance.adsdk.MY.EO.EO.MY) {
                if (ilO.lEW() && ilO.vCE() > 0.0f) {
                    RectF rectF = new RectF();
                    ilO.IlO(rectF, ilO.tV(), true);
                    if (rectF.width() >= 3.0f && rectF.height() >= 3.0f && (IlO2 = IlO((com.bytedance.adsdk.MY.EO.EO.MY) ilO, motionEvent)) != null) {
                        return IlO2;
                    }
                }
            } else if (ilO.lEW() && ilO.vCE() > 0.0f) {
                RectF rectF2 = new RectF();
                DmF dmF = this.Bc;
                if (dmF != null && dmF.Bc()) {
                    ilO.IlO(rectF2, ilO.tV(), true);
                    RectF rectFVSq = this.Bc.vSq();
                    if (rectFVSq != null) {
                        IlO(rectF2, rectFVSq);
                    }
                } else {
                    RectF rectF3 = new RectF();
                    ilO.IlO(rectF3, ilO.tV(), true);
                    MY(rectF2, rectF3);
                }
                if (IlO(motionEvent, rectF2)) {
                    return ilO;
                }
            }
        }
        return null;
    }

    private boolean IlO(MotionEvent motionEvent, RectF rectF) {
        if (motionEvent != null && rectF != null) {
            float x2 = motionEvent.getX();
            float y = motionEvent.getY();
            if (x2 >= rectF.left && x2 <= rectF.right && y >= rectF.top && y <= rectF.bottom) {
                return true;
            }
        }
        return false;
    }

    private void IlO(RectF rectF, RectF rectF2) {
        float width = getWidth();
        float height = getHeight();
        float fWidth = rectF2.width();
        float fHeight = rectF2.height();
        if (width == 0.0f || height == 0.0f || fWidth == 0.0f || fHeight == 0.0f) {
            return;
        }
        Matrix matrix = new Matrix();
        int i2 = AnonymousClass5.IlO[getScaleType().ordinal()];
        if (i2 == 1) {
            IlO(matrix, width, height, fWidth, fHeight);
        } else if (i2 == 2) {
            MY(matrix, width, height, fWidth, fHeight);
        } else if (i2 == 3) {
            EO(matrix, width, height, fWidth, fHeight);
        } else if (i2 == 4) {
            tV(matrix, width, height, fWidth, fHeight);
        }
        matrix.mapRect(rectF);
    }

    private void IlO(Matrix matrix, float f4, float f8, float f9, float f10) {
        if (f9 / f10 >= f4 / f8) {
            float f11 = f8 / f10;
            matrix.preScale(f11, f11);
            matrix.postTranslate(-(((f9 * f11) - f4) / 2.0f), 0.0f);
        } else {
            float f12 = f4 / f9;
            matrix.preScale(f12, f12);
            matrix.postTranslate(0.0f, -(((f10 * f12) - f8) / 2.0f));
        }
    }

    public void IlO(boolean z2, Context context) {
        this.Bc.IlO(z2, context);
    }

    private hp<Bc> IlO(final int i2) {
        if (isInEditMode()) {
            return new hp<>(new Callable<rp<Bc>>() { // from class: com.bytedance.adsdk.MY.vCE.13
                @Override // java.util.concurrent.Callable
                /* JADX INFO: renamed from: IlO, reason: merged with bridge method [inline-methods] */
                public rp<Bc> call() throws Exception {
                    return vCE.this.rp ? lEW.MY(vCE.this.getContext(), i2) : lEW.MY(vCE.this.getContext(), i2, (String) null);
                }
            }, true);
        }
        return this.rp ? lEW.IlO(getContext(), i2) : lEW.IlO(getContext(), i2, (String) null);
    }

    public void IlO(String str, String str2) {
        IlO(new ByteArrayInputStream(str.getBytes()), str2);
    }

    public void IlO(InputStream inputStream, String str) {
        setCompositionTask(lEW.IlO(inputStream, str));
    }

    private com.bytedance.adsdk.MY.EO.EO.EO IlO(com.bytedance.adsdk.MY.EO.EO.MY my, String str) {
        for (com.bytedance.adsdk.MY.EO.EO.IlO ilO : my.rp()) {
            if (ilO instanceof com.bytedance.adsdk.MY.EO.EO.MY) {
                com.bytedance.adsdk.MY.EO.EO.EO eoIlO = IlO((com.bytedance.adsdk.MY.EO.EO.MY) ilO, str);
                if (eoIlO != null) {
                    return eoIlO;
                }
            } else if (TextUtils.equals(str, ilO.DmF()) && (ilO instanceof com.bytedance.adsdk.MY.EO.EO.EO)) {
                return (com.bytedance.adsdk.MY.EO.EO.EO) ilO;
            }
        }
        return null;
    }

    public void IlO() {
        if (this.xF == 0) {
            this.xF = SystemClock.elapsedRealtime();
        }
        this.hp.add(tV.PLAY_OPTION);
        this.Bc.EV();
    }

    public void IlO(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.Bc.IlO(animatorUpdateListener);
    }

    public void IlO(Animator.AnimatorListener animatorListener) {
        this.Bc.IlO(animatorListener);
    }

    public void IlO(boolean z2) {
        this.Bc.Cc(z2 ? -1 : 0);
    }

    public Bitmap IlO(String str, Bitmap bitmap) {
        return this.Bc.IlO(str, bitmap);
    }

    private void IlO(float f4, boolean z2) {
        if (z2) {
            this.hp.add(tV.SET_PROGRESS);
        }
        this.Bc.tV(f4);
    }
}
