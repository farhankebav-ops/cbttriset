package com.ironsource;

import com.ironsource.InterfaceC2565t4;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.ironsource.h1, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class C2351h1 implements InterfaceC2495p1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final InterfaceC2404k1 f8634a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final F7 f8635b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Lb<Integer, Integer> f8636c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final InterfaceC2565t4 f8637d;
    private List<InterfaceC2440m1> e;

    public C2351h1(InterfaceC2404k1 eventBaseData, F7 eventsManager, Lb<Integer, Integer> eventsMapper, InterfaceC2565t4 currentTimeProvider) {
        kotlin.jvm.internal.k.e(eventBaseData, "eventBaseData");
        kotlin.jvm.internal.k.e(eventsManager, "eventsManager");
        kotlin.jvm.internal.k.e(eventsMapper, "eventsMapper");
        kotlin.jvm.internal.k.e(currentTimeProvider, "currentTimeProvider");
        this.f8634a = eventBaseData;
        this.f8635b = eventsManager;
        this.f8636c = eventsMapper;
        this.f8637d = currentTimeProvider;
        this.e = new ArrayList();
    }

    public final void a(List<InterfaceC2440m1> list) {
        kotlin.jvm.internal.k.e(list, "<set-?>");
        this.e = list;
    }

    public final List<InterfaceC2440m1> b() {
        return this.e;
    }

    private final JSONObject b(List<? extends InterfaceC2440m1> list) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<? extends InterfaceC2440m1> it = list.iterator();
        while (it.hasNext()) {
            it.next().a(linkedHashMap);
        }
        return new JSONObject(linkedHashMap);
    }

    @Override // com.ironsource.InterfaceC2495p1
    public void a(int i2, List<InterfaceC2440m1> arrayList) {
        kotlin.jvm.internal.k.e(arrayList, "arrayList");
        try {
            ArrayList<InterfaceC2440m1> arrayListA = this.f8634a.a();
            int size = arrayListA.size();
            int i8 = 0;
            while (i8 < size) {
                InterfaceC2440m1 interfaceC2440m1 = arrayListA.get(i8);
                i8++;
                arrayList.add(interfaceC2440m1);
            }
            Iterator<InterfaceC2440m1> it = this.e.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next());
            }
            this.f8635b.a(new C5(this.f8636c.a(Integer.valueOf(i2)).intValue(), this.f8637d.a(), b(arrayList)));
        } catch (Exception e) {
            C2531r4.d().a(e);
            System.out.println((Object) a1.a.l("LogRemote | Exception: ", e.getMessage()));
        }
    }

    public /* synthetic */ C2351h1(InterfaceC2404k1 interfaceC2404k1, F7 f72, Lb lb, InterfaceC2565t4 interfaceC2565t4, int i2, kotlin.jvm.internal.f fVar) {
        this(interfaceC2404k1, f72, lb, (i2 & 8) != 0 ? new InterfaceC2565t4.a() : interfaceC2565t4);
    }

    @Override // com.ironsource.InterfaceC2495p1
    public void a() {
        this.e.clear();
    }

    @Override // com.ironsource.InterfaceC2495p1
    public void a(InterfaceC2440m1... analyticsEventEntity) {
        kotlin.jvm.internal.k.e(analyticsEventEntity, "analyticsEventEntity");
        for (InterfaceC2440m1 interfaceC2440m1 : analyticsEventEntity) {
            this.e.add(interfaceC2440m1);
        }
    }
}
