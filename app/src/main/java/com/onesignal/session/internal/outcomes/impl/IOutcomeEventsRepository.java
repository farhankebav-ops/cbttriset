package com.onesignal.session.internal.outcomes.impl;

import com.onesignal.session.internal.influence.Influence;
import java.util.List;
import q5.x;
import v5.c;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public interface IOutcomeEventsRepository {
    Object cleanCachedUniqueOutcomeEventNotifications(c<? super x> cVar);

    Object deleteOldOutcomeEvent(OutcomeEventParams outcomeEventParams, c<? super x> cVar);

    Object getAllEventsToSend(c<? super List<OutcomeEventParams>> cVar);

    Object getNotCachedUniqueInfluencesForOutcome(String str, List<Influence> list, c<? super List<Influence>> cVar);

    Object saveOutcomeEvent(OutcomeEventParams outcomeEventParams, c<? super x> cVar);

    Object saveUniqueOutcomeEventParams(OutcomeEventParams outcomeEventParams, c<? super x> cVar);
}
