package com.bytedance.sdk.openadsdk.core.NV.MY.IlO;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.widget.ImageView;
import com.bytedance.adsdk.MY.NV;
import com.bytedance.adsdk.MY.tV;
import com.bytedance.adsdk.ugeno.Bc.lEW;
import com.bytedance.adsdk.ugeno.Cc;
import com.bytedance.adsdk.ugeno.IlO;
import com.bytedance.adsdk.ugeno.MY.EO;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class IlO extends EO<MY> {
    private String Aw;
    protected ImageView.ScaleType BES;
    protected String IlO;
    protected ImageView.ScaleType La;
    private int NST;
    private float XvI;
    private boolean aP;
    private float ao;

    @Deprecated
    private boolean eDn;
    protected HashMap<String, Bitmap> eeU;
    private boolean uF;

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.NV.MY.IlO.IlO$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class AnonymousClass1 implements tV {
        public AnonymousClass1() {
        }

        @Override // com.bytedance.adsdk.MY.tV
        public Bitmap IlO(final NV nv) {
            final String strIlO;
            if (nv == null) {
                return null;
            }
            String strNV = nv.NV();
            String strDmF = nv.DmF();
            if (!TextUtils.isEmpty(strNV) && TextUtils.isEmpty(strDmF)) {
                strIlO = com.bytedance.adsdk.ugeno.EO.MY.IlO(strNV, ((EO) IlO.this).tV);
            } else if (!TextUtils.isEmpty(strDmF) && TextUtils.isEmpty(strNV)) {
                strIlO = com.bytedance.adsdk.ugeno.EO.MY.IlO(strDmF, ((EO) IlO.this).tV);
            } else if (TextUtils.isEmpty(strDmF) || TextUtils.isEmpty(strNV)) {
                strIlO = null;
            } else {
                strIlO = com.bytedance.adsdk.ugeno.EO.MY.IlO(strNV, ((EO) IlO.this).tV) + com.bytedance.adsdk.ugeno.EO.MY.IlO(strDmF, ((EO) IlO.this).tV);
            }
            if (TextUtils.isEmpty(strIlO)) {
                return null;
            }
            Bitmap bitmap = IlO.this.eeU.get(strIlO);
            if (bitmap != null) {
                return bitmap;
            }
            Cc.IlO().MY().IlO(((EO) IlO.this).DmF, strIlO, new IlO.InterfaceC0030IlO() { // from class: com.bytedance.sdk.openadsdk.core.NV.MY.IlO.IlO.1.1
                @Override // com.bytedance.adsdk.ugeno.IlO.InterfaceC0030IlO
                public void IlO(Bitmap bitmap2) {
                    if (bitmap2 != null) {
                        final Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmap2, nv.IlO(), nv.MY(), false);
                        IlO.this.eeU.put(strIlO, bitmapCreateScaledBitmap);
                        lEW.IlO(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.NV.MY.IlO.IlO.1.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                ((MY) ((EO) IlO.this).Cc).IlO(nv.lEW(), bitmapCreateScaledBitmap);
                            }
                        });
                    }
                }
            });
            return IlO.this.eeU.get(strIlO);
        }
    }

    public IlO(Context context) {
        super(context);
        this.Aw = "images";
        this.XvI = 1.0f;
        this.BES = ImageView.ScaleType.FIT_CENTER;
        this.La = ImageView.ScaleType.FIT_XY;
        this.eeU = new HashMap<>();
    }

    private String Bc(String str) {
        return (!TextUtils.isEmpty(str) && str.contains("local")) ? str.contains("shake_phone") ? "lottie_json/shake_phone.json" : str.contains("swipe_right") ? "lottie_json/swipe_right.json" : "" : "";
    }

    private ImageView.ScaleType DmF(String str) {
        ImageView.ScaleType scaleType;
        scaleType = ImageView.ScaleType.FIT_XY;
        str.getClass();
        switch (str) {
            case "center":
            case "none":
                return ImageView.ScaleType.CENTER;
            case "fit":
                return ImageView.ScaleType.FIT_CENTER;
            case "crop":
                return ImageView.ScaleType.CENTER_CROP;
            default:
                return scaleType;
        }
    }

    private ImageView.ScaleType lEW(String str) {
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
            case "fitCenter":
                return ImageView.ScaleType.FIT_CENTER;
            case "centerCrop":
                return ImageView.ScaleType.CENTER_CROP;
            default:
                return scaleType;
        }
    }

    @Override // com.bytedance.adsdk.ugeno.MY.EO
    /* JADX INFO: renamed from: EO, reason: merged with bridge method [inline-methods] */
    public MY IlO() {
        MY my = new MY(this.MY);
        my.IlO(this);
        return my;
    }

    @Override // com.bytedance.adsdk.ugeno.MY.EO
    public void MY() {
        super.MY();
        ((MY) this.Cc).setProgress(this.ao);
        if (this.XvI <= 0.0f) {
            this.XvI = 1.0f;
        }
        ((MY) this.Cc).setSpeed(this.XvI);
        if (this.IlO.startsWith("local")) {
            ((MY) this.Cc).setAnimation(Bc(this.IlO));
            ((MY) this.Cc).setImageAssetsFolder(this.Aw);
        } else {
            ((MY) this.Cc).setAnimationFromUrl(this.IlO);
        }
        ((MY) this.Cc).setImageAssetDelegate(new AnonymousClass1());
        if (oc()) {
            ((MY) this.Cc).setScaleType(this.La);
        } else {
            ((MY) this.Cc).setScaleType(this.BES);
        }
        if (oc()) {
            ((MY) this.Cc).setRepeatCount(this.NST);
        } else {
            ((MY) this.Cc).IlO(this.eDn);
        }
        tV();
    }

    public void tV() {
        ((MY) this.Cc).IlO();
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
                this.La = DmF(str2);
                break;
            case "scaleType":
                this.BES = lEW(str2);
                break;
            case "progress":
                this.ao = com.bytedance.adsdk.ugeno.Bc.EO.IlO(str2, 0.0f);
                break;
            case "imagePath":
                this.Aw = str2;
                break;
            case "autoReverse":
                this.uF = com.bytedance.adsdk.ugeno.Bc.EO.IlO(str2, false);
                break;
            case "src":
                this.IlO = com.bytedance.sdk.openadsdk.core.NV.EO.IlO(str2);
                break;
            case "loop":
                if (oc()) {
                    this.NST = com.bytedance.adsdk.ugeno.Bc.EO.IlO(str2, 0);
                    break;
                } else {
                    this.eDn = com.bytedance.adsdk.ugeno.Bc.EO.IlO(str2, false);
                    break;
                }
                break;
            case "speed":
                this.XvI = com.bytedance.adsdk.ugeno.Bc.EO.IlO(str2, 1.0f);
                break;
            case "autoPlay":
                this.aP = com.bytedance.adsdk.ugeno.Bc.EO.IlO(str2, false);
                break;
            case "autoplay":
                this.aP = com.bytedance.adsdk.ugeno.Bc.EO.IlO(str2, true);
                break;
        }
    }
}
