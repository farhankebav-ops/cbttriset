package com.unity3d.ads.core.domain;

import com.unity3d.ads.core.domain.SendDiagnosticEvent;
import com.unity3d.services.core.configuration.InitializeEventsMetricSender;
import com.unity3d.services.core.properties.ClientProperties;
import com.unity3d.services.core.properties.SdkProperties;
import com.unity3d.services.core.request.metrics.Metric;
import java.util.Map;
import kotlin.jvm.internal.k;
import q5.i;
import r5.x;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class CommonCheckForGameIdAndTestModeChanges implements CheckForGameIdAndTestModeChanges {
    private final GetGameId getGameId;
    private final SendDiagnosticEvent sendDiagnosticEvent;

    public CommonCheckForGameIdAndTestModeChanges(GetGameId getGameId, SendDiagnosticEvent sendDiagnosticEvent) {
        k.e(getGameId, "getGameId");
        k.e(sendDiagnosticEvent, "sendDiagnosticEvent");
        this.getGameId = getGameId;
        this.sendDiagnosticEvent = sendDiagnosticEvent;
    }

    private final void sendDiagnostic(String str, Map<String, String> map, boolean z2) {
        if (z2) {
            InitializeEventsMetricSender.getInstance().sendMetric(new Metric(str, map, null, 4, null));
        } else {
            SendDiagnosticEvent.DefaultImpls.invoke$default(this.sendDiagnosticEvent, str, null, map, null, null, null, 58, null);
        }
    }

    @Override // com.unity3d.ads.core.domain.CheckForGameIdAndTestModeChanges
    public void invoke(boolean z2) {
        String strInvoke = this.getGameId.invoke();
        if (strInvoke == null) {
            strInvoke = "null";
        }
        String previousGameId = ClientProperties.getPreviousGameId();
        if (previousGameId == null) {
            previousGameId = "null";
        }
        Map<String, String> mapF0 = x.f0(new i("previous_game_id", previousGameId), new i("game_id", strInvoke));
        if (previousGameId.equals("null")) {
            return;
        }
        if (strInvoke.equals(previousGameId)) {
            sendDiagnostic("native_initialize_game_id_same", mapF0, z2);
        } else {
            sendDiagnostic("native_initialize_game_id_changed", mapF0, z2);
        }
        boolean zIsTestMode = SdkProperties.isTestMode();
        boolean previousTestMode = SdkProperties.getPreviousTestMode();
        Map<String, String> mapF02 = x.f0(new i("previous_test_mode", String.valueOf(previousTestMode)), new i("test_mode", String.valueOf(zIsTestMode)));
        if (zIsTestMode != previousTestMode) {
            sendDiagnostic("native_initialize_test_mode_changed", mapF02, z2);
        } else {
            sendDiagnostic("native_initialize_test_mode_same", mapF02, z2);
        }
    }
}
