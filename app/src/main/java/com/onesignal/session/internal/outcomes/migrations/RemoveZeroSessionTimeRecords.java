package com.onesignal.session.internal.outcomes.migrations;

import com.onesignal.core.internal.database.IDatabaseProvider;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class RemoveZeroSessionTimeRecords {
    public static final RemoveZeroSessionTimeRecords INSTANCE = new RemoveZeroSessionTimeRecords();

    private RemoveZeroSessionTimeRecords() {
    }

    public final void run(IDatabaseProvider databaseProvider) {
        k.e(databaseProvider, "databaseProvider");
        databaseProvider.getOs().delete("outcome", "name = \"os__session_duration\" AND session_time = 0", null);
    }
}
