package com.bytedance.adsdk.MY;

import android.util.Pair;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class es {
    private boolean IlO = false;
    private final Set<Object> MY = new IlO();
    private final Map<String, com.bytedance.adsdk.MY.vCE.tV> EO = new HashMap();
    private final Comparator<Pair<String, Float>> tV = new Comparator<Pair<String, Float>>() { // from class: com.bytedance.adsdk.MY.es.1
        @Override // java.util.Comparator
        /* JADX INFO: renamed from: IlO, reason: merged with bridge method [inline-methods] */
        public int compare(Pair<String, Float> pair, Pair<String, Float> pair2) {
            float fFloatValue = ((Float) pair.second).floatValue();
            float fFloatValue2 = ((Float) pair2.second).floatValue();
            if (fFloatValue2 > fFloatValue) {
                return 1;
            }
            return fFloatValue > fFloatValue2 ? -1 : 0;
        }
    };

    public void IlO(boolean z2) {
        this.IlO = z2;
    }

    public void IlO(String str, float f4) {
        if (this.IlO) {
            com.bytedance.adsdk.MY.vCE.tV tVVar = this.EO.get(str);
            if (tVVar == null) {
                tVVar = new com.bytedance.adsdk.MY.vCE.tV();
                this.EO.put(str, tVVar);
            }
            tVVar.IlO(f4);
            if (str.equals("__container")) {
                Iterator<Object> it = this.MY.iterator();
                while (it.hasNext()) {
                    it.next();
                }
            }
        }
    }
}
