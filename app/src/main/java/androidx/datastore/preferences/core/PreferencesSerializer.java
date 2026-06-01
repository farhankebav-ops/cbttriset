package androidx.datastore.preferences.core;

import androidx.datastore.core.CorruptionException;
import androidx.datastore.core.okio.OkioSerializer;
import androidx.datastore.preferences.PreferencesMapCompat;
import androidx.datastore.preferences.PreferencesProto;
import androidx.datastore.preferences.core.Preferences;
import androidx.datastore.preferences.protobuf.ByteString;
import e2.s;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.k;
import q5.x;
import r5.l;
import v5.c;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class PreferencesSerializer implements OkioSerializer<Preferences> {
    public static final PreferencesSerializer INSTANCE = new PreferencesSerializer();
    public static final String fileExtension = "preferences_pb";

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[PreferencesProto.Value.ValueCase.values().length];
            try {
                iArr[PreferencesProto.Value.ValueCase.BOOLEAN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PreferencesProto.Value.ValueCase.FLOAT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[PreferencesProto.Value.ValueCase.DOUBLE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[PreferencesProto.Value.ValueCase.INTEGER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[PreferencesProto.Value.ValueCase.LONG.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[PreferencesProto.Value.ValueCase.STRING.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[PreferencesProto.Value.ValueCase.STRING_SET.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[PreferencesProto.Value.ValueCase.BYTES.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[PreferencesProto.Value.ValueCase.VALUE_NOT_SET.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private PreferencesSerializer() {
    }

    private final void addProtoEntryToPreferences(String str, PreferencesProto.Value value, MutablePreferences mutablePreferences) throws CorruptionException {
        PreferencesProto.Value.ValueCase valueCase = value.getValueCase();
        int i2 = 2;
        Throwable th = null;
        byte b8 = 0;
        byte b9 = 0;
        byte b10 = 0;
        switch (valueCase == null ? -1 : WhenMappings.$EnumSwitchMapping$0[valueCase.ordinal()]) {
            case -1:
                throw new CorruptionException("Value case is null.", b9 == true ? 1 : 0, i2, b8 == true ? 1 : 0);
            case 0:
            default:
                throw new s(3);
            case 1:
                mutablePreferences.set(PreferencesKeys.booleanKey(str), Boolean.valueOf(value.getBoolean()));
                return;
            case 2:
                mutablePreferences.set(PreferencesKeys.floatKey(str), Float.valueOf(value.getFloat()));
                return;
            case 3:
                mutablePreferences.set(PreferencesKeys.doubleKey(str), Double.valueOf(value.getDouble()));
                return;
            case 4:
                mutablePreferences.set(PreferencesKeys.intKey(str), Integer.valueOf(value.getInteger()));
                return;
            case 5:
                mutablePreferences.set(PreferencesKeys.longKey(str), Long.valueOf(value.getLong()));
                return;
            case 6:
                Preferences.Key<String> keyStringKey = PreferencesKeys.stringKey(str);
                String string = value.getString();
                k.d(string, "value.string");
                mutablePreferences.set(keyStringKey, string);
                return;
            case 7:
                Preferences.Key<Set<String>> keyStringSetKey = PreferencesKeys.stringSetKey(str);
                List<String> stringsList = value.getStringSet().getStringsList();
                k.d(stringsList, "value.stringSet.stringsList");
                mutablePreferences.set(keyStringSetKey, l.r1(stringsList));
                return;
            case 8:
                Preferences.Key<byte[]> keyByteArrayKey = PreferencesKeys.byteArrayKey(str);
                byte[] byteArray = value.getBytes().toByteArray();
                k.d(byteArray, "value.bytes.toByteArray()");
                mutablePreferences.set(keyByteArrayKey, byteArray);
                return;
            case 9:
                throw new CorruptionException("Value not set.", th, i2, b10 == true ? 1 : 0);
        }
    }

    private final PreferencesProto.Value getValueProto(Object obj) {
        if (obj instanceof Boolean) {
            PreferencesProto.Value valueBuild = PreferencesProto.Value.newBuilder().setBoolean(((Boolean) obj).booleanValue()).build();
            k.d(valueBuild, "newBuilder().setBoolean(value).build()");
            return valueBuild;
        }
        if (obj instanceof Float) {
            PreferencesProto.Value valueBuild2 = PreferencesProto.Value.newBuilder().setFloat(((Number) obj).floatValue()).build();
            k.d(valueBuild2, "newBuilder().setFloat(value).build()");
            return valueBuild2;
        }
        if (obj instanceof Double) {
            PreferencesProto.Value valueBuild3 = PreferencesProto.Value.newBuilder().setDouble(((Number) obj).doubleValue()).build();
            k.d(valueBuild3, "newBuilder().setDouble(value).build()");
            return valueBuild3;
        }
        if (obj instanceof Integer) {
            PreferencesProto.Value valueBuild4 = PreferencesProto.Value.newBuilder().setInteger(((Number) obj).intValue()).build();
            k.d(valueBuild4, "newBuilder().setInteger(value).build()");
            return valueBuild4;
        }
        if (obj instanceof Long) {
            PreferencesProto.Value valueBuild5 = PreferencesProto.Value.newBuilder().setLong(((Number) obj).longValue()).build();
            k.d(valueBuild5, "newBuilder().setLong(value).build()");
            return valueBuild5;
        }
        if (obj instanceof String) {
            PreferencesProto.Value valueBuild6 = PreferencesProto.Value.newBuilder().setString((String) obj).build();
            k.d(valueBuild6, "newBuilder().setString(value).build()");
            return valueBuild6;
        }
        if (obj instanceof Set) {
            PreferencesProto.Value valueBuild7 = PreferencesProto.Value.newBuilder().setStringSet(PreferencesProto.StringSet.newBuilder().addAllStrings((Set) obj)).build();
            k.d(valueBuild7, "newBuilder()\n           …                 .build()");
            return valueBuild7;
        }
        if (!(obj instanceof byte[])) {
            throw new IllegalStateException("PreferencesSerializer does not support type: ".concat(obj.getClass().getName()));
        }
        PreferencesProto.Value valueBuild8 = PreferencesProto.Value.newBuilder().setBytes(ByteString.copyFrom((byte[]) obj)).build();
        k.d(valueBuild8, "newBuilder().setBytes(By….copyFrom(value)).build()");
        return valueBuild8;
    }

    @Override // androidx.datastore.core.okio.OkioSerializer
    public Object readFrom(l7.l lVar, c<? super Preferences> cVar) throws IOException {
        PreferencesProto.PreferenceMap from = PreferencesMapCompat.Companion.readFrom(lVar.V());
        MutablePreferences mutablePreferencesCreateMutable = PreferencesFactory.createMutable(new Preferences.Pair[0]);
        Map<String, PreferencesProto.Value> preferencesMap = from.getPreferencesMap();
        k.d(preferencesMap, "preferencesProto.preferencesMap");
        for (Map.Entry<String, PreferencesProto.Value> entry : preferencesMap.entrySet()) {
            String name = entry.getKey();
            PreferencesProto.Value value = entry.getValue();
            PreferencesSerializer preferencesSerializer = INSTANCE;
            k.d(name, "name");
            k.d(value, "value");
            preferencesSerializer.addProtoEntryToPreferences(name, value, mutablePreferencesCreateMutable);
        }
        return mutablePreferencesCreateMutable.toPreferences();
    }

    @Override // androidx.datastore.core.okio.OkioSerializer
    public /* bridge */ /* synthetic */ Object writeTo(Preferences preferences, l7.k kVar, c cVar) {
        return writeTo2(preferences, kVar, (c<? super x>) cVar);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.datastore.core.okio.OkioSerializer
    public Preferences getDefaultValue() {
        return PreferencesFactory.createEmpty();
    }

    /* JADX INFO: renamed from: writeTo, reason: avoid collision after fix types in other method */
    public Object writeTo2(Preferences preferences, l7.k kVar, c<? super x> cVar) throws IOException {
        Map<Preferences.Key<?>, Object> mapAsMap = preferences.asMap();
        PreferencesProto.PreferenceMap.Builder builderNewBuilder = PreferencesProto.PreferenceMap.newBuilder();
        for (Map.Entry<Preferences.Key<?>, Object> entry : mapAsMap.entrySet()) {
            builderNewBuilder.putPreferences(entry.getKey().getName(), getValueProto(entry.getValue()));
        }
        builderNewBuilder.build().writeTo(kVar.T());
        return x.f13520a;
    }
}
