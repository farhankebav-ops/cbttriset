package kotlin.jvm.internal;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class i extends c implements h, l6.e {
    private final int arity;
    private final int flags;

    public i(int i2, Object obj, Class cls, String str, String str2, int i8) {
        super(obj, cls, str, str2, (i8 & 1) == 1);
        this.arity = i2;
        this.flags = 0;
    }

    @Override // kotlin.jvm.internal.c
    public l6.b computeReflected() {
        b0.f12719a.getClass();
        return this;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof i) {
            i iVar = (i) obj;
            return getName().equals(iVar.getName()) && getSignature().equals(iVar.getSignature()) && this.flags == iVar.flags && this.arity == iVar.arity && k.a(getBoundReceiver(), iVar.getBoundReceiver()) && k.a(getOwner(), iVar.getOwner());
        }
        if (obj instanceof l6.e) {
            return obj.equals(compute());
        }
        return false;
    }

    @Override // kotlin.jvm.internal.h
    public int getArity() {
        return this.arity;
    }

    public int hashCode() {
        return getSignature().hashCode() + ((getName().hashCode() + (getOwner() == null ? 0 : getOwner().hashCode() * 31)) * 31);
    }

    @Override // l6.e
    public boolean isExternal() {
        return getReflected().isExternal();
    }

    @Override // l6.e
    public boolean isInfix() {
        return getReflected().isInfix();
    }

    @Override // l6.e
    public boolean isInline() {
        return getReflected().isInline();
    }

    @Override // l6.e
    public boolean isOperator() {
        return getReflected().isOperator();
    }

    @Override // kotlin.jvm.internal.c, l6.b
    public boolean isSuspend() {
        return getReflected().isSuspend();
    }

    public String toString() {
        l6.b bVarCompute = compute();
        if (bVarCompute != this) {
            return bVarCompute.toString();
        }
        if ("<init>".equals(getName())) {
            return "constructor (Kotlin reflection is not available)";
        }
        return "function " + getName() + " (Kotlin reflection is not available)";
    }

    @Override // kotlin.jvm.internal.c
    public l6.e getReflected() {
        l6.b bVarCompute = compute();
        if (bVarCompute != this) {
            return (l6.e) bVarCompute;
        }
        throw new d6.a("Kotlin reflection implementation is not found at runtime. Make sure you have kotlin-reflect.jar in the classpath");
    }
}
