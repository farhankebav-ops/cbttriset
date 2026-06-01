package com.onesignal.core.internal.operations;

import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class ExecutionResponse {
    private final Map<String, String> idTranslations;
    private final List<Operation> operations;
    private final ExecutionResult result;
    private final Integer retryAfterSeconds;

    /* JADX WARN: Multi-variable type inference failed */
    public ExecutionResponse(ExecutionResult result, Map<String, String> map, List<? extends Operation> list, Integer num) {
        k.e(result, "result");
        this.result = result;
        this.idTranslations = map;
        this.operations = list;
        this.retryAfterSeconds = num;
    }

    public final Map<String, String> getIdTranslations() {
        return this.idTranslations;
    }

    public final List<Operation> getOperations() {
        return this.operations;
    }

    public final ExecutionResult getResult() {
        return this.result;
    }

    public final Integer getRetryAfterSeconds() {
        return this.retryAfterSeconds;
    }

    public /* synthetic */ ExecutionResponse(ExecutionResult executionResult, Map map, List list, Integer num, int i2, f fVar) {
        this(executionResult, (i2 & 2) != 0 ? null : map, (i2 & 4) != 0 ? null : list, (i2 & 8) != 0 ? null : num);
    }
}
