package com.unity3d.ads.core.data.model.exception;

import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class ExposureException extends Exception {
    private final Object[] parameters;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ExposureException(String message, Object[] parameters) {
        super(message);
        k.e(message, "message");
        k.e(parameters, "parameters");
        this.parameters = parameters;
    }

    public final Object[] getParameters() {
        return this.parameters;
    }
}
