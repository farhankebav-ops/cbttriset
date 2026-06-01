package com.google.firebase.components;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class a implements ComponentFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5517a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f5518b;

    public /* synthetic */ a(Object obj, int i2) {
        this.f5517a = i2;
        this.f5518b = obj;
    }

    @Override // com.google.firebase.components.ComponentFactory
    public final Object create(ComponentContainer componentContainer) {
        switch (this.f5517a) {
            case 0:
                return Component.lambda$of$2(this.f5518b, componentContainer);
            case 1:
                return Component.lambda$intoSet$4(this.f5518b, componentContainer);
            case 2:
                return Component.lambda$intoSet$3(this.f5518b, componentContainer);
            case 3:
                return Component.lambda$of$0(this.f5518b, componentContainer);
            default:
                return Component.lambda$of$1(this.f5518b, componentContainer);
        }
    }
}
