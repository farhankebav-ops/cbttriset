package com.ironsource;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;

/* JADX INFO: renamed from: com.ironsource.g1, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class C2333g1 implements InterfaceC2365hf<JSONArray> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<C2315f1> f8560a = new ArrayList();

    /* JADX INFO: renamed from: com.ironsource.g1$a */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f8561a;

        static {
            int[] iArr = new int[EnumC2347gf.values().length];
            try {
                iArr[EnumC2347gf.FullHistory.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[EnumC2347gf.CurrentlyLoadedAds.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f8561a = iArr;
        }
    }

    @Override // com.ironsource.InterfaceC2357h7
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public JSONArray a(EnumC2347gf mode) {
        kotlin.jvm.internal.k.e(mode, "mode");
        int i2 = a.f8561a[mode.ordinal()];
        if (i2 == 1) {
            List<C2315f1> listB = b();
            ArrayList arrayList = new ArrayList(r5.n.L0(listB, 10));
            Iterator<T> it = listB.iterator();
            while (it.hasNext()) {
                arrayList.add(((C2315f1) it.next()).d());
            }
            return new JSONArray((Collection) arrayList);
        }
        if (i2 != 2) {
            throw new e2.s(3);
        }
        List<C2315f1> listA = a();
        ArrayList arrayList2 = new ArrayList(r5.n.L0(listA, 10));
        Iterator<T> it2 = listA.iterator();
        while (it2.hasNext()) {
            arrayList2.add(((C2315f1) it2.next()).c());
        }
        return new JSONArray((Collection) arrayList2);
    }

    public final void a(C2315f1 event) {
        kotlin.jvm.internal.k.e(event, "event");
        this.f8560a.add(event);
    }

    private final List<C2315f1> a() {
        List<C2315f1> list = this.f8560a;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            C2315f1 c2315f1 = (C2315f1) obj;
            if (c2315f1.e() != EnumC2311ef.LoadSuccess && c2315f1.e() != EnumC2311ef.LoadRequest) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(r5.n.L0(arrayList, 10));
        int size = arrayList.size();
        int i2 = 0;
        while (i2 < size) {
            Object obj2 = arrayList.get(i2);
            i2++;
            arrayList2.add(((C2315f1) obj2).a());
        }
        Set setR1 = r5.l.r1(arrayList2);
        List<C2315f1> list2 = this.f8560a;
        ArrayList arrayList3 = new ArrayList();
        for (Object obj3 : list2) {
            C2315f1 c2315f12 = (C2315f1) obj3;
            if (c2315f12.e() == EnumC2311ef.LoadSuccess && !setR1.contains(c2315f12.a())) {
                arrayList3.add(obj3);
            }
        }
        return arrayList3;
    }

    private final List<C2315f1> b() {
        List<C2315f1> list = this.f8560a;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (((C2315f1) obj).e() != EnumC2311ef.LoadRequest) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }
}
