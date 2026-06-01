package com.bytedance.sdk.component.MY.IlO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class rp {
    public EV IlO;
    public com.bytedance.sdk.component.EO.IlO.IlO MY = new com.bytedance.sdk.component.EO.IlO.IlO();

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class IlO {
        int Bc;
        Object Cc;
        Bc EO;
        com.bytedance.sdk.component.MY.IlO.IlO IlO;
        Map<String, List<String>> MY;
        String lEW;
        String tV;
        hp vCE;

        public IlO() {
            this.MY = new HashMap();
        }

        public IlO IlO(com.bytedance.sdk.component.MY.IlO.IlO ilO) {
            this.IlO = ilO;
            return this;
        }

        public IlO MY(String str) {
            return IlO(Bc.EO(str));
        }

        public IlO IlO(String str) {
            this.lEW = str;
            return this;
        }

        public IlO MY(String str, String str2) {
            if (!this.MY.containsKey(str)) {
                this.MY.put(str, new ArrayList());
            }
            this.MY.get(str).add(str2);
            return this;
        }

        public IlO(rp rpVar) {
            this.EO = rpVar.MY();
            this.tV = rpVar.EO();
            this.MY = rpVar.tV();
            this.Cc = rpVar.IlO();
            this.vCE = rpVar.lEW();
            this.IlO = rpVar.Cc();
            this.Bc = rpVar.Bc();
            this.lEW = rpVar.vCE();
        }

        public IlO IlO(int i2) {
            this.Bc = i2;
            return this;
        }

        public IlO IlO(Object obj) {
            this.Cc = obj;
            return this;
        }

        public IlO IlO(Bc bc) {
            this.EO = bc;
            return this;
        }

        public rp MY() {
            return new rp() { // from class: com.bytedance.sdk.component.MY.IlO.rp.IlO.1
                @Override // com.bytedance.sdk.component.MY.IlO.rp
                public int Bc() {
                    return IlO.this.Bc;
                }

                @Override // com.bytedance.sdk.component.MY.IlO.rp
                public com.bytedance.sdk.component.MY.IlO.IlO Cc() {
                    return IlO.this.IlO;
                }

                @Override // com.bytedance.sdk.component.MY.IlO.rp
                public String EO() {
                    return IlO.this.tV;
                }

                @Override // com.bytedance.sdk.component.MY.IlO.rp
                public Object IlO() {
                    return IlO.this.Cc;
                }

                @Override // com.bytedance.sdk.component.MY.IlO.rp
                public Bc MY() {
                    return IlO.this.EO;
                }

                @Override // com.bytedance.sdk.component.MY.IlO.rp
                public hp lEW() {
                    return IlO.this.vCE;
                }

                @Override // com.bytedance.sdk.component.MY.IlO.rp
                public Map tV() {
                    return IlO.this.MY;
                }

                public String toString() {
                    return "";
                }

                @Override // com.bytedance.sdk.component.MY.IlO.rp
                public String vCE() {
                    return IlO.this.lEW;
                }
            };
        }

        public IlO IlO(String str, String str2) {
            return MY(str, str2);
        }

        public IlO IlO() {
            return IlO("GET", (hp) null);
        }

        private IlO IlO(String str, hp hpVar) {
            this.tV = str;
            this.vCE = hpVar;
            return this;
        }

        public IlO IlO(hp hpVar) {
            return IlO("POST", hpVar);
        }
    }

    public abstract int Bc();

    public abstract com.bytedance.sdk.component.MY.IlO.IlO Cc();

    public IlO DmF() {
        return new IlO(this);
    }

    public abstract String EO();

    public abstract Object IlO();

    public void IlO(EV ev) {
        this.IlO = ev;
    }

    public abstract Bc MY();

    public hp lEW() {
        return null;
    }

    public abstract Map<String, List<String>> tV();

    public abstract String vCE();
}
