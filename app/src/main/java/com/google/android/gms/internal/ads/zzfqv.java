package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;
import android.view.View;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzfqv {
    private final HashMap zza = new HashMap();
    private final HashMap zzb = new HashMap();
    private final HashMap zzc = new HashMap();
    private final HashSet zzd = new HashSet();
    private final HashSet zze = new HashSet();
    private final HashSet zzf = new HashSet();
    private final HashMap zzg = new HashMap();
    private final HashSet zzh = new HashSet();
    private final Map zzi = new WeakHashMap();
    private boolean zzj;

    public final HashSet zza() {
        return this.zze;
    }

    public final HashSet zzb() {
        return this.zzf;
    }

    public final String zzc(String str) {
        return (String) this.zzg.get(str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void zzd() {
        Boolean bool;
        Activity activity;
        zzfps zzfpsVarZza = zzfps.zza();
        if (zzfpsVarZza != null) {
            for (zzfoy zzfoyVar : zzfpsVarZza.zzf()) {
                View viewZzi = zzfoyVar.zzi();
                if (zzfoyVar.zzj()) {
                    String strZzh = zzfoyVar.zzh();
                    if (viewZzi != null) {
                        boolean zIsInPictureInPictureMode = false;
                        String str = null;
                        if (Build.VERSION.SDK_INT >= 24) {
                            Context context = viewZzi.getContext();
                            while (true) {
                                if (!(context instanceof ContextWrapper)) {
                                    activity = null;
                                    break;
                                } else {
                                    if (context instanceof Activity) {
                                        activity = (Activity) context;
                                        break;
                                    }
                                    context = ((ContextWrapper) context).getBaseContext();
                                }
                            }
                            if (activity != null) {
                                zIsInPictureInPictureMode = activity.isInPictureInPictureMode();
                            }
                        }
                        if (zIsInPictureInPictureMode) {
                            this.zzh.add(strZzh);
                        }
                        if (viewZzi.isAttachedToWindow()) {
                            if (viewZzi.hasWindowFocus()) {
                                this.zzi.remove(viewZzi);
                                bool = Boolean.FALSE;
                            } else {
                                Map map = this.zzi;
                                if (map.containsKey(viewZzi)) {
                                    bool = (Boolean) map.get(viewZzi);
                                } else {
                                    Boolean bool2 = Boolean.FALSE;
                                    map.put(viewZzi, bool2);
                                    bool = bool2;
                                }
                            }
                            if (!bool.booleanValue() || zIsInPictureInPictureMode) {
                                HashSet hashSet = new HashSet();
                                View view = viewZzi;
                                while (true) {
                                    if (view == null) {
                                        this.zzd.addAll(hashSet);
                                        break;
                                    }
                                    String strZza = zzfqt.zza(view);
                                    if (strZza != null) {
                                        str = strZza;
                                        break;
                                    } else {
                                        hashSet.add(view);
                                        Object parent = view.getParent();
                                        view = parent instanceof View ? (View) parent : null;
                                    }
                                }
                            } else {
                                str = "noWindowFocus";
                            }
                        } else {
                            str = "notAttached";
                        }
                        if (str == null) {
                            this.zze.add(strZzh);
                            this.zza.put(viewZzi, strZzh);
                            for (zzfpv zzfpvVar : zzfoyVar.zzf()) {
                                View view2 = (View) zzfpvVar.zza().get();
                                if (view2 != null) {
                                    HashMap map2 = this.zzb;
                                    zzfqu zzfquVar = (zzfqu) map2.get(view2);
                                    if (zzfquVar != null) {
                                        zzfquVar.zza(zzfoyVar.zzh());
                                    } else {
                                        map2.put(view2, new zzfqu(zzfpvVar, zzfoyVar.zzh()));
                                    }
                                }
                            }
                        } else if (str != "noWindowFocus") {
                            this.zzf.add(strZzh);
                            this.zzc.put(strZzh, viewZzi);
                            this.zzg.put(strZzh, str);
                        }
                    } else {
                        this.zzf.add(strZzh);
                        this.zzg.put(strZzh, "noAdView");
                    }
                }
            }
        }
    }

    public final void zze() {
        this.zza.clear();
        this.zzb.clear();
        this.zzc.clear();
        this.zzd.clear();
        this.zze.clear();
        this.zzf.clear();
        this.zzg.clear();
        this.zzj = false;
        this.zzh.clear();
    }

    public final void zzf() {
        this.zzj = true;
    }

    public final String zzg(View view) {
        HashMap map = this.zza;
        if (map.size() == 0) {
            return null;
        }
        String str = (String) map.get(view);
        if (str != null) {
            map.remove(view);
        }
        return str;
    }

    public final View zzh(String str) {
        return (View) this.zzc.get(str);
    }

    public final zzfqu zzi(View view) {
        HashMap map = this.zzb;
        zzfqu zzfquVar = (zzfqu) map.get(view);
        if (zzfquVar != null) {
            map.remove(view);
        }
        return zzfquVar;
    }

    public final boolean zzj(View view) {
        Map map = this.zzi;
        if (!map.containsKey(view)) {
            return true;
        }
        map.put(view, Boolean.TRUE);
        return false;
    }

    public final boolean zzk(String str) {
        return this.zzh.contains(str);
    }

    public final int zzl(View view) {
        if (this.zzd.contains(view)) {
            return 1;
        }
        return this.zzj ? 2 : 3;
    }
}
