package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzfrc implements zzfqd {
    private static final zzfrc zza = new zzfrc();
    private static final Handler zzb = new Handler(Looper.getMainLooper());
    private static Handler zzc = null;
    private static final Runnable zzk = new zzfqy();
    private static final Runnable zzl = new zzfqz();
    private int zze;
    private long zzj;
    private final List zzd = new ArrayList();
    private final List zzf = new ArrayList();
    private final zzfqv zzh = new zzfqv();
    private final zzfqf zzg = new zzfqf();
    private final zzfqw zzi = new zzfqw(new zzfrf());

    public static zzfrc zzb() {
        return zza;
    }

    private final void zzk(View view, zzfqe zzfqeVar, JSONObject jSONObject, int i2, boolean z2) {
        zzfqeVar.zzb(view, jSONObject, this, i2 == 1, z2);
    }

    private static final void zzl() {
        Handler handler = zzc;
        if (handler != null) {
            handler.removeCallbacks(zzl);
            zzc = null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzfqd
    public final void zza(View view, zzfqe zzfqeVar, JSONObject jSONObject, boolean z2) {
        zzfqv zzfqvVar;
        int iZzl;
        boolean z7;
        zzfrc zzfrcVar;
        View view2;
        zzfqe zzfqeVar2;
        boolean z8;
        if (zzfqt.zza(view) != null || (iZzl = (zzfqvVar = this.zzh).zzl(view)) == 3) {
            return;
        }
        JSONObject jSONObjectZza = zzfqeVar.zza(view);
        zzfqo.zze(jSONObject, jSONObjectZza);
        String strZzg = zzfqvVar.zzg(view);
        if (strZzg != null) {
            zzfqo.zzd(jSONObjectZza, strZzg);
            try {
                jSONObjectZza.put("hasWindowFocus", Boolean.valueOf(this.zzh.zzj(view)));
            } catch (JSONException e) {
                zzfqp.zza("Error with setting has window focus", e);
            }
            boolean zZzk = this.zzh.zzk(strZzg);
            Boolean boolValueOf = Boolean.valueOf(zZzk);
            if (zZzk) {
                try {
                    jSONObjectZza.put("isPipActive", boolValueOf);
                } catch (JSONException e4) {
                    zzfqp.zza("Error with setting is picture-in-picture active", e4);
                }
            }
            this.zzh.zzf();
            zzfrcVar = this;
        } else {
            zzfqu zzfquVarZzi = zzfqvVar.zzi(view);
            if (zzfquVarZzi != null) {
                zzfpv zzfpvVarZzb = zzfquVarZzi.zzb();
                JSONArray jSONArray = new JSONArray();
                ArrayList arrayListZzc = zzfquVarZzi.zzc();
                int size = arrayListZzc.size();
                for (int i2 = 0; i2 < size; i2++) {
                    jSONArray.put((String) arrayListZzc.get(i2));
                }
                try {
                    jSONObjectZza.put("isFriendlyObstructionFor", jSONArray);
                    jSONObjectZza.put("friendlyObstructionClass", zzfpvVarZzb.zzb());
                    jSONObjectZza.put("friendlyObstructionPurpose", zzfpvVarZzb.zzc());
                    jSONObjectZza.put("friendlyObstructionReason", zzfpvVarZzb.zzd());
                } catch (JSONException e8) {
                    zzfqp.zza("Error with setting friendly obstruction", e8);
                }
                z7 = true;
            } else {
                z7 = false;
            }
            if (z2 || z7) {
                zzfrcVar = this;
                view2 = view;
                zzfqeVar2 = zzfqeVar;
                z8 = true;
            } else {
                view2 = view;
                zzfqeVar2 = zzfqeVar;
                z8 = false;
                zzfrcVar = this;
            }
            zzfrcVar.zzk(view2, zzfqeVar2, jSONObjectZza, iZzl, z8);
        }
        zzfrcVar.zze++;
    }

    public final void zzc() {
        if (zzc == null) {
            Handler handler = new Handler(Looper.getMainLooper());
            zzc = handler;
            handler.post(zzk);
            zzc.postDelayed(zzl, 200L);
        }
    }

    public final void zzd() {
        zzl();
        this.zzd.clear();
        zzb.post(new zzfqx(this));
    }

    public final void zze() {
        zzl();
    }

    public final /* synthetic */ void zzf() {
        zzfrc zzfrcVar;
        this.zze = 0;
        this.zzf.clear();
        for (zzfoy zzfoyVar : zzfps.zza().zzf()) {
        }
        this.zzj = System.nanoTime();
        zzfqv zzfqvVar = this.zzh;
        zzfqvVar.zzd();
        zzfqf zzfqfVar = this.zzg;
        long jNanoTime = System.nanoTime();
        zzfqe zzfqeVarZza = zzfqfVar.zza();
        if (zzfqvVar.zzb().size() > 0) {
            for (String str : zzfqvVar.zzb()) {
                JSONObject jSONObjectZza = zzfqeVarZza.zza(null);
                View viewZzh = zzfqvVar.zzh(str);
                zzfqe zzfqeVarZzb = zzfqfVar.zzb();
                String strZzc = zzfqvVar.zzc(str);
                if (strZzc != null) {
                    JSONObject jSONObjectZza2 = zzfqeVarZzb.zza(viewZzh);
                    zzfqo.zzd(jSONObjectZza2, str);
                    try {
                        jSONObjectZza2.put("notVisibleReason", strZzc);
                    } catch (JSONException e) {
                        zzfqp.zza("Error with setting not visible reason", e);
                    }
                    zzfqo.zze(jSONObjectZza, jSONObjectZza2);
                }
                zzfqo.zzf(jSONObjectZza);
                HashSet hashSet = new HashSet();
                hashSet.add(str);
                this.zzi.zzb(jSONObjectZza, hashSet, jNanoTime);
            }
        }
        zzfqv zzfqvVar2 = this.zzh;
        if (zzfqvVar2.zza().size() > 0) {
            JSONObject jSONObjectZza3 = zzfqeVarZza.zza(null);
            zzfrcVar = this;
            zzfrcVar.zzk(null, zzfqeVarZza, jSONObjectZza3, 1, false);
            zzfqo.zzf(jSONObjectZza3);
            zzfrcVar.zzi.zza(jSONObjectZza3, zzfqvVar2.zza(), jNanoTime);
        } else {
            zzfrcVar = this;
            zzfrcVar.zzi.zzc();
        }
        zzfqvVar2.zze();
        long jNanoTime2 = System.nanoTime() - zzfrcVar.zzj;
        List<zzfrb> list = zzfrcVar.zzd;
        if (list.size() > 0) {
            for (zzfrb zzfrbVar : list) {
                TimeUnit.NANOSECONDS.toMillis(jNanoTime2);
                zzfrbVar.zzb();
                if (zzfrbVar instanceof zzfra) {
                    ((zzfra) zzfrbVar).zza();
                }
            }
        }
        zzfqc.zza().zzc();
    }

    public final /* synthetic */ zzfqw zzh() {
        return this.zzi;
    }
}
