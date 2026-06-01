package com.google.android.gms.internal.ads;

import android.content.SharedPreferences;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzbem {
    private final List zza = new ArrayList();
    private final List zzb = new ArrayList();
    private final List zzc = new ArrayList();

    public final void zza(zzbel zzbelVar) {
        this.zza.add(zzbelVar);
    }

    public final void zzb(zzbel zzbelVar) {
        this.zzb.add(zzbelVar);
    }

    public final void zzc(zzbel zzbelVar) {
        this.zzc.add(zzbelVar);
    }

    public final void zzd(SharedPreferences.Editor editor, int i2, JSONObject jSONObject) {
        for (zzbel zzbelVar : this.zza) {
            if (zzbelVar.zzm() == 1) {
                zzbelVar.zzb(editor, zzbelVar.zzc(jSONObject));
            }
        }
        if (jSONObject != null) {
            editor.putString("flag_configuration", jSONObject.toString());
        } else {
            com.google.android.gms.ads.internal.util.client.zzo.zzf("Flag Json is null.");
        }
    }

    public final List zze() {
        ArrayList arrayList = new ArrayList();
        Iterator it = this.zzb.iterator();
        while (it.hasNext()) {
            String str = (String) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd((zzbel) it.next());
            if (!TextUtils.isEmpty(str)) {
                arrayList.add(str);
            }
        }
        arrayList.addAll(zzbev.zza());
        return arrayList;
    }

    public final List zzf() {
        List listZze = zze();
        Iterator it = this.zzc.iterator();
        while (it.hasNext()) {
            String str = (String) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd((zzbel) it.next());
            if (!TextUtils.isEmpty(str)) {
                listZze.add(str);
            }
        }
        listZze.addAll(zzbev.zzb());
        return listZze;
    }
}
