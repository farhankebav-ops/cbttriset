package androidx.constraintlayout.core.utils;

import com.google.firebase.crashlytics.internal.persistence.CrashlyticsReportPersistence;
import com.google.firebase.inappmessaging.internal.InAppMessageStreamManager;
import java.io.File;
import java.util.Comparator;
import q2.f;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class a implements Comparator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3920a;

    public /* synthetic */ a(int i2) {
        this.f3920a = i2;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        switch (this.f3920a) {
            case 0:
                return GridCore.lambda$parseSpans$0((String) obj, (String) obj2);
            case 1:
                return CrashlyticsReportPersistence.lambda$static$0((File) obj, (File) obj2);
            case 2:
                return CrashlyticsReportPersistence.oldestEventFileFirst((File) obj, (File) obj2);
            default:
                return InAppMessageStreamManager.compareByPriority((f) obj, (f) obj2);
        }
    }
}
