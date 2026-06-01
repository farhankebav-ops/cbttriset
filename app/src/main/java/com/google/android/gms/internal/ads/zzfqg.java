package com.google.android.gms.internal.ads;

import android.view.View;
import java.util.ArrayList;
import java.util.Collection;
import java.util.IdentityHashMap;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzfqg implements zzfqe {
    private final zzfqe zza;

    public zzfqg(zzfqe zzfqeVar) {
        this.zza = zzfqeVar;
    }

    @Override // com.google.android.gms.internal.ads.zzfqe
    public final JSONObject zza(View view) {
        JSONObject jSONObjectZzb = zzfqo.zzb(0, 0, 0, 0);
        int iZzb = zzfqr.zzb();
        int i2 = iZzb - 1;
        if (iZzb == 0) {
            throw null;
        }
        try {
            jSONObjectZzb.put("noOutputDevice", i2 == 0);
            return jSONObjectZzb;
        } catch (JSONException e) {
            zzfqp.zza("Error with setting output device status", e);
            return jSONObjectZzb;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzfqe
    public final void zzb(View view, JSONObject jSONObject, zzfqd zzfqdVar, boolean z2, boolean z7) {
        ArrayList arrayList = new ArrayList();
        zzfps zzfpsVarZza = zzfps.zza();
        if (zzfpsVarZza != null) {
            Collection collectionZzf = zzfpsVarZza.zzf();
            int size = collectionZzf.size();
            IdentityHashMap identityHashMap = new IdentityHashMap(size + size + 3);
            Iterator it = collectionZzf.iterator();
            while (it.hasNext()) {
                View viewZzi = ((zzfoy) it.next()).zzi();
                if (viewZzi != null && viewZzi.isAttachedToWindow() && viewZzi.isShown()) {
                    View view2 = viewZzi;
                    while (true) {
                        if (view2 == null) {
                            View rootView = viewZzi.getRootView();
                            if (rootView != null && !identityHashMap.containsKey(rootView)) {
                                identityHashMap.put(rootView, rootView);
                                float z8 = rootView.getZ();
                                int size2 = arrayList.size();
                                while (size2 > 0) {
                                    int i2 = size2 - 1;
                                    if (((View) arrayList.get(i2)).getZ() <= z8) {
                                        break;
                                    } else {
                                        size2 = i2;
                                    }
                                }
                                arrayList.add(size2, rootView);
                            }
                        } else if (view2.getAlpha() != 0.0f) {
                            Object parent = view2.getParent();
                            view2 = parent instanceof View ? (View) parent : null;
                        }
                    }
                }
            }
        }
        int size3 = arrayList.size();
        for (int i8 = 0; i8 < size3; i8++) {
            zzfqdVar.zza((View) arrayList.get(i8), this.zza, jSONObject, z7);
        }
    }
}
