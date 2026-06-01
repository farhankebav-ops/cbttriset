package com.unity3d.ads.core.data.model;

import a1.a;
import com.unity3d.ads.adplayer.model.ShowStatus;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class ShowEvent {

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class CancelTimeout extends ShowEvent {
        public static final CancelTimeout INSTANCE = new CancelTimeout();

        private CancelTimeout() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Clicked extends ShowEvent {
        public static final Clicked INSTANCE = new Clicked();

        private Clicked() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Completed extends ShowEvent {
        private final String reason;
        private final String reasonDebug;
        private final ShowStatus status;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Completed(ShowStatus status, String str, String str2) {
            super(null);
            k.e(status, "status");
            this.status = status;
            this.reason = str;
            this.reasonDebug = str2;
        }

        public static /* synthetic */ Completed copy$default(Completed completed, ShowStatus showStatus, String str, String str2, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                showStatus = completed.status;
            }
            if ((i2 & 2) != 0) {
                str = completed.reason;
            }
            if ((i2 & 4) != 0) {
                str2 = completed.reasonDebug;
            }
            return completed.copy(showStatus, str, str2);
        }

        public final ShowStatus component1() {
            return this.status;
        }

        public final String component2() {
            return this.reason;
        }

        public final String component3() {
            return this.reasonDebug;
        }

        public final Completed copy(ShowStatus status, String str, String str2) {
            k.e(status, "status");
            return new Completed(status, str, str2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Completed)) {
                return false;
            }
            Completed completed = (Completed) obj;
            return this.status == completed.status && k.a(this.reason, completed.reason) && k.a(this.reasonDebug, completed.reasonDebug);
        }

        public final String getReason() {
            return this.reason;
        }

        public final String getReasonDebug() {
            return this.reasonDebug;
        }

        public final ShowStatus getStatus() {
            return this.status;
        }

        public int hashCode() {
            int iHashCode = this.status.hashCode() * 31;
            String str = this.reason;
            int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.reasonDebug;
            return iHashCode2 + (str2 != null ? str2.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("Completed(status=");
            sb.append(this.status);
            sb.append(", reason=");
            sb.append(this.reason);
            sb.append(", reasonDebug=");
            return a.e(')', this.reasonDebug, sb);
        }

        public /* synthetic */ Completed(ShowStatus showStatus, String str, String str2, int i2, f fVar) {
            this(showStatus, (i2 & 2) != 0 ? null : str, (i2 & 4) != 0 ? null : str2);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Error extends ShowEvent {
        private final int errorCode;
        private final String message;
        private final String reason;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Error(String message, int i2, String reason) {
            super(null);
            k.e(message, "message");
            k.e(reason, "reason");
            this.message = message;
            this.errorCode = i2;
            this.reason = reason;
        }

        public static /* synthetic */ Error copy$default(Error error, String str, int i2, String str2, int i8, Object obj) {
            if ((i8 & 1) != 0) {
                str = error.message;
            }
            if ((i8 & 2) != 0) {
                i2 = error.errorCode;
            }
            if ((i8 & 4) != 0) {
                str2 = error.reason;
            }
            return error.copy(str, i2, str2);
        }

        public final String component1() {
            return this.message;
        }

        public final int component2() {
            return this.errorCode;
        }

        public final String component3() {
            return this.reason;
        }

        public final Error copy(String message, int i2, String reason) {
            k.e(message, "message");
            k.e(reason, "reason");
            return new Error(message, i2, reason);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Error)) {
                return false;
            }
            Error error = (Error) obj;
            return k.a(this.message, error.message) && this.errorCode == error.errorCode && k.a(this.reason, error.reason);
        }

        public final int getErrorCode() {
            return this.errorCode;
        }

        public final String getMessage() {
            return this.message;
        }

        public final String getReason() {
            return this.reason;
        }

        public int hashCode() {
            return this.reason.hashCode() + (((this.message.hashCode() * 31) + this.errorCode) * 31);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("Error(message=");
            sb.append(this.message);
            sb.append(", errorCode=");
            sb.append(this.errorCode);
            sb.append(", reason=");
            return a.e(')', this.reason, sb);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class LeftApplication extends ShowEvent {
        public static final LeftApplication INSTANCE = new LeftApplication();

        private LeftApplication() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Started extends ShowEvent {
        public static final Started INSTANCE = new Started();

        private Started() {
            super(null);
        }
    }

    public /* synthetic */ ShowEvent(f fVar) {
        this();
    }

    private ShowEvent() {
    }
}
