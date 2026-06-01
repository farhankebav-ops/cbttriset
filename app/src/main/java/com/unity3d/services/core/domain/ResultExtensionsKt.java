package com.unity3d.services.core.domain;

import com.unity3d.services.core.domain.task.InitializationException;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class ResultExtensionsKt {
    public static final <E extends Exception> E getCustomExceptionOrNull(Object obj) {
        k.k();
        throw null;
    }

    public static final <E extends Exception> E getCustomExceptionOrThrow(Object obj) {
        k.k();
        throw null;
    }

    public static final InitializationException getInitializationExceptionOrNull(Object obj) {
        Throwable thA = q5.k.a(obj);
        if (thA instanceof InitializationException) {
            return (InitializationException) thA;
        }
        return null;
    }

    public static final InitializationException getInitializationExceptionOrThrow(Object obj) {
        Throwable thA = q5.k.a(obj);
        if (thA instanceof InitializationException) {
            return (InitializationException) thA;
        }
        throw new IllegalArgumentException("Wrong Exception type found");
    }
}
