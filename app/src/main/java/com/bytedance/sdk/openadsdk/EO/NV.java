package com.bytedance.sdk.openadsdk.EO;

import android.os.RemoteException;
import android.text.TextUtils;
import com.bytedance.sdk.component.utils.oeT;
import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.IListenerManager;
import com.bytedance.sdk.openadsdk.core.EO.Bc;
import com.bytedance.sdk.openadsdk.utils.mmj;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class NV {
    private String EV;
    private String bWL;
    private FilterWord cL;
    private int cl;
    private String ea;
    private String hp;
    private String rp;
    protected IListenerManager vCE;
    private int zPa;
    public static FilterWord IlO = new FilterWord("", "");
    public static int MY = 1;
    public static int EO = 2;
    public static int tV = 3;
    public static int Cc = 4;
    private final Set<EO> Bc = new HashSet();
    private final Set<MY> lEW = new HashSet();
    private final Set<tV> DmF = new HashSet();
    private final Set<IlO> NV = new HashSet();

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public interface EO {
        void IlO(FilterWord filterWord);
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public interface IlO {
        void IlO(List<FilterWord> list);
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public interface MY {
        void IlO(int i2);
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public interface tV {
        void IlO(String str);
    }

    private void NV() {
        Iterator<EO> it = this.Bc.iterator();
        while (it.hasNext()) {
            it.next().IlO(this.cL);
        }
    }

    public String Bc() {
        return this.bWL;
    }

    public void Cc() {
        Iterator<MY> it = this.lEW.iterator();
        while (it.hasNext()) {
            it.next().IlO(EO);
        }
    }

    public boolean DmF() {
        return this.zPa < this.cl;
    }

    public boolean EO() {
        FilterWord filterWord = this.cL;
        return (filterWord == null || filterWord.equals(IlO)) ? false : true;
    }

    public void MY(String str) {
        this.rp = str;
    }

    public int lEW() {
        return this.zPa;
    }

    public void tV() {
        if (!EO() && !TextUtils.isEmpty(this.bWL)) {
            this.cL = new FilterWord("0:00", this.bWL);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.cL);
        if (!TextUtils.isEmpty(this.EV)) {
            if (TextUtils.isEmpty(this.bWL)) {
                com.bytedance.sdk.openadsdk.EO.MY.IlO().IlO(this.EV, arrayList, this.rp);
            } else {
                com.bytedance.sdk.openadsdk.EO.MY.IlO().IlO(this.EV, arrayList, this.ea, this.bWL, this.rp);
            }
        }
        if (!TextUtils.isEmpty(this.hp)) {
            if (com.bytedance.sdk.openadsdk.multipro.MY.EO()) {
                Cc("onItemClickClosed");
            } else {
                Bc.IlO ilOCc = com.bytedance.sdk.openadsdk.core.DmF.MY().Cc(this.hp);
                if (ilOCc != null) {
                    ilOCc.IlO();
                    com.bytedance.sdk.openadsdk.core.DmF.MY().vCE(this.hp);
                }
            }
        }
        Iterator<MY> it = this.lEW.iterator();
        while (it.hasNext()) {
            it.next().IlO(MY);
        }
        IlO(IlO);
        EO("");
    }

    public void vCE() {
        Iterator<MY> it = this.lEW.iterator();
        while (it.hasNext()) {
            it.next().IlO(Cc);
        }
    }

    public void EO(String str) {
        this.bWL = str;
        Iterator<tV> it = this.DmF.iterator();
        while (it.hasNext()) {
            it.next().IlO(this.bWL);
        }
    }

    public void IlO() {
        this.Bc.clear();
        this.lEW.clear();
        this.DmF.clear();
        this.NV.clear();
    }

    public FilterWord MY() {
        return this.cL;
    }

    private void Cc(final String str) {
        mmj.EO(new com.bytedance.sdk.component.lEW.lEW("Reward_executeMultiProcessCallback") { // from class: com.bytedance.sdk.openadsdk.EO.NV.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (TextUtils.isEmpty(NV.this.hp)) {
                        return;
                    }
                    NV.this.IlO(6).executeDisLikeClosedCallback(NV.this.hp, str);
                } catch (Throwable th) {
                    oeT.IlO("TTDislikeManager", "executeRewardVideoCallback execute throw Exception : ", th);
                }
            }
        }, 5);
    }

    public void IlO(String str) {
        this.EV = str;
    }

    public void IlO(FilterWord filterWord) {
        this.cL = filterWord;
        NV();
    }

    public void IlO(EO eo) {
        this.Bc.add(eo);
    }

    public void IlO(MY my) {
        this.lEW.add(my);
    }

    public void IlO(tV tVVar) {
        this.DmF.add(tVVar);
    }

    public void IlO(IlO ilO) {
        this.NV.add(ilO);
    }

    public void IlO(List<FilterWord> list) {
        Iterator<IlO> it = this.NV.iterator();
        while (it.hasNext()) {
            it.next().IlO(list);
        }
    }

    public IListenerManager IlO(int i2) {
        if (this.vCE == null) {
            this.vCE = IListenerManager.Stub.asInterface(com.bytedance.sdk.openadsdk.multipro.aidl.IlO.IlO().IlO(i2));
        }
        return this.vCE;
    }

    public void tV(String str) {
        this.ea = str;
    }

    public static void IlO(final int i2, final String str, final Bc.IlO ilO) {
        if (com.bytedance.sdk.openadsdk.multipro.MY.EO()) {
            mmj.EO(new com.bytedance.sdk.component.lEW.lEW("DislikeClosed_registerMultiProcessListener") { // from class: com.bytedance.sdk.openadsdk.EO.NV.2
                @Override // java.lang.Runnable
                public void run() {
                    com.bytedance.sdk.openadsdk.multipro.aidl.IlO IlO2 = com.bytedance.sdk.openadsdk.multipro.aidl.IlO.IlO();
                    if (i2 != 6 || ilO == null) {
                        return;
                    }
                    try {
                        com.bytedance.sdk.openadsdk.multipro.aidl.MY.MY my = new com.bytedance.sdk.openadsdk.multipro.aidl.MY.MY(str, ilO);
                        IListenerManager iListenerManagerAsInterface = IListenerManager.Stub.asInterface(IlO2.IlO(6));
                        if (iListenerManagerAsInterface != null) {
                            iListenerManagerAsInterface.registerDisLikeClosedListener(str, my);
                        }
                    } catch (RemoteException e) {
                        oeT.EO("TTDislikeManager", e.getMessage());
                    }
                }
            }, 5);
        }
    }

    public static void IlO(final int i2, final String str) {
        if (com.bytedance.sdk.openadsdk.multipro.MY.EO()) {
            mmj.EO(new com.bytedance.sdk.component.lEW.lEW("DislikeClosed_unregisterMultiProcessListener") { // from class: com.bytedance.sdk.openadsdk.EO.NV.3
                @Override // java.lang.Runnable
                public void run() {
                    com.bytedance.sdk.openadsdk.multipro.aidl.IlO IlO2 = com.bytedance.sdk.openadsdk.multipro.aidl.IlO.IlO();
                    if (i2 == 6) {
                        try {
                            IListenerManager iListenerManagerAsInterface = IListenerManager.Stub.asInterface(IlO2.IlO(6));
                            if (iListenerManagerAsInterface != null) {
                                iListenerManagerAsInterface.unregisterDisLikeClosedListener(str);
                            }
                        } catch (RemoteException unused) {
                        }
                    }
                }
            }, 5);
        }
    }

    public void IlO(int i2, int i8) {
        this.zPa = i2;
        this.cl = i8;
    }
}
