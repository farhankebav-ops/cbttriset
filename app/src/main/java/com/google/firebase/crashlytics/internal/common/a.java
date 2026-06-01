package com.google.firebase.crashlytics.internal.common;

import java.io.File;
import java.io.FilenameFilter;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class a implements FilenameFilter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5567a;

    public /* synthetic */ a(int i2) {
        this.f5567a = i2;
    }

    @Override // java.io.FilenameFilter
    public final boolean accept(File file, String str) {
        switch (this.f5567a) {
            case 0:
                return CrashlyticsAppQualitySessionsStore.lambda$static$0(file, str);
            default:
                return CrashlyticsController.lambda$static$0(file, str);
        }
    }
}
