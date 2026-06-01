package com.onesignal.common.consistency.models;

import com.onesignal.common.consistency.RywData;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public interface ICondition {
    String getId();

    RywData getRywData(Map<String, ? extends Map<IConsistencyKeyEnum, RywData>> map);

    boolean isMet(Map<String, ? extends Map<IConsistencyKeyEnum, RywData>> map);
}
