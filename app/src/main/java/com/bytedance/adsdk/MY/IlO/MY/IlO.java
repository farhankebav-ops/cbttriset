package com.bytedance.adsdk.MY.IlO.MY;

import android.view.animation.Interpolator;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class IlO<K, A> {
    private final EO<K> Cc;
    protected com.bytedance.adsdk.MY.Bc.MY<A> EO;
    final List<InterfaceC0025IlO> IlO = new ArrayList(1);
    private boolean tV = false;
    protected float MY = 0.0f;
    private A vCE = null;
    private float Bc = -1.0f;
    private float lEW = -1.0f;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Cc<T> implements EO<T> {
        private final com.bytedance.adsdk.MY.Bc.IlO<T> IlO;
        private float MY = -1.0f;

        public Cc(List<? extends com.bytedance.adsdk.MY.Bc.IlO<T>> list) {
            this.IlO = list.get(0);
        }

        @Override // com.bytedance.adsdk.MY.IlO.MY.IlO.EO
        public float EO() {
            return this.IlO.EO();
        }

        @Override // com.bytedance.adsdk.MY.IlO.MY.IlO.EO
        public boolean IlO() {
            return false;
        }

        @Override // com.bytedance.adsdk.MY.IlO.MY.IlO.EO
        public com.bytedance.adsdk.MY.Bc.IlO<T> MY() {
            return this.IlO;
        }

        @Override // com.bytedance.adsdk.MY.IlO.MY.IlO.EO
        public float tV() {
            return this.IlO.tV();
        }

        @Override // com.bytedance.adsdk.MY.IlO.MY.IlO.EO
        public boolean IlO(float f4) {
            return !this.IlO.Cc();
        }

        @Override // com.bytedance.adsdk.MY.IlO.MY.IlO.EO
        public boolean MY(float f4) {
            if (this.MY == f4) {
                return true;
            }
            this.MY = f4;
            return false;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public interface EO<T> {
        float EO();

        boolean IlO();

        boolean IlO(float f4);

        com.bytedance.adsdk.MY.Bc.IlO<T> MY();

        boolean MY(float f4);

        float tV();
    }

    /* JADX INFO: renamed from: com.bytedance.adsdk.MY.IlO.MY.IlO$IlO, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public interface InterfaceC0025IlO {
        void IlO();
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class MY<T> implements EO<T> {
        private MY() {
        }

        @Override // com.bytedance.adsdk.MY.IlO.MY.IlO.EO
        public float EO() {
            return 0.0f;
        }

        @Override // com.bytedance.adsdk.MY.IlO.MY.IlO.EO
        public boolean IlO() {
            return true;
        }

        @Override // com.bytedance.adsdk.MY.IlO.MY.IlO.EO
        public com.bytedance.adsdk.MY.Bc.IlO<T> MY() {
            throw new IllegalStateException("not implemented");
        }

        @Override // com.bytedance.adsdk.MY.IlO.MY.IlO.EO
        public float tV() {
            return 1.0f;
        }

        @Override // com.bytedance.adsdk.MY.IlO.MY.IlO.EO
        public boolean IlO(float f4) {
            return false;
        }

        @Override // com.bytedance.adsdk.MY.IlO.MY.IlO.EO
        public boolean MY(float f4) {
            throw new IllegalStateException("not implemented");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class tV<T> implements EO<T> {
        private final List<? extends com.bytedance.adsdk.MY.Bc.IlO<T>> IlO;
        private com.bytedance.adsdk.MY.Bc.IlO<T> EO = null;
        private float tV = -1.0f;
        private com.bytedance.adsdk.MY.Bc.IlO<T> MY = EO(0.0f);

        public tV(List<? extends com.bytedance.adsdk.MY.Bc.IlO<T>> list) {
            this.IlO = list;
        }

        private com.bytedance.adsdk.MY.Bc.IlO<T> EO(float f4) {
            com.bytedance.adsdk.MY.Bc.IlO<T> ilO = this.IlO.get(r0.size() - 1);
            if (f4 >= ilO.EO()) {
                return ilO;
            }
            for (int size = this.IlO.size() - 2; size > 0; size--) {
                com.bytedance.adsdk.MY.Bc.IlO<T> ilO2 = this.IlO.get(size);
                if (this.MY != ilO2 && ilO2.IlO(f4)) {
                    return ilO2;
                }
            }
            return this.IlO.get(0);
        }

        @Override // com.bytedance.adsdk.MY.IlO.MY.IlO.EO
        public boolean IlO() {
            return false;
        }

        @Override // com.bytedance.adsdk.MY.IlO.MY.IlO.EO
        public com.bytedance.adsdk.MY.Bc.IlO<T> MY() {
            return this.MY;
        }

        @Override // com.bytedance.adsdk.MY.IlO.MY.IlO.EO
        public float tV() {
            return this.IlO.get(r0.size() - 1).tV();
        }

        @Override // com.bytedance.adsdk.MY.IlO.MY.IlO.EO
        public boolean IlO(float f4) {
            if (this.MY.IlO(f4)) {
                return !this.MY.Cc();
            }
            this.MY = EO(f4);
            return true;
        }

        @Override // com.bytedance.adsdk.MY.IlO.MY.IlO.EO
        public boolean MY(float f4) {
            com.bytedance.adsdk.MY.Bc.IlO<T> ilO = this.EO;
            com.bytedance.adsdk.MY.Bc.IlO<T> ilO2 = this.MY;
            if (ilO == ilO2 && this.tV == f4) {
                return true;
            }
            this.EO = ilO2;
            this.tV = f4;
            return false;
        }

        @Override // com.bytedance.adsdk.MY.IlO.MY.IlO.EO
        public float EO() {
            return this.IlO.get(0).EO();
        }
    }

    public IlO(List<? extends com.bytedance.adsdk.MY.Bc.IlO<K>> list) {
        this.Cc = IlO(list);
    }

    private float DmF() {
        if (this.Bc == -1.0f) {
            this.Bc = this.Cc.EO();
        }
        return this.Bc;
    }

    public A Bc() {
        float fTV = tV();
        if (this.EO == null && this.Cc.MY(fTV)) {
            return this.vCE;
        }
        com.bytedance.adsdk.MY.Bc.IlO<K> ilOEO = EO();
        Interpolator interpolator = ilOEO.tV;
        A aIlO = (interpolator == null || ilOEO.Cc == null) ? IlO(ilOEO, Cc()) : IlO(ilOEO, fTV, interpolator.getInterpolation(fTV), ilOEO.Cc.getInterpolation(fTV));
        this.vCE = aIlO;
        return aIlO;
    }

    public float Cc() {
        com.bytedance.adsdk.MY.Bc.IlO<K> ilOEO = EO();
        if (ilOEO == null || ilOEO.Cc()) {
            return 0.0f;
        }
        return ilOEO.EO.getInterpolation(tV());
    }

    public com.bytedance.adsdk.MY.Bc.IlO<K> EO() {
        com.bytedance.adsdk.MY.Cc.IlO("BaseKeyframeAnimation#getCurrentKeyframe");
        com.bytedance.adsdk.MY.Bc.IlO<K> ilOMY = this.Cc.MY();
        com.bytedance.adsdk.MY.Cc.MY("BaseKeyframeAnimation#getCurrentKeyframe");
        return ilOMY;
    }

    public abstract A IlO(com.bytedance.adsdk.MY.Bc.IlO<K> ilO, float f4);

    public void IlO() {
        this.tV = true;
    }

    public void MY() {
        for (int i2 = 0; i2 < this.IlO.size(); i2++) {
            this.IlO.get(i2).IlO();
        }
    }

    public float lEW() {
        return this.MY;
    }

    public float tV() {
        if (this.tV) {
            return 0.0f;
        }
        com.bytedance.adsdk.MY.Bc.IlO<K> ilOEO = EO();
        if (ilOEO.Cc()) {
            return 0.0f;
        }
        return (this.MY - ilOEO.EO()) / (ilOEO.tV() - ilOEO.EO());
    }

    public float vCE() {
        if (this.lEW == -1.0f) {
            this.lEW = this.Cc.tV();
        }
        return this.lEW;
    }

    public void IlO(InterfaceC0025IlO interfaceC0025IlO) {
        this.IlO.add(interfaceC0025IlO);
    }

    public void IlO(float f4) {
        if (this.Cc.IlO()) {
            return;
        }
        if (f4 < DmF()) {
            f4 = DmF();
        } else if (f4 > vCE()) {
            f4 = vCE();
        }
        if (f4 == this.MY) {
            return;
        }
        this.MY = f4;
        if (this.Cc.IlO(f4)) {
            MY();
        }
    }

    public A IlO(com.bytedance.adsdk.MY.Bc.IlO<K> ilO, float f4, float f8, float f9) {
        throw new UnsupportedOperationException("This animation does not support split dimensions!");
    }

    private static <T> EO<T> IlO(List<? extends com.bytedance.adsdk.MY.Bc.IlO<T>> list) {
        if (list.isEmpty()) {
            return new MY();
        }
        if (list.size() == 1) {
            return new Cc(list);
        }
        return new tV(list);
    }
}
