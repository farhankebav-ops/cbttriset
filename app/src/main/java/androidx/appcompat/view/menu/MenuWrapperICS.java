package androidx.appcompat.view.menu;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import androidx.annotation.RestrictTo;
import androidx.core.internal.view.SupportMenu;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class MenuWrapperICS extends BaseMenuWrapper implements Menu {
    private final SupportMenu mWrappedObject;

    public MenuWrapperICS(Context context, SupportMenu supportMenu) {
        super(context);
        if (supportMenu == null) {
            throw new IllegalArgumentException("Wrapped Object can not be null.");
        }
        this.mWrappedObject = supportMenu;
    }

    @Override // android.view.Menu
    public MenuItem add(CharSequence charSequence) {
        return getMenuItemWrapper(this.mWrappedObject.add(charSequence));
    }

    @Override // android.view.Menu
    public int addIntentOptions(int i2, int i8, int i9, ComponentName componentName, Intent[] intentArr, Intent intent, int i10, MenuItem[] menuItemArr) {
        MenuItem[] menuItemArr2 = menuItemArr != null ? new MenuItem[menuItemArr.length] : null;
        int iAddIntentOptions = this.mWrappedObject.addIntentOptions(i2, i8, i9, componentName, intentArr, intent, i10, menuItemArr2);
        if (menuItemArr2 != null) {
            int length = menuItemArr2.length;
            for (int i11 = 0; i11 < length; i11++) {
                menuItemArr[i11] = getMenuItemWrapper(menuItemArr2[i11]);
            }
        }
        return iAddIntentOptions;
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(CharSequence charSequence) {
        return getSubMenuWrapper(this.mWrappedObject.addSubMenu(charSequence));
    }

    @Override // android.view.Menu
    public void clear() {
        internalClear();
        this.mWrappedObject.clear();
    }

    @Override // android.view.Menu
    public void close() {
        this.mWrappedObject.close();
    }

    @Override // android.view.Menu
    public MenuItem findItem(int i2) {
        return getMenuItemWrapper(this.mWrappedObject.findItem(i2));
    }

    @Override // android.view.Menu
    public MenuItem getItem(int i2) {
        return getMenuItemWrapper(this.mWrappedObject.getItem(i2));
    }

    @Override // android.view.Menu
    public boolean hasVisibleItems() {
        return this.mWrappedObject.hasVisibleItems();
    }

    @Override // android.view.Menu
    public boolean isShortcutKey(int i2, KeyEvent keyEvent) {
        return this.mWrappedObject.isShortcutKey(i2, keyEvent);
    }

    @Override // android.view.Menu
    public boolean performIdentifierAction(int i2, int i8) {
        return this.mWrappedObject.performIdentifierAction(i2, i8);
    }

    @Override // android.view.Menu
    public boolean performShortcut(int i2, KeyEvent keyEvent, int i8) {
        return this.mWrappedObject.performShortcut(i2, keyEvent, i8);
    }

    @Override // android.view.Menu
    public void removeGroup(int i2) {
        internalRemoveGroup(i2);
        this.mWrappedObject.removeGroup(i2);
    }

    @Override // android.view.Menu
    public void removeItem(int i2) {
        internalRemoveItem(i2);
        this.mWrappedObject.removeItem(i2);
    }

    @Override // android.view.Menu
    public void setGroupCheckable(int i2, boolean z2, boolean z7) {
        this.mWrappedObject.setGroupCheckable(i2, z2, z7);
    }

    @Override // android.view.Menu
    public void setGroupEnabled(int i2, boolean z2) {
        this.mWrappedObject.setGroupEnabled(i2, z2);
    }

    @Override // android.view.Menu
    public void setGroupVisible(int i2, boolean z2) {
        this.mWrappedObject.setGroupVisible(i2, z2);
    }

    @Override // android.view.Menu
    public void setQwertyMode(boolean z2) {
        this.mWrappedObject.setQwertyMode(z2);
    }

    @Override // android.view.Menu
    public int size() {
        return this.mWrappedObject.size();
    }

    @Override // android.view.Menu
    public MenuItem add(int i2) {
        return getMenuItemWrapper(this.mWrappedObject.add(i2));
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i2) {
        return getSubMenuWrapper(this.mWrappedObject.addSubMenu(i2));
    }

    @Override // android.view.Menu
    public MenuItem add(int i2, int i8, int i9, CharSequence charSequence) {
        return getMenuItemWrapper(this.mWrappedObject.add(i2, i8, i9, charSequence));
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i2, int i8, int i9, CharSequence charSequence) {
        return getSubMenuWrapper(this.mWrappedObject.addSubMenu(i2, i8, i9, charSequence));
    }

    @Override // android.view.Menu
    public MenuItem add(int i2, int i8, int i9, int i10) {
        return getMenuItemWrapper(this.mWrappedObject.add(i2, i8, i9, i10));
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i2, int i8, int i9, int i10) {
        return getSubMenuWrapper(this.mWrappedObject.addSubMenu(i2, i8, i9, i10));
    }
}
