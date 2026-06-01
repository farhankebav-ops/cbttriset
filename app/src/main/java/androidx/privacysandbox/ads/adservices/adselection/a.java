package androidx.privacysandbox.ads.adservices.adselection;

import android.adservices.appsetid.AppSetId;
import android.adservices.appsetid.AppSetIdManager;
import android.adservices.common.AdData;
import android.adservices.customaudience.CustomAudienceManager;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class a {
    public static /* bridge */ /* synthetic */ void B(Object obj) {
    }

    public static /* bridge */ /* synthetic */ Class D() {
        return CustomAudienceManager.class;
    }

    public static /* synthetic */ android.adservices.adselection.ReportImpressionRequest c(long j, android.adservices.adselection.AdSelectionConfig adSelectionConfig) {
        return new android.adservices.adselection.ReportImpressionRequest(j, adSelectionConfig);
    }

    public static /* bridge */ /* synthetic */ AppSetId d(Object obj) {
        return (AppSetId) obj;
    }

    public static /* bridge */ /* synthetic */ AppSetIdManager f(Object obj) {
        return (AppSetIdManager) obj;
    }

    public static /* synthetic */ AdData.Builder g() {
        return new AdData.Builder();
    }

    public static /* bridge */ /* synthetic */ CustomAudienceManager t(Object obj) {
        return (CustomAudienceManager) obj;
    }

    public static /* bridge */ /* synthetic */ Class w() {
        return AppSetIdManager.class;
    }

    public static /* synthetic */ void y() {
    }
}
