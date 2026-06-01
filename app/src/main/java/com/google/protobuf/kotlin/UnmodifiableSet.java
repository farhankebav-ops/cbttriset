package com.google.protobuf.kotlin;

import java.util.Collection;
import java.util.Set;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class UnmodifiableSet<E> extends UnmodifiableCollection<E> implements Set<E> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UnmodifiableSet(Collection<? extends E> delegate) {
        super(delegate);
        k.e(delegate, "delegate");
    }
}
