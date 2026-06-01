package androidx.camera.core.impl.utils.futures;

import j2.q;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
@FunctionalInterface
public interface AsyncFunction<I, O> {
    q apply(I i2) throws Exception;
}
