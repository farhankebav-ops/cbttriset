package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.view.InputEvent;
import android.view.View;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzfxn {
    private final zzfzl zza;
    private final zzgam zzb;
    private final zzghy zzc;
    private final zzgjd zzd;
    private final long zze;
    private final zzifb zzf;
    private final long zzg;
    private final long zzh = System.currentTimeMillis();
    private final boolean zzi;
    private final long zzj;

    public zzfxn(zzfzl zzfzlVar, zzgam zzgamVar, zzghy zzghyVar, zzgjd zzgjdVar, zzifb zzifbVar, zzfxt zzfxtVar) {
        this.zza = zzfzlVar;
        this.zzb = zzgamVar;
        this.zzc = zzghyVar;
        this.zzd = zzgjdVar;
        this.zze = zzfxtVar.zzh();
        this.zzf = zzifbVar;
        this.zzg = zzfxtVar.zzg();
        this.zzi = zzfxtVar.zzq();
        this.zzj = zzfxtVar.zzp();
    }

    public final j2.q zza() {
        return this.zza.zza();
    }

    public final String zzb(Context context) {
        String string;
        boolean z2 = false;
        if (this.zzi) {
            if (System.currentTimeMillis() - this.zzh <= this.zzj) {
                z2 = true;
            }
        }
        zzgjb zzgjbVarZza = this.zzd.zza(3);
        try {
            try {
                try {
                    try {
                        zzgjbVarZza.zza();
                        string = (String) zzgui.zzj(this.zza.zzb(), new zzfxk(this, context), zzguz.zza()).get(z2 ? this.zzg : this.zze, TimeUnit.MILLISECONDS);
                    } catch (ExecutionException e) {
                        e = e;
                        Throwable cause = e.getCause();
                        if (cause != null) {
                            e = cause;
                        }
                        zzgjbVarZza.zzb(e);
                        string = Integer.toString(3);
                    } catch (Throwable th) {
                        zzgjbVarZza.zzb(th);
                        throw th;
                    }
                } catch (InterruptedException e4) {
                    Thread.currentThread().interrupt();
                    zzgjbVarZza.zzb(e4);
                    string = "";
                }
            } catch (TimeoutException e8) {
                zzgjbVarZza.zzb(e8);
                string = z2 ? ((zzgdo) this.zzf.zzb()).zza(true, this.zzh) : Integer.toString(17);
            }
            zzgjbVarZza.zzc();
            return string;
        } catch (Throwable th2) {
            zzgjbVarZza.zzc();
            throw th2;
        }
    }

    public final String zzc(Context context, String str, View view, Activity activity) {
        String string;
        zzgjb zzgjbVarZza = this.zzd.zza(4);
        try {
            try {
                zzgjbVarZza.zza();
            } catch (InterruptedException e) {
                e = e;
            } catch (ExecutionException e4) {
                e = e4;
            } catch (TimeoutException e8) {
                e = e8;
            } catch (Throwable th) {
                th = th;
            }
            try {
                string = (String) zzgui.zzj(this.zza.zzb(), new zzfxl(this, context, null, view, activity), zzguz.zza()).get(this.zze, TimeUnit.MILLISECONDS);
            } catch (InterruptedException e9) {
                e = e9;
                InterruptedException interruptedException = e;
                Thread.currentThread().interrupt();
                zzgjbVarZza.zzb(interruptedException);
                string = "";
            } catch (ExecutionException e10) {
                e = e10;
                Throwable th2 = e;
                Throwable cause = th2.getCause();
                if (cause != null) {
                    th2 = cause;
                }
                zzgjbVarZza.zzb(th2);
                string = Integer.toString(3);
            } catch (TimeoutException e11) {
                e = e11;
                zzgjbVarZza.zzb(e);
                string = Integer.toString(17);
            } catch (Throwable th3) {
                th = th3;
                Throwable th4 = th;
                zzgjbVarZza.zzb(th4);
                throw th4;
            }
            zzgjbVarZza.zzc();
            return string;
        } catch (Throwable th5) {
            zzgjbVarZza.zzc();
            throw th5;
        }
    }

    public final String zzd(Context context, String str, View view, Activity activity) {
        String string;
        zzgjb zzgjbVarZza = this.zzd.zza(5);
        try {
            try {
                zzgjbVarZza.zza();
            } catch (InterruptedException e) {
                e = e;
            } catch (ExecutionException e4) {
                e = e4;
            } catch (TimeoutException e8) {
                e = e8;
            } catch (Throwable th) {
                th = th;
            }
            try {
                string = (String) zzgui.zzj(this.zza.zzb(), new zzfxm(this, context, str, view, null), zzguz.zza()).get(this.zze, TimeUnit.MILLISECONDS);
            } catch (InterruptedException e9) {
                e = e9;
                InterruptedException interruptedException = e;
                Thread.currentThread().interrupt();
                zzgjbVarZza.zzb(interruptedException);
                string = "";
            } catch (ExecutionException e10) {
                e = e10;
                Throwable th2 = e;
                Throwable cause = th2.getCause();
                if (cause != null) {
                    th2 = cause;
                }
                zzgjbVarZza.zzb(th2);
                string = Integer.toString(3);
            } catch (TimeoutException e11) {
                e = e11;
                zzgjbVarZza.zzb(e);
                string = Integer.toString(17);
            } catch (Throwable th3) {
                th = th3;
                Throwable th4 = th;
                zzgjbVarZza.zzb(th4);
                throw th4;
            }
            zzgjbVarZza.zzc();
            return string;
        } catch (Throwable th5) {
            zzgjbVarZza.zzc();
            throw th5;
        }
    }

    public final void zze(List list) {
        this.zzc.zza(list);
    }

    public final void zzf(InputEvent inputEvent) {
        this.zzb.zze(inputEvent);
    }

    public final /* synthetic */ zzgam zzg() {
        return this.zzb;
    }

    public final int zzh() {
        return this.zzb.zzh();
    }
}
