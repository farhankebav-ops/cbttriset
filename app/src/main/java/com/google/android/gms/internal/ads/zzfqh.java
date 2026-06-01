package com.google.android.gms.internal.ads;

import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzfqh implements zzfqe {
    private final int[] zza = new int[2];

    @Override // com.google.android.gms.internal.ads.zzfqe
    public final JSONObject zza(View view) {
        if (view == null) {
            return zzfqo.zzb(0, 0, 0, 0);
        }
        int[] iArr = this.zza;
        int width = view.getWidth();
        int height = view.getHeight();
        view.getLocationOnScreen(iArr);
        return zzfqo.zzb(iArr[0], iArr[1], width, height);
    }

    @Override // com.google.android.gms.internal.ads.zzfqe
    public final void zzb(View view, JSONObject jSONObject, zzfqd zzfqdVar, boolean z2, boolean z7) {
        int i2;
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (!z2) {
                for (int i8 = 0; i8 < viewGroup.getChildCount(); i8++) {
                    zzfqdVar.zza(viewGroup.getChildAt(i8), this, jSONObject, z7);
                }
                return;
            }
            HashMap map = new HashMap();
            for (int i9 = 0; i9 < viewGroup.getChildCount(); i9++) {
                View childAt = viewGroup.getChildAt(i9);
                ArrayList arrayList = (ArrayList) map.get(Float.valueOf(childAt.getZ()));
                if (arrayList == null) {
                    arrayList = new ArrayList();
                    map.put(Float.valueOf(childAt.getZ()), arrayList);
                }
                arrayList.add(childAt);
            }
            ArrayList arrayList2 = new ArrayList(map.keySet());
            Collections.sort(arrayList2);
            int size = arrayList2.size();
            int i10 = 0;
            while (i10 < size) {
                ArrayList arrayList3 = (ArrayList) map.get((Float) arrayList2.get(i10));
                int size2 = arrayList3.size();
                int i11 = 0;
                while (true) {
                    i2 = i10 + 1;
                    if (i11 < size2) {
                        zzfqdVar.zza((View) arrayList3.get(i11), this, jSONObject, z7);
                        i11++;
                    }
                }
                i10 = i2;
            }
        }
    }
}
