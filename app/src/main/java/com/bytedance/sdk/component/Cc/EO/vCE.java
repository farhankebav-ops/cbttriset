package com.bytedance.sdk.component.Cc.EO;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;
import com.bytedance.sdk.component.Cc.AXM;
import com.bytedance.sdk.component.Cc.cl;
import com.bytedance.sdk.component.Cc.es;
import com.bytedance.sdk.component.Cc.hp;
import com.bytedance.sdk.component.Cc.oeT;
import com.bytedance.sdk.component.Cc.rp;
import java.io.File;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class vCE {
    private rp Bc;
    private final hp MY;
    private ExecutorService lEW;
    private com.bytedance.sdk.component.Cc.tV vCE;
    private Map<String, List<EO>> IlO = new ConcurrentHashMap();
    private Map<String, cl> EO = new HashMap();
    private Map<String, es> tV = new HashMap();
    private Map<String, com.bytedance.sdk.component.Cc.EO> Cc = new HashMap();

    public vCE(Context context, hp hpVar) {
        this.MY = (hp) Bc.IlO(hpVar);
        com.bytedance.sdk.component.Cc.EO.IlO.IlO.IlO(context, hpVar.lEW());
    }

    private es Cc(com.bytedance.sdk.component.Cc.MY my) {
        es esVarVCE = this.MY.vCE();
        return esVarVCE != null ? esVarVCE : com.bytedance.sdk.component.Cc.EO.IlO.MY.Cc.IlO(my.MY());
    }

    private com.bytedance.sdk.component.Cc.tV DmF() {
        com.bytedance.sdk.component.Cc.tV tVVarTV = this.MY.tV();
        return tVVarTV == null ? new com.bytedance.sdk.component.Cc.MY.IlO() : tVVarTV;
    }

    private ExecutorService EV() {
        ExecutorService executorServiceMY = this.MY.MY();
        return executorServiceMY != null ? executorServiceMY : com.bytedance.sdk.component.Cc.IlO.EO.IlO();
    }

    private rp NV() {
        rp rpVarIlO = this.MY.IlO();
        return rpVarIlO != null ? rpVarIlO : com.bytedance.sdk.component.Cc.IlO.MY.IlO();
    }

    private cl tV(com.bytedance.sdk.component.Cc.MY my) {
        cl clVarCc = this.MY.Cc();
        return clVarCc != null ? com.bytedance.sdk.component.Cc.EO.IlO.MY.IlO.IlO(clVarCc) : com.bytedance.sdk.component.Cc.EO.IlO.MY.IlO.IlO(my.MY());
    }

    private com.bytedance.sdk.component.Cc.EO vCE(com.bytedance.sdk.component.Cc.MY my) {
        com.bytedance.sdk.component.Cc.EO eoBc = this.MY.Bc();
        return eoBc != null ? eoBc : new com.bytedance.sdk.component.Cc.EO.IlO.IlO.MY(my.lEW(), my.IlO(), Bc());
    }

    public ExecutorService Bc() {
        ExecutorService executorServiceIlO;
        AXM axmEO = this.MY.EO();
        if (axmEO != null && (executorServiceIlO = axmEO.IlO()) != null) {
            return executorServiceIlO;
        }
        if (this.lEW == null) {
            this.lEW = EV();
        }
        return this.lEW;
    }

    public Collection<com.bytedance.sdk.component.Cc.EO> EO() {
        return this.Cc.values();
    }

    public Collection<cl> IlO() {
        return this.EO.values();
    }

    public Collection<es> MY() {
        return this.tV.values();
    }

    public Map<String, List<EO>> lEW() {
        return this.IlO;
    }

    public com.bytedance.sdk.component.Cc.EO EO(com.bytedance.sdk.component.Cc.MY my) {
        if (my == null) {
            my = com.bytedance.sdk.component.Cc.EO.IlO.IlO.NV();
        }
        String string = my.lEW().toString();
        com.bytedance.sdk.component.Cc.EO eo = this.Cc.get(string);
        if (eo != null) {
            return eo;
        }
        com.bytedance.sdk.component.Cc.EO eoVCE = vCE(my);
        this.Cc.put(string, eoVCE);
        return eoVCE;
    }

    public cl IlO(com.bytedance.sdk.component.Cc.MY my) {
        if (my == null) {
            my = com.bytedance.sdk.component.Cc.EO.IlO.IlO.NV();
        }
        String string = my.lEW().toString();
        cl clVar = this.EO.get(string);
        if (clVar != null) {
            return clVar;
        }
        cl clVarTV = tV(my);
        this.EO.put(string, clVarTV);
        return clVarTV;
    }

    public es MY(com.bytedance.sdk.component.Cc.MY my) {
        if (my == null) {
            my = com.bytedance.sdk.component.Cc.EO.IlO.IlO.NV();
        }
        String string = my.lEW().toString();
        es esVar = this.tV.get(string);
        if (esVar != null) {
            return esVar;
        }
        es esVarCc = Cc(my);
        this.tV.put(string, esVarCc);
        return esVarCc;
    }

    public oeT Cc() {
        hp hpVar = this.MY;
        if (hpVar != null) {
            return hpVar.DmF();
        }
        return null;
    }

    public rp vCE() {
        if (this.Bc == null) {
            this.Bc = NV();
        }
        return this.Bc;
    }

    public com.bytedance.sdk.component.Cc.tV tV() {
        if (this.vCE == null) {
            this.vCE = DmF();
        }
        return this.vCE;
    }

    public com.bytedance.sdk.component.Cc.EO IlO(String str) {
        return EO(com.bytedance.sdk.component.Cc.EO.IlO.IlO.IlO(new File(str)));
    }

    public com.bytedance.sdk.component.Cc.EO.MY.IlO IlO(EO eo) {
        ImageView.ScaleType scaleTypeTV = eo.tV();
        if (scaleTypeTV == null) {
            scaleTypeTV = com.bytedance.sdk.component.Cc.EO.MY.IlO.IlO;
        }
        ImageView.ScaleType scaleType = scaleTypeTV;
        Bitmap.Config configEV = eo.EV();
        if (configEV == null) {
            configEV = com.bytedance.sdk.component.Cc.EO.MY.IlO.MY;
        }
        return new com.bytedance.sdk.component.Cc.EO.MY.IlO(eo.MY(), eo.EO(), scaleType, configEV, eo.vCE(), eo.Bc());
    }
}
