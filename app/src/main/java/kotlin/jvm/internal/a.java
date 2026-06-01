package kotlin.jvm.internal;

import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class a implements h, Serializable {
    private final int arity;
    private final int flags;
    private final boolean isTopLevel = false;
    private final String name;
    private final Class owner;
    protected final Object receiver;
    private final String signature;

    public a(int i2, Object obj, Class cls, String str, String str2, int i8) {
        this.receiver = obj;
        this.owner = cls;
        this.name = str;
        this.signature = str2;
        this.arity = i2;
        this.flags = i8 >> 1;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.isTopLevel == aVar.isTopLevel && this.arity == aVar.arity && this.flags == aVar.flags && k.a(this.receiver, aVar.receiver) && k.a(this.owner, aVar.owner) && this.name.equals(aVar.name) && this.signature.equals(aVar.signature);
    }

    @Override // kotlin.jvm.internal.h
    public int getArity() {
        return this.arity;
    }

    public l6.d getOwner() {
        Class cls = this.owner;
        if (cls == null) {
            return null;
        }
        if (!this.isTopLevel) {
            return b0.a(cls);
        }
        b0.f12719a.getClass();
        return new r(cls);
    }

    public int hashCode() {
        Object obj = this.receiver;
        int iHashCode = (obj != null ? obj.hashCode() : 0) * 31;
        Class cls = this.owner;
        return ((((androidx.camera.core.processing.util.a.b(androidx.camera.core.processing.util.a.b((iHashCode + (cls != null ? cls.hashCode() : 0)) * 31, 31, this.name), 31, this.signature) + (this.isTopLevel ? 1231 : 1237)) * 31) + this.arity) * 31) + this.flags;
    }

    public String toString() {
        b0.f12719a.getClass();
        return c0.a(this);
    }
}
