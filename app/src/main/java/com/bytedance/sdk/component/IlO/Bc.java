package com.bytedance.sdk.component.IlO;

import com.bytedance.sdk.component.IlO.oeT;
import com.bytedance.sdk.component.IlO.tV;
import com.bytedance.sdk.component.IlO.vAh;
import com.bytedance.sdk.component.IlO.xF;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
class Bc implements vAh.IlO {
    private final hp Bc;
    private final boolean DmF;
    private final lEW IlO;
    private final AXM MY;
    private final com.bytedance.sdk.component.IlO.IlO NV;
    private final boolean lEW;
    private final Map<String, MY> EO = new HashMap();
    private final Map<String, tV.MY> tV = new HashMap();
    private final List<zPa> Cc = new ArrayList();
    private final Set<tV> vCE = new HashSet();

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class IlO {
        boolean IlO;
        String MY;

        private IlO(boolean z2, String str) {
            this.IlO = z2;
            this.MY = str;
        }
    }

    public Bc(NV nv, com.bytedance.sdk.component.IlO.IlO ilO, oeT oet) {
        this.NV = ilO;
        this.IlO = nv.tV;
        AXM axm = new AXM(oet, nv.rp, nv.hp);
        this.MY = axm;
        axm.IlO(this);
        axm.IlO(nv.zPa);
        this.Bc = nv.DmF;
        this.lEW = nv.lEW;
        this.DmF = nv.ea;
    }

    private kBB MY(String str, MY my) {
        return this.DmF ? kBB.PRIVATE : this.MY.IlO(this.lEW, str, my);
    }

    public IlO IlO(zPa zpa, vCE vce) throws Exception {
        MY my = this.EO.get(zpa.tV);
        if (my != null) {
            try {
                kBB kbbMY = MY(vce.MY, my);
                vce.tV = kbbMY;
                if (kbbMY == null) {
                    zpa.toString();
                    throw new es(-1);
                }
                if (my instanceof Cc) {
                    zpa.toString();
                    return IlO(zpa, (Cc) my, vce);
                }
                if (my instanceof EO) {
                    zpa.toString();
                    return IlO(zpa, (EO) my, kbbMY);
                }
            } catch (oeT.IlO unused) {
                zpa.toString();
                this.Cc.add(zpa);
                return new IlO(false, pP.IlO());
            }
        }
        tV.MY my2 = this.tV.get(zpa.tV);
        if (my2 == null) {
            zpa.toString();
            return null;
        }
        tV tVVarIlO = my2.IlO();
        tVVarIlO.IlO(zpa.tV);
        kBB kbbMY2 = MY(vce.MY, tVVarIlO);
        vce.tV = kbbMY2;
        if (kbbMY2 != null) {
            zpa.toString();
            return IlO(zpa, tVVarIlO, vce);
        }
        zpa.toString();
        tVVarIlO.tV();
        throw new es(-1);
    }

    public void IlO(String str, Cc<?, ?> cc) {
        cc.IlO(str);
        this.EO.put(str, cc);
    }

    public void IlO(String str, tV.MY my) {
        this.tV.put(str, my);
    }

    public void IlO() {
        Iterator<tV> it = this.vCE.iterator();
        while (it.hasNext()) {
            it.next().Cc();
        }
        this.vCE.clear();
        this.EO.clear();
        this.tV.clear();
        this.MY.MY(this);
    }

    private IlO IlO(zPa zpa, Cc cc, vCE vce) throws Exception {
        return new IlO(true, pP.IlO(this.IlO.IlO(cc.IlO(IlO(zpa.Cc, (MY) cc), vce))));
    }

    private IlO IlO(final zPa zpa, final tV tVVar, vCE vce) throws Exception {
        this.vCE.add(tVVar);
        tVVar.IlO(IlO(zpa.Cc, tVVar), vce, new tV.IlO() { // from class: com.bytedance.sdk.component.IlO.Bc.1
            @Override // com.bytedance.sdk.component.IlO.tV.IlO
            public void IlO(Object obj) {
                if (Bc.this.NV == null) {
                    return;
                }
                Bc.this.NV.MY(pP.IlO(Bc.this.IlO.IlO(obj)), zpa);
                Bc.this.vCE.remove(tVVar);
            }

            @Override // com.bytedance.sdk.component.IlO.tV.IlO
            public void IlO(Throwable th) {
                if (Bc.this.NV == null) {
                    return;
                }
                Bc.this.NV.MY(pP.IlO(th), zpa);
                Bc.this.vCE.remove(tVVar);
            }
        });
        return new IlO(false, pP.IlO());
    }

    private IlO IlO(final zPa zpa, EO eo, kBB kbb) throws Exception {
        new xF(zpa.tV, kbb, new xF.IlO() { // from class: com.bytedance.sdk.component.IlO.Bc.2
        });
        return new IlO(false, pP.IlO());
    }

    private Object IlO(String str, MY my) throws JSONException {
        return this.IlO.IlO(str, IlO(my)[0]);
    }

    private static Type[] IlO(Object obj) {
        Type genericSuperclass = obj.getClass().getGenericSuperclass();
        if (genericSuperclass != null) {
            return ((ParameterizedType) genericSuperclass).getActualTypeArguments();
        }
        throw new IllegalStateException("Method is not parameterized?!");
    }
}
