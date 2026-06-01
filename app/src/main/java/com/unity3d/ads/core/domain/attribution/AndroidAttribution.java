package com.unity3d.ads.core.domain.attribution;

import android.adservices.AdServicesState;
import android.adservices.measurement.MeasurementManager;
import android.content.Context;
import android.net.Uri;
import android.os.OutcomeReceiver;
import android.os.ext.SdkExtensions;
import android.view.InputEvent;
import androidx.privacysandbox.ads.adservices.customaudience.a;
import com.unity3d.ads.adplayer.AdPlayer;
import com.unity3d.ads.adplayer.WebViewContainer;
import com.unity3d.ads.core.data.model.AdObject;
import com.unity3d.ads.core.data.repository.SessionRepository;
import com.unity3d.ads.core.domain.HandleInvocationsFromAdViewer;
import com.unity3d.ads.core.extensions.ProtobufExtensionsKt;
import com.unity3d.services.core.device.Device;
import com.unity3d.services.core.domain.ISDKDispatchers;
import kotlin.jvm.internal.k;
import n7.b;
import q5.f;
import q5.x;
import q6.c0;
import t6.b1;
import v5.c;
import v5.j;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class AndroidAttribution {
    private final ISDKDispatchers dispatchers;
    private final f measurementManager$delegate;
    private final SessionRepository sessionRepository;

    public AndroidAttribution(Context context, ISDKDispatchers dispatchers, SessionRepository sessionRepository) {
        k.e(context, "context");
        k.e(dispatchers, "dispatchers");
        k.e(sessionRepository, "sessionRepository");
        this.dispatchers = dispatchers;
        this.sessionRepository = sessionRepository;
        this.measurementManager$delegate = b.C(new AndroidAttribution$measurementManager$2(this, context));
    }

    private final MeasurementManager getMeasurementManager() {
        return a.u(this.measurementManager$delegate.getValue());
    }

    private final Uri getUri(String str, AdObject adObject) {
        Uri uri = Uri.parse(str);
        k.d(uri, "parse(this)");
        Uri uriBuild = uri.buildUpon().appendQueryParameter("sessionToken", ProtobufExtensionsKt.toBase64$default(this.sessionRepository.getSessionToken(), false, 1, null)).appendQueryParameter(HandleInvocationsFromAdViewer.KEY_TRACKING_TOKEN, ProtobufExtensionsKt.toBase64$default(adObject.getTrackingToken(), false, 1, null)).build();
        k.d(uriBuild, "baseUrl.toUri()\n        …4())\n            .build()");
        return uriBuild;
    }

    public final Object isAvailable(c<? super Boolean> cVar) throws Throwable {
        x xVar;
        if (Device.getApiLevel() < 33) {
            return Boolean.FALSE;
        }
        if (SdkExtensions.getExtensionVersion(1000000) < 4) {
            return Boolean.FALSE;
        }
        if (getMeasurementManager() == null) {
            return Boolean.FALSE;
        }
        if (!AdServicesState.isAdServicesStateEnabled()) {
            return Boolean.FALSE;
        }
        final j jVar = new j(a.a.I(cVar));
        MeasurementManager measurementManager = getMeasurementManager();
        if (measurementManager != null) {
            measurementManager.getMeasurementApiStatus(c0.f(this.dispatchers.getDefault()), new OutcomeReceiver() { // from class: com.unity3d.ads.core.domain.attribution.AndroidAttribution$isAvailable$2$1
                public /* bridge */ /* synthetic */ void onResult(Object obj) {
                    onResult(((Number) obj).intValue());
                }

                public void onError(Exception error) {
                    k.e(error, "error");
                    jVar.resumeWith(Boolean.FALSE);
                }

                public void onResult(int i2) {
                    jVar.resumeWith(Boolean.valueOf(i2 == 1));
                }
            });
            xVar = x.f13520a;
        } else {
            xVar = null;
        }
        if (xVar == null) {
            jVar.resumeWith(Boolean.FALSE);
        }
        Object objA = jVar.a();
        w5.a aVar = w5.a.f17774a;
        return objA;
    }

    public final Object registerClick(String str, AdObject adObject, c<? super Boolean> cVar) throws Throwable {
        WebViewContainer webViewContainer;
        b1 lastInputEvent;
        InputEvent inputEvent;
        x xVar;
        if (getMeasurementManager() == null) {
            return Boolean.FALSE;
        }
        AdPlayer adPlayer = adObject.getAdPlayer();
        if (adPlayer == null || (webViewContainer = adPlayer.getWebViewContainer()) == null || (lastInputEvent = webViewContainer.getLastInputEvent()) == null || (inputEvent = (InputEvent) lastInputEvent.getValue()) == null) {
            return Boolean.FALSE;
        }
        final j jVar = new j(a.a.I(cVar));
        MeasurementManager measurementManager = getMeasurementManager();
        if (measurementManager != null) {
            measurementManager.registerSource(getUri(str, adObject), inputEvent, c0.f(this.dispatchers.getDefault()), new OutcomeReceiver() { // from class: com.unity3d.ads.core.domain.attribution.AndroidAttribution$registerClick$2$1
                public void onResult(Object p02) {
                    k.e(p02, "p0");
                    jVar.resumeWith(Boolean.TRUE);
                }

                public void onError(Exception error) {
                    k.e(error, "error");
                    jVar.resumeWith(Boolean.FALSE);
                }
            });
            xVar = x.f13520a;
        } else {
            xVar = null;
        }
        if (xVar == null) {
            jVar.resumeWith(Boolean.FALSE);
        }
        Object objA = jVar.a();
        w5.a aVar = w5.a.f17774a;
        return objA;
    }

    public final Object registerView(String str, AdObject adObject, c<? super Boolean> cVar) throws Throwable {
        x xVar;
        if (getMeasurementManager() == null) {
            return Boolean.FALSE;
        }
        final j jVar = new j(a.a.I(cVar));
        MeasurementManager measurementManager = getMeasurementManager();
        if (measurementManager != null) {
            measurementManager.registerSource(getUri(str, adObject), null, c0.f(this.dispatchers.getDefault()), new OutcomeReceiver() { // from class: com.unity3d.ads.core.domain.attribution.AndroidAttribution$registerView$2$1
                public void onResult(Object p02) {
                    k.e(p02, "p0");
                    jVar.resumeWith(Boolean.TRUE);
                }

                public void onError(Exception error) {
                    k.e(error, "error");
                    jVar.resumeWith(Boolean.FALSE);
                }
            });
            xVar = x.f13520a;
        } else {
            xVar = null;
        }
        if (xVar == null) {
            jVar.resumeWith(Boolean.FALSE);
        }
        Object objA = jVar.a();
        w5.a aVar = w5.a.f17774a;
        return objA;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final MeasurementManager getMeasurementManager(Context context) {
        if (Device.getApiLevel() >= 33 && SdkExtensions.getExtensionVersion(1000000) >= 4) {
            return a.u(context.getSystemService(a.v()));
        }
        return null;
    }
}
