package com.google.android.gms.measurement.internal;

import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import com.google.android.gms.common.internal.Preconditions;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzat {
    final /* synthetic */ zzav zza;
    private final String zzb;
    private long zzc;

    public zzat(zzav zzavVar, String str) {
        Objects.requireNonNull(zzavVar);
        this.zza = zzavVar;
        Preconditions.checkNotEmpty(str);
        this.zzb = str;
        this.zzc = -1L;
    }

    public final List zza() {
        List list;
        ArrayList arrayList = new ArrayList();
        Cursor cursorQuery = null;
        try {
            try {
                cursorQuery = this.zza.zze().query("raw_events", new String[]{"rowid", "name", "timestamp", "metadata_fingerprint", "data", "realtime"}, "app_id = ? and rowid > ?", new String[]{this.zzb, String.valueOf(this.zzc)}, null, null, "rowid", "1000");
                if (cursorQuery.moveToFirst()) {
                    do {
                        long j = cursorQuery.getLong(0);
                        long j3 = cursorQuery.getLong(3);
                        boolean z2 = cursorQuery.getLong(5) == 1;
                        byte[] blob = cursorQuery.getBlob(4);
                        if (j > this.zzc) {
                            this.zzc = j;
                        }
                        try {
                            com.google.android.gms.internal.measurement.zzhr zzhrVar = (com.google.android.gms.internal.measurement.zzhr) zzpk.zzw(com.google.android.gms.internal.measurement.zzhs.zzk(), blob);
                            String string = cursorQuery.getString(1);
                            if (string == null) {
                                string = "";
                            }
                            zzhrVar.zzl(string);
                            zzhrVar.zzo(cursorQuery.getLong(2));
                            arrayList.add(new zzas(j, j3, z2, (com.google.android.gms.internal.measurement.zzhs) zzhrVar.zzbc()));
                        } catch (IOException e) {
                            this.zza.zzu.zzaV().zzb().zzc("Data loss. Failed to merge raw event. appId", zzgu.zzl(this.zzb), e);
                        }
                    } while (cursorQuery.moveToNext());
                    list = arrayList;
                } else {
                    list = Collections.EMPTY_LIST;
                }
            } catch (SQLiteException e4) {
                this.zza.zzu.zzaV().zzb().zzc("Data loss. Error querying raw events batch. appId", zzgu.zzl(this.zzb), e4);
                list = arrayList;
            }
            return list;
        } finally {
            if (0 != 0) {
                cursorQuery.close();
            }
        }
    }

    public zzat(zzav zzavVar, String str, long j) {
        Objects.requireNonNull(zzavVar);
        this.zza = zzavVar;
        Preconditions.checkNotEmpty(str);
        this.zzb = str;
        this.zzc = zzavVar.zzah("select rowid from raw_events where app_id = ? and timestamp < ? order by rowid desc limit 1", new String[]{str, String.valueOf(j)}, -1L);
    }
}
