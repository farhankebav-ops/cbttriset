package com.bytedance.sdk.component.adexpress.dynamic.animation.IlO;

import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class EO {
    private static volatile EO IlO;

    private EO() {
    }

    public static EO IlO() {
        if (IlO == null) {
            synchronized (EO.class) {
                try {
                    if (IlO == null) {
                        IlO = new EO();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return IlO;
    }

    public tV IlO(View view, com.bytedance.sdk.component.adexpress.dynamic.tV.IlO ilO) {
        if (ilO == null) {
            return null;
        }
        if (view.getParent() != null) {
            ((ViewGroup) view.getParent()).setClipChildren(false);
        }
        if (view.getParent().getParent() != null) {
            ((ViewGroup) view.getParent().getParent()).setClipChildren(false);
        }
        if ("scale".equals(ilO.DmF())) {
            return new EV(view, ilO);
        }
        if ("translate".equals(ilO.DmF())) {
            return new ea(view, ilO);
        }
        if ("ripple".equals(ilO.DmF())) {
            return new lEW(view, ilO);
        }
        if ("marquee".equals(ilO.DmF())) {
            return new Bc(view, ilO);
        }
        if ("waggle".equals(ilO.DmF())) {
            return new zPa(view, ilO);
        }
        if ("shine".equals(ilO.DmF())) {
            return new rp(view, ilO);
        }
        if ("swing".equals(ilO.DmF())) {
            return new bWL(view, ilO);
        }
        if ("fade".equals(ilO.DmF())) {
            return new IlO(view, ilO);
        }
        if ("rubIn".equals(ilO.DmF())) {
            return new NV(view, ilO);
        }
        if ("rotate".equals(ilO.DmF())) {
            return new DmF(view, ilO);
        }
        if ("cutIn".equals(ilO.DmF())) {
            return new vCE(view, ilO);
        }
        if ("stretch".equals(ilO.DmF())) {
            return new hp(view, ilO);
        }
        if ("bounce".equals(ilO.DmF())) {
            return new Cc(view, ilO);
        }
        return null;
    }
}
