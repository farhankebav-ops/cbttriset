package kotlin.jvm.internal;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class v extends c implements l6.q {
    private final boolean syntheticJavaProperty;

    public v(Object obj, Class cls, String str, String str2, int i2) {
        super(obj, cls, str, str2, (i2 & 1) == 1);
        this.syntheticJavaProperty = (i2 & 2) == 2;
    }

    @Override // kotlin.jvm.internal.c
    public l6.b compute() {
        return this.syntheticJavaProperty ? this : super.compute();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof v) {
            v vVar = (v) obj;
            return getOwner().equals(vVar.getOwner()) && getName().equals(vVar.getName()) && getSignature().equals(vVar.getSignature()) && k.a(getBoundReceiver(), vVar.getBoundReceiver());
        }
        if (obj instanceof l6.q) {
            return obj.equals(compute());
        }
        return false;
    }

    public int hashCode() {
        return getSignature().hashCode() + ((getName().hashCode() + (getOwner().hashCode() * 31)) * 31);
    }

    @Override // l6.q
    public boolean isConst() {
        return getReflected().isConst();
    }

    @Override // l6.q
    public boolean isLateinit() {
        return getReflected().isLateinit();
    }

    public String toString() {
        l6.b bVarCompute = compute();
        if (bVarCompute != this) {
            return bVarCompute.toString();
        }
        return "property " + getName() + " (Kotlin reflection is not available)";
    }

    @Override // kotlin.jvm.internal.c
    public l6.q getReflected() {
        if (this.syntheticJavaProperty) {
            throw new UnsupportedOperationException("Kotlin reflection is not yet supported for synthetic Java properties. Please follow/upvote https://youtrack.jetbrains.com/issue/KT-55980");
        }
        l6.b bVarCompute = compute();
        if (bVarCompute != this) {
            return (l6.q) bVarCompute;
        }
        throw new d6.a("Kotlin reflection implementation is not found at runtime. Make sure you have kotlin-reflect.jar in the classpath");
    }
}
