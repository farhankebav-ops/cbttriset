package com.google.firebase.sessions;

import b7.h;
import d7.g;
import f7.c1;
import f7.m1;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
@h
public final class ProcessData {
    public static final Companion Companion = new Companion(null);
    private final int pid;
    private final String uuid;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Companion {
        private Companion() {
        }

        public final b7.c serializer() {
            return ProcessData$$serializer.INSTANCE;
        }

        public /* synthetic */ Companion(f fVar) {
            this();
        }
    }

    public /* synthetic */ ProcessData(int i2, int i8, String str, m1 m1Var) {
        if (3 != (i2 & 3)) {
            c1.j(ProcessData$$serializer.INSTANCE.getDescriptor(), i2, 3);
            throw null;
        }
        this.pid = i8;
        this.uuid = str;
    }

    public static /* synthetic */ ProcessData copy$default(ProcessData processData, int i2, String str, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            i2 = processData.pid;
        }
        if ((i8 & 2) != 0) {
            str = processData.uuid;
        }
        return processData.copy(i2, str);
    }

    public static final /* synthetic */ void write$Self$com_google_firebase_firebase_sessions(ProcessData processData, e7.d dVar, g gVar) {
        dVar.encodeIntElement(gVar, 0, processData.pid);
        dVar.encodeStringElement(gVar, 1, processData.uuid);
    }

    public final int component1() {
        return this.pid;
    }

    public final String component2() {
        return this.uuid;
    }

    public final ProcessData copy(int i2, String uuid) {
        k.e(uuid, "uuid");
        return new ProcessData(i2, uuid);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ProcessData)) {
            return false;
        }
        ProcessData processData = (ProcessData) obj;
        return this.pid == processData.pid && k.a(this.uuid, processData.uuid);
    }

    public final int getPid() {
        return this.pid;
    }

    public final String getUuid() {
        return this.uuid;
    }

    public int hashCode() {
        return this.uuid.hashCode() + (this.pid * 31);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("ProcessData(pid=");
        sb.append(this.pid);
        sb.append(", uuid=");
        return a1.a.e(')', this.uuid, sb);
    }

    public ProcessData(int i2, String uuid) {
        k.e(uuid, "uuid");
        this.pid = i2;
        this.uuid = uuid;
    }
}
