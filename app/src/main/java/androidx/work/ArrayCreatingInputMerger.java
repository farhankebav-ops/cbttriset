package androidx.work;

import androidx.work.Data;
import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class ArrayCreatingInputMerger extends InputMerger {
    private final Object concatenateArrayAndNonArray(Object obj, Object obj2, Class<?> cls) {
        int length = Array.getLength(obj);
        Object newArray = Array.newInstance(cls, length + 1);
        System.arraycopy(obj, 0, newArray, 0, length);
        Array.set(newArray, length, obj2);
        k.d(newArray, "newArray");
        return newArray;
    }

    private final Object concatenateArrays(Object obj, Object obj2) {
        int length = Array.getLength(obj);
        int length2 = Array.getLength(obj2);
        Class<?> componentType = obj.getClass().getComponentType();
        k.b(componentType);
        Object newArray = Array.newInstance(componentType, length + length2);
        System.arraycopy(obj, 0, newArray, 0, length);
        System.arraycopy(obj2, 0, newArray, length, length2);
        k.d(newArray, "newArray");
        return newArray;
    }

    private final Object createArrayFor(Object obj, Class<?> cls) {
        Object newArray = Array.newInstance(cls, 1);
        Array.set(newArray, 0, obj);
        k.d(newArray, "newArray");
        return newArray;
    }

    @Override // androidx.work.InputMerger
    public Data merge(List<Data> inputs) throws Throwable {
        k.e(inputs, "inputs");
        Data.Builder builder = new Data.Builder();
        HashMap map = new HashMap();
        Iterator<Data> it = inputs.iterator();
        while (it.hasNext()) {
            Map<String, Object> keyValueMap = it.next().getKeyValueMap();
            k.d(keyValueMap, "input.keyValueMap");
            for (Map.Entry<String, Object> entry : keyValueMap.entrySet()) {
                String key = entry.getKey();
                Object value = entry.getValue();
                Class cls = value != null ? value.getClass() : String.class;
                Object obj = map.get(key);
                k.d(key, "key");
                if (obj != null) {
                    Class<?> cls2 = obj.getClass();
                    if (cls2.equals(cls)) {
                        k.d(value, "value");
                        value = concatenateArrays(obj, value);
                    } else {
                        if (!k.a(cls2.getComponentType(), cls)) {
                            throw new IllegalArgumentException();
                        }
                        value = concatenateArrayAndNonArray(obj, value, cls);
                    }
                } else if (!cls.isArray()) {
                    value = createArrayFor(value, cls);
                }
                k.d(value, "if (existingValue == nul…      }\n                }");
                map.put(key, value);
            }
        }
        builder.putAll(map);
        Data dataBuild = builder.build();
        k.d(dataBuild, "output.build()");
        return dataBuild;
    }
}
