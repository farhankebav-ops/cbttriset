package com.bytedance.adsdk.ugeno.IlO.MY;

import android.animation.ArgbEvaluator;
import android.animation.IntEvaluator;
import android.animation.Keyframe;
import android.animation.TypeEvaluator;
import android.content.Context;
import java.util.TreeMap;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class EO extends IlO {
    public EO(Context context, com.bytedance.adsdk.ugeno.MY.EO eo, String str, TreeMap<Float, String> treeMap) {
        super(context, eo, str, treeMap);
    }

    @Override // com.bytedance.adsdk.ugeno.IlO.MY.IlO
    public void IlO(float f4, String str) {
        this.Cc.add(this.tV == com.bytedance.adsdk.ugeno.IlO.tV.BACKGROUND_COLOR ? Keyframe.ofInt(f4, com.bytedance.adsdk.ugeno.Bc.IlO.IlO(str)) : Keyframe.ofInt(f4, com.bytedance.adsdk.ugeno.Bc.EO.IlO(str, 0)));
    }

    @Override // com.bytedance.adsdk.ugeno.IlO.MY.IlO
    public void MY() {
        if (this.tV == com.bytedance.adsdk.ugeno.IlO.tV.BACKGROUND_COLOR) {
            this.Cc.add(Keyframe.ofInt(0.0f, this.Bc.DM()));
        }
    }

    @Override // com.bytedance.adsdk.ugeno.IlO.MY.IlO
    public TypeEvaluator vCE() {
        return this.tV == com.bytedance.adsdk.ugeno.IlO.tV.BACKGROUND_COLOR ? new ArgbEvaluator() : new IntEvaluator();
    }
}
