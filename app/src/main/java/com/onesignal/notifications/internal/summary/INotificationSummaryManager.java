package com.onesignal.notifications.internal.summary;

import q5.x;
import v5.c;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public interface INotificationSummaryManager {
    Object clearNotificationOnSummaryClick(String str, c<? super x> cVar);

    Object updatePossibleDependentSummaryOnDismiss(int i2, c<? super x> cVar);

    Object updateSummaryNotificationAfterChildRemoved(String str, boolean z2, c<? super x> cVar);
}
