package androidx.privacysandbox.ads.adservices.measurement;

import android.net.Uri;
import android.view.InputEvent;
import androidx.annotation.RequiresExtension;
import java.util.List;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class WebSourceRegistrationRequest {
    private final Uri appDestination;
    private final InputEvent inputEvent;
    private final Uri topOriginUri;
    private final Uri verifiedDestination;
    private final Uri webDestination;
    private final List<WebSourceParams> webSourceParams;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Builder {
        private Uri appDestination;
        private InputEvent inputEvent;
        private final Uri topOriginUri;
        private Uri verifiedDestination;
        private Uri webDestination;
        private final List<WebSourceParams> webSourceParams;

        public Builder(List<WebSourceParams> webSourceParams, Uri topOriginUri) {
            k.e(webSourceParams, "webSourceParams");
            k.e(topOriginUri, "topOriginUri");
            this.webSourceParams = webSourceParams;
            this.topOriginUri = topOriginUri;
        }

        public final WebSourceRegistrationRequest build() {
            return new WebSourceRegistrationRequest(this.webSourceParams, this.topOriginUri, this.inputEvent, this.appDestination, this.webDestination, this.verifiedDestination);
        }

        public final Builder setAppDestination(Uri uri) {
            this.appDestination = uri;
            return this;
        }

        public final Builder setInputEvent(InputEvent inputEvent) {
            k.e(inputEvent, "inputEvent");
            this.inputEvent = inputEvent;
            return this;
        }

        public final Builder setVerifiedDestination(Uri uri) {
            this.verifiedDestination = uri;
            return this;
        }

        public final Builder setWebDestination(Uri uri) {
            this.webDestination = uri;
            return this;
        }
    }

    public WebSourceRegistrationRequest(List<WebSourceParams> webSourceParams, Uri topOriginUri, InputEvent inputEvent, Uri uri, Uri uri2, Uri uri3) {
        k.e(webSourceParams, "webSourceParams");
        k.e(topOriginUri, "topOriginUri");
        this.webSourceParams = webSourceParams;
        this.topOriginUri = topOriginUri;
        this.inputEvent = inputEvent;
        this.appDestination = uri;
        this.webDestination = uri2;
        this.verifiedDestination = uri3;
    }

    @RequiresExtension.Container({@RequiresExtension(extension = 1000000, version = 4), @RequiresExtension(extension = 31, version = 9)})
    public final android.adservices.measurement.WebSourceRegistrationRequest convertToAdServices$ads_adservices_release() {
        a.z();
        android.adservices.measurement.WebSourceRegistrationRequest webSourceRegistrationRequestBuild = a.g(WebSourceParams.Companion.convertWebSourceParams$ads_adservices_release(this.webSourceParams), this.topOriginUri).setWebDestination(this.webDestination).setAppDestination(this.appDestination).setInputEvent(this.inputEvent).setVerifiedDestination(this.verifiedDestination).build();
        k.d(webSourceRegistrationRequestBuild, "Builder(\n               …ion)\n            .build()");
        return webSourceRegistrationRequestBuild;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WebSourceRegistrationRequest)) {
            return false;
        }
        WebSourceRegistrationRequest webSourceRegistrationRequest = (WebSourceRegistrationRequest) obj;
        return k.a(this.webSourceParams, webSourceRegistrationRequest.webSourceParams) && k.a(this.webDestination, webSourceRegistrationRequest.webDestination) && k.a(this.appDestination, webSourceRegistrationRequest.appDestination) && k.a(this.topOriginUri, webSourceRegistrationRequest.topOriginUri) && k.a(this.inputEvent, webSourceRegistrationRequest.inputEvent) && k.a(this.verifiedDestination, webSourceRegistrationRequest.verifiedDestination);
    }

    public final Uri getAppDestination() {
        return this.appDestination;
    }

    public final InputEvent getInputEvent() {
        return this.inputEvent;
    }

    public final Uri getTopOriginUri() {
        return this.topOriginUri;
    }

    public final Uri getVerifiedDestination() {
        return this.verifiedDestination;
    }

    public final Uri getWebDestination() {
        return this.webDestination;
    }

    public final List<WebSourceParams> getWebSourceParams() {
        return this.webSourceParams;
    }

    public int hashCode() {
        int iHashCode = this.topOriginUri.hashCode() + (this.webSourceParams.hashCode() * 31);
        InputEvent inputEvent = this.inputEvent;
        if (inputEvent != null) {
            iHashCode = (iHashCode * 31) + inputEvent.hashCode();
        }
        Uri uri = this.appDestination;
        if (uri != null) {
            iHashCode = (iHashCode * 31) + uri.hashCode();
        }
        Uri uri2 = this.webDestination;
        if (uri2 != null) {
            iHashCode = (iHashCode * 31) + uri2.hashCode();
        }
        int iHashCode2 = this.topOriginUri.hashCode() + (iHashCode * 31);
        InputEvent inputEvent2 = this.inputEvent;
        if (inputEvent2 != null) {
            iHashCode2 = (iHashCode2 * 31) + inputEvent2.hashCode();
        }
        Uri uri3 = this.verifiedDestination;
        if (uri3 == null) {
            return iHashCode2;
        }
        return uri3.hashCode() + (iHashCode2 * 31);
    }

    public String toString() {
        return a1.a.m("WebSourceRegistrationRequest { ", "WebSourceParams=[" + this.webSourceParams + "], TopOriginUri=" + this.topOriginUri + ", InputEvent=" + this.inputEvent + ", AppDestination=" + this.appDestination + ", WebDestination=" + this.webDestination + ", VerifiedDestination=" + this.verifiedDestination, " }");
    }

    public /* synthetic */ WebSourceRegistrationRequest(List list, Uri uri, InputEvent inputEvent, Uri uri2, Uri uri3, Uri uri4, int i2, f fVar) {
        this(list, uri, (i2 & 4) != 0 ? null : inputEvent, (i2 & 8) != 0 ? null : uri2, (i2 & 16) != 0 ? null : uri3, (i2 & 32) != 0 ? null : uri4);
    }
}
