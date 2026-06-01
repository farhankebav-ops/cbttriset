package com.unity3d.ads.core.data.datasource;

import android.content.Context;
import androidx.datastore.core.DataMigration;
import com.unity3d.ads.datastore.ByteStringStoreOuterClass;
import kotlin.jvm.internal.k;
import q5.x;
import v5.c;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class PreservingByteStringPreferenceMigration implements DataMigration<ByteStringStoreOuterClass.ByteStringStore> {
    private final Context context;
    private final GetByteStringData getByteStringData;
    private final String key;
    private final String name;

    public PreservingByteStringPreferenceMigration(Context context, String name, String key, GetByteStringData getByteStringData) {
        k.e(context, "context");
        k.e(name, "name");
        k.e(key, "key");
        k.e(getByteStringData, "getByteStringData");
        this.context = context;
        this.name = name;
        this.key = key;
        this.getByteStringData = getByteStringData;
    }

    @Override // androidx.datastore.core.DataMigration
    public Object cleanUp(c<? super x> cVar) {
        return x.f13520a;
    }

    @Override // androidx.datastore.core.DataMigration
    public /* bridge */ /* synthetic */ Object shouldMigrate(ByteStringStoreOuterClass.ByteStringStore byteStringStore, c cVar) {
        return shouldMigrate2(byteStringStore, (c<? super Boolean>) cVar);
    }

    @Override // androidx.datastore.core.DataMigration
    public Object migrate(ByteStringStoreOuterClass.ByteStringStore byteStringStore, c<? super ByteStringStoreOuterClass.ByteStringStore> cVar) {
        String string;
        if (!byteStringStore.getData().isEmpty() || (string = this.context.getSharedPreferences(this.name, 0).getString(this.key, null)) == null || string.length() == 0) {
            return byteStringStore;
        }
        ByteStringStoreOuterClass.ByteStringStore byteStringStoreBuild = ByteStringStoreOuterClass.ByteStringStore.newBuilder().setData(this.getByteStringData.invoke(string)).build();
        k.d(byteStringStoreBuild, "newBuilder()\n           …                 .build()");
        return byteStringStoreBuild;
    }

    /* JADX INFO: renamed from: shouldMigrate, reason: avoid collision after fix types in other method */
    public Object shouldMigrate2(ByteStringStoreOuterClass.ByteStringStore byteStringStore, c<? super Boolean> cVar) {
        return Boolean.valueOf(byteStringStore.getData().isEmpty());
    }
}
