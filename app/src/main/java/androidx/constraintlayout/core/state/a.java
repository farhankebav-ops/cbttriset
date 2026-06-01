package androidx.constraintlayout.core.state;

import com.google.firebase.inappmessaging.internal.InAppMessageStreamManager;
import com.google.gson.internal.ConstructorConstructor;
import com.google.gson.internal.ObjectConstructor;
import q2.f;
import x4.d;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class a implements Interpolator, d, ObjectConstructor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3918a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f3919b;

    public /* synthetic */ a(String str, int i2) {
        this.f3918a = i2;
        this.f3919b = str;
    }

    @Override // com.google.gson.internal.ObjectConstructor
    public Object construct() {
        switch (this.f3918a) {
            case 2:
                return ConstructorConstructor.lambda$newUnsafeAllocator$20(this.f3919b);
            case 3:
                return ConstructorConstructor.lambda$newDefaultConstructor$7(this.f3919b);
            case 4:
                return ConstructorConstructor.lambda$newDefaultConstructor$8(this.f3919b);
            case 5:
                return ConstructorConstructor.lambda$get$2(this.f3919b);
            case 6:
                return ConstructorConstructor.lambda$get$3(this.f3919b);
            default:
                return ConstructorConstructor.lambda$get$4(this.f3919b);
        }
    }

    @Override // androidx.constraintlayout.core.state.Interpolator
    public float getInterpolation(float f4) {
        return Transition.lambda$getInterpolator$0(this.f3919b, f4);
    }

    @Override // x4.d
    public boolean test(Object obj) {
        return InAppMessageStreamManager.containsTriggeringCondition(this.f3919b, (f) obj);
    }
}
