package com.unity3d.services.core.request.metrics;

import java.util.Map;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;
import r5.s;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class Metric {
    public static final Companion Companion = new Companion(null);
    private static final String METRIC_NAME = "n";
    private static final String METRIC_TAGS = "t";
    private static final String METRIC_VALUE = "v";
    private final String name;
    private final Map<String, String> tags;
    private final Object value;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Companion {
        public /* synthetic */ Companion(f fVar) {
            this();
        }

        private Companion() {
        }
    }

    public Metric(String str) {
        this(str, null, null, 6, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Metric copy$default(Metric metric, String str, Object obj, Map map, int i2, Object obj2) {
        if ((i2 & 1) != 0) {
            str = metric.name;
        }
        if ((i2 & 2) != 0) {
            obj = metric.value;
        }
        if ((i2 & 4) != 0) {
            map = metric.tags;
        }
        return metric.copy(str, obj, map);
    }

    public final String component1() {
        return this.name;
    }

    public final Object component2() {
        return this.value;
    }

    public final Map<String, String> component3() {
        return this.tags;
    }

    public final Metric copy(String str, Object obj, Map<String, String> tags) {
        k.e(tags, "tags");
        return new Metric(str, obj, tags);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Metric)) {
            return false;
        }
        Metric metric = (Metric) obj;
        return k.a(this.name, metric.name) && k.a(this.value, metric.value) && k.a(this.tags, metric.tags);
    }

    public final String getName() {
        return this.name;
    }

    public final Map<String, String> getTags() {
        return this.tags;
    }

    public final Object getValue() {
        return this.value;
    }

    public int hashCode() {
        String str = this.name;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        Object obj = this.value;
        return this.tags.hashCode() + ((iHashCode + (obj != null ? obj.hashCode() : 0)) * 31);
    }

    public final Map<String, Object> toMap() {
        s5.f fVar = new s5.f();
        String str = this.name;
        if (str != null) {
            fVar.put("n", str);
        }
        Object obj = this.value;
        if (obj != null) {
            fVar.put(METRIC_VALUE, obj);
        }
        if (!this.tags.isEmpty()) {
            fVar.put(METRIC_TAGS, this.tags);
        }
        return fVar.b();
    }

    public String toString() {
        return "Metric(name=" + this.name + ", value=" + this.value + ", tags=" + this.tags + ')';
    }

    public Metric(String str, Object obj) {
        this(str, obj, null, 4, null);
    }

    public Metric(String str, Object obj, Map<String, String> tags) {
        k.e(tags, "tags");
        this.name = str;
        this.value = obj;
        this.tags = tags;
    }

    public /* synthetic */ Metric(String str, Object obj, Map map, int i2, f fVar) {
        this(str, (i2 & 2) != 0 ? null : obj, (i2 & 4) != 0 ? s.f13639a : map);
    }
}
