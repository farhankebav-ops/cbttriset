package com.bytedance.adsdk.ugeno.IlO.MY;

import android.animation.Keyframe;
import android.animation.PropertyValuesHolder;
import android.animation.TypeEvaluator;
import android.content.Context;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class IlO {
    protected com.bytedance.adsdk.ugeno.MY.EO Bc;
    protected Map<Float, String> EO;
    protected Context IlO;
    protected String MY;
    protected com.bytedance.adsdk.ugeno.IlO.tV tV;
    protected List<PropertyValuesHolder> vCE = new ArrayList();
    protected List<Keyframe> Cc = new ArrayList();

    public IlO(Context context, com.bytedance.adsdk.ugeno.MY.EO eo, String str, Map<Float, String> map) {
        this.IlO = context;
        this.MY = str;
        this.EO = map;
        this.tV = com.bytedance.adsdk.ugeno.IlO.tV.IlO(this.MY);
        this.Bc = eo;
    }

    public List<PropertyValuesHolder> Cc() {
        String strMY = this.tV.MY();
        tV();
        PropertyValuesHolder propertyValuesHolderOfKeyframe = PropertyValuesHolder.ofKeyframe(strMY, (Keyframe[]) this.Cc.toArray(new Keyframe[0]));
        TypeEvaluator typeEvaluatorVCE = vCE();
        if (typeEvaluatorVCE != null) {
            propertyValuesHolderOfKeyframe.setEvaluator(typeEvaluatorVCE);
        }
        this.vCE.add(propertyValuesHolderOfKeyframe);
        return this.vCE;
    }

    public void EO() {
        Map<Float, String> map = this.EO;
        if (map == null || map.size() <= 0) {
            return;
        }
        Map<Float, String> map2 = this.EO;
        if (map2 instanceof TreeMap) {
            Float f4 = (Float) ((TreeMap) map2).lastKey();
            if (f4.floatValue() != 100.0f) {
                IlO(100.0f, this.EO.get(f4));
            }
        }
    }

    public abstract void IlO(float f4, String str);

    public boolean IlO() {
        Map<Float, String> map = this.EO;
        if (map == null || map.size() <= 0) {
            return false;
        }
        return this.EO.containsKey(Float.valueOf(0.0f));
    }

    public abstract void MY();

    public void tV() {
        Map<Float, String> map = this.EO;
        if (map == null || map.size() <= 0) {
            return;
        }
        if (!IlO()) {
            MY();
        }
        for (Map.Entry<Float, String> entry : this.EO.entrySet()) {
            if (entry != null) {
                IlO(entry.getKey().floatValue() / 100.0f, entry.getValue());
            }
        }
        EO();
    }

    public abstract TypeEvaluator vCE();
}
