package l4;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class j implements InvocationHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f12802a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f12803b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f12804c;

    public j(ArrayList arrayList) {
        this.f12802a = arrayList;
    }

    @Override // java.lang.reflect.InvocationHandler
    public final Object invoke(Object obj, Method method, Object[] objArr) {
        String name = method.getName();
        Class<?> returnType = method.getReturnType();
        if (objArr == null) {
            objArr = n.f12819a;
        }
        if (name.equals("supports") && Boolean.TYPE == returnType) {
            return Boolean.TRUE;
        }
        if (name.equals("unsupported") && Void.TYPE == returnType) {
            this.f12803b = true;
            return null;
        }
        boolean zEquals = name.equals("protocols");
        ArrayList arrayList = this.f12802a;
        if (zEquals && objArr.length == 0) {
            return arrayList;
        }
        if ((name.equals("selectProtocol") || name.equals("select")) && String.class == returnType && objArr.length == 1) {
            Object obj2 = objArr[0];
            if (obj2 instanceof List) {
                List list = (List) obj2;
                int size = list.size();
                for (int i2 = 0; i2 < size; i2++) {
                    if (arrayList.contains(list.get(i2))) {
                        String str = (String) list.get(i2);
                        this.f12804c = str;
                        return str;
                    }
                }
                String str2 = (String) arrayList.get(0);
                this.f12804c = str2;
                return str2;
            }
        }
        if ((!name.equals("protocolSelected") && !name.equals("selected")) || objArr.length != 1) {
            return method.invoke(this, objArr);
        }
        this.f12804c = (String) objArr[0];
        return null;
    }
}
