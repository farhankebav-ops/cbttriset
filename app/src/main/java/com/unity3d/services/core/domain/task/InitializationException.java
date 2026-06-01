package com.unity3d.services.core.domain.task;

import com.unity3d.services.core.configuration.Configuration;
import com.unity3d.services.core.configuration.ErrorState;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class InitializationException extends Exception {
    private final Configuration config;
    private final ErrorState errorState;
    private final Exception originalException;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InitializationException(ErrorState errorState, Exception originalException, Configuration config) {
        super(originalException);
        k.e(errorState, "errorState");
        k.e(originalException, "originalException");
        k.e(config, "config");
        this.errorState = errorState;
        this.originalException = originalException;
        this.config = config;
    }

    public static /* synthetic */ InitializationException copy$default(InitializationException initializationException, ErrorState errorState, Exception exc, Configuration configuration, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            errorState = initializationException.errorState;
        }
        if ((i2 & 2) != 0) {
            exc = initializationException.originalException;
        }
        if ((i2 & 4) != 0) {
            configuration = initializationException.config;
        }
        return initializationException.copy(errorState, exc, configuration);
    }

    public final ErrorState component1() {
        return this.errorState;
    }

    public final Exception component2() {
        return this.originalException;
    }

    public final Configuration component3() {
        return this.config;
    }

    public final InitializationException copy(ErrorState errorState, Exception originalException, Configuration config) {
        k.e(errorState, "errorState");
        k.e(originalException, "originalException");
        k.e(config, "config");
        return new InitializationException(errorState, originalException, config);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof InitializationException)) {
            return false;
        }
        InitializationException initializationException = (InitializationException) obj;
        return this.errorState == initializationException.errorState && k.a(this.originalException, initializationException.originalException) && k.a(this.config, initializationException.config);
    }

    public final Configuration getConfig() {
        return this.config;
    }

    public final ErrorState getErrorState() {
        return this.errorState;
    }

    public final Exception getOriginalException() {
        return this.originalException;
    }

    public int hashCode() {
        return this.config.hashCode() + ((this.originalException.hashCode() + (this.errorState.hashCode() * 31)) * 31);
    }

    @Override // java.lang.Throwable
    public String toString() {
        return "InitializationException(errorState=" + this.errorState + ", originalException=" + this.originalException + ", config=" + this.config + ')';
    }
}
