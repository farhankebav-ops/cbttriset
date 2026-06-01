package v0;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import com.bumptech.glide.load.Key;
import com.ironsource.C2300e4;
import com.ironsource.Q6;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Executor;
import o0.b0;
import o0.i0;
import o0.j0;
import o0.l0;
import o0.m;
import o0.o;
import o0.p;
import o0.r;
import o0.s;
import o0.t;
import o0.u;
import o0.v;
import o0.x;
import p0.j;
import p0.k;
import p0.n;
import p0.q;
import w0.i;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f17581a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final q0.f f17582b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final w0.d f17583c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final e2.h f17584d;
    public final Executor e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final x0.c f17585f;
    public final y0.a g;
    public final y0.a h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final w0.c f17586i;

    public f(Context context, q0.f fVar, w0.d dVar, e2.h hVar, Executor executor, x0.c cVar, y0.a aVar, y0.a aVar2, w0.c cVar2) {
        this.f17581a = context;
        this.f17582b = fVar;
        this.f17583c = dVar;
        this.f17584d = hVar;
        this.e = executor;
        this.f17585f = cVar;
        this.g = aVar;
        this.h = aVar2;
        this.f17586i = cVar2;
    }

    public final void a(k kVar, int i2) {
        byte[] bArr;
        long j;
        q0.a aVar;
        String str;
        q0.a aVar2;
        int i8;
        n0.b bVarA;
        String str2;
        Integer numValueOf;
        t tVar;
        final f fVar = this;
        final k kVar2 = kVar;
        byte[] bArr2 = kVar2.f13293b;
        q0.h hVarA = fVar.f17582b.a(kVar2.f13292a);
        long jMax = 0;
        while (true) {
            final int i9 = 0;
            x0.b bVar = new x0.b(fVar) { // from class: v0.d

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                public final /* synthetic */ f f17576b;

                {
                    this.f17576b = fVar;
                }

                @Override // x0.b
                public final Object execute() {
                    Boolean bool;
                    switch (i9) {
                        case 0:
                            k kVar3 = kVar2;
                            i iVar = (i) this.f17576b.f17583c;
                            SQLiteDatabase sQLiteDatabaseA = iVar.a();
                            sQLiteDatabaseA.beginTransaction();
                            try {
                                Long lB = i.b(sQLiteDatabaseA, kVar3);
                                if (lB == null) {
                                    bool = Boolean.FALSE;
                                } else {
                                    Cursor cursorRawQuery = iVar.a().rawQuery("SELECT 1 FROM events WHERE context_id = ? LIMIT 1", new String[]{lB.toString()});
                                    try {
                                        Boolean boolValueOf = Boolean.valueOf(cursorRawQuery.moveToNext());
                                        cursorRawQuery.close();
                                        bool = boolValueOf;
                                    } catch (Throwable th) {
                                        cursorRawQuery.close();
                                        throw th;
                                    }
                                }
                                sQLiteDatabaseA.setTransactionSuccessful();
                                return bool;
                            } finally {
                                sQLiteDatabaseA.endTransaction();
                            }
                        default:
                            i iVar2 = (i) this.f17576b.f17583c;
                            iVar2.getClass();
                            return (Iterable) iVar2.e(new androidx.camera.camera2.interop.d(13, iVar2, kVar2));
                    }
                }
            };
            i iVar = (i) fVar.f17585f;
            if (!((Boolean) iVar.j(bVar)).booleanValue()) {
                iVar.j(new androidx.camera.core.impl.utils.futures.a(fVar, kVar2, jMax));
                return;
            }
            final int i10 = 1;
            Iterable iterable = (Iterable) iVar.j(new x0.b(fVar) { // from class: v0.d

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                public final /* synthetic */ f f17576b;

                {
                    this.f17576b = fVar;
                }

                @Override // x0.b
                public final Object execute() {
                    Boolean bool;
                    switch (i10) {
                        case 0:
                            k kVar3 = kVar2;
                            i iVar2 = (i) this.f17576b.f17583c;
                            SQLiteDatabase sQLiteDatabaseA = iVar2.a();
                            sQLiteDatabaseA.beginTransaction();
                            try {
                                Long lB = i.b(sQLiteDatabaseA, kVar3);
                                if (lB == null) {
                                    bool = Boolean.FALSE;
                                } else {
                                    Cursor cursorRawQuery = iVar2.a().rawQuery("SELECT 1 FROM events WHERE context_id = ? LIMIT 1", new String[]{lB.toString()});
                                    try {
                                        Boolean boolValueOf = Boolean.valueOf(cursorRawQuery.moveToNext());
                                        cursorRawQuery.close();
                                        bool = boolValueOf;
                                    } catch (Throwable th) {
                                        cursorRawQuery.close();
                                        throw th;
                                    }
                                }
                                sQLiteDatabaseA.setTransactionSuccessful();
                                return bool;
                            } finally {
                                sQLiteDatabaseA.endTransaction();
                            }
                        default:
                            i iVar22 = (i) this.f17576b.f17583c;
                            iVar22.getClass();
                            return (Iterable) iVar22.e(new androidx.camera.camera2.interop.d(13, iVar22, kVar2));
                    }
                }
            });
            if (!iterable.iterator().hasNext()) {
                return;
            }
            if (hVarA == null) {
                a.a.t("Uploader", "Unknown backend for %s, deleting event batch for it...", kVar2);
                aVar2 = new q0.a(3, -1L);
                bArr = bArr2;
                j = jMax;
            } else {
                ArrayList arrayList = new ArrayList();
                Iterator it = iterable.iterator();
                while (it.hasNext()) {
                    arrayList.add(((w0.b) it.next()).f17662c);
                }
                if (bArr2 != null) {
                    w0.c cVar = fVar.f17586i;
                    Objects.requireNonNull(cVar);
                    s0.a aVar3 = (s0.a) iVar.j(new j7.a(cVar, 7));
                    p0.i iVar2 = new p0.i();
                    iVar2.f13284f = new HashMap();
                    iVar2.f13283d = Long.valueOf(fVar.g.getTime());
                    iVar2.e = Long.valueOf(fVar.h.getTime());
                    iVar2.f13280a = "GDT_CLIENT_METRICS";
                    m0.c cVar2 = new m0.c("proto");
                    aVar3.getClass();
                    iVar2.f13282c = new n(cVar2, q.f13303a.encode(aVar3));
                    arrayList.add(((n0.c) hVarA).a(iVar2.b()));
                }
                n0.c cVar3 = (n0.c) hVarA;
                HashMap map = new HashMap();
                int size = arrayList.size();
                int i11 = 0;
                while (i11 < size) {
                    Object obj = arrayList.get(i11);
                    i11++;
                    j jVar = (j) obj;
                    String str3 = jVar.f13286a;
                    if (map.containsKey(str3)) {
                        ((List) map.get(str3)).add(jVar);
                    } else {
                        ArrayList arrayList2 = new ArrayList();
                        arrayList2.add(jVar);
                        map.put(str3, arrayList2);
                    }
                }
                ArrayList arrayList3 = new ArrayList();
                for (Map.Entry entry : map.entrySet()) {
                    j jVar2 = (j) ((List) entry.getValue()).get(0);
                    l0 l0Var = l0.f13149a;
                    long time = cVar3.f13053f.getTime();
                    long time2 = cVar3.e.getTime();
                    o oVar = new o(new m(Integer.valueOf(jVar2.b("sdk-version")), jVar2.a(Q6.B), jVar2.a("hardware"), jVar2.a(C2300e4.h.G), jVar2.a("product"), jVar2.a("os-uild"), jVar2.a("manufacturer"), jVar2.a("fingerprint"), jVar2.a("locale"), jVar2.a("country"), jVar2.a("mcc_mnc"), jVar2.a("application_build")));
                    try {
                        numValueOf = Integer.valueOf(Integer.parseInt((String) entry.getKey()));
                        str2 = null;
                    } catch (NumberFormatException unused) {
                        str2 = (String) entry.getKey();
                        numValueOf = null;
                    }
                    ArrayList arrayList4 = new ArrayList();
                    for (j jVar3 : (List) entry.getValue()) {
                        byte[] bArr3 = bArr2;
                        n nVar = jVar3.f13288c;
                        byte[] bArr4 = jVar3.j;
                        m0.c cVar4 = nVar.f13300a;
                        byte[] bArr5 = nVar.f13301b;
                        long j3 = jMax;
                        if (cVar4.equals(new m0.c("proto"))) {
                            tVar = new t();
                            tVar.e = bArr5;
                        } else if (cVar4.equals(new m0.c("json"))) {
                            String str4 = new String(bArr5, Charset.forName(Key.STRING_CHARSET_NAME));
                            t tVar2 = new t();
                            tVar2.f13168f = str4;
                            tVar = tVar2;
                        } else {
                            String strH = a.a.H("CctTransportBackend");
                            if (Log.isLoggable(strH, 5)) {
                                Log.w(strH, "Received event of unsupported encoding " + cVar4 + ". Skipping...");
                            }
                            bArr2 = bArr3;
                            jMax = j3;
                        }
                        tVar.f13164a = Long.valueOf(jVar3.f13289d);
                        tVar.f13167d = Long.valueOf(jVar3.e);
                        String str5 = (String) jVar3.f13290f.get("tz-offset");
                        tVar.g = Long.valueOf(str5 == null ? 0L : Long.valueOf(str5).longValue());
                        tVar.h = new x((j0) j0.f13143a.get(jVar3.b("net-type")), (i0) i0.f13136a.get(jVar3.b("mobile-subtype")));
                        Integer num = jVar3.f13287b;
                        if (num != null) {
                            tVar.f13165b = num;
                        }
                        Integer num2 = jVar3.g;
                        if (num2 != null) {
                            s sVar = new s(new r(num2));
                            b0 b0Var = b0.f13113a;
                            tVar.f13166c = new p(sVar);
                        }
                        byte[] bArr6 = jVar3.f13291i;
                        if (bArr6 != null || bArr4 != null) {
                            if (bArr6 == null) {
                                bArr6 = null;
                            }
                            tVar.f13169i = new o0.q(bArr6, bArr4 != null ? bArr4 : null);
                        }
                        String strC = tVar.f13164a == null ? " eventTimeMs" : "";
                        if (tVar.f13167d == null) {
                            strC = strC.concat(" eventUptimeMs");
                        }
                        if (tVar.g == null) {
                            strC = a1.a.C(strC, " timezoneOffsetSeconds");
                        }
                        if (!strC.isEmpty()) {
                            throw new IllegalStateException("Missing required properties:".concat(strC));
                        }
                        arrayList4.add(new u(tVar.f13164a.longValue(), tVar.f13165b, tVar.f13166c, tVar.f13167d.longValue(), tVar.e, tVar.f13168f, tVar.g.longValue(), tVar.h, tVar.f13169i));
                        bArr2 = bArr3;
                        jMax = j3;
                    }
                    arrayList3.add(new v(time, time2, oVar, numValueOf, str2, arrayList4));
                    bArr2 = bArr2;
                }
                bArr = bArr2;
                j = jMax;
                o0.n nVar2 = new o0.n(arrayList3);
                URL urlB = cVar3.f13052d;
                if (bArr != null) {
                    try {
                        n0.a aVarA = n0.a.a(bArr);
                        str = aVarA.f13045b;
                        if (str == null) {
                            str = null;
                        }
                        String str6 = aVarA.f13044a;
                        if (str6 != null) {
                            urlB = n0.c.b(str6);
                        }
                    } catch (IllegalArgumentException unused2) {
                        aVar = new q0.a(3, -1L);
                    }
                } else {
                    str = null;
                }
                try {
                    e2.h hVar = new e2.h(urlB, nVar2, str);
                    j7.a aVar4 = new j7.a(cVar3, 2);
                    int i12 = 5;
                    do {
                        bVarA = aVar4.a(hVar);
                        URL url = bVarA.f13047b;
                        if (url != null) {
                            a.a.t("CctTransportBackend", "Following redirect to: %s", url);
                            hVar = new e2.h(url, (o0.n) hVar.f11233c, (String) hVar.f11231a);
                        } else {
                            hVar = null;
                        }
                        if (hVar == null) {
                            break;
                        } else {
                            i12--;
                        }
                    } while (i12 >= 1);
                    int i13 = bVarA.f13046a;
                    if (i13 == 200) {
                        aVar2 = new q0.a(1, bVarA.f13048c);
                    } else {
                        if (i13 >= 500 || i13 == 404) {
                            aVar = new q0.a(2, -1L);
                        } else if (i13 == 400) {
                            try {
                                aVar = new q0.a(4, -1L);
                            } catch (IOException e) {
                                e = e;
                                a.a.w("CctTransportBackend", "Could not make request to the backend", e);
                                i8 = 2;
                                aVar2 = new q0.a(2, -1L);
                            }
                        } else {
                            aVar = new q0.a(3, -1L);
                        }
                        aVar2 = aVar;
                    }
                } catch (IOException e4) {
                    e = e4;
                }
            }
            i8 = 2;
            int i14 = aVar2.f13367a;
            if (i14 == i8) {
                iVar.j(new com.google.firebase.crashlytics.internal.a(this, iterable, kVar, j));
                this.f17584d.l(kVar, i2 + 1, true);
                return;
            }
            fVar = this;
            kVar2 = kVar;
            jMax = j;
            iVar.j(new androidx.camera.camera2.interop.d(10, fVar, iterable));
            if (i14 == 1) {
                jMax = Math.max(jMax, aVar2.f13368b);
                if (bArr != null) {
                    iVar.j(new j7.a(fVar, 6));
                }
            } else if (i14 == 4) {
                HashMap map2 = new HashMap();
                Iterator it2 = iterable.iterator();
                while (it2.hasNext()) {
                    String str7 = ((w0.b) it2.next()).f17662c.f13286a;
                    if (map2.containsKey(str7)) {
                        map2.put(str7, Integer.valueOf(((Integer) map2.get(str7)).intValue() + 1));
                    } else {
                        map2.put(str7, 1);
                    }
                }
                iVar.j(new androidx.camera.camera2.interop.d(11, fVar, map2));
            }
            bArr2 = bArr;
        }
    }
}
