package com.google.firebase.inappmessaging.internal;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.Parser;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class q implements Callable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5655a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ProtoStorageClient f5656b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f5657c;

    public /* synthetic */ q(ProtoStorageClient protoStorageClient, Object obj, int i2) {
        this.f5655a = i2;
        this.f5656b = protoStorageClient;
        this.f5657c = obj;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        switch (this.f5655a) {
            case 0:
                return this.f5656b.lambda$write$0((AbstractMessageLite) this.f5657c);
            default:
                return this.f5656b.lambda$read$1((Parser) this.f5657c);
        }
    }
}
