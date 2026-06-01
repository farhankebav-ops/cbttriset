package com.bytedance.sdk.component.Cc.tV.EO;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;
import com.bytedance.sdk.component.Cc.AXM;
import com.bytedance.sdk.component.Cc.cl;
import com.bytedance.sdk.component.Cc.es;
import com.bytedance.sdk.component.Cc.hp;
import com.bytedance.sdk.component.Cc.oeT;
import java.io.File;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class vCE {
    private ExecutorService Bc;
    private Context DmF;
    private volatile cl EO;
    private final hp MY;
    private ExecutorService lEW;
    private volatile es tV;
    private com.bytedance.sdk.component.Cc.tV vCE;
    private Map<String, List<EO>> IlO = new ConcurrentHashMap();
    private Map<String, com.bytedance.sdk.component.Cc.EO> Cc = new ConcurrentHashMap();

    public vCE(Context context, hp hpVar) {
        this.MY = (hp) Bc.IlO(hpVar);
        this.DmF = context;
        com.bytedance.sdk.component.Cc.tV.EO.IlO.MY.IlO(context, hpVar.lEW());
    }

    private ExecutorService EV() {
        ExecutorService executorServiceMY = this.MY.MY();
        return executorServiceMY != null ? executorServiceMY : com.bytedance.sdk.component.Cc.tV.IlO.MY.IlO();
    }

    private com.bytedance.sdk.component.Cc.tV NV() {
        com.bytedance.sdk.component.Cc.tV tVVarTV = this.MY.tV();
        return tVVarTV == null ? new com.bytedance.sdk.component.Cc.MY.IlO() : tVVarTV;
    }

    private com.bytedance.sdk.component.Cc.EO tV(com.bytedance.sdk.component.Cc.MY my) {
        com.bytedance.sdk.component.Cc.EO eoBc = this.MY.Bc();
        return eoBc != null ? eoBc : new com.bytedance.sdk.component.Cc.tV.EO.IlO.IlO.MY(my.lEW(), my.IlO());
    }

    public boolean Bc() {
        hp hpVar = this.MY;
        if (hpVar != null) {
            return hpVar.NV();
        }
        return false;
    }

    public ExecutorService Cc() {
        ExecutorService executorServiceIlO;
        AXM axmEO = this.MY.EO();
        if (axmEO != null && (executorServiceIlO = axmEO.IlO()) != null) {
            return executorServiceIlO;
        }
        if (this.Bc == null) {
            this.Bc = EV();
        }
        return this.Bc;
    }

    public Map<String, List<EO>> DmF() {
        return this.IlO;
    }

    public Collection<com.bytedance.sdk.component.Cc.EO> EO() {
        return this.Cc.values();
    }

    public Context IlO() {
        return this.DmF;
    }

    public es MY() {
        return this.tV;
    }

    public ExecutorService lEW() {
        ExecutorService executorServiceMY;
        AXM axmEO = this.MY.EO();
        if (axmEO != null && (executorServiceMY = axmEO.MY()) != null) {
            return executorServiceMY;
        }
        if (this.lEW == null) {
            this.lEW = com.bytedance.sdk.component.Cc.tV.IlO.MY.IlO();
        }
        return this.lEW;
    }

    public oeT vCE() {
        hp hpVar = this.MY;
        if (hpVar != null) {
            return hpVar.DmF();
        }
        return null;
    }

    public com.bytedance.sdk.component.Cc.EO EO(com.bytedance.sdk.component.Cc.MY my) {
        if (my == null) {
            my = com.bytedance.sdk.component.Cc.tV.EO.IlO.MY.NV();
        }
        String string = my.lEW().toString();
        com.bytedance.sdk.component.Cc.EO eo = this.Cc.get(string);
        if (eo != null) {
            return eo;
        }
        com.bytedance.sdk.component.Cc.EO eoTV = tV(my);
        this.Cc.put(string, eoTV);
        return eoTV;
    }

    public cl IlO(com.bytedance.sdk.component.Cc.MY my) {
        if (my == null) {
            my = com.bytedance.sdk.component.Cc.tV.EO.IlO.MY.NV();
        }
        if (this.EO == null) {
            synchronized (com.bytedance.sdk.component.Cc.tV.EO.IlO.MY.EO.class) {
                try {
                    if (this.EO == null) {
                        this.EO = new com.bytedance.sdk.component.Cc.tV.EO.IlO.MY.EO(new com.bytedance.sdk.component.Cc.tV.EO.IlO.MY.IlO(my.MY(), my.EO()));
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return this.EO;
    }

    public es MY(com.bytedance.sdk.component.Cc.MY my) {
        if (my == null) {
            my = com.bytedance.sdk.component.Cc.tV.EO.IlO.MY.NV();
        }
        if (this.tV == null) {
            synchronized (com.bytedance.sdk.component.Cc.tV.EO.IlO.MY.MY.class) {
                try {
                    if (this.tV == null) {
                        this.tV = new com.bytedance.sdk.component.Cc.tV.EO.IlO.MY.MY(my.MY(), my.tV());
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return this.tV;
    }

    public com.bytedance.sdk.component.Cc.tV tV() {
        if (this.vCE == null) {
            this.vCE = NV();
        }
        return this.vCE;
    }

    public com.bytedance.sdk.component.Cc.EO IlO(String str) {
        return EO(com.bytedance.sdk.component.Cc.tV.EO.IlO.MY.IlO(new File(str)));
    }

    public com.bytedance.sdk.component.Cc.tV.EO.MY.MY IlO(EO eo) {
        ImageView.ScaleType scaleTypeTV = eo.tV();
        if (scaleTypeTV == null) {
            scaleTypeTV = com.bytedance.sdk.component.Cc.tV.EO.MY.MY.IlO;
        }
        ImageView.ScaleType scaleType = scaleTypeTV;
        Bitmap.Config configEV = eo.EV();
        if (configEV == null) {
            configEV = com.bytedance.sdk.component.Cc.tV.EO.MY.MY.MY;
        }
        return new com.bytedance.sdk.component.Cc.tV.EO.MY.MY(eo.MY(), eo.EO(), scaleType, configEV, eo.vCE(), eo.Bc());
    }
}
