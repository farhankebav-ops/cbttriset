package com.onesignal.inAppMessages.internal.repositories;

import com.onesignal.inAppMessages.internal.InAppMessage;
import java.util.List;
import q5.x;
import v5.c;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public interface IInAppRepository {
    Object cleanCachedInAppMessages(c<? super x> cVar);

    Object listInAppMessages(c<? super List<InAppMessage>> cVar);

    Object saveInAppMessage(InAppMessage inAppMessage, c<? super x> cVar);
}
