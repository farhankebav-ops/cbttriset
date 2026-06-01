package com.unity3d.services.core.fid;

import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.unity3d.services.core.reflection.GenericBridge;
import kotlin.jvm.internal.k;
import q5.i;
import r5.x;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class FIdBridge extends GenericBridge {
    private final Object instance;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FIdBridge(Object instance) {
        super(x.e0(new i(Constants.GET_APP_INSTANCE_ID, new Class[0])), false);
        k.e(instance, "instance");
        this.instance = instance;
    }

    public final Task<String> getAppInstanceId() {
        Task<String> task = (Task) callNonVoidMethod(Constants.GET_APP_INSTANCE_ID, this.instance, new Object[0]);
        if (task != null) {
            return task;
        }
        Task<String> taskForResult = Tasks.forResult(null);
        k.d(taskForResult, "forResult(null)");
        return taskForResult;
    }

    @Override // com.unity3d.services.core.reflection.GenericBridge
    public String getClassName() {
        return Constants.Companion.getClassName();
    }
}
