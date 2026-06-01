package com.bytedance.adsdk.ugeno.yoga;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
@com.bytedance.adsdk.ugeno.yoga.IlO.IlO
public abstract class YogaNodeJNIBase extends NV implements Cloneable {
    private boolean Bc;
    private MY Cc;
    private List<YogaNodeJNIBase> EO;
    protected long IlO;
    private YogaNodeJNIBase MY;

    @com.bytedance.adsdk.ugeno.yoga.IlO.IlO
    private float[] arr;

    @com.bytedance.adsdk.ugeno.yoga.IlO.IlO
    private int mLayoutDirection;
    private Bc tV;
    private Object vCE;

    private YogaNodeJNIBase(long j) {
        this.arr = null;
        this.mLayoutDirection = 0;
        this.Bc = true;
        if (j == 0) {
            throw new IllegalStateException("Failed to allocate native memory");
        }
        this.IlO = j;
    }

    @com.bytedance.adsdk.ugeno.yoga.IlO.IlO
    private final long replaceChild(YogaNodeJNIBase yogaNodeJNIBase, int i2) {
        List<YogaNodeJNIBase> list = this.EO;
        if (list == null) {
            throw new IllegalStateException("Cannot replace child. YogaNode does not have children");
        }
        list.remove(i2);
        this.EO.add(i2, yogaNodeJNIBase);
        yogaNodeJNIBase.MY = this;
        return yogaNodeJNIBase.IlO;
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.NV
    public void Bc(float f4) {
        YogaNative.jni_YGNodeStyleSetHeightPercentJNI(this.IlO, f4);
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.NV
    public void Cc(float f4) {
        YogaNative.jni_YGNodeStyleSetWidthPercentJNI(this.IlO, f4);
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.NV
    public void DmF(float f4) {
        YogaNative.jni_YGNodeStyleSetMinHeightJNI(this.IlO, f4);
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.NV
    /* JADX INFO: renamed from: EO, reason: merged with bridge method [inline-methods] */
    public YogaNodeJNIBase IlO(int i2) {
        List<YogaNodeJNIBase> list = this.EO;
        if (list != null) {
            return list.get(i2);
        }
        throw new IllegalStateException("YogaNode does not have children");
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.NV
    /* JADX INFO: renamed from: EV, reason: merged with bridge method [inline-methods] */
    public YogaNodeJNIBase MY() {
        return this.MY;
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.NV
    public void NV(float f4) {
        YogaNative.jni_YGNodeStyleSetMaxWidthJNI(this.IlO, f4);
    }

    @com.bytedance.adsdk.ugeno.yoga.IlO.IlO
    public final float baseline(float f4, float f8) {
        return this.Cc.IlO(this, f4, f8);
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.NV
    public void lEW(float f4) {
        YogaNative.jni_YGNodeStyleSetMinWidthJNI(this.IlO, f4);
    }

    @com.bytedance.adsdk.ugeno.yoga.IlO.IlO
    public final long measure(float f4, int i2, float f8, int i8) {
        if (rp()) {
            return this.tV.IlO(this, f4, lEW.IlO(i2), f8, lEW.IlO(i8));
        }
        throw new RuntimeException("Measure function isn't defined!");
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.NV
    public void rp(float f4) {
        YogaNative.jni_YGNodeStyleSetAspectRatioJNI(this.IlO, f4);
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.NV
    /* JADX INFO: renamed from: tV, reason: merged with bridge method [inline-methods] */
    public YogaNodeJNIBase MY(int i2) {
        List<YogaNodeJNIBase> list = this.EO;
        if (list == null) {
            throw new IllegalStateException("Trying to remove a child of a YogaNode that does not have children");
        }
        YogaNodeJNIBase yogaNodeJNIBaseRemove = list.remove(i2);
        yogaNodeJNIBaseRemove.MY = null;
        YogaNative.jni_YGNodeRemoveChildJNI(this.IlO, yogaNodeJNIBaseRemove.IlO);
        return yogaNodeJNIBaseRemove;
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.NV
    public void vCE(float f4) {
        YogaNative.jni_YGNodeStyleSetHeightJNI(this.IlO, f4);
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.NV
    public float Bc() {
        float[] fArr = this.arr;
        if (fArr != null) {
            return fArr[4];
        }
        return 0.0f;
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.NV
    public void Cc() {
        YogaNative.jni_YGNodeStyleSetHeightAutoJNI(this.IlO);
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.NV
    public float DmF() {
        float[] fArr = this.arr;
        if (fArr != null) {
            return fArr[2];
        }
        return 0.0f;
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.NV
    public void EV(float f4) {
        YogaNative.jni_YGNodeStyleSetMaxHeightJNI(this.IlO, f4);
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.NV
    public int IlO() {
        List<YogaNodeJNIBase> list = this.EO;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.NV
    public Object NV() {
        return this.vCE;
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.NV
    public float lEW() {
        float[] fArr = this.arr;
        if (fArr != null) {
            return fArr[1];
        }
        return 0.0f;
    }

    public boolean rp() {
        return this.tV != null;
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.NV
    public float vCE() {
        float[] fArr = this.arr;
        if (fArr != null) {
            return fArr[3];
        }
        return 0.0f;
    }

    private void MY(NV nv) {
        NV();
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.NV
    public void IlO(NV nv, int i2) {
        if (nv instanceof YogaNodeJNIBase) {
            YogaNodeJNIBase yogaNodeJNIBase = (YogaNodeJNIBase) nv;
            if (yogaNodeJNIBase.MY == null) {
                if (this.EO == null) {
                    this.EO = new ArrayList(4);
                }
                this.EO.add(i2, yogaNodeJNIBase);
                yogaNodeJNIBase.MY = this;
                YogaNative.jni_YGNodeInsertChildJNI(this.IlO, yogaNodeJNIBase.IlO, i2);
                return;
            }
            throw new IllegalStateException("Child already has a parent, it must be removed first.");
        }
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.NV
    public void EO(IlO ilO) {
        YogaNative.jni_YGNodeStyleSetAlignContentJNI(this.IlO, ilO.IlO());
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.NV
    public void MY(IlO ilO) {
        YogaNative.jni_YGNodeStyleSetAlignSelfJNI(this.IlO, ilO.IlO());
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.NV
    public void EO(float f4) {
        YogaNative.jni_YGNodeStyleSetFlexBasisJNI(this.IlO, f4);
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.NV
    public void MY(float f4) {
        YogaNative.jni_YGNodeStyleSetFlexShrinkJNI(this.IlO, f4);
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.NV
    public void EO() {
        YogaNative.jni_YGNodeStyleSetFlexBasisAutoJNI(this.IlO);
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.NV
    public void MY(tV tVVar, float f4) {
        YogaNative.jni_YGNodeStyleSetPaddingJNI(this.IlO, tVVar.IlO(), f4);
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.NV
    public void tV(float f4) {
        YogaNative.jni_YGNodeStyleSetWidthJNI(this.IlO, f4);
    }

    public YogaNodeJNIBase() {
        this(YogaNative.jni_YGNodeNewJNI());
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.NV
    public void EO(tV tVVar, float f4) {
        YogaNative.jni_YGNodeStyleSetPositionJNI(this.IlO, tVVar.IlO(), f4);
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.NV
    public void tV() {
        YogaNative.jni_YGNodeStyleSetWidthAutoJNI(this.IlO);
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.NV
    public int IlO(NV nv) {
        List<YogaNodeJNIBase> list = this.EO;
        if (list == null) {
            return -1;
        }
        return list.indexOf(nv);
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.NV
    public void IlO(float f4, float f8) {
        MY((NV) null);
        ArrayList arrayList = new ArrayList();
        arrayList.add(this);
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            YogaNodeJNIBase yogaNodeJNIBase = (YogaNodeJNIBase) arrayList.get(i2);
            List<YogaNodeJNIBase> list = yogaNodeJNIBase.EO;
            if (list != null) {
                for (YogaNodeJNIBase yogaNodeJNIBase2 : list) {
                    yogaNodeJNIBase2.MY(yogaNodeJNIBase);
                    arrayList.add(yogaNodeJNIBase2);
                }
            }
        }
        YogaNodeJNIBase[] yogaNodeJNIBaseArr = (YogaNodeJNIBase[]) arrayList.toArray(new YogaNodeJNIBase[arrayList.size()]);
        long[] jArr = new long[yogaNodeJNIBaseArr.length];
        for (int i8 = 0; i8 < yogaNodeJNIBaseArr.length; i8++) {
            jArr[i8] = yogaNodeJNIBaseArr[i8].IlO;
        }
        YogaNative.jni_YGNodeCalculateLayoutJNI(this.IlO, f4, f8, jArr, yogaNodeJNIBaseArr);
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.NV
    public void IlO(EO eo) {
        YogaNative.jni_YGNodeStyleSetDirectionJNI(this.IlO, eo.IlO());
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.NV
    public void IlO(Cc cc) {
        YogaNative.jni_YGNodeStyleSetFlexDirectionJNI(this.IlO, cc.IlO());
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.NV
    public void IlO(vCE vce) {
        YogaNative.jni_YGNodeStyleSetJustifyContentJNI(this.IlO, vce.IlO());
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.NV
    public void IlO(IlO ilO) {
        YogaNative.jni_YGNodeStyleSetAlignItemsJNI(this.IlO, ilO.IlO());
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.NV
    public void IlO(hp hpVar) {
        YogaNative.jni_YGNodeStyleSetPositionTypeJNI(this.IlO, hpVar.IlO());
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.NV
    public void IlO(bWL bwl) {
        YogaNative.jni_YGNodeStyleSetFlexWrapJNI(this.IlO, bwl.IlO());
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.NV
    public void IlO(float f4) {
        YogaNative.jni_YGNodeStyleSetFlexGrowJNI(this.IlO, f4);
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.NV
    public void IlO(tV tVVar, float f4) {
        YogaNative.jni_YGNodeStyleSetMarginJNI(this.IlO, tVVar.IlO(), f4);
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.NV
    public void IlO(Bc bc) {
        this.tV = bc;
        YogaNative.jni_YGNodeSetHasMeasureFuncJNI(this.IlO, bc != null);
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.NV
    public void IlO(boolean z2) {
        YogaNative.jni_YGNodeSetAlwaysFormsContainingBlockJNI(this.IlO, z2);
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.NV
    public void IlO(Object obj) {
        this.vCE = obj;
    }
}
