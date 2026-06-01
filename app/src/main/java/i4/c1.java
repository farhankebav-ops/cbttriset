package i4;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLite;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReferenceArray;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class c1 implements i7.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f11836a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f11837b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Serializable f11838c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Serializable f11839d;
    public final Serializable e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Object f11840f;
    public final Object g;

    public c1() {
        this.f11836a = 1;
        this.f11838c = new HashMap();
        this.f11839d = new HashMap();
        this.e = new HashMap();
        this.f11840f = new HashMap();
        this.g = new HashMap();
    }

    public static String d(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        r2.q.D(str, "fullServiceName");
        sb.append(str);
        sb.append("/");
        r2.q.D(str2, "methodName");
        sb.append(str2);
        return sb.toString();
    }

    public i7.d a() {
        return new i7.d((HashMap) this.f11838c, (HashMap) this.f11839d, (HashMap) this.e, (HashMap) this.f11840f, (HashMap) this.g, this.f11837b);
    }

    @Override // i7.g
    public void b(l6.c cVar, b7.c serializer) {
        kotlin.jvm.internal.k.e(serializer, "serializer");
        l(cVar, new i7.a(serializer), false);
    }

    @Override // i7.g
    public void c(l6.c cVar, e6.l lVar) {
        j(cVar, lVar, false);
    }

    public MessageLite e(InputStream inputStream) {
        CodedInputStream codedInputStreamNewInstance;
        byte[] bArr;
        o4.b bVar = (o4.b) this.g;
        bVar.getClass();
        if ((inputStream instanceof o4.a) && ((o4.a) inputStream).f13187b == bVar.f13190a) {
            try {
                MessageLite messageLite = ((o4.a) inputStream).f13186a;
                if (messageLite != null) {
                    return messageLite;
                }
                throw new IllegalStateException("message not available");
            } catch (IllegalStateException unused) {
            }
        }
        try {
            if (inputStream instanceof i0) {
                int iAvailable = inputStream.available();
                if (iAvailable <= 0 || iAvailable > 4194304) {
                    if (iAvailable == 0) {
                        return bVar.f13191b;
                    }
                    codedInputStreamNewInstance = null;
                } else {
                    ThreadLocal threadLocal = o4.b.f13189d;
                    Reference reference = (Reference) threadLocal.get();
                    if (reference == null || (bArr = (byte[]) reference.get()) == null || bArr.length < iAvailable) {
                        bArr = new byte[iAvailable];
                        threadLocal.set(new WeakReference(bArr));
                    }
                    int i2 = iAvailable;
                    while (i2 > 0) {
                        int i8 = inputStream.read(bArr, iAvailable - i2, i2);
                        if (i8 == -1) {
                            break;
                        }
                        i2 -= i8;
                    }
                    if (i2 != 0) {
                        throw new RuntimeException("size inaccurate: " + iAvailable + " != " + (iAvailable - i2));
                    }
                    codedInputStreamNewInstance = CodedInputStream.newInstance(bArr, 0, iAvailable);
                }
            } else {
                codedInputStreamNewInstance = null;
            }
            if (codedInputStreamNewInstance == null) {
                codedInputStreamNewInstance = CodedInputStream.newInstance(inputStream);
            }
            codedInputStreamNewInstance.setSizeLimit(Integer.MAX_VALUE);
            int i9 = bVar.f13192c;
            if (i9 >= 0) {
                codedInputStreamNewInstance.setRecursionLimit(i9);
            }
            try {
                MessageLite messageLite2 = (MessageLite) bVar.f13190a.parseFrom(codedInputStreamNewInstance, o4.c.f13193a);
                try {
                    codedInputStreamNewInstance.checkLastTagWas(0);
                    return messageLite2;
                } catch (InvalidProtocolBufferException e) {
                    e.setUnfinishedMessage(messageLite2);
                    throw e;
                }
            } catch (InvalidProtocolBufferException e4) {
                throw n1.l.h("Invalid protobuf byte sequence").g(e4).a();
            }
        } catch (IOException e8) {
            throw new RuntimeException(e8);
        }
    }

    @Override // i7.g
    public void f(l6.c cVar, e6.l lVar) {
        i(cVar, lVar, false);
    }

    @Override // i7.g
    public void g(l6.c kClass, e6.l lVar) {
        kotlin.jvm.internal.k.e(kClass, "kClass");
        l(kClass, new i7.b(lVar), false);
    }

    @Override // i7.g
    public void h(l6.c cVar, l6.c cVar2, b7.c cVar3) {
        k(cVar, cVar2, cVar3, false);
    }

    public void i(l6.c cVar, e6.l lVar, boolean z2) {
        HashMap map = (HashMap) this.g;
        e6.l lVar2 = (e6.l) map.get(cVar);
        if (lVar2 == null || lVar2.equals(lVar) || z2) {
            map.put(cVar, lVar);
            return;
        }
        throw new IllegalArgumentException("Default deserializers provider for " + cVar + " is already registered: " + lVar2);
    }

    public void j(l6.c cVar, e6.l lVar, boolean z2) {
        HashMap map = (HashMap) this.e;
        e6.l lVar2 = (e6.l) map.get(cVar);
        if (lVar2 == null || lVar2.equals(lVar) || z2) {
            map.put(cVar, lVar);
            return;
        }
        throw new IllegalArgumentException("Default serializers provider for " + cVar + " is already registered: " + lVar2);
    }

    public void k(l6.c cVar, l6.c cVar2, b7.c cVar3, boolean z2) {
        Object next;
        String strH = cVar3.getDescriptor().h();
        HashMap map = (HashMap) this.f11839d;
        Object map2 = map.get(cVar);
        if (map2 == null) {
            map2 = new HashMap();
            map.put(cVar, map2);
        }
        Map map3 = (Map) map2;
        b7.c cVar4 = (b7.c) map3.get(cVar2);
        HashMap map4 = (HashMap) this.f11840f;
        Object map5 = map4.get(cVar);
        if (map5 == null) {
            map5 = new HashMap();
            map4.put(cVar, map5);
        }
        Map map6 = (Map) map5;
        if (z2) {
            if (cVar4 != null) {
                map6.remove(cVar4.getDescriptor().h());
            }
            map3.put(cVar2, cVar3);
            map6.put(strH, cVar3);
            return;
        }
        if (cVar4 != null) {
            if (!cVar4.equals(cVar3)) {
                throw new i7.e("Serializer for " + cVar2 + " already registered in the scope of " + cVar);
            }
        }
        b7.c cVar5 = (b7.c) map6.get(strH);
        if (cVar5 == null) {
            map3.put(cVar2, cVar3);
            map6.put(strH, cVar3);
            return;
        }
        Object obj = map.get(cVar);
        kotlin.jvm.internal.k.b(obj);
        Iterator it = ((Iterable) r5.l.S0(((Map) obj).entrySet()).f4240b).iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            } else {
                next = it.next();
                if (((Map.Entry) next).getValue() == cVar5) {
                    break;
                }
            }
        }
        throw new IllegalArgumentException("Multiple polymorphic serializers for base class '" + cVar + "' have the same serial name '" + strH + "': '" + cVar2 + "' and '" + ((Map.Entry) next) + '\'');
    }

    public void l(l6.c forClass, i7.c cVar, boolean z2) {
        i7.c cVar2;
        HashMap map = (HashMap) this.f11838c;
        kotlin.jvm.internal.k.e(forClass, "forClass");
        if (!z2 && (cVar2 = (i7.c) map.get(forClass)) != null && !cVar2.equals(cVar)) {
            throw new i7.e("Contextual serializer or serializer provider for " + forClass + " already registered in this module");
        }
        map.put(forClass, cVar);
        if (f7.c1.g(forClass)) {
            this.f11837b = true;
        }
    }

    public o4.a m(Object obj) {
        o4.b bVar = (o4.b) this.f11840f;
        bVar.getClass();
        return new o4.a((MessageLite) obj, bVar.f13190a);
    }

    public String toString() {
        switch (this.f11836a) {
            case 0:
                e2.i iVarY = a.a.Y(this);
                iVarY.c((String) this.f11839d, "fullMethodName");
                iVarY.c((b1) this.f11838c, "type");
                iVarY.e("idempotent", false);
                iVarY.e("safe", false);
                iVarY.e("sampledToLocalTracing", this.f11837b);
                iVarY.c((o4.b) this.f11840f, "requestMarshaller");
                iVarY.c((o4.b) this.g, "responseMarshaller");
                iVarY.c(null, "schemaDescriptor");
                iVarY.f11235b = true;
                return iVarY.toString();
            default:
                return super.toString();
        }
    }

    public c1(String str, o4.b bVar, o4.b bVar2) {
        this.f11836a = 0;
        new AtomicReferenceArray(2);
        this.f11838c = b1.f11827a;
        r2.q.D(str, "fullMethodName");
        this.f11839d = str;
        int iLastIndexOf = str.lastIndexOf(47);
        this.e = iLastIndexOf == -1 ? null : str.substring(0, iLastIndexOf);
        this.f11840f = bVar;
        this.g = bVar2;
        this.f11837b = true;
    }
}
