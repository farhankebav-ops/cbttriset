package com.onesignal.core.internal.database.impl;

import com.onesignal.core.internal.application.IApplicationService;
import com.onesignal.core.internal.database.IDatabase;
import com.onesignal.core.internal.database.IDatabaseProvider;
import com.onesignal.session.internal.outcomes.impl.OutcomeTableProvider;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class DatabaseProvider implements IDatabaseProvider {
    private final IApplicationService _application;
    private final Object lock;
    private OSDatabase osDatabase;

    public DatabaseProvider(IApplicationService _application) {
        k.e(_application, "_application");
        this._application = _application;
        this.lock = new Object();
    }

    @Override // com.onesignal.core.internal.database.IDatabaseProvider
    public IDatabase getOs() {
        if (this.osDatabase == null) {
            synchronized (this.lock) {
                if (this.osDatabase == null) {
                    this.osDatabase = new OSDatabase(new OutcomeTableProvider(), this._application.getAppContext(), 0, 4, null);
                }
            }
        }
        OSDatabase oSDatabase = this.osDatabase;
        k.b(oSDatabase);
        return oSDatabase;
    }
}
