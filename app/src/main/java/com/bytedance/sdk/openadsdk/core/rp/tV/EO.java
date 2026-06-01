package com.bytedance.sdk.openadsdk.core.rp.tV;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import r.b;
import r.c;
import z.n;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class EO extends n {
    private final IlO tV;
    private final List<MY> IlO = Collections.synchronizedList(new ArrayList());
    private int MY = 1;
    private int EO = 1;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public interface MY extends b {
        @Override // r.b
        /* synthetic */ void Cc(c cVar);

        @Override // r.b
        /* synthetic */ void EO(c cVar);

        void IlO(int i2, int i8);

        @Override // r.b
        /* synthetic */ void IlO(c cVar);

        @Override // r.b
        /* synthetic */ void IlO(c cVar, int i2);

        @Override // r.b
        /* synthetic */ void IlO(c cVar, int i2, int i8);

        @Override // r.b
        /* synthetic */ void IlO(c cVar, int i2, int i8, int i9);

        @Override // r.b
        /* synthetic */ void IlO(c cVar, long j);

        @Override // r.b
        /* synthetic */ void IlO(c cVar, long j, long j3);

        @Override // r.b
        /* synthetic */ void IlO(c cVar, com.bykv.vk.openvk.IlO.IlO.IlO.EO.b bVar);

        @Override // r.b
        /* synthetic */ void IlO(c cVar, boolean z2);

        @Override // r.b
        /* synthetic */ void MY(c cVar);

        @Override // r.b
        /* synthetic */ void MY(c cVar, int i2);

        @Override // r.b
        /* synthetic */ void tV(c cVar);
    }

    public EO() {
        IlO ilO = new IlO();
        this.tV = ilO;
        super.IlO(ilO);
        IlO(500);
    }

    public static /* synthetic */ int IlO(EO eo) {
        int i2 = eo.EO;
        eo.EO = i2 + 1;
        return i2;
    }

    @Override // z.n
    public long cl() {
        return (((long) (this.EO - 1)) * super.zPa()) + super.cl();
    }

    public int xF() {
        return this.EO;
    }

    @Override // z.n
    public long zPa() {
        return super.zPa() * ((long) this.MY);
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class IlO implements b {
        private IlO() {
        }

        @Override // r.b
        public void Cc(c cVar) {
            Iterator it = EO.this.IlO.iterator();
            while (it.hasNext()) {
                ((MY) it.next()).Cc(cVar);
            }
        }

        @Override // r.b
        public void EO(c cVar) {
            Iterator it = EO.this.IlO.iterator();
            while (it.hasNext()) {
                ((MY) it.next()).EO(cVar);
            }
        }

        @Override // r.b
        public void IlO(c cVar) {
            EO.IlO(EO.this);
            if (EO.this.EO > EO.this.MY) {
                Iterator it = EO.this.IlO.iterator();
                while (it.hasNext()) {
                    ((MY) it.next()).IlO(cVar);
                }
            } else {
                Iterator it2 = EO.this.IlO.iterator();
                while (it2.hasNext()) {
                    ((MY) it2.next()).IlO(EO.this.EO, EO.this.MY);
                }
                EO.this.DmF();
            }
        }

        @Override // r.b
        public void MY(c cVar) {
            Iterator it = EO.this.IlO.iterator();
            while (it.hasNext()) {
                ((MY) it.next()).MY(cVar);
            }
        }

        @Override // r.b
        public void tV(c cVar) {
            Iterator it = EO.this.IlO.iterator();
            while (it.hasNext()) {
                ((MY) it.next()).tV(cVar);
            }
        }

        @Override // r.b
        public void MY(c cVar, int i2) {
            Iterator it = EO.this.IlO.iterator();
            while (it.hasNext()) {
                ((MY) it.next()).MY(cVar, i2);
            }
        }

        @Override // r.b
        public void IlO(c cVar, long j) {
            Iterator it = EO.this.IlO.iterator();
            while (it.hasNext()) {
                ((MY) it.next()).IlO(cVar, j);
            }
        }

        @Override // r.b
        public void IlO(c cVar, com.bykv.vk.openvk.IlO.IlO.IlO.EO.b bVar) {
            Iterator it = EO.this.IlO.iterator();
            while (it.hasNext()) {
                ((MY) it.next()).IlO(cVar, bVar);
            }
        }

        @Override // r.b
        public void IlO(c cVar, boolean z2) {
            Iterator it = EO.this.IlO.iterator();
            while (it.hasNext()) {
                ((MY) it.next()).IlO(cVar, z2);
            }
        }

        @Override // r.b
        public void IlO(c cVar, int i2, int i8) {
            Iterator it = EO.this.IlO.iterator();
            while (it.hasNext()) {
                ((MY) it.next()).IlO(cVar, i2, i8);
            }
        }

        @Override // r.b
        public void IlO(c cVar, int i2, int i8, int i9) {
            Iterator it = EO.this.IlO.iterator();
            while (it.hasNext()) {
                ((MY) it.next()).IlO(cVar, i2, i8, i9);
            }
        }

        @Override // r.b
        public void IlO(c cVar, int i2) {
            Iterator it = EO.this.IlO.iterator();
            while (it.hasNext()) {
                ((MY) it.next()).IlO(cVar, i2);
            }
        }

        @Override // r.b
        public void IlO(c cVar, long j, long j3) {
            Iterator it = EO.this.IlO.iterator();
            while (it.hasNext()) {
                ((MY) it.next()).IlO(cVar, j, j3);
            }
        }
    }

    public void EO(int i2) {
        this.MY = Math.max(1, i2);
    }

    @Override // z.n
    public void IlO(b bVar) {
        if (!(bVar instanceof MY)) {
            super.IlO(bVar);
        } else {
            if (this.IlO.contains(bVar)) {
                return;
            }
            this.IlO.add((MY) bVar);
        }
    }
}
