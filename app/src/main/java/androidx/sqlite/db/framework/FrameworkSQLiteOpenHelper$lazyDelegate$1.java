package androidx.sqlite.db.framework;

import androidx.sqlite.db.SupportSQLiteCompat;
import androidx.sqlite.db.framework.FrameworkSQLiteOpenHelper;
import java.io.File;
import kotlin.jvm.internal.l;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class FrameworkSQLiteOpenHelper$lazyDelegate$1 extends l implements e6.a {
    final /* synthetic */ FrameworkSQLiteOpenHelper this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FrameworkSQLiteOpenHelper$lazyDelegate$1(FrameworkSQLiteOpenHelper frameworkSQLiteOpenHelper) {
        super(0);
        this.this$0 = frameworkSQLiteOpenHelper;
    }

    @Override // e6.a
    public final FrameworkSQLiteOpenHelper.OpenHelper invoke() {
        FrameworkSQLiteOpenHelper.OpenHelper openHelper;
        if (this.this$0.name == null || !this.this$0.useNoBackupDirectory) {
            openHelper = new FrameworkSQLiteOpenHelper.OpenHelper(this.this$0.context, this.this$0.name, new FrameworkSQLiteOpenHelper.DBRefHolder(null), this.this$0.callback, this.this$0.allowDataLossOnRecovery);
        } else {
            openHelper = new FrameworkSQLiteOpenHelper.OpenHelper(this.this$0.context, new File(SupportSQLiteCompat.Api21Impl.getNoBackupFilesDir(this.this$0.context), this.this$0.name).getAbsolutePath(), new FrameworkSQLiteOpenHelper.DBRefHolder(null), this.this$0.callback, this.this$0.allowDataLossOnRecovery);
        }
        SupportSQLiteCompat.Api16Impl.setWriteAheadLoggingEnabled(openHelper, this.this$0.writeAheadLoggingEnabled);
        return openHelper;
    }
}
