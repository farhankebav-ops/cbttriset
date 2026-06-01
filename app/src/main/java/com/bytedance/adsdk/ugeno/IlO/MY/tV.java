package com.bytedance.adsdk.ugeno.IlO.MY;

import android.animation.FloatEvaluator;
import android.animation.Keyframe;
import android.animation.PropertyValuesHolder;
import android.animation.TypeEvaluator;
import android.content.Context;
import android.text.TextUtils;
import com.bytedance.adsdk.ugeno.Bc.lEW;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class tV extends IlO {
    private List<Keyframe> lEW;

    /* JADX INFO: renamed from: com.bytedance.adsdk.ugeno.IlO.MY.tV$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] IlO;

        static {
            int[] iArr = new int[com.bytedance.adsdk.ugeno.IlO.tV.values().length];
            IlO = iArr;
            try {
                iArr[com.bytedance.adsdk.ugeno.IlO.tV.TRANSLATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                IlO[com.bytedance.adsdk.ugeno.IlO.tV.SCALE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public tV(Context context, com.bytedance.adsdk.ugeno.MY.EO eo, String str, Map<Float, String> map) {
        super(context, eo, str, map);
        this.lEW = new ArrayList();
    }

    @Override // com.bytedance.adsdk.ugeno.IlO.MY.IlO
    public List<PropertyValuesHolder> Cc() {
        String strMY = this.tV.MY();
        tV();
        PropertyValuesHolder propertyValuesHolderOfKeyframe = PropertyValuesHolder.ofKeyframe(strMY + "X", (Keyframe[]) this.Cc.toArray(new Keyframe[0]));
        this.vCE.add(propertyValuesHolderOfKeyframe);
        PropertyValuesHolder propertyValuesHolderOfKeyframe2 = PropertyValuesHolder.ofKeyframe(strMY + "Y", (Keyframe[]) this.lEW.toArray(new Keyframe[0]));
        this.vCE.add(propertyValuesHolderOfKeyframe2);
        TypeEvaluator typeEvaluatorVCE = vCE();
        if (typeEvaluatorVCE != null) {
            propertyValuesHolderOfKeyframe.setEvaluator(typeEvaluatorVCE);
            propertyValuesHolderOfKeyframe2.setEvaluator(typeEvaluatorVCE);
        }
        return this.vCE;
    }

    @Override // com.bytedance.adsdk.ugeno.IlO.MY.IlO
    public void IlO(float f4, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONArray jSONArray = new JSONArray(str);
            if (jSONArray.length() != 2) {
                return;
            }
            float fOptDouble = (float) jSONArray.optDouble(0);
            float fOptDouble2 = (float) jSONArray.optDouble(1);
            if (this.tV == com.bytedance.adsdk.ugeno.IlO.tV.TRANSLATE) {
                fOptDouble = lEW.IlO(this.IlO, fOptDouble);
                fOptDouble2 = lEW.IlO(this.IlO, fOptDouble2);
            }
            this.Cc.add(Keyframe.ofFloat(f4, fOptDouble));
            this.lEW.add(Keyframe.ofFloat(f4, fOptDouble2));
        } catch (JSONException unused) {
        }
    }

    @Override // com.bytedance.adsdk.ugeno.IlO.MY.IlO
    public void MY() {
        Keyframe keyframeOfFloat;
        Keyframe keyframeOfFloat2;
        int i2 = AnonymousClass1.IlO[this.tV.ordinal()];
        if (i2 == 1) {
            keyframeOfFloat = Keyframe.ofFloat(0.0f, this.Bc.bWL());
            keyframeOfFloat2 = Keyframe.ofFloat(0.0f, this.Bc.ea());
        } else if (i2 != 2) {
            keyframeOfFloat = null;
            keyframeOfFloat2 = null;
        } else {
            keyframeOfFloat = Keyframe.ofFloat(0.0f, this.Bc.zPa());
            keyframeOfFloat2 = Keyframe.ofFloat(0.0f, this.Bc.cl());
        }
        if (keyframeOfFloat != null) {
            this.Cc.add(keyframeOfFloat);
        }
        if (keyframeOfFloat2 != null) {
            this.lEW.add(keyframeOfFloat2);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.IlO.MY.IlO
    public TypeEvaluator vCE() {
        return new FloatEvaluator();
    }
}
