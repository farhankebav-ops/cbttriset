package com.onesignal.common.consistency.models;

import com.onesignal.common.consistency.RywData;
import q5.x;
import q6.q;
import v5.c;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public interface IConsistencyManager {
    Object getRywDataFromAwaitableCondition(ICondition iCondition, c<? super q> cVar);

    Object resolveConditionsWithID(String str, c<? super x> cVar);

    Object setRywData(String str, IConsistencyKeyEnum iConsistencyKeyEnum, RywData rywData, c<? super x> cVar);
}
