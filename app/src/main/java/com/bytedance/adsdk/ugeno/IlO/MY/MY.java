package com.bytedance.adsdk.ugeno.IlO.MY;

import android.animation.FloatEvaluator;
import android.animation.Keyframe;
import android.animation.TypeEvaluator;
import android.content.Context;
import com.bytedance.adsdk.ugeno.Bc.lEW;
import java.util.TreeMap;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class MY extends IlO {

    /* JADX INFO: renamed from: com.bytedance.adsdk.ugeno.IlO.MY.MY$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] IlO;

        static {
            int[] iArr = new int[com.bytedance.adsdk.ugeno.IlO.tV.values().length];
            IlO = iArr;
            try {
                iArr[com.bytedance.adsdk.ugeno.IlO.tV.TRANSLATE_X.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                IlO[com.bytedance.adsdk.ugeno.IlO.tV.TRANSLATE_Y.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                IlO[com.bytedance.adsdk.ugeno.IlO.tV.SCALE_X.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                IlO[com.bytedance.adsdk.ugeno.IlO.tV.SCALE_Y.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                IlO[com.bytedance.adsdk.ugeno.IlO.tV.ROTATE_X.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                IlO[com.bytedance.adsdk.ugeno.IlO.tV.ROTATE_Y.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                IlO[com.bytedance.adsdk.ugeno.IlO.tV.ROTATE_Z.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                IlO[com.bytedance.adsdk.ugeno.IlO.tV.ALPHA.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                IlO[com.bytedance.adsdk.ugeno.IlO.tV.BORDER_RADIUS.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    public MY(Context context, com.bytedance.adsdk.ugeno.MY.EO eo, String str, TreeMap<Float, String> treeMap) {
        super(context, eo, str, treeMap);
    }

    @Override // com.bytedance.adsdk.ugeno.IlO.MY.IlO
    public void IlO(float f4, String str) {
        this.Cc.add(Keyframe.ofFloat(f4, (this.MY.startsWith(com.bytedance.adsdk.ugeno.IlO.tV.TRANSLATE.IlO()) || this.tV == com.bytedance.adsdk.ugeno.IlO.tV.BORDER_RADIUS) ? lEW.IlO(this.IlO, com.bytedance.adsdk.ugeno.Bc.EO.IlO(str, 0.0f)) : com.bytedance.adsdk.ugeno.Bc.EO.IlO(str, 0.0f)));
    }

    @Override // com.bytedance.adsdk.ugeno.IlO.MY.IlO
    public void MY() {
        float fBWL;
        switch (AnonymousClass1.IlO[this.tV.ordinal()]) {
            case 1:
                fBWL = this.Bc.bWL();
                break;
            case 2:
                fBWL = this.Bc.ea();
                break;
            case 3:
                fBWL = this.Bc.zPa();
                break;
            case 4:
                fBWL = this.Bc.cl();
                break;
            case 5:
                fBWL = this.Bc.cL();
                break;
            case 6:
                fBWL = this.Bc.es();
                break;
            case 7:
                fBWL = this.Bc.xF();
                break;
            case 8:
                fBWL = this.Bc.AXM();
                break;
            case 9:
                fBWL = this.Bc.oeT();
                break;
            default:
                fBWL = 0.0f;
                break;
        }
        this.Cc.add(Keyframe.ofFloat(0.0f, fBWL));
    }

    @Override // com.bytedance.adsdk.ugeno.IlO.MY.IlO
    public TypeEvaluator vCE() {
        return new FloatEvaluator();
    }
}
