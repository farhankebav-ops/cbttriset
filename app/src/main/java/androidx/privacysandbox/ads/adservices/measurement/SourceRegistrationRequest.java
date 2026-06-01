package androidx.privacysandbox.ads.adservices.measurement;

import android.net.Uri;
import android.view.InputEvent;
import androidx.privacysandbox.ads.adservices.common.ExperimentalFeatures;
import java.util.List;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
@ExperimentalFeatures.RegisterSourceOptIn
public final class SourceRegistrationRequest {
    private final InputEvent inputEvent;
    private final List<Uri> registrationUris;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Builder {
        private InputEvent inputEvent;
        private final List<Uri> registrationUris;

        /* JADX WARN: Multi-variable type inference failed */
        public Builder(List<? extends Uri> registrationUris) {
            k.e(registrationUris, "registrationUris");
            this.registrationUris = registrationUris;
        }

        public final SourceRegistrationRequest build() {
            return new SourceRegistrationRequest(this.registrationUris, this.inputEvent);
        }

        public final Builder setInputEvent(InputEvent inputEvent) {
            k.e(inputEvent, "inputEvent");
            this.inputEvent = inputEvent;
            return this;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SourceRegistrationRequest(List<? extends Uri> registrationUris, InputEvent inputEvent) {
        k.e(registrationUris, "registrationUris");
        this.registrationUris = registrationUris;
        this.inputEvent = inputEvent;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SourceRegistrationRequest)) {
            return false;
        }
        SourceRegistrationRequest sourceRegistrationRequest = (SourceRegistrationRequest) obj;
        return k.a(this.registrationUris, sourceRegistrationRequest.registrationUris) && k.a(this.inputEvent, sourceRegistrationRequest.inputEvent);
    }

    public final InputEvent getInputEvent() {
        return this.inputEvent;
    }

    public final List<Uri> getRegistrationUris() {
        return this.registrationUris;
    }

    public int hashCode() {
        int iHashCode = this.registrationUris.hashCode();
        InputEvent inputEvent = this.inputEvent;
        if (inputEvent == null) {
            return iHashCode;
        }
        return inputEvent.hashCode() + (iHashCode * 31);
    }

    public String toString() {
        return a1.a.m("AppSourcesRegistrationRequest { ", "RegistrationUris=[" + this.registrationUris + "], InputEvent=" + this.inputEvent, " }");
    }

    public /* synthetic */ SourceRegistrationRequest(List list, InputEvent inputEvent, int i2, f fVar) {
        this(list, (i2 & 2) != 0 ? null : inputEvent);
    }
}
