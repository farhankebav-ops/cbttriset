package com.google.firebase.analytics.connector;

import com.google.firebase.events.Event;
import com.google.firebase.events.EventHandler;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final /* synthetic */ class zza implements EventHandler {
    static final /* synthetic */ zza zza = new zza();

    private /* synthetic */ zza() {
    }

    @Override // com.google.firebase.events.EventHandler
    public final /* synthetic */ void handle(Event event) {
        AnalyticsConnectorImpl.zza(event);
    }
}
