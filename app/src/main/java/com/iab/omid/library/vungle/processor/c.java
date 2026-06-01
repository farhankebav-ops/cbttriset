package com.iab.omid.library.vungle.processor;

import android.view.View;
import androidx.annotation.NonNull;
import com.iab.omid.library.vungle.processor.a;
import com.iab.omid.library.vungle.utils.e;
import com.iab.omid.library.vungle.utils.h;
import java.util.ArrayList;
import java.util.Collection;
import java.util.IdentityHashMap;
import java.util.Iterator;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class c implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final a f6218a;

    public c(a aVar) {
        this.f6218a = aVar;
    }

    @NonNull
    public ArrayList<View> a() {
        View rootView;
        ArrayList<View> arrayList = new ArrayList<>();
        com.iab.omid.library.vungle.internal.c cVarC = com.iab.omid.library.vungle.internal.c.c();
        if (cVarC != null) {
            Collection<com.iab.omid.library.vungle.adsession.a> collectionA = cVarC.a();
            IdentityHashMap identityHashMap = new IdentityHashMap((collectionA.size() * 2) + 3);
            Iterator<com.iab.omid.library.vungle.adsession.a> it = collectionA.iterator();
            while (it.hasNext()) {
                View viewE = it.next().e();
                if (viewE != null && h.g(viewE) && (rootView = viewE.getRootView()) != null && !identityHashMap.containsKey(rootView)) {
                    identityHashMap.put(rootView, rootView);
                    float fD = h.d(rootView);
                    int size = arrayList.size();
                    while (size > 0 && h.d(arrayList.get(size - 1)) > fD) {
                        size--;
                    }
                    arrayList.add(size, rootView);
                }
            }
        }
        return arrayList;
    }

    @Override // com.iab.omid.library.vungle.processor.a
    public JSONObject a(View view) {
        JSONObject jSONObjectA = com.iab.omid.library.vungle.utils.c.a(0, 0, 0, 0);
        com.iab.omid.library.vungle.utils.c.a(jSONObjectA, e.a());
        return jSONObjectA;
    }

    @Override // com.iab.omid.library.vungle.processor.a
    public void a(View view, JSONObject jSONObject, a.InterfaceC0160a interfaceC0160a, boolean z2, boolean z7) {
        ArrayList<View> arrayListA = a();
        int size = arrayListA.size();
        int i2 = 0;
        while (i2 < size) {
            View view2 = arrayListA.get(i2);
            i2++;
            interfaceC0160a.a(view2, this.f6218a, jSONObject, z7);
        }
    }
}
