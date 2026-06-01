package com.iab.omid.library.bytedance2.processor;

import android.view.View;
import android.view.ViewGroup;
import com.iab.omid.library.bytedance2.processor.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class d implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int[] f5899a = new int[2];

    private void b(ViewGroup viewGroup, JSONObject jSONObject, a.InterfaceC0148a interfaceC0148a, boolean z2) {
        HashMap map = new HashMap();
        for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
            View childAt = viewGroup.getChildAt(i2);
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
        int i8 = 0;
        while (i8 < size) {
            Object obj = arrayList2.get(i8);
            i8++;
            ArrayList arrayList3 = (ArrayList) map.get((Float) obj);
            int size2 = arrayList3.size();
            int i9 = 0;
            while (i9 < size2) {
                Object obj2 = arrayList3.get(i9);
                i9++;
                interfaceC0148a.a((View) obj2, this, jSONObject, z2);
            }
        }
    }

    @Override // com.iab.omid.library.bytedance2.processor.a
    public JSONObject a(View view) {
        if (view == null) {
            return com.iab.omid.library.bytedance2.utils.c.a(0, 0, 0, 0);
        }
        int width = view.getWidth();
        int height = view.getHeight();
        view.getLocationOnScreen(this.f5899a);
        int[] iArr = this.f5899a;
        return com.iab.omid.library.bytedance2.utils.c.a(iArr[0], iArr[1], width, height);
    }

    @Override // com.iab.omid.library.bytedance2.processor.a
    public void a(View view, JSONObject jSONObject, a.InterfaceC0148a interfaceC0148a, boolean z2, boolean z7) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (z2) {
                b(viewGroup, jSONObject, interfaceC0148a, z7);
            } else {
                a(viewGroup, jSONObject, interfaceC0148a, z7);
            }
        }
    }

    private void a(ViewGroup viewGroup, JSONObject jSONObject, a.InterfaceC0148a interfaceC0148a, boolean z2) {
        for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
            interfaceC0148a.a(viewGroup.getChildAt(i2), this, jSONObject, z2);
        }
    }
}
