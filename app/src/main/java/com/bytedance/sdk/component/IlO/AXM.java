package com.bytedance.sdk.component.IlO;

import android.net.Uri;
import com.bytedance.sdk.component.IlO.EV;
import com.bytedance.sdk.component.IlO.oeT;
import com.bytedance.sdk.component.IlO.vAh;
import java.util.LinkedHashSet;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
class AXM {
    private EV.IlO Cc;
    private final vAh EO = cl.IlO;
    private final Set<String> IlO;
    private final Set<String> MY;
    private final oeT tV;

    public AXM(oeT oet, Set<String> set, Set<String> set2) {
        this.tV = oet;
        if (set == null || set.isEmpty()) {
            this.IlO = new LinkedHashSet();
        } else {
            this.IlO = new LinkedHashSet(set);
        }
        if (set2 == null || set2.isEmpty()) {
            this.MY = new LinkedHashSet();
        } else {
            this.MY = new LinkedHashSet(set2);
        }
    }

    public final synchronized kBB IlO(boolean z2, String str, MY my) throws oeT.IlO {
        EV.IlO ilO;
        try {
            Uri uri = Uri.parse(str);
            String host = uri.getHost();
            if (host == null) {
                return null;
            }
            kBB kbb = this.MY.contains(my.IlO()) ? kBB.PUBLIC : null;
            for (String str2 : this.IlO) {
                if (uri.getHost().equals(str2) || host.endsWith(".".concat(String.valueOf(str2)))) {
                    kbb = kBB.PRIVATE;
                    break;
                }
            }
            if (kbb == null && (ilO = this.Cc) != null && ilO.IlO(str)) {
                if (this.Cc.IlO(str, my.IlO())) {
                    return null;
                }
                kbb = kBB.PRIVATE;
            }
            kBB kbbIlO = z2 ? IlO(str, my) : MY(str, my);
            return kbbIlO != null ? kbbIlO : kbb;
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized kBB MY(String str, MY my) {
        return IlO(str, my, false);
    }

    public void MY(vAh.IlO ilO) {
        if (this.EO != null) {
            throw null;
        }
    }

    public final synchronized kBB IlO(String str, MY my) throws oeT.IlO {
        return IlO(str, my, true);
    }

    public void IlO(EV.IlO ilO) {
        this.Cc = ilO;
    }

    public void IlO(vAh.IlO ilO) {
        if (this.EO != null) {
            throw null;
        }
    }

    private kBB IlO(String str, MY my, boolean z2) {
        if (!z2 || this.tV == null) {
            return null;
        }
        throw null;
    }
}
