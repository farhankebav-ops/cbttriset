package com.bytedance.adsdk.ugeno.DmF.tV;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.widget.ImageView;
import androidx.webkit.internal.b;
import com.bytedance.adsdk.ugeno.Bc.lEW;
import com.bytedance.adsdk.ugeno.Bc.tV;
import com.bytedance.adsdk.ugeno.Cc;
import com.bytedance.adsdk.ugeno.IlO;
import com.bytedance.adsdk.ugeno.core.DmF;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class EO extends com.bytedance.adsdk.ugeno.MY.EO<IlO> {
    private float Aw;
    protected boolean BES;
    protected String IlO;
    private int La;
    protected ImageView.ScaleType eeU;
    private float uF;

    public EO(Context context) {
        super(context);
        this.eeU = ImageView.ScaleType.FIT_XY;
        this.La = -1;
        this.Aw = -1.0f;
        this.uF = -1.0f;
    }

    private ImageView.ScaleType Bc(String str) {
        ImageView.ScaleType scaleType;
        scaleType = ImageView.ScaleType.FIT_XY;
        str.getClass();
        switch (str) {
            case "center":
                return ImageView.ScaleType.CENTER;
            case "fitEnd":
                return ImageView.ScaleType.FIT_END;
            case "fitStart":
                return ImageView.ScaleType.FIT_START;
            case "centerInside":
                return ImageView.ScaleType.CENTER_INSIDE;
            case "fit":
            case "fitCenter":
                return ImageView.ScaleType.FIT_CENTER;
            case "crop":
            case "centerCrop":
                return ImageView.ScaleType.CENTER_CROP;
            default:
                return scaleType;
        }
    }

    private void DmF() {
        if (this.Aw > 0.0f) {
            Cc.IlO().MY().IlO(this.DmF, this.IlO, new IlO.InterfaceC0030IlO() { // from class: com.bytedance.adsdk.ugeno.DmF.tV.EO.1
                @Override // com.bytedance.adsdk.ugeno.IlO.InterfaceC0030IlO
                public void IlO(Bitmap bitmap) {
                    if (bitmap == null) {
                        return;
                    }
                    final Bitmap bitmapIlO = lEW.IlO(((com.bytedance.adsdk.ugeno.MY.EO) EO.this).MY, bitmap, (int) EO.this.Aw);
                    if (bitmapIlO != null) {
                        lEW.IlO(new Runnable() { // from class: com.bytedance.adsdk.ugeno.DmF.tV.EO.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                ((IlO) ((com.bytedance.adsdk.ugeno.MY.EO) EO.this).Cc).setImageBitmap(bitmapIlO);
                            }
                        });
                    }
                    EO eo = EO.this;
                    if (eo.BES || eo.uF > 0.0f) {
                        Bitmap bitmapIlO2 = lEW.IlO(((com.bytedance.adsdk.ugeno.MY.EO) EO.this).MY, bitmap, EO.this.uF > 0.0f ? (int) EO.this.uF : 10);
                        if (bitmapIlO2 != null) {
                            final BitmapDrawable bitmapDrawable = new BitmapDrawable(((com.bytedance.adsdk.ugeno.MY.EO) EO.this).MY.getResources(), bitmapIlO2);
                            lEW.IlO(new Runnable() { // from class: com.bytedance.adsdk.ugeno.DmF.tV.EO.1.2
                                @Override // java.lang.Runnable
                                public void run() {
                                    ((IlO) ((com.bytedance.adsdk.ugeno.MY.EO) EO.this).Cc).setBackground(bitmapDrawable);
                                }
                            });
                        }
                    }
                }
            });
            return;
        }
        com.bytedance.adsdk.ugeno.IlO ilOMY = Cc.IlO().MY();
        DmF dmF = this.DmF;
        String str = this.IlO;
        T t3 = this.Cc;
        ilOMY.IlO(dmF, str, (ImageView) t3, ((IlO) t3).getWidth(), ((IlO) this.Cc).getHeight());
        if (this.BES || this.uF > 0.0f) {
            Cc.IlO().MY().IlO(this.DmF, this.IlO, new IlO.InterfaceC0030IlO() { // from class: com.bytedance.adsdk.ugeno.DmF.tV.EO.2
                @Override // com.bytedance.adsdk.ugeno.IlO.InterfaceC0030IlO
                public void IlO(Bitmap bitmap) {
                    if (bitmap == null) {
                        return;
                    }
                    final Bitmap bitmapIlO = lEW.IlO(((com.bytedance.adsdk.ugeno.MY.EO) EO.this).MY, bitmap, EO.this.uF > 0.0f ? (int) EO.this.uF : 10);
                    lEW.IlO(new Runnable() { // from class: com.bytedance.adsdk.ugeno.DmF.tV.EO.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (bitmapIlO != null) {
                                ((IlO) ((com.bytedance.adsdk.ugeno.MY.EO) EO.this).Cc).setBackground(new BitmapDrawable(((com.bytedance.adsdk.ugeno.MY.EO) EO.this).MY.getResources(), bitmapIlO));
                            }
                        }
                    });
                }
            });
        }
    }

    private void tV() {
        if (TextUtils.isEmpty(this.IlO)) {
            return;
        }
        ((IlO) this.Cc).setImageDrawable(null);
        if (this.IlO.startsWith("local://")) {
            try {
                ((IlO) this.Cc).setImageResource(tV.IlO(this.MY, this.IlO.replace("local://", "")));
            } catch (Exception unused) {
            }
        } else if (!this.IlO.startsWith("@")) {
            DmF();
        } else {
            ((IlO) this.Cc).setImageResource(Integer.parseInt(this.IlO.substring(1)));
        }
    }

    @Override // com.bytedance.adsdk.ugeno.MY.EO
    /* JADX INFO: renamed from: EO, reason: merged with bridge method [inline-methods] */
    public IlO IlO() {
        IlO ilO = new IlO(this.MY);
        ilO.IlO(this);
        return ilO;
    }

    @Override // com.bytedance.adsdk.ugeno.MY.EO
    public void MY() {
        super.MY();
        tV();
        ((IlO) this.Cc).setScaleType(this.eeU);
        ((IlO) this.Cc).setBorderColor(this.nm);
        ((IlO) this.Cc).setCornerRadius(this.AK);
        ((IlO) this.Cc).setBorderWidth(this.wD);
        int i2 = this.La;
        if (i2 != -1) {
            ((IlO) this.Cc).setColorFilter(i2);
        }
    }

    public void lEW(String str) {
        this.IlO = str;
    }

    @Override // com.bytedance.adsdk.ugeno.MY.EO
    public void IlO(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        super.IlO(str, str2);
        str.getClass();
        switch (str) {
            case "scaleMode":
            case "scaleType":
                this.eeU = Bc(str2);
                break;
            case "imageBlur":
                this.Aw = com.bytedance.adsdk.ugeno.Bc.EO.IlO(str2, -1.0f);
                break;
            case "isBgGaussianBlur":
                this.BES = com.bytedance.adsdk.ugeno.Bc.EO.IlO(str2, false);
                break;
            case "src":
                this.IlO = str2;
                break;
            case "tintColor":
                this.La = com.bytedance.adsdk.ugeno.Bc.IlO.IlO(str2);
                break;
            case "imageBgBlur":
                this.uF = com.bytedance.adsdk.ugeno.Bc.EO.IlO(str2, -1.0f);
                break;
        }
    }

    @Override // com.bytedance.adsdk.ugeno.MY.EO, com.bytedance.adsdk.ugeno.tV
    public void lEW() {
        super.lEW();
        Drawable drawable = ((IlO) this.Cc).getDrawable();
        if (Build.VERSION.SDK_INT < 28 || !b.x(drawable)) {
            return;
        }
        b.g(drawable).stop();
    }

    @Override // com.bytedance.adsdk.ugeno.MY.EO, com.bytedance.adsdk.ugeno.tV
    public void Bc() {
        super.Bc();
        ((IlO) this.Cc).post(new Runnable() { // from class: com.bytedance.adsdk.ugeno.DmF.tV.EO.3
            @Override // java.lang.Runnable
            public void run() {
                Drawable drawable = ((IlO) ((com.bytedance.adsdk.ugeno.MY.EO) EO.this).Cc).getDrawable();
                if (Build.VERSION.SDK_INT < 28 || !b.x(drawable)) {
                    return;
                }
                b.g(drawable).start();
            }
        });
    }
}
