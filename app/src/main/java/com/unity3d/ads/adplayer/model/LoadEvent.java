package com.unity3d.ads.adplayer.model;

import com.ironsource.adqualitysdk.sdk.i.a0;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class LoadEvent {

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Completed extends LoadEvent {
        public static final Completed INSTANCE = new Completed();

        private Completed() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Error extends LoadEvent {
        private final int errorCode;
        private final String message;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Error(String message, int i2) {
            super(null);
            k.e(message, "message");
            this.message = message;
            this.errorCode = i2;
        }

        public static /* synthetic */ Error copy$default(Error error, String str, int i2, int i8, Object obj) {
            if ((i8 & 1) != 0) {
                str = error.message;
            }
            if ((i8 & 2) != 0) {
                i2 = error.errorCode;
            }
            return error.copy(str, i2);
        }

        public final String component1() {
            return this.message;
        }

        public final int component2() {
            return this.errorCode;
        }

        public final Error copy(String message, int i2) {
            k.e(message, "message");
            return new Error(message, i2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Error)) {
                return false;
            }
            Error error = (Error) obj;
            return k.a(this.message, error.message) && this.errorCode == error.errorCode;
        }

        public final int getErrorCode() {
            return this.errorCode;
        }

        public final String getMessage() {
            return this.message;
        }

        public int hashCode() {
            return (this.message.hashCode() * 31) + this.errorCode;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("Error(message=");
            sb.append(this.message);
            sb.append(", errorCode=");
            return a0.c(sb, this.errorCode, ')');
        }
    }

    public /* synthetic */ LoadEvent(f fVar) {
        this();
    }

    private LoadEvent() {
    }
}
