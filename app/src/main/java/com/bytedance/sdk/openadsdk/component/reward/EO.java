package com.bytedance.sdk.openadsdk.component.reward;

import android.os.CountDownTimer;
import com.bytedance.sdk.openadsdk.core.model.oeT;
import com.bytedance.sdk.openadsdk.core.rp.tV.IlO;
import com.bytedance.sdk.openadsdk.tV.Cc.MY.ea;
import r.c;
import v.a;
import w.b;
import w.e;
import w.g;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class EO implements e {
    private final oeT Bc;
    private boolean Cc;
    private IlO.InterfaceC0108IlO DmF;
    private final IlO IlO;
    private final a lEW;
    private long vCE;
    private boolean MY = true;
    private long EO = 0;
    private boolean tV = false;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class IlO implements c {
        private final a Bc;
        private b Cc;
        private long DmF;
        private int EO = 0;
        private final long IlO;
        private long MY;
        private final com.bytedance.sdk.openadsdk.tV.Bc lEW;
        private CountDownTimer tV;
        private long vCE;

        public IlO(long j, a aVar, com.bytedance.sdk.openadsdk.tV.Bc bc) {
            this.IlO = j;
            this.Bc = aVar;
            this.lEW = bc;
        }

        @Override // r.c
        public boolean Bc() {
            return this.EO == 2;
        }

        @Override // r.c
        public int Cc() {
            return 0;
        }

        public long DmF() {
            return this.DmF;
        }

        @Override // r.c
        public boolean EO() {
            return false;
        }

        public void EV() {
            this.EO = 2;
            this.MY = this.vCE;
            CountDownTimer countDownTimer = this.tV;
            if (countDownTimer != null) {
                countDownTimer.cancel();
                this.tV = null;
            }
        }

        @Override // r.c
        public boolean IlO() {
            return false;
        }

        @Override // r.c
        public boolean MY() {
            return false;
        }

        public void NV() {
            if (this.EO == 1) {
                return;
            }
            this.EO = 1;
            final long jEa = ea();
            final long j = jEa - this.MY;
            CountDownTimer countDownTimer = new CountDownTimer(j, 200L) { // from class: com.bytedance.sdk.openadsdk.component.reward.EO.IlO.1
                @Override // android.os.CountDownTimer
                public void onFinish() {
                    IlO.this.EO = 4;
                    IlO.this.vCE = jEa;
                    if (IlO.this.Cc != null) {
                        IlO.this.Cc.IlO(IlO.this.zPa(), 100);
                    }
                    ea.IlO ilO = new ea.IlO();
                    ilO.MY(jEa);
                    ilO.tV(jEa);
                    ilO.EO(IlO.this.hp());
                    ilO.tV(IlO.this.bWL());
                    ilO.IlO(IlO.this.DmF());
                    com.bytedance.sdk.openadsdk.tV.Cc.IlO.IlO.MY(IlO.this.Bc, ilO, IlO.this.lEW);
                }

                @Override // android.os.CountDownTimer
                public void onTick(long j3) {
                    long j8 = (j - j3) + IlO.this.MY;
                    IlO.this.vCE = j8;
                    if (IlO.this.Cc != null) {
                        IlO.this.Cc.IlO(j8, jEa);
                    }
                }
            };
            this.tV = countDownTimer;
            countDownTimer.start();
        }

        public int bWL() {
            return 0;
        }

        public long ea() {
            return this.IlO;
        }

        public long hp() {
            return 0L;
        }

        @Override // r.c
        public boolean lEW() {
            return this.EO == 0;
        }

        public void rp() {
            this.EO = 0;
            CountDownTimer countDownTimer = this.tV;
            if (countDownTimer != null) {
                countDownTimer.cancel();
                this.tV = null;
            }
            if (this.Cc != null) {
                this.Cc = null;
            }
        }

        @Override // r.c
        public int tV() {
            return 0;
        }

        public long zPa() {
            return this.vCE;
        }

        @Override // r.c
        public boolean vCE() {
            return this.EO == 1;
        }

        public void MY(long j) {
            this.MY = j;
        }

        public void IlO(long j) {
            this.DmF = j;
        }

        public void IlO(b bVar) {
            this.Cc = bVar;
        }
    }

    public EO(oeT oet, com.bytedance.sdk.openadsdk.tV.Bc bc) {
        a aVar = new a() { // from class: com.bytedance.sdk.openadsdk.component.reward.EO.1
        };
        this.lEW = aVar;
        this.Bc = oet;
        com.bykv.vk.openvk.IlO.IlO.IlO.EO.c cVarFdM = oet.fdM();
        long j = 10;
        long j3 = cVarFdM != null ? (long) cVarFdM.f4688d : 10L;
        if (j3 <= 0) {
            cVarFdM.f4688d = 10.0d;
        } else {
            j = j3;
        }
        this.IlO = new IlO(j * 1000, aVar, bc);
    }

    @Override // w.e
    public int Bc() {
        return 0;
    }

    @Override // w.e
    public long Cc() {
        return this.IlO.zPa();
    }

    @Override // w.e
    public int DmF() {
        return e0.a.a(this.IlO.vCE, this.IlO.IlO);
    }

    @Override // w.e
    public void EO() {
        this.IlO.rp();
    }

    @Override // w.e
    public g EV() {
        return null;
    }

    @Override // w.e
    public boolean IlO(float f4) {
        return false;
    }

    @Override // w.e
    public void MY() {
        this.IlO.NV();
        ea.IlO ilO = new ea.IlO();
        ilO.MY(Cc());
        ilO.tV(lEW());
        ilO.EO(vCE());
        com.bytedance.sdk.openadsdk.tV.Cc.IlO.IlO.MY(this.lEW, ilO);
        IlO.InterfaceC0108IlO interfaceC0108IlO = this.DmF;
        if (interfaceC0108IlO != null) {
            interfaceC0108IlO.IlO(1);
        }
    }

    @Override // w.e
    public c NV() {
        return this.IlO;
    }

    @Override // w.e
    public boolean bWL() {
        return false;
    }

    public long ea() {
        return this.vCE;
    }

    @Override // w.e
    public boolean hp() {
        return false;
    }

    @Override // w.e
    public long lEW() {
        return this.IlO.ea();
    }

    @Override // w.e
    public boolean rp() {
        return this.Cc;
    }

    @Override // w.e
    public void tV() {
        EO();
    }

    @Override // w.e
    public long vCE() {
        return 0L;
    }

    public a zPa() {
        return this.lEW;
    }

    @Override // w.e
    public void IlO(long j) {
        this.vCE = j;
        IlO ilO = this.IlO;
        if (ilO != null) {
            ilO.IlO(j);
        }
    }

    @Override // w.e
    public void IlO() {
        this.IlO.EV();
        ea.IlO ilO = new ea.IlO();
        ilO.MY(Cc());
        ilO.tV(lEW());
        ilO.EO(vCE());
        ilO.IlO(ea());
        com.bytedance.sdk.openadsdk.tV.Cc.IlO.IlO.IlO(this.lEW, ilO);
        IlO.InterfaceC0108IlO interfaceC0108IlO = this.DmF;
        if (interfaceC0108IlO != null) {
            interfaceC0108IlO.IlO(2);
        }
    }

    public void IlO(boolean z2, int i2) {
        EO();
    }

    @Override // w.e
    public boolean IlO(com.bykv.vk.openvk.IlO.IlO.IlO.EO.a aVar) {
        this.tV = aVar.EV();
        if (aVar.NV() > 0) {
            this.IlO.MY(aVar.NV());
        }
        aVar.MY(com.bytedance.sdk.openadsdk.AXM.IlO.IlO("player_force_raw_url", 0) == 1);
        com.bytedance.sdk.openadsdk.tV.Cc.IlO.IlO.IlO(this.Bc, this.lEW, aVar);
        this.IlO.NV();
        return true;
    }

    @Override // w.e
    public void IlO(boolean z2, String str) {
        this.tV = z2;
    }

    @Override // w.e
    public void IlO(b bVar) {
        this.IlO.IlO(bVar);
    }

    public void IlO(IlO.InterfaceC0108IlO interfaceC0108IlO) {
        this.DmF = interfaceC0108IlO;
    }
}
