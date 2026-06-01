package f7;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import okhttp3.internal.http2.Http2Connection;
import okhttp3.internal.http2.Http2Stream;
import okhttp3.internal.ws.RealWebSocket;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class z implements e6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f11550a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f11551b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f11552c;

    public /* synthetic */ z(int i2, Object obj, Object obj2) {
        this.f11550a = i2;
        this.f11551b = obj;
        this.f11552c = obj2;
    }

    @Override // e6.a
    public final Object invoke() {
        String[] strArrNames;
        switch (this.f11550a) {
            case 0:
                a0 a0Var = (a0) this.f11551b;
                String str = (String) this.f11552c;
                a0Var.getClass();
                Enum[] enumArr = a0Var.f11415a;
                y yVar = new y(str, enumArr.length);
                for (Enum r02 : enumArr) {
                    yVar.j(r02.name(), false);
                }
                return yVar;
            case 1:
                d7.g gVar = (d7.g) this.f11551b;
                g7.c cVar = (g7.c) this.f11552c;
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                g7.j jVar = cVar.f11598a;
                h7.o.m(gVar, cVar);
                int iD = gVar.d();
                for (int i2 = 0; i2 < iD; i2++) {
                    List listF = gVar.f(i2);
                    ArrayList arrayList = new ArrayList();
                    for (Object obj : listF) {
                        if (obj instanceof g7.t) {
                            arrayList.add(obj);
                        }
                    }
                    g7.t tVar = (g7.t) (arrayList.size() == 1 ? arrayList.get(0) : null);
                    if (tVar != null && (strArrNames = tVar.names()) != null) {
                        for (String str2 : strArrNames) {
                            String str3 = kotlin.jvm.internal.k.a(gVar.getKind(), d7.l.f11200b) ? "enum value" : "property";
                            if (linkedHashMap.containsKey(str2)) {
                                String message = "The suggested name '" + str2 + "' for " + str3 + ' ' + gVar.e(i2) + " is already one of the names for " + str3 + ' ' + gVar.e(((Number) r5.x.b0(linkedHashMap, str2)).intValue()) + " in " + gVar;
                                kotlin.jvm.internal.k.e(message, "message");
                                throw new b7.m(message);
                            }
                            linkedHashMap.put(str2, Integer.valueOf(i2));
                        }
                    }
                }
                return linkedHashMap.isEmpty() ? r5.s.f13639a : linkedHashMap;
            case 2:
                return Http2Connection.ReaderRunnable.headers$lambda$2$lambda$1((Http2Connection) this.f11551b, (Http2Stream) this.f11552c);
            case 3:
                return Http2Connection.ReaderRunnable.applyAndAckSettings$lambda$7$lambda$6$lambda$5((Http2Connection) this.f11551b, (kotlin.jvm.internal.a0) this.f11552c);
            default:
                return RealWebSocket.failWebSocket$lambda$14$lambda$13((kotlin.jvm.internal.a0) this.f11551b, (kotlin.jvm.internal.a0) this.f11552c);
        }
    }
}
