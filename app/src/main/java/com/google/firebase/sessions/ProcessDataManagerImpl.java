package com.google.firebase.sessions;

import android.content.Context;
import android.os.Process;
import com.google.firebase.sessions.ProcessDataManager;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.k;
import q5.f;
import q5.i;
import r5.x;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class ProcessDataManagerImpl implements ProcessDataManager {
    private final Context appContext;
    private boolean hasGeneratedSession;
    private final int myPid;
    private final f myProcessDetails$delegate;
    private final f myProcessName$delegate;
    private final f myUuid$delegate;

    public ProcessDataManagerImpl(Context appContext, UuidGenerator uuidGenerator) {
        k.e(appContext, "appContext");
        k.e(uuidGenerator, "uuidGenerator");
        this.appContext = appContext;
        final int i2 = 0;
        this.myProcessName$delegate = n7.b.C(new e6.a(this) { // from class: com.google.firebase.sessions.e

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ ProcessDataManagerImpl f5739b;

            {
                this.f5739b = this;
            }

            @Override // e6.a
            public final Object invoke() {
                switch (i2) {
                    case 0:
                        return ProcessDataManagerImpl.myProcessName_delegate$lambda$0(this.f5739b);
                    default:
                        return ProcessDataManagerImpl.myProcessDetails_delegate$lambda$2(this.f5739b);
                }
            }
        });
        this.myPid = Process.myPid();
        this.myUuid$delegate = n7.b.C(new c(uuidGenerator, 2));
        final int i8 = 1;
        this.myProcessDetails$delegate = n7.b.C(new e6.a(this) { // from class: com.google.firebase.sessions.e

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ ProcessDataManagerImpl f5739b;

            {
                this.f5739b = this;
            }

            @Override // e6.a
            public final Object invoke() {
                switch (i8) {
                    case 0:
                        return ProcessDataManagerImpl.myProcessName_delegate$lambda$0(this.f5739b);
                    default:
                        return ProcessDataManagerImpl.myProcessDetails_delegate$lambda$2(this.f5739b);
                }
            }
        });
    }

    private final List<ProcessDetails> getAppProcessDetails() {
        return ProcessDetailsProvider.INSTANCE.getAppProcessDetails(this.appContext);
    }

    private final ProcessDetails getMyProcessDetails() {
        return (ProcessDetails) this.myProcessDetails$delegate.getValue();
    }

    private final boolean isProcessStale(ProcessDetails processDetails, ProcessData processData) {
        return k.a(getMyProcessName(), processDetails.getProcessName()) ? (processDetails.getPid() == processData.getPid() && k.a(getMyUuid(), processData.getUuid())) ? false : true : processDetails.getPid() != processData.getPid();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ProcessDetails myProcessDetails_delegate$lambda$2(ProcessDataManagerImpl processDataManagerImpl) {
        return ProcessDetailsProvider.INSTANCE.getMyProcessDetails(processDataManagerImpl.appContext);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String myProcessName_delegate$lambda$0(ProcessDataManagerImpl processDataManagerImpl) {
        return processDataManagerImpl.getMyProcessDetails().getProcessName();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String myUuid_delegate$lambda$1(UuidGenerator uuidGenerator) {
        String string = uuidGenerator.next().toString();
        k.d(string, "toString(...)");
        return string;
    }

    @Override // com.google.firebase.sessions.ProcessDataManager
    public Map<String, ProcessData> generateProcessDataMap() {
        return ProcessDataManager.DefaultImpls.generateProcessDataMap(this);
    }

    @Override // com.google.firebase.sessions.ProcessDataManager
    public int getMyPid() {
        return this.myPid;
    }

    @Override // com.google.firebase.sessions.ProcessDataManager
    public String getMyProcessName() {
        return (String) this.myProcessName$delegate.getValue();
    }

    @Override // com.google.firebase.sessions.ProcessDataManager
    public String getMyUuid() {
        return (String) this.myUuid$delegate.getValue();
    }

    @Override // com.google.firebase.sessions.ProcessDataManager
    public boolean isColdStart(Map<String, ProcessData> processDataMap) {
        k.e(processDataMap, "processDataMap");
        if (this.hasGeneratedSession) {
            return false;
        }
        List<ProcessDetails> appProcessDetails = getAppProcessDetails();
        ArrayList arrayList = new ArrayList();
        for (ProcessDetails processDetails : appProcessDetails) {
            ProcessData processData = processDataMap.get(processDetails.getProcessName());
            i iVar = processData != null ? new i(processDetails, processData) : null;
            if (iVar != null) {
                arrayList.add(iVar);
            }
        }
        if (arrayList.isEmpty()) {
            return true;
        }
        int size = arrayList.size();
        int i2 = 0;
        while (i2 < size) {
            Object obj = arrayList.get(i2);
            i2++;
            i iVar2 = (i) obj;
            if (!isProcessStale((ProcessDetails) iVar2.f13498a, (ProcessData) iVar2.f13499b)) {
                return false;
            }
        }
        return true;
    }

    @Override // com.google.firebase.sessions.ProcessDataManager
    public boolean isMyProcessStale(Map<String, ProcessData> processDataMap) {
        k.e(processDataMap, "processDataMap");
        ProcessData processData = processDataMap.get(getMyProcessName());
        return (processData != null && processData.getPid() == getMyPid() && k.a(processData.getUuid(), getMyUuid())) ? false : true;
    }

    @Override // com.google.firebase.sessions.ProcessDataManager
    public void onSessionGenerated() {
        this.hasGeneratedSession = true;
    }

    @Override // com.google.firebase.sessions.ProcessDataManager
    public Map<String, ProcessData> updateProcessDataMap(Map<String, ProcessData> map) {
        if (map == null) {
            return x.e0(new i(getMyProcessName(), new ProcessData(Process.myPid(), getMyUuid())));
        }
        LinkedHashMap linkedHashMapO0 = x.o0(map);
        linkedHashMapO0.put(getMyProcessName(), new ProcessData(Process.myPid(), getMyUuid()));
        return x.n0(linkedHashMapO0);
    }
}
