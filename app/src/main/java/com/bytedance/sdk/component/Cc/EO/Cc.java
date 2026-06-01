package com.bytedance.sdk.component.Cc.EO;

import android.content.Context;
import com.bytedance.sdk.component.Cc.AXM;
import com.bytedance.sdk.component.Cc.cl;
import com.bytedance.sdk.component.Cc.es;
import com.bytedance.sdk.component.Cc.hp;
import com.bytedance.sdk.component.Cc.oeT;
import com.bytedance.sdk.component.Cc.rp;
import java.util.concurrent.ExecutorService;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class Cc implements hp {
    private com.bytedance.sdk.component.Cc.MY Bc;
    private es Cc;
    private oeT DmF;
    private com.bytedance.sdk.component.Cc.tV EO;
    private rp IlO;
    private ExecutorService MY;
    private boolean NV;
    private AXM lEW;
    private cl tV;
    private com.bytedance.sdk.component.Cc.EO vCE;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class IlO {
        private com.bytedance.sdk.component.Cc.MY Bc;
        private es Cc;
        private oeT DmF;
        private com.bytedance.sdk.component.Cc.tV EO;
        private rp IlO;
        private ExecutorService MY;
        private boolean NV;
        private AXM lEW;
        private cl tV;
        private com.bytedance.sdk.component.Cc.EO vCE;

        public IlO IlO(com.bytedance.sdk.component.Cc.MY my) {
            this.Bc = my;
            return this;
        }

        public IlO IlO(oeT oet) {
            this.DmF = oet;
            return this;
        }

        public IlO IlO(AXM axm) {
            this.lEW = axm;
            return this;
        }

        public IlO IlO(com.bytedance.sdk.component.Cc.tV tVVar) {
            this.EO = tVVar;
            return this;
        }

        public IlO IlO(boolean z2) {
            this.NV = z2;
            return this;
        }

        public Cc IlO() {
            return new Cc(this);
        }
    }

    @Override // com.bytedance.sdk.component.Cc.hp
    public com.bytedance.sdk.component.Cc.EO Bc() {
        return this.vCE;
    }

    @Override // com.bytedance.sdk.component.Cc.hp
    public cl Cc() {
        return this.tV;
    }

    @Override // com.bytedance.sdk.component.Cc.hp
    public oeT DmF() {
        return this.DmF;
    }

    @Override // com.bytedance.sdk.component.Cc.hp
    public AXM EO() {
        return this.lEW;
    }

    @Override // com.bytedance.sdk.component.Cc.hp
    public rp IlO() {
        return this.IlO;
    }

    @Override // com.bytedance.sdk.component.Cc.hp
    public ExecutorService MY() {
        return this.MY;
    }

    @Override // com.bytedance.sdk.component.Cc.hp
    public boolean NV() {
        return this.NV;
    }

    @Override // com.bytedance.sdk.component.Cc.hp
    public com.bytedance.sdk.component.Cc.MY lEW() {
        return this.Bc;
    }

    @Override // com.bytedance.sdk.component.Cc.hp
    public com.bytedance.sdk.component.Cc.tV tV() {
        return this.EO;
    }

    @Override // com.bytedance.sdk.component.Cc.hp
    public es vCE() {
        return this.Cc;
    }

    private Cc(IlO ilO) {
        this.IlO = ilO.IlO;
        this.MY = ilO.MY;
        this.EO = ilO.EO;
        this.tV = ilO.tV;
        this.Cc = ilO.Cc;
        this.vCE = ilO.vCE;
        this.Bc = ilO.Bc;
        this.lEW = ilO.lEW;
        this.DmF = ilO.DmF;
        this.NV = ilO.NV;
    }

    public static Cc IlO(Context context) {
        return new IlO().IlO();
    }
}
