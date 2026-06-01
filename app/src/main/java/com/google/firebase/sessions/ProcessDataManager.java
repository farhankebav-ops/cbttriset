package com.google.firebase.sessions;

import java.util.Map;
import r5.s;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public interface ProcessDataManager {

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class DefaultImpls {
        public static Map<String, ProcessData> generateProcessDataMap(ProcessDataManager processDataManager) {
            return processDataManager.updateProcessDataMap(s.f13639a);
        }
    }

    Map<String, ProcessData> generateProcessDataMap();

    int getMyPid();

    String getMyProcessName();

    String getMyUuid();

    boolean isColdStart(Map<String, ProcessData> map);

    boolean isMyProcessStale(Map<String, ProcessData> map);

    void onSessionGenerated();

    Map<String, ProcessData> updateProcessDataMap(Map<String, ProcessData> map);
}
