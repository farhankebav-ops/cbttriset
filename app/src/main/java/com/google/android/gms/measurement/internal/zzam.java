package com.google.android.gms.measurement.internal;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
enum zzam {
    UNSET('0'),
    REMOTE_DEFAULT('1'),
    REMOTE_DELEGATION('2'),
    MANIFEST('3'),
    INITIALIZATION('4'),
    API('5'),
    CHILD_ACCOUNT('6'),
    TCF('7'),
    REMOTE_ENFORCED_DEFAULT('8'),
    FAILSAFE('9');

    private final char zzk;

    zzam(char c7) {
        this.zzk = c7;
    }

    public static zzam zza(char c7) {
        for (zzam zzamVar : values()) {
            if (zzamVar.zzk == c7) {
                return zzamVar;
            }
        }
        return UNSET;
    }

    public final /* synthetic */ char zzb() {
        return this.zzk;
    }
}
