package com.onesignal.core.internal.operations;

import java.util.List;
import v5.c;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public interface IOperationExecutor {
    Object execute(List<? extends Operation> list, c<? super ExecutionResponse> cVar);

    List<String> getOperations();
}
