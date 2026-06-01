package com.onesignal.session.internal.outcomes;

import v5.c;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public interface IOutcomeEventsController {
    Object sendOutcomeEvent(String str, c<? super IOutcomeEvent> cVar);

    Object sendOutcomeEventWithValue(String str, float f4, c<? super IOutcomeEvent> cVar);

    Object sendSessionEndOutcomeEvent(long j, c<? super IOutcomeEvent> cVar);

    Object sendUniqueOutcomeEvent(String str, c<? super IOutcomeEvent> cVar);
}
