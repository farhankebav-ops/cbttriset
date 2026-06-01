package com.ironsource;

import android.util.Pair;
import com.ironsource.G7;
import com.ironsource.mediationsdk.logger.IronLog;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class N5 implements Runnable {
    private static final String e = "Content-Type";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final String f7268f = "application/json";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private G7 f7269a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    String f7270b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    String f7271c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    ArrayList<C5> f7272d;

    public N5(G7 g72, String str, String str2, ArrayList<C5> arrayList) {
        this.f7269a = g72;
        this.f7270b = str;
        this.f7271c = str2;
        this.f7272d = arrayList;
    }

    @Override // java.lang.Runnable
    public void run() {
        G7.a aVarA;
        G7.a aVar = new G7.a(this.f7272d);
        try {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new Pair("Content-Type", "application/json"));
            Gd gdB = C2340g8.b(this.f7271c, this.f7270b, arrayList);
            aVarA = aVar.a(gdB.a()).a(gdB.f6881a);
        } catch (Exception e4) {
            C2531r4.d().a(e4);
            IronLog.INTERNAL.error("EventsSender failed to send events - " + e4.getLocalizedMessage());
            aVarA = aVar.a(e4 instanceof Gc).a(e4);
        }
        G7 g72 = this.f7269a;
        if (g72 != null) {
            g72.a(aVarA);
        }
    }
}
