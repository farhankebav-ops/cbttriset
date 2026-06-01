package com.google.firebase.platforminfo;

import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;
import com.google.firebase.platforminfo.LibraryVersionComponent;
import com.google.firebase.tracing.ComponentMonitor;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class a implements ComponentFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5710a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f5711b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f5712c;

    public /* synthetic */ a(String str, Object obj, int i2) {
        this.f5710a = i2;
        this.f5711b = str;
        this.f5712c = obj;
    }

    @Override // com.google.firebase.components.ComponentFactory
    public final Object create(ComponentContainer componentContainer) {
        switch (this.f5710a) {
            case 0:
                return LibraryVersionComponent.lambda$fromContext$0(this.f5711b, (LibraryVersionComponent.VersionExtractor) this.f5712c, componentContainer);
            default:
                return ComponentMonitor.lambda$processRegistrar$0(this.f5711b, (Component) this.f5712c, componentContainer);
        }
    }
}
